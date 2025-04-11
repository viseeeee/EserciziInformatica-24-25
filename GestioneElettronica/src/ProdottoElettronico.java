public abstract class ProdottoElettronico {
    protected String codiceProdotto;
    protected String marca;
    protected double prezzo;

    public ProdottoElettronico(String codiceProdotto, String marca, double prezzo) {
        this.codiceProdotto = codiceProdotto;
        this.marca = marca;
        this.prezzo = prezzo;
    }

    public ProdottoElettronico(ProdottoElettronico prodotto) {
        this.codiceProdotto = prodotto.codiceProdotto;
        this.marca = prodotto.marca;
        this.prezzo = prodotto.prezzo;
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
