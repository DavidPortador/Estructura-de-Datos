package estructura.pkg1;
import java.util.Scanner;

public class Estructura1 {
    // El unico atributo será el Scanner
    Scanner a_tec = new Scanner(System.in);
    // Metodo main para elegir el tipo de dato
    public static void main(String[] args) {
        Estructura1 v_obj = new Estructura1();
        System.out.println("-----Tipo de dato para la estructura-----");
        System.out.println("1) Int     (funcional)\n"
                + "2) String  (funcional)\n"
                + "3) Float   (funcional)\n"
                + "4) Salir");
        v_obj.crear();
    }
    // Metodos 
    void crear(){
        int v_opc;
        v_opc = valiEntero("Ingrese una opción valida: ");
        if(v_opc < 1 || v_opc > 4)
            crear();
        else
            switch(v_opc){
                case 1:listaInt();break;
                case 2:listaString();break;
                case 3:listaFloat(); break;
                case 4:System.exit(0);
                default:System.out.println("Seleccione una opcion valida");
            }
    }
    void listaString(){
        a_tec.nextLine(); // Limpia el buffer para la entrada de datos
        String v_texto;
        System.out.print("Ingrese la cabeza de la estructura: ");
        v_texto = a_tec.nextLine();
        clasString v_dato = new clasString(v_texto);
        listaString v_list = new listaString(v_dato);
    }
    void listaFloat(){
        float v_opc;
        v_opc = valiFloat("Ingrese la cabeza de la estructura: ");
        classFloat v_dato = new classFloat(v_opc);
        listaFloat v_list = new listaFloat(v_dato);
    }
    void listaInt(){
        int v_opc;
        v_opc = valiEntero("Ingrese la cabeza de la estructura: ");
        classInt v_dato = new classInt(v_opc);
        listaInt v_list = new listaInt(v_dato);
    }
    // Validaciones
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
    float valiFloat(String p_texto){
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
