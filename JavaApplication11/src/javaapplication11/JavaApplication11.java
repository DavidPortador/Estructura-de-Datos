package javaapplication11;

public class JavaApplication11 {

    public static void main(String[] args) {
        // 1,2,3,3
        JavaApplication11 v_obj = new JavaApplication11();
        int[] v_arr ={1,2,3,3,4,4,4}; 
        v_obj.sinRepeticiones(v_arr);
    }
    void sinRepeticiones(int[] p_datos){
        int v_cont = 0;
        for(int i=0;i<(p_datos.length-1);i++)
            if(p_datos[i]!=p_datos[i+1])
               p_datos[v_cont++] = p_datos[i];
        p_datos[v_cont++] = p_datos[p_datos.length-1];
        int [] sinRepetir = new int[v_cont];
        for(int k = 0;k<v_cont;k++)
        sinRepetir[k] = p_datos[k];
        for(int l=0;l<sinRepetir.length;l++)
            System.out.println(sinRepetir[l]);
    }
}
