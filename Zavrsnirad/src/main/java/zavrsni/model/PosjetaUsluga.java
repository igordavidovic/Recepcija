/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Igor
 */
@Entity
@Table(name = "posjeta_usluga")
public class PosjetaUsluga {
    @Id
    private Integer sifra;
    @ManyToOne
    @JoinColumn(name = "usluga",referencedColumnName = "sifra")
    private Usluga usluga;
    @ManyToOne
    @JoinColumn(name = "posjeta",referencedColumnName = "sifra")
    private Posjeta posjeta;

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Posjeta getPosjeta() {
        return posjeta;
    }

    public void setPosjeta(Posjeta posjeta) {
        this.posjeta = posjeta;
    }

}
