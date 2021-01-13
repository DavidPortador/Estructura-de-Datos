package p293;

import java.util.Scanner;
public class p293 {
    Scanner a_tec = new Scanner(System.in);
    String a_resul = "";
    public static void main(String[] args) {
        p293 v_obj = new p293();
        v_obj.casos();
    }
    void casos(){
        int v_casos, v_cc;
        v_casos = a_tec.nextInt();
        a_tec.nextLine();
        for (v_cc = 0; v_cc < v_casos; v_cc++){
            entrada();
            a_resul = "";
        }
    }
    void entrada(){
        int v_cont;
        String v_aux, v_dato = "";
        String[] v_datos;
        TDA v_bipolar = new TDA("");
        while(!v_dato.equals("FINISH")){
            v_dato = a_tec.nextLine();
            v_datos = v_dato.split(" ");
            if(v_datos.length == 2){ // insertar
                if(v_datos[0].equals("PUSH")) //pila
                    v_bipolar.insertarFinal(v_datos[1]);
                else if(v_datos[0].equals("IN")) //cola
                    v_bipolar.insertarFinal(v_datos[1]);
                else if(v_datos[0].equals("INSERT")){ //lista
                    int v_posi = v_bipolar.recorrido(Integer.parseInt(v_datos[1]));
                    if(v_posi == 0)
                        v_bipolar.insertarPrincipio(v_datos[1]);
                    else
                        v_bipolar.insertarXn(v_posi-1, v_datos[1]);
                }else if(v_datos[0].equals("REMOVE")){ //eliminar
                    int v_posi = v_bipolar.remove(Integer.parseInt(v_datos[1]));
                    if(v_bipolar.get_Long() == 0)
                        a_resul += "NO DATA, ";
                    else
                        if(v_posi == -1)
                            a_resul += "NO DATA, ";
                        else if(v_posi == v_bipolar.get_Long())
                            a_resul += "NO DATA, ";
                        else{
                            a_resul += v_bipolar.obtener(v_posi)+", ";
                            v_bipolar.eliminarXn(v_posi);
                        }
                }
            }else if(v_datos.length == 1) //eliminar
                if(v_datos[0].equals("POP"))
                    if(v_bipolar.get_Long() == 0)
                        a_resul += "UNDERFLOW, ";
                    else{
                        a_resul += v_bipolar.obtener(v_bipolar.get_Long()-1)+", ";
                        v_bipolar.eliminarFinal();
                    }
                else if(v_datos[0].equals("OUT"))
                    if(v_bipolar.get_Long() == 0)
                        a_resul += "UNDERFLOW, ";
                    else{
                        a_resul += v_bipolar.obtener(0)+", ";
                        v_bipolar.eliminarPrincipio();
                    }
        }
        if(a_resul.equals(""))
            System.out.println("****");
        else
            System.out.println(a_resul+"****");
    }
    private class TDA{
        TDA a_cabeza;
        int a_longitud = 0;
        public TDA a_sig = null;
        public String a_str;
        public TDA(String p_str) {
            a_str = p_str;
        }
        void insertarPrincipio(String p_str){
            TDA v_nuevoNodo = new TDA(p_str);
            v_nuevoNodo.a_sig = a_cabeza;
            a_cabeza = v_nuevoNodo;
            a_longitud ++;
        }
        void insertarFinal(String p_str){
            TDA v_nuevoNodo = new TDA(p_str);
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                TDA v_puntero = a_cabeza;
                while(v_puntero.a_sig != null)
                    v_puntero = v_puntero.a_sig;
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud ++;
        }
        void insertarXn(int p_num, String p_str){
            TDA v_nuevoNodo = new TDA(p_str);
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                TDA v_puntero = a_cabeza;
                int v_cont=0;
                while(v_cont < p_num && v_puntero.a_sig != null){
                    v_puntero = v_puntero.a_sig;
                    v_cont++;
                }
                v_nuevoNodo.a_sig = v_puntero.a_sig;
                v_puntero.a_sig=v_nuevoNodo;
            }
            a_longitud ++;
        }
        String obtener(int p_num){
            if (a_cabeza == null)
                return null;
            else{
                TDA v_puntero = a_cabeza;
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
        void eliminarPrincipio(){
            if (a_cabeza != null){
                TDA v_primer = a_cabeza;
                a_cabeza = a_cabeza.a_sig;
                v_primer.a_sig = null;
                a_longitud--;
            }
        }
        void eliminarFinal(){
            if (a_cabeza != null && a_longitud != 1)
                if(a_cabeza.a_sig == null){
                    a_cabeza = null;
                    a_longitud --;
                }else{
                    TDA v_puntero = a_cabeza;
                    while(v_puntero.a_sig.a_sig != null)
                        v_puntero = v_puntero.a_sig;
                    v_puntero.a_sig = null;
                    a_longitud--;
                }
        }
        void eliminarXn(int p_num){
            if (a_cabeza != null)
                if (p_num == 0){
                    TDA v_primer = a_cabeza;
                    a_cabeza = a_cabeza.a_sig;
                    v_primer.a_sig = null;
                    a_longitud --;
                }else if (p_num < a_longitud){
                    int v_cont = 0;
                    TDA v_puntero = a_cabeza;
                    while (v_cont < (p_num - 1)){
                        v_puntero = v_puntero.a_sig;
                        v_cont ++;
                    }
                    TDA v_temp = v_puntero.a_sig;
                    v_puntero.a_sig = v_temp.a_sig;
                    v_temp.a_sig = null;
                    a_longitud --;
                }
        }
        int get_Long(){
            return a_longitud;
        }
        int recorrido(int p_real){
            boolean v_ban = true;
            int v_cont = 0;
            int v_nodo;
            while(v_cont < get_Long() && v_ban){
                v_nodo = Integer.parseInt(obtener(v_cont));
                if(v_nodo < p_real)
                    v_cont++;
                else if(v_nodo > p_real)
                    v_ban = false;
            }
            return v_cont;
        }
        int remove(int p_rem){
            boolean v_ban = true;
            int v_cont = 0;
            int v_nodo;
            while(v_cont < get_Long() && v_ban){
                v_nodo = Integer.parseInt(obtener(v_cont));
                if(p_rem == v_nodo)
                    v_ban = false;
                else if(p_rem > v_nodo)
                    v_cont ++;
                else{
                    v_cont = -1;
                    v_ban = false;
                }
            }
            return v_cont;
        }
    }
}