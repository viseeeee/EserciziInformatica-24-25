package Scuderia;

import java.util.ArrayList;
import java.util.Scanner;

public class Auto {
    private String scuderia;
    private Pilota pilota;
    private String cilindrata;

    public void setPilota(Pilota pilota) {
        this.pilota = pilota;
    }

    public Pilota getPilota() {
        return pilota;
    }

    public void setCilindrata(String cilindrata) {
        this.cilindrata = cilindrata;
    }

    public String getCilindrata() {
        return cilindrata;
    }

    public void setScuderia(String scuderia) {
        this.scuderia = scuderia;
    }

    public String getScuderia() {
        return scuderia;
    }

    public void setAuto(Auto inserimentoauto) {
        this.pilota = inserimentoauto.getPilota();
        this.cilindrata = inserimentoauto.getCilindrata();
        this.scuderia = inserimentoauto.getScuderia();
    }

    @Override
    public String toString() {
        return String.format("Scuderia:%s   Cilindrata:%s", scuderia, cilindrata);
    }

    public static void controlloNumeroScuderie(int numeroScuderie) throws Exception{
        if(numeroScuderie==0)
            throw new Exception("Inserisci delle scuderie");
        return;
    }

    public static void controlloPilota(ArrayList<Auto> auto, Auto inserimentoAuto) throws Exception{
        for (Auto a : auto) {
            if (a.getPilota().getNome().equals(inserimentoAuto.getPilota().getNome()) && a.getPilota().getCognome().equals(inserimentoAuto.getPilota().getCognome()) && a.getPilota().getEta()==inserimentoAuto.getPilota().getEta()) {
                throw new Exception("Hai già inserito questo pilota");
            }
        }
    }

    public static Auto inserimentoScuderia(Scanner keyboard){
        Auto auto = new Auto();
        System.out.println("Inserisci scuderia: ");
        auto.setScuderia(keyboard.nextLine());
        System.out.println("Inserisci la cilindrata: ");
        auto.setCilindrata(keyboard.nextLine());
        return auto;
    }


}
