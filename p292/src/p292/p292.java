package p292;

import java.util.Scanner;
public class p292 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        p292 v_obj = new p292();
        v_obj.entrada();
    }
    void entrada(){
        int v_cc, v_casos;
        float v_v1, v_v2;
        String v_dato;
        String [] v_datos;
        v_casos = a_tec.nextInt();
        a_tec.nextLine();
        if(v_casos > 0)
            for (v_cc = 0; v_cc  < v_casos; v_cc ++) {
                v_dato = a_tec.nextLine();
                v_datos = v_dato.split(" ");
                v_v1 = Float.parseFloat(v_datos[0]);
                v_v2 = Float.parseFloat(v_datos[1]);
                if(v_v1 < 0)
                    System.out.println("null");
                else
                    truncar(calcular(v_v1,v_v2)+"");
            }
    }
    float calcular(float p_v1, float p_v2){
        if(p_v1 == 0)
            return 1;
        else if(p_v1 == 1)
            return p_v2 * 2;
        else
            return (2 *p_v2) *calcular(p_v1 -1, p_v2) -2*(p_v1 -1) * calcular(p_v1 -2, p_v2);
    }
    void truncar(String p_resul){
        int v_cc;
        String v_enteros = "", v_decimales = "";
        for (v_cc = 0; v_cc < p_resul.length(); v_cc++) 
            if(p_resul.charAt(v_cc) == '.'){
                v_enteros = p_resul.substring(0, v_cc);
                v_decimales = p_resul.substring(v_cc+1, p_resul.length());
            }
        if(v_decimales.length() == 1)
            System.out.println(p_resul+"0");
        else
            System.out.println(v_enteros+"."+v_decimales.substring(0, 2));
    }
}