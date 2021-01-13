package p145;

import java.util.Scanner;
public class p145 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        p145 v_obj = new p145();
        v_obj.entrada();
    }
    void entrada(){
        int [] v_datos,v_aux;
        String v_dato;
        do{
           v_dato = a_tec.nextLine();
           v_datos = validar(v_dato);
           if(v_datos.length == 3)
               if(!(v_datos[0] == 0 && v_datos[1] == 0 && v_datos[2] == 0)){
                    if(v_datos[0] < v_datos[1] && v_datos[0] <= v_datos[2] && v_datos[2] <= v_datos[1]){
                        v_aux = Datos(v_datos[0],v_datos[1]);
                        System.out.println(calcular(v_aux, 1, v_aux.length, v_datos[2], 0));
                    }else
                        System.out.println("-1");
               }
        }while(!(v_datos[0] == 0 && v_datos[1] == 0 && v_datos[2] == 0));
    }
    int calcular(int[] p_datos, int p_li, int p_ls, int p_vb, int p_cont){
        int v_vc;
        p_cont++;
        if(p_li == p_ls){
            return p_cont;
        }else{
            v_vc = (p_ls + p_li) / 2;
            //System.out.println(p_li+" "+p_ls+"   -> "+v_vc);
            //System.out.println(p_datos[v_vc-1]);
            if(p_datos[v_vc-1] < p_vb){
                return calcular(p_datos, v_vc+1, p_ls, p_vb, p_cont);
            }else if(p_datos[v_vc-1] >= p_vb){
                return calcular(p_datos, p_li, v_vc, p_vb, p_cont);
            }else
                return -1;
        }
    }
    int[] Datos(int p_li, int p_ls){
        int[] v_datos = new int[(p_ls-p_li)+1];
        int v_cc;
        for (v_cc = 0; v_cc < v_datos.length; v_cc++) 
            v_datos[v_cc] = p_li++;
        return v_datos;
    }
    int[] validar(String p_dato){
        int v_cc,v_cc2;
        int[] v_datos = null;
        try {
            int v_cont=0,v_cont2=0;
            String[] v_aux = p_dato.split(" ");
            for(v_cc=0;v_cc<v_aux.length;v_cc++)
                if(!v_aux[v_cc].equals(""))
                    v_cont++;
            v_datos = new int[v_cont];
            for(v_cc2=0;v_cc2<v_aux.length;v_cc2++)
                if(!v_aux[v_cc2].equals("")){
                    v_datos[v_cont2]= Integer.parseInt(v_aux[v_cc2]);
                    v_cont2++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
}
