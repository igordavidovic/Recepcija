/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Igor
 */
@Entity
public class Posjeta extends Entitet{
    @ManyToOne
    @JoinColumn(name = "korisnik",referencedColumnName = "sifra",nullable = false)
    private Korisnik korisnik;
    @Column(name = "datumprijave")
    private Date datumPrijave;
    @Column(name = "datumodjave")
    private Date datumOdjave;
    @Column(name = "brojsoba",nullable = false)
    private int brojSoba;
    @Column(name = "brojodraslih",nullable = false)
    private int brojOdraslih;
    @Column(name = "brojdjece",nullable = false)
    private int brojDjece;
    @ManyToMany
    @JoinTable(name = "posjeta_usluga",
            joinColumns = {@JoinColumn(name = "posjeta")},
    inverseJoinColumns = {@JoinColumn(name = "usluga")})
    private List<Usluga> usluge;

    public int getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(int brojSoba) {
        this.brojSoba = brojSoba;
    }

    public int getBrojOdraslih() {
        return brojOdraslih;
    }

    public void setBrojOdraslih(int brojOdraslih) {
        this.brojOdraslih = brojOdraslih;
    }

    public int getBrojDjece() {
        return brojDjece;
    }

    public void setBrojDjece(int brojDjece) {
        this.brojDjece = brojDjece;
    }

    public List<Usluga> getUsluge() {
        return usluge;
    }

    public void setUsluge(List<Usluga> usluge) {
        this.usluge = usluge;
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


}
