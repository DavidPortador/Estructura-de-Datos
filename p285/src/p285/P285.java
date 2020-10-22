package p285;

import java.util.Scanner;

public class P285 {
    Scanner a_tec = new Scanner(System.in);
    private Nodo a_cabeza;
    private int a_longitud = 0;
    public static void main(String[] args) {
        P285 v_obj = new P285();
        v_obj.entrada();
    }
    void entrada(){
        int v_datos;
        v_datos = valiEntrada();
        a_tec.nextLine();
        for(int i=0;i<v_datos;i++){
            arbol();
        }
    }
    void arbol(){
        String v_dato;
        int[] v_datos;
        v_dato = a_tec.nextLine();
        v_datos = validar(v_dato);
        Celda v_ini = new Celda(1,v_datos[0],0,0);
        Nodo v_nodo = new Nodo(v_ini);
        v_nodo.insertarPrincipio(v_ini);
        llenarNodos(v_nodo,v_datos,1);
        validarNodos(v_nodo);
    }
    void validarNodos(Nodo p_nodo){
        for(int i=0;i<a_longitud;i++){
            System.out.println(p_nodo.obtener(i).getA_conta()+" "+p_nodo.obtener(i).getA_valor()+" "+p_nodo.obtener(i).getA_menor()+" "+p_nodo.obtener(i).getA_mayor());
            if(i==0){
                
            }else{
                if(p_nodo.obtener(i).getA_menor()==0){
                    for(int k=0;k<i;k++){
                        System.out.println("--"+p_nodo.obtener(k).getA_valor());
                    }
                } 
            }
        }
    }
    void llenarNodos(Nodo p_nodo,int[] p_datos,int p_aux){
        if(p_aux<p_datos.length){
            Celda v_aux = new Celda(1,p_datos[p_aux],0,0);
            p_nodo.insertarFinal(v_aux);
            p_aux++;
            llenarNodos(p_nodo,p_datos,p_aux);
        }
    }
    int[] validar(String p_dato){
        int[] v_datos = null;
        try {
            int v_cont=0,v_cont2=0;
            String[] v_aux = p_dato.split(" ");
            for(int j=0;j<v_aux.length;j++)
                if(!v_aux[j].equals(""))
                    v_cont++;
            v_datos = new int[v_cont];
            for(int k=0;k<v_aux.length;k++)
                if(!v_aux[k].equals("")){
                    v_datos[v_cont2]= Integer.parseInt(v_aux[k]);
                    v_cont2++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
    int valiEntrada(){
        int v_num=0;
        try {
            v_num = a_tec.nextInt();
            if(v_num<0 || v_num>5)
                v_num=0;
        } catch (Exception e) {
        }
        return v_num;
    }
    class Celda{
        private int a_conta;
        private int a_valor;
        private int a_menor;
        private int a_mayor;

        public Celda(int a_conta, int a_valor, int a_menor, int a_mayor) {
            this.a_conta = a_conta;
            this.a_valor = a_valor;
            this.a_menor = a_menor;
            this.a_mayor = a_mayor;
        }

        public int getA_conta() {
            return a_conta;
        }

        public void setA_conta(int a_conta) {
            this.a_conta = a_conta;
        }

        public int getA_valor() {
            return a_valor;
        }

        public void setA_valor(int a_valor) {
            this.a_valor = a_valor;
        }

        public int getA_menor() {
            return a_menor;
        }

        public void setA_menor(int a_menor) {
            this.a_menor = a_menor;
        }

        public int getA_mayor() {
            return a_mayor;
        }

        public void setA_mayor(int a_mayor) {
            this.a_mayor = a_mayor;
        }
        
    }
    private class Nodo{
        public Nodo a_sig = null;
        public Celda a_celda;
        public Nodo(Celda p_int) {
            a_celda = p_int;
        }
        void insertarPrincipio(Celda p_int){
            Nodo v_nuevoNodo = new Nodo(p_int);
            v_nuevoNodo.a_sig = a_cabeza;
            a_cabeza = v_nuevoNodo;
            a_longitud ++;
            System.out.println("Agregado con exito");
        }
        void insertarFinal(Celda p_int){
            Nodo v_nuevoNodo = new Nodo(p_int);  
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
        void insertarXn(int p_num, Celda p_int){ // Posicion especifica
            Nodo v_nuevoNodo = new Nodo(p_int);  
            // Valida que la lista no este vacia
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                Nodo v_puntero = a_cabeza;
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
        Celda obtener(int p_num){
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
                    return v_puntero.a_celda;
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
        void eliminarFinal(){
            if (a_cabeza != null && a_longitud != 1)
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
                if(a_longitud == 1)
                    System.out.println("Solo existe un dato");
                else
                    System.out.println("No existen datos");
            
        }
        void eliminarXn(int p_num){
            if (a_cabeza != null)
                if (p_num == 0){
                    Nodo v_primer = a_cabeza;
                    a_cabeza = a_cabeza.a_sig;
                    v_primer.a_sig = null;
                    a_longitud --;
                    System.out.println("*Se elimino el dato ("+p_num+")*");
                }else if (p_num < a_longitud){
                    int v_cont = 0;
                    Nodo v_puntero = a_cabeza;
                    while (v_cont < (p_num - 1)){
                        v_puntero = v_puntero.a_sig;
                        v_cont ++;
                    }
                    Nodo v_temp = v_puntero.a_sig;
                    v_puntero.a_sig = v_temp.a_sig;
                    v_temp.a_sig = null;
                    a_longitud --;
                    System.out.println("*Se elimino el dato ("+p_num+")*");
                }
        }
    }
}
