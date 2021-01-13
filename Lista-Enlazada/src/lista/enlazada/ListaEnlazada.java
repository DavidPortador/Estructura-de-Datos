package lista.enlazada;

public class ListaEnlazada {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    class Objeto{
        
    }
    class Lista{
        Lista a_cabeza;
        int a_longitud = 0;
        Lista a_sig = null;
        public Objeto a_obj;
        // Constructor que recibe el objeto a manipular
        public Lista(Objeto p_obj) {
            a_obj = p_obj;
        }
        void insertarPrincipio(Objeto p_obj){
            Lista v_nuevoNodo = new Lista(p_obj);
            v_nuevoNodo.a_sig = a_cabeza;
            a_cabeza = v_nuevoNodo;
            a_longitud ++;
            System.out.println("Agregado con exito");
        }
        void insertarFinal(Objeto p_obj){
            Lista v_nuevoNodo = new Lista(p_obj);  
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
            System.out.println("Agregado con exito");
        }
        void insertarXn(int p_num, Objeto p_obj){ // Posicion especifica
            Lista v_nuevoNodo = new Lista(p_obj);  
            // Valida que la lista no este vacia
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                Lista v_puntero = a_cabeza;
                int v_cont=0;
                while(v_cont < p_num && v_puntero.a_sig != null){
                    v_puntero = v_puntero.a_sig;
                    v_cont++;
                }
                v_nuevoNodo.a_sig = v_puntero.a_sig;
                v_puntero.a_sig=v_nuevoNodo;
            }
            a_longitud ++;
            System.out.println("Agregado con exito");
        }
        Objeto obtener(int p_num){
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
                System.out.println("*Se elimino la cabeza de la estructura*");
            }else
                System.out.println("No existen datos");
        }
        void eliminarFinal(){
            if (a_cabeza != null && a_longitud != 1)
                if(a_cabeza.a_sig == null){
                    a_cabeza = null;
                    a_longitud --;
                    System.out.println("*Se elimino la cola de la estructura*");
                }else{
                    Lista v_puntero = a_cabeza;
                    while(v_puntero.a_sig.a_sig != null){
                        v_puntero = v_puntero.a_sig;
                    }
                    v_puntero.a_sig = null;
                    a_longitud--; 
                    System.out.println("*Se elimino la cola de la estructura*");
                }
            else
                if(a_longitud == 1)
                    System.out.println("Solo existe un dato");
                else
                    System.out.println("No existen datos");
            
        }
        void eliminarXn(int p_num){
            if (a_cabeza != null)
                if (p_num == 0){
                    Lista v_primer = a_cabeza;
                    a_cabeza = a_cabeza.a_sig;
                    v_primer.a_sig = null;
                    a_longitud --;
                    System.out.println("*Se elimino el dato ("+p_num+")*");
                }else if (p_num < a_longitud){
                    int v_cont = 0;
                    Lista v_puntero = a_cabeza;
                    while (v_cont < (p_num - 1)){
                        v_puntero = v_puntero.a_sig;
                        v_cont ++;
                    }
                    Lista v_temp = v_puntero.a_sig;
                    v_puntero.a_sig = v_temp.a_sig;
                    v_temp.a_sig = null;
                    a_longitud --;
                    System.out.println("*Se elimino el dato ("+p_num+")*");
                }
        }
    }
}
