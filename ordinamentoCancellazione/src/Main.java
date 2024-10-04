import java.util.Scanner;
import static tools.utility.menu;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner keyboard= new Scanner(System.in);
        //dichiarazione variabili
        int nPosizioni,ricerca;
        boolean esci =false;
        //istanziamento menu
        String[] menu={
                "MENU",
                "[1] Sostituisci valore ricercato con 0",
                "[2] Cancellazione valore ricercato con ricompattazione",
                "[3] Ordinamento tramite selection",
                "[4] Visualizza",
                "[5] Esci"

        };
        do {
        //gli fai inserire all'utente il numero di posizioni che deve avere l'array
        System.out.println("Inserisci quante posizioni deve avere l'array(1/20)");
        nPosizioni = keyboard.nextInt();
        }while (nPosizioni>20 || nPosizioni<=0);
        //attribuisce all'array la sua grandezza
        int[] numeri = new int[nPosizioni];

        //si riempie l'array inserendo i valori al suo interno
        generazioneRandom(numeri);
        do {
        switch (menu(menu,keyboard)){
            case 1:
                System.out.println("Inserisci il valore da ricercare");
                ricerca=keyboard.nextInt();
                //entra se il valore inserito non è presente nell'array
                if (Ricerca(numeri,ricerca)==-1){
                    System.out.println("Il numero che hai inserito non è presente all'interno dell'array");
                }else {
                    //sostituisce il valore ricercato con 0
                    numeri[Ricerca(numeri,ricerca)]=0;
                    System.out.println("Il numero ricercato è stato cambiato");
                }
                break;
            case 2:
                //riduce la posizione dell'array
                System.out.println("Inserisci il valore da ricercare");
                ricerca=keyboard.nextInt();
                //entra se il valore non è presente nell'array
                if (Ricerca(numeri,ricerca)==-1){
                    System.out.println("Il numero che hai inserito non è presente all'interno dell'array");
                }else {
                    //Riduce la posizione
                    numeri=riduciPos(numeri,Ricerca(numeri,ricerca));
                    System.out.println("L'array è stato diminuito di una posizione");
                }
                break;
            case 3:
                //ordina l'array
                selectionSort(numeri);
                System.out.println("L'array è stato ordinato");
                break;
            case 4:
                //visualizzazione dell'array
                Visualizza(numeri);
                break;
            case 5:
                //esce dal ciclo
                esci=true;
            break;
            default:
                System.out.println("Hai inserito un valore errato");
                break;
        }
        }while (!esci);

    }

    //trova la posizione del numero ricercato
    public static int Ricerca(int[] numeri, int ricerca){
        for (int i = 0; i < numeri.length; i++) {
            if (numeri[i] == ricerca) {
                return i;
            }
        }
        return -1;
    }

    public static int[] riduciPos (int[] numeri,int posizione){
        //istanzio l'array nuovo
        int[] numeri2 = new int[numeri.length-1];
        for (int i = 0; i < numeri.length; i++) {
            //esce dal ciclo al penultimo valore
            if(i==numeri.length-1){
                return numeri2;
                //attribuisce all'array il numero successivo
            }else if (i>=posizione) {
                numeri2[i]=numeri[i+1];
                //attribuisce i valori normalmente
            }else {
                numeri2[i]=numeri[i];
            }
        }
        return numeri2;
    }

    //visualizza tutto l'array
    public static void Visualizza (int[] numeri){
        for (int i = 0; i < numeri.length; i++) {
            System.out.print(numeri[i]+"    ");
            if (i==numeri.length-1){
                System.out.println(" ");
            }
        }
    }

    //genera i numeri nell'array
    public static void generazioneRandom(int[] numeri){
        Random random=new Random();
        for (int i = 0; i < numeri.length; i++) {
            numeri[i]=random.nextInt(1,100)+1;
        }
    }

    //selection sort
    public static void selectionSort(int[]numeri){
        int temp;
        for (int i = 0; i < numeri.length; i++) {
            for (int j = i+1; j < numeri.length; j++) {
                if (numeri[i]>numeri[j]){
                    temp=numeri[i];
                    numeri[i]=numeri[j];
                    numeri[j]=temp;
                }
            }
        }
    }

}