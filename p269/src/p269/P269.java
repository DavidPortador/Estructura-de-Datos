package p269;
/*
    10
    POP
    PUSH 20
    PUSH 30
    POP
    PUSH 19
    PUSH 10
    FREE
*/

import java.util.Scanner;
public class P269 {
    Scanner a_tec = new Scanner(System.in);
    int a_cont;
    public static void main(String[] args) {
        P269 v_obj = new P269();
        v_obj.entrada();
    }
    void entrada(){
        try {
            a_cont = a_tec.nextInt();
            a_tec.nextLine();
            objeto v_aux = new objeto(0);
            Nodo v_nodo = new Nodo(v_aux);
            while(true)
                clasificacion(v_nodo);
        } catch (Exception e) {
        }
    }
    void clasificacion(Nodo p_nodo){
        String v_dato;
        int v_aux,v_cont,v_cont2;
        String[] v_auxdato;
        v_dato = a_tec.nextLine();
        v_auxdato = validar(v_dato);
        if(v_auxdato.length>1){
            if(v_auxdato[0].equals("PUSH")){
                try {
                    v_aux = Integer.parseInt(v_auxdato[1]);
                    if(v_aux>0 && v_aux<100){
                        if(p_nodo.get_Long()<a_cont){
                            objeto v_obj = new objeto(v_aux);
                            p_nodo.PUSH(v_obj);
                        }else{
                            System.out.println("OVERFLOW "+v_aux);
                        }
                    }else{
                        System.out.println("PUSH ERRONEO "+v_aux);
                    }
                } catch (Exception e) {
                }
            }
        }else{
            if(v_auxdato[0].equals("FREE")){
                if(p_nodo.valiUnder()){
                    System.out.println("UNDERFLOW");
                }else{
                    v_cont2=p_nodo.get_Long()-1;
                    for(v_cont=0;v_cont<p_nodo.get_Long();v_cont++){
                        System.out.println(p_nodo.obtener(v_cont2-v_cont).getA_valor());
                        //p_nodo.POP();
                    }
                    //System.out.println(p_nodo.obtener(0).getA_valor());
                    //p_nodo.POP();
                    System.exit(0);
                }
            }else if(v_auxdato[0].equals("POP")){
                if(p_nodo.valiUnder()){
                    System.out.println("UNDERFLOW");
                }else{
                    System.out.println(p_nodo.obtener(p_nodo.get_Long()-1).getA_valor());
                    p_nodo.POP();
                }
            }
        }
    }
    String[] validar(String p_dato){
        String[] v_datos = null;
        try {
            int v_cont=0,v_cont2=0;
            String[] v_aux = p_dato.split(" ");
            for(int j=0;j<v_aux.length;j++)
                if(!v_aux[j].equals(""))
                    v_cont++;
            v_datos = new String[v_cont];
            for(int k=0;k<v_aux.length;k++)
                if(!v_aux[k].equals("")){
                    v_datos[v_cont2]= v_aux[k];
                    v_cont2++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
    class objeto{
        private int a_valor;

        public objeto(int a_valor) {
            this.a_valor = a_valor;
        }

        public int getA_valor() {
            return a_valor;
        }
        
    }
    class Nodo{
        int a_longitud = 0;
        Nodo a_cabeza = null;
        Nodo a_sig = null;
        objeto a_var;
        public Nodo(objeto p_var) {
            a_var = p_var;
        }
        void PUSH(objeto p_var){
            Nodo v_nuevoNodo = new Nodo(p_var);  
            // Valida que la lista no este vacia
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                Nodo v_puntero = a_cabeza;
                while(v_puntero.a_sig != null){
                    v_puntero = v_puntero.a_sig;
                }
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud ++;
        }
        objeto obtener(int p_num){
            if (a_cabeza == null)
                return null;
            else{
                Nodo v_puntero = a_cabeza;
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
                    Nodo v_puntero = a_cabeza;
                    while(v_puntero.a_sig.a_sig != null){
                        v_puntero = v_puntero.a_sig;
                    }
                    v_puntero.a_sig = null;
                    a_longitud--; 
                }
            else
                System.out.println("No existen datos");
        }
        int get_Long(){
            return a_longitud;
        }
        boolean valiUnder(){
            boolean v_badera;
            if(a_longitud<1)
                return true;
            else
                return false;
        }
    }
}
