/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.controller;

import java.math.BigDecimal;
import java.util.List;
import recepcija.model.Usluga;
import recepcija.util.ZavrsniException;

/**
 *
 * @author Igor
 */
public class ObradaUsluga extends Obrada<Usluga> {

    @Override
    public List<Usluga> read() {
        return session.createQuery("from Usluga").list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniException {
        kontrolaNaziv();
        kontrolaCijena();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniException {
        kontrolaNaziv();
        kontrolaCijena();
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniException {
     if(entitet.getPosjete() != null && entitet.getPosjete().size() > 0){
         throw new ZavrsniException("Usluga se ne može brisati jer se nalazi na jednoj ili više posjeta!");
     }   
    }


    private void kontrolaNaziv() throws ZavrsniException {
        if(entitet.getNaziv() == null || entitet.getNaziv().trim().length() > 50){
            throw new ZavrsniException("Naziv mora biti upisan i kraći od 50 znakova");
        }
    }

    private void kontrolaCijena() throws ZavrsniException {
        if(entitet.getCijena().compareTo(BigDecimal.ZERO) < 0 || entitet.getCijena().compareTo(new BigDecimal(20000)) > 0){
            throw new ZavrsniException("Cijena mora biti između 0 i 20000");
        }
    }

}
