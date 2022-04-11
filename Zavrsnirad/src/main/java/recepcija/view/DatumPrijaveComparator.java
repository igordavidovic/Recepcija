/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.view;

import java.util.Comparator;
import recepcija.model.Posjeta;

/**
 *
 * @author Igor
 */
public class DatumPrijaveComparator implements Comparator<Posjeta> {

    @Override
    public int compare(Posjeta o1, Posjeta o2) {
        return o2.getDatumPrijave().compareTo(o1.getDatumPrijave());
    }

}
