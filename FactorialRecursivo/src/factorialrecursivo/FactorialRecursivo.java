package factorialrecursivo;

import java.util.Scanner;
public class FactorialRecursivo {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        FactorialRecursivo v_obj = new FactorialRecursivo();
        v_obj.entrada();
    }

    void entrada() {
        int v_num;
        try {
            System.out.println("Ingresa un número entero: ");
            v_num = a_tec.nextInt();
            System.out.println("Factorial de " + v_num + " es: " + factorial(v_num));
        } catch (Exception e) {
            a_tec = new Scanner(System.in);
            System.out.println("Ingrese un dato valido");
            entrada();
        }
    }

    int factorial(int p_num) {
        int resultado;
        if (p_num == 1)
            return 1;
        resultado = factorial(p_num - 1) * p_num;
        return resultado;
    }
}
