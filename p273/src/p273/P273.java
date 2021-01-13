package p273;

import java.util.Scanner;
public class P273 {
    Scanner a_tec = new Scanner(System.in);
    String[] a_datos;
    public static void main(String[] args) {
        P273 v_obj = new P273();
        v_obj.entrada();
    }
    void entrada(){
        String v_dato;
        boolean v_ban = true;
        while(v_ban){
            try {
                v_dato = a_tec.nextLine();
                separar(v_dato);
            } catch (Exception e) {
                v_ban = false;
            }
        }
    }
    void separar(String p_dato){
        int v_cont=0,v_cont2=0;
        String[] v_arr = p_dato.split(" ");
        for(int i=0;i<v_arr.length;i++)
            if(!v_arr[i].equals(""))
                v_cont++;
        a_datos = new String[v_cont];
        for(int i=0;i<v_arr.length;i++)
            if(!v_arr[i].equals("")){
                a_datos[v_cont2]=v_arr[i];
                v_cont2++;
            }
        validar(a_datos);
    }
    void validar(String[] p_datos){
        if(p_datos[0].equals("+") || p_datos[0].equals("-") || p_datos[0].equals("*") || p_datos[0].equals("/"))
            System.out.println("PREFIJA");
        else
            System.out.println("POSTFIJA");
    }
}