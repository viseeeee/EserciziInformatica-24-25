import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        //dichiarazione delle variabili
        int cifre,ricerca,posizione;
        //controlla se il numero inserito è tra 0 e 20
        do {
            //inserimento del numero dell'array
        System.out.println("Inserisci di quante cifre deve essere l'array(0/20)");
        cifre=keyboard.nextInt();
        }while (cifre<0 || cifre>20);
        //dichiarazione dell'array
        int[] numero=new int[cifre];
        //inserimento del valore all'interno di un array
        for (int i=0;i<cifre;i++){
            System.out.println("Inserisci il valore numero "+ (i+1));
            numero[i]=keyboard.nextInt();
        }
        //inserimento del numero da ricercare
        System.out.println("Inserisci il numero che vuoi ricercare");
        ricerca=keyboard.nextInt();
        //richiamo del metodo
        posizione=Ricerca(numero,ricerca);
        //controlla se è presente o no
        if (posizione!=-1){
            System.out.println("La posizione del numero ricercato all'interno dell'array è nella posizione:"+posizione);
        }else {
            System.out.println("Il numero ricercato non è preseente all'interno dell'array");
        }
    }
    public static int Ricerca(int[] numero,int ricerca){
        //scorre tra l'array per cercarlo
    for (int i=0;i< numero.length;i++){
        if(numero[i]==ricerca){
            //restituisce la posizione se lo trova
            return i;
        }
    
    //returna -1 perchè le posizione dell'array iniziano da 0 quindi è un valore che non può assumere
    return -1;
    }
}