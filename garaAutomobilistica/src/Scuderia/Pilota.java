package Scuderia;

import java.util.ArrayList;
import java.util.Scanner;

public class Pilota extends Auto {
    private String nome;
    private String cognome;
    private String nazionalita;
    private int eta;
    private Cronometro cronometro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setCronometro(Cronometro cronometro) {
        this.cronometro = cronometro;
    }

    public Cronometro getCronometro() {
        return cronometro;
    }

    @Override
    public String toString() {
        return String.format("Nome:%s   Cognome:%s  Nazionalità:%s  eta:%s", nome, cognome, nazionalita, eta);
    }


    public static Pilota inserimentoPilota(Scanner keyboard) {
        Pilota inserimento = new Pilota();
        boolean ciclo = true;
        System.out.println("Inserisci il nome del pilota");
        inserimento.setNome(keyboard.nextLine());
        System.out.println("Inserisci il cognome del pilota");
        inserimento.setCognome(keyboard.nextLine());
        System.out.println("Inserisci il nazionalita del pilota");
        inserimento.setNazionalita(keyboard.nextLine());
        do {
            try{
                ciclo=false;
                System.out.println("Inserisci l'età del pilota");
                inserimento.setEta(Integer.parseInt(keyboard.nextLine()));
            }catch (Exception e){
                ciclo = true;
            }
        }while (ciclo);
        return inserimento;
    }



}
