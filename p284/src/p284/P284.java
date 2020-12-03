package p284;

import java.util.Scanner;
public class P284 {
    Scanner a_tec = new Scanner(System.in);
    private Nodo a_cabeza;
    private int a_longitud = 0;
    public boolean a_ban = true;
    public static void main(String[] args) {
        P284 v_obj = new P284();
        v_obj.entrada();
    }
    void entrada(){
        try {
            int v_casos;
            v_casos = a_tec.nextInt();
            a_tec.nextLine();
            if(v_casos > 0)
                llenar(v_casos);
        } catch (Exception e) {
            System.out.println("MAL CONSTRUIDO DIRECCION INVALIDA");
        }
    }
    void llenar(int p_casos){
        int v_cc;
        int[] v_datos;
        String v_dato;
        boolean v_ban = true;
        Celda v_aux = new Celda(0,0,0,0);
        Nodo v_nodo = new Nodo(v_aux);
        for (v_cc = 0; v_cc < p_casos; v_cc++) {
            while(v_ban){
                v_dato = a_tec.nextLine();
                if(v_dato.equals("0")){
                    v_ban = false;
                    //System.out.println("fin");
                }else{
                    v_datos = validar(v_dato);
                    Celda v_new = new Celda(v_datos[0],v_datos[1],v_datos[2],v_datos[3]);
                    v_nodo.insertar(v_new);
                }
            }
            //System.out.println("Long: "+v_nodo.get_Long());
            Celda v_raiz = v_nodo.obtener(posiRam(v_nodo,v_nodo.obtener(0).getA_valor()));
            //most(v_nodo);
            recorrido(v_nodo,v_raiz);
            if(a_ban)
                extraviados(v_nodo);
            v_nodo.vaciarNodos();
            v_ban=true;
        }
    }
    void recorrido(Nodo p_nodo,Celda p_raiz){
        if(p_raiz.getA_menor() != 0){
            int v_posi = posiRam(p_nodo,p_raiz.getA_menor());
            if(v_posi < p_nodo.get_Long()){
                /*System.out.println(p_raiz.getA_valor()+" menor "+v_posi);
                recorrido(p_nodo,p_nodo.obtener(v_posi));*/
            }else{
                System.out.println("MAL CONSTRUIDO DIRECCION INVALIDA");
                a_ban = false;
            }
        }
        if(p_raiz.getA_mayor() != 0){
            int v_posi = posiRam(p_nodo,p_raiz.getA_mayor());
            if(v_posi < p_nodo.get_Long()){
                /*System.out.println(p_raiz.getA_valor()+" mayor "+v_posi);
                recorrido(p_nodo,p_nodo.obtener(v_posi));*/
            }else{
                System.out.println("MAL CONSTRUIDO DIRECCION INVALIDA");
                a_ban = false;
            }
        }
    }
    void extraviados(Nodo p_nodo){
        int v_cc,v_cont = 0;
        for (v_cc = 1; v_cc < p_nodo.get_Long(); v_cc++) {
            if(p_nodo.obtener(v_cc).getA_menor() != 0)
                v_cont ++;
            if(p_nodo.obtener(v_cc).getA_mayor() != 0)
                v_cont ++;
        }
        //System.out.println("NUM "+v_cont+" - "+(p_nodo.get_Long()-2));
        if(v_cont == (p_nodo.get_Long()-2))
            System.out.println("BIEN FORMADO");
        else if(v_cont < (p_nodo.get_Long()-2))
            System.out.println("MAL CONSTRUIDO NODO EXTRAVIADO");
    }
    /*
    void most(Nodo p_nodo){
        int v_cc;
        for (v_cc = 0; v_cc < p_nodo.get_Long(); v_cc++) {
            Celda v_aux = p_nodo.obtener(v_cc);
            System.out.println(v_aux.getA_ram()+", "+v_aux.getA_valor()+", "+v_aux.getA_menor()+", "+v_aux.getA_mayor());
            System.out.println("menor: "+posiRam(p_nodo,v_aux.getA_menor())+" mayor: "+posiRam(p_nodo,v_aux.getA_mayor()));
        }
    }
    */
    int posiRam(Nodo p_nodo,int p_valor){
        int v_cont=0;
        boolean v_ban=true;
        while(v_cont < p_nodo.get_Long() && v_ban)
            if(p_nodo.obtener(v_cont).getA_ram()==p_valor)
                v_ban=false;
            else
                v_cont++;
        return v_cont;
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
    class Celda{
        private int a_ram;
        private int a_valor;
        private int a_menor;
        private int a_mayor;
        public Celda(int a_ram, int a_valor, int a_menor, int a_mayor) {
            this.a_ram = a_ram;
            this.a_valor = a_valor;
            this.a_menor = a_menor;
            this.a_mayor = a_mayor;
        }
        public int getA_ram() {
            return a_ram;
        }
        public int getA_valor() {
            return a_valor;
        }
        public int getA_menor() {
            return a_menor;
        }
        public int getA_mayor() {
            return a_mayor;
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
            // System.out.println("agregado");
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
