package lista.de.alumnos.ordenada;

import java.util.Scanner;
public class ListaDeAlumnosOrdenada {
    Scanner a_tec = new Scanner(System.in);
    Lista a_Lista;
    public static void main(String[] args) {
        ListaDeAlumnosOrdenada v_obj = new ListaDeAlumnosOrdenada();
        v_obj.entrada();
    }
    void entrada(){
        String[] v_aux = null;
        System.out.println("--- Instrucciones ---");
        System.out.println("Para ingresar un estudiante solo hace falta agregar\n"
                         + "nombre completo empezandopor apellidos y se agregara\n"
                         + "de manera Ordenda");
        System.out.println("Ejemplo: García Ramírez Luis David\n\n");
        Alumno v_ax = new Alumno("", "", v_aux);
        a_Lista = new Lista(v_ax); //Se inicializa
        while(true){
            menu();
        }
    }
    void menu(){
        int v_resp;
        System.out.println("1) Insertar Alumno");
        System.out.println("2) Eliminar Aumno");
        System.out.println("3) Ver Lista");
        System.out.println("4) Salir");
        System.out.print(">>");
        v_resp = a_tec.nextInt();
        if(v_resp == 1){
            System.out.println("Insertar");
            insertar();
        }else if(v_resp == 2){
            System.out.println("Eliminar");
            eliminar();
        }else if(v_resp == 3){
            System.out.println("Ver");
            eliminar();
        }else
            System.exit(0);
    }
    void insertar(){
        
    }
    void eliminar(){
        
    }
    void mostrar(){
        
    }
    int getPosi(String p_letra){
        int v_cc, v_posi = 0;
        char[] v_abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                        'n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (v_cc = 0; v_cc < v_abc.length; v_cc++) 
            if(p_letra.charAt(0) == v_abc[v_cc])
                v_posi = v_cc;
        return v_posi;
    }
    String getLetra(int p_posi){
        String[] v_abc = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                        "n","o","p","q","r","s","t","u","v","w","x","y","z"};
        return v_abc[p_posi].toUpperCase();
    }
    class Alumno{
        private String a_apPaterno;
        private String a_apMaterno;
        private String[] a_nombres;

        public Alumno(String a_apPaterno, String a_apMaterno, String[] a_nombres) {
            this.a_apPaterno = a_apPaterno;
            this.a_apMaterno = a_apMaterno;
            this.a_nombres = a_nombres;
        }

        public String getA_apPaterno() {
            return a_apPaterno;
        }

        public void setA_apPaterno(String a_apPaterno) {
            this.a_apPaterno = a_apPaterno;
        }

        public String getA_apMaterno() {
            return a_apMaterno;
        }

        public void setA_apMaterno(String a_apMaterno) {
            this.a_apMaterno = a_apMaterno;
        }

        public String[] getA_nombres() {
            return a_nombres;
        }

        public void setA_nombres(String[] a_nombres) {
            this.a_nombres = a_nombres;
        }
        
    }
    class Lista{
        Lista a_cabeza;
        int a_longitud = 0;
        Lista a_sig = null;
        public Alumno a_obj;
        // Constructor que recibe el objeto a manipular
        public Lista(Alumno p_obj) {
            a_obj = p_obj;
        }
        void insertarPrincipio(Alumno p_obj){
            Lista v_nuevoNodo = new Lista(p_obj);
            v_nuevoNodo.a_sig = a_cabeza;
            a_cabeza = v_nuevoNodo;
            a_longitud ++;
            System.out.println("Agregado con exito");
        }
        void insertarFinal(Alumno p_obj){
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
        void insertarXn(int p_num, Alumno p_obj){ // Posicion especifica
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
        Alumno obtener(int p_num){
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
