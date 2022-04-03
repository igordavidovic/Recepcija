/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private static void testDatum() {
        Date datum = new Date();
        SimpleDateFormat stariFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat noviFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date datum2;
        try {
            datum2 = stariFormat.parse(datum.toString());
            String formatiran = noviFormat.format(datum2);
            System.out.println(formatiran);
        } catch (ParseException ex) {
        }
        System.out.println(datum.toString());
    }

    public static void main(String[] args) {
        //testOib();
        //Date date = ZavrsniUtil.generirajRandomDatum("01.01.1970", "31.12.2021");
        //System.out.println(date.toString());
        testDatum();
    }
}
