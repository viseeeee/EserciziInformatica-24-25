
import java.util.ArrayList;
import java.util.Scanner;
import Utility.*;
public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<ProdottoElettronico> prodotti = new ArrayList<>();
        String[] menu={
                "PRODOTTO ELETRONICA",
                "inserisci un prodotto",
                "Ricerca un prodotto per il codice",
                "Modifica il prezzo di un prodotto",
                "Visualizza tutti i prodotti",
                "Rimuovi un prodotto",
                "Esci"
        };
        boolean exit=false;

        do {
            switch (Tools.menu(menu,keyboard)){
                case 1->{
                    //inserisci un prodotto
                    try{
                        prodotti.add(inserisciSmartphone(keyboard,prodotti));
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 2->{
                    //ricerca di un prodotto per il codice
                    System.out.println("Inserisci il codice del prodotto");
                    String codice = keyboard.nextLine();
                    for (ProdottoElettronico prodotto : prodotti){
                        if (prodotto.getCodiceProdotto().equals(codice)){
                            System.out.println(prodotto.toString());
                        }
                    }
                }
                case 3->{
                    //modifica prezzo di un prodotto
                    System.out.println("Inserisci il codice del prodotto");
                    String codice = keyboard.nextLine();
                    for (ProdottoElettronico prodotto : prodotti){
                        if (prodotto.getCodiceProdotto().equals(codice)){
                            System.out.println("Modifica il prezzo del prodotto");
                            prodotto.setPrezzo(Double.parseDouble(keyboard.nextLine()));
                        }
                    }
                }
                case 4->{
                    //visualizza i prodotti
                    visualizza(prodotti);
                }
                case 5->{
                    try {
                        //rimuovi un prodotto
                        System.out.println("Inserisci il codice del prodotto");
                        String codice = keyboard.nextLine();
                        prodotti.remove(returnaPosizione(prodotti, codice)-1);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 6->{
                    exit=true;
                    System.out.println("Programma terminato con successo");
                }

            }
        }while (!exit);
    }

    private static Smartphone inserisciSmartphone(Scanner keyboard,ArrayList<ProdottoElettronico> prodottoElettronico)throws Exception{
        Smartphone inseriemento;
        System.out.println("Inserisci il codiceProdotto");
        String codiceProdotto = keyboard.nextLine();
        System.out.println("Inserisci la marca");
        String marca = keyboard.nextLine();
        System.out.println("Inserisci il prezzo");
        double prezzo = Double.parseDouble(keyboard.nextLine());
        System.out.println("Inserisci il modello");
        String modello = keyboard.nextLine();
        System.out.println("Inserisci la memoria");
        int memoria = Integer.parseInt(keyboard.nextLine());
        controlloID(prodottoElettronico,codiceProdotto);
        return inseriemento=new Smartphone(codiceProdotto, marca, prezzo, modello, memoria);
    }

    private static void controlloID(ArrayList<ProdottoElettronico> prodottoElettronico,String codiceProdotto)throws Exception{
        for (ProdottoElettronico prodotto : prodottoElettronico){
            if(prodotto.getCodiceProdotto().equals(codiceProdotto)){
                throw new Exception("Hai già inserito questo codice prodotto");
            }
        }
    }

    private static void visualizza(ArrayList<ProdottoElettronico> prodottoElettronico){
        for (ProdottoElettronico prodotto : prodottoElettronico){
            System.out.println(prodotto.toString());
        }
    }

    private static int returnaPosizione(ArrayList<ProdottoElettronico> prodotti,String codice)throws Exception{
        int i=0;
        for (ProdottoElettronico prodotto : prodotti){
            i++;
            if (prodotto.getCodiceProdotto().equals(codice)){
                return i;
            }
        }
        throw new Exception("Il codice inserito non esiste");
    }

}