import utility.Tools;
import utility.Tools.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<GestoreSolidi> gestoreSolidi=new ArrayList<>();
        String [] menu={
                "MENU",
                "Inserisci Cubo",
                "Inserisci Sfera",
                "Visualizza tutto",
                "Esci"
        };
        boolean exit=false;
        boolean sbagliato;
        Scanner keyboard = new Scanner(System.in);
        do {
            switch (Tools.menu(menu,keyboard)){
                case 1->{
                    sbagliato=false;
                    do {
                    try{
                        System.out.println("Inserisci il cubo");
                        Cubo cubo=new Cubo(keyboard.nextInt());
                        gestoreSolidi.add(cubo);
                        sbagliato=true;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    }while (!sbagliato);
                    System.out.println("Inserimento del cubo avvenuto con successo");
                }
                case 2->{
                    sbagliato=false;
                    do {
                    try{
                    System.out.println("Inserisci la Sfera");
                    Sfera sfera=new Sfera(keyboard.nextInt());
                    gestoreSolidi.add(sfera);
                    sbagliato=true;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    }while (!sbagliato);
                System.out.println("Inserimento della sfera avvenuto con successo");
                }
                case 3->{
                    for (GestoreSolidi gestoreSolidi1:gestoreSolidi){
                            System.out.println(gestoreSolidi1.toString());
                    }
                }
                case 4->
                    exit=true;
            }
        }while (!exit);
        System.out.println("Programma terminato");
    }
}