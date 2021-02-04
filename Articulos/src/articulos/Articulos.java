package articulos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Articulos {

    Scanner a_tec = new Scanner(System.in);

    public static void main(String[] args) {
        Articulos obj = new Articulos();
        obj.entrada();
    }

    void entrada() {
        Scanner a_tec = new Scanner(System.in);
        Departamento Depa = new Departamento();
        inventario Inve = new inventario();
        RandomAccessFile depa;
        RandomAccessFile inve;
        depa = null;
        inve = null;
        String decide = "";
        String otra, otrap, bus;
        int elige, a_cantidad;
        boolean v_encontrar = true;
        otrap = "si";
        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("Elige la opcion que necesites: \na)DEPARTAMENTOS \nb)INVENTARIOS \nc)CAJERO \nd)SALIR ");
            decide = a_tec.nextLine();
            switch (decide) {
                case "a":
                case "A":
                    otra = "si";
                    while (otra.equalsIgnoreCase("si")) {
                        System.out.println("MENU");
                        System.out.println("Elige la opcion que necesites: \n1)Ingresar datos de departamentos\n2)Ordenar fichero departamentos\n"
                                + "3)Mostrar fichero actual \n4)Generar Reporte \n5)Modificar registros \n6)Salir ");
                        elige = a_tec.nextInt();
                        switch (elige) {
                            case 1:
                                depa = Depa.EscrDatoDepartamento();
                                break;
                            case 2:
                                Depa.ordeFichero(depa);
                                break;
                            case 3:
                                Depa.MostDepartamento(depa);
                                break;
                            case 4:
                                Depa.repoDepartamentos(depa);
                                break;
                            case 5:
                                System.out.println("Ingrese la clave para buscar si se encuentra en el fichero");
                                a_tec.nextLine();
                                bus = a_tec.nextLine();
                                v_encontrar = Depa.busquedaBinaria(depa, bus);
                                if (v_encontrar == true) {
                                    Depa.Modificar(depa, bus);
                                }
                                break;
                            default:
                                System.out.println("Saliendo!!");
                                System.out.println("Enter para regresar al menu principal");
                                elige = 6;
                        }
                        if (elige == 6) {
                            otra = "no";
                            otrap = "si";
                        } else {
                            System.out.println("Desea elegir otra opcion en el menu de departamentos? ");
                        }
                        a_tec.nextLine();
                        otra = a_tec.nextLine();

                    }
                    break;
                case "b":
                case "B":
                    otra = "si";

                    while (otra.equalsIgnoreCase("si")) {
                        System.out.println("MENU DE INVENTARIOS");
                        System.out.println("Elige la opcion que necesites: \n1)Ingresar datos de inventario\n2)Ordenar por producto\n"
                                + "3)Mostrar fichero actual \n4)Reporte General Inventario \n5)Modificar registros \n6)Ordenar por departamento "
                                + "\n7)Reporte por productos \n8)Reporte pedidos \n9)Salir");
                        elige = a_tec.nextInt();
                        switch (elige) {
                            case 1:
                                inve = Inve.EscrDatoInventario();
                                break;
                            case 2:
                                Inve.ordeFichero(inve);
                                break;
                            case 3:
                                Inve.mostInventario(inve);
                                break;
                            case 4:
                                Inve.repoInventario(inve);
                                break;
                            case 5:
                                System.out.println("Ingrese la clave para buscar si se encuentra en el fichero");
                                a_tec.nextLine();
                                bus = a_tec.nextLine();
                                v_encontrar = Inve.busquedaBinaria(inve, bus);
                                if (v_encontrar == true) {
                                    Inve.Modificar(inve, bus);
                                }
                                break;
                            case 6:
                                Inve.ordeFicheDepartamentos(inve);
                                break;

                            case 7:
                                Inve.repoInveProductos(depa, inve);
                                break;

                            case 8:
                                Inve.repoPedidos(inve);
                                break;

                            default:

                                System.out.println("Saliendo!!!");
                                System.out.println("Enter para regresar al menu principal");
                                elige = 9;
                        }

                        if (elige == 9) {
                            otra = "no";
                            otrap = "si";
                        } else {
                            System.out.println("Desea elegir otra opcion en el menu de inventarios?");
                        }
                        a_tec.nextLine();
                        otra = a_tec.nextLine();
                    }
                    break;
                case "c":
                case "C":
                    System.out.println("Ingresa la clave del producto");
                    bus = a_tec.nextLine();
                    Inve.m_cajeCompras(inve, bus);

                    break;

                case "d":
                case "D":
                    System.out.println("Salio del programa con exito!!");
                    otrap = "no";
                    break;
                default:
                    System.out.println("Opcion no valida!!!");
                    if (decide == "d" || decide == "D") {
                        otra = "no";
                    } else {
                        System.out.println("Desea elegir algo de nuevo en el menu?");
                    }

                    otra = a_tec.nextLine();
            }
        } while (otrap.equalsIgnoreCase("si"));
    }

    class inventario {

        RandomAccessFile salida;
        RandomAccessFile depa;
        int a_tamaRegistro = 78, numRe, pm;

        RandomAccessFile EscrDatoInventario() {
            boolean v_decision = true;
            Departamento Objeto = new Departamento();
            try {
                String v_clavDep = "";
                do {
                    depa = new RandomAccessFile("Departamento.dat", "rw");
                    System.out.println("Ingresa la clave de departamento");
                    v_clavDep = a_tec.nextLine();
                    v_clavDep = String.format("%-4s", v_clavDep);
                    v_decision = Objeto.busquedaBinaria(depa, v_clavDep);
                } while (v_decision == false);

            } catch (IOException e) {
                System.out.println("No se logro abrir correctamente el fichero \n" + e.toString());
            }
            if (v_decision = true) {
                System.out.println("Se encontro el departamento");
            }
            String a_clavProducto, a_nombProducto, a_clavDepa, a_unidMedida;
            double a_precUnitario;
            int a_existencias, a_exisMinima;
            String resp = "respuesta";
            try {
                salida = new RandomAccessFile("Inventario.dat", "rw");
                System.out.println("Tamaño del archivo " + salida.length());
                System.out.println("CLAVE|DEPTO|PRODUCTO|                        P.U.|TOTAL"
                        + "|  MEDIDA  |     MINIMO ");
                System.out.println("-----------------------------------"
                        + "--------------------------------------------------");
                salida.seek(salida.length());
                do {
                    System.out.println("Ingresa Clave del producto");
                    a_clavProducto = a_tec.nextLine();
                    a_clavProducto = String.format("%-5s", a_clavProducto); //P1010

                    System.out.println("Ingresa Clave del departamento");
                    a_clavDepa = a_tec.nextLine();
                    a_clavDepa = String.format("%-4s", a_clavDepa); //P1010

                    System.out.println("Ingresa el nombre del producto");
                    a_nombProducto = a_tec.nextLine();
                    a_nombProducto = String.format("%-30s", a_nombProducto); //Martillo

                    System.out.println("Ingresa su precio unitario");
                    a_precUnitario = a_tec.nextDouble();//3.4

                    System.out.println("Ingresa el total de existencia del producto");
                    a_existencias = a_tec.nextInt();//100
                    a_tec.nextLine();

                    System.out.println("Ingresa la unidad de medida del producto");
                    a_unidMedida = a_tec.nextLine();
                    a_unidMedida = String.format("%-15s", a_unidMedida); //Metros

                    System.out.println("Ingresa la minima cantidad de existencia del producto");//20
                    a_exisMinima = a_tec.nextInt();

                    salida.writeUTF(a_clavProducto);
                    salida.writeUTF(a_clavDepa);
                    salida.writeUTF(a_nombProducto);
                    salida.writeDouble(a_precUnitario);
                    salida.writeInt(a_existencias);
                    salida.writeUTF(a_unidMedida);
                    salida.writeInt(a_exisMinima);
                    System.out.println("Desea ingresar otro registro? (si/no)");
                    a_tec.nextLine();
                    resp = a_tec.nextLine();
                } while (resp.toUpperCase().equals("SI"));
                salida.close();
                System.out.println("Se logro registrar con exito!! " + "Inventario.dat");

            } catch (IOException e) {
                System.out.println("No se logro abrir correctamente el fichero \n" + e.toString());
            }
            return salida;
        }

        public void mostInventario(RandomAccessFile entrada) {
            String a_clavProducto, a_nombProducto, a_clavDepa, a_unidMedida;
            double a_precUnitario;
            int a_existencias, a_exisMinima;
            String fichero = "respuesta";
            fichero = "Inventario.dat";

            try {
                entrada = new RandomAccessFile(fichero, "rw");
                System.out.println("Tamaño del archivo " + entrada.length());
                System.out.println("CLAVE|DEPTO|PRODUCTO|                        P.U.|TOTAL"
                        + "|  MEDIDA  |     MINIMO ");
                System.out.println("-----------------------------------"
                        + "--------------------------------------------------");
                long registros = entrada.length() / a_tamaRegistro;
                entrada.seek(0);
                int i = 0;
                for (i = 0; i < registros; i++) {

                    a_clavProducto = entrada.readUTF();
                    a_clavDepa = entrada.readUTF();
                    a_nombProducto = entrada.readUTF();
                    a_precUnitario = entrada.readDouble();
                    a_existencias = entrada.readInt();
                    a_unidMedida = entrada.readUTF();
                    a_exisMinima = entrada.readInt();

                    System.out.println(a_clavProducto + "  " + a_clavDepa + "  " + a_nombProducto + "  "
                            + a_precUnitario + "  " + a_existencias + "  " + a_unidMedida + "  " + a_exisMinima);
                }
                entrada.close();
                System.out.println("Se mostraron con exito los ultimos datos " + fichero);
            } catch (IOException e) {
                System.out.println(" No se abrio bien el fichero \n" + e.toString());
            }

        }

        public void ordeFichero(RandomAccessFile leer) {
            String aux, aux2, aux3, auxUnidad, l1, l2, l3, lUnidad;
            int auxMax, auxMin, lMax, lMin;
            double auxPrecio, lprecio;
            boolean f = false;
            do {
                try {
                    f = false;
                    leer = new RandomAccessFile("Inventario.dat", "rw");
                    numRe = (int) (leer.length() / a_tamaRegistro);

                    for (int pas = 1; pas < numRe; pas++) {
                        for (int com = 1, k = 0; com <= (numRe - pas); com++, k += 78) {
                            leer.seek(k);
                            aux = leer.readUTF();
                            aux2 = leer.readUTF();
                            aux3 = leer.readUTF();
                            auxPrecio = leer.readDouble();
                            auxMax = leer.readInt();
                            auxUnidad = leer.readUTF();
                            auxMin = leer.readInt();

                            leer.seek(0);
                            leer.seek(k + 78);
                            l1 = leer.readUTF();
                            l2 = leer.readUTF();
                            l3 = leer.readUTF();
                            lprecio = leer.readDouble();
                            lMax = leer.readInt();
                            lUnidad = leer.readUTF();
                            lMin = leer.readInt();

                            if (aux.compareToIgnoreCase(l1) > 0) {
                                leer.seek(k);
                                leer.writeUTF(l1);
                                leer.writeUTF(l2);
                                leer.writeUTF(l3);
                                leer.writeDouble(lprecio);
                                leer.writeInt(lMax);
                                leer.writeUTF(lUnidad);
                                leer.writeInt(lMin);

                                leer.seek(0);
                                leer.seek(k + 78);
                                leer.writeUTF(aux);
                                leer.writeUTF(aux2);
                                leer.writeUTF(aux3);
                                leer.writeDouble(auxPrecio);
                                leer.writeInt(auxMax);
                                leer.writeUTF(auxUnidad);
                                leer.writeInt(auxMin);
                            }
                        }
                    }
                    leer.close();
                    System.out.println("Se ordeno correctamente el archivo!!");
                } catch (IOException e) {
                    System.out.println("Fichero " + " ordenar Departamento no encontrado" + e.toString());

                }
            } while (f);
        }

        public void ordeFicheDepartamentos(RandomAccessFile leer) {
            String aux, aux2, aux3, auxUnidad, l1, l2, l3, lUnidad;
            int auxMax, auxMin, lMax, lMin;
            double auxPrecio, lprecio;
            boolean f = false;
            do {
                try {
                    f = false;
                    leer = new RandomAccessFile("Inventario.dat", "rw");
                    numRe = (int) (leer.length() / a_tamaRegistro);

                    for (int pas = 1; pas < numRe; pas++) {
                        for (int com = 1, k = 0; com <= (numRe - pas); com++, k += 78) {
                            leer.seek(k);
                            aux = leer.readUTF();
                            aux2 = leer.readUTF();
                            aux3 = leer.readUTF();
                            auxPrecio = leer.readDouble();
                            auxMax = leer.readInt();
                            auxUnidad = leer.readUTF();
                            auxMin = leer.readInt();

                            leer.seek(0);
                            leer.seek(k + 78);
                            l1 = leer.readUTF();
                            l2 = leer.readUTF();
                            l3 = leer.readUTF();
                            lprecio = leer.readDouble();
                            lMax = leer.readInt();
                            lUnidad = leer.readUTF();
                            lMin = leer.readInt();

                            if (aux2.compareToIgnoreCase(l2) > 0) {
                                leer.seek(k);
                                leer.writeUTF(l1);
                                leer.writeUTF(l2);
                                leer.writeUTF(l3);
                                leer.writeDouble(lprecio);
                                leer.writeInt(lMax);
                                leer.writeUTF(lUnidad);
                                leer.writeInt(lMin);

                                leer.seek(0);
                                leer.seek(k + 78);
                                leer.writeUTF(aux);
                                leer.writeUTF(aux2);
                                leer.writeUTF(aux3);
                                leer.writeDouble(auxPrecio);
                                leer.writeInt(auxMax);
                                leer.writeUTF(auxUnidad);
                                leer.writeInt(auxMin);
                            }
                        }
                    }
                    leer.close();
                    System.out.println("Se ordeno correctamente el archivo!!");
                } catch (IOException e) {
                    System.out.println("Fichero " + " ordenar Departamento no encontrado" + e.toString());

                }
            } while (f);
        }

        public void repoInventario(RandomAccessFile salida) {

            try {
                PrintWriter reporte;
                salida = new RandomAccessFile("Inventario.dat", "rw");
                int numRe = (int) (salida.length() / a_tamaRegistro);
                reporte = new PrintWriter(new FileWriter("reporteInventario.txt", true));
                reporte.println("\t\t                 REPORTE INVENTARIO ");
                reporte.println("--------------------------------------------------------------------------------");
                reporte.println(String.format("%-5s%-4s%-33s%-8s%-4s%-15s%-4s", "CLAVE ", "DEPTO ", "NOMBRE", "P.U.",
                        "TOTAL", " MEDIDA ", "MINIMO"));
                reporte.println("-----------------------------------"
                        + "---------------------------------------------\n");
                salida.seek(0);
                String auxclavProducto, auxnom, auxclavDepa, auxunidMedida;
                double auxprecUnitario;
                int auxExistencias, auxexisMinimas;

                numRe = (int) (salida.length() / a_tamaRegistro);
                for (int i = 0; i < numRe; i++) {
                    auxclavProducto = salida.readUTF();
                    auxclavDepa = salida.readUTF();
                    auxnom = salida.readUTF();
                    auxprecUnitario = salida.readDouble();
                    auxExistencias = salida.readInt();
                    auxunidMedida = salida.readUTF();
                    auxexisMinimas = salida.readInt();
                    reporte.write(String.format("%-5s %-4s %-30s %10.2f %4d %-15s %4d \n", auxclavProducto, auxclavDepa, auxnom, auxprecUnitario, auxExistencias, auxunidMedida, auxexisMinimas));

                }
                System.out.println("Se logro generar el reporte con exito!!!");
                salida.close();
                reporte.close();

            } catch (IOException e) {
                System.out.println("No se logro abrir el archivo");
            }
        }

        public void repoInveProductos(RandomAccessFile salida, RandomAccessFile salida2) {
            try {
                String auxclavDepa, auxnomDepa;
                String auxclavProducto, auxnom, auxclavDepa2, auxunidMedida;
                double auxprecUnitario;
                int auxExistencias, auxexisMinimas;
                int a_tamaRegisDepa = 38;
                PrintWriter reporte;
                reporte = new PrintWriter(new FileWriter("reporteProductos.txt", true));
                salida = new RandomAccessFile("Departamento.dat", "rw");
                salida.seek(0);
                int numRen = (int) (salida.length() / a_tamaRegisDepa);
                salida2 = new RandomAccessFile("Inventario.dat", "rw");
                int numRe2 = (int) (salida2.length() / a_tamaRegistro);

                for (int i = 0; i < numRen; i++) {
                    auxclavDepa = salida.readUTF();
                    auxnomDepa = salida.readUTF();
                    reporte.println("\n");
                    reporte.write(String.format("DEPARTAMENTO = %-4s %-30s\n", auxclavDepa, auxnomDepa));
                    reporte.println("---------------------------------------------------------------------------");
                    salida2.seek(0);
                    reporte.println(String.format("%-5s %-33s %-6s %-4s %-15s %-4s ", "CLAVE", " NOMBRE", "P.U.",
                            "TOTAL", " MEDIDA ", "MINIMO"));
                    reporte.println("---------------------------------------------------------------------------\n");
                    for (int k = 0; k < numRe2; k++) {

                        auxclavProducto = salida2.readUTF();
                        auxclavDepa2 = salida2.readUTF();
                        auxnom = salida2.readUTF();
                        auxprecUnitario = salida2.readDouble();
                        auxExistencias = salida2.readInt();
                        auxunidMedida = salida2.readUTF();
                        auxexisMinimas = salida2.readInt();

                        if (auxclavDepa.equalsIgnoreCase(auxclavDepa2)) {
                            reporte.write(String.format("%-5s %-30s %10.2f %4d %-15s %4d \n", auxclavProducto, auxnom, auxprecUnitario, auxExistencias, auxunidMedida, auxexisMinimas));
                        }

                    }
                }

                System.out.println("Se logro generar el reporte con exito!!!");
                salida.close();
                salida2.close();
                reporte.close();

            } catch (IOException e) {
                System.out.println("No se logro abrir el archivo");
            }
        }

        public void repoPedidos(RandomAccessFile salida) {

            try {
                PrintWriter reporte;
                salida = new RandomAccessFile("Inventario.dat", "rw");
                int numRe = (int) (salida.length() / a_tamaRegistro);
                reporte = new PrintWriter(new FileWriter("reportePedidos.txt", true));
                reporte.println("\t\t                 REPORTE PEDIDOS ");
                reporte.println("--------------------------------------------------------------------------------");
                reporte.println(String.format("%-5s%-33s%-4s", "CLAVE ", "DESCRIPCION", "DIFERENCIA"));
                reporte.println("-----------------------------------"
                        + "---------------------------------------------\n");
                salida.seek(0);
                String auxclavProducto, auxnom, auxclavDepa, auxunidMedida;
                double auxprecUnitario;
                int auxExistencias, auxexisMinimas;
                numRe = (int) (salida.length() / a_tamaRegistro);
                for (int i = 0; i < numRe; i++) {
                    auxclavProducto = salida.readUTF();
                    auxclavDepa = salida.readUTF();
                    auxnom = salida.readUTF();
                    auxprecUnitario = salida.readDouble();
                    auxExistencias = salida.readInt();
                    auxunidMedida = salida.readUTF();
                    auxexisMinimas = salida.readInt();
                    if (auxExistencias < auxexisMinimas) {
                        auxExistencias = auxexisMinimas - auxExistencias;
                        reporte.write(String.format("%-5s %-30s %4d \n", auxclavProducto, auxnom, auxExistencias));
                    }
                }
                System.out.println("Se logro generar el reporte con exito!!!");
                salida.close();
                reporte.close();

            } catch (IOException e) {
                System.out.println("No se logro abrir el archivo");
            }
        }

        public void Modificar(RandomAccessFile salida, String bus) {
            int li, ls = 0, exisTotal, exisMinima;
            double precUnitario;
            String aux, auxDepa, auxNombre, unidMedida;
            String fichero;
            fichero = "Inventario.dat";
            try {
                salida = new RandomAccessFile(fichero, "rw");

                bus = String.format("%-5s", bus);

                ls = (int) ((salida.length() / a_tamaRegistro) - 1);
                li = 0;
                do {
                    pm = (li + ls) / 2;
                    salida.seek(pm * a_tamaRegistro);
                    aux = salida.readUTF();
                    auxDepa = salida.readUTF();
                    auxNombre = salida.readUTF();
                    precUnitario = salida.readDouble();
                    exisTotal = salida.readInt();
                    unidMedida = salida.readUTF();
                    exisMinima = salida.readInt();

                    if (aux.compareToIgnoreCase(bus) > 0) {
                        ls = pm - 1;
                    } else {
                        li = pm + 1;
                    }

                } while (!aux.equalsIgnoreCase(bus) && li <= ls);
                if (aux.equalsIgnoreCase(bus)) {
                    String otra;
                    int decide;
                    do {

                        System.out.println("Elige la opcion a modificar: \n1)Clave Departamento \n2)Nombre Producto \n3)Precio Unitario \n"
                                + "4)Existencia Total \n5)Unidad de Medida \n6)Existencia Minima \n7)Salir");
                        decide = a_tec.nextInt();
                        switch (decide) {
                            case 1:
                                System.out.println("Ingrese la nueva clave de departamento");
                                a_tec.nextLine();
                                auxDepa = a_tec.nextLine();
                                auxDepa = String.format("%-4s", auxDepa);
                                System.out.println("Clave modificada con exito");
                                break;
                            case 2:
                                System.out.println("Ingrese el nuevo nombre del producto");
                                a_tec.nextLine();
                                auxNombre = a_tec.nextLine();
                                auxNombre = String.format("%-30s", auxNombre);
                                System.out.println("Nombre modificado con exito");
                                break;

                            case 3:
                                System.out.println("Ingrese el nuevo precio unitario");
                                precUnitario = a_tec.nextDouble();
                                System.out.println("Precio modificado con exito");
                                break;

                            case 4:
                                System.out.println("Ingrese la existencia total correcta");
                                exisTotal = a_tec.nextInt();
                                System.out.println("Existencia total modificada con exito");
                                break;

                            case 5:
                                System.out.println("Ingrese la nueva unidad de medida");
                                a_tec.nextLine();
                                unidMedida = a_tec.nextLine();
                                unidMedida = String.format("%-15s", unidMedida);
                                System.out.println("Unidad de medida modificada con exito");
                                break;

                            case 6:
                                System.out.println("Ingrese la existencia minima correcta");
                                exisMinima = a_tec.nextInt();
                                System.out.println("Existencia minima modificada con exito");
                                break;
                            case 7:
                                System.out.println("Exito al salir");
                                break;

                            default:
                                System.out.println("Ingresa una opcion valida");
                        }
                        if (decide == 7) {
                            otra = "no";
                        } else {
                            System.out.println("Desea volver a modificar algo mas del producto " + bus);
                            a_tec.nextLine();
                            otra = a_tec.nextLine();

                        }
                    } while (otra.equalsIgnoreCase("si"));
                    salida.seek(pm * a_tamaRegistro);
                    salida.writeUTF(aux);
                    salida.writeUTF(auxDepa);
                    salida.writeUTF(auxNombre);
                    salida.writeDouble(precUnitario);
                    salida.writeInt(exisTotal);
                    salida.writeUTF(unidMedida);
                    salida.writeInt(exisMinima);

                } else {
                    System.out.println("El registro no existe");

                }
                salida.close();
            } catch (IOException e) {
                System.out.println("Fichero " + " modificar no encontrado" + e.toString());

            }

        }

        public boolean busquedaBinaria(RandomAccessFile salida, String bus) {
            int li, ls, exisTotal, exisMinima;
            double precUnitario;
            String aux, auxDepa, auxNombre, unidMedida;
            boolean d = true;
            try {
                salida = new RandomAccessFile("Inventario.dat", "rw");
                bus = String.format("%-5s", bus);

                ls = (int) ((salida.length() / a_tamaRegistro) - 1);
                li = 0;
                do {
                    pm = (li + ls) / 2;
                    salida.seek(pm * a_tamaRegistro);
                    aux = salida.readUTF();
                    auxDepa = salida.readUTF();
                    auxNombre = salida.readUTF();
                    precUnitario = salida.readDouble();
                    exisTotal = salida.readInt();
                    unidMedida = salida.readUTF();
                    exisMinima = salida.readInt();
                    if (aux.compareToIgnoreCase(bus) > 0) {
                        ls = pm - 1;
                    } else {
                        li = pm + 1;
                    }

                } while (!aux.equalsIgnoreCase(bus) && li <= ls);
                if (aux.equalsIgnoreCase(bus)) {
                    d = true;

                    System.out.println("Se logro encontrar el fichero!!");

                } else {
                    d = false;
                    System.out.println("No se logro encontrar el fichero");
                }
                salida.close();
            } catch (IOException e) {
                System.out.println("Fichero " + " modificar no encontrado" + e.toString());

            }
            return d;
        }

        public void m_cajeCompras(RandomAccessFile salida, String bus) {
            inventario Objeto = new inventario();
            int li, ls = 0, exisTotal, exisMinima, v_cantidad, v_total = 0;
            double precUnitario;
            String aux, auxDepa, auxNombre, unidMedida;
            String fichero, decision = "si";
            fichero = "Inventario.dat";

            try {
                salida = new RandomAccessFile(fichero, "rw");
                PrintWriter reporte;
                int numRe = (int) (salida.length() / a_tamaRegistro);
                reporte = new PrintWriter(new FileWriter("ticket.txt", true));
                reporte.println("\n");
                reporte.println("\t\t      TICKET ");
                reporte.println("-----------------------------------------------------");
                reporte.println(String.format("%-5s%-30s%-10s%-8s", "CLAVE ", "DESCRIPCION", "CANTIDAD", "P.U"));
                reporte.println("-----------------------------------------------------\n");

                do {

                    bus = String.format("%-5s", bus);

                    ls = (int) ((salida.length() / a_tamaRegistro) - 1);
                    li = 0;
                    do {
                        pm = (li + ls) / 2;
                        salida.seek(pm * a_tamaRegistro);
                        aux = salida.readUTF();
                        auxDepa = salida.readUTF();
                        auxNombre = salida.readUTF();
                        precUnitario = salida.readDouble();
                        exisTotal = salida.readInt();
                        unidMedida = salida.readUTF();
                        exisMinima = salida.readInt();

                        if (aux.compareToIgnoreCase(bus) > 0) {
                            ls = pm - 1;
                        } else {
                            li = pm + 1;
                        }

                    } while (!aux.equalsIgnoreCase(bus) && li <= ls);
                    if (aux.equalsIgnoreCase(bus)) {
                        String otra = "no";

                        do {
                            System.out.println("Ingrese la cantidad del producto a comprar =  " + aux + " " + auxNombre);
                            v_cantidad = a_tec.nextInt();

                            if (exisTotal > 0) {
                                exisTotal = exisTotal - v_cantidad;
                            } else {
                                System.out.println("El producto a agotado sus existencias");
                            }
                            if (exisTotal < exisMinima || exisTotal == 0) {
                                System.out.println("Se necesita comprar mas de este producto");
                                System.out.println("Se generara un reporte para comprobar");
                                salida.seek(pm * a_tamaRegistro);
                                salida.writeUTF(aux);
                                salida.writeUTF(auxDepa);
                                salida.writeUTF(auxNombre);
                                salida.writeDouble(precUnitario);
                                salida.writeInt(exisTotal);
                                salida.writeUTF(unidMedida);
                                salida.writeInt(exisMinima);
                                Objeto.repoPedidos(salida);
                                System.out.println("Que cantidad desea comprar para reabastecer el producto?");
                                v_cantidad = a_tec.nextInt();
                                exisTotal = v_cantidad + exisTotal;
                            }
                            System.out.println("Desea comprar aun mas de este producto?");
                            a_tec.nextLine();
                            otra = a_tec.nextLine();

                            salida.seek(0);
                            String auxclavProducto, auxnom, auxclavDepa, auxunidMedida;
                            double auxprecUnitario;
                            int auxExistencias, auxexisMinimas;
                            numRe = (int) (salida.length() / a_tamaRegistro);
                            for (int i = 0; i < numRe; i++) {
                                auxclavProducto = salida.readUTF();
                                auxclavDepa = salida.readUTF();
                                auxnom = salida.readUTF();
                                auxprecUnitario = salida.readDouble();
                                auxExistencias = salida.readInt();
                                auxunidMedida = salida.readUTF();
                                auxexisMinimas = salida.readInt();

                                if (auxclavProducto.equalsIgnoreCase(bus)) {
                                    reporte.write(String.format("%-5s %-30s %4d %10.2f \n", auxclavProducto, auxnom, v_cantidad, auxprecUnitario));

                                }

                            }

                        } while (otra.equalsIgnoreCase("si"));

                        salida.seek(pm * a_tamaRegistro);
                        salida.writeUTF(aux);
                        salida.writeUTF(auxDepa);
                        salida.writeUTF(auxNombre);
                        salida.writeDouble(precUnitario);
                        salida.writeInt(exisTotal);
                        salida.writeUTF(unidMedida);
                        salida.writeInt(exisMinima);
                        precUnitario = (precUnitario * v_cantidad);
                        v_total += precUnitario;
                    } else {
                        System.out.println("El registro no existe");

                    }
                    System.out.println("Desea comprar otro producto?");
                    decision = a_tec.nextLine();
                    if (decision.equalsIgnoreCase("si")) {
                        System.out.println("Ingresa la clave del producto");
                        bus = a_tec.nextLine();
                    }

                } while (decision.equalsIgnoreCase("si"));
                reporte.println("-----------------------------------------------------");
                reporte.write(String.format("TOTAL = %-8s", v_total));
                System.out.println("Se logro generar el ticket con exito!!!");
                reporte.close();
                salida.close();
            } catch (IOException e) {
                System.out.println("Fichero " + " modificar no encontrado" + e.toString());

            }

        }
    }

    public class Departamento {

        Scanner a_tec = new Scanner(System.in);
        RandomAccessFile salida;
        int a_tamaRegistro = 38, numRe, pm;

        RandomAccessFile EscrDatoDepartamento() {
            String a_clave, a_nombre;
            String resp = "respuesta";
            try {
                salida = new RandomAccessFile("Departamento.dat", "rw");
                System.out.println("Tamaño del archivo " + salida.length());
                System.out.println("Clave | Departamento");
                System.out.println("-------------------");
                salida.seek(salida.length());
                do {
                    System.out.println("Ingresa Clave del departamento");
                    a_clave = a_tec.nextLine();
                    a_clave = String.format("%-4s", a_clave); //D012
                    System.out.println("Ingresa el nombre del departamento");
                    a_nombre = a_tec.nextLine();
                    a_nombre = String.format("%-30s", a_nombre); //Armeria

                    salida.writeUTF(a_clave);
                    salida.writeUTF(a_nombre);
                    System.out.println("Desea ingresar otro registro? (si/no)");
                    resp = a_tec.nextLine();
                } while (resp.toUpperCase().equals("SI"));
                salida.close();
                System.out.println("Se logro registrar con exito!! " + "Departamento.dat");
            } catch (IOException e) {
                System.out.println("No se logro abrir correctamente el fichero \n" + e.toString());
            }
            return salida;
        }

        public void MostDepartamento(RandomAccessFile entrada) {
            String fichero = "respuesta", a_clave, a_nombre;
            fichero = "Departamento.dat";
            try {
                entrada = new RandomAccessFile(fichero, "rw");
                System.out.println("Tamaño del archivo " + entrada.length());
                System.out.println("Clave | Departamento");
                System.out.println("-------------------");
                long registros = entrada.length() / a_tamaRegistro;
                entrada.seek(0);
                int i = 0;
                for (i = 0; i < registros; i++) {

                    a_clave = entrada.readUTF();
                    a_nombre = entrada.readUTF();

                    System.out.println(a_clave + "  " + a_nombre);
                }
                entrada.close();
                System.out.println("Se mostraron con exito los ultimos datos " + fichero);
            } catch (IOException e) {
                System.out.println(" No se abrio bien el fichero \n" + e.toString());
            }
        }

        public void ordeFichero(RandomAccessFile leer) {
            String aux, aux2, l1, l2;
            boolean f = false;
            do {
                try {
                    f = false;
                    leer = new RandomAccessFile("Departamento.dat", "rw");
                    numRe = (int) (leer.length() / a_tamaRegistro);

                    for (int pas = 1; pas < numRe; pas++) {
                        for (int com = 1, k = 0; com <= (numRe - pas); com++, k += 38) {
                            leer.seek(k);
                            aux = leer.readUTF();
                            aux2 = leer.readUTF();

                            leer.seek(0);
                            leer.seek(k + 38);
                            l1 = leer.readUTF();
                            l2 = leer.readUTF();

                            if (aux.compareToIgnoreCase(l1) > 0) {
                                leer.seek(k);
                                leer.writeUTF(l1);
                                leer.writeUTF(l2);

                                leer.seek(0);
                                leer.seek(k + 38);
                                leer.writeUTF(aux);
                                leer.writeUTF(aux2);
                            }
                        }
                    }
                    leer.close();
                    System.out.println("Se ordeno correctamente el archivo!!");
                } catch (IOException e) {
                    System.out.println("Fichero " + " ordenar Departamento no encontrado" + e.toString());

                }
            } while (f);
        }

        public void repoDepartamentos(RandomAccessFile salida) {
            try {
                PrintWriter reporte;
                salida = new RandomAccessFile("Departamento.dat", "rw");
                int numRe = (int) (salida.length() / a_tamaRegistro);
                reporte = new PrintWriter(new FileWriter("reporteDepartamento.txt", true));
                reporte.println("\t\t      REPORTE DEPARTAMENTOS ");
                reporte.println("---------------------------------------------------------------\n");
                reporte.println(String.format("%-4s%-30s", "CLAVE  ", "DEPARTAMENTO "));
                reporte.println("---------------------------------------------------------------\n");
                salida.seek(0);
                String auxnumc, auxnom;
                numRe = (int) (salida.length() / a_tamaRegistro);
                for (int i = 0; i < numRe; i++) {
                    auxnumc = salida.readUTF();
                    auxnom = salida.readUTF();
                    reporte.write(String.format("%-4s %-30s\n", auxnumc, auxnom));
                }
                System.out.println("Se logro generar el reporte con exito!!!");
                salida.close();
                reporte.close();

            } catch (IOException e) {
                System.out.println("No se logro abrir el archivo");
            }
        }

        public void Modificar(RandomAccessFile salida, String bus) {
            int li, ls = 0;
            String aux, auxnom;
            String fichero;
            fichero = "Departamento.dat";
            try {
                salida = new RandomAccessFile(fichero, "rw");
                bus = String.format("%-4s", bus);
                ls = (int) ((salida.length() / a_tamaRegistro) - 1);
                li = 0;
                do {
                    pm = (li + ls) / 2;
                    salida.seek(pm * a_tamaRegistro);
                    aux = salida.readUTF();
                    auxnom = salida.readUTF();

                    if (aux.compareToIgnoreCase(bus) > 0) {
                        ls = pm - 1;
                    } else {
                        li = pm + 1;
                    }

                } while (!aux.equalsIgnoreCase(bus) && li <= ls);
                if (aux.equalsIgnoreCase(bus)) {
                    String otra;
                    int decide;
                    do {

                        System.out.println("Si realmente desea modificar el nombre ingrese el numero 1, si no eliga el numero 2");
                        decide = a_tec.nextInt();
                        switch (decide) {
                            case 1:
                                System.out.println("Ingrese el nuevo nombre del departamento");
                                a_tec.nextLine();
                                auxnom = a_tec.nextLine();
                                auxnom = String.format("%-30s", auxnom);
                                System.out.println("Nombre modificado con exito");
                                break;

                            case 2:
                                System.out.println("Exito al salir");
                                break;

                            default:
                                System.out.println("Ingresa una opcion valida");
                        }
                        if (decide == 2) {
                            otra = "no";
                        } else {
                            System.out.println("Desea volver a modificar el nombre del departamento " + bus);

                            otra = a_tec.nextLine();

                        }
                    } while (otra.equalsIgnoreCase("si"));
                    salida.seek(pm * a_tamaRegistro);
                    salida.writeUTF(aux);
                    salida.writeUTF(auxnom);

                } else {
                    System.out.println("El registro no existe");

                }
                salida.close();
            } catch (IOException e) {
                System.out.println("Fichero " + " modificar no encontrado" + e.toString());

            }

        }

        public boolean busquedaBinaria(RandomAccessFile salida, String bus) {

            int li, ls;

            String aux, auxnom;
            boolean d = true;
            try {
                salida = new RandomAccessFile("Departamento.dat", "rw");
                bus = String.format("%-4s", bus);

                ls = (int) ((salida.length() / a_tamaRegistro) - 1);
                li = 0;
                do {
                    pm = (li + ls) / 2;
                    salida.seek(pm * a_tamaRegistro);
                    aux = salida.readUTF();
                    auxnom = salida.readUTF();
                    if (aux.compareToIgnoreCase(bus) > 0) {
                        ls = pm - 1;
                    } else {
                        li = pm + 1;
                    }

                } while (!aux.equalsIgnoreCase(bus) && li <= ls);
                if (aux.equalsIgnoreCase(bus)) {
                    d = true;

                    System.out.println("Se logro encontrar el fichero!!");

                } else {
                    d = false;
                    System.out.println("No se logro encontrar el fichero");
                }
                salida.close();
            } catch (IOException e) {
                System.out.println("Fichero " + " modificar no encontrado" + e.toString());
            }
            return d;
        }
    }
}
