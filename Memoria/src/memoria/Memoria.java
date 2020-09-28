package memoria;

public class Memoria {

    public static void main(String[] args) {
        int dataSize = 1024*1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria máxima: "+runtime.maxMemory()/dataSize+"MB");
        System.out.println("Memoria total: "+runtime.totalMemory()/dataSize+"MB");
        System.out.println("Memoria libre: "+runtime.freeMemory()/dataSize+"MB");
        System.out.println("Memoria usada: "+(runtime.totalMemory()-runtime.freeMemory())/dataSize+"MB");   
    }
    
}
