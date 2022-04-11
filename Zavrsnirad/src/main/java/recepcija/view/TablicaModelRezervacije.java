/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recepcija.view;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import recepcija.model.Posjeta;

/**
 *
 * @author CP
 */
public class TablicaModelRezervacije extends AbstractTableModel {

    private List<Posjeta> posjete;
    private String[] opis = {"Šifra", "Korisnik", "Odjava", "Osobe", "Sobe"};

    public TablicaModelRezervacije(List<Posjeta> posjete) {
        this.posjete = posjete;
    }

    @Override
    public String getColumnName(int index) {
        return opis[index];
    }

    @Override
    public int getRowCount() {
        return posjete == null ? 0 : posjete.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Posjeta p = posjete.get(rowIndex);
        Object value = "??";
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                value = p.getSifra();
                break;
            case 1:
                value = p.getKorisnik().getIme() + " " + p.getKorisnik().getPrezime();
                break;
            case 2:
                value = sdf.format(p.getDatumOdjave());
                break;
            case 3:
                value = p.getBrojOdraslih() + p.getBrojDjece();
                break;
            case 4:
                value = p.getBrojSoba();
                break;
        }
        return value;
    }

    public Posjeta getPolaznikAt(int red) {
        return posjete.get(red);
    }

}
