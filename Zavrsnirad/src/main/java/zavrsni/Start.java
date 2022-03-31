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
        new SplashScreen().setVisible(true);
    }

    public static void main(String[] args) {
        new Start();
    }
}
