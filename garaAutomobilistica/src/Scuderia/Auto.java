package Scuderia;

import java.util.ArrayList;
import java.util.Random;
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
        return String.format("Scuderia: %s; Cilindrata: %scc;", scuderia, cilindrata);
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

    public static void setCronometro(ArrayList<Auto> auto){
        Cronometro temp;
        for (Auto a : auto) {
            temp=Cronometro.generaTempo();
            a.getPilota().setCronometro(temp);
        }
    }



    public static void stampaClassifica(ArrayList<Auto> auto) {
        // Bubble sort per ordinare le auto in base al tempo del cronometro
        for (int i = 0; i < auto.size() - 1; i++) {
            for (int j = 0; j < auto.size() - i - 1; j++) {
                // Confronta i tempi tra auto[j] e auto[j + 1]
                if (confrontaTempi(auto.get(j).getPilota().getCronometro(),
                        auto.get(j + 1).getPilota().getCronometro()) > 0) {
                    // Scambia le auto
                    Auto tempAuto = auto.get(j);
                    auto.set(j, auto.get(j + 1));
                    auto.set(j + 1, tempAuto);
                }
            }
        }
        for(int i = 0; i < auto.size(); i++){
            System.out.printf("%d° -- %s Tempo: %d:%d.%d\n",i+1, auto.get(i).pilota.toString(), auto.get(i).pilota.getCronometro().getMinuti(), auto.get(i).pilota.getCronometro().getSecondi(), auto.get(i).pilota.getCronometro().getMillisecondi());
        }
    }

    private static int confrontaTempi(Cronometro c1, Cronometro c2) {
        if (c1.getMinuti() != c2.getMinuti()) {
            return c1.getMinuti() - c2.getMinuti();
        }
        if (c1.getSecondi() != c2.getSecondi()) {
            return c1.getSecondi() - c2.getSecondi();
        }
        return c1.getMillisecondi() - c2.getMillisecondi();
    }


    public static void controlloPiloti(ArrayList<Auto> auto)throws Exception{
        if (auto.size()<=1)
            throw new Exception("Inserisci altri piloti");
    }
}