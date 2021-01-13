package p253;

import java.text.DecimalFormat;
import java.util.Scanner;
public class p253 {
    Scanner a_tec = new Scanner(System.in);
    double [] a_neuronas;
    double a_sumatoria = 0;
    public static void main(String[] args) {
        p253 v_obj = new p253();
        v_obj.entrada();
    }
    void entrada(){
        int v_nn;
        String v_valores = "";
        v_nn = a_tec.nextInt();
        if(v_nn > 0 && v_nn < 100){
            do {                
                v_valores += a_tec.nextLine() + " ";
                a_neuronas = validar(v_valores);
            } while (a_neuronas.length < v_nn);
            casos();
        }
    }
    void casos(){
        DecimalFormat v_df = new DecimalFormat("#.00");
        int v_cc, v_cc2, v_nc;
        double[] v_casos;
        String v_aux, v_salida = null;
        v_nc = a_tec.nextInt();
        a_tec.nextLine();
        if(v_nc > 0 && v_nc < 10)
            for (v_cc = 0; v_cc < v_nc; v_cc++) {
                v_aux = a_tec.nextLine();
                v_casos = validar(v_aux);
                if(v_casos.length == a_neuronas.length){
                    for (v_cc2 = 0; v_cc2 < a_neuronas.length; v_cc2++)
                        a_sumatoria += a_neuronas[v_cc2] * v_casos[v_cc2];
                    a_sumatoria = Double.parseDouble(v_df.format(a_sumatoria));
                    if(get_Salida(a_sumatoria*a_neuronas.length) == 1)
                        v_salida = "ACTIVA";
                    else if(get_Salida(a_sumatoria*a_neuronas.length) == 0)
                        v_salida = "PASIVA";
                    if(a_sumatoria < 1)
                        System.out.println("0"+v_df.format(a_sumatoria)+" "+v_salida);
                    else
                        System.out.println(v_df.format(a_sumatoria)+" "+v_salida);
                    a_sumatoria = 0;
                    v_salida = null;
                }
            }
    }
    double[] validar(String p_dato){
        double[] v_datos = null;
        int v_con, v_con2;
        try {
            int v_cont = 0, v_cont2 = 0;
            String[] v_aux = p_dato.split(" ");
            for(v_con = 0; v_con < v_aux.length; v_con++)
                if(!v_aux[v_con].equals(""))
                    v_cont ++;
            v_datos = new double[v_cont];
            for(v_con2 = 0; v_con2 < v_aux.length; v_con2++)
                if(!v_aux[v_con2].equals("")){
                    v_datos[v_cont2] = Double.parseDouble(v_aux[v_con2]);
                    v_cont2 ++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
    int get_Salida(double p_num){
        return (int) Math.round(Math.abs(Math.sin(p_num)));
    }
}