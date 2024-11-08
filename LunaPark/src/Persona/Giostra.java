package Persona;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Giostra {
    public String[] giostre=new String[10];
    public LocalDateTime[] oraGiostra = new LocalDateTime[10];
    public int biglietto;

    public static void VisualizzaGiostre(Giostra giostra) {
        // Scorre l'array giostre della persona all'indice 'posizione'
        for (int i = 0; i < giostra.giostre.length; i++) {
            // Verifica se l'elemento dell'array giostre è diverso da null
            if (giostra.giostre[i] != null) {
                // Stampa il nome della giostra e l'orario della giostra
                System.out.println("Giostra: " + giostra.giostre[i] +
                        " Ora della giostra: " + giostra.oraGiostra[i]);
            }
        }
    }


    public static void aggiungiGiostra(String giostra, ArrayList<Giostra> giostre,Persona persona) {
        for (Giostra g : giostre) {
            int posizione=0;
            if (g.biglietto== persona.biglietto && g.giostre[posizione] == null) {
                g.giostre[posizione]=giostra;
                g.oraGiostra[posizione]=LocalDateTime.now();
                return;
            }else
                posizione++;
        }
    }
}
