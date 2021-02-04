package estructura.pkg1;

import java.util.Scanner;
public class listaFloat {
    // Declaracion de atributos
    Scanner a_tec = new Scanner(System.in);
    private Nodo a_cabeza;
    private int a_longitud = 0;
    // Contructor el cual recibe la cabeza de la estructura
    public listaFloat(classFloat p_flt) {
        Nodo v_nodo = new Nodo(p_flt);
        v_nodo.insertarPrincipio(p_flt);
        // Bucle que repite el menú y muestra la longitud, cabeza y cola de la estrucura
        while (true) {
            if (a_longitud < 1) {
                System.out.println("\nCabeza: null");
                System.out.println("Cola: null");
            } else {
                System.out.println("\nCabeza: " + v_nodo.obtener(0).getA_Float());
                if (a_longitud == 1)
                    System.out.println("Cola: null");
                else
                    System.out.println("Cola: " + v_nodo.obtener(a_longitud - 1).getA_Float());
            }
            System.out.println("Longitud: " + a_longitud);
            menu(v_nodo);
        }
    }

    // Valida la opcion dada y hace la accion correspondiente
    void menu(Nodo p_nodo) {
        int v_opc;
        float v_val;
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
                if (a_longitud < 1) 
                    System.out.println("No hay datos");
                else if (a_longitud == 1)
                    System.out.println("Solo exite el dato ["+ p_nodo.obtener(0).getA_Float() + "]");
                else {
                    System.out.println("Cabeza(0) a Cola(" + (a_longitud - 1) + ")");
                    while (v_dato < 0 || v_dato >= a_longitud)
                        v_dato = valiEntero("Obtener dato: ");
                    System.out.println("Dato (" + v_dato + ") tiene = "+ "[" + p_nodo.obtener(v_dato).getA_Float() + "]");
                }
                break;
            case 2:
                int v_cont;
                System.out.print("Estructura: (");
                for (v_cont = 0; v_cont < a_longitud; v_cont++) {
                    System.out.print(p_nodo.obtener(v_cont).getA_Float());
                    if (v_cont != a_longitud - 1)
                        System.out.print(", ");
                }
                System.out.println(")");
                break;
            case 3:
                a_tec.nextLine(); // Limpia el buffer para la entrada de datos
                v_val = valiFloat("Dato: ");
                classFloat v_inInicio = new classFloat(v_val);
                p_nodo.insertarPrincipio(v_inInicio);
                break;
            case 4:
                a_tec.nextLine(); // Limpia el buffer para la entrada de datos
                v_val = valiFloat("Dato: ");
                classFloat v_inFinal = new classFloat(v_val);
                p_nodo.insertarFinal(v_inFinal);
                break;
            case 5:
                int v_op = 0;
                if (a_longitud == 1) {
                    System.out.println("Solo existe un dato");
                    menu(p_nodo);
                } else {
                    System.out.println("Cabeza(0) a Cola(" + a_longitud + ")");
                    v_op = valiEntero("Insertar dato en la posicion:");
                    while (v_op < 0 || v_op > a_longitud)
                        v_op = valiEntero("Insertar dato en la posicion:");
                    a_tec.nextLine(); // Limpia el buffer 
                    v_val = valiFloat("Dato");
                    classFloat v_xn = new classFloat(v_val);
                    if (v_op == 0)
                        p_nodo.insertarPrincipio(v_xn);
                    else if (v_op == a_longitud)
                        p_nodo.insertarFinal(v_xn);
                    else
                        p_nodo.insertarXn(v_op - 1, v_xn);
                }
                break;
            case 6:
                if (a_longitud == 0) {
                    System.out.println("No hay datos");
                } else {
                    a_tec.nextLine(); // Limpia el buffer para la entrada de datos
                    System.out.print("Esta seguro de borrar la cabeza "
                            + "de la estructura[s/n]");
                    v_texto = a_tec.nextLine();
                    if (v_texto.equals("s") || v_texto.equals("S")) {
                        p_nodo.eliminarPrincipio();
                    } else {
                        System.out.println("No se borro el dato");
                    }
                }
                break;
            case 7:
                if (a_longitud < 2) {
                    if (a_longitud == 0) {
                        System.out.println("No hay datos");
                    } else {
                        System.out.println("Solo exite un dato");
                    }
                } else {
                    a_tec.nextLine(); // Limpia el buffer para la entrada de datos
                    System.out.print("Esta seguro de borrar la cola "
                            + "de la estructura[s/n]");
                    v_texto = a_tec.nextLine();
                    if (v_texto.equals("s") || v_texto.equals("S")) {
                        p_nodo.eliminarFinal();
                    } else {
                        System.out.println("No se borro el dato");
                    }
                }
                break;
            case 8:
                if (a_longitud < 2) {
                    if (a_longitud == 0) {
                        System.out.println("No hay datos");
                    } else {
                        System.out.println("Solo exite un dato");
                    }
                } else {
                    int v_aux = -1;
                    System.out.println("Cabeza(0) a Cola(" + (a_longitud - 1) + ")");
                    while (v_aux < 0 || v_aux >= a_longitud) {
                        v_aux = valiEntero("¿Qué dato deseas borrar?");
                    }
                    if (v_aux == 0) {
                        a_tec.nextLine(); // Limpia el buffer para la entrada de datos
                        System.out.print("Esta seguro de borrar la cabeza "
                                + "de la estructura[s/n]");
                        v_texto = a_tec.nextLine();
                        if (v_texto.equals("s") || v_texto.equals("S")) {
                            p_nodo.eliminarPrincipio();
                        } else {
                            System.out.println("No se borro el dato");
                        }
                    } else if (v_aux == (a_longitud - 1)) {
                        a_tec.nextLine(); // Limpia el buffer
                        System.out.print("Esta seguro de borrar la cola "
                                + "de la estructura[s/n]");
                        v_texto = a_tec.nextLine();
                        if (v_texto.equals("s") || v_texto.equals("S")) {
                            p_nodo.eliminarFinal();
                        } else {
                            System.out.println("No se borro el dato");
                        }
                    } else {
                        a_tec.nextLine(); // Limpia el buffer
                        System.out.print("Esta seguro de borrar el dato (" + v_aux
                                + ") de la estructura[s/n]");
                        v_texto = a_tec.nextLine();
                        if (v_texto.equals("s") || v_texto.equals("S")) {
                            p_nodo.eliminarXn(v_aux);
                        } else {
                            System.out.println("No se borro el dato");
                        }
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
    }

    // Validaciones
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

    float valiFloat(String p_texto) {
        float v_flt;
        while (true) {
            System.out.print(p_texto);
            try {
                v_flt = a_tec.nextFloat();
                break;
            } catch (Exception e) {
                System.out.println("No es flotante");
                a_tec = new Scanner(System.in);
            }
        }
        return v_flt;
    }

    // Se crea una clase local para el manejo de nodos
    private class Nodo {
        public Nodo a_sig = null;
        public classFloat a_ent;
        // Constructor que recibe el objeto a manipular
        public Nodo(classFloat p_flt) {
            a_ent = p_flt;
        }

        void insertarPrincipio(classFloat p_flt) {
            Nodo v_nuevoNodo = new Nodo(p_flt);
            v_nuevoNodo.a_sig = a_cabeza;
            a_cabeza = v_nuevoNodo;
            a_longitud++;
            System.out.println("Agregado con exito");
        }

        void insertarFinal(classFloat p_flt) {
            Nodo v_nuevoNodo = new Nodo(p_flt);
            // Valida que la lista no este vacia
            if (a_cabeza == null) {
                a_cabeza = v_nuevoNodo;
            } else {
                Nodo v_puntero = a_cabeza;
                while (v_puntero.a_sig != null) {
                    v_puntero = v_puntero.a_sig;
                }
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud++;
            System.out.println("Agregado con exito");
        }

        void insertarXn(int p_num, classFloat p_flt) { // Posicion especifica
            Nodo v_nuevoNodo = new Nodo(p_flt);
            // Valida que la lista no este vacia
            if (a_cabeza == null) {
                a_cabeza = v_nuevoNodo;
            } else {
                Nodo v_puntero = a_cabeza;
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

        classFloat obtener(int p_num) {
            if (a_cabeza == null) {
                return null;
            } else {
                Nodo v_puntero = a_cabeza;
                int v_cont = 0;
                while (v_cont < p_num && v_puntero.a_sig != null) {
                    v_puntero = v_puntero.a_sig;
                    v_cont++;
                }
                if (v_cont != p_num) {
                    return null;
                } else {
                    return v_puntero.a_ent;
                }
            }
        }

        void eliminarPrincipio() {
            if (a_cabeza != null) {
                Nodo v_primer = a_cabeza;
                a_cabeza = a_cabeza.a_sig;
                v_primer.a_sig = null;
                a_longitud--;
                System.out.println("*Se elimino la cabeza de la estructura*");
            } else {
                System.out.println("No existen datos");
            }
        }

        void eliminarFinal() {
            if (a_cabeza != null && a_longitud != 1) {
                if (a_cabeza.a_sig == null) {
                    a_cabeza = null;
                    a_longitud--;
                    System.out.println("*Se elimino la cola de la estructura*");
                } else {
                    Nodo v_puntero = a_cabeza;
                    while (v_puntero.a_sig.a_sig != null) {
                        v_puntero = v_puntero.a_sig;
                    }
                    v_puntero.a_sig = null;
                    a_longitud--;
                    System.out.println("*Se elimino la cola de la estructura*");
                }
            } else if (a_longitud == 1) {
                System.out.println("Solo existe un dato");
            } else {
                System.out.println("No existen datos");
            }

        }

        void eliminarXn(int p_num) {
            if (a_cabeza != null) {
                if (p_num == 0) {
                    Nodo v_primer = a_cabeza;
                    a_cabeza = a_cabeza.a_sig;
                    v_primer.a_sig = null;
                    a_longitud--;
                    System.out.println("*Se elimino el dato (" + p_num + ")*");
                } else if (p_num < a_longitud) {
                    int v_cont = 0;
                    Nodo v_puntero = a_cabeza;
                    while (v_cont < (p_num - 1)) {
                        v_puntero = v_puntero.a_sig;
                        v_cont++;
                    }
                    Nodo v_temp = v_puntero.a_sig;
                    v_puntero.a_sig = v_temp.a_sig;
                    v_temp.a_sig = null;
                    a_longitud--;
                    System.out.println("*Se elimino el dato (" + p_num + ")*");
                }
            }
        }
    }
}
