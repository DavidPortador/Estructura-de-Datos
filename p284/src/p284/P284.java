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
        Celdas v_celda;
        Nodo v_nodo = null;
        int v_casos,v_cont=0,v_cont2=0,v_inicio;
        int[] v_datos = new int[4];
        String v_dato;
        boolean v_bandera=true;
        v_casos = valiCasos();
        a_tec.nextLine();
        for(int i=0;i<v_casos;i++){
            System.out.println("vuelta "+i);
            v_bandera=true;
            while(v_bandera){
                v_dato = a_tec.nextLine();
                if(v_dato.equals("0")){
                    v_bandera = false;
                }else{
                    v_cont ++;
                    v_cont2++;
                    v_datos = validar(v_dato);
                    v_celda = new Celdas(v_datos[0],v_datos[1],v_datos[2],v_datos[3]);
                    v_nodo = new Nodo(v_celda);
                    v_nodo.insertar(v_celda);
                    System.out.print(v_nodo.obtener(v_nodo.get_Longitud()-1).getA_ram()+", "+
                            v_nodo.obtener(v_nodo.get_Longitud()-1).getA_valor()+", "+
                            v_nodo.obtener(v_nodo.get_Longitud()-1).getA_izq()+", "+
                            v_nodo.obtener(v_nodo.get_Longitud()-1).getA_der()+"\n");
                    System.out.println("total de datos: "+v_nodo.get_Longitud());
                }
            }
            if(i==0){
                System.out.println("---- 1"+", "+v_cont2);
                //valiRecursion(1,1,v_cont2);
                valiFormado(1,1,v_cont2,v_nodo);
            }else{
                v_inicio = (v_cont2-v_cont)+1;
                System.out.println("---- "+v_inicio+", "+v_cont2);
                //valiRecursion(v_inicio,v_inicio,v_cont2);
                valiFormado(v_inicio,v_inicio,v_cont2,v_nodo);
            }
            v_cont=0;
        }
    }
    void valiFormado(int p_ini,int p_aux,int p_fin,Nodo p_nodo){
        int v_valor,v_izq,v_der;
        if(p_aux==p_ini){
            Celdas v_celda = p_nodo.obtener(p_ini-1);
            v_valor = v_celda.getA_valor();
            v_izq = v_celda.getA_izq();
            v_der = v_celda.getA_der();
            System.out.println(v_valor+" "+v_izq+" "+v_der);
        }else{
            System.out.println("xd");
        }
    }/*
    void valiRecursion(int p_ini,int p_aux,int p_fin){
        if(p_aux<=p_fin){
            System.out.println(p_aux);
            p_aux++;
            valiRecursion(p_ini,p_aux,p_fin);
        }
    }*/
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
    public class Celdas{
        private int a_ram;
        private int a_valor;
        private int a_izq;
        private int a_der;
        public Celdas(int p_ram, int p_valor, int p_izq, int p_der) {
            a_ram = p_ram;
            a_valor = p_valor;
            a_izq = p_izq;
            a_der = p_der;
        }
        public int getA_ram() {
            return a_ram;
        }
        public int getA_valor() {
            return a_valor;
        }
        public int getA_izq() {
            return a_izq;
        }
        public int getA_der() {
            return a_der;
        }
    }
    public class Nodo{
        public Nodo a_sig = null;
        public Celdas a_celdas;
        public Nodo(Celdas p_celdas) {
            a_celdas = p_celdas;
        }
        void insertar(Celdas p_celdas){
            Nodo v_nuevoNodo = new Nodo(p_celdas);  
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
            System.out.print("Agregado con exito: ");
        }
        Celdas obtener(int p_num){
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
                    return v_puntero.a_celdas;
            }
        }
        int get_Longitud(){
            return a_longitud;
        }
    }
}
