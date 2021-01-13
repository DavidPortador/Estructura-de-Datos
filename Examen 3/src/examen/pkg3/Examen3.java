package examen.pkg3;

import java.util.Scanner;
public class Examen3 {
    Scanner tec = new Scanner(System.in);
    Vehiculo[] ar;
    public static void main(String[] args) {
        Examen3 obj = new Examen3();
        obj.entrada();
    }
    void entrada(){
        int caso,n;
        System.out.println("Ingrese el número de vehiculos: ");
        try {
            n = tec.nextInt();
            ar = new Vehiculo[n];
            for (int i = 0; i < ar.length; i++) {
                System.out.println("¿Qué carro es?\n1-Eléctrico\n2-Combustión");
                try {
                    caso = tec.nextInt();
                    tec.nextLine();
                    if(caso == 1){
                        ar[i] = new Electrico();
                        ar[i].capturar();
                        ar[i].calcularImpuesto();
                        ar[i].mostrar();
                    }if(caso == 2){
                        ar[i] = new Combustion();
                        ar[i].capturar();
                        ar[i].calcularImpuesto();
                        ar[i].mostrar();
                    }
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    abstract class Vehiculo{
        String color;
        String modelo;
        double precio;
        double impuesto;
        void capturar(){
            
        }
        void mostrar(){
            
        }
        void calcularImpuesto(){
            
        }
    }
    class Electrico extends Vehiculo{
        String modelobateria;
        void capturar(){
            try {
                System.out.println("Color: ");
                color = tec.nextLine();
                System.out.println("Modelo: ");
                modelo = tec.nextLine();
                System.out.println("Precio: ");
                precio = tec.nextDouble();
                tec.nextLine();
                System.out.println("Modelo de bateria: ");
                modelobateria = tec.nextLine();
            } catch (Exception e) {
            }
        }
        void mostrar(){
            System.out.println("El Vehiculo Eléctrico\nColor: "+color+"\nModelo: "+modelo+"\nPrecio: "+precio+"\nImpuesto: "
                    +impuesto+"\nModelo de bateria: "+modelobateria);
        }
        void calcularImpuesto(){
            impuesto = precio * .09;
        }
    }
    class Combustion extends Vehiculo{
        int cilindrada;
        
        void capturar(){
            try {
                System.out.println("Color: ");
                color = tec.nextLine();
                System.out.println("Modelo: ");
                modelo = tec.nextLine();
                System.out.println("Precio: ");
                precio = tec.nextDouble();
                System.out.println("Cilindrada: ");
                cilindrada = tec.nextInt();
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        void mostrar(){
            System.out.println("Vehiculo Eléctrico\nColor: "+color+"\nModelo: "+modelo+"\nPrecio: "+precio+"\nImpuesto: "
                    +impuesto+"\nCilindrada: "+cilindrada);
        }
        void calcularImpuesto(){
            impuesto = cilindrada * 3;
        }
    }
}
