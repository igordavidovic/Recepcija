/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.controller;

import java.util.List;
import org.apache.commons.validator.routines.EmailValidator;
import zavrsni.model.Korisnik;
import zavrsni.util.OibProvjera;
import zavrsni.util.ZavrsniException;
import zavrsni.util.ZavrsniUtil;

/**
 *
 * @author Igor
 */
public class ObradaKorisnik extends Obrada<Korisnik> {

    @Override
    public List<Korisnik> read() {
        return session.createQuery("from Korisnik").list();
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
