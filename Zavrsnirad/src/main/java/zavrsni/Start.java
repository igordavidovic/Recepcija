/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni;

import org.hibernate.Session;
import zavrsni.view.SplashScreen;

/**
 *
 * @author Igor
 */
public class Start {

    private Session s;

    public Start() {
        new SplashScreen().setVisible(true);
    }

    public static void main(String[] args) {
        new Start();
    }
}
