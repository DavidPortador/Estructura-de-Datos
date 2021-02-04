package lista.enlazada;

import java.util.Scanner;
public class ListaEnlazada {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        ListaEnlazada v_obj = new ListaEnlazada();
        v_obj.entrada();
    }

    void entrada() {
        Nodo v_aux = new Nodo("");
        Lista v_lista = new Lista(v_aux);
        while (true) {
            if (v_lista.getLong() < 1) {
                System.out.println("Cabeza: null");
                System.out.println("Tope: null");
            } else {
                System.out.println("\nCabeza: " + v_lista.obtener(0).getA_texto());
                if (v_lista.getLong() == 1)
                    System.out.println("Tope: null");
                else
                    System.out.println("Tope: " + v_lista.obtener(v_lista.getLong() - 1).getA_texto());
            }
            System.out.println("Longitud: " + v_lista.getLong());
            menu(v_lista);
        }
    }

    void menu(Lista p_lista) {
        int v_opc;
        String v_texto = null;
        System.out.println("--------Menú--------");
        System.out.println("1) Obtener dato especifico");
        System.out.println("2) Obtener Estructura COMPLETA");
        System.out.println("3) Insertar al inicio");
        System.out.println("4) Insertar al final");
        System.out.println("5) Insertar en Xn");
        System.out.println("6) Eliminar cabeza de la estructura");
        System.out.println("7) Eliminar cola de la estructura");
        System.out.println("8) Eliminar en Xn");
        System.out.println("9) Salir");
        v_opc = valiEntero("Opción: ");
        // Se valida y aplica la opcion dada
        switch (v_opc) {
            case 1:
                int v_dato = -1;
                if (p_lista.getLong() < 1)
                    System.out.println("No hay datos");
                else if (p_lista.getLong() == 1)
                    System.out.println("Solo exite el dato ["+ p_lista.obtener(0).getA_texto() + "]");
                else {
                    System.out.println("Cabeza(0) a Cola(" + (p_lista.getLong() - 1) + ")");
                    while (v_dato < 0 || v_dato >= p_lista.getLong())
                        v_dato = valiEntero("Obtener dato: ");
                    System.out.println("Dato (" + v_dato + ") tiene = "+ "[" + p_lista.obtener(v_dato).getA_texto() + "]");
                }
                break;
            case 2:
                int v_cont;
                System.out.print("Estructura: (");
                for (v_cont = 0; v_cont < p_lista.getLong(); v_cont++) {
                    System.out.print(p_lista.obtener(v_cont).getA_texto());
                    if (v_cont != p_lista.getLong() - 1)
                        System.out.print(", ");
                }
                System.out.println(")");
                break;
            case 3:
                a_tec.nextLine(); // Limpia el buffer para la entrada de datos
                System.out.print("Dato: ");
                v_texto = a_tec.nextLine();
                Nodo v_inInicio = new Nodo(v_texto);
                p_lista.insertarPrincipio(v_inInicio);
                break;
            case 4:
                a_tec.nextLine(); // Limpia el buffer para la entrada de datos
                System.out.print("Dato: ");
                v_texto = a_tec.nextLine();
                Nodo v_inFinal = new Nodo(v_texto);
                p_lista.insertarFinal(v_inFinal);
                break;
            case 5:
                int v_op = 0;
                if (p_lista.getLong() == 1) {
                    System.out.println("Solo existe un dato");
                    menu(p_lista);
                } else {
                    System.out.println("Cabeza(0) a Cola(" + p_lista.getLong() + ")");
                    v_op = valiEntero("Insertar dato en la posicion:");
                    while (v_op < 0 || v_op > p_lista.getLong())
                        v_op = valiEntero("Insertar dato en la posicion:");
                    a_tec.nextLine(); // Limpia el buffer 
                    System.out.print("Dato: ");
                    v_texto = a_tec.nextLine();
                    Nodo v_xn = new Nodo(v_texto);
                    if (v_op == 0)
                        p_lista.insertarPrincipio(v_xn);
                    else if (v_op == p_lista.getLong())
                        p_lista.insertarFinal(v_xn);
                    else
                        p_lista.insertarXn(v_op - 1, v_xn);
                }
                break;
            case 6:
                if (p_lista.getLong() == 0) {
                    System.out.println("No hay datos");
                } else {
                    a_tec.nextLine(); // Limpia el buffer para la entrada de datos
                    System.out.print("Esta seguro de borrar la cabeza "
                            + "de la estructura[s/n]");
                    v_texto = a_tec.nextLine();
                    if (v_texto.equals("s") || v_texto.equals("S"))
                        p_lista.eliminarPrincipio();
                    else
                        System.out.println("No se borro el dato");
                }
                break;
            case 7:
                if (p_lista.getLong() < 2) {
                    if (p_lista.getLong() == 0)
                        System.out.println("No hay datos");
                    else
                        System.out.println("Solo exite un dato");
                } else {
                    a_tec.nextLine(); // Limpia el buffer para la entrada de datos
                    System.out.print("Esta seguro de borrar la cola "
                            + "de la estructura[s/n]");
                    v_texto = a_tec.nextLine();
                    if (v_texto.equals("s") || v_texto.equals("S"))
                        p_lista.eliminarFinal();
                    else
                        System.out.println("No se borro el dato");
                }
                break;
            case 8:
                if (p_lista.getLong() < 2) {
                    if (p_lista.getLong() == 0)
                        System.out.println("No hay datos");
                    else
                        System.out.println("Solo exite un dato");
                } else {
                    int v_aux = -1;
                    System.out.println("Cabeza(0) a Cola(" + (p_lista.getLong() - 1) + ")");
                    while (v_aux < 0 || v_aux >= p_lista.getLong())
                        v_aux = valiEntero("¿Qué dato deseas borrar?");
                    if (v_aux == 0) {
                        a_tec.nextLine(); // Limpia el buffer para la entrada de datos
                        System.out.print("Esta seguro de borrar la cabeza "
                                + "de la estructura[s/n]");
                        v_texto = a_tec.nextLine();
                        if (v_texto.equals("s") || v_texto.equals("S"))
                            p_lista.eliminarPrincipio();
                        else
                            System.out.println("No se borro el dato");
                    } else if (v_aux == (p_lista.getLong() - 1)) {
                        a_tec.nextLine(); // Limpia el buffer
                        System.out.print("Esta seguro de borrar la cola "
                                + "de la estructura[s/n]");
                        v_texto = a_tec.nextLine();
                        if (v_texto.equals("s") || v_texto.equals("S"))
                            p_lista.eliminarFinal();
                        else
                            System.out.println("No se borro el dato");
                    } else {
                        a_tec.nextLine(); // Limpia el buffer
                        System.out.print("Esta seguro de borrar el dato (" + v_aux
                                + ") de la estructura[s/n]");
                        v_texto = a_tec.nextLine();
                        if (v_texto.equals("s") || v_texto.equals("S"))
                            p_lista.eliminarXn(v_aux);
                        else
                            System.out.println("No se borro el dato");
                    }
                }
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("Selecciones una opcion valida");
                break;
        }
        System.out.println("");
    }

    // Validación
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

    class Nodo {
        private String a_texto;
        public Nodo(String a_texto) {
            this.a_texto = a_texto;
        }

        public String getA_texto() {
            return a_texto;
        }

        public void setA_texto(String a_texto) {
            this.a_texto = a_texto;
        }

    }

    class Lista {
        Lista a_cabeza;
        int a_longitud = 0;
        Lista a_sig = null;
        public Nodo a_obj;
        // Constructor que recibe el objeto a manipular
        public Lista(Nodo p_obj) {
            a_obj = p_obj;
        }

        void insertarPrincipio(Nodo p_obj) {
            Lista v_nuevoNodo = new Lista(p_obj);
            v_nuevoNodo.a_sig = a_cabeza;
            a_cabeza = v_nuevoNodo;
            a_longitud++;
            System.out.println("Agregado con exito");
        }

        void insertarFinal(Nodo p_obj) {
            Lista v_nuevoNodo = new Lista(p_obj);
            // Valida que la lista no este vacia
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else {
                Lista v_puntero = a_cabeza;
                while (v_puntero.a_sig != null)
                    v_puntero = v_puntero.a_sig;
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud++;
            System.out.println("Agregado con exito");
        }

        void insertarXn(int p_num, Nodo p_obj) { // Posicion especifica
            Lista v_nuevoNodo = new Lista(p_obj);
            // Valida que la lista no este vacia
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else {
                Lista v_puntero = a_cabeza;
                int v_cont = 0;
                while (v_cont < p_num && v_puntero.a_sig != null) {
                    v_puntero = v_puntero.a_sig;
                    v_cont++;
                }
                v_nuevoNodo.a_sig = v_puntero.a_sig;
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud++;
            System.out.println("Agregado con exito");
        }

        Nodo obtener(int p_num) {
            if (a_cabeza == null)
                return null;
            else {
                Lista v_puntero = a_cabeza;
                int v_cont = 0;
                while (v_cont < p_num && v_puntero.a_sig != null) {
                    v_puntero = v_puntero.a_sig;
                    v_cont++;
                }
                if (v_cont != p_num)
                    return null;
                else
                    return v_puntero.a_obj;
            }
        }

        void eliminarPrincipio() {
            if (a_cabeza != null) {
                Lista v_primer = a_cabeza;
                a_cabeza = a_cabeza.a_sig;
                v_primer.a_sig = null;
                a_longitud--;
                System.out.println("*Se elimino la cabeza de la estructura*");
            } else
                System.out.println("No existen datos");
        }

        void eliminarFinal() {
            if (a_cabeza != null && a_longitud != 1)
                if (a_cabeza.a_sig == null) {
                    a_cabeza = null;
                    a_longitud--;
                    System.out.println("*Se elimino la cola de la estructura*");
                } else {
                    Lista v_puntero = a_cabeza;
                    while (v_puntero.a_sig.a_sig != null)
                        v_puntero = v_puntero.a_sig;
                    v_puntero.a_sig = null;
                    a_longitud--;
                    System.out.println("*Se elimino la cola de la estructura*");
                }
            else if (a_longitud == 1)
                System.out.println("Solo existe un dato");
            else
                System.out.println("No existen datos");
        }

        void eliminarXn(int p_num) {
            if (a_cabeza != null)
                if (p_num == 0) {
                    Lista v_primer = a_cabeza;
                    a_cabeza = a_cabeza.a_sig;
                    v_primer.a_sig = null;
                    a_longitud--;
                    System.out.println("*Se elimino el dato (" + p_num + ")*");
                } else if (p_num < a_longitud) {
                    int v_cont = 0;
                    Lista v_puntero = a_cabeza;
                    while (v_cont < (p_num - 1)) {
                        v_puntero = v_puntero.a_sig;
                        v_cont++;
                    }
                    Lista v_temp = v_puntero.a_sig;
                    v_puntero.a_sig = v_temp.a_sig;
                    v_temp.a_sig = null;
                    a_longitud--;
                    System.out.println("*Se elimino el dato (" + p_num + ")*");
                }
        }

        int getLong() {
            return a_longitud;
        }
    }
}
