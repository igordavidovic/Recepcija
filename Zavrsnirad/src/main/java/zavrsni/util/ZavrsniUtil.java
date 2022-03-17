/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.util;

import zavrsni.model.Djelatnik;

/**
 *
 * @author Igor
 */
public class ZavrsniUtil {

    public static Djelatnik djelatnik;
    public static final String APP_NASLOV = "Recepcija app";

    public static String getNaslov(String naslov) {
        if (ZavrsniUtil.djelatnik == null) {
            return new StringBuilder().append(APP_NASLOV).append(" ").append(naslov).toString();
        }
        return new StringBuilder().append(APP_NASLOV).append(" ").append(naslov).append(" ").append(ZavrsniUtil.djelatnik.getIme()).append(" ").append(ZavrsniUtil.djelatnik.getPrezime()).append(" - ").append(ZavrsniUtil.djelatnik.getUloga()).toString();
    }

    public static boolean provjeraZnakova(String s) {
        char[] c = {'<', '>', '!', '~', '"', 'ˇ', '#', '^', '$', '˘', '%', '°', '&', '˛', '/', '`', '(', '˙', ')', '´', '=', '˝', '?', '¨', '*', '+', '¸', '\\', '|', '€', '÷', '×', '[', ']', 'ł', 'Ł', '¤', '@', '{', '}', '§', ',', ';', '.', ':', '_', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] p = s.toCharArray();
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (p[i] == c[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean provjeraUloge(String s) {
        String[] niz = {"RECEPCIONAR", "POMOĆNI RECEPCIONAR", "NOĆNI RECEPCIONAR", "ŠEF RECEPCIJE", "ZAMJENIK ŠEFA RECEPCIJE", "PORTIR"};
        for (String a : niz) {
            if (s.trim().toUpperCase().equals(a)) {
                return true;
            }
        }

        return false;
    }
}
