package p280;

import java.util.Scanner;
public class P280 {
    Scanner a_tec = new Scanner(System.in);
    int a_cont,a_long;
    public static void main(String[] args) {
        P280 v_obj = new P280();
        v_obj.entrada();
    }
    void entrada(){
        a_long = validar();
        ingresar(a_long);
    }
    void ingresar(int p_long){
        int v_aux,v_fib;
        if(p_long > 0)
            if(p_long <= a_long){
                v_aux = a_tec.nextInt();
                v_fib = calcular(v_aux);
                System.out.println(a_cont);
                a_cont=0;
                ingresar(p_long-1);
            }
    }
    int calcular(int p_valor){
        a_cont++;
        if (p_valor<2)
           return 1;
        else
           return calcular(p_valor-1)+calcular(p_valor-2);
    }
    int validar(){
        int v_num=0;
        try {
            v_num = a_tec.nextInt();
            if(v_num<0 || v_num>5)
                v_num=0;
        } catch (Exception e) {
        }
        return v_num;
    }
}
