import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
import java.util.Random;

import Persona.*;
import utility.*;

public class Main {
    public static void main(String[] args) {
        String[] menu={
                "LUNA PARK",
                "Inserisci utente",
                "Uscita utente",
                "Inserisci Giostre",
                "Visualizzazione",
                "Esci"
        };
        ArrayList<Persona> lunaPark=new ArrayList<Persona>();
        ArrayList<Giostra> giostre=new ArrayList<Giostra>();
        int personeInserite=0;
        Scanner keyboard=new Scanner(System.in);
        boolean ripetizione;

        do {
            ripetizione=true;
            switch (Tools.menu(menu,keyboard)){
                case 1->{
                Persona persona=Persona.inserimentoPersona(lunaPark,keyboard,personeInserite);
                //inserisce persona dentro lunaPark
                lunaPark.add(persona);
                int biglietto=lunaPark.get(personeInserite).biglietto;
                Giostra personaGiostra=new Giostra();
                personaGiostra.biglietto=biglietto;
                giostre.add(personaGiostra);
                personeInserite++;
                }
                case 2->{
                    if (personeInserite!=0) {
                        System.out.println("Inserisci il numero del biglietto della persona");
                        int biglietto =Integer.parseInt(keyboard.nextLine());
                        if (!Persona.controlloBiglietto(biglietto,lunaPark))
                            System.out.println("Non è presente nessun utente con quel biglietto");
                        else {
                            Persona.rimozioneUtente(lunaPark,biglietto,giostre);
                            System.out.println("Utente rimosso");
                            personeInserite--;
                        }
                    }else {
                        System.out.println("Non hai ancora inserito delle persone");
                    }
                }

                case 3->{
                    //inserimento giostre
                    System.out.println("Inserisci il biglietto");
                    int biglietto =Integer.parseInt(keyboard.nextLine());
                    if (Persona.trovaBiglietto(lunaPark,biglietto)==-1){
                        System.out.println("Il biglietto che hai inserito non è presente");
                    }else {
                        System.out.println("Inserisci la giostra nel quale vuole partecipare");
                        String giostra=keyboard.nextLine();
                        Giostra.aggiungiGiostra(giostra,giostre,Persona.trovaBiglietto(lunaPark,biglietto));
                    }
                }
                case 4->{
                    int posizione=0;
                    //controlla se le persone sono state inserite
                    if (personeInserite!=0) {
                    for (Persona persona : lunaPark){
                        System.out.println(persona.toString());
                        //metodo che returna la posizione di giostra
                        if (giostre.get(posizione).giostre[0]!=null){
                            Giostra.VisualizzaGiostre(giostre,Persona.posizioneBiglietto(lunaPark,giostre));
                        }
                        posizione++;
                    }
                    }else {
                        System.out.println("Non hai ancora inserito delle persone");
                    }
                }
                case 5->{
                ripetizione=false;
                    System.out.println("Programma terminato");
                }
            }
        }while (ripetizione);
    }
}