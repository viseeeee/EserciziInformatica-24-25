package Persona;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Giostra {
    public String[] giostre=new String[10];
    public LocalDateTime[] oraGiostra = new LocalDateTime[10];
    public int biglietto;

    public void setBiglietto(int biglietto) {
        this.biglietto = biglietto;
    }

    public static void VisualizzaGiostre(ArrayList<Giostra> giostra, int posizione) {
        // Scorre l'array giostre della persona all'indice 'posizione'
        for (int i = 0; i < giostra.get(posizione).giostre.length; i++) {
            // Verifica se l'elemento dell'array giostre è diverso da null
            if (giostra.get(posizione).giostre[i] != null) {
                // Stampa il nome della giostra e l'orario della giostra
                System.out.println("Giostra: " + giostra.get(posizione).giostre[i] +
                        " Ora della giostra: " + giostra.get(posizione).oraGiostra[i] + "\n");
            }
        }
    }


    public static void aggiungiGiostra(String giostra, ArrayList<Giostra> giostre, int posizione) {
        for (int j = 0; j < giostre.size(); j++) {
            if (giostre.get(posizione).giostre[j] == null) {
                giostre.get(posizione).giostre[j]=giostra;
                giostre.get(posizione).oraGiostra[j]=LocalDateTime.now();
                return;
            }
        }
    }
}
