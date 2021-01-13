package bm;

import java.util.Scanner;
public class BM {
    Scanner a_teclado = new Scanner(System.in);
    barco[] a_barcos;
    lista a_lista = new lista();
    public static void main(String[] args) {
        BM v_objeto = new BM();
        v_objeto.m_ingrDatos();
    }
    
    void m_ingrDatos(){
    int v_casos = Integer.parseInt(a_teclado.nextLine());
    String  v_cadena = "";
    String[] v_datos = null;
    while(v_casos>0){
    v_cadena = a_teclado.nextLine();
    v_datos = m_elimEspacios(v_cadena);
    m_crearBarcos(v_datos);
    m_ingrContenedores();
    m_llenaBarcos();
    m_mostResultados();
    a_lista.m_limpiar();
    a_barcos=null;
    v_casos--;
    }
    }
    
    void m_crearBarcos(String[] p_datos){
    int v_cont=0, v_cont2 =0;
    String v_auxiliar;
    a_barcos = new barco[Integer.parseInt(p_datos[0])];
    for(;a_barcos.length>v_cont;v_cont++){
        try{
        a_barcos[v_cont] = new barco(Integer.parseInt(p_datos[++v_cont2]),Integer.parseInt(p_datos[++v_cont2]));
        }
        catch(Exception e){
        v_cont--;
        v_cont2=-1;
        v_auxiliar = a_teclado.nextLine();
        p_datos = m_elimEspacios(v_auxiliar);
        }
    }
    }
    
    void m_ingrContenedores(){
    lista  v_listaAuxiliar = new lista();
    String v_cadena = "";
    String v_auxiliar = "";
    String[] v_datos= null;
    int v_cont=0;
    do{
    v_auxiliar = a_teclado.nextLine();
    v_cadena = v_cadena + v_auxiliar + " ";
    v_datos = m_elimEspacios(v_cadena);
    }while(!v_datos[v_datos.length-1].equals("0"));
    for(;v_datos.length-1>v_cont;v_cont++)
    v_listaAuxiliar.m_insertar(Integer.parseInt(v_datos[v_cont]),v_cont);
    m_ordenar(v_listaAuxiliar);
    }
    
    void m_ordenar(lista p_lista){
     nodo v_nodo = p_lista.m_out();
     int v_cont=0;
     while(v_nodo!=null){
         a_lista.m_insertar(v_nodo.a_valor, v_cont);
         v_nodo = p_lista.m_out();
         v_cont++;
     }
    }
    
    void m_llenaBarcos(){
    int v_cont=0, v_cont2=0, v_limite = a_lista.a_elementos, v_cont3=0 ;
    nodo v_auxiliar = null;
    boolean v_bandera = true;
    for(;v_limite>v_cont;v_cont++){
        v_auxiliar = a_lista.m_buscaPosicion(v_cont);
        if(v_cont2 == a_barcos.length)
            v_cont2=0;
        for(v_bandera =true;a_barcos.length>v_cont2 && v_bandera;v_cont2++){
            if(v_auxiliar!=null)
            if(a_barcos[v_cont2].m_ingrContenedor(v_auxiliar.a_valor)){
                //System.out.println("al barco: " + (v_cont2+1) + " se le puso un contenedor de: " + v_auxiliar.a_valor);
            a_lista.m_borrar(v_cont);
            v_bandera = false;
            }
        }
        if(v_bandera)
            for(;a_barcos.length>v_cont3 && v_bandera;v_cont3++){
            if(v_auxiliar!=null)
            if(a_barcos[v_cont3].m_ingrContenedor(v_auxiliar.a_valor)){
                //System.out.println("al barco: " + (v_cont2+1) + " se le puso un contenedor de: " + v_auxiliar.a_valor);
            a_lista.m_borrar(v_cont);
            v_bandera = false;
            }
    }
    }
    }
    
    
    void m_mostResultados(){
    String v_resultado ="";
    int v_cont =0, v_contenedores = 0, v_peso =0;
    for(;a_barcos.length>v_cont;v_cont++){
    v_resultado = v_resultado + "B" +(v_cont+1) + " " + a_barcos[v_cont].a_numeContene + " " + a_barcos[v_cont].a_peso + " ";
    v_contenedores += (a_barcos[v_cont].a_contenedores - a_barcos[v_cont].a_numeContene);
    v_peso += (a_barcos[v_cont].a_pesoMax-a_barcos[v_cont].a_peso);
    }
    //if(v_contenedores>0 && a_lista.a_elementos>0 && v_peso>0)
    v_resultado = v_resultado + "F" + a_lista.a_elementos + " K" + a_lista.m_suma();
    //else
    //v_resultado = v_resultado.substring(0,v_resultado.length()-1);
    System.out.println(v_resultado);
}
    String[] m_elimEspacios(String p_cadena){
    String[] v_elementos = p_cadena.split(" ");
    String v_auxiliar="";
    int v_cont;
    for(v_cont=0;v_cont<v_elementos.length;v_cont++)
        if(!v_elementos[v_cont].equals(""))
            v_auxiliar = v_auxiliar + v_elementos[v_cont] +",";
    return v_auxiliar.split(",");
    }   
}
class lista {
    nodo a_inicio;
    nodo a_tope;
    int a_elementos;
    public lista(){
    a_inicio = null;
    a_tope = null;
    a_elementos=0;
    }
    
