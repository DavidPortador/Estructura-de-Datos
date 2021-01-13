package p300;

import java.util.Scanner;
public class p300 {
    Scanner a_tec = new Scanner(System.in);
    int[][] a_matriz;
    public static void main(String[] args) {
        p300 v_obj = new p300();
        v_obj.entrada();
    }
    void entrada(){
        int v_long;
        v_long = a_tec.nextInt();
        a_tec.nextLine();
        a_matriz = new int[v_long][v_long];
        llenarMatriz();
    }
    void llenarMatriz(){
        String v_var;
        int v_cc;
        for (v_cc = 0; v_cc < a_matriz.length; v_cc++) {
            v_var = a_tec.nextLine();
            insertaLinea(v_var, v_cc);
        }
        insertarCasos();
        //imprimirmatriz();
    }
    void insertaLinea(String p_dato, int p_posi){
        int v_cc;
        String[] v_aux = p_dato.split(" ");
        for (v_cc = 0; v_cc < a_matriz.length; v_cc++) 
            a_matriz[p_posi][v_cc] = Integer.parseInt(v_aux[v_cc]);
    }
    void insertarCasos(){
        boolean v_ban = true;
        String v_caso;
        while(v_ban){
            try {
                v_caso = a_tec.nextLine();
                calcular(v_caso);
            } catch (Exception e) {
                v_ban = false;
            }
        }
    }
    void calcular(String p_caso){
        boolean v_ban = true;
        int v_cc,v_cc2;
        String[] v_letras = p_caso.split(" ");
        int[] v_posis = new int[v_letras.length];
        for (v_cc = 0; v_cc < v_letras.length; v_cc++) 
            v_posis[v_cc] = getPosi(v_letras[v_cc].toLowerCase());
        for (v_cc2 = 0; v_cc2 < v_posis.length-1; v_cc2++) {
            try {
                //System.out.println(v_posis[v_cc2]+" "+v_posis[v_cc2+1]);
                if(a_matriz[v_posis[v_cc2]][v_posis[v_cc2+1]] == 0)
                    v_ban = false;
            } catch (Exception e) {
                v_ban = false;
            }
        }
        if(v_ban)
            if(v_letras[0].equals(v_letras[v_letras.length-1]))
                System.out.println("CIRCUITO");
            else
                System.out.println("CAMINO");
        else
            System.out.println("NO SUBGRAFO");
    }
    int getPosi(String p_letra){
        int v_cc, v_posi = 0;
        char[] v_abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                        'n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (v_cc = 0; v_cc < v_abc.length; v_cc++) 
            if(p_letra.charAt(0) == v_abc[v_cc])
                v_posi = v_cc;
        return v_posi;
    }
    /*
    void imprimirmatriz(){
        for (int i = 0; i < a_matriz.length; i++) {
            for (int j = 0; j < a_matriz.length; j++) 
                System.out.print(a_matriz[i][j]+" ");
            System.out.println("");
        }
    }*/
}
