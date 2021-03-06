/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Igor
 */
@Entity
public class Usluga extends Entitet{
    @Column(columnDefinition = "varchar(100)",nullable = false)
    private String naziv;
    @Column(columnDefinition = "decimal(18,2)",nullable = true)
    private BigDecimal cijena;
    @ManyToMany(mappedBy = "usluge")
    private List<Posjeta> posjete;

    public List<Posjeta> getPosjete() {
        return posjete;
    }

    public void setPosjete(List<Posjeta> posjete) {
        this.posjete = posjete;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
