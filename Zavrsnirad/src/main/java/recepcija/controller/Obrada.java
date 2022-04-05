/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.controller;

import java.util.List;
import org.hibernate.Session;
import recepcija.util.HibernateUtil;
import recepcija.util.ZavrsniException;

/**
 *
 * @author Igor
 */
public abstract class Obrada<T> {

    protected Session session;
    protected T entitet;

    public abstract List<T> read();

    protected abstract void kontrolaCreate() throws ZavrsniException;

    protected abstract void kontrolaUpdate() throws ZavrsniException;

    protected abstract void kontrolaDelete() throws ZavrsniException;

    public Obrada() {
        session = HibernateUtil.getSession();
    }
    public T create() throws ZavrsniException{
        kontrolaCreate();
        save();
        return entitet;
    }
    
    public T update() throws ZavrsniException{
        kontrolaUpdate();
        save();
        return entitet;
    }
    
    public void delete() throws ZavrsniException{
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
    }
    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }

    private void save() {
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
    }

}
