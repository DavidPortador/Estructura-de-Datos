package p291;
// -4 + 5i 8 - 2.5i +

import java.text.DecimalFormat;
import java.util.Scanner;
public class P291 {
    DecimalFormat a_df = new DecimalFormat("#.#");
    float a_real1,a_comp1=0,a_real2,a_comp2=0;
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        P291 v_obj = new P291();
        v_obj.entrada();
    }
    void entrada(){
        String v_variable="";
        String[] v_datos;
        boolean v_bandera=true;
        while(v_bandera){
            try {
                v_variable=a_tec.nextLine();
            }catch(Exception E){ 
                v_bandera=false;
            }
            if (v_bandera) {  
                v_datos = validar(v_variable);
                separar(v_datos);
            }
         }
    }
    String[] validar(String p_dato){
        String[] v_datos = null;
        try {
            int v_cont=0,v_cont2=0;
            String[] v_aux = p_dato.split(" ");
            for(int j=0;j<v_aux.length;j++)
                if(!v_aux[j].equals(""))
                    v_cont++;
            v_datos = new String[v_cont];
            for(int k=0;k<v_aux.length;k++)
                if(!v_aux[k].equals("")){
                    v_datos[v_cont2]= v_aux[k];
                    v_cont2++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
    void separar(String[] p_dato){
        String v_ope;
        try {
            String[] v_arr = p_dato;
            String[] v_auxc1 = v_arr[2].split("i");
            String[] v_auxc2 = v_arr[5].split("i");
            a_real1 = Float.parseFloat(v_arr[0]);
            a_real2 = Float.parseFloat(v_arr[3]);
            for(int j=0;j<v_auxc1.length;j++)
                if(v_arr[1].equals("+"))
                    a_comp1 = Float.parseFloat(v_auxc1[j]);
                else if(v_arr[1].endsWith("-"))
                    a_comp1 = Float.parseFloat(v_auxc1[j])*-1; 
            for(int j=0;j<v_auxc2.length;j++)
                if(v_arr[4].equals("+"))
                    a_comp2 = Float.parseFloat(v_auxc2[j]);
                else if(v_arr[4].endsWith("-"))
                    a_comp2 = Float.parseFloat(v_auxc2[j])*-1;
            v_ope = v_arr[6];
            if(v_ope.equals("+"))
                sumar();
            if(v_ope.equals("-"))
                restar();
            if(v_ope.equals("*"))
                multiplicar();
            if(v_ope.equals("/"))
                dividir();
        } catch (Exception e) {
            System.exit(0);
        }
    }
    void sumar(){
        String v_sig;
        float v_real,v_comp;
        v_real = a_real1+a_real2;
        v_comp = a_comp1+a_comp2;
        if(v_comp<0){
            v_sig = "-";
            v_comp *= -1;
        }else
            v_sig = "+";
        System.out.println(a_df.format(v_real)+" "+v_sig+" "+a_df.format(v_comp)+"i");
    }
    void restar(){
        String v_sig;
        float v_real,v_comp;
        v_real = a_real1-a_real2;
        v_comp = a_comp1-a_comp2;
        if(v_comp<0){
            v_sig = "-";
            v_comp *= -1;
        }else
            v_sig = "+";
        System.out.println(a_df.format(v_real)+" "+v_sig+" "+a_df.format(v_comp)+"i");
    }
    void multiplicar(){
        String v_sig;
        float v_auxr1,v_auxc1,v_auxr2,v_auxc2,v_real,v_comp;
        v_auxr1 = a_real1*a_real2;
        v_auxr2 = a_real1*a_comp2;
        v_auxc1 = a_comp1*a_real2;
        v_auxc2 = a_comp1*a_comp2;
        v_auxr2 += v_auxc1;
        v_auxc2 *= -1;
        v_auxr1 += v_auxc2;
        v_real = v_auxr1;
        v_comp = v_auxr2;
        if(v_comp<0){
            v_sig = "-";
            v_comp *= -1;
        }else
            v_sig = "+";
        System.out.println(a_df.format(v_real)+" "+v_sig+" "+a_df.format(v_comp)+"i");
    }
    void dividir(){
        String v_sig;
        float v_auxr1,v_auxc1,v_auxr2,v_auxc2,v_conj,v_auxd1,v_auxd2,v_real,v_comp;
        v_conj = a_comp2*-1;
        v_auxr1 = a_real1*a_real2;
        v_auxr2 = a_real1*v_conj;
        v_auxc1 = a_comp1*a_real2;
        v_auxc2 = a_comp1*v_conj;
        v_auxd1=a_real2;
        v_auxd2=a_comp2;
        v_auxd1 *= v_auxd1;
        v_auxd2 *= v_auxd2;
        v_auxc2 *= -1;
        v_auxr1 += v_auxc2;
        v_auxc1 += v_auxr2;
        v_auxd1 += v_auxd2;
        v_real=v_auxr1/v_auxd1;
        v_comp=v_auxc1/v_auxd1;
        if(v_comp<0){
            v_sig = "-";
            v_comp *= -1;
        }else
            v_sig = "+";
        System.out.println(a_df.format(v_real)+" "+v_sig+" "+a_df.format(v_comp)+"i");
    }
}

