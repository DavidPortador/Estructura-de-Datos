package p299;

import java.util.Scanner;
public class p299 {
    Scanner a_tec = new Scanner(System.in);
    Lista[] a_caminos;
    int[][] a_matriz;
    int a_total = 0;
    public static void main(String[] args) {
        p299 v_obj = new p299();
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
        int v_ax = 0, vi, vf;
        String[] v_limites = p_caso.split(",");
        vi = getPosi(v_limites[0].toLowerCase());
        vf = getPosi(v_limites[1].toLowerCase());
        System.out.println(v_limites[0]+"("+vi+")  -->  "+v_limites[1]+"("+vf+")");
        crearRecorridos();
        int[] v_recorrido = new int[a_matriz.length];
        v_recorrido[0] = vi;
        for (int v_cc = 1; v_cc < a_matriz.length; v_cc++)
            v_recorrido[v_cc] = -1;
        System.out.println("===> "+vi+" ");
        camino(vi,vf,1,v_recorrido);
        for (int v_cc2 = 0; v_cc2 < v_recorrido.length; v_cc2++) {
            System.out.print(v_recorrido[v_cc2]+" ");
        }
        System.out.println("  = "+a_total);
        imprimir(v_recorrido);
        a_total = 0;
    }
    void imprimir(int[] p_recorrido){
        int v_long = 0;
        String v_respuesta = "";
        for (int v_cc = 0; v_cc < p_recorrido.length; v_cc++)
            if(p_recorrido[v_cc] != -1)
                v_respuesta += getLetra(p_recorrido[v_cc])+" ";
        System.out.println(v_respuesta + a_total);
    }
    void crearRecorridos(){
        a_caminos = new Lista[a_matriz.length];
        int v_cc, v_cc2, v_cc3,v_cc5, v_cc6, aux, aux2, v_cont = 0;
        int[] v_datos, v_letras;
        Nodo v_ax = new Nodo(0,0);
        for (v_cc = 0; v_cc < a_matriz.length; v_cc++) {
            a_caminos[v_cc] = new Lista(v_ax);
            for (v_cc2 = 0; v_cc2 < a_matriz.length; v_cc2++)
                if(a_matriz[v_cc][v_cc2] != 0)
                    v_cont ++;
            v_datos = new int[v_cont];
            v_letras = new int[v_cont];
            v_cont = 0;
            for (v_cc3 = 0; v_cc3 < a_matriz.length; v_cc3++)
                if(a_matriz[v_cc][v_cc3] != 0){
                    v_datos[v_cont] = a_matriz[v_cc][v_cc3];
                    v_letras[v_cont] = v_cc3;
                    v_cont++;
                }
            v_cont = 0;
            for (v_cc5 = 0; v_cc5 < v_datos.length - 1; v_cc5++)
                for (v_cc6 = 0; v_cc6 < v_datos.length - v_cc5 - 1; v_cc6++)
                    if (v_datos[v_cc6 + 1] < v_datos[v_cc6]) {
                        aux = v_datos[v_cc6 + 1];
                        aux2 = v_letras[v_cc6 + 1];
                        v_datos[v_cc6 + 1] = v_datos[v_cc6];
                        v_letras[v_cc6 + 1] = v_letras[v_cc6];
                        v_datos[v_cc6] = aux;
                        v_letras[v_cc6] = aux2;
                    }
            System.out.print(v_cc + " orden ---> ");
            for (int v_cc7 = 0; v_cc7 < v_datos.length; v_cc7++) {
                System.out.print(v_datos[v_cc7]+" ("+v_letras[v_cc7]+") ");
                Nodo v_newNodo = new Nodo(v_letras[v_cc7], v_datos[v_cc7]);
                a_caminos[v_cc].insertarFinal(v_newNodo);
            }
            System.out.print(" Long -> "+a_caminos[v_cc].get_Long());
        }
    }
    void camino(int p_vi, int p_vf, int p_cont,  int[] p_recorrido){
        boolean v_ban = true;
        for (int v_cc = 0; v_cc < p_cont; v_cc++) {
            System.out.print(" ("+p_recorrido[v_cc]+"="+a_caminos[p_vi].obtener(0).getA_letra()+") ");
            if(p_recorrido[v_cc] == a_caminos[p_vi].obtener(0).getA_letra())
                v_ban = false;
        }
        if(v_ban){
            System.out.println(" => "+a_caminos[p_vi].obtener(0).getA_letra());
            p_recorrido[p_cont] = a_caminos[p_vi].obtener(0).getA_letra();
            a_total += a_caminos[p_vi].obtener(0).getA_peso();
            p_cont ++;
            if(p_vf == a_caminos[p_vi].obtener(0).getA_letra()){
                System.out.println("termina");
            }else
                camino(a_caminos[p_vi].obtener(0).getA_letra(), p_vf, p_cont, p_recorrido);
        }else
            if(a_caminos[p_vi].get_Long() > 1){
                a_caminos[p_vi].eliminarPrincipio();
                camino(p_vi, p_vf, p_cont, p_recorrido);
            }else{
                p_cont --;
                System.out.println("ELIMINADO: "+p_recorrido[p_cont]);
                a_total -= a_matriz[p_recorrido[p_cont]][p_recorrido[p_cont]-1];
                System.out.println(p_recorrido[p_cont-1]);
                p_recorrido[p_cont] = -1;
                a_caminos[p_cont-1].eliminarPrincipio();
                camino(p_recorrido[p_cont-1], p_vf, p_cont, p_recorrido);
            }
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
    String getLetra(int p_posi){
        String[] v_abc = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                        "n","o","p","q","r","s","t","u","v","w","x","y","z"};
        return v_abc[p_posi].toUpperCase();
    }
    class Nodo{
        private int a_letra;
        private int a_peso;
        public Nodo(int a_letra, int a_peso) {
            this.a_letra = a_letra;
            this.a_peso = a_peso;
        }
        public int getA_peso() {
            return a_peso;
        }
        public void setA_peso(int a_peso) {
            this.a_peso = a_peso;
        }
        public int getA_letra() {
            return a_letra;
        }
        public void setA_letra(int a_letra) {
            this.a_letra = a_letra;
        }
    }
    class Lista{
        Lista a_cabeza;
        int a_longitud = 0;
        Lista a_sig = null;
        public Nodo a_obj;
        public Lista(Nodo p_obj) {
            a_obj = p_obj;
        }
        void insertarFinal(Nodo p_obj){
            Lista v_nuevoNodo = new Lista(p_obj);
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                Lista v_puntero = a_cabeza;
                while(v_puntero.a_sig != null){
                    v_puntero = v_puntero.a_sig;
                }
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud ++;
        }
        Nodo obtener(int p_num){
            if (a_cabeza == null)
                return null;
            else{
                Lista v_puntero = a_cabeza;
                int v_cont = 0;
                while(v_cont < p_num && v_puntero.a_sig != null){
                    v_puntero = v_puntero.a_sig;
                    v_cont++;
                }
                if(v_cont != p_num)
                    return null;
                else
                    return v_puntero.a_obj;
            }
        }
        void eliminarPrincipio(){
            if (a_cabeza != null){
                Lista v_primer = a_cabeza;
                a_cabeza = a_cabeza.a_sig;
                v_primer.a_sig = null;
                a_longitud--;
            }
        }
        int get_Long(){
            return a_longitud;
        }
    }
}