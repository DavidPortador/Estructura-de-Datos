package p285;
// 50 76 17 23 54 9 14 12 72 67 19 0

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
        int v_datos,v_cont;
        v_datos = valiEntrada();
        a_tec.nextLine();
        for(v_cont=0; v_cont<v_datos; v_cont++){
            arbol();
        }
    }
    void arbol(){
        String v_dato;
        int[] v_datos;
        v_dato = a_tec.nextLine();
        v_datos = validar(v_dato);
        if(!repeticiones(v_datos)){
            if(negativos(v_datos)){
                v_datos = valicero(v_datos);
                if(v_datos[v_datos.length-1] == 0){
                    valicero(v_datos);
                    Celda v_ini = new Celda(v_datos[0],0,0);
                    Nodo v_nodo = new Nodo(v_ini);
                    v_nodo.insertar(v_ini);
                    llenarNodos(v_nodo,v_datos,1);
                    validarNodos(v_nodo);
                    v_nodo.vaciarNodos();
                }else{
                    System.out.println("0");
                }
            }
        }
    }
    int[] valicero(int[] p_datos){
        int v_cont, v_cont2, v_aux = 0;
        boolean v_ban = false;
        if(p_datos[p_datos.length-1]==0){
            return p_datos;
        }else{
            for(v_cont = 0; v_cont < p_datos.length; v_cont++){
                if(p_datos[v_cont]==0){
                    v_aux = v_cont+1;
                    v_ban = true;
                }
            }
            if(v_ban){
                int[] v_datos = new int[v_aux];
                for(v_cont2=0; v_cont2 < v_aux; v_cont2++){
                    v_datos[v_cont2] = p_datos[v_cont2];
                }
                return v_datos;
            }else{
                return p_datos;
            }
        }
        
    }
    boolean negativos(int[] p_datos){
        boolean v_ban = true;
        int v_con;
        for(v_con=0; v_con < p_datos.length-1; v_con++){
            if(p_datos[v_con] < 0){
                v_ban=false;
            }
        }
        return v_ban;
    }
    boolean repeticiones(int[] p_datos){
        boolean repetido = false;
        int v_cont1,v_cont2;
        for (v_cont1 = 0; v_cont1 < p_datos.length; v_cont1++) {
            for (v_cont2 = 0; v_cont2 < p_datos.length; v_cont2++) {
                if (p_datos[v_cont1] == p_datos[v_cont2] && v_cont1 != v_cont2) {
                    repetido = true;
                 }
             }
         }
        return repetido;
    }
    void validarNodos(Nodo p_nodo){
        int v_mayor, v_menor,v_anterior,v_actual,v_cont=0,v_con,v_con2,v_con3,v_con4;
        int[] v_ramas;
        for(v_con=1;v_con<a_longitud;v_con++){
            recorrido(p_nodo,v_con,0);
        }
        for(v_con2=0;v_con2<a_longitud-1;v_con2++){
            if(p_nodo.obtener(v_con2).getA_mayor()==0 && p_nodo.obtener(v_con2).getA_menor()==0){
                v_cont++;
            }
        }
        v_ramas = new int[v_cont];
        v_cont=0;
        for(v_con3=0;v_con3<a_longitud-1;v_con3++){
            if(p_nodo.obtener(v_con3).getA_mayor()==0 && p_nodo.obtener(v_con3).getA_menor()==0){
                //System.out.println(calcular(p_nodo,p_nodo.obtener(i).getA_valor(),i-1,1));
                v_ramas[v_cont]=calcular(p_nodo,p_nodo.obtener(v_con3).getA_valor(),v_con3-1,1);
                v_cont++;
            }
        }
        v_mayor = v_menor = v_ramas[0];
        for (v_con4=0;v_con4<v_ramas.length;v_con4++){
            if(v_ramas [v_con4] > v_mayor) {
                v_mayor = v_ramas[v_con4];
            }
            if(v_ramas[v_con4]<v_menor) {
                v_menor = v_ramas[v_con4];
            }
        }
        System.out.println(v_menor+" "+v_mayor);
    }
    int calcular(Nodo p_nodo, int p_valor, int p_pos, int p_cont){
        //System.out.print("posi: "+p_pos+", ");
        if(p_pos>=0){
            if(p_nodo.obtener(p_pos).getA_mayor() == p_valor){
                p_cont++;
                p_valor = p_nodo.obtener(p_pos).getA_valor();
                //System.out.print("ok "+p_valor);
                return calcular(p_nodo,p_valor,p_pos-1,p_cont);
            }else if(p_nodo.obtener(p_pos).getA_menor() == p_valor){
                p_cont++;
                p_valor = p_nodo.obtener(p_pos).getA_valor();
                //System.out.print("ok "+p_valor);
                return calcular(p_nodo,p_valor,p_pos-1,p_cont);
            }else{
                return calcular(p_nodo,p_valor,p_pos-1,p_cont);
            }
        }else{
            return p_cont;
        }
    }
    void recorrido(Nodo p_nodo, int p_num, int p_posi){
        int v_base;
        Celda v_raiz;
        if(p_num<p_nodo.get_Long()){
            v_base = p_nodo.obtener(p_num).getA_valor();
            v_raiz = p_nodo.obtener(p_posi);
            if(v_base<v_raiz.getA_valor()){
                if(v_raiz.getA_menor()==0){
                    v_raiz.setA_menor(v_base);
                }else{
                    p_posi = posicion(p_nodo, v_raiz.getA_menor());
                    recorrido(p_nodo,p_num,p_posi);
                }
            }else if(v_base>v_raiz.getA_valor()){
                if(v_raiz.getA_mayor()==0){
                    v_raiz.setA_mayor(v_base);
                }else{
                    p_posi = posicion(p_nodo, v_raiz.getA_mayor());
                    recorrido(p_nodo,p_num,p_posi);
                }
            }
        }
    }
    int posicion(Nodo p_nodo,int p_valor){
        int v_cont=0;
        boolean v_ban=true;
        while(v_cont<p_nodo.get_Long() && v_ban){
            if(p_nodo.obtener(v_cont).getA_valor()==p_valor){
                v_ban=false;
            }else{
                v_cont++;
            }
        }
        return v_cont;
    }
    void llenarNodos(Nodo p_nodo,int[] p_datos,int p_aux){
        if(p_aux<p_datos.length){
            Celda v_aux = new Celda(p_datos[p_aux],0,0);
            p_nodo.insertar(v_aux);
            p_aux++;
            llenarNodos(p_nodo,p_datos,p_aux);
        }
    }
    int[] validar(String p_dato){
        int[] v_datos = null;
        int v_con,v_con2;
        try {
            int v_cont = 0,v_cont2 = 0;
            String[] v_aux = p_dato.split(" ");
            for(v_con=0; v_con < v_aux.length; v_con++)
                if(!v_aux[v_con].equals(""))
                    v_cont++;
            v_datos = new int[v_cont];
            for(v_con2=0;v_con2<v_aux.length;v_con2++)
                if(!v_aux[v_con2].equals("")){
                    v_datos[v_cont2]= Integer.parseInt(v_aux[v_con2]);
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
        private int a_valor;
        private int a_menor;
        private int a_mayor;
        public Celda(int a_valor, int a_menor, int a_mayor) {
            this.a_valor = a_valor;
            this.a_menor = a_menor;
            this.a_mayor = a_mayor;
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
        void insertar(Celda p_int){
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
        void vaciarNodos(){
            a_cabeza=null;
            a_sig=null;
            a_longitud=0;
        }
        int get_Long(){
            return a_longitud;
        }
    }
}