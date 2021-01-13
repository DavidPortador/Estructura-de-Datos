package busqueda;
 import java.util.Scanner;
public class Busqueda {
    int [][]a_matriz;
    int [] a_ruta;
    pila a_pila = new pila();
   
 public static void main(String[] args) {
     Busqueda busqueda= new Busqueda();
     busqueda.m_llenMatriz();
     busqueda.m_pideDatos();
    }
 void m_pideDatos(){
    int Vi,Vf;
    Scanner v_teclado=new Scanner(System.in);
    System.out.print("Ingresa el vertice de inicio ");
    Vi=v_teclado.nextInt();
    System.out.print("Ingresa el vertice de Final ");
    Vf=v_teclado.nextInt();
    System.out.println("La ruta es : "+m_buscRuta(Vi,Vf)); 
 }

String m_buscRuta(int p_Vi,int p_Vf){
    a_ruta = new int[a_matriz.length];
    int v_cont, v_nivel,v_actual=0;
    nodo v_temporal;
    String v_ruta="";
    for(v_cont=0;v_cont<a_matriz.length;v_cont++)
        a_ruta[v_cont] =0;
    //1 PUSH 1
    v_nivel =0;
    a_pila.m_push(String.valueOf(p_Vi),v_nivel);
    do{
        v_temporal = a_pila.m_pop();
        v_nivel = v_temporal.a_nivel;
        v_actual = Integer.parseInt(v_temporal.a_caracter);
        a_ruta[v_nivel] = v_actual;
        System.out.println("ruta: " + v_ruta);
        if(v_actual != p_Vf) //expandir nodo
            m_expaNodo(v_actual,v_nivel);
    }while(v_actual != p_Vf);
    for(v_cont=0;v_cont<=v_nivel;v_cont++)
    v_ruta = v_ruta + a_ruta[v_cont] +", ";
    return v_ruta;
 }

void m_expaNodo(int p_nodoActual, int p_nivel){
    int v_nodoColumna;
    nodo v_temporal=null;
    boolean v_bandera = false;
    for(v_nodoColumna=0;v_nodoColumna<a_matriz.length;v_nodoColumna++)
        if(a_matriz[p_nodoActual][v_nodoColumna]>0)
            if(m_valiRuta(v_nodoColumna, p_nivel)){
                a_pila.m_push(String.valueOf(v_nodoColumna), p_nivel+1);
                v_bandera = true;
            }else if(v_nodoColumna+1==a_matriz.length && !v_bandera){
                v_temporal = a_pila.m_pop();
                m_expaNodo(Integer.parseInt(v_temporal.a_caracter),v_temporal.a_nivel);
            }
}

boolean m_valiRuta(int p_nodoColumna, int p_nivel){
    int v_cont =0;
    boolean v_bandera = true;
    for(;p_nivel>v_cont && v_bandera;v_cont++)
        if(a_ruta[v_cont]==p_nodoColumna)
            v_bandera = false;
    return v_bandera;
}

 void m_llenMatriz(){
     int temp[][]={{0,1,0,1,0},{1,0,1,0,1},{0,1,0,1,0},{1,0,1,0,0},{0,1,0,0,0}};
     a_matriz=temp;
 }
}
