/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tap2;

import java.util.*;
public class Tap2 {

    public static void main(String[] args) {
        String palabra1;
        String palabra2;
        
        Scanner read=new Scanner(System.in);
        System.out.println("Ingrese Palabra 1:");
        palabra1= read.nextLine();
       
        System.out.println("Ingrese Palabra 2:");
        palabra2=read.nextLine();
        
        if(palabra1.length()>palabra2.length())
        {
           int dif = palabra1.length()-palabra2.length();
            System.out.println("La palabra "+palabra1+" tiene "+dif+" letras mas que "+palabra2);
        }
        else if(palabra1.length()<palabra2.length())
        {
           int dif = palabra2.length()-palabra1.length();
            System.out.println("La palabra "+palabra2+" tiene "+dif+" letras mas que "+palabra1);
        }
        if(palabra1.length()== palabra2.length())
        {
            System.out.println("Las 2 palabras tienen el mismo largo");
        }
    }
    
}
