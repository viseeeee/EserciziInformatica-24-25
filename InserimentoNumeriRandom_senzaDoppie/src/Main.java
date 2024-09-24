import java.util.Scanner;
import java.util.Random;

import static tools.utility.menu;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard= new Scanner(System.in);
        final int numeroArray=5;
        final int min=0;
        final int max=4;
        String[] menu={
                "menu",
                "[1]inserimento numeri nell'array",
                "[2]visualizzazione dei numeri nell'array",
                "[3] fine",
        };
        int[] numeri=new int[numeroArray];
        boolean fine=true;
        boolean ripetizione=true;
        do {
            switch (menu(menu,keyboard)){
                case 1:
                    InserimentoValori(numeri,min,max,ripetizione);
                    break;
                case 2:
                    visualizzazione(numeri);
                    break;
                case 3:
                    fine=false;
                    break;
                default:
                    System.out.println("hai inserito un valore errato");
                    break;
            }
        }while (fine);
        }
    public static void InserimentoValori(int[] numeri,int min,int max,boolean ripetizione){
        Random rand = new Random();

        //inserimento dei valori randomici
        for (int i=0; i<numeri.length;i++){
            //inserimento dei valori randomici nell'array
            numeri[i] = rand.nextInt((max - min) + 1) + min;
            ripetizione=controllo(numeri,i);
            while (ripetizione==false) {
                numeri[i] = rand.nextInt((max - min) + 1) + min;
                ripetizione=controllo(numeri,i);
            }
        }

    }
    //fa il controllo dei numeri
    public static boolean controllo(int[] numeri ,  int i){
        boolean ripetizione=true;
        for (int j=0; j<i;j++){
            if(numeri[j]==numeri[i]){
                return false;
            }
        }

    return true;
    }
    public static void visualizzazione(int[] numeri){
        for (int i=0;i<numeri.length;i++){
            System.out.println(numeri[i]);
        }
    }
}