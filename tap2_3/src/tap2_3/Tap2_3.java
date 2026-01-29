
package tap2_3;
import java.text.DecimalFormat;
import java.util.*;
public class Tap2_3 {

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        int anioAct;
        int edadAct;
        int anioEnt;
        int edadRes;
        
        System.out.print("Anio actual: ");
        anioAct=leer.nextInt();
        System.out.print("Edad actual: ");
        edadAct=leer.nextInt();
        
        System.out.print("Anio determinado: ");
        anioEnt=leer.nextInt();
        
        edadRes=(anioEnt-anioAct)+edadAct;
        System.out.print(edadRes);
        
        
        double radio;
        double circunferencia;
        double area;
        System.out.print("Ingresa el radio");
        radio=leer.nextDouble();
        
        circunferencia=Math.PI* (radio*2);
        area= Math.PI * (radio*radio);
        
        System.out.println("Area: "+area+", circunferencia "+circunferencia);
        
        double dolar;
        double euro;
        int opc;
        System.out.println("Ingresa 1 para convertir de dolar a euro o 2 para convertir de euro a dolar");
        opc=leer.nextInt();
        
        if(opc==1){//dolar a euro
            dolar=leer.nextDouble();
            euro=dolar*10;
            String res=df.format(euro);
            System.out.println(res);
        }
        else if(opc==2){//euro a dolar
            euro=leer.nextDouble();
            dolar=euro*15;
            String res=df.format(dolar);
            System.out.println(res);
        double C;
        double F;
        int opc2;
        //DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Ingresa 1 para convertir C a F o 2 para convertir de F a C");
        opc2=leer.nextInt();
        if(opc2==1)//C a F
        {
          C=leer.nextDouble();
          F=((C/5)*9+32);
          String res2=df.format(F);
          System.out.println(res2);
        }
        if(opc2==2)//F a C
        {
          F=leer.nextDouble();
          C=((F-32)/9)*5;
          String res2=df.format(C);
          System.out.println(res2);
        }
    }
}
