import frontScreen.FrontEnd;
import mensola.Libro;

import java.util.Formatter;
import java.util.Scanner;

import static utility.Tools.menu;


public class Main {
    public static void main(String[] args) {
        int MAX_LIBRI = 20;
        Libro[] mensola = new Libro[MAX_LIBRI];
        int libriInseriti=0;
        boolean ripetizione=true;
        Scanner keyboard = new Scanner(System.in);
        String[] menu={
                "Libreria",
                "Inserimento",
                "Modifica pagine di un libro",
                "Visualizza tutti i libri",
                "Visualizza i libri tramite autore",
                "Cancella un libro",
                "Costo dei libri di un autore",
                "Visualizza la posizione dei libri tramite autore",
                "Esci"
        };
        do {
        switch (menu(menu,keyboard)){
            //inserimento
            case 1-> {
                if (libriInseriti<=20){
                    Libro libro = FrontEnd.Inserimento(keyboard);
                    if (FrontEnd.controlloLibro(mensola,libro,libriInseriti)) {
                        mensola[libriInseriti] = libro;
                        libriInseriti++;
                    }else
                        System.out.println("Hai già inserito questo libro");

                }else {
                    //entra quando si finisce la posizione nell'array
                    System.out.println("Hai finito lo spazio dove mettere i libri");
                }
            }
            case 2->{
                if (libriInseriti!=0){
                System.out.println("Inserisci il titolo del libro");
                String titolo=keyboard.nextLine();
                System.out.println("Inserisci l'autore del libro");
                String autore=keyboard.nextLine();
                if (FrontEnd.posizioneLibro(mensola,titolo,libriInseriti,autore)!=-1){
                    do {
                        System.out.println("Inserisci il numero di pagine del libro");
                        mensola[FrontEnd.posizioneLibro(mensola,titolo,libriInseriti,autore)].numeroPagine=keyboard.nextInt();
                    }while (FrontEnd.controlloPagine(mensola[FrontEnd.posizioneLibro(mensola,titolo,libriInseriti,autore)]));
                }else {
                    System.out.println("Questo libro non esiste");
                }
                }else {
                    System.out.println("Inserisci un libro");
                }
            }
            case 3->FrontEnd.Visualizza(mensola,libriInseriti,keyboard);
            case 4->{
                if (libriInseriti!=0) {
                    System.out.println("Inserisci il nome dell'autore");
                    String autore = keyboard.nextLine();
                    if (FrontEnd.numeroAutoriUguali(mensola, autore, libriInseriti) == -1)
                        System.out.println("Non esiste questo autore");
                    else {
                        FrontEnd.Visualizza(FrontEnd.posizioneAutore(mensola, libriInseriti, autore), FrontEnd.numeroAutoriUguali(mensola, autore, libriInseriti), keyboard);
                    }
                }else
                    System.out.println("Inserisci un libro");
            }
            case 5->{
                String titolo,autore;
                if (libriInseriti!=0) {
                        System.out.println("Inserisci il nome del titolo");
                        titolo=keyboard.nextLine();
                        System.out.println("Inserisci l'autore del libro autore");
                        autore=keyboard.nextLine();
                    if (FrontEnd.posizioneLibro(mensola,titolo,libriInseriti,autore)!=-1){
                        mensola=FrontEnd.cancellaTitolo(mensola,libriInseriti,titolo,autore);
                        libriInseriti--;
                    }else
                        System.out.println("Non è presente nessun libro con questo titolo e con questo autore");
                }else {
                    System.out.println("Inserisci un libro");
                }
            }
            case 6->{
                if (libriInseriti!=0) {
                    System.out.println("Inserisci il nome dell'autore");
                    String autore = keyboard.nextLine();
                    if (FrontEnd.numeroAutoriUguali(mensola, autore, libriInseriti) == -1)
                        System.out.println("Non esiste questo autore");
                    else {
                        System.out.printf("Il costo dei libri di questo autore è %.2f\n",FrontEnd.costoLibriAutore(mensola,libriInseriti,autore));
                    }
                }else
                    System.out.println("Inserisci un libro");
            }
            case 7->{
                if (libriInseriti!=0) {
                    System.out.println("Inserisci il nome dell'autore");
                    String autore = keyboard.nextLine();
                    if (FrontEnd.numeroAutoriUguali(mensola, autore, libriInseriti) == -1)
                        System.out.println("Non esiste questo autore");
                    else {
                        System.out.println("La posizione dei libri all'interno dell'array è:");
                        FrontEnd.visualizzaPosizioneLibriAutore(mensola,FrontEnd.posizioneLibriAutore(mensola,libriInseriti,autore),libriInseriti,autore);
                    }
                }else
                    System.out.println("Inserisci un libro");
            }
            case 8->ripetizione=false;
            default-> ripetizione=false;
        }
        }while (ripetizione);
    }

}