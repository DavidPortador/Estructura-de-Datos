package hm;

import java.util.Scanner;
public class HM {
int [][]a_matriz;
int [] a_ruta;
int [] a_costo;
pila a_pila = new pila();
Scanner a_teclado=new Scanner(System.in);
public static void main(String[] args) {
HM busqueda= new HM();
int v_longitud = Integer.parseInt(busqueda.a_teclado.nextLine());
busqueda.m_llenMatriz(v_longitud);
busqueda.m_pideDatos();
}
void m_pideDatos(){
boolean v_bandera =true;
while(v_bandera){
try{
String[] v_vertices;
String v_cadena;
int Vi,Vf;
v_cadena = a_teclado.next();
v_vertices = v_cadena.split(",");
Vi= m_verticeLetra(v_vertices[0]);
Vf= m_verticeLetra(v_vertices[1]);
System.out.println(m_buscRuta(Vi,Vf));
}
catch(Exception e){
v_bandera = false;
}
}
}
String m_buscRuta(int p_Vi,int p_Vf){
a_pila.m_vaciar();
a_ruta = new int[a_matriz.length];
a_costo = new int [a_matriz.length];
int v_cont, v_nivel=0,v_actual=0, v_costo;
nodo v_temporal;
String v_ruta="";
a_pila.m_push(0,0,p_Vi);
try{
do{
v_temporal = a_pila.m_pop();
v_nivel = v_temporal.a_nivel;
v_actual = v_temporal.a_vertice;
v_costo = v_temporal.a_valor;
a_ruta[v_nivel] = v_actual;
a_costo[v_nivel] = v_costo;
if(v_actual != p_Vf) //expandir nodo
m_expaNodo(v_actual,v_nivel);
}while(v_actual != p_Vf);
v_ruta = m_CalcRuta(v_nivel);
return v_ruta;
}
catch(Exception e){
return "NO HAY RUTA";
}
}
void m_expaNodo(int p_nodoActual, int p_nivel){
pila v_pilaAuxiliar = new pila();
v_pilaAuxiliar = m_respaldarPila();
int v_nodoColumna;
for(v_nodoColumna=0;v_nodoColumna<a_matriz.length;v_nodoColumna++)
if(a_matriz[p_nodoActual][v_nodoColumna]>0)
if(!m_valiRuta(v_nodoColumna, p_nivel))
a_pila.m_push(a_matriz[p_nodoActual][v_nodoColumna], (p_nivel+1), v_nodoColumna);
m_respaldoPila(v_pilaAuxiliar);
}
pila m_respaldarPila(){
pila v_pilaAuxiliar = new pila();
nodo v_nodoAuxiliar;
v_nodoAuxiliar= a_pila.m_pop();
while(v_nodoAuxiliar!=null){
v_pilaAuxiliar.m_pushDetas(v_nodoAuxiliar);
v_nodoAuxiliar= a_pila.m_pop();
}
return v_pilaAuxiliar;
}
void m_respaldoPila(pila p_pilaRespaldo){
nodo v_nodoAuxiliar;
v_nodoAuxiliar= p_pilaRespaldo.m_pop();
while(v_nodoAuxiliar!=null){
a_pila.m_pushDetas(v_nodoAuxiliar);
v_nodoAuxiliar= p_pilaRespaldo.m_pop();
}
}
boolean m_valiRuta(int p_nodoColumna, int p_nivel){
while(a_ruta[p_nivel]!=p_nodoColumna && p_nivel>0)
p_nivel--;
if(a_ruta[p_nivel]==p_nodoColumna)
return true;
else
return false;
}
void m_llenMatriz(int p_longitud){
int v_cont=0, v_cont2=0;
String v_cadena="";
String[] v_datos;
a_matriz = new int[p_longitud][p_longitud];
for(;v_cont<p_longitud;v_cont++){
v_cadena = a_teclado.nextLine();
v_datos = v_cadena.split(" ");
for(v_cont2=0;v_cont2<p_longitud;v_cont2++)
a_matriz[v_cont][v_cont2] = Integer.parseInt(v_datos[v_cont2]);
}
}
int m_verticeLetra(String p_vertice){
int v_cont=0;
String v_cadena= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
while(!p_vertice.equals(String.valueOf(v_cadena.charAt(v_cont)))){
v_cont++;
}
return v_cont;
}
String m_verticeNumero(int p_vertice){
String v_cadena= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
return String.valueOf(v_cadena.charAt(p_vertice));
}
String m_CalcRuta(int p_nivel){
String v_ruta ="";
int v_cont=0, v_costo =0;
for(;v_cont<=p_nivel;v_cont++)
v_ruta = v_ruta + m_verticeNumero(a_ruta[v_cont]) +" ";
for(v_cont=0;v_cont<=p_nivel;v_cont++)
v_costo+= a_costo[v_cont];
v_ruta = v_ruta + v_costo;
return v_ruta;
}
}
class pila {
nodo a_tope;
nodo a_inicio;
int a_cantElementos;
public pila(){
a_tope = null;
a_inicio = null;
a_cantElementos=0;
}
void m_pushDetas(nodo p_nodo){
if(a_inicio==null){
a_inicio = p_nodo;
a_tope = p_nodo;
}
else{
a_inicio.a_anterior = p_nodo;
p_nodo.a_siguiente = a_inicio;
a_inicio = p_nodo;
}
a_cantElementos++;
}
void m_push(int p_dato, int p_nivel, int p_vertice){
nodo v_nodo = new nodo(p_dato, p_nivel, p_vertice);
nodo v_auxiliar = a_inicio;
int v_cont =0;
if(a_inicio==null){
a_inicio = v_nodo;
a_tope = v_nodo;
a_cantElementos++;
}
else
if(a_inicio==a_tope){//cuando hay uno
if(v_nodo.a_valor<=a_inicio.a_valor){
a_tope.a_siguiente = v_nodo;
v_nodo.a_anterior = a_tope;
a_tope = v_nodo;
a_cantElementos++;
}
else{
a_inicio.a_anterior = v_nodo;
v_nodo.a_siguiente = a_inicio;
a_inicio = v_nodo;
a_cantElementos++;
}
}
else{
//System.out.println("a");
while(a_cantElementos>v_cont){
if(v_nodo.a_valor<=v_auxiliar.a_valor && a_cantElementos>v_cont+1)
v_auxiliar = v_auxiliar.a_siguiente;
else
v_cont = a_cantElementos;
v_cont++;
}
if(v_auxiliar==a_inicio){
a_inicio.a_anterior = v_nodo;
v_nodo.a_siguiente = a_inicio;
a_inicio = v_nodo;
a_cantElementos++;
}
else
if(v_auxiliar==a_tope){
if(v_nodo.a_valor<=a_tope.a_valor){
a_tope.a_siguiente = v_nodo;
v_nodo.a_anterior = a_tope;
a_tope = v_nodo;
a_cantElementos++;
}
else{
v_auxiliar.a_anterior.a_siguiente = v_nodo;
v_nodo.a_siguiente = v_auxiliar;
v_nodo.a_anterior = v_auxiliar.a_anterior;
v_auxiliar.a_anterior = v_nodo;
a_cantElementos++;
}
}
else{
v_auxiliar.a_anterior.a_siguiente = v_nodo;
v_nodo.a_siguiente = v_auxiliar;
v_nodo.a_anterior = v_auxiliar.a_anterior;
v_auxiliar.a_anterior = v_nodo;
a_cantElementos++;
}
}
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
a_cantElementos--;
return v_nodoRetorno;
}
else{
while(v_auxiliar.a_siguiente!= a_tope)
v_auxiliar = v_auxiliar.a_siguiente;
v_nodoRetorno = a_tope;
a_tope = v_auxiliar;
a_tope.a_siguiente = null;
a_cantElementos--;
return v_nodoRetorno;
}
}
}
void m_vaciar(){
a_tope=null;
a_inicio=null;
a_cantElementos=0;
}
}
class nodo {
nodo a_siguiente;
nodo a_anterior;
int a_valor;
int a_nivel;
int a_vertice;
public nodo (int p_valor, int p_nivel, int p_vertice){
a_valor = p_valor;
a_nivel = p_nivel;
a_vertice = p_vertice;
nodo a_siguiente = null;
nodo a_anterior = null;
}
}

