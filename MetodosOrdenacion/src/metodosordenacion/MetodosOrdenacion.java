package metodosordenacion;

public class MetodosOrdenacion {

    public static void main(String[] args) {
        MetodosOrdenacion v_obj = new MetodosOrdenacion();
        v_obj.entrada();
    }
    void entrada(){
        System.out.println("Iteración vs Recursividad");
        System.out.println("Datos de prueba: [5, 10, 20, 40, 80, 160]");
        iteracion(10);
        recursividad(10);
    }
    void iteracion(int p_opc){
        long TInicio, TFin, Tiempo;
        TInicio = System.currentTimeMillis(); 
        int v_cont,v_izq=0,v_der=1,v_suma=1;
        for(v_cont=0;v_cont<p_opc;v_cont++){
            v_suma=v_izq+v_der;
            System.out.println((v_cont+1)+")"+v_izq+"+"+v_der+"="+v_suma);
            v_izq=v_der;
            v_der=v_suma;
        }
        TFin = System.currentTimeMillis();
        Tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " + Tiempo); 
    }
    int recursividad(int p_num){
        long TInicio, TFin, Tiempo;
        TInicio = System.currentTimeMillis(); 
        int resultado;
        if (p_num==1) 
            return 1;
        resultado=recursividad(p_num-1)*p_num;
        TFin = System.currentTimeMillis();
        Tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " + Tiempo); 
        return resultado;
    }
}
