import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Concessionario concessionario = new Concessionario();

        Auto a1 = new AutoNuova(1, "Fiat", "Panda", 12000, 2022, "Benzina", 69);
        Auto a2 = new AutoCarro(2, "Iveco", "Daily", 25000, 2020, 35);

        concessionario.aggiungiAuto(a1);
        concessionario.aggiungiAuto(a2);

        System.out.println("TUTTE LE AUTO:");
        concessionario.mostraTutte();

        System.out.println("RICERCA PER MARCA: Fiat");
        concessionario.ricercaPerMarca("Fiat");

        System.out.println("AUTO DA ANNO 2021:");
        concessionario.visualizzaDaAnno(2021);
    }
}