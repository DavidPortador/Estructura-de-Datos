package p274;

import java.util.Scanner;
public class p274 {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        p274 v_obj = new p274();
        v_obj.entrada();
    }
    void entrada(){
        String v_dato;
        String[] v_datos;
        v_dato = a_tec.nextLine();
        v_datos = validar(v_dato);
        recursion(v_datos,0);
    }
    void recursion(String[] p_datos, int p_cont){
        if(p_cont < p_datos.length){
            if(p_datos.length >= 3){
                if(p_cont==0){
                    if((getDato(p_datos[0])==0) || (getDato(p_datos[0])==1)){
                        if((getDato(p_datos[1])==0) || (getDato(p_datos[1])==1)){
                            if(getDato(p_datos[2])==2){
                                if(p_datos.length==3){
                                    System.out.println("OK");
                                }else{
                                    p_cont += 3;
                                    recursion(p_datos,p_cont);
                                }
                            }else{
                                System.out.println("FALTA OPERADOR");
                            }
                        }else{
                            if(getDato(p_datos[1])==3)
                                System.out.println("SIMBOLO DESCONOCIDO");
                            else
                            System.out.println("FALTA OPERANDO");
                        }
                    }else{
                        if(getDato(p_datos[0])==3)
                            System.out.println("SIMBOLO DESCONOCIDO");
                        else
                        System.out.println("FALTA OPERANDO");
                    }
                }else{
                    //aqui ya es de uno en uno
                    //System.out.println("continua...");
                    if(p_cont < p_datos.length-1){
                        if(getDato(p_datos[p_cont])==2){
                            System.out.println("operador");
                            if((getDato(p_datos[p_cont-1])==2)){
                                System.out.println("FALTA OPERANDO");
                            }else{
                                System.out.println("recur");
                                p_cont += 1;
                                recursion(p_datos,p_cont);
                            }
                        }else if((getDato(p_datos[p_cont])==0) || getDato(p_datos[p_cont])==1){
                            System.out.println("numero");
                            
                        }
                        
                    }else{
                        if((getDato(p_datos[p_cont])==0) || (getDato(p_datos[p_cont])==1)){
                            System.out.println("FALTA OPERADOR");
                        }else{
                            System.out.println("FALTA OPERANDO");
                        }
                    }
                }
            }else{
                // Solo dos o uno
                if(p_datos.length==2){
                    if(((getDato(p_datos[0])==0) || (getDato(p_datos[0])==1)) 
                    && ((getDato(p_datos[1])==0) || (getDato(p_datos[1])==1))){
                        System.out.println("FALTA OPERADOR");
                    }else if((getDato(p_datos[0])==3) || (getDato(p_datos[1])==3)){
                        System.out.println("SIMBOLO DESCONOCIDO");
                    }else{
                        System.out.println("FALTA OPERANDO");
                    }
                }else{
                    if(getDato(p_datos[0])==3)
                        System.out.println("SIMBOLO DESCONOCIDO");
                    else
                        System.out.println("FALTA OPERANDO");
                }
            }
        }else{
            System.out.println("se pasa...");
        }
    }
    int getDato(String p_dato){ // 0=letra 1=num 2=operador 3=desconocido
        if(valiletra(p_dato))
            return 0;
        else if(valinum(p_dato))
            return 1;
        else if(valiope(p_dato))
            return 2;
        else
            return 3;
    }
    boolean valiletra(String p_caracter){
        char v_caracter = p_caracter.toUpperCase().charAt(0);
        int v_valorASCII = (int) v_caracter;
        if (v_valorASCII != 165 && (v_valorASCII < 65 || v_valorASCII > 90))
            return false;
        else
            return true;
    }
    boolean valinum(String p_caracter){
        int v_aux;
        try {
            v_aux = Integer.parseInt(p_caracter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    boolean valiope(String p_caracter){
        if(p_caracter.equals("+") || p_caracter.equals("-") 
                || p_caracter.equals("*") || p_caracter.equals("/"))
            return true;
        else
            return false;
    }
    String[] validar(String p_dato){
        String[] v_datos = null;
        int v_con,v_con2;
        try {
            int v_cont = 0,v_cont2 = 0;
            String[] v_aux = p_dato.split(" ");
            for(v_con=0; v_con < v_aux.length; v_con++)
                if(!v_aux[v_con].equals(""))
                    v_cont++;
            v_datos = new String[v_cont];
            for(v_con2=0;v_con2<v_aux.length;v_con2++)
                if(!v_aux[v_con2].equals("")){
                    v_datos[v_cont2]= v_aux[v_con2];
                    v_cont2++;
                }
            return v_datos;
        } catch (Exception e) {
            return v_datos;
        }
    }
}

/*

*/