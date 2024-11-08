package Persona;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.*;
import java.util.function.Predicate;

public class Persona {
    public String nome;
    public String cognome;
    public Accesso presenza;
    public int biglietto;
    public LocalDateTime entrata;

    @Override
    public String toString(){
        Duration durata=Duration.between(entrata, LocalDateTime.now());
        return String.format("Nome:%s  Cognome:%s  Biglietto:%s  Ore di permanenza:%s  Minuti di permanenza:%s  Accesso:%S",nome,cognome,biglietto,durata.toHours(),durata.toMinutes(),presenza);
    }

    public static void generazioneBiglietto(ArrayList<Persona> lunaPark, int personeInserite,Persona persona) {
        Random random=new Random();
        persona.biglietto=random.nextInt(1000,9999);
        //controlla se il biglietto è già stato inserito
        for (int i=0;i<personeInserite;i++) {
            if (persona.biglietto==lunaPark.get(i).biglietto){
                persona.biglietto=random.nextInt(1000,9999);
            }
        }
    }


    public static Persona inserimentoPersona(ArrayList<Persona> lunaPark,Scanner keyboard,int personeInserite) {
        Persona persona=new Persona();
        System.out.println("Inserisci il nome");
        persona.nome=keyboard.nextLine();
        System.out.println("Inserisci il cognome");
        persona.cognome=keyboard.nextLine();
        //inserimento biglietto
        generazioneBiglietto(lunaPark,personeInserite,persona);
        //inserisce che è presente
        persona.presenza=Accesso.dentro;
        //inserimento entrata
        persona.entrata= LocalDateTime.now();
        return persona;
    }

    public static boolean controlloBiglietto(int biglietto,ArrayList<Persona> lunaPark) {
        for (int i=0;i<lunaPark.size();i++) {
            if (lunaPark.get(i).biglietto==biglietto){
                return true;
            }
        }
        return false;
    }

    public static int trovaBiglietto(ArrayList<Persona> lunaPark,int biglietto ) {
        for (int i=0;i<lunaPark.size();i++) {
            if (lunaPark.get(i).biglietto==biglietto){
                return i;
            }
        }
        return -1;
    }

    //returna la posizione del biglietto
    public static int posizioneBiglietto(Persona lunaPark, ArrayList<Giostra> giostre ) {
        for (int i=0;i<giostre.size();i++) {
            if (lunaPark.biglietto==giostre.get(i).biglietto){
                return i;
            }
        }
        return -1;
    }

    public static void rimozioneUtente(ArrayList<Persona> lunaPark,int biglietto,ArrayList<Giostra> giostra) {
        for (int i = 0; i < lunaPark.size(); i++) {
            if (biglietto==giostra.get(i).biglietto) {
                giostra.remove(i);
            }
            if (biglietto==lunaPark.get(i).biglietto) {
                lunaPark.get(i).presenza=Accesso.fuori;
            }
        }
    }
}


