package fibonacci.recursividad;

import java.util.Scanner;
public class FibonacciRecursividad {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        FibonacciRecursividad v_fbnc = new FibonacciRecursividad();
        v_fbnc.m_inicio();
    }

    void m_inicio() {
        int v_cont, v_num;
        System.out.println("Ingresa el numero de fibonacci a calcular");
        v_num = a_tec.nextInt();
        System.out.print("0 ");
        for (v_cont = 0; v_cont < v_num - 1; v_cont++) 
            System.out.print(m_calcular(v_cont) + " ");
    }

    static int m_calcular(int p_cont) {
        if (p_cont < 2)
            return 1;
        else 
            return m_calcular(p_cont - 1) + m_calcular(p_cont - 2);
    }
}
