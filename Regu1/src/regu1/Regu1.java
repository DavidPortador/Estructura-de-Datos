package regu1;

import java.util.Scanner;

public class Regu1 {

    Scanner teclado = new Scanner(System.in);
    int[][] matriz;
    int ren, col;

    public static void main(String[] args) {
        Regu1 obj = new Regu1();
        obj.entrada();
    }
    void entrada(){
        
    }

    class mtz{
        void entrada() {
            //Para llenar matriz
            System.out.println("Ingresa el numero de renglones: ");
            ren = teclado.nextInt();
            System.out.println("Ingresa el numero de columnas: ");
            col = teclado.nextInt();
            matriz = new int[ren][col];
            for (int i = 0; i < ren; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.println("Ingresa el valor del elemento [" + i + "][" + j + "]");
                    matriz[i][j] = teclado.nextInt();
                }
            }
            System.out.println("\nMatriz Original");
            imprimir();
            System.out.println("\nMatriz Ordenada");
            ordenar();
            imprimir();
            maximo();
        }

        void imprimir() {
            for (int i = 0; i < ren; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println("");
            }
        }

        void ordenar() {
            for (int i = 0; i < col; i++) {
                metodoBurbujaDesc(i);
            }
        }

        void metodoBurbujaDesc(int col) {
            int i;
            boolean flag = true;
            int temp;

            while (flag) {
                flag = false;
                for (i = 0; i < ren - 1; i++) {
                    if (matriz[i][col] < matriz[i + 1][col]) {
                        temp = matriz[i][col];
                        matriz[i][col] = matriz[i + 1][col];
                        matriz[i + 1][col] = temp;
                        flag = true;
                    }
                }
            }
        }

        void maximo() {
            int val, max, aux;
            System.out.print("\nIngrese el renglon a buscar su maximo: ");
            val = teclado.nextInt();
            max = matriz[val][0];
            aux = 0;
            for (int i = 0; i < col; i++) {
                if (matriz[val][i] > max) {
                    max = matriz[val][i];
                    aux = i;
                }
            }
            System.out.println("Maximo: "+max+" en la columna: "+aux);
        }
    }
}
