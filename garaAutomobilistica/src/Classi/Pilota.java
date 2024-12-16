package Classi;

import java.util.ArrayList;
import java.util.Scanner;

public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;
    private int eta;

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCognome() {return cognome;}
    public void setCognome(String cognome) {this.cognome = cognome;}

    public String getNazionalita() {return nazionalita;}
    public void setNazionalita(String nazionalita) {this.nazionalita = nazionalita;}

    public int getEta() {return eta;}
    public void setEta(int eta) {this.eta = eta;}

    public Pilota() {
        setNome("");
        setCognome("");
        setNazionalita("");
        setEta(0);
    }

    public static Pilota inserimentoPilota(ArrayList<Pilota> piloti, Scanner keyboard) {
        boolean inserito;
        Pilota p = new Pilota();
        do{
            inserito = false;
            System.out.println("Inserisci nome pilota");
            p.setNome(keyboard.nextLine());
            System.out.println("Inserisci cognome pilota");
            p.setCognome(keyboard.nextLine());
            System.out.println("Inserisci eta pilota");
            p.setEta(Integer.parseInt(keyboard.nextLine()));
            for(Pilota pi : piloti) {
                if(pi.getNome().equals(p.getNome()) && pi.getCognome().equals(p.getCognome()) && pi.getEta() == p.getEta()) {
                    inserito = true;
                    break;
                }
            }
            System.out.println("Inserisci nazionalità pilota");
            p.setNazionalita(keyboard.nextLine());
            if(inserito) {
                System.out.println("Pilota già inserito, riprova.");
            }
        }while(inserito);
        return p;
    }

    @Override
    public String toString() {
        return String.format("Pilota -- Nome: %s, Cognome: %s, Eta: %d, Nazionalità: %s", getNome(), getCognome(), getEta(), getNazionalita());
    }
}
