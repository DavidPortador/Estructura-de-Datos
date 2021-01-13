package p284;

import java.util.Scanner;
public class p284 {
    Scanner a_tec = new Scanner(System.in);
    boolean a_DirInvalida = false;
    public static void main(String[] args) {
        p284 v_obj = new p284();
        v_obj.entrada();    
    }
    void entrada(){
        int v_cc, v_casos;
        v_casos = a_tec.nextInt();
        for (v_cc = 0; v_cc < v_casos; v_cc++) 
            ingCaso();
    }
    void ingCaso(){
        boolean v_extraviados = false, v_ban = true;
        Nodo v_aux = new Nodo(0,0,0,0,false);
        Lista v_lista = new Lista(v_aux);
        int v_cc, v_raiz;
        int[] v_nodos;
        String v_nodo;
        v_raiz = a_tec.nextInt();
        a_tec.nextLine();
        do{
            v_nodo = a_tec.nextLine();
            if(v_nodo.equals("0"))
                v_ban = false;
            else{
                v_nodos = validar(v_nodo);
                //System.out.println(v_nodos[0]+" "+v_nodos[1]+" "+v_nodos[2]+" "+v_nodos[3]);
                Nodo v_nueNodo = new Nodo(v_nodos[0],v_nodos[1],v_nodos[2],v_nodos[3],false);
                v_lista.insertarFinal(v_nueNodo);
            }
        }while(v_ban);
        recorrido(v_raiz, v_lista);
        if(!a_DirInvalida){
            for (v_cc = 0; v_cc < v_lista.get_Long(); v_cc++) {
                Nodo v_ax = v_lista.obtener(v_cc);
                //System.out.println(v_ax.getA_raiz()+" "+v_ax.getA_valor()+" "+v_ax.getA_izq()+" "+v_ax.getA_der()+" "+v_ax.isA_rec());
                if(v_ax.isA_rec() == false)
                    v_extraviados = true;
            }
            if(v_extraviados)
                System.out.println("MAL FORMADO NODO EXTRAVIADO");
            else
                System.out.println("BIEN FORMADO");
        }else
            System.out.println("MAL FORMADO DIRECCION INVALIDA");
        a_DirInvalida = false;
    }
    void recorrido(int p_raiz, Lista p_lista){
        if(get_Posi(p_raiz,p_lista) == -1)
            a_DirInvalida = true;
        else{
            Nodo v_raiz = p_lista.obtener(get_Posi(p_raiz,p_lista));
            v_raiz.setA_rec(true);
            if(v_raiz.getA_izq() != 0)
                recorrido(v_raiz.getA_izq(), p_lista);
            if(v_raiz.getA_der() != 0)
                recorrido(v_raiz.getA_der(), p_lista);
        }
    }
    int get_Posi(int p_valor, Lista p_lista){
        int v_posi = -1;
        for (int v_cc = 0; v_cc < p_lista.get_Long(); v_cc++)
            if(p_lista.obtener(v_cc).getA_raiz() == p_valor)
                v_posi = v_cc;
        return v_posi;
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
    class Nodo{
        private int a_raiz;
        private int a_valor;
        private int a_izq;
        private int a_der;
        private boolean a_rec;
        public Nodo(int a_raiz, int a_valor, int a_izq, int a_der, boolean a_rec) {
            this.a_raiz = a_raiz;
            this.a_valor = a_valor;
            this.a_izq = a_izq;
            this.a_der = a_der;
            this.a_rec = a_rec;
        }
        public boolean isA_rec() {
            return a_rec;
        }
        public void setA_rec(boolean a_rec) {
            this.a_rec = a_rec;
        }
        public int getA_raiz() {
            return a_raiz;
        }
        public int getA_izq() {
            return a_izq;
        }
        public int getA_der() {
            return a_der;
        }
    }
    class Lista{
        Lista a_cabeza;
        int a_longitud = 0;
        Lista a_sig = null;
        Nodo a_str;
        public Lista(Nodo p_str) {
            a_str = p_str;
        }
        void insertarFinal(Nodo p_str){
            Lista v_nuevoNodo = new Lista(p_str);  
            // Valida que la lista no este vacia
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
                    return v_puntero.a_str;
            }
        }
        int get_Long(){
            return a_longitud;
        }
    }
}