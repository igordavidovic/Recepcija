/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Igor
 */
@Entity
public class Posjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sifra;
    @ManyToOne
    @JoinColumn(name = "korisnik",referencedColumnName = "sifra")
    private Korisnik korisnik;
    @Column(name = "datumprijave")
    private Date datumPrijave;
    @Column(name = "datumodjave")
    private Date datumOdjave;
    @Column(name = "brojsoba")
    private int brojSoba;
    @Column(name = "brojodraslih")
    private int brojOdraslih;
    @Column(name = "brojdjece")
    private int brojDjece;
    
    
    public Integer getSifra() {
        return sifra;
    }

    public void setSifra(Integer sifra) {
        this.sifra = sifra;
    }
    
    
    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public Date getDatumOdjave() {
        return datumOdjave;
    }

    public void setDatumOdjave(Date datumOdjave) {
        this.datumOdjave = datumOdjave;
    }

    public Integer getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(Integer brojSoba) {
        this.brojSoba = brojSoba;
    }

    public Integer getBrojOdraslih() {
        return brojOdraslih;
    }

    public void setBrojOdraslih(Integer brojOdraslih) {
        this.brojOdraslih = brojOdraslih;
    }

    public Integer getBrojDjece() {
        return brojDjece;
    }

    public void setBrojDjece(Integer brojDjece) {
        this.brojDjece = brojDjece;
    }
    
}
