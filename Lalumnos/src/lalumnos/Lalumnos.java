package lalumnos;

import java.util.Scanner;
public class Lalumnos {
    Scanner a_tec = new Scanner(System.in);
    public static void main(String[] args) {
        Lalumnos v_obj = new Lalumnos();
        v_obj.menu();
    }
    void menu(){
        opc1(2);
    }
    void opc1(int p_long){
        int nc,sem;
        String nombre;
        Alumnos[] v_alumnos = new Alumnos[p_long];
        for(int i=0;i<p_long;i++){
            System.out.println("dime el nc, nom, sem");
            nc= a_tec.nextInt();
            a_tec.nextLine();
            nombre = a_tec.nextLine();
            sem = a_tec.nextInt();
            Alumnos v_obj = new Alumnos(nc,nombre,sem);
            v_alumnos[i] = v_obj;
        }
        for(int j=0; j<p_long;j++){
            System.out.println(v_alumnos[j].getNc()+" "+v_alumnos[j].getNom()+" "+v_alumnos[j].getSem());
        }
    }
    class Alumnos{
        private int nc;
        private String nom;
        private int sem;

        public Alumnos(int nc, String nom, int sem) {
            this.nc = nc;
            this.nom = nom;
            this.sem = sem;
        }

        public int getNc() {
            return nc;
        }

        public String getNom() {
            return nom;
        }

        public int getSem() {
            return sem;
        }
        
    }
}
