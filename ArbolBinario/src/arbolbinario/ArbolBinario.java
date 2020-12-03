package arbolbinario;

import java.util.Scanner;
public class ArbolBinario {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        ArbolBinario v_obj = new ArbolBinario();
        v_obj.entrada();
    }
    void entrada(){
        String v_datos = "50 76 17 23 54 9 14 12 72 67 19 0";
        int[] v_arbol = validar(v_datos);
        llenar(v_arbol);
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
    void llenar(int[] p_arbol){
        Nodo v_Raiz = new Nodo(p_arbol[0]);
        Arbol v_arbol = new Arbol(v_Raiz);
        for (int i = 1; i < p_arbol.length-1; i++) {
            v_arbol.insertar(v_Raiz, p_arbol[i]);
        }
    }
    class Nodo{
        private int valor;
        private Nodo izq;
        private Nodo der;
        public Nodo(int p_valor) {
            valor = p_valor;
            izq = null;
            der = null;
        }
        public int getValor() {
            return valor;
        }
        public Nodo getIzq() {
            return izq;
        }
        public void setIzq(Nodo izq) {
            this.izq = izq;
        }
        public Nodo getDer() {
            return der;
        }
        public void setDer(Nodo der) {
            this.der = der;
        }
    }
    class Arbol{
        Nodo a_raiz;
        
        public Arbol(Nodo p_raiz) {
            a_raiz = p_raiz;
        }
        void insertar(Nodo p_raiz, int p_valor){
            if(p_valor < p_raiz.getValor()){
                if(p_raiz.getIzq()==null){
                    Nodo v_menor = new Nodo(p_valor);
                    p_raiz.setIzq(v_menor);
                    System.out.println("se agrego "+p_valor+" menor que "+p_raiz.getValor());
                }else{
                    insertar(p_raiz.getIzq(),p_valor);
                }
            }else if(p_valor > p_raiz.getValor()){
                if(p_raiz.getDer()==null){
                    Nodo v_mayor = new Nodo(p_valor);
                    p_raiz.setDer(v_mayor);
                    System.out.println("se agrego "+p_valor+" mayor que "+p_raiz.getValor());
                }else{
                    insertar(p_raiz.getDer(),p_valor);
                }
            }
        }
    }
}
