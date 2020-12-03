package p2822;

import java.util.Scanner;
public class p2822 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        p2822 v_obj = new p2822();
        v_obj.entrada();
    }
    void entrada(){
        int v_cc,v_casos;
        v_casos = casos();
        for (v_cc = 0;v_cc  < v_casos;v_cc ++) 
            calcular();
    }
    int casos(){
        int v_casos;
        v_casos = a_tec.nextInt();
        a_tec.nextLine();
        if(v_casos > 0 && v_casos < 6)
            return v_casos;
        else
            return 0;
    }
    String[] separar(String p_dato){
        int v_cc,v_cont=0;
        String [] v_datos;
        if(p_dato.length() % 2 == 0){
            v_datos = new String[(p_dato.length() + 1) / 2];
            for (v_cc = 0;v_cc  < p_dato.length();v_cc += 2) {
                v_datos[v_cont] = p_dato.substring(v_cc, v_cc + 2);
                v_cont ++;
            }
        }else{
            v_datos = new String[p_dato.length() / 2];
            for (v_cc = 0;v_cc  < p_dato.length()-1;v_cc += 2) {
                v_datos[v_cont] = p_dato.substring(v_cc, v_cc + 2);
                v_cont ++;
            }
        }
        return v_datos;
    }
    void calcular(){
        int v_cc;
        String v_dato, v_resultado = "";
        String[] v_datos;
        v_dato = a_tec.nextLine();
        v_datos = separar(v_dato);
        Pila v_auxP = new Pila("");
        Cola v_auxC = new Cola("");
        for (v_cc = 0;v_cc  < v_datos.length;v_cc ++) {
            if(v_datos[v_cc].equals("PU"))
                v_auxP.PUSH(v_datos[v_cc+1]);
            else if(v_datos[v_cc].equals("PO")){
                if(v_auxP.get_Long()<1)
                    v_resultado += "##,";
                else{
                    v_resultado += (v_auxP.obtener(v_auxP.get_Long()-1)+",");
                    v_auxP.POP();
                }
            }else if(v_datos[v_cc].equals("LL"))
                v_auxC.LL(v_datos[v_cc+1]);
            else if(v_datos[v_cc].equals("SA")){
                if(v_auxC.get_Long() < 1)
                    v_resultado += "$$,";
                else{
                    v_resultado += (v_auxC.obtener(0)+",");
                    v_auxC.SA();
                }
            }
        }
        if(v_auxC.get_Long() > 0){
            int v_cc3;
            for (v_cc3 = 0;v_cc3  < v_auxC.get_Long();v_cc3 ++) 
                v_resultado += (v_auxC.obtener(v_cc3)+",");
        }
        if(v_auxP.get_Long() > 0){
            int v_cc2,v_cont=0;
            for (v_cc2 = 0;v_cc2  < v_auxP.get_Long();v_cc2 ++) {
                v_cont++;
                v_resultado += (v_auxP.obtener(v_auxP.get_Long()-v_cont)+",");
            }
        }
        System.out.println(v_resultado.substring(0, v_resultado.length()-1));
    }
    class Pila{
        private Pila a_cabeza;
        private int a_longitud = 0;
        public Pila a_sig = null;
        public String a_str;
        public Pila(String p_str) {
            a_str = p_str;
        }
        void PUSH(String p_str){
            Pila v_nuevoNodo = new Pila(p_str);
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                Pila v_puntero = a_cabeza;
                while(v_puntero.a_sig != null){
                    v_puntero = v_puntero.a_sig;
                }
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud ++;
        }
        void POP(){
            if (a_cabeza != null && a_longitud > 0)
                if(a_cabeza.a_sig == null){
                    a_cabeza = null;
                    a_longitud --;
                }else{
                    Pila v_puntero = a_cabeza;
                    while(v_puntero.a_sig.a_sig != null){
                        v_puntero = v_puntero.a_sig;
                    }
                    v_puntero.a_sig = null;
                    a_longitud--; 
                }
        }
        String obtener(int p_num){
            if (a_cabeza == null)
                return null;
            else{
                Pila v_puntero = a_cabeza;
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
    class Cola{
        private Cola a_cabeza;
        private int a_longitud = 0;
        public Cola a_sig = null;
        public String a_str;
        public Cola(String p_str) {
            a_str = p_str;
        }
        void LL(String p_str){
            Cola v_nuevoNodo = new Cola(p_str);
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                Cola v_puntero = a_cabeza;
                while(v_puntero.a_sig != null){
                    v_puntero = v_puntero.a_sig;
                }
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud ++;
        }
        void SA(){
            if (a_cabeza != null){
                Cola v_primer = a_cabeza;
                a_cabeza = a_cabeza.a_sig;
                v_primer.a_sig = null;
                a_longitud--;
            }
        }
        String obtener(int p_num){
            if (a_cabeza == null)
                return null;
            else{
                Cola v_puntero = a_cabeza;
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