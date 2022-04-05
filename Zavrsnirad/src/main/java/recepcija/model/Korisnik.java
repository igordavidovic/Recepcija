/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Igor
 */
@Entity
public class Korisnik extends Entitet{
    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String ime;
    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String prezime;
    @Column(columnDefinition = "varchar(50)",nullable = true)
    private String email;
    @Column(columnDefinition = "varchar(50)",nullable = true)
    private String oib;
    @Column(name = "datumrodenja",nullable = true)
    private Date datumRodenja;
    @OneToMany(mappedBy = "korisnik")
    private List<Posjeta> posjete;

    public List<Posjeta> getPosjete() {
        return posjete;
    }

    public void setPosjete(List<Posjeta> posjete) {
        this.posjete = posjete;
    }
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public Date getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(Date datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(ime).append(" ").append(prezime).toString();
    }
    
}
