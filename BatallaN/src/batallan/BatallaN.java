package batallan;

public class BatallaN {
    String[][] matriz = new String[5][5];
    public static void main(String[] args) {
        BatallaN v_obj = new BatallaN();
        v_obj.entrada();
    }
    void entrada(){
        matriz();
    }
    void randoms(){
        int x,y;
        x = (int)(Math.random()*5);
        y = (int)(Math.random()*5);
        System.out.println(x+", "+y);
        if(matriz[x][y].equals("*")){
            System.out.println("ok");
            matriz[x][y]="B";
        }else{
            randoms();
        }
    }
    void matriz(){
        for(int i=0; i<5; i++){
            for(int k=0; k<5; k++){
                matriz[i][k] = "*";
            }
        }
        for(int j=0; j<5; j++){
            for(int p=0; p<5; p++){
                System.out.print(matriz[j][p]+" ");
            }
            System.out.println("");
        }
        for(int i=0;i<5;i++){
            randoms();
        }
        for(int j=0; j<5; j++){
            for(int p=0; p<5; p++){
                System.out.print(matriz[j][p]+" ");
            }
            System.out.println("");
        }
    }
}