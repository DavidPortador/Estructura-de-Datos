package p274;

import java.util.Scanner;
public class p274 {
    Scanner a_tec = new Scanner(System.in);
    boolean a_ban = true;
    public static void main(String[] args) {
        p274 v_obj = new p274();
        v_obj.entrada();
    }
    void entrada(){
        boolean v_ban = true;
        String v_aux;
        String[] v_datos;
        do {
            try {
                v_aux = a_tec.nextLine();
                v_datos = validar(v_aux);
                Pila v_pila = new Pila("");
                calcular(v_pila, v_datos, 0);
                if(a_ban)
                    if(v_pila.get_Long() == 1)
                        System.out.println("OK");
                    else
                        System.out.println("FALTA OPERADOR");
                a_ban = true;
            } catch (Exception e) {
                v_ban = false;
            }
        } while (v_ban);
    }
    void calcular(Pila p_pila, String[] p_datos, int p_cont){
        if(getDato(p_datos[p_cont]) == 1){
            p_pila.PUSH(p_datos[p_cont]);
            p_cont ++;
            if(p_cont != p_datos.length)
                calcular(p_pila, p_datos, p_cont);
        }else if(getDato(p_datos[p_cont]) == 2)
            if(p_pila.get_Long() > 1){
                p_pila.POP();
                p_cont ++;
                if(p_cont != p_datos.length)
                    calcular(p_pila, p_datos, p_cont);
            }else{
                System.out.println("FALTA OPERANDO");
                a_ban = false;
            }
        else if(getDato(p_datos[p_cont]) == 3){
            System.out.println("SIMBOLO DESCONOCIDO");
            a_ban = false;
        }
    }
    int getDato(String p_dato){                 // 1 = num o letra 2 = operador 3 = desconocido
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
        int a_longitud = 0;
        Pila a_cabeza = null;
        Pila a_sig = null;
        String a_var;
        public Pila(String p_variable) {
            a_var = p_variable;
        }
        void PUSH(String p_variable){
            Pila v_nuevoNodo = new Pila(p_variable);  
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
        int get_Long(){
            return a_longitud;
        }
    }
}