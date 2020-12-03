package p2852;
// 50 76 17 23 54 9 14 12 72 67 19 0

import java.util.Scanner;
public class p2852 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        p2852 v_obj = new p2852();
        v_obj.entrada();
    }
    void entrada(){
        int v_datos,v_cont;
        v_datos = valiEntrada();
        a_tec.nextLine();
        for(v_cont = 0; v_cont < v_datos; v_cont++)
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
                    llenar(v_arrs);
                }
            }
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
    void llenar(int[] p_arbol){
        int v_mayor,v_menor,v_cont=0,v_cont2=0,v_cc1,v_cc2,v_cc3,v_cc4;
        int[] v_lineas;
        Nodo v_Raiz = new Nodo(p_arbol[0]);
        Arbol v_arbol = new Arbol(v_Raiz);
        for (v_cc1 = 1; v_cc1 < p_arbol.length-1; v_cc1++)
            v_arbol.insertar(v_Raiz, p_arbol[v_cc1]);
        for (v_cc2 = 0; v_cc2 < p_arbol.length-1; v_cc2++) {
            Nodo v_aux = v_arbol.buscar(v_Raiz, p_arbol[v_cc2]);
            if(v_aux.getIzq()==null && v_aux.getDer()==null)
                v_cont++;
        }
        v_lineas = new int[v_cont];
        for (v_cc3 = 0; v_cc3 < p_arbol.length-1; v_cc3++) {
            Nodo v_aux = v_arbol.buscar(v_Raiz, p_arbol[v_cc3]);
            int linea = v_arbol.get_Linea(v_Raiz, p_arbol[v_cc3], 0);
            if(v_aux.getIzq()==null && v_aux.getDer()==null){
                v_lineas[v_cont2]=linea;
                v_cont2++;
            }
        }
        v_mayor = v_menor = v_lineas[0];
        for (v_cc4 = 0; v_cc4 < v_lineas.length; v_cc4++){
            if(v_lineas[v_cc4] > v_mayor)
                v_mayor = v_lineas[v_cc4];
            if(v_lineas[v_cc4]<v_menor) 
                v_menor = v_lineas[v_cc4];
        }
        System.out.println(v_menor+" "+v_mayor);
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
                    //System.out.println("se agrego "+p_valor+" menor que "+p_raiz.getValor());
                }else
                    insertar(p_raiz.getIzq(),p_valor);
            }else if(p_valor > p_raiz.getValor()){
                if(p_raiz.getDer()==null){
                    Nodo v_mayor = new Nodo(p_valor);
                    p_raiz.setDer(v_mayor);
                    //System.out.println("se agrego "+p_valor+" mayor que "+p_raiz.getValor());
                }else
                    insertar(p_raiz.getDer(),p_valor);
            }
        }
        Nodo buscar(Nodo p_raiz,int p_valor){
            if(p_raiz.getValor()==p_valor)
                return p_raiz;
            else if(p_valor < p_raiz.getValor())
                return buscar(p_raiz.getIzq(),p_valor);
            else if(p_valor > p_raiz.getValor())
                return buscar(p_raiz.getDer(),p_valor);
            else
                return null;
        }
        int get_Linea(Nodo p_raiz,int p_valor,int v_cont){
            v_cont++;
            if(p_raiz.getValor()==p_valor)
                return v_cont;
            else if(p_valor < p_raiz.getValor())
                return get_Linea(p_raiz.getIzq(),p_valor,v_cont);
            else if(p_valor > p_raiz.getValor())
                return get_Linea(p_raiz.getDer(),p_valor,v_cont);
            else
                return 0;
        }
    }
}