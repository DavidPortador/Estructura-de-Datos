package colas;

import java.util.Scanner;
public class Colas {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        Colas v_obj = new Colas();
        v_obj.entrada();
    }

    void entrada() {
        int v_opc, v_num;
        objeto v_aux = new objeto(0);
        Cola v_nodo = new Cola(v_aux);
        // Se crea el nodo y se utiliza un objeto auxiliar para manejarlo cuando aun no se le agregan datos
        while (true) {
            v_opc = valiEntero("\n----- Menu -----\n"
                    + "1)IN (agregar)\n"
                    + "2)OUT (eliminar)\n"
                    + "3)Mostar Cola\n"
                    + "4)Salir\n"
                    + "Opcion: ");
            if (v_opc == 1) {
                v_num = valiEntero("Agregar: ");
                objeto v_obj = new objeto(v_num);
                v_nodo.IN(v_obj);
            } else if (v_opc == 2)
                v_nodo.OUT();
            else if (v_opc == 3)
                if (v_nodo.getLong() > 0) 
                    for (int i = 0; i < v_nodo.getLong(); i++)
                        System.out.println(v_nodo.obtener(i).getVariable());
                else
                    System.out.println("No existen datos");
            else if (v_opc == 4)
                System.exit(0);
            else 
                System.out.println("Opcion incorrecta");
        }
    }

    int valiEntero(String p_texto) {
        int v_num;
        while (true) {
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

    class objeto {
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

    private class Cola {
        private Cola a_cabeza;
        private int a_longitud = 0;
        public Cola a_sig = null;
        public objeto a_str;

        // Constructor que recibe el objeto a manipular
        public Cola(objeto p_str) {
            a_str = p_str;
        }

        void IN(objeto p_str) {
            Cola v_nuevoNodo = new Cola(p_str);
            // Valida que la lista no este vacia
            if (a_cabeza == null) {
                a_cabeza = v_nuevoNodo;
            } else {
                Cola v_puntero = a_cabeza;
                while (v_puntero.a_sig != null) 
                    v_puntero = v_puntero.a_sig;
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud++;
            System.out.println("Agregado con exito");
        }

        objeto obtener(int p_num) {
            if (a_cabeza == null) {
                return null;
            } else {
                Cola v_puntero = a_cabeza;
                int v_cont = 0;
                while (v_cont < p_num && v_puntero.a_sig != null) {
                    v_puntero = v_puntero.a_sig;
                    v_cont++;
                }
                if (v_cont != p_num) 
                    return null;
                else
                    return v_puntero.a_str;
            }
        }

        void OUT() {
            if (a_cabeza != null) {
                Cola v_primer = a_cabeza;
                a_cabeza = a_cabeza.a_sig;
                v_primer.a_sig = null;
                a_longitud--;
                System.out.println("*Se elimino la cabeza de la estructura*");
            } else
                System.out.println("No existen datos");
        }

        int getLong() {
            return a_longitud;
        }
    }
}
