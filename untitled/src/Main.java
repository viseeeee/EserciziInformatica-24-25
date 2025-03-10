public class Rettangolo {
    private double base;
    private double altezza;

    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double calcolaArea() {
        return base * altezza;
    }

    public int compareTo(Rettangolo altro) {
        double areaQuesto = this.calcolaArea();
        double areaAltro = altro.calcolaArea();
        return Double.compare(areaQuesto, areaAltro);
    }
}

public class Quadrato {
    private double lato;

    public Quadrato(double lato) {
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }

    public double calcolaArea() {
        return lato * lato;
    }
}

public class TriangoloRettangolo {
    private double base;
    private double altezza;

    public TriangoloRettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double calcolaArea() {
        return (base * altezza) / 2;
    }
}

public class Circonferenza {
    private double raggio;

    public Circonferenza(double raggio) {
        this.raggio = raggio;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    public double calcolaArea() {
        return Math.PI * raggio * raggio;
    }
}

/* Versione light */

public class Main {
    public static void main(String[] args) {
        // Creazione di un rettangolo e calcolo area
        Rettangolo rettangolo = new Rettangolo(5, 10);
        System.out.println("Rettangolo - Base: " + rettangolo.getBase() + ", Altezza: " + rettangolo.getAltezza());
        System.out.println("Area del rettangolo: " + rettangolo.calcolaArea());

        // Creazione di un quadrato e calcolo area
        Quadrato quadrato = new Quadrato(4);
        System.out.println("\nQuadrato - Lato: " + quadrato.getLato());
        System.out.println("Area del quadrato: " + quadrato.calcolaArea());

        // Creazione di un triangolo rettangolo e calcolo area
        TriangoloRettangolo triangolo = new TriangoloRettangolo(6, 8);
        System.out.println("\nTriangolo Rettangolo - Base: " + triangolo.getBase() + ", Altezza: " + triangolo.getAltezza());
        System.out.println("Area del triangolo rettangolo: " + triangolo.calcolaArea());

        // Creazione di una circonferenza e calcolo area
        Circonferenza circonferenza = new Circonferenza(7);
        System.out.println("\nCirconferenza - Raggio: " + circonferenza.getRaggio());
        System.out.println("Area della circonferenza: " + circonferenza.calcolaArea());
    }
}

/*
Modifica il programma principale (main) in modo che:
1.	Chieda all'utente di inserire i dati da tastiera per creare un nuovo rettangolo, un quadrato e una circonferenza.
2.	Stampi i dati e le aree delle figure create.
Esempio di input richiesto:
•	Per il rettangolo: base e altezza.
•	Per il quadrato: lunghezza del lato.
•	Per la circonferenza: lunghezza del raggio.
Assicurati che il programma verifichi se i valori inseriti dall'utente siano positivi, e in caso contrario stampi un messaggio di errore.
*/

/*
MAIN ALTERNATIVO:
*/
public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(5, 8);
        Quadrato quadrato = new Quadrato(6);
        TriangoloRettangolo triangolo = new TriangoloRettangolo(3, 4);
        Circonferenza circonferenza = new Circonferenza(7);

        // Stampa delle descrizioni delle figure
        System.out.println(rettangolo.descrizione());
        System.out.println(quadrato.descrizione());
        System.out.println(triangolo.descrizione());
        System.out.println(circonferenza.descrizione());

        // Stampa delle aree delle figure
        System.out.println("\nAree delle figure:");
        System.out.println("Rettangolo: " + rettangolo.calcolaArea());
        System.out.println("Quadrato: " + quadrato.calcolaArea());
        System.out.println("Triangolo Rettangolo: " + triangolo.calcolaArea());
        System.out.println("Circonferenza: " + circonferenza.calcolaArea());
    }
}
/*
Modifica le classi Rettangolo, Quadrato, TriangoloRettangolo e Circonferenza per fare in modo che il programma compili correttamente ed esegua quanto segue:
1.	Aggiungi un metodo String descrizione() in ciascuna classe che restituisca una stringa con i dettagli della figura.
o	Esempio per un rettangolo: "Rettangolo con base 5.0 e altezza 8.0".
o	Esempio per un quadrato: "Quadrato con lato 6.0".
o	Fai in modo che il metodo restituisca descrizioni simili per le altre figure.
2.	Verifica che il metodo calcolaArea() sia presente in tutte le classi e che restituisca correttamente l'area.
Nota: Non modificare il codice del main. Adatta le classi al codice esistente.

*/



/* Just another creepy main */

public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(5, 8);
        Quadrato quadrato = new Quadrato(6);
        TriangoloRettangolo triangolo = new TriangoloRettangolo(3, 4);
        System.out.println(rettangolo.getInformazioni());
        System.out.println(quadrato.getInformazioni());
        System.out.println(triangolo.getInformazioni());
        if (rettangolo.compareTo(quadrato) > 0) {
            System.out.println("Il rettangolo ha un'area maggiore del quadrato.");
        } else {
            System.out.println("Il quadrato ha un'area maggiore o uguale a quella del rettangolo.");
        }
    }
}


/*
Che devi fare?
Correggi il main, se occorre:
Controlla bene il  metodo getInformazioni() e vedi come risolvere il problema dello stampare info.

Modifica alle classi:
Aggiungi un metodo getInformazioni() in ciascuna classe (Rettangolo, Quadrato, TriangoloRettangolo), che restituisca una descrizione dettagliata della figura
(simile a un metodo descrizione() ma con più dettagli, ad esempio il calcolo dell'area incluso nella stringa).
Sistema il metodo compareTo:

Fai in modo che tutte le figure abbiano un metodo compareTo(Figura altra) che consenta di confrontare le aree di due figure geometriche di tipo diverso.
Nota: Il confronto deve funzionare anche tra figure geometriche diverse, ad esempio tra un rettangolo e un quadrato. Spiega brevemente il ragionamento dietro le modifiche apportate prima di realizzare le modifiche.

*/