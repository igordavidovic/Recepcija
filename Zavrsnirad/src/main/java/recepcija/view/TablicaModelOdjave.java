/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recepcija.view;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import recepcija.model.Posjeta;
import recepcija.model.Usluga;

/**
 *
 * @author CP
 */
public class TablicaModelOdjave extends AbstractTableModel {

    private List<Posjeta> posjete;
    private String[] opis = {"Šifra", "Korisnik", "Prijava", "Osobe", "Cijena"};

    public TablicaModelOdjave(List<Posjeta> posjete) {
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
        BigDecimal cijena = new BigDecimal(0);
        LocalDate prviDatum = p.getDatumPrijave().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate drugiDatum = p.getDatumOdjave().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long razlika = ChronoUnit.DAYS.between(prviDatum, drugiDatum);
        switch (columnIndex) {
            case 0:
                value = p.getSifra();
                break;
            case 1:
                value = p.getKorisnik().getIme() + " " + p.getKorisnik().getPrezime();
                break;
            case 2:
                value = sdf.format(p.getDatumPrijave());
                break;
            case 3:
                value = p.getBrojOdraslih() + p.getBrojDjece();
                break;
            case 4:
                for (Usluga u : p.getUsluge()) {
                    cijena = cijena.add(u.getCijena());
                }
                value = cijena.multiply(new BigDecimal(razlika));
                break;
        }
        return value;
    }

    public Posjeta getPolaznikAt(int red) {
        return posjete.get(red);
    }

}
