package p282;

import java.util.Scanner;
public class p282 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        p282 v_obj = new p282();
        v_obj.entrada();
    }
    void entrada(){
        int v_casos;
        String v_dato;
        String[] v_datos;
        v_casos = a_tec.nextInt();
        if(v_casos>0 && v_casos<6){
            for (int v_con = 0; v_con < v_casos; v_con++) {
                v_dato = a_tec.next();
                v_datos = separar(v_dato);
                instrucciones(v_datos);
            }
        }
    }
    void instrucciones(String [] p_ins){
        String v_cadena="";
        objeto v_aux = new objeto("");
        Pila v_pila = new Pila(v_aux);
        Cola v_cola = new Cola(v_aux);
        for (int v_con = 0; v_con < p_ins.length; v_con++) {
            if(p_ins[v_con].equals("PU")){
                objeto v_pu = new objeto(p_ins[v_con+1]);
                v_pila.PUSH(v_pu);
            }else if(p_ins[v_con].equals("PO")){
                if(v_pila.get_Long()<1)
                    v_cadena+="##,";
                else{
                    v_cadena+=v_pila.obtener(v_pila.get_Long()-1).getV_dato()+",";
                    v_pila.POP();
                }
            }else if(p_ins[v_con].equals("LL")){
                objeto v_ll = new objeto(p_ins[v_con+1]);
                v_cola.Llega(v_ll);
            }else if(p_ins[v_con].equals("SA"))
                if(v_cola.get_Long()<1)
                    v_cadena+="$$,";
                else{
                    v_cadena+=v_cola.obtener(v_cola.get_Long()-1).getV_dato()+",";
                    v_cola.Sale();
                }
        }
        for (int v_con = 0; v_con < v_cola.get_Long(); v_con++) 
            v_cadena+=v_cola.obtener(v_con).getV_dato()+",";
        for (int v_con = 1; v_con < v_pila.get_Long()+1; v_con++) 
            v_cadena+=v_pila.obtener(v_pila.get_Long()-v_con).getV_dato()+",";
        System.out.println(v_cadena.substring(0, v_cadena.length()-1));
    }
    String[] separar(String p_dato){
        String [] v_datos;
        int v_cont = 0;
        if(p_dato.length()%2 == 0)
            v_datos = new String[p_dato.length()/2];
        else
            v_datos = new String[(p_dato.length()-1)/2];
        if(p_dato.length()%2 == 0)
            for (int v_con = 0; v_con < p_dato.length(); v_con+=2) {
                v_datos[v_cont] = p_dato.substring(v_con,v_con+2);
                v_cont++;
            }
        else
            for (int v_con = 0; v_con < p_dato.length()-1; v_con+=2) {
                v_datos[v_cont] = p_dato.substring(v_con,v_con+2);
                v_cont++;
            }
        return v_datos;
    }
}
class objeto{
    private String v_dato;
    public objeto(String v_dato) {
        this.v_dato = v_dato;
    }
    public String getV_dato() {
        return v_dato;
    }
}
class Cola{
    int a_longitud = 0;
    Cola a_cabeza = null;
    Cola a_sig = null;
    objeto a_var;
    public Cola(objeto p_var) {
        a_var = p_var;
    }
    void Llega(objeto p_var){
        Cola v_nuevoCola = new Cola(p_var);
        if (a_cabeza == null)
            a_cabeza = v_nuevoCola;
        else{
            Cola v_puntero = a_cabeza;
            while(v_puntero.a_sig != null){
                v_puntero = v_puntero.a_sig;
            }
            v_puntero.a_sig = v_nuevoCola;
        }
        a_longitud ++;
    }
    objeto obtener(int p_num){
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
                return v_puntero.a_var;
        }
    }
    void Sale(){
        if (a_cabeza != null && a_longitud > 0)
            if(a_cabeza.a_sig == null){
                a_cabeza = null;
                a_longitud --;
            }else{
                Cola v_puntero = a_cabeza;
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
class Pila{
    int a_longitud = 0;
    Pila a_cabeza = null;
    Pila a_sig = null;
    objeto a_var;
    public Pila(objeto p_var) {
        a_var = p_var;
    }
    void PUSH(objeto p_var){
        Pila v_nuevoPila = new Pila(p_var);
        if (a_cabeza == null)
            a_cabeza = v_nuevoPila;
        else{
            Pila v_puntero = a_cabeza;
            while(v_puntero.a_sig != null){
                v_puntero = v_puntero.a_sig;
            }
            v_puntero.a_sig = v_nuevoPila;
        }
        a_longitud ++;
    }
    objeto obtener(int p_num){
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
                return v_puntero.a_var;
        }
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
