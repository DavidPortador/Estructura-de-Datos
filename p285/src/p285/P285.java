package p285;

import java.util.Scanner;

public class P285 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        P285 v_obj = new P285();
        v_obj.entrada();
    }
    void entrada(){
        int v_datos;
        v_datos = valiEntrada();
        a_tec.nextLine();
        for(int i=0;i<v_datos;i++){
            arbol();
        }
    }
    void arbol(){
        String v_dato;
        int[] v_datos;
        v_dato = a_tec.nextLine();
        v_datos = validar(v_dato);
        crearArbol(v_datos,v_datos.length,v_datos.length,0,0);
    }
    void crearArbol(int[] p_datos, int p_cont,int p_aux,int p_men,int p_may){
        if(p_cont>0){
            System.out.println("----"+(p_aux-p_cont));
            p_cont--;
            crearArbol(p_datos,p_cont,p_aux,p_men,p_may);
        }else{
            System.out.println("menor: "+p_men+" mayor: "+p_may);
        }
    }
    int[] validar(String p_dato){
        int[] v_datos = null;
        try {
            int v_cont=0,v_cont2=0;
            String[] v_aux = p_dato.split(" ");
            for(int j=0;j<v_aux.length;j++)
                if(!v_aux[j].equals(""))
                    v_cont++;
            v_datos = new int[v_cont];
            for(int k=0;k<v_aux.length;k++)
                if(!v_aux[k].equals("")){
                    v_datos[v_cont2]= Integer.parseInt(v_aux[k]);
                    v_cont2++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
    int valiEntrada(){
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
