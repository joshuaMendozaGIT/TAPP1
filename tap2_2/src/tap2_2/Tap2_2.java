/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tap2_2;
import java.util.*;
public class Tap2_2 {
    public static void main(String[] args) {
        int t;//hora actual
        int h;//horas que van a pasar
        int hrsExt;
        int hrFinal;
        
        Scanner leer=new Scanner(System.in);
        
        System.out.print("Hora actual: ");
        t = leer.nextInt();

        System.out.print("Cantidad de horas: ");
        h = leer.nextInt();
        
        hrsExt=(24-h);
        
        if(hrsExt>0)
        {
            hrFinal=(t+h);
            System.out.println("En "+h+" horas, el reloj marcara las "+hrFinal);
        }
        
        if(hrsExt<0)
        {
            hrFinal=(t+h)%24;
            System.out.println("En " +h+" horas, el reloj marcara las "+hrFinal);
        }
    }
}
