package metodos.frescos;

public class MetodosFrescos {
    public static void main(String[] args) {
        System.out.println("--- Metodos re-frescos para programar osi osi ---");
        System.out.println("1) Retornar arreglo de numeros por espacios");
        System.out.println("2) Retornar arreglo de Strings");
        System.out.println("3) Retornar arreglo de numeros sin repeticiones");
        // alt + shif + f       Ordenar el codigo
        // ctrl + f            Buscar palabras en tdo el codigo
        // ctrl + shift + tab   Tabular a la izquierda
        
    }
// Toma de parametro una cadena y la devuelve como un arrelo entero separado por espacios
    int[] valiNum(String p_dato){
        int v_cc,v_cc2;
        int[] v_datos = null;
        try {
            int v_cont=0,v_cont2=0;
            String[] v_aux = p_dato.split(" ");
            for(v_cc=0;v_cc<v_aux.length;v_cc++)
                if(!v_aux[v_cc].equals(""))
                    v_cont++;
            v_datos = new int[v_cont];
            for(v_cc2=0;v_cc2<v_aux.length;v_cc2++)
                if(!v_aux[v_cc2].equals("")){
                    v_datos[v_cont2]= Integer.parseInt(v_aux[v_cc2]);
                    v_cont2++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
// Toma de parametro una cadena y la devuelve como un arrelo String separado por espacios
    String[] valiString(String p_dato){
        String[] v_datos = null;
        int v_con,v_con2;
        try {
            int v_cont = 0,v_cont2 = 0;
            String[] v_aux = p_dato.split(" ");
            for(v_con = 0; v_con < v_aux.length; v_con++)
                if(!v_aux[v_con].equals(""))
                    v_cont++;
            v_datos = new String[v_cont];
            for(v_con2 = 0;v_con2 < v_aux.length; v_con2++)
                if(!v_aux[v_con2].equals("")){
                    v_datos[v_cont2]= v_aux[v_con2];
                    v_cont2++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
// Toma de parametro un arreglo y lo devuelve sin datos repetidos
    int[] sinRepeticiones(int[] p_datos){
        int [] sinRepetir;
        int v_cc, v_cc2, v_cont = 0;
        for(v_cc = 0; v_cc < (p_datos.length-1); v_cc++)
            if(p_datos[v_cc]!=p_datos[v_cc+1])
               p_datos[v_cont++] = p_datos[v_cc];
        p_datos[v_cont++] = p_datos[p_datos.length-1];
        sinRepetir = new int[v_cont];
        for(v_cc2 = 0; v_cc2 < v_cont; v_cc2++)
            sinRepetir[v_cc2] = p_datos[v_cc2];
        return sinRepetir;
    }
    
}
