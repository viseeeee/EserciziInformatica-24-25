/*Definire la classe Auto che è composta dagli attributi:
id
marca
modello
prezzo
anno di immatricolazione
Definire la classe AutoNuova che deriva da Auto contenente i seguenti attributi:
alimentazione
cavalli
Definire la classe AutoCarro che deriva da Auto che contenente i seguenti attributi:
tara (in quintali)
Definire la classe Concessionario che implementa le operazioni CRUD. Occorre aggiungere:
ricerca() per marca
visualizzare gli autoveicoli disponibili a partire dall'anno di immatricolazione
Occorre definire due metodi:
calcolaValoreAttuale() calcola il valore attuale dell'auto a partire dal 2025 considerando che per ogni anno dalla data di immatricolazione l'auto si svaluta del 5%
mostraDettagli() visualizza i dettagli e le caratteristiche di ogni autoVeicolo - astratto*/

import Auto.*;
import utility.Tools;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard=new Scanner(System.in);
        Concessionario concessionario = new Concessionario();
        String[] menu={
                "AUTO",
                "Inserimento",
                "Modifica Prezzo",
                "Modifica Anno",
                "Mostra auto modificate",
                "Mostra auto",
                "Elimina una macchina",
                "Ricerca una macchina",
                "esci"
        };
        boolean exit = false;

        do {
            switch (Tools.menu(menu,keyboard)){
                case 1->{

                    //inserimento
                    if (scelta(keyboard).equals(Scelta.AUTOCARRO)){
                        try{
                            AutoCarro a=inserimentoAutoCarro(keyboard);
                            concessionario.confrontoID(a.getID());
                            concessionario.setAuto(a);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }else {
                        try{
                            AutoNuova a=inserimentoAutoNuova(keyboard);
                            concessionario.confrontoID(a.getID());
                            concessionario.setAuto(a);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
                case 2->{
                    //modifica prezzo
                    try {
                        System.out.println("Inserisci l'id");
                        String id = keyboard.nextLine();
                        concessionario.IDControl(id);
                        for (Auto a : concessionario.getAuto()) {
                            if (a.getID().equals(id)) {
                                System.out.println("Inserisci il prezzo");
                                a.setPrezzo(Integer.parseInt(keyboard.nextLine()));
                            }
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 3->{
                    //modifica anno
                    try {
                        System.out.println("Inserisci l'id");
                        String id = keyboard.nextLine();
                        concessionario.IDControl(id);
                        for (Auto a : concessionario.getAuto()) {
                            if (a.getID().equals(id)) {
                                System.out.println("Inserisci l'anno");
                                a.setAnno(Integer.parseInt(keyboard.nextLine()));
                            }
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 4->{
                    //mostra auto modificate
                }
                case 5->{
                    //mostra auto
                    for (Auto a: concessionario.getAuto()){
                        System.out.println(a.mostraDettagli());
                    }
                }
                case 6->{
                    //elimina macchina
                    try {
                        System.out.println("Inserisci l'id della macchina");
                        concessionario.remove(concessionario.returnIndexID(keyboard.nextLine()));
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 7->{
                    //ricerca una macchina
                    try {
                    System.out.println("Inserisci la marca della macchina");
                    ArrayList<Auto> a=concessionario.ricerca(keyboard.nextLine());
                    for (Auto aut:a){
                        System.out.println(aut.mostraDettagli());
                    }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 8->{
                    //esci
                    exit = true;
                    System.out.println("Programma terminato");
                }
            }

        }while (!exit);


    }
    private static Scelta scelta(Scanner keyboard){
        String[] menu={
            "SCElTA",
            "Auto Nuova",
            "Auto Carro"
        };
        switch (Tools.menu(menu,keyboard)){
                case 1->{
                    return Scelta.AUTONUOVA;
                }
                case 2->{
                    return Scelta.AUTOCARRO;
                }
        }
        return null;
    }

    private static Alimentazione alimentazione(Scanner keyboard) {
        String[] menu = {
                "SCElTA",
                "Bnezina",
                "GPL",
                "Metano"
        };
        switch (Tools.menu(menu, keyboard)) {
            case 1 -> {
                return Alimentazione.BENZINA;
            }
            case 2 -> {
                return Alimentazione.GPL;
            }
            case 3->{
                return Alimentazione.METANO;
            }
        }
        return null;
    }

        private static AutoNuova inserimentoAutoNuova(Scanner keyboard) throws Exception {
        AutoNuova inserimento;
        do {
            try {
                System.out.println("Inserisci l'id");
                String id = keyboard.nextLine();
                System.out.println("Inserisci la marca");
                String marca = keyboard.nextLine();
                System.out.println("Inserisci il modello");
                String modello = keyboard.nextLine();
                System.out.println("Inserisci il prezzo");
                double prezzo = Double.parseDouble(keyboard.nextLine());
                System.out.println("Inserisci l'anno");
                int anno = Integer.parseInt(keyboard.nextLine());
                System.out.println("Inserisci i cavalli");
                int cavalli = Integer.parseInt(keyboard.nextLine());
                System.out.println("Inserisci l'alimentazione");
                return inserimento = new AutoNuova(id, marca, modello, prezzo, anno, alimentazione(keyboard), cavalli);
            } catch (NumberFormatException e) {
                System.out.println("Hai sbagliato l'inserimento");
            }
        }while (true);
    }


    private static AutoCarro inserimentoAutoCarro(Scanner keyboard) throws Exception {
        do {
            try {
                AutoCarro inserimento;
                System.out.println("Inserisci l'id");
                String id=keyboard.nextLine();
                System.out.println("Inserisci la marca");
                String marca=keyboard.nextLine();
                System.out.println("Inserisci il modello");
                String modello=keyboard.nextLine();
                System.out.println("Inserisci il prezzo");
                double prezzo=Double.parseDouble(keyboard.nextLine());
                System.out.println("Inserisci l'anno");
                int anno=Integer.parseInt(keyboard.nextLine());
                System.out.println("Inserisci la tara");
                int tara=Integer.parseInt(keyboard.nextLine());
                return inserimento=new AutoCarro(id,marca,modello,prezzo,anno, tara);
    } catch (NumberFormatException e) {
        System.out.println("Hai sbagliato l'inserimento");
            }
        }while (true);
    }
}