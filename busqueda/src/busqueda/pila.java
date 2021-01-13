/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;
public class pila {
    nodo a_tope;
    nodo a_inicio;
    public pila(){
        a_tope = null;
        a_inicio = null;
   }
   
   void m_push(String p_dato, int p_nivel){
   nodo v_nodo = new nodo(p_dato, p_nivel);
   if(a_tope==null){   
   a_inicio = v_nodo;
   a_tope = v_nodo;
   }
   else 
   a_tope.a_siguiente = v_nodo;
   a_tope = v_nodo;
   }
   nodo m_pop(){
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
      while(v_auxiliar.a_siguiente!= a_tope)
            v_auxiliar = v_auxiliar.a_siguiente;
      v_nodoRetorno = a_tope;
      a_tope = v_auxiliar;
      a_tope.a_siguiente = null;
      return v_nodoRetorno;
      }   
   }
   }  
}
