/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.controller;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import javax.persistence.NoResultException;
import org.apache.commons.validator.routines.EmailValidator;
import zavrsni.model.Djelatnik;
import zavrsni.util.ZavrsniException;
import zavrsni.util.ZavrsniUtil;

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
        kontrolaEmail();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaUloga();
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

    private void kontrolaUloga() throws ZavrsniException {
        boolean b = ZavrsniUtil.provjeraUloge(entitet.getUloga());
        if (b == false) {
            throw new ZavrsniException("Uloga nije formalno ispravna");
        }
    }

    private void kontrolaEmail() throws ZavrsniException {
        boolean b = EmailValidator.getInstance().isValid(entitet.getEmail());
        if (b == false) {
            throw new ZavrsniException("Email nije formalno ispravan");
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
}
