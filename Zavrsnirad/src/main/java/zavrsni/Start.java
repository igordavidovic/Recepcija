/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.math.BigDecimal;
import org.hibernate.Session;
import zavrsni.model.Djelatnik;
import zavrsni.util.HibernateUtil;
import zavrsni.view.SplashScreen;

/**
 *
 * @author Igor
 */
public class Start {

    private Session s;
    private Argon2 argon2;

    public Start() {
        //s = HibernateUtil.getSession();
        //dodavanjeDjelatnika();
        new SplashScreen().setVisible(true);
    }

    private void dodavanjeDjelatnika() {
        s.beginTransaction();
        Djelatnik d = new Djelatnik();
        argon2 = Argon2Factory.create();
        d.setIme("Igor");
        d.setPrezime("Davidović");
        d.setEmail("idavidovic@gmail.com");
        d.setPlaca(new BigDecimal(5500));
        d.setUloga("Recepcionar");
        d.setLozinka(argon2.hash(10, 65536, 1, "id".toCharArray()));
        s.save(d);
        s.getTransaction().commit();
    }

    public static void main(String[] args) {
        new Start();
    }
}
