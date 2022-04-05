/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recepcija.util;

import com.github.javafaker.Faker;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import recepcija.model.Djelatnik;
import recepcija.model.Korisnik;
import recepcija.model.Posjeta;
import recepcija.model.Usluga;

/**
 *
 * @author Igor
 */
public class PocetniUnos {



    public static void pocetniUnos() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Faker faker = new Faker();
        Argon2 argon2 = Argon2Factory.create();
        unosDjelatnika(faker,session,argon2);
        List<Korisnik> korisnici = unosKorisnika(faker,session);
        List<Usluga> usluge = unosUsluga(faker,session);
        unosPosjeta(korisnici,usluge,faker,session);
        session.getTransaction().commit();
    }

    private static void unosDjelatnika(Faker faker,Session session,Argon2 argon2) {
        Djelatnik d;
        d = new Djelatnik();
        d.setIme("Igor");
        d.setPrezime("Davidović");
        d.setEmail("idavidovic@gmail.com");
        d.setPlaca(new BigDecimal(12000));
        d.setUloga("Šef recepcije");
        d.setLozinka(argon2.hash(10, 65536, 1, "id".toCharArray()));
        session.save(d);
        String[] domene = {"gmail.com", "hotmail.com", "mail.com", "outlook.com", "yahoo.com"};
        String[] uloge = {"Recepcionar", "Recepcionar", "Pomoćni recepcionar", "Portir", "Noćni recepcionar"};
        String[] sifre = {"a","bb","ccc","dddd","eeeee"};
        for (int i = 0; i < uloge.length; i++) {
            d = new Djelatnik();
            d.setIme(faker.name().firstName());
            d.setPrezime(faker.name().lastName());
            d.setUloga(uloge[i]);
            d.setPlaca(new BigDecimal(Math.random() * (12000 - 6000) + 6000));
            d.setEmail(new StringBuilder().append(d.getIme().toLowerCase()).append(d.getPrezime().substring(0, 1).toLowerCase()).append("@").append(domene[(int) (Math.random() * 5)]).toString());
            d.setLozinka(argon2.hash(10, 65536, 1, sifre[i].toCharArray()));
            session.save(d);
        }
    }

    private static List<Korisnik> unosKorisnika(Faker faker,Session session) {
        List<Korisnik> korisnici = new ArrayList<>();
        Korisnik k;
        String[] domene = {"gmail.com", "hotmail.com", "mail.com", "outlook.com", "yahoo.com"};
        for (int i = 0; i < 1000; i++) {
            k = new Korisnik();
            k.setIme(faker.name().firstName());
            k.setPrezime(faker.name().lastName());
            k.setEmail(new StringBuilder().append(k.getIme().toLowerCase()).append(k.getPrezime().substring(0, 1).toLowerCase()).append("@").append(domene[(int) (Math.random() * 5)]).toString());
            k.setOib(ZavrsniUtil.oibGeneriraj());
            k.setDatumRodenja(ZavrsniUtil.generirajRandomDatum("01.01.1970", "31.12.2021"));
            korisnici.add(k);
            session.save(k);
        }

        return korisnici;
    }

    private static void unosPosjeta(List<Korisnik> korisnici,List<Usluga> usluge,Faker faker,Session session) {
        Posjeta p;
        for(int i = 0;i < 2000;i++){
            p = new Posjeta();
            p.setKorisnik(korisnici.get((int)(Math.random() * 1000)));
            p.setDatumPrijave(ZavrsniUtil.generirajRandomDatum("01.01.2019", "30.03.2022"));
            while(true){
            p.setDatumOdjave(ZavrsniUtil.generirajRandomDatum("01.01.2019", "31.03.2022"));
            if(p.getDatumOdjave().after(p.getDatumPrijave())){
                break;
            }
            }
            p.setBrojSoba((int)(Math.random() * (4 - 1) + 1));
            p.setBrojOdraslih((int)(Math.random() * ((p.getBrojSoba() + 2) - p.getBrojSoba()) + p.getBrojSoba()));
            p.setBrojDjece((int)(Math.random() * 3));
            p.setUsluge(new ArrayList());
            for(int j = 0;j < p.getBrojSoba();j++){
            p.getUsluge().add(usluge.get(j));
            }
            session.save(p); 
        }
    }

    private static List<Usluga> unosUsluga(Faker faker,Session session) {
        List<Usluga> usluge = new ArrayList<>();
        Usluga u;
        String[] nazivi = {"Noćenje u jednokrevetnoj sobi s doručkom", "Noćenje u dvokreventoj sobi s doručkom", "Noćenje u jednokreventoj sobi s polupansionom", "Noćenje u dvokreventoj sobi s polupansionom", "Noćenje u jednokreventoj sobi s punim pansionom", "Noćenje u dvokreventoj sobi s punim pansionom"};
        BigDecimal[] cijene = {new BigDecimal(350), new BigDecimal(380), new BigDecimal(400), new BigDecimal(450), new BigDecimal(500), new BigDecimal(550)};
        for(int i = 0;i < nazivi.length;i++){
            u = new Usluga();
            u.setNaziv(nazivi[i]);
            u.setCijena(cijene[i]);
            session.save(u);
            usluge.add(u);
        }
        return usluge;
    }
}
