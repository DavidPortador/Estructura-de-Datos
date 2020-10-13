        /////////////////////////////////////////
       // Tiene soporte para numeros decimales//
      /////////////////////////////////////////
package t2.calculadorarecursiva;
import java.util.Scanner;
public class T2CalculadoraRecursiva {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        T2CalculadoraRecursiva v_obj = new T2CalculadoraRecursiva();
        v_obj.entrada();
    }
    void entrada(){
        int v_opc;
        System.out.println("Calculadora\n"
                + "1)Sumar\n"
                + "2)Restar\n"
                + "3)Multiplicar\n"
                + "4)Dividir\n"
                + "5)Salir");
        v_opc = valientero("Opcion: ");
        if(v_opc < 0 || v_opc > 5){
            System.out.println("Seleccione una opcion valida\n");
            entrada();
        }else
            menu(v_opc);
    }
    void menu(int p_opc){
        int v_num1,v_num2;
        v_num1 = valientero("Valor 1: ");
        v_num2 = valientero("Valor 2: ");
        switch(p_opc){
            case 1: 
                if(v_num1 > 0 && v_num2 > 0)
                    System.out.println(sumar(v_num1,v_num2));
                else if(v_num1 < 0 && v_num2 < 0){
                    v_num1 *= -1;
                    v_num2 *= -1;
                    System.out.println("-"+sumar(v_num1,v_num2));
                }else
                    if(v_num1 < 0)
                        System.out.println(sumar(v_num1,v_num2));
                    else
                        System.out.println(sumar(v_num2,v_num1));
                break;
            case 2: 
                if(v_num1 > 0 && v_num2 > 0)
                    System.out.println(restar(v_num1,v_num2));
                else if(v_num1 < 0 && v_num2 < 0){
                    v_num1 *= -1;
                    v_num2 *= -1;
                    System.out.println(restar(v_num1,v_num2));
                }else
                    if(v_num1 < 0)
                        System.out.println(restar(v_num1,v_num2));
                    else
                        System.out.println((restar(v_num2,v_num1)*-1));
                break;
            case 3: 
                if(v_num1 > 0 && v_num2 > 0)
                    System.out.println(multiplicar(v_num1,0,v_num2,v_num2));
                else if(v_num1 < 0 && v_num2 < 0){
                    v_num1 *= -1;
                    v_num2 *= -1;
                    System.out.println(multiplicar(v_num1,0,v_num2,v_num2));
                }else
                    if(v_num1 < 0){
                        v_num1 *= -1;
                        System.out.println("-"+multiplicar(v_num1,0,v_num2,v_num2));
                    }else{
                        v_num2 *= -1;
                        System.out.println("-"+multiplicar(v_num1,0,v_num2,v_num2));
                    }
                break;
            case 4:
                String v_sig="";
                if(v_num1<0 && v_num2<0){
                    v_num1 *= -1;
                    v_num2 *= -1;
                }else{
                    if(v_num1 < 0){
                        v_num1 *= -1;
                        v_sig="-";
                    }if(v_num2 < 0){
                        v_num2 *= -1;
                        v_sig="-";
                    }
                }
                System.out.println(v_sig+dividir(v_num1,v_num1,v_num2,0));
                break;
            case 5: System.exit(0);
        }  
    }
    int valientero(String p_texto){
        int v_num;
        System.out.print(p_texto);
        try {
            v_num = a_tec.nextInt();
        } catch (Exception e) {
            v_num=0;
            a_tec = new Scanner(System.in);
            System.out.println("No es entero");
            valientero(p_texto);
        }
        return v_num;
    }
    int sumar(int p_num1,int p_num2){
        if(p_num2 > 0){
            p_num1++;
            p_num2--;
            return sumar(p_num1,p_num2);
        }else
            return p_num1;
    }
    int restar(int p_num1,int p_num2){
        if(p_num2 > 0){
            p_num1--;
            p_num2--;
            return restar(p_num1,p_num2);
        }else
            return p_num1;
    }
    int multiplicar(int p_num1,int p_aux1,int p_num2,int p_aux2){
        if((restar(p_num2,p_aux2)) != p_num2){
            p_aux1 = sumar(p_aux1,p_num1);
            p_aux2--;
            return multiplicar(p_num1,p_aux1,p_num2,p_aux2);
        }else
            return p_aux1;
    }
    int dividir(int p_num1,int p_aux1,int p_num2,int p_aux2){
        if(p_aux1 >= p_num2){
            p_aux1 = restar(p_aux1,p_num2);
            p_aux2++;
            return dividir(p_num1,p_aux1,p_num2,p_aux2);
        }else
            return p_aux2;
    } 
}
