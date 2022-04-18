/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.controller;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.NoResultException;
import org.apache.commons.validator.routines.EmailValidator;
import recepcija.model.Djelatnik;
import recepcija.model.Usluga;
import recepcija.util.ZavrsniException;
import recepcija.util.ZavrsniUtil;

/**
 *
 * @author Igor
 */
public class ObradaDjelatnik extends Obrada<Djelatnik> {

    @Override
    public List<Djelatnik> read() {
        return session.createQuery("from Djelatnik").list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaUloga();
        kontrolaNoviEmail();
        kontrolaPlaca();
        kontrolaLozinka();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaUloga();
        kontrolaPromjenaEmail();
        kontrolaPlaca();
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniException {

    }

    private void kontrolaIme() throws ZavrsniException {
        if (entitet.getIme() == null || entitet.getIme().trim().isEmpty()) {
            throw new ZavrsniException("Ime mora biti uneseno");
        }
        if (entitet.getIme().length() > 100) {
            throw new ZavrsniException("Ime ne smije sadržavati više od 100 znakova");
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
        if (entitet.getPrezime().length() > 100) {
            throw new ZavrsniException("Prezime ne smije sadržavati više od 100 znakova");
        }
        boolean b = ZavrsniUtil.provjeraZnakova(entitet.getPrezime());
        if (b == false) {
            throw new ZavrsniException("Prezime ne smije sadržavati brojeve ili posebne znakove(#,$,%,& etc.)");
        }

    }

    private void kontrolaUloga() throws ZavrsniException {
        boolean b = ZavrsniUtil.provjeraUloge(entitet.getUloga());
        if (b == false) {
            throw new ZavrsniException("Uloga nije formalno ispravna");
        }
    }

    private void kontrolaEmail() throws ZavrsniException {
        if (entitet.getEmail().length() > 100) {
            throw new ZavrsniException("Email ne smije biti duži od 100 znakova");
        }
        boolean b = EmailValidator.getInstance().isValid(entitet.getEmail());
        if (b == false) {
            throw new ZavrsniException("Email nije formalno ispravan");
        }
    }

    private void kontrolaNoviEmail() throws ZavrsniException {
        kontrolaEmail();
        List<Djelatnik> lista = session.createQuery("from Djelatnik e "
                + "where e.email=:email")
                .setParameter("email", entitet.getEmail()).list();

        if (lista != null && lista.size() > 0) {
            throw new ZavrsniException("Email postoji u sustavu, dodijeljen " + lista.get(0).getPrezime());
        }
    }

    private void kontrolaPromjenaEmail() throws ZavrsniException {
        kontrolaEmail();
        List<Djelatnik> lista = session.createQuery("from Djelatnik e "
                + "where e.email=:email and e.sifra!=:id")
                .setParameter("email", entitet.getEmail())
                .setParameter("id", entitet.getSifra()).list();

        if (lista != null && lista.size() > 0) {
            throw new ZavrsniException("Email postoji u sustavu, dodijeljen " + lista.get(0).getPrezime());
        }
    }

    private void kontrolaLozinka() throws ZavrsniException {
        if (entitet.getLozinka() == null) {
            throw new ZavrsniException("Lozinka mora biti upisana");
        }
        if (entitet.getLozinka().length() > 100) {
            throw new ZavrsniException("Lozinka ne smije biti duža od 25 znakova");
        }
    }

    public Djelatnik autoriziraj(String email, String lozinka) {
        Djelatnik djelatnik = null;
        try {
            djelatnik = (Djelatnik) session.createQuery("from Djelatnik where email=:email").setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        if (djelatnik == null) {
            return null;
        }

        Argon2 argon2 = Argon2Factory.create();

        return argon2.verify(djelatnik.getLozinka(), lozinka.toCharArray()) ? djelatnik : null;
    }

    private void kontrolaPlaca() throws ZavrsniException {
        if (entitet.getPlaca().equals(BigDecimal.ZERO)) {
            throw new ZavrsniException("Plaća nije ispravno unesena");
        }
    }
}
