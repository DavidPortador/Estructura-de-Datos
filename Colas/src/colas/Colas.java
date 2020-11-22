package colas;

public class Colas {

    public static void main(String[] args) {
        
    }
    class objeto{
        private int variable;
        public objeto(int variable) {
            this.variable = variable;
        }
        public int getVariable() {
            return variable;
        }
        public void setVariable(int variable) {
            this.variable = variable;
        }
    }
    private class Nodo{
        private Nodo a_cabeza;
        private int a_longitud = 0;
        public Nodo a_sig = null;
        public objeto a_str;
        // Constructor que recibe el objeto a manipular
        public Nodo(objeto p_str) {
            a_str = p_str;
        }
        void insertarFinal(objeto p_str){
            Nodo v_nuevoNodo = new Nodo(p_str);  
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
            System.out.println("Agregado con exito");
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
                    return v_puntero.a_str;
            }
        }
        void eliminarPrincipio(){
            if (a_cabeza != null){
                Nodo v_primer = a_cabeza;
                a_cabeza = a_cabeza.a_sig;
                v_primer.a_sig = null;
                a_longitud--;
                System.out.println("*Se elimino la cabeza de la estructura*");
            }else
                System.out.println("No existen datos");
        }
    }
}
