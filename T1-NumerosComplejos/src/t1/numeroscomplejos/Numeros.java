package t1.numeroscomplejos;
import java.util.Scanner;

public class Numeros {
    // Atributos de la clase
    Scanner a_tec = new Scanner(System.in);
    private int a_long;
    private float[] a_nreal;
    private float[] a_ncomp;
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
        String v_res;
        float v_auxr=0,v_auxc=0;
        for(v_cont = 0;v_cont < get_Longitud()-1;v_cont++){
            v_auxr += a_nreal[v_cont]+a_nreal[v_cont+1];
            v_auxc += a_ncomp[v_cont]+a_ncomp[v_cont+1];
        }
        System.out.println("Suma = ("+v_auxr+" + "+v_auxc+"i)");
    }
    void restar() {
        int v_cont;
        String v_res;
        float v_auxr=0,v_auxc=0;
        for(v_cont = 0;v_cont < get_Longitud()-1;v_cont++){
            v_auxr += a_nreal[v_cont]-a_nreal[v_cont+1];
            v_auxc += a_ncomp[v_cont]-a_ncomp[v_cont+1];
        }
        System.out.println("Resta = ("+v_auxr+" + "+v_auxc+"i)");
    }
    void multiplicar(){
        int v_cont;
        float v_auxr1,v_auxc1,v_auxr2,v_auxc2,v_resr,v_resc;
        for(v_cont = 0;v_cont < get_Longitud()-1;v_cont++){
            if(v_cont==0){
                v_auxr1 = a_nreal[v_cont]*a_nreal[v_cont+1];
                v_auxr2 = a_nreal[v_cont]*a_ncomp[v_cont+1];
                v_auxc1 = a_ncomp[v_cont]*a_nreal[v_cont+1];
                v_auxc2 = a_ncomp[v_cont]*a_ncomp[v_cont+1];
                //System.out.println(v_auxr1 +", "+v_auxr2 +", "+v_auxc1 +", "+v_auxc2);
                v_auxr2 += v_auxc1;
                v_auxc2 *= -1; 
                // System.out.println(v_auxr1 +", "+v_auxr2 +", "+v_auxc2);
                v_auxr1 += v_auxc2;
                a_resr=v_auxr1;
                a_resc=v_auxr2;
                System.out.println("Multiplicacion("+v_cont+"): "+a_resr+", "+a_resc+"i");
            }else{
                v_auxr1 = a_resr*a_nreal[v_cont+1];
                v_auxc1 = a_resr*a_ncomp[v_cont+1];
                v_auxr2 = a_resc*a_nreal[v_cont+1];
                v_auxc2 = a_resc*a_ncomp[v_cont+1];
                // System.out.println(v_auxr1+" "+v_auxc1+" "+v_auxr2+" "+v_auxc2);
                v_auxr2 += v_auxc1;
                v_auxc2 *= -1;
                // System.out.println(v_auxr1+" "+v_auxr2+" "+v_auxc2);
                v_auxr1 += v_auxc2;
                a_resr=v_auxr1;
                a_resc=v_auxr2;
                // System.out.println(a_resr+" "+a_resc);
                System.out.println("Multiplicacion("+v_cont+"): "+a_resr+", "+a_resc+"i");
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
