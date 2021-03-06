/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import recepcija.model.Djelatnik;

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
        int broj;
        char[] c = {'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'P', 'Š', 'Đ', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Č', 'Ć', 'Ž', 'Y', 'X', 'C', 'V', 'B', 'N', 'M', '\'', '-', ' '};
        for (int i = 0; i < s.length(); i++) {
            broj = 0;
            for (int j = 0; j < c.length; j++) {
                if (s.toUpperCase().charAt(i) == c[j]) {
                    broj = 1;
                    break;
                }
            }
            if (broj == 0) {
                return false;
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

    public static Date generirajDatum(LocalDate pocetak, LocalDate kraj) {
        long startEpochDay = pocetak.toEpochDay();
        long endEpochDay = kraj.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);
        LocalDate date = LocalDate.ofEpochDay(randomDay);
        return Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String oibGeneriraj() {
        StringBuilder sb = new StringBuilder();
        Integer[] niz = new Integer[11];
        for (int i = 0; i < 10; i++) {
            niz[i] = (int) (Math.random() * 9);
            sb.append(niz[i]);
        }
        int c = niz[0] + 10;
        for (int i = 1; i <= 10; i++) {
            if (c % 10 == 0) {
                c = 10;
            } else {
                c = c % 10;
            }
            c = c * 2;
            c = c % 11;
            if (i == 10) {
                break;
            }
            c = c + niz[i];
        }
        if (11 - c == 10) {
            niz[10] = 0;
        } else {
            niz[10] = 11 - c;
        }
        sb.append(niz[10]);
        return sb.toString();
    }

    public static int randomBroj(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
