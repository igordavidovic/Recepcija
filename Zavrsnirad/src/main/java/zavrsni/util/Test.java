/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.util;

import java.util.Date;

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
        //testOib();
        Date date = ZavrsniUtil.generirajRandomDatum("01.01.1970", "31.12.2021");
        System.out.println(date.toString());
    }
}
