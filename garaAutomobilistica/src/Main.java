import Scuderia.Auto;
import utility.Tools;
import java.util.ArrayList;
import java.util.Scanner;
import Scuderia.*;

public class Main {
    public static void main(String[] args) {
        boolean ciclo;
        String[] menu={
                "Gara Automobilistica",
                "Inserimento scuderia",
                "Mosta scuderie",
                "Mostra piloti",
                "Corri gara",
                "Esci"
        };
        ArrayList<Auto> auto=new ArrayList<Auto>();
        Scanner keyboard = new Scanner(System.in);
        int numeroScuderie=0;
        do{
            ciclo = true;
            switch (Tools.menu(menu,keyboard)){
                case 1->{
                    Auto inserimentoAuto;
                    Pilota inserimentoPilota=new Pilota();
                    inserimentoAuto=Auto.inserimentoScuderia(keyboard);
                    inserimentoAuto.setPilota(Pilota.inserimentoPilota(keyboard));
                    //inserimento scuderia
                    try{
                        if (numeroScuderie==0){
                            auto.add(inserimentoAuto);
                            numeroScuderie++;
                        }else {
                            Auto.controlloPilota(auto,inserimentoAuto);
                            auto.add(inserimentoAuto);
                            numeroScuderie++;
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Scuderia aggiunta correttamente");

                }
                case 2->{
                    //mostra scuderie
                    try {
                        Auto.controlloNumeroScuderie(numeroScuderie);
                        for (Auto a:auto){
                            System.out.println(a.toString());
                            System.out.println(a.getPilota().toString());
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 3->{
                    //mostra piloti
                    try {
                        Auto.controlloNumeroScuderie(numeroScuderie);
                        for (Auto a:auto){
                            System.out.println(a.getPilota().toString());
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 4->{
                    //corrigara
                    try {
                        Auto.controlloPiloti(auto);
                        for (Auto a : auto) {
                            a.getPilota().setCronometro(Cronometro.generaTempo());
                        }
                        Auto.stampaClassifica(auto);
                        keyboard.nextLine();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 5->{
                    //termina il programma
                    ciclo = false;
                    System.out.println("Programma terminato");
                }
            }

        }while (ciclo);
    }
}