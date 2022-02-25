/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsni.util;

/**
 *
 * @author Igor
 */
public class ZavrsniUtil {

    public static boolean provjeraZnakova(String s) {
        char[] c = {'<', '>', '!', '~', '"', 'ˇ', '#', '^', '$', '˘', '%', '°', '&', '˛', '/', '`', '(', '˙', ')', '´', '=', '˝', '?', '¨', '*', '+', '¸', '\\', '|', '€', '÷', '×', '[', ']', 'ł', 'Ł', '¤', '@', '{', '}', '§', ',', ';', '.', ':', '_', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] p = s.toCharArray();
        for(int i = 0;i < p.length;i++){
            for(int j = 0;j < c.length;j++){
                if(p[i] == c[j]){
                 return false;   
                }
            }
        }
        return true;
    }
    
    
    public static boolean provjeraUloge(String s){
        String[] niz = {"RECEPCIONAR","POMOĆNI RECEPCIONAR","NOĆNI RECEPCIONAR","ŠEF RECEPCIJE","ZAMJENIK ŠEFA RECEPCIJE","PORTIR","BELL BOY"};
        for(String a : niz){
            if(s.toUpperCase().equals(a)){
                return true;
            }
        }
        
        return false;
    }
}
