package p257;

import java.util.Scanner;
public class P257 {
    Scanner a_tec = new Scanner(System.in);
    String[] a_datos;
    int[] a_resp;
    int a_long;
    public static void main(String[] args) {
        P257 v_obj = new P257();
        v_obj.entrada();
    }
    void entrada(){
        int v_cont,v_long;
        try {
            a_long = a_tec.nextInt();
            a_datos = new String[a_long];
            a_resp = new int[a_long];
            
        } catch (Exception e) {
            System.out.println("err2");
        }
    }
    void ingresar(int p_long){
        if(p_long > 0){
            if(p_long <= a_long){
                a_datos[a_long-p_long] = a_tec.nextLine();
                System.out.println(a_long-p_long);
                ingresar(p_long-1);
            }
        }
    }
    void separar(){
        int v_dato1,v_dato2;
        for(int i=0;i<a_long;i++){
            System.out.println(i);
            String[] v_arr = a_datos[i].split(" ");
            try {
                v_dato1 = Integer.parseInt(v_arr[0]);
                v_dato2 = Integer.parseInt(v_arr[1]);
                System.out.println(v_dato1+" "+v_dato2);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }
    int nMultiplos(int p_num){
        int v_cont,v_contM=0;
        for(v_cont=1;v_cont<=p_num;v_cont++){
            if(p_num % v_cont == 0){
                // System.out.println(v_cont);
                v_contM++;
            }
        }
        return v_contM;
    } 
}
