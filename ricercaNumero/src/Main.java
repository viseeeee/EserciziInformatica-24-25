import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        int cifre,ricerca,posizione;
        do {
        System.out.println("Inserisci di quante cifre deve essere l'array(0/20)");
        cifre=keyboard.nextInt();
        }while (cifre<0 || cifre>20);
        int[] numero=new int[cifre];
        for (int i=0;i<cifre;i++){
            System.out.println("Inserisci il valore numero "+ (i+1));
            numero[i]=keyboard.nextInt();
        }
        System.out.println("Inserisci il numero che vuoi ricercare");
        ricerca=keyboard.nextInt();
        posizione=Ricerca(numero,ricerca);
        if (posizione!=-1){
            System.out.println("La posizione del numero ricercato all'interno dell'array è nella posizione:"+posizione);
        }else {
            System.out.println("Il numero ricercato non è preseente all'interno dell'array");
        }
    }
    public static int Ricerca(int[] numero,int ricerca){
    for (int i=0;i< numero.length;i++){
        if(numero[i]==ricerca){
            return i;
        }
    }
    return -1;
    }
}