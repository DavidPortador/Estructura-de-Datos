package p2852;
// 50 76 17 23 54 9 14 12 72 67 19 0

import java.util.Scanner;
public class p2852 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        
    }
    void entrada(){
        int v_datos,v_cont;
        v_datos = valiEntrada();
        a_tec.nextLine();
        for(v_cont=0; v_cont < v_datos; v_cont++)
            arbol();
    }
    void arbol(){
        String v_dato;
        int[] v_datos;
        boolean v_ban = true;
        v_dato = a_tec.nextLine();
        v_datos = validar(v_dato);
        if(!repeticiones(v_datos)){
            if(negativos(v_datos)){
                v_datos = valicero(v_datos);
                if(v_datos[v_datos.length-1] == 0){
                    valicero(v_datos);
                    //Celda v_ini = new Celda(v_datos[0],0,0);
                    //Nodo v_nodo = new Nodo(v_ini);
                    //v_nodo.insertar(v_ini);
                    //llenarNodos(v_nodo,v_datos,1);
                    //validarNodos(v_nodo);
                    //v_nodo.vaciarNodos();
                    llenar(v_datos);
                }else{
                    String v_aux;
                    int[] v_arrs = null;
                    while(v_ban){
                        v_aux = a_tec.nextLine();
                        v_aux = v_dato + v_aux;
                        v_dato = v_aux;
                        v_arrs = validar(v_aux);
                        if(v_arrs[v_arrs.length-1]==0)
                            v_ban=false;
                        else
                            v_ban=true;
                    }
                    valicero(v_arrs);
                    //Celda v_ini = new Celda(v_arrs[0],0,0);
                    //Nodo v_nodo = new Nodo(v_ini);
                    //v_nodo.insertar(v_ini);
                    //llenarNodos(v_nodo,v_arrs,1);
                    //validarNodos(v_nodo);
                    //v_nodo.vaciarNodos();
                    llenar(v_datos);
                }
            }
        }
    }
    void llenar(int[] p_datos){
        for (int i = 0; i < p_datos.length; i++) {
            
        }
    }
    int[] valicero(int[] p_datos){
        int v_cont, v_cont2, v_aux = 0;
        boolean v_ban = false;
        if(p_datos[p_datos.length-1]==0)
            return p_datos;
        else{
            for(v_cont = 0; v_cont < p_datos.length; v_cont++)
                if(p_datos[v_cont]==0){
                    v_aux = v_cont+1;
                    v_ban = true;
                }
            if(v_ban){
                int[] v_datos = new int[v_aux];
                for(v_cont2=0; v_cont2 < v_aux; v_cont2++)
                    v_datos[v_cont2] = p_datos[v_cont2];
                return v_datos;
            }else
                return p_datos;
        }
        
    }
    boolean negativos(int[] p_datos){
        boolean v_ban = true;
        int v_con;
        for(v_con=0; v_con < p_datos.length-1; v_con++)
            if(p_datos[v_con] < 0)
                v_ban=false;
        return v_ban;
    }
    boolean repeticiones(int[] p_datos){
        boolean repetido = false;
        int v_cont1,v_cont2;
        for (v_cont1 = 0; v_cont1 < p_datos.length; v_cont1++) 
            for (v_cont2 = 0; v_cont2 < p_datos.length; v_cont2++) 
                if (p_datos[v_cont1] == p_datos[v_cont2] && v_cont1 != v_cont2) 
                    repetido = true;
        return repetido;
    }
    int[] validar(String p_dato){
        int[] v_datos = null;
        int v_con,v_con2;
        try {
            int v_cont = 0,v_cont2 = 0;
            String[] v_aux = p_dato.split(" ");
            for(v_con=0; v_con < v_aux.length; v_con++)
                if(!v_aux[v_con].equals(""))
                    v_cont++;
            v_datos = new int[v_cont];
            for(v_con2=0;v_con2<v_aux.length;v_con2++)
                if(!v_aux[v_con2].equals("")){
                    v_datos[v_cont2]= Integer.parseInt(v_aux[v_con2]);
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
