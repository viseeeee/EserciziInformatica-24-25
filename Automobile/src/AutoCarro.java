// Classe derivata AutoCarro
public class AutoCarro extends Auto {
    private double tara; // in quintali

    public AutoCarro(int id, String marca, String modello, double prezzo, int annoImmatricolazione, double tara) {
        super(id, marca, modello, prezzo, annoImmatricolazione);
        this.tara = tara;
    }

    @Override
    public void mostraDettagli() {
        System.out.println("AUTO CARRO:");
        System.out.println("Marca: " + marca + ", Modello: " + modello);
        System.out.println("Tara: " + tara + " quintali");
        System.out.println("Anno: " + annoImmatricolazione + ", Prezzo: " + prezzo);
        System.out.printf("Valore attuale: %.2f€%n", calcolaValoreAttuale());
    }

}