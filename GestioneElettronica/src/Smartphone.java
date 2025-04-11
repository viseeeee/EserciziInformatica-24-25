public class Smartphone extends ProdottoElettronico{
    String modello;
    int memoria;

    public Smartphone(String codiceProdotto, String marca, double prezzo,String modello,int memoria){
        super(codiceProdotto, marca, prezzo);
        this.modello = modello;
        this.memoria = memoria;
    }

    public Smartphone(Smartphone s){
        super(s);
        this.modello = s.modello;
        this.memoria = s.memoria;
    }

    @Override
    public String toString(){
        return String.format("Codice Prodotto:%s    Marca:%s    Prezzo:%.2f   Modello:%s  Memoria:%s",codiceProdotto,marca,prezzo,modello,memoria);
    }
}
