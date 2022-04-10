/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
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

    private static Date datumIzmedu(LocalDate a, LocalDate b) {
        long startEpochDay = a.toEpochDay();
        long endEpochDay = b.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);
        LocalDate date = LocalDate.ofEpochDay(randomDay);
        return Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {
        //testOib();
        //Date date = ZavrsniUtil.generirajRandomDatum("01.01.1970", "31.12.2021");
        //System.out.println(date.toString());
        //testDatum();
        LocalDate start = LocalDate.of(1989, Month.OCTOBER, 14);
        LocalDate end = LocalDate.now();
        Date date;
        for(int i = 0;i < 100;i++){
            date = datumIzmedu(start,end);
            System.out.println(date.toString());
        }
    }
}
