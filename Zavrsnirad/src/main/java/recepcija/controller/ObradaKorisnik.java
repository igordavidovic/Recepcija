/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.controller;

import java.util.Date;
import java.util.List;
import org.apache.commons.validator.routines.EmailValidator;
import recepcija.model.Korisnik;
import recepcija.model.Posjeta;
import recepcija.util.OibProvjera;
import recepcija.util.ZavrsniException;
import recepcija.util.ZavrsniUtil;

/**
 *
 * @author Igor
 */
public class ObradaKorisnik extends Obrada<Korisnik> {

    @Override
    public List<Korisnik> read() {
        return session.createQuery("from Korisnik").list();
    }

    public List<Korisnik> read(String uvjet) {
        return session.createQuery("from Korisnik k "
                + " where concat(k.ime,' ',k.prezime,' ',ifnull(k.oib,'')) "
                + " like :uvjet order by k.prezime, k.ime")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(100)
                .list();
    }

    public List<Korisnik> readIme(String uvjet) {
        return session.createQuery("from Korisnik k "
                + " where k.ime "
                + " like :uvjet order by k.ime")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(100)
                .list();
    }

    public List<Korisnik> readPrezime(String uvjet) {
        return session.createQuery("from Korisnik k "
                + " where k.prezime "
                + " like :uvjet order by k.prezime")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(100)
                .list();
    }

    public List<Korisnik> readOib(String uvjet) {
        return session.createQuery("from Korisnik k "
                + " where k.oib "
                + " like :uvjet order by k.oib")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(100)
                .list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
        kontrolaEmail();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
        kontrolaEmail();
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniException {
        if (entitet.getPosjete() != null && entitet.getPosjete().size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (Posjeta p : entitet.getPosjete()) {
                sb.append(p.getKorisnik().getIme());
                sb.append(" ");
                sb.append(p.getKorisnik().getPrezime());
                sb.append("\n");
            }

            throw new ZavrsniException("Ne možete brisati korisnika jer se on nalazi na posjeti");
        }
    }

    private void kontrolaIme() throws ZavrsniException {
        if (entitet.getIme() == null || entitet.getIme().trim().isEmpty()) {
            throw new ZavrsniException("Ime mora biti uneseno");
        }
        if (entitet.getIme().length() > 50) {
            throw new ZavrsniException("Ime ne smije sadržavati više od 50 znakova");
        }
        boolean b = ZavrsniUtil.provjeraZnakova(entitet.getIme());
        if (b == false) {
            throw new ZavrsniException("Ime ne smije sadržavati brojeve ili posebne znakove(#,$,%,& etc.)");
        }

    }

    private void kontrolaPrezime() throws ZavrsniException {
        if (entitet.getPrezime() == null || entitet.getPrezime().trim().isEmpty()) {
            throw new ZavrsniException("Prezime mora biti uneseno");
        }
        if (entitet.getPrezime().length() > 50) {
            throw new ZavrsniException("Prezime ne smije sadržavati više od 50 znakova");
        }
        boolean b = ZavrsniUtil.provjeraZnakova(entitet.getPrezime());
        if (b == false) {
            throw new ZavrsniException("Prezime ne smije sadržavati brojeve ili posebne znakove(#,$,%,& etc.)");
        }

    }

    private void kontrolaOib() throws ZavrsniException {
        boolean b = OibProvjera.provjera(entitet.getOib());
        if (b == false) {
            throw new ZavrsniException("OIB nije formalno ispravan");
        }

    }

    private void kontrolaEmail() throws ZavrsniException {
        boolean b = EmailValidator.getInstance().isValid(entitet.getEmail());
        if (b == false) {
            throw new ZavrsniException("Email nije formalno ispravan");
        }
    }
}
