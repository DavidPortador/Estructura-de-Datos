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
        v_obj.separar();
    }
    void entrada(){
        int v_cont,v_long;
        try {
            a_long = a_tec.nextInt();
            a_tec.nextLine(); // Limpia el buffer
            a_datos = new String[a_long];
            a_resp = new int[a_long];
            ingresar(a_long);
        } catch (Exception e) {
        }
    }
    void ingresar(int p_long){
        if(p_long > 0)
            if(p_long <= a_long){
                a_datos[a_long-p_long] = a_tec.nextLine();
                ingresar(p_long-1);
            }
    }
    void separar(){
        int[] v_multid1,v_multid2;
        int v_dato1,v_dato2;
        for(int i=0;i<a_long;i++){
            String[] v_arr = a_datos[i].split(" ");
            try {
                v_dato1 = Integer.parseInt(v_arr[0]);
                v_dato2 = Integer.parseInt(v_arr[1]);
                v_multid1 = new int[nMultiplos(v_dato1,1,0)];
                v_multid2 = new int[nMultiplos(v_dato2,1,0)];
                nMulti(v_dato1,1,0,v_multid1);
                nMulti(v_dato2,1,0,v_multid2);
                comparar(v_multid1,v_multid2,1);
            } catch (Exception e) {
            }
        }
    }
    int nMultiplos(int p_num,int p_aux, int p_cont){
        if(p_aux>0 && p_aux<=p_num){
            if(p_num % p_aux == 0){
                p_cont++;
            }
            return nMultiplos(p_num,p_aux+1,p_cont);
        }else
            return p_cont;
    }
    void nMulti(int p_num,int p_aux, int p_cont, int[] p_datos){
        if(p_aux>0 && p_aux<=p_num){
            if(p_num % p_aux == 0){
                p_datos[p_cont] = p_aux; 
                p_cont++;
            }
            nMulti(p_num,p_aux+1,p_cont,p_datos);
        }
    }
    void comparar(int[] p_dato1,int[] p_dato2,int p_resp){
        for(int i=0;i<p_dato1.length;i++){
            for(int j=0;j<p_dato2.length;j++){
                if(p_dato1[i] == p_dato2[j])
                    p_resp = p_dato1[i];
            }
        }
        System.out.println(p_resp);
    }
}
