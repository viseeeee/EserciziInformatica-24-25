import java.util.Scanner;
import Ingredienti.*;
public class Main {
    public static void main(String[] args) {
        boolean error;
        Scanner keyboard = new Scanner(System.in);
        IngredientiNecessari ingredienti = new IngredientiNecessari();
        ingredienti.setPizza(new Pizza());
        int numeroPizze = 0,numeroPizzeProsciutto=0;
        do {
        try{
            error=true;
            //inserimento farina
            System.out.println("Inserisci la farina da usare(KG)");
            ingredienti.getPizza().setFarina(Double.parseDouble(keyboard.nextLine()));
            //inserimento pomodoro
            System.out.println("Inserisci Il pomodoro da usare(KG)");
            ingredienti.getPizza().setPomodoro(Double.parseDouble(keyboard.nextLine()));
            //inserimento prosciutto
            System.out.println("Inserisci il prosciutto da usare(KG)");
            ingredienti.getPizza().setProsciutto(Double.parseDouble(keyboard.nextLine()));
            //inserimento numero delle pizze
            System.out.println("Inserisci quante pizze vuoi");
            numeroPizze = keyboard.nextInt();
            //controllo sul numero di pizze
            if (numeroPizze<=0){
                throw new Exception();
            } else if (ingredienti.getPizza().getProsciutto()>0) {
                System.out.println("Inserisci quante pizze al prosciutto vuoi");
                numeroPizzeProsciutto = keyboard.nextInt();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            error=false;
        }
        }while (!error);
        // Calcolo della somma totale della pizza
        ingredienti.setSommaTotale(ingredienti.getPizza());

        // Calcolo della farina per ogni pizza
        ingredienti.setFarina(ingredienti.getPizza().getFarina() / numeroPizze);

        // Calcolo del prosciutto per ogni pizza al prosciutto
        ingredienti.setProsciutto(ingredienti.getPizza().getProsciutto() / numeroPizzeProsciutto);

        // Calcolo del pomodoro per pizza al prosciutto
        ingredienti.setPomodoroProsciutto(ingredienti.getSommaTotale()/numeroPizze - ingredienti.getFarina() - ingredienti.getProsciutto());

        // Calcolo del pomodoro per pizza margherita
        ingredienti.setPomodoro((ingredienti.getPizza().getPomodoro() - (ingredienti.getPomodoroProsciutto() * numeroPizzeProsciutto)) / (numeroPizze - numeroPizzeProsciutto));
    }
}