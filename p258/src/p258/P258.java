package p258;

import java.util.Scanner;
public class P258 {
    Scanner a_tec = new Scanner(System.in);
    int[] a_datos;
    int a_long,a_resp;
    public static void main(String[] args) {
        P258 v_obj = new P258();
        v_obj.entrada();
    }
    void entrada(){
        int v_cont;
        try {
            a_long = a_tec.nextInt();
            a_datos = new int[a_long];
            ingresar(a_long);
            System.out.println(sumar(a_long));
        } catch (Exception e) {
        }
    }
    void ingresar(int p_long){
        if(p_long > 0)
            if(p_long <= a_long){
                a_datos[a_long-p_long] = a_tec.nextInt();
                ingresar(p_long-1);
            }
    }
    int sumar(int p_cont){
        if(p_cont > 0)
            if(p_cont <= a_long){
                a_resp += a_datos[a_long-p_cont];
                return sumar(p_cont-1);
            }else
                return a_resp;
        else
            return a_resp;
    }
}
