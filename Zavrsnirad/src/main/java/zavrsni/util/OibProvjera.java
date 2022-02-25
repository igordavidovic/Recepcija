/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.util;

/**
 *
 * @author Igor
 */
public class OibProvjera {

    public static boolean provjera(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() != 11) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }

        return provjeraKontrolnogBroja(s);
    }

    private static boolean provjeraKontrolnogBroja(String s) {
        int b = (s.charAt(0) - 48) + 10;
        for (int i = 1; i <= 10; i++) {
            if (b % 10 == 0) {
                b = 10;
            } else {
                b = b % 10;
            }
            b = b * 2;
            b = b % 11;
            if (i == 10) {
                break;
            }
            b = b + (s.charAt(i) - 48);
        }
        if (b == 1) {
            b = 0;
        } else {
            b = 11 - b;
        }
        if (s.charAt(10) != (b + 48)) {
            return false;
        }
        return true;
    }

}
