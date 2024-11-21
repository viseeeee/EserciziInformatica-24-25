import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Segmento segmento1 = new Segmento();
        Segmento segmento2 = new Segmento();
        Scanner keyboard = new Scanner(System.in);
        double lunghezzaSegmento;
        try{
            System.out.println("Inserisci il primo punto");
            segmento1=Segmento.inserimentoSegmento(keyboard);
            System.out.println("Inserisci il secondo punto");
            segmento2=Segmento.inserimentoSegmento(keyboard);
        }catch (Exception e){
            System.out.println(e);
        }
        lunghezzaSegmento=Segmento.lunghezzaSegmento(segmento1,segmento2);
        System.out.println("La lunghezza del segmento è: "+lunghezzaSegmento);
    }
}