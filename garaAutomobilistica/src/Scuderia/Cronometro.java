package Scuderia;

import java.util.Random;

public class Cronometro extends Pilota{
    private int minuti;
    private int secondi;
    private int millisecondi;

    public void setMillisecondi(int millisecondi) {
        this.millisecondi = millisecondi;
    }

    public int getMillisecondi() {
        return millisecondi;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

    public int getSecondi() {
        return secondi;
    }


    public static Cronometro generaTempo() {
        Random random = new Random();
        Cronometro cronometro = new Cronometro();
        cronometro.setMinuti(random.nextInt(1,2)+1);
        cronometro.setSecondi(random.nextInt(1,59)+1);
        cronometro.setMillisecondi(random.nextInt(1,999)+1);
        return cronometro;
    }
}
