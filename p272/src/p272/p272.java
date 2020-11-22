package p272;

import java.util.Scanner;
public class p272 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        p272 v_obj = new p272();
        v_obj.entrada();
    }
    void entrada(){
        int v_casoN, v_casoM;
        String v_dato;
        String[] v_datos;
        int[] v_casos;
        v_casoN = a_tec.nextInt();
        if(v_casoN>0 && v_casoN<10){
            for (int v_cont = 0; v_cont < v_casoN; v_cont++) {
                v_casoM = a_tec.nextInt();
                if(v_casoM>0 && v_casoM<5){
                    v_casos = new int[v_casoM];
                    a_tec.nextLine();
                    for (int v_cont2 = 0; v_cont2 < v_casoM; v_cont2++) {
                        v_dato = a_tec.nextLine();
                        v_datos = separar(v_dato);
                        v_casos[v_cont2] = contador(v_datos,v_datos.length,0,0);
                    }
                    comparar(v_casos);
                }
            }
        }
    }
    void comparar(int[] p_casos){
        int v_menor,v_caso;
        v_menor = p_casos[0];
        v_caso=1;
        for (int v_cont = 0; v_cont < p_casos.length; v_cont++) {
            if(p_casos[v_cont] < v_menor) {
                v_menor = p_casos[v_cont];
                v_caso = v_cont+1;
            }
        }
        System.out.println("Algoritmo "+v_caso+" => "+v_menor+" bytes");
    }
    String[] separar(String p_dato){
        String[] v_datos;
        v_datos = p_dato.split(",");
        return v_datos;
    }
    int contador(String[] p_datos, int p_long, int p_aux, int p_cont){
        if(p_aux < p_long){
            if((p_datos[p_aux].equals("boolean")) || (p_datos[p_aux].equals("byte")))
                p_cont += 1;
            else if((p_datos[p_aux].equals("char")))
                p_cont += 2;
            else if((p_datos[p_aux].equals("float")) || (p_datos[p_aux].equals("int")))
                p_cont += 4;
            else if((p_datos[p_aux].equals("double")) || (p_datos[p_aux].equals("long")))
                p_cont += 8;
            else if(p_datos[p_aux].equals("String"))
                p_cont += 36;
            return contador(p_datos,p_long,p_aux+1,p_cont);
        }else
            return p_cont;
    }
}