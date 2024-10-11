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
                "Visualizza",
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
            case 2->FrontEnd.Visualizza(mensola,libriInseriti,keyboard);
            case 3->ripetizione=false;
            default-> ripetizione=false;
        }
        }while (ripetizione);
    }

}