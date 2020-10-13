package ep1.problemaa;

import java.util.Scanner;
public class EP1ProblemaA {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        EP1ProblemaA v_obj = new EP1ProblemaA();
        v_obj.entrada();
    }
    void entrada(){
        int v_ini,v_fin;
        String v_dir;
        v_ini = valientero("Rango inicial: ");
        v_fin = valientero("Rango final: ");
        System.out.print("Direccion: ");
        v_dir = a_tec.next();
        if(v_dir.charAt(v_dir.length()-1) == '<'){
            descendente(v_ini,v_fin,v_fin);
        }else if(v_dir.charAt(v_dir.length()-1) == '>'){
            ascendente(v_ini,v_fin,v_ini);
        }
    }
    void ascendente(int p_ini,int p_fin,int p_aux){
        if(p_ini<=p_aux && p_fin>=p_aux){
            System.out.println(p_aux);
            ascendente(p_ini,p_fin,p_aux+1);
        }
    }
    void descendente(int p_ini,int p_fin,int p_aux){
        if(p_ini<=p_aux && p_fin>=p_aux){
            System.out.println(p_aux);
            descendente(p_ini,p_fin,p_aux-1);
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
}
