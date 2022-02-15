/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Igor
 */
@Entity
public class Djelatnik extends Entitet{
    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String ime;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String prezime;
    @Column(columnDefinition = "varchar(50)",nullable = true)
    private String uloga;
    @Column(columnDefinition = "varchar(50)", nullable = true)
    private String email;
    @Column(columnDefinition = "decimal(18,2)", nullable = true)
    private BigDecimal placa;

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

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getPlaca() {
        return placa;
    }

    public void setPlaca(BigDecimal placa) {
        this.placa = placa;
    }
    
    
}
