package p274;

import java.util.Scanner;
public class p274 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        p274 v_obj = new p274();
        v_obj.entrada();
    }
    void entrada(){
        String v_dato;
        String[] v_datos;
        v_dato = a_tec.nextLine();
        v_datos = validar(v_dato);
        Pila v_nodo = new Pila("x");
        calcular(v_datos, v_nodo, 0);
    }
    void calcular(String[] p_datos,Pila p_nodo,  int p_cont){
        if(p_cont < p_datos.length){
            int v_dato;
            v_dato = getDato(p_datos[p_cont]);
            if(p_cont == p_datos.length-1){
                if(v_dato == 1){
                    if(p_datos.length == 1)
                        System.out.println("OK");
                    else
                        System.out.println("FALTA OPERADOR");
                }else if(v_dato == 2){
                    if(p_nodo.get_long() == 2)
                        System.out.println("OK");
                    else
                        System.out.println("FALTA OPERANDO");
                }else if(v_dato == 3){
                    System.out.println("SIMBOLO DESCONOCIDO");
                }
            }else{
                if(v_dato == 1){
                    p_nodo.PUSH(p_datos[p_cont]);
                    calcular(p_datos, p_nodo, p_cont+1);
                }else if(v_dato == 2){
                    if(p_nodo.get_long() < 2){
                        System.out.println("FALTA OPERANDO");
                    }else{
                        p_nodo.POP();
                        calcular(p_datos, p_nodo, p_cont+1);
                    }
                }else if(v_dato == 3){
                    System.out.println("SIMBOLO DESCONOCIDO");
                }
            }
        }
    }
    int getDato(String p_dato){ // 1=num o letra 2=operador 3=desconocido
        if(valiletra(p_dato) || (valinum(p_dato)))
            return 1;
        else if(valiope(p_dato))
            return 2;
        else
            return 3;
    }
    boolean valiletra(String p_caracter){
        char v_caracter = p_caracter.toUpperCase().charAt(0);
        int v_valorASCII = (int) v_caracter;
        if (v_valorASCII != 165 && (v_valorASCII < 65 || v_valorASCII > 90))
            return false;
        else
            return true;
    }
    boolean valinum(String p_caracter){
        int v_aux;
        try {
            v_aux = Integer.parseInt(p_caracter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    boolean valiope(String p_caracter){
        if(p_caracter.equals("+") || p_caracter.equals("-") 
                || p_caracter.equals("*") || p_caracter.equals("/"))
            return true;
        else
            return false;
    }
    String[] validar(String p_dato){
        String[] v_datos = null;
        int v_con,v_con2;
        try {
            int v_cont = 0,v_cont2 = 0;
            String[] v_aux = p_dato.split(" ");
            for(v_con=0; v_con < v_aux.length; v_con++)
                if(!v_aux[v_con].equals(""))
                    v_cont++;
            v_datos = new String[v_cont];
            for(v_con2=0;v_con2<v_aux.length;v_con2++)
                if(!v_aux[v_con2].equals("")){
                    v_datos[v_cont2]= v_aux[v_con2];
                    v_cont2++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
    class Pila{
        Pila a_cabeza;
        int a_longitud = 0;
        public Pila a_sig = null;
        public String a_str;
        // Constructor que recibe el objeto a manipular
        public Pila(String p_str) {
            a_str = p_str;
        }
        void PUSH(String p_str){
            Pila v_nuevoNodo = new Pila(p_str);  
            // Valida que la lista no este vacia
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
        void POP(){
            if (a_cabeza != null && a_longitud != 1)
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
        int get_long(){
            return a_longitud;
        }
    }
}
