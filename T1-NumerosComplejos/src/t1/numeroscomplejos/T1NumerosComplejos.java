package t1.numeroscomplejos;
import java.util.Scanner;

public class T1NumerosComplejos {
    // Declaracion de atributos
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        T1NumerosComplejos v_obj = new T1NumerosComplejos();
        v_obj.crearMenu();
    }
    // Valida la cantidad de numeros a manejar y crea el arreglo
    void crearMenu(){
        int v_long;
        v_long = valiEntero("¿Cúantos numeros manejará?\n[min: 2, max: 10] Opción: ");
        if(v_long<2 || v_long>10) 
            crearMenu();
        else
            menu(v_long);
    }
    void menu(int p_long){
        Numeros v_numeros = new Numeros(p_long);
        int v_opc;
        while(true){
            System.out.println("\nDatos: "+p_long);
            System.out.println("1) Sumar");
            System.out.println("2) Restar");
            System.out.println("3) Multiplicar");
            System.out.println("4) Dividir");
            System.out.println("5) Mostrar números");
            System.out.println("6) Mostrar procedimientos");
            System.out.println("7) Salir");
            v_opc = valiEntero("Opcion: ");
            switch(v_opc){
                case 1: v_numeros.sumar(); break;
                case 2: v_numeros.restar(); break;
                case 3: v_numeros.multiplicar(); break;
                case 4: v_numeros.dividir(); break;
                case 5: v_numeros.mostrarNumeros(); break;
                case 6: v_numeros.mostarDatos();break;
                case 7: System.exit(0); break;
            }
        }
    }
    int valiEntero(String p_texto){
        int v_num;
        while(true){
            System.out.print(p_texto);
            try {
                v_num = a_tec.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("No es entero");
                a_tec = new Scanner(System.in);
            }
        }
        return v_num;
    }
}