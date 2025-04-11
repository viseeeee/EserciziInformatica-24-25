package Auto;

import java.time.LocalDateTime;

public class AutoNuova extends Auto {
    private Alimentazione alimentazione;
    private int cavalli;

    public AutoNuova(String _id, String _marca, String _modello, double _prezzo, int _anno,Alimentazione _alimentazione, int _cavalli) {
        super(_id, _marca, _modello, _prezzo,_anno);
        this.cavalli = _cavalli;
        this.alimentazione = _alimentazione;
    }

    public AutoNuova(AutoNuova auto) {
        super(auto);
        this.cavalli =auto.cavalli;
        this.alimentazione = auto.alimentazione;
    }
    @Override
    public String mostraDettagli() {
        return String.format("ID:%s Marca:%s   Modello:%s  Prezzo:%.2f   anno:%d    Alimentazione:%s     Cavalli:%d",ID,marca,modello,prezzo,anno,alimentazione,cavalli);
    }
}
