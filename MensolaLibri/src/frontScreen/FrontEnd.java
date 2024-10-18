package frontScreen;

import mensola.Genere;
import mensola.Libro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static utility.Tools.menu;

public class FrontEnd {

    public static void Visualizza(Libro[] mensola,int libriInseriti,Scanner keyboard){
        if (!controlloVisualizzazione(libriInseriti)) {
            for (int i = 0; i < libriInseriti; i++) {
                System.out.println(mensola[i].toString());
                keyboard.nextLine();
            }
        }else {
            System.out.println("Non hai ancora inserito dei libri");
            keyboard.nextLine();
        }
    }

    public static boolean controlloVisualizzazione(int libriInseriti){
        if (libriInseriti!=0)
            return false;
        else
            return true;
    }

    public static Libro Inserimento(Scanner keyboard){
        Libro libro=new Libro();
        System.out.println("Inserisci l'autore del libro");
        libro.autore = keyboard.nextLine();
        System.out.println("Inserisci il titolo del libro");
        libro.titolo = keyboard.nextLine();
        inserimentoPagine(libro, keyboard);
        inserimentoTipologia(libro, keyboard);
        boolean dataValida = false;
        while (!dataValida) {
            System.out.println("Inserisci la data di pubblicazione del libro (formato: dd/MM/yyyy): ");
            String dataInput = keyboard.nextLine();
            try {
                libro.dataPubblicazione = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                dataValida = true;  // Esce dal ciclo se la data è valida
            } catch (Exception e) {
                System.out.println("Formato della data non valido. Riprova.");
            }
        }
        return libro;
    }

    public static boolean controlloTitolo(Libro[] mensola,Libro libro,int libriInseriti){
        for (int i = 0; i < libriInseriti; i++){
            if (libro.titolo.equals(mensola[i].titolo)){
                return false;
            }
        }
        return true;
    }

    public static void inserimentoPagine(Libro libro,Scanner keyboard){
        do {
            System.out.println("Inserisci il numero di pagine del libro");
            libro.numeroPagine=keyboard.nextInt();
            keyboard.nextLine();
            if (controlloPagine(libro))
                System.out.println("Hai inserito un valore minore o uguale a 0 per le pagine del libro");
        }while (controlloPagine(libro));
    }

    public static void inserimentoTipologia(Libro libro,Scanner keyboard){
        String[] tipologia={"TIPOLOGIA","ROMANZO","MANUALE","THRILLER"};
        boolean ripetizione=false;
        do {
            switch (menu(tipologia,keyboard)){
                case 1-> libro.tipologia=Genere.ROMANZO;
                case 2-> libro.tipologia=Genere.MANUALE;
                case 3-> libro.tipologia=Genere.THRILLER;
                default-> ripetizione=true;
            }
        }while (ripetizione);
    }

    public static int posizioneTitolo(Libro[] mensola, String titolo, int libriInseriti){
        for (int i = 0; i < libriInseriti; i++) {
            if (titolo.equals(mensola[i].titolo)){
                return i;
            }
        }
        return -1;
    }
    public static int numeroAutoriUguali(Libro[] mensola, String autore, int libriInseriti){
        int contatore=0;
        for (int i = 0; i < libriInseriti; i++) {
            if (autore.equals(mensola[i].autore)){
                contatore++;
            }
        }
        if (contatore!=0)
            return contatore;
        else
            return -1;
    }
    public static Libro[] cancellaTitolo(Libro[] mensola,int libriInseriti,String titolo){
        Libro[] libro=new Libro[mensola.length -1];
        for (int i = 0; i < libriInseriti-1; i++) {
            if (i==posizioneTitolo(mensola,titolo,libriInseriti)){
                libro[i]=mensola[i+1];
            }else
                libro[i]=mensola[i];
        }
        return libro;
    }

    public static int[] posizioneAutore(Libro[] mensola, String autore, int libriInseriti){
        int[] posizioni=new int[numeroAutoriUguali(mensola,autore,libriInseriti)];
        if (posizioni[0]!=-1) {
            for (int i = 0; i < libriInseriti; i++) {
                if (autore.equals(mensola[i].autore)) {
                    posizioni[i] = i;
                }
            }
            return posizioni;
        }else {
            return posizioni;
        }
    }

    public static void visualizzaAutori(Libro[] mensola,int libriInseriti,Scanner keyboard,int[] posizione){
        if (!controlloVisualizzazione(libriInseriti)) {
            for (int i = 0; i < posizione.length; i++) {
                System.out.println(mensola[posizione[i]].toString());
                keyboard.nextLine();
            }
        }else {
            System.out.println("Non hai ancora inserito dei libri");
            keyboard.nextLine();
        }
    }

    public static boolean controlloPagine(Libro libro){
        if(libro.numeroPagine<=0)
            return true;
        else
            return false;
    }
}
