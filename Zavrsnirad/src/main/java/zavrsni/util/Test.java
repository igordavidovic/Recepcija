/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.util;

/**
 *
 * @author Igor
 */
public class Test {

    public static void testOib() {
        String s = "48484843920";
        boolean b = OibProvjera.provjera(s);
        System.out.println(b);
    }

    public static void main(String[] args) {
        testOib();
    }
}
