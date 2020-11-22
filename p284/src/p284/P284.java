package p284;

import java.util.Scanner;
public class P284 {
    Scanner a_tec = new Scanner(System.in);
    private Nodo a_cabeza;
    private int a_longitud = 0;
    public static void main(String[] args) {
        P284 v_obj = new P284();
        v_obj.entrada();
    }
    void entrada(){
        int v_casos,v_cont2=0,v_inicio;
        int[] v_datos;
        String v_dato = "";
        boolean v_bandera = true;
        v_casos = valiCasos();
        a_tec.nextLine();
        Celda v_aux = new Celda(0,0,0,0);
        Nodo v_nodo = new Nodo(v_aux);
        for (int i = 0; i < v_casos; i++) {
            while(v_bandera){
                v_dato = a_tec.nextLine();
                if(v_dato.equals("0")){
                    v_bandera = false;
                }else{
                    v_datos = validar(v_dato);
                    if(v_datos.length==4){
                        // System.out.println("ok");
                        Celda v_celda = new Celda(v_datos[0],v_datos[1],v_datos[2],v_datos[3]);
                        v_nodo.insertar(v_celda);
                        // System.out.println(v_nodo.get_Long());
                    }else{
                        // System.out.println("mal formado");
                    }
                }
            }
            int v_raiz,v_posi;
            v_raiz = v_nodo.obtener(0).getA_valor();
            v_posi = posiRam(v_nodo,v_raiz);
            if(v_posi==v_nodo.get_Long()){
                System.out.println("MAL FORMADO DIRECCION INVALIDA");
            }else{
                System.out.println("raiz: "+v_raiz+", posi: "+v_posi);
                recorrido(v_nodo,v_raiz,v_posi);
                // System.out.println("termina");
                v_nodo.vaciarNodos();
                v_bandera = true;
            }
            
        }
    }
    // llega el valor de la raiz (50) y hace el arbol a partir de eso
    void recorrido(Nodo p_nodo, int p_valor, int p_posi){
        if(p_nodo.obtener(p_posi).getA_menor() != 0){
            // tiene mayor
            int v_menor,v_posi;
            v_menor = p_nodo.obtener(p_posi).getA_menor();
            v_posi = posicion(p_nodo,v_menor);
            if(p_posi==p_nodo.get_Long()){
                System.out.println("MAL FORMADO DIRECCION INVALIDA");
            }else{
                System.out.println("pasa");
                recorrido(p_nodo,v_menor,v_posi);
            }
            System.out.println(v_posi+" en "+v_menor);
        }else{
            // no tiene menor
        }
        if(p_nodo.obtener(p_posi).getA_mayor() != 0){
            // tiene mayor
            int v_mayor,v_posi;
            v_mayor = p_nodo.obtener(p_posi).getA_mayor();
            v_posi = posicion(p_nodo,v_mayor);
            System.out.println(v_posi+" en "+v_mayor);
        }else{
            // no tiene mayor
        }
    }
    int posicion(Nodo p_nodo,int p_valor){
        int v_cont = 0;
        boolean v_ban=true;
        while(v_cont < p_nodo.get_Long() && v_ban){
            if(p_nodo.obtener(v_cont).getA_valor()==p_valor){
                v_ban=false;
            }else{
                v_cont++;
            }
        }
        return v_cont;
    }
    int posiRam(Nodo p_nodo,int p_valor){
        int v_cont = 0;
        boolean v_ban=true;
        while(v_cont < p_nodo.get_Long() && v_ban){
            if(p_nodo.obtener(v_cont).getA_ram()==p_valor){
                v_ban=false;
            }else{
                v_cont++;
            }
        }
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
    int valiCasos(){
        int v_caso;
        try {
            v_caso = a_tec.nextInt();
            if(v_caso > 0)
                return v_caso;
            else
                return 0;
        } catch (Exception e) {
            return 0;
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
