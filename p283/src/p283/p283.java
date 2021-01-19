package p283;
/*
1
3
4 20 5 25 4 45
7 6 5 15 2 4 8 1 2 9 4 15 3 8 0
*/
import java.util.Scanner;
public class p283 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        p283 v_obj = new p283();
        v_obj.entrada();
    }
    void entrada(){
        int v_cc,v_casos;
        v_casos = a_tec.nextInt();
        a_tec.nextLine();
        if(v_casos > 0 && v_casos < 6)
            for (v_cc = 0; v_cc < v_casos; v_cc++) 
                separar();
    }
    void separar(){
        int[] v_pesos,v_duplas;
        TDA v_ordenados;
        barco[] v_barcos;
        // Se separan
        v_duplas = separarBarcos();
        v_pesos = separarPesos();
        // Se ordenan
        v_ordenados = CO_ordenar(v_pesos); 
        v_barcos = crearBarcos(v_duplas);
        calcular(v_barcos,v_ordenados);
    }
    int[] separarBarcos(){
        int v_cc;
        String v_barcos = "";
        int[] v_duplas, v_resultado;
        do{
            v_barcos += a_tec.nextLine();
            v_barcos += " ";
            v_duplas = validar(v_barcos);
        }while(v_duplas[0] != (v_duplas.length-1)/2);
        v_resultado = new int[v_duplas.length-1];
        for (v_cc = 0; v_cc < v_resultado.length; v_cc++) 
            v_resultado[v_cc] = v_duplas[v_cc+1];
        return v_resultado;
    }
    int[] separarPesos(){
        String v_contenedores="";
        int[] v_pesos;
        do{
            v_contenedores += a_tec.nextLine();
            v_contenedores += " ";
            v_pesos = validar(v_contenedores);
        }while(v_pesos[v_pesos.length-1] != 0);
        return v_pesos;
    }
    TDA CO_ordenar(int[] p_pesos){
        int v_cc,v_cc2,v_cc3;
        TDA v_contenido = new TDA("");
        for (v_cc = 0; v_cc < p_pesos.length-2; v_cc++) {
            int v_posi = v_contenido.recorrido(p_pesos[v_cc]);
            if(v_posi == 0)
                v_contenido.insertarPrincipio(p_pesos[v_cc]+"");
            else
                v_contenido.insertarXn(v_posi-1, p_pesos[v_cc]+"");
        }
        int v_posi = v_contenido.recorrido(p_pesos[p_pesos.length-2]);
        if(v_posi == 0)
            v_contenido.insertarPrincipio(p_pesos[v_cc]+"");
        else
            v_contenido.insertarXn(v_posi-1, p_pesos[v_cc]+"");
        // Despues de haber sido insertados se reagrupan
        String[] v_ordenados = new String[v_contenido.get_Long()];
        for (v_cc2 = 0; v_cc2 < v_contenido.get_Long(); v_cc2++) 
            v_ordenados[v_cc2] = v_contenido.obtener((v_contenido.get_Long()-1)-v_cc2);
        v_contenido.vaciarNodos();
        for (v_cc3 = 0; v_cc3 < v_ordenados.length; v_cc3++)
            v_contenido.insertarFinal(v_ordenados[v_cc3]);
        return v_contenido;
    }
    barco[] crearBarcos(int[] p_duplas){
        int v_cc, v_cont = 0;
        barco[] v_barcos = new barco[p_duplas.length/2];
        for (v_cc = 0; v_cc < v_barcos.length; v_cc++) {
            v_barcos[v_cc] = new barco(0,0,p_duplas[v_cont],p_duplas[v_cont+1]);
            v_cont += 2;
        }
        return v_barcos;
    }
    int[] validar(String p_dato){
        int v_cc,v_cc2;
        int[] v_datos = null;
        try {
            int v_cont=0,v_cont2=0;
            String[] v_aux = p_dato.split(" ");
            for(v_cc=0;v_cc<v_aux.length;v_cc++)
                if(!v_aux[v_cc].equals(""))
                    v_cont++;
            v_datos = new int[v_cont];
            for(v_cc2=0;v_cc2<v_aux.length;v_cc2++)
                if(!v_aux[v_cc2].equals("")){
                    v_datos[v_cont2]= Integer.parseInt(v_aux[v_cc2]);
                    v_cont2++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
    void calcular(barco[] p_barcos, TDA p_datos){
        String v_resultado = "";
        boolean v_agregado, v_sobra;
        Cola v_cola = new Cola("");
        int v_cc, v_cc2, v_nsobras, v_sobras = 0, v_casos = 0, v_posiBarco = 0, v_nPeso = 0, v_cont = 0; // Posicion donde se estan agregando pesos
        while(v_nPeso < p_datos.get_Long()){ // Avance con base en los pesos
            do{
                if(p_barcos[v_posiBarco].getA_ContMax() > 0 && p_barcos[v_posiBarco].getA_PesoMax() >= Integer.parseInt(p_datos.obtener(v_nPeso))){
                    // Se puede agregar
                    p_barcos[v_posiBarco].setA_cont(p_barcos[v_posiBarco].getA_cont()+1);
                    p_barcos[v_posiBarco].setA_pesos(p_barcos[v_posiBarco].getA_pesos()+Integer.parseInt(p_datos.obtener(v_nPeso)));
                    p_barcos[v_posiBarco].setA_ContMax(p_barcos[v_posiBarco].getA_ContMax()-1);
                    p_barcos[v_posiBarco].setA_PesoMax(p_barcos[v_posiBarco].getA_PesoMax()-Integer.parseInt(p_datos.obtener(v_nPeso)));
                    v_agregado = true;
                }else{
                    // No se puede agregar
                    if(v_posiBarco + 1 == p_barcos.length){
                        v_agregado = true; // No cabe
                        System.out.println("No cabe --> "+Integer.parseInt(p_datos.obtener(v_nPeso)));
                        System.out.println("===> "+v_cont);
                    }else{
                        v_agregado = false;
                    }
                }
                v_posiBarco++;
                v_cont++;
                if(v_posiBarco == p_barcos.length){
                    v_posiBarco = 0;
                }
            }while(v_cont < p_datos.get_Long() && (!v_agregado));
            //System.out.println(v_agregado+" "+Integer.parseInt(p_datos.obtener(v_nPeso)));
            v_cont = 0;
            v_nPeso++;
            if(!v_agregado)
                v_cola.insertarFinal(p_datos.obtener(v_nPeso-1));
        }
        for (v_cc = 0; v_cc < p_barcos.length; v_cc++) 
            v_resultado += ("B"+(v_cc+1)+" "+p_barcos[v_cc].getA_cont()+" "+p_barcos[v_cc].getA_pesos()+" ");
        // Contador de los sobrantes
        if(v_cola.get_Long() > 0){
            v_nsobras = v_cola.get_Long();
            for (v_cc2 = 0; v_cc2 < v_cola.get_Long(); v_cc2++)
                v_sobras += Integer.parseInt(v_cola.obtener(v_cc2));
            v_resultado += ("F" + v_nsobras + " K" + v_sobras);
            System.out.println(v_resultado);
        }else
            System.out.println(v_resultado.substring(0, v_resultado.length()-1));
    }
    class barco{
        private int a_cont;
        private int a_pesos;
        private int a_ContMax;
        private int a_PesoMax;
        public barco(int a_cont, int a_pesos, int a_ContMax, int a_PesoMax) {
            this.a_cont = a_cont;
            this.a_pesos = a_pesos;
            this.a_ContMax = a_ContMax;
            this.a_PesoMax = a_PesoMax;
        }
        public int getA_cont() {
            return a_cont;
        }
        public void setA_cont(int a_cont) {
            this.a_cont = a_cont;
        }
        public int getA_pesos() {
            return a_pesos;
        }
        public void setA_pesos(int a_pesos) {
            this.a_pesos = a_pesos;
        }
        public int getA_PesoMax() {
            return a_PesoMax;
        }
        public void setA_PesoMax(int a_PesoMax) {
            this.a_PesoMax = a_PesoMax;
        }
        public int getA_ContMax() {
            return a_ContMax;
        }
        public void setA_ContMax(int a_ContMax) {
            this.a_ContMax = a_ContMax;
        }
    }
    class TDA{
        TDA a_cabeza;
        int a_longitud = 0;
        public TDA a_sig = null;
        public String a_str;
        public TDA(String p_str) {
            a_str = p_str;
        }
        void insertarPrincipio(String p_str){
            TDA v_nuevoNodo = new TDA(p_str);
            v_nuevoNodo.a_sig = a_cabeza;
            a_cabeza = v_nuevoNodo;
            a_longitud ++;
        }
        void insertarFinal(String p_str){
            TDA v_nuevoNodo = new TDA(p_str);
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                TDA v_puntero = a_cabeza;
                while(v_puntero.a_sig != null)
                    v_puntero = v_puntero.a_sig;
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud ++;
        }
        void insertarXn(int p_num, String p_str){
            TDA v_nuevoNodo = new TDA(p_str);
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                TDA v_puntero = a_cabeza;
                int v_cont=0;
                while(v_cont < p_num && v_puntero.a_sig != null){
                    v_puntero = v_puntero.a_sig;
                    v_cont++;
                }
                v_nuevoNodo.a_sig = v_puntero.a_sig;
                v_puntero.a_sig=v_nuevoNodo;
            }
            a_longitud ++;
        }
        String obtener(int p_num){
            if (a_cabeza == null)
                return null;
            else{
                TDA v_puntero = a_cabeza;
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
        int recorrido(int p_real){
            boolean v_ban = true;
            int v_cont = 0;
            int v_nodo;
            while(v_cont < get_Long() && v_ban){
                v_nodo = Integer.parseInt(obtener(v_cont));
                if(v_nodo <= p_real)
                    v_cont++;
                else if(v_nodo > p_real)
                    v_ban = false;
            }
            return v_cont;
        }
        void vaciarNodos(){
            a_cabeza = null;
            a_sig = null;
            a_longitud = 0;
        }
        int get_Long(){
            return a_longitud;
        }
    }
    class Cola{
        private Cola a_cabeza;
        private int a_longitud = 0;
        public Cola a_sig = null;
        public String a_str;
        // Constructor que recibe el String a manipular
        public Cola(String p_str) {
            a_str = p_str;
        }
        void insertarFinal(String p_str){
            Cola v_nuevoNodo = new Cola(p_str);  
            // Valida que la lista no este vacia
            if (a_cabeza == null)
                a_cabeza = v_nuevoNodo;
            else{
                Cola v_puntero = a_cabeza;
                while(v_puntero.a_sig != null)
                    v_puntero = v_puntero.a_sig;
                v_puntero.a_sig = v_nuevoNodo;
            }
            a_longitud ++;
        }
        String obtener(int p_num){
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
                    return v_puntero.a_str;
            }
        }
        int get_Long(){
            return a_longitud;
        }
    }
}