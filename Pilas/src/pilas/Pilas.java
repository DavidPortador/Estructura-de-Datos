package pilas;
import java.util.Scanner;

public class Pilas {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        Pilas v_obj = new Pilas();
        v_obj.entrada();
    }
    void entrada(){
        int v_opc,v_num;
        objeto v_aux = new objeto(0); 
        Nodo v_nodo = new Nodo(v_aux);
        // Se crea el nodo y se utiliza un objeto auxiliar para manejarlo cuando aun no se le agregan datos
        while(true){
            v_opc = valiEntero("\n----- Menu -----\n"
                + "1)POP (agregar)\n"
                + "2)PUSH (eliminar)\n"
                + "3)Mostar Pila\n"
                + "4)Salir\n"
                + "Opcion: ");
            if(v_opc==1){
                v_num = valiEntero("Agregar: ");
                objeto v_obj = new objeto(v_num);
                v_nodo.PUSH(v_obj);
            }else if(v_opc==2){
                v_nodo.POP();
            }else if(v_opc==3){
                if(v_nodo.get_Long()>0){
                    for(int i=0;i<v_nodo.get_Long();i++){
                        System.out.println(v_nodo.obtener(i).getVariable());
                    }
                }else
                    System.out.println("No existen datos");
            }else if(v_opc==4){
                System.exit(0);
            }else{
                System.out.println("Opcion incorrecta");
            }
        }
    }
    int valiEntero(String p_texto){
        int v_num;
        while(true){
            System.out.print(p_texto);
            try {
                v_num = a_tec.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("No es entero");
                a_tec = new Scanner(System.in);
            }
        }
        return v_num;
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
    class Nodo{
        int a_longitud = 0;
        Nodo a_cabeza = null;
        Nodo a_sig = null;
        objeto a_var;
        public Nodo(objeto p_variable) {
            a_var = p_variable;
        }
        
        void PUSH(objeto p_variable){
            Nodo v_nuevoNodo = new Nodo(p_variable);  
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
                    return v_puntero.a_var;
            }
        }
        
        void POP(){
            if (a_cabeza != null && a_longitud > 0)
                if(a_cabeza.a_sig == null){
                    a_cabeza = null;
                    a_longitud --;
                    System.out.println("*Se elimino la cola de la estructura*");
                }else{
                    Nodo v_puntero = a_cabeza;
                    while(v_puntero.a_sig.a_sig != null){
                        v_puntero = v_puntero.a_sig;
                    }
                    v_puntero.a_sig = null;
                    a_longitud--; 
                    System.out.println("*Se elimino la cola de la estructura*");
                }
            else
                System.out.println("No existen datos");
        }
        
        int get_Long(){
            return a_longitud;
        }
    }
}
