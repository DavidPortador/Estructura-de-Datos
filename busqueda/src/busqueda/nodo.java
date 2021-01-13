/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;
public class nodo {
nodo a_siguiente;
String a_caracter;
int a_nivel;

    public nodo (String p_caracter, int p_nivel){
    a_caracter = p_caracter;
    a_nivel = p_nivel;
    nodo a_siguiente = null;

}
}
