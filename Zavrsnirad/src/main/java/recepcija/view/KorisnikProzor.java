/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package recepcija.view;

import com.github.lgooddatepicker.components.DatePickerSettings;

import java.awt.event.KeyEvent;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import recepcija.controller.ObradaKorisnik;
import recepcija.model.Korisnik;
import recepcija.util.ZavrsniException;
import recepcija.util.ZavrsniUtil;

/**
 *
 * @author Igor
 */
public class KorisnikProzor extends javax.swing.JFrame {

    /**
     * Creates new form KorisnikProzor
     */
    private ObradaKorisnik ok;

    public KorisnikProzor() {
        initComponents();
        ok = new ObradaKorisnik();
        setTitle(ZavrsniUtil.getNaslov("Korisnici"));
        ucitaj();
        datum();
    }

    private void datum() {
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dpDatumRodenja.setSettings(dps);
    }

    private void ucitaj() {
        DefaultListModel<Korisnik> m = new DefaultListModel<>();
        List<Korisnik> korisnici = ok.read();

        for (Korisnik k : korisnici) {
            m.addElement(k);
        }
        lstKorisnici.setModel(m);
    }

    private void ucitajTrazi() {
        if (txtTrazilica.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(getRootPane(), "U polju za traženje mora biti unosa!");
            return;
        }
        if (chbIme.isSelected() == false && chbPrezime.isSelected() == false && chbOib.isSelected() == false) {
            JOptionPane.showMessageDialog(getRootPane(), "Morate odabrati stavku!");
            return;
        }
        if ((chbIme.isSelected() && chbPrezime.isSelected() && chbOib.isSelected()) || (chbIme.isSelected() && chbOib.isSelected()) || (chbPrezime.isSelected() && chbOib.isSelected())) {
            JOptionPane.showMessageDialog(getRootPane(), "Nemoguća kombinacija!");
            return;
        }
        DefaultListModel<Korisnik> m = new DefaultListModel<>();
        List<Korisnik> korisnici;
        if (chbIme.isSelected() && chbPrezime.isSelected()) {
            korisnici = ok.read(txtTrazilica.getText());
        } else if (chbIme.isSelected()) {
            korisnici = ok.readIme(txtTrazilica.getText());
        } else if (chbPrezime.isSelected()) {
            korisnici = ok.readPrezime(txtTrazilica.getText());
        } else {
            korisnici = ok.readOib(txtTrazilica.getText());
        }
        for (Korisnik k : korisnici) {
            m.addElement(k);
        }
        lstKorisnici.setModel(m);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstKorisnici = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtOib = new javax.swing.JTextField();
        btnKreiraj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTrazilica = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        chbIme = new javax.swing.JCheckBox();
        chbPrezime = new javax.swing.JCheckBox();
        chbOib = new javax.swing.JCheckBox();
        dpDatumRodenja = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lstKorisnici.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstKorisniciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstKorisnici);

        jLabel1.setText("Ime");

        jLabel2.setText("Prezime");

        jLabel3.setText("Email");

        jLabel5.setText("Oib");

        btnKreiraj.setText("Kreiraj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel6.setText("Tražilica");

        txtTrazilica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTrazilicaKeyPressed(evt);
            }
        });

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        chbIme.setText("Po imenu");

        chbPrezime.setText("Po prezimenu");

        chbOib.setText("Po OIB-u");

        jLabel4.setText("Datum rođenja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtOib)
                        .addGap(103, 103, 103))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnKreiraj)
                                .addGap(18, 18, 18)
                                .addComponent(btnPromjeni)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisi))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpDatumRodenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtTrazilica))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chbIme, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbOib, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIme, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrazilica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chbIme)
                            .addComponent(chbOib)
                            .addComponent(chbPrezime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpDatumRodenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKreiraj)
                            .addComponent(btnPromjeni)
                            .addComponent(btnObrisi))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if (ok.getEntitet() == null || lstKorisnici.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }
        vrijednosti();

        try {
            ok.update();
            ucitaj();
        } catch (ZavrsniException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void lstKorisniciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstKorisniciValueChanged
        if (evt.getValueIsAdjusting() || lstKorisnici.getSelectedValue() == null) {
            return;
        }
        ok.setEntitet(lstKorisnici.getSelectedValue());
        var k = ok.getEntitet();
        txtIme.setText(k.getIme());
        txtPrezime.setText(k.getPrezime());
        txtEmail.setText(k.getEmail());
        txtOib.setText(k.getOib());
        if (k.getDatumRodenja() != null) {
            dpDatumRodenja.setDate(k.getDatumRodenja().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        } else {
            dpDatumRodenja.setDate(null);
        }
    }//GEN-LAST:event_lstKorisniciValueChanged

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        ok.setEntitet(new Korisnik());
        vrijednosti();
        try {
            ok.create();
        } catch (ZavrsniException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
        ucitaj();
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (ok.getEntitet() == null || lstKorisnici.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }

        if (JOptionPane.showConfirmDialog(getRootPane(),
                "Sigurno bristati \"" + ok.getEntitet().getIme() + " " + ok.getEntitet().getPrezime() + "\"?", "Brisanje",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            ok.delete();
            ucitaj();
        } catch (ZavrsniException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitajTrazi();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void txtTrazilicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrazilicaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitajTrazi();
        }
    }//GEN-LAST:event_txtTrazilicaKeyPressed

    private void vrijednosti() {
        var s = ok.getEntitet();
        s.setIme(txtIme.getText());
        s.setPrezime(txtPrezime.getText());
        s.setEmail(txtEmail.getText());
        s.setOib(txtOib.getText());
        s.setDatumRodenja(dpDatumRodenja.getDate() == null ? null : (Date.from(dpDatumRodenja.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant())));
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JCheckBox chbIme;
    private javax.swing.JCheckBox chbOib;
    private javax.swing.JCheckBox chbPrezime;
    private com.github.lgooddatepicker.components.DatePicker dpDatumRodenja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Korisnik> lstKorisnici;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOib;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTrazilica;
    // End of variables declaration//GEN-END:variables
}
