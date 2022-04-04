/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.view;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.apache.commons.validator.GenericValidator;
import zavrsni.model.Posjeta;

/**
 *
 * @author Igor
 */
public class PrikazPosjeta extends JLabel implements ListCellRenderer<Posjeta> {

    private SimpleDateFormat stariFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private SimpleDateFormat noviFormat = new SimpleDateFormat("dd.MM.yyyy");

    private SimpleDateFormat defaultFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

    private DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

    private Date datumPrijave;

    private Date datumOdjave;

    @Override
    public Component getListCellRendererComponent(JList<? extends Posjeta> list, Posjeta value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
        String a, b;
        try {
            //if (GenericValidator.isDate(value.getDatumPrijave().toString(), "EEE MMM dd HH:mm:ss zzz yyyy", true) && GenericValidator.isDate(value.getDatumOdjave().toString(), "EEE MMM dd HH:mm:ss zzz yyyy", true)) {
            datumPrijave = defaultFormat.parse(value.getDatumPrijave().toString());
            datumOdjave = defaultFormat.parse(value.getDatumOdjave().toString());
            // } else {
        } catch (ParseException ex) {
            try {
                datumPrijave = stariFormat.parse(value.getDatumPrijave().toString());
                datumOdjave = stariFormat.parse(value.getDatumOdjave().toString());
            } catch (ParseException ex1) {
               // System.out.println(ex.getMessage());

            }
            //System.out.println(ex.getMessage());

        }

        // }
        a = noviFormat.format(datumPrijave);
        b = noviFormat.format(datumOdjave);
        renderer.setText(a + " - " + b);

        return renderer;
    }

}
