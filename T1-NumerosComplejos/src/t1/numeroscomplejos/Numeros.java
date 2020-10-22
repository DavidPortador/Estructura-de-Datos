package t1.numeroscomplejos;
import java.util.Scanner;

public class Numeros {
    // Atributos de la clase
    Scanner a_tec = new Scanner(System.in);
    private int a_long,a_contDatos=0;
    private float[] a_nreal;
    private float[] a_ncomp;
    String[] a_proc = new String[4];
    boolean a_bsuma=false,a_bresta=false,a_bmulti=false,a_bdiv=false;
    float a_resr,a_resc;

    // El constructor recibe la longitud e inicializa el arreglo
    public Numeros(int p_long) {
        a_long = p_long;
        a_nreal = new float[p_long];
        a_ncomp = new float[p_long];
        crear();
    }
    void crear() {
        int v_cont;
        System.out.println("\nRepresentación de un número complejo: "
                + "Zn = (a + bi)\nNota: Cuando ingrese el valor imaginario (b) "
                + "no agregue 'i'");
        for(v_cont=0;v_cont<get_Longitud();v_cont++){
            a_nreal[v_cont]=valiFloat("Ingresa el valor real de a("+v_cont+"): ");
            a_ncomp[v_cont]=valiFloat("Ingresa el valor imaginario de b("+v_cont+"): ");
        }
    }
    void sumar() {
        int v_cont;
        String v_res="",v_opc;
        float v_auxr=0,v_auxc=0;
        for(v_cont = 0;v_cont < get_Longitud()-1;v_cont++)
            if(v_cont==0){
                a_resr = a_nreal[v_cont]+a_nreal[v_cont+1];
                a_resc = a_ncomp[v_cont]+a_ncomp[v_cont+1];
                System.out.println("Suma("+v_cont+") = ("+a_resr+" + "+a_resc+"i)");
                v_res="("+a_nreal[v_cont]+"+"+a_ncomp[v_cont]+"i)+("+a_nreal[v_cont+1]
                        +"+"+a_ncomp[v_cont+1]+"i) = ("+a_resr+"+"+a_resc+"i)";
            }else{
                a_resr += a_nreal[v_cont+1];
                a_resc += a_ncomp[v_cont+1];
                System.out.println("Suma("+v_cont+") = ("+a_resr+" + "+a_resc+"i)");
                v_res+="+("+a_nreal[v_cont+1]+"+"+a_ncomp[v_cont+1]+"i) = "
                        +"("+a_resr+"+"+a_resc+"i)";
            }
        System.out.println("Suma: ("+a_resr+" + "+a_resc+"i)");        
        if(a_bsuma==false){
            System.out.print("¿Quiere guardar el procedimiento? [s/n] ");
            v_opc=a_tec.next();
            if(v_opc.equals("s") || v_opc.equals("S")){
                guardar(v_res);
                a_bsuma=true;
            }
        }
    }
    void restar() {
        int v_cont;
        String v_res="",v_opc;
        float v_auxr=0,v_auxc=0;
        for(v_cont = 0;v_cont < get_Longitud()-1;v_cont++)
            if(v_cont==0){
                a_resr = a_nreal[v_cont]-a_nreal[v_cont+1];
                a_resc = a_ncomp[v_cont]-a_ncomp[v_cont+1];
                System.out.println("Resta("+v_cont+") = ("+a_resr+" + "+a_resc+"i)");
                v_res="("+a_nreal[v_cont]+"+"+a_ncomp[v_cont]+"i)-("+a_nreal[v_cont+1]
                        +"+"+a_ncomp[v_cont+1]+"i) = ("+a_resr+"+"+a_resc+"i)";
            }else{
                a_resr -= a_nreal[v_cont+1];
                a_resc -= a_ncomp[v_cont+1];
                System.out.println("Resta("+v_cont+") = ("+a_resr+" + "+a_resc+"i)");
                v_res+="-("+a_nreal[v_cont+1]+"+"+a_ncomp[v_cont+1]+"i) = "
                        +"("+a_resr+"+"+a_resc+"i)";
            }
        System.out.println("Resta: ("+a_resr+" + "+a_resc+"i)");
        if(a_bresta==false){
            System.out.print("¿Quiere guardar el procedimiento? [s/n] ");
            v_opc=a_tec.next();
            if(v_opc.equals("s") || v_opc.equals("S")){
                guardar(v_res);
                a_bresta=true;
            }
        }
    }
    void multiplicar(){
        int v_cont;
        String v_res="",v_opc;
        float v_auxr1,v_auxc1,v_auxr2,v_auxc2,v_resr,v_resc;
        for(v_cont = 0;v_cont < get_Longitud()-1;v_cont++)
            if(v_cont==0){
                v_auxr1 = a_nreal[v_cont]*a_nreal[v_cont+1];
                v_auxr2 = a_nreal[v_cont]*a_ncomp[v_cont+1];
                v_auxc1 = a_ncomp[v_cont]*a_nreal[v_cont+1];
                v_auxc2 = a_ncomp[v_cont]*a_ncomp[v_cont+1];
                System.out.println(v_auxr1 +", "+v_auxr2 +", "+v_auxc1 +", "+v_auxc2);
                v_auxr2 += v_auxc1;
                v_auxc2 *= -1; 
                System.out.println(v_auxr1 +", "+v_auxr2 +", "+v_auxc2);
                v_auxr1 += v_auxc2;
                a_resr=v_auxr1;
                a_resc=v_auxr2;
                System.out.println("Multiplicacion("+v_cont+"): ("+a_resr+", "+a_resc+"i)");
                v_res="("+a_nreal[v_cont]+"+"+a_ncomp[v_cont]+"i)*("+a_nreal[v_cont+1]
                        +"+"+a_ncomp[v_cont+1]+"i) = ("+a_resr+"+"+a_resc+"i)";
            }else{
                v_auxr1 = a_resr*a_nreal[v_cont+1];
                v_auxc1 = a_resr*a_ncomp[v_cont+1];
                v_auxr2 = a_resc*a_nreal[v_cont+1];
                v_auxc2 = a_resc*a_ncomp[v_cont+1];
                System.out.println(v_auxr1+" "+v_auxc1+" "+v_auxr2+" "+v_auxc2);
                v_auxr2 += v_auxc1;
                v_auxc2 *= -1;
                System.out.println(v_auxr1+" "+v_auxr2+" "+v_auxc2);
                v_auxr1 += v_auxc2;
                a_resr=v_auxr1;
                a_resc=v_auxr2;
                System.out.println(a_resr+" "+a_resc);
                System.out.println("Multiplicacion("+v_cont+"): ("+a_resr+", "+a_resc+"i)");
                v_res+="*("+a_nreal[v_cont+1]+"+"+a_ncomp[v_cont+1]+"i) = "
                        +"("+a_resr+"+"+a_resc+"i)";
            }
        System.out.println("Multiplicacion: ("+a_resr+" + "+a_resc+"i)");
        if(a_bmulti==false){
            System.out.print("¿Quiere guardar el procedimiento? [s/n] ");
            v_opc=a_tec.next();
            if(v_opc.equals("s") || v_opc.equals("S")){
                guardar(v_res);
                a_bmulti=true;
            }
        }
    }
    void dividir(){
        int v_cont;
        String v_res="",v_opc;
        float v_auxr1,v_auxc1,v_auxr2,v_auxc2,v_resr,v_resc,v_conj,v_auxd1,v_auxd2;
        for(v_cont = 0;v_cont < get_Longitud()-1;v_cont++){
            v_conj = a_ncomp[v_cont+1]*-1;
            if(v_cont==0){
                v_auxr1=a_nreal[v_cont ]*a_nreal[v_cont+1];
                v_auxc1=a_nreal[v_cont]*v_conj;
                v_auxr2=a_ncomp[v_cont]*a_nreal[v_cont+1];
                v_auxc2=a_ncomp[v_cont]*v_conj;
                System.out.println(v_auxr1 +", "+v_auxc1 +", "+v_auxr2 +", "+v_auxc2);
                v_auxd1=a_nreal[v_cont+1];
                v_auxd2=a_ncomp[v_cont+1];
                v_auxd1 *= v_auxd1;
                v_auxd2 *= v_auxd2;
                System.out.println(v_auxd1+". "+v_auxd2);
                v_auxc2 *= -1;
                v_auxr1 += v_auxc2;
                v_auxc1 += v_auxr2;
                System.out.println(v_auxr1+", "+v_auxc1);
                v_auxd1 += v_auxd2;
                a_resr=v_auxr1/v_auxd1;
                a_resc=v_auxc1/v_auxd1;
                System.out.println("Division("+v_cont+"): ("+a_resr+", "+a_resc+"i)");
                v_res="("+a_nreal[v_cont]+"+"+a_ncomp[v_cont]+"i)/("+a_nreal[v_cont+1]
                        +"+"+a_ncomp[v_cont+1]+"i) = ("+a_resr+"+"+a_resc+"i)";
            }else{
                System.out.println(a_nreal[v_cont+1]+", "+a_ncomp[v_cont+1]);
                v_auxr1=a_resr*a_nreal[v_cont+1];
                v_auxc1=a_resr*v_conj;
                v_auxr2=a_resc*a_ncomp[v_cont+1];
                v_auxc2=a_resc*v_conj;
                System.out.println(v_auxr1 +", "+v_auxc1 +", "+v_auxr2 +", "+v_auxc2);
                v_auxd1=a_nreal[v_cont+1];
                v_auxd2=a_ncomp[v_cont+1];
                v_auxd1 *= v_auxd1;
                v_auxd2 *= v_auxd2;
                System.out.println(v_auxd1+". "+v_auxd2);
                v_auxc2 *= -1;
                v_auxr1 += v_auxc2;
                v_auxc1 += v_auxr2;
                System.out.println(v_auxr1+", "+v_auxc1);
                v_auxd1 += v_auxd2;
                a_resr=v_auxr1/v_auxd1;
                a_resc=v_auxc1/v_auxd1;
                System.out.println("Division("+v_cont+"): ("+a_resr+", "+a_resc+"i)");
                v_res+="*("+a_nreal[v_cont+1]+"+"+a_ncomp[v_cont+1]+"i) = "
                        +"("+a_resr+"+"+a_resc+"i)";
            }
        }
        System.out.println("Division: ("+a_resr+" + "+a_resc+"i)");
        if(a_bdiv==false){
            System.out.print("¿Quiere guardar el procedimiento? [s/n] ");
            v_opc=a_tec.next();
            if(v_opc.equals("s") || v_opc.equals("S")){
                guardar(v_res);
                a_bdiv=true;
            }
        }
    }
    void mostrarNumeros() {
        int v_cont;
        for(v_cont = 0;v_cont < get_Longitud();v_cont++)
            System.out.println("Z("+v_cont+") = "
                    + "("+a_nreal[v_cont]+" + "+a_ncomp[v_cont]+"i)");
    }
    public int get_Longitud() {
        return a_long;
    }
    void guardar(String p_dato){
        a_proc[a_contDatos]=p_dato;
        System.out.println("Se guardo con exito: "+a_proc[a_contDatos]);
        a_contDatos++;
    }
    void mostarDatos(){
        int v_cont;
        if(a_bsuma==false && a_bresta==false && a_bmulti==false && a_bdiv==false)
            System.out.println("No se han guardado Datos");
        else{
            System.out.println("Datos guardados: ");
            for(v_cont=0;v_cont<a_contDatos;v_cont++)
                System.out.println(a_proc[v_cont]);
        }
    }
    float valiFloat(String p_texto) {
        float v_flt;
        while(true){
            System.out.print(p_texto);
            try {
                v_flt = a_tec.nextFloat();
                break;
            } catch (Exception e) {
                System.out.println("No es flotante");
                a_tec = new Scanner(System.in);
            }
        }
        return v_flt;
    }
}