    void m_insertar(int p_valor, int p_posicion){
    nodo v_nodo = new nodo(p_valor, p_posicion);
    nodo v_auxiliar=null;
    if(a_inicio ==null)
        m_inseRaiz(v_nodo);
    else{
    v_auxiliar = m_buscar(v_nodo);
    if(v_auxiliar==a_inicio && p_valor>=a_inicio.a_valor)
        m_inseInicio(v_nodo, v_auxiliar);
    else
        if(v_auxiliar==a_tope && p_valor<a_tope.a_valor)
          m_inseTope(v_nodo, v_auxiliar);
        else
            m_inseMedio(v_nodo,v_auxiliar);
    }
    a_elementos++;
    }
    
    private void m_inseMedio(nodo p_nodo, nodo p_auxiliar){
    p_nodo.a_siguiente = p_auxiliar;
    p_auxiliar.a_anterior.a_siguiente = p_nodo;
    p_nodo.a_anterior = p_auxiliar.a_anterior;
    p_auxiliar.a_anterior = p_nodo;
    }
    
    private void m_inseTope(nodo p_nodo, nodo p_auxiliar){
    p_nodo.a_anterior = p_auxiliar;
    p_auxiliar.a_siguiente = p_nodo;
    a_tope = p_nodo;
    } 
    
    private void m_inseInicio(nodo p_nodo, nodo p_auxiliar){
    p_nodo.a_siguiente=p_auxiliar;
    p_auxiliar.a_anterior = p_nodo;
    a_inicio = p_nodo;
    } 
    
    private void m_inseRaiz(nodo p_nodo){
    a_inicio = p_nodo;
    a_tope = p_nodo;
    }
    
    nodo m_buscar(nodo p_nodo){
    nodo v_auxiliar = a_inicio;
    nodo v_temporal = v_auxiliar;
    while(v_auxiliar!=null){
        if(v_auxiliar.a_valor>p_nodo.a_valor){
            v_auxiliar = v_auxiliar.a_siguiente;
            if(v_auxiliar!=null)
            v_temporal = v_auxiliar;
        }
        else
            v_auxiliar=null;
    }
    return v_temporal;    
    }
    
    nodo m_buscaPosicion(int p_posicion){
    nodo v_auxiliar = a_inicio;
    nodo v_temporal = v_auxiliar;
    int v_cont=0;
    while(a_elementos>v_cont){
        if(v_auxiliar.a_posicion==p_posicion)
            v_cont=a_elementos;
        else
        v_auxiliar = v_auxiliar.a_siguiente;
        v_cont++;
    }
    return v_auxiliar;
    }
    
    void m_borrar(int p_posicion){
    nodo v_auxiliar = m_buscaPosicion(p_posicion);
    if(v_auxiliar == a_inicio && v_auxiliar ==a_tope){
    a_inicio = null;
    a_tope = null;
    } 
    else
        if(v_auxiliar == a_inicio)
            m_borraInicio();
        else 
            if(v_auxiliar == a_tope)
             m_borraTope();
             else
                m_borraMedio(v_auxiliar);
    a_elementos--;
    }
    
    void m_borraInicio(){
    a_inicio = a_inicio.a_siguiente;
    a_inicio.a_anterior = null;
    }
    
    void m_borraTope(){
    a_tope = a_tope.a_anterior;
    a_tope.a_siguiente = null;
    }
    
    void m_borraMedio(nodo p_auxiliar){
    p_auxiliar.a_anterior.a_siguiente = p_auxiliar.a_siguiente;
    p_auxiliar.a_siguiente.a_anterior = p_auxiliar.a_anterior;
    } 
    
    void m_limpiar(){
    a_inicio = null;
    a_tope = null;
    a_elementos =0;
    }
    
     nodo m_out(){
       nodo v_auxiliar = a_inicio;
       nodo v_nodoRetorno;
      if(a_tope ==null)
       return null;
      else{
          if(v_auxiliar.a_siguiente == null){
          v_nodoRetorno = a_inicio;
          a_inicio = null;
          a_tope = null;
          return  v_nodoRetorno;
          }
          else{  
              v_nodoRetorno = a_inicio;
              a_inicio = a_inicio.a_siguiente;
              a_inicio.a_anterior=null;
              return  v_nodoRetorno;
      }   
   }
  }
     int m_suma(){
     nodo v_nodo = m_out();
     int v_suma=0;
     while(v_nodo!=null){
         v_suma+= v_nodo.a_valor;
         v_nodo = m_out();
     }
     return v_suma;
     }
}
class nodo {
    nodo a_anterior;
    nodo a_siguiente;
    int a_valor;
    int a_posicion;
    public nodo(int p_valor, int p_posicion){
    a_anterior = null;
    a_siguiente = null;
    a_valor = p_valor;
    a_posicion = p_posicion;
    }
}
class barco {
 int a_pesoMax;
 int a_contenedores;
 int a_peso=0;
 int a_numeContene=0;
 public barco(int p_contenedores, int p_peso){
 a_pesoMax = p_peso;
 a_contenedores = p_contenedores;
 }
 
 boolean m_ingrContenedor(int p_contenedor){
 if((a_numeContene+1)<=a_contenedores)
     if(a_pesoMax-(p_contenedor+a_peso)>=0){
         a_numeContene++;
         a_peso= a_peso + p_contenedor;
         return true;
     }
     else
         return false;
 else
     return false;
 }
}
