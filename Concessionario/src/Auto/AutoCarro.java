package Auto;

import java.time.LocalDateTime;

public class AutoCarro extends Auto {
    private double tara;

    public AutoCarro(String _id, String _marca, String _modello, double _prezzo, int _anno, double _tara) {
        super(_id, _marca, _modello, _prezzo,_anno);
        this.tara = _tara;
    }

    public AutoCarro(AutoCarro auto) {
        super(auto);
        this.tara =auto.tara;
    }

    @Override
    public String mostraDettagli() {
        return String.format("ID:%s Marca:%s   Modello:%s  Prezzo:%.2f   Anno:%d    Tara:%s",ID,marca,modello,prezzo,anno,tara);
    }

}
