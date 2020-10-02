package fibonacci.recursividad;

public class FibonacciRecursividad {
    public static void main(String[] args) {
        FibonacciRecursividad v_fbnc = new FibonacciRecursividad();
        v_fbnc.m_inicio();
    }
    void m_inicio(){
        int v_cont;
        System.out.print("0 ");
        for(v_cont=0;v_cont<20;v_cont++){
            System.out.print(m_calcular(v_cont)+" ");
        }
    }
    static int m_calcular(int p_cont){
        if (p_cont<2){
           return 1;
        }else{
           return m_calcular(p_cont-1)+m_calcular(p_cont-2);
        }
    } 
}