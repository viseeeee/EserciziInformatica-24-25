// Classe base Auto
public abstract class Auto {
    protected int id;
    protected String marca;
    protected String modello;
    protected double prezzo;
    protected int annoImmatricolazione;

    public Auto(int id, String marca, String modello, double prezzo, int annoImmatricolazione) {
        this.id = id;
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.annoImmatricolazione = annoImmatricolazione;
    }

    public double calcolaValoreAttuale() {
        int anniPassati = 2025 - annoImmatricolazione;
        return prezzo * Math.pow(0.95, anniPassati); // svalutazione del 5% annuo
    }

    public abstract void mostraDettagli();

    public int getId() { return id; }
    public String getMarca() { return marca; }
    public int getAnnoImmatricolazione() { return annoImmatricolazione; }

}
