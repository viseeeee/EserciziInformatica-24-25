import java.util.Scanner;

public class Segmento {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Segmento(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public Segmento() {}

    public static Segmento inserimentoSegmento(Scanner keyboard) {
        Segmento segmento = new Segmento();
        System.out.println("Inserisci x");
        segmento.setX(Integer.parseInt(keyboard.nextLine()));
        System.out.println("Inserisci y");
        segmento.setY(Integer.parseInt(keyboard.nextLine()));
        return segmento;
    }

    public static double lunghezzaSegmento(Segmento segmento1,Segmento segmento2) {
        return Math.sqrt(Math.pow(segmento1.getX()-segmento2.getX(),2)+Math.pow(segmento1.getY()-segmento2.getY(),2));
    }

}
