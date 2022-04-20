/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.controller;

import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;
import recepcija.model.Posjeta;
import recepcija.util.ZavrsniException;

/**
 *
 * @author Igor
 */
public class ObradaPosjeta extends Obrada<Posjeta> {

    @Override
    public List<Posjeta> read() {
        return session.createQuery("from Posjeta").list();
    }

    public List<Posjeta> read(String uvjet) {
        return session.createQuery("from Posjeta p "
                + " where concat(p.datumPrijave,' ',p.datumOdjave) "
                + " like :uvjet order by p.datumPrijave, p.datumOdjave").setParameter("uvjet", "%" + uvjet + "%").list();
    }

    public List<Posjeta> readPrijava(Date uvjet) {
        return session.createQuery("from Posjeta p "
                + " where p.datumPrijave "
                + " = :uvjet").setParameter("uvjet", uvjet, TemporalType.DATE).list();
    }

    public List<Posjeta> readOdjava(Date uvjet) {
        return session.createQuery("from Posjeta p "
                + " where p.datumOdjave "
                + " = :uvjet").setParameter("uvjet", uvjet, TemporalType.DATE).list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniException {
        kontrolaKorisnik();
        kontrolaBrojSoba();
        kontrolaDatumPrijave();
        kontrolaDatumOdjave();
        kontrolaBrojOdraslih();
        kontrolaBrojDjece();
        kontrolaUsluga();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniException {
        kontrolaKorisnik();
        kontrolaBrojSoba();
        kontrolaDatumPrijave();
        kontrolaDatumOdjave();
        kontrolaBrojOdraslih();
        kontrolaBrojDjece();
        kontrolaUsluga();
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniException {
    }

    private void kontrolaKorisnik() throws ZavrsniException {
        if (entitet.getKorisnik() == null || entitet.getKorisnik().getSifra() == 0) {
            throw new ZavrsniException("Korisnik mora biti postavljen na posjeti");
        }
    }

    private void kontrolaBrojSoba() throws ZavrsniException {
        if (entitet.getBrojSoba() == null) {
            throw new ZavrsniException("Broj soba mora biti unesen");
        }
        if (entitet.getBrojSoba() > 10 || entitet.getBrojSoba() < 1) {
            throw new ZavrsniException("Broj soba može biti između 1 i 10");
        }
    }

    private void kontrolaBrojOdraslih() throws ZavrsniException {
        if (entitet.getBrojOdraslih() == null) {
            throw new ZavrsniException("Broj odraslih mora biti unesen");
        }
        if (entitet.getBrojOdraslih() > 20 || entitet.getBrojOdraslih() < 1) {
            throw new ZavrsniException("Broj odraslih može biti između 1 i 20");
        }
    }

    private void kontrolaBrojDjece() throws ZavrsniException {
        if (entitet.getBrojDjece() != null) {
            if (entitet.getBrojDjece() > 20 || entitet.getBrojDjece() < 0) {
                throw new ZavrsniException("Broj djece može biti između 0 i 20");
            }
        }
    }

    private void kontrolaUsluga() throws ZavrsniException {
        if (entitet.getUsluge() == null || entitet.getUsluge().isEmpty()) {
            throw new ZavrsniException("Posjeta mora sadržati usluge");
        }
    }

    private void kontrolaDatumPrijave() throws ZavrsniException {
        if (entitet.getDatumPrijave() == null) {
            throw new ZavrsniException("Datum prijave mora biti izabran");
        }
    }

    /*private void kontrolaNoviDatumPrijave() throws ZavrsniException {
        if (entitet.getDatumPrijave() == null) {
            throw new ZavrsniException("Datum prijave mora biti izabran");
        }
        int broj = 0;
        int provjera;
        List<Posjeta> posjete = session.createQuery("from Posjeta").list();
        for (Posjeta p : posjete) {
            provjera = p.getDatumPrijave().compareTo(entitet.getDatumPrijave());
            if (provjera != 0) {
                continue;
            }
            broj++;
        }
        if (broj >= 20) {
            throw new ZavrsniException("Nije moguće napraviti rezervaciju za odabrani dan");
        }
    }*/
    private void kontrolaDatumOdjave() throws ZavrsniException {
        if (entitet.getDatumOdjave() == null) {
            throw new ZavrsniException("Datum odjave mora biti izabran");
        }
    }
}
