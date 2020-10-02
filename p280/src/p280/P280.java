package p280;

import java.util.Scanner;
public class P280 {
    Scanner a_tec = new Scanner(System.in);
    int[] a_resp;
    public static void main(String[] args) {
        P280 v_obj = new P280();
        v_obj.entrada();
    }
    void entrada(){
        int v_long,v_aux;
        try {
            v_long = a_tec.nextInt();
            if (v_long<6){
                a_resp = new int[v_long];
                for(int i=0;i<v_long;i++){
                    v_aux = a_tec.nextInt();
                    a_resp[i] = calcular(v_aux+1);
                }
            }else{
                System.exit(0);
            }
        } catch (Exception e) {
        }
        for(int i=0;i<a_resp.length;i++)
            System.out.println(a_resp[i]);
    }
    int calcular(int p_cont){
        if (p_cont<2)
           return 1;
        else
           return calcular(p_cont-1)+calcular(p_cont-2);
    }
}
