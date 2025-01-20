import Scuderia.Auto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utility.Tools;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import Scuderia.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        final String csvPath="C:\\Users\\User\\Desktop\\garaAutomobilistica\\Griglia.csv";
        final String jsonPath="C:\\Users\\User\\Desktop\\garaAutomobilistica\\Griglia.json";
        boolean ciclo;
        String[] menu={
                "Gara Automobilistica",
                "Inserimento scuderia",
                "Mosta scuderie",
                "Mostra piloti",
                "Corri gara",
                "cambia scuderia",
                "salva su file",
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
                    //corri gara
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
                    try{
                        Auto.controlloNumeroScuderie(numeroScuderie);
                        Auto.cambioScuderia(auto,keyboard);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                }
                case 6->{
                    //salva su file
                    ArrayList<String> csv=new ArrayList<>();
                    try{
                        for (Auto a:auto){
                            csv.add(a.toString());
                            Files.write(Paths.get(csvPath),csv);
                            csv.add(a.getPilota().toString());
                            Files.write(Paths.get(csvPath),csv);
                        }
                        System.out.println("Csv inserito correttamente");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }


                    try(FileWriter writer=new FileWriter(jsonPath);) {
                        Gson gson=new GsonBuilder().setPrettyPrinting().create();
                        for (Auto a:auto){
                            gson.toJson(a,writer);
                        }
                        System.out.println("Json inserito correttamente");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                }
                case 7->{
                    //termina il programma
                    ciclo = false;
                    System.out.println("Programma terminato");
                }
            }

        }while (ciclo);
    }
}