package ordenamientosinternos;

import java.util.Scanner;
public class OrdenamientosInternos {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        OrdenamientosInternos v_obj = new OrdenamientosInternos();
        v_obj.entrada();
    }

    void getDatos() { // Metodo para obtener los valores a ordenar (entre 0 y 1000)
        int valorEntero;
        for (int v_cc = 0; v_cc < 10000; v_cc++) {
            valorEntero = (int) Math.floor(Math.random() * (1000 - 0 + 1) + 0);
            System.out.println(valorEntero);
        }
    }

    void entrada() {
        int[] v_burb, v_sele, v_inse, v_shll, v_heap, v_qick;
        int v_can, v_cc, v_aux;
        System.out.println("Ingrese la cantidad de datos a evaluar: ");
        try {
            v_can = a_tec.nextInt();
            v_burb = new int[v_can];
            v_sele = new int[v_can];
            v_inse = new int[v_can];
            v_shll = new int[v_can];
            v_heap = new int[v_can];
            v_qick = new int[v_can];
            System.out.println("Valores: ");
            for (v_cc = 0; v_cc < v_can; v_cc++) {
                v_aux = a_tec.nextInt();
                v_burb[v_cc] = v_aux;
                v_sele[v_cc] = v_aux;
                v_inse[v_cc] = v_aux;
                v_shll[v_cc] = v_aux;
                v_heap[v_cc] = v_aux;
                v_qick[v_cc] = v_aux;
            }
            evaluar(v_burb, v_sele, v_inse, v_shll, v_heap, v_qick);
        } catch (Exception e) {
        }
    }

    void evaluar(int[] v_burb, int[] v_sele, int[] v_inse, int[] v_shll, int[] v_heap, int[] v_qick) {
        Metodos v_ope = new Metodos();
        v_ope.burbuja(v_burb);
        v_ope.seleccion(v_sele);
        v_ope.insercion(v_inse);
        v_ope.shell(v_shll);
        v_ope.heap(v_heap);
        v_ope.quick(v_qick);
    }

    class Metodos {

        void burbuja(int[] p_valores) {
            long time_start, time_end;
            int v_cc, v_cc2, v_aux;
            time_start = System.currentTimeMillis();
            //
            for (v_cc = 0; v_cc < p_valores.length - 1; v_cc++) {
                for (v_cc2 = 0; v_cc2 < p_valores.length - v_cc - 1; v_cc2++)
                    if (p_valores[v_cc2 + 1] < p_valores[v_cc2]) {
                        v_aux = p_valores[v_cc2 + 1];
                        p_valores[v_cc2 + 1] = p_valores[v_cc2];
                        p_valores[v_cc2] = v_aux;
                    }
            }
            //
            time_end = System.currentTimeMillis();
            System.out.println("Burbuja:   " + (time_end - time_start) + " milisegundos");
            //
            System.out.print("   --> ");
            for (int v_contDatos = 0; v_contDatos < p_valores.length; v_contDatos++)
                System.out.print(p_valores[v_contDatos] + ", ");
            System.out.println("");
        }

        void seleccion(int[] p_valores) {
            long time_start, time_end;
            int v_cc, v_cc2, v_menor, v_pos, v_tem;
            time_start = System.currentTimeMillis();
            //
            for (v_cc = 0; v_cc < p_valores.length - 1; v_cc++) {
                v_menor = p_valores[v_cc];
                v_pos = v_cc;
                for (v_cc2 = v_cc + 1; v_cc2 < p_valores.length; v_cc2++)
                    if (p_valores[v_cc2] < v_menor) {
                        v_menor = p_valores[v_cc2];
                        v_pos = v_cc2;
                    }
                if (v_pos != v_cc) {
                    v_tem = p_valores[v_cc];
                    p_valores[v_cc] = p_valores[v_pos];
                    p_valores[v_pos] = v_tem;
                }
            }
            //
            time_end = System.currentTimeMillis();
            System.out.println("Seleccion: " + (time_end - time_start) + " milisegundos");
            //
            System.out.print("   --> ");
            for (int v_contDatos = 0; v_contDatos < p_valores.length; v_contDatos++) {
                System.out.print(p_valores[v_contDatos] + ", ");
            }
            System.out.println("");
        }

        void insercion(int[] p_valores) {
            long time_start, time_end;
            int v_cc, v_cc2, v_aux;
            time_start = System.currentTimeMillis();
            //
            for (v_cc = 1; v_cc < p_valores.length; v_cc++) {
                v_aux = p_valores[v_cc];
                v_cc2 = v_cc - 1;
                while ((v_cc2 >= 0) && (v_aux < p_valores[v_cc2])) {
                    p_valores[v_cc2 + 1] = p_valores[v_cc2];
                    v_cc2--;
                }
                p_valores[v_cc2 + 1] = v_aux;
            }
            //
            time_end = System.currentTimeMillis();
            System.out.println("Insercion: " + (time_end - time_start) + " milisegundos");

            System.out.print("   --> ");
            for (int v_contDatos = 0; v_contDatos < p_valores.length; v_contDatos++) {
                System.out.print(p_valores[v_contDatos] + ", ");
            }
            System.out.println("");
        }

        void shell(int[] p_valores) {
            long time_start, time_end;
            int v_salto, v_aux, v_cc;
            boolean v_cambio;
            time_start = System.currentTimeMillis();
            //
            for (v_salto = p_valores.length / 2; v_salto != 0; v_salto /= 2) {
                v_cambio = true;
                while (v_cambio) {
                    v_cambio = false;
                    for (v_cc = v_salto; v_cc < p_valores.length; v_cc++)
                        if (p_valores[v_cc - v_salto] > p_valores[v_cc]) {
                            v_aux = p_valores[v_cc];
                            p_valores[v_cc] = p_valores[v_cc - v_salto];
                            p_valores[v_cc - v_salto] = v_aux;
                            v_cambio = true;
                        }
                }
            }
            //
            time_end = System.currentTimeMillis();
            System.out.println("Shell:     " + (time_end - time_start) + " milisegundos");
            System.out.print("   --> ");
            for (int v_contDatos = 0; v_contDatos < p_valores.length; v_contDatos++)
                System.out.print(p_valores[v_contDatos] + ", ");
            System.out.println("");
        }

        void heap(int[] p_valores) {
            long time_start, time_end;
            time_start = System.currentTimeMillis();
            //
            int v_num;
            v_num = p_valores.length;
            for (int v_cc = v_num / 2 - 1; v_cc >= 0; v_cc--)
                heapRec(p_valores, v_num, v_cc);
            for (int v_cc = v_num - 1; v_cc >= 0; v_cc--) {
                int temp = p_valores[0];
                p_valores[0] = p_valores[v_cc];
                p_valores[v_cc] = temp;
                heapRec(p_valores, v_cc, 0);
            }
            //
            time_end = System.currentTimeMillis();
            System.out.println("Heap:      " + (time_end - time_start) + " milisegundos");
            System.out.print("   --> ");
            for (int v_contDatos = 0; v_contDatos < p_valores.length; v_contDatos++)
                System.out.print(p_valores[v_contDatos] + ", ");
            System.out.println("");
        }

        void heapRec(int arr[], int p_num, int v_cc) {
            int v_long, v_izq, v_der;
            v_long = v_cc;
            v_izq = 2 * v_cc + 1;
            v_der = 2 * v_cc + 2;
            if (v_izq < p_num && arr[v_izq] > arr[v_long])
                v_long = v_izq;
            if (v_der < p_num && arr[v_der] > arr[v_long])
                v_long = v_der;
            if (v_long != v_cc) {
                int swap = arr[v_cc];
                arr[v_cc] = arr[v_long];
                arr[v_long] = swap;
                heapRec(arr, p_num, v_long);
            }
        }

        void quick(int[] p_valores) {
            long time_start, time_end;
            time_start = System.currentTimeMillis();
            //
            quicksort(p_valores, 0, p_valores.length - 1);
            //
            time_end = System.currentTimeMillis();
            System.out.println("Quick:     " + (time_end - time_start) + " milisegundos");
            System.out.print("   --> ");
            for (int v_contDatos = 0; v_contDatos < p_valores.length; v_contDatos++)
                System.out.print(p_valores[v_contDatos] + ", ");
            System.out.println("");
        }

        void quicksort(int A[], int izq, int der) {
            int pivote = A[izq];
            int i = izq;
            int j = der;
            int aux;
            while (i < j) {
                while (A[i] <= pivote && i < j)
                    i++;
                while (A[j] > pivote)
                    j--;
                if (i < j) {
                    aux = A[i];
                    A[i] = A[j];
                    A[j] = aux;
                }
            }
            A[izq] = A[j];
            A[j] = pivote;
            if (izq < j - 1)
                quicksort(A, izq, j - 1);
            if (j + 1 < der)
                quicksort(A, j + 1, der);
        }
    }
}
