package ordenamientosexternos;

import java.io.*;
import java.util.*;
public class OrdenamientosExternos {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            OrdenamientosExternos v_obj = new OrdenamientosExternos();
            v_obj.entrada();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void entrada() throws FileNotFoundException, IOException {
        File v_archivo = new File("./Archivos/Origen.dat");
        int v_can, v_cc, v_res, v_ax;
        long v_time_start, v_time_end;
        String v_aux;
        boolean v_ban = false;
        System.out.println("Ingrese la cantidad de datos a evaluar: ");
        try {
            v_can = a_tec.nextInt();
            System.out.println("¿Como desea evaluar el programa?\n1)Forma Manual\n2)Numeros Aleatorios");
            v_res = a_tec.nextInt();
            if (v_res == 1) {
                System.out.println("Valores: ");
                for (v_cc = 0; v_cc < v_can; v_cc++) {
                    v_ax = a_tec.nextInt();
                    Agregar(v_archivo, v_ax);
                }
            } else if (v_res == 2) {
                System.out.println("¿Desea ver los datos usados? s/n");
                a_tec.nextLine();
                v_aux = a_tec.nextLine();
                if (v_aux.equalsIgnoreCase("s"))
                    v_ban = true;
                for (v_cc = 0; v_cc < v_can; v_cc++) {
                    v_ax = (int) Math.floor(Math.random() * (1000 - 0 + 1) + 0);
                    Agregar(v_archivo, v_ax);
                    if (v_ban)
                        System.out.println(v_ax);
                }
                v_ban = true;
            } else
                System.out.println("Opcion incorrecta");
        } catch (Exception e) {
        }
        v_time_start = System.currentTimeMillis();
        // Automaticamente comienza la ordenacion cuando termina de recibir datos
        mezclaDirecta(v_archivo);
        System.out.println("¿Desea ver los datos ordenados? s/n");
        if (!v_ban)
            a_tec.nextLine();
        v_aux = a_tec.nextLine();
        if (v_aux.equalsIgnoreCase("s"))
            imprimir(v_archivo);
        // Siempre borro el archivo donde genero la ordenacion para que no se junten varios casos
        v_archivo.delete();
        v_time_end = System.currentTimeMillis();
        System.out.println("\nTiempo de ejecucion: " + (v_time_end - v_time_start) + " milisegundos");
    }

    void Agregar(File p_fichero, int v_num) {
        DataOutputStream v_archivo = null;
        try {
            v_archivo = new DataOutputStream(new FileOutputStream(p_fichero, true));
            // Grabando al archivo
            v_archivo.writeInt(v_num);
            v_archivo.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }

    void mezclaDirecta(File p_archivo) throws IOException {
        int v_longSec, v_numReg;
        File v_aux1 = new File("./Archivos/Aux1.dat");
        File v_aux2 = new File("./Archivos/Aux2.dat");
        // El numero de registros se obtiene dividiendo el peso entre 4 (int = 4 bytes)
        v_numReg = (int) p_archivo.length() / 4;
        v_longSec = 1;
        while (v_longSec < v_numReg) {
            distribuir(p_archivo, v_aux1, v_aux2, v_longSec, v_numReg);
            mezclar(v_aux1, v_aux2, p_archivo, v_longSec, v_numReg);
            v_longSec *= 2;
        }
    }

    void distribuir(File p_archivo, File p_aux1, File p_aux2, int p_longSec, int p_numReg) throws IOException {
        int v_numSec, v_resto, v_cc;
        DataInputStream v_flujo = new DataInputStream(new BufferedInputStream(new FileInputStream(p_archivo)));
        DataOutputStream v_flujo1 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(p_aux1)));
        DataOutputStream v_flujo2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(p_aux2)));
        v_numSec = p_numReg / (2 * p_longSec);
        v_resto = p_numReg % (2 * p_longSec);
        //distribuye secuencias de longitud longSec
        for (v_cc = 1; v_cc <= v_numSec; v_cc++) {
            subSecuencia(v_flujo, v_flujo1, p_longSec);
            subSecuencia(v_flujo, v_flujo2, p_longSec);
        }
        if (v_resto > p_longSec)
            v_resto -= p_longSec;
        else {
            p_longSec = v_resto;
            v_resto = 0;
        }
        subSecuencia(v_flujo, v_flujo1, p_longSec);
        subSecuencia(v_flujo, v_flujo2, v_resto);
        v_flujo.close();
        v_flujo1.close();
        v_flujo2.close();
    }

    void subSecuencia(DataInput p_archivo, DataOutput p_imp, int p_longSec) throws IOException {
        int v_cc, v_clave;
        for (v_cc = 1; v_cc <= p_longSec; v_cc++) {
            v_clave = p_archivo.readInt();
            p_imp.writeInt(v_clave);
        }
    }

    void mezclar(File p_aux1, File p_aux2, File p_archivo, int p_lonSec, int p_numReg) throws IOException {
        int v_numSec, v_resto, v_cc, v_cc2, v_cc3, v_clave, v_clave1 = 0, v_clave2 = 0;
        int v_n1, v_n2;
        v_numSec = p_numReg / (2 * p_lonSec); // número de subsecuencias
        v_resto = p_numReg % (2 * p_lonSec);
        DataOutputStream flujo = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(p_archivo)));
        DataInputStream flujo1 = new DataInputStream(new BufferedInputStream(new FileInputStream(p_aux1)));
        DataInputStream flujo2 = new DataInputStream(new BufferedInputStream(new FileInputStream(p_aux2)));
        // Claves iniciales
        v_clave1 = flujo1.readInt();
        v_clave2 = flujo2.readInt();
        // Bucle para controlar todo el proceso de mezcla
        for (int s = 1; s <= v_numSec + 1; s++) {
            v_n1 = v_n2 = p_lonSec;
            if (s == v_numSec + 1)
                if (v_resto > p_lonSec)
                    v_n2 = v_resto - p_lonSec;
                else {
                    v_n1 = v_resto;
                    v_n2 = 0;
                }
            v_cc = v_cc2 = 1;
            while (v_cc <= v_n1 && v_cc2 <= v_n2) {
                if (v_clave1 < v_clave2) {
                    v_clave = v_clave1;
                    try {
                        v_clave1 = flujo1.readInt();
                    } catch (EOFException e) {
                    }
                    v_cc++;
                } else {
                    v_clave = v_clave2;
                    try {
                        v_clave2 = flujo2.readInt();
                    } catch (EOFException e) {
                    }
                    v_cc2++;
                }
                flujo.writeInt(v_clave);
            }
            for (v_cc3 = v_cc; v_cc3 <= v_n1; v_cc3++) {
                flujo.writeInt(v_clave1);
                try {
                    v_clave1 = flujo1.readInt();
                } catch (EOFException e) {
                }
            }
            for (v_cc3 = v_cc2; v_cc3 <= v_n2; v_cc3++) {
                flujo.writeInt(v_clave2);
                try {
                    v_clave2 = flujo2.readInt();
                } catch (EOFException e) {
                }
            }
        }
        flujo.close();
        flujo1.close();
        flujo2.close();
    }

    void imprimir(File p_archivo) throws FileNotFoundException, IOException {
        DataInputStream v_flujo = null;
        try {
            v_flujo = new DataInputStream(new BufferedInputStream(new FileInputStream(p_archivo)));
            System.out.println("Datos Ordenados: ");
            while (true)
                System.out.print(v_flujo.readInt() + ", ");
        } catch (EOFException eof) {
            v_flujo.close();
        }
    }
}
