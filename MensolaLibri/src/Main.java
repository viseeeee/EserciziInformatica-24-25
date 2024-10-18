import frontScreen.FrontEnd;
import mensola.Libro;

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
                "Esci"
        };
        do {
        switch (menu(menu,keyboard)){
            case 1-> {
                if (libriInseriti<=20){
                    Libro libro = FrontEnd.Inserimento(keyboard);
                    if (FrontEnd.controlloTitolo(mensola,libro,libriInseriti)) {
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
                if (FrontEnd.posizioneTitolo(mensola,titolo,libriInseriti)!=-1){
                    do {
                        System.out.println("Inserisci il numero di pagine del libro");
                        mensola[FrontEnd.posizioneTitolo(mensola,titolo,libriInseriti)].numeroPagine=keyboard.nextInt();
                    }while (FrontEnd.controlloPagine(mensola[FrontEnd.posizioneTitolo(mensola,titolo,libriInseriti)]));
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
                    String autore;
                    do {
                        System.out.println("Inserisci il nome dell'autore");
                        autore=keyboard.nextLine();
                    }while (FrontEnd.numeroAutoriUguali(mensola,autore,libriInseriti)==-1);
                    FrontEnd.visualizzaAutori(mensola,libriInseriti,keyboard,FrontEnd.posizioneAutore(mensola,autore,libriInseriti));
                }else {
                    System.out.println("Inserisci un libro");
                }
            }
            case 5->{
                String titolo;
                if (libriInseriti!=0) {
                    do {
                        System.out.println("Inserisci il nome del titolo");
                        titolo=keyboard.nextLine();
                    }while (FrontEnd.posizioneTitolo(mensola,titolo,libriInseriti)==-1);
                    mensola=FrontEnd.cancellaTitolo(mensola,libriInseriti,titolo);
                    libriInseriti--;
                }else {
                    System.out.println("Inserisci un libro");
                }
            }
            case 6->ripetizione=false;
            default-> ripetizione=false;
        }
        }while (ripetizione);
    }

}