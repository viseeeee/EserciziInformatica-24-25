// Classe derivata AutoNuova
public class AutoNuova extends Auto {
    private String alimentazione;
    private int cavalli;

    public AutoNuova(int id, String marca, String modello, double prezzo, int annoImmatricolazione, String alimentazione, int cavalli) {
        super(id, marca, modello, prezzo, annoImmatricolazione);
        this.alimentazione = alimentazione;
        this.cavalli = cavalli;
    }

    @Override
    public void mostraDettagli() {
        System.out.println("AUTO NUOVA:");
        System.out.println("Marca: " + marca + ", Modello: " + modello);
        System.out.println("Alimentazione: " + alimentazione + ", Cavalli: " + cavalli);
        System.out.println("Anno: " + annoImmatricolazione + ", Prezzo: " + prezzo);
        System.out.printf("Valore attuale: %.2f€%n", calcolaValoreAttuale());
    }

}