package p243;

import java.util.Scanner;
public class p243 {
    Scanner a_tec = new Scanner(System.in);
    brazo[] a_brazos;
    public static void main(String[] args) {
        p243 v_obj = new p243();
        v_obj.entrada();
    }
    void entrada(){
        int v_cc,v_casos;
        v_casos = a_tec.nextInt();
        a_tec.nextLine();
        for (v_cc = 0; v_cc < v_casos; v_cc++)
            calcular();
    }
    void calcular(){
        int v_cc, v_cc2, v_cont = 0;
        String v_dato= "";
        int[] v_datos, v_angulos;
        do {
            v_dato += a_tec.nextLine();
            v_dato += "";
            v_datos = validar(v_dato);
        } while (v_datos[v_datos.length-1] != 0);
        a_brazos = new brazo[v_datos[0]];
        for (v_cc = 0; v_cc < a_brazos.length; v_cc++)
            a_brazos[v_cc] = new brazo(v_datos[v_cc+1],0);
        v_angulos = new int[(v_datos.length-1)-(v_datos[0]+1)];
        for (v_cc2 = v_datos[0]+1; v_cc2 < v_datos.length-1; v_cc2++) {
            v_angulos[v_cont] = v_datos[v_cc2];
            v_cont++;
        }
        asignar(v_angulos);
    }
    void asignar(int[] p_angulos){
        boolean v_valiStop = false;
        String v_respuesta = "";
        for (int v_cc = 0; v_cc < p_angulos.length; v_cc++) {
            a_brazos[p_angulos[v_cc]-1].setA_grados(a_brazos[p_angulos[v_cc]-1].getA_grados()+p_angulos[v_cc+1]);
            if(a_brazos[p_angulos[v_cc]-1].getA_grados() < 0){ // Respuesta negativa
                if(a_brazos[p_angulos[v_cc]-1].getA_grados() >= (a_brazos[p_angulos[v_cc]-1].getA_limite()*-1))
                    v_cc++;
                else{
                    v_respuesta = "STOP "+p_angulos[v_cc]+" "+a_brazos[p_angulos[v_cc]-1].getA_grados();
                    v_valiStop = true;
                    v_cc = p_angulos.length;
                }
            }else{ // Respuesta positiva
                if(a_brazos[p_angulos[v_cc]-1].getA_grados() <= a_brazos[p_angulos[v_cc]-1].getA_limite())
                    v_cc++;
                else{
                    v_respuesta = "STOP "+p_angulos[v_cc]+" "+a_brazos[p_angulos[v_cc]-1].getA_grados();
                    v_valiStop = true;
                    v_cc = p_angulos.length;
                }
            }
        }
        if(v_valiStop)
            System.out.println(v_respuesta);
        else{
            for (int v_cc2 = 0; v_cc2 < a_brazos.length; v_cc2++)
                v_respuesta += (v_cc2+1)+" "+a_brazos[v_cc2].getA_grados()+" ";
            System.out.println(v_respuesta.substring(0, v_respuesta.length()-1));
        }
    }
    int[] validar(String p_dato){
        int[] v_datos = null;
        int v_con, v_con2;
        try {
            int v_cont = 0, v_cont2 = 0;
            String[] v_aux = p_dato.split(" ");
            for(v_con = 0; v_con < v_aux.length; v_con++)
                if(!v_aux[v_con].equals(""))
                    v_cont ++;
            v_datos = new int[v_cont];
            for(v_con2 = 0; v_con2 < v_aux.length; v_con2++)
                if(!v_aux[v_con2].equals("")){
                    v_datos[v_cont2] = Integer.parseInt(v_aux[v_con2]);
                    v_cont2 ++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
    class brazo{
        private int a_limite;
        private int a_grados;
        public brazo(int a_limite, int a_grados) {
            this.a_limite = a_limite;
            this.a_grados = a_grados;
        }
        public int getA_grados() {
            return a_grados;
        }
        public void setA_grados(int a_grados) {
            this.a_grados = a_grados;
        }
        public int getA_limite() {
            return a_limite;
        }
        public void setA_limite(int a_limite) {
            this.a_limite = a_limite;
        }
    }
}
