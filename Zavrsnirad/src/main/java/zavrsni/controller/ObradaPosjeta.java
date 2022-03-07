/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.controller;

import java.util.List;
import zavrsni.model.Posjeta;
import zavrsni.util.ZavrsniException;

/**
 *
 * @author Igor
 */
public class ObradaPosjeta extends Obrada<Posjeta> {

    @Override
    public List<Posjeta> read() {
        return session.createQuery("from Posjeta").list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniException {
        kontrolaKorisnik();
        kontrolaBrojSoba();
        kontrolaBrojOdraslih();
        kontrolaBrojDjece();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniException {
        kontrolaKorisnik();
        kontrolaBrojSoba();
        kontrolaBrojOdraslih();
        kontrolaBrojDjece();
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniException {
    }

    private void kontrolaKorisnik() throws ZavrsniException {
    }

    private void kontrolaBrojSoba() throws ZavrsniException {
        if(entitet.getBrojSoba() == null){
            throw new ZavrsniException("Broj soba mora biti unesen");
        }
        if(entitet.getBrojSoba() > 10 || entitet.getBrojSoba() < 1){
            throw new ZavrsniException("Broj soba može biti između 1 i 10");
        }
    }

    private void kontrolaBrojOdraslih() throws ZavrsniException {
         if(entitet.getBrojOdraslih() == null){
            throw new ZavrsniException("Broj odraslih mora biti unesen");
        }
        if(entitet.getBrojOdraslih() > 20 || entitet.getBrojOdraslih()< 1){
            throw new ZavrsniException("Broj odraslih može biti između 1 i 20");
        }
    }

    private void kontrolaBrojDjece() throws ZavrsniException {
         if(entitet.getBrojDjece() == null){
            throw new ZavrsniException("Broj djece mora biti unesen");
        }
        if(entitet.getBrojDjece() > 20 || entitet.getBrojSoba() < 0){
            throw new ZavrsniException("Broj djece može biti između 0 i 20");
        }
    }

}
