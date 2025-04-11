package Auto;

import java.time.LocalDateTime;

public abstract class Auto {
    protected String ID;
    protected String marca;
    protected String modello;
    protected double prezzo;
    protected int anno;


    public Auto(String _id, String _marca, String _modello, double _prezzo, int _anno) {
        this.ID=_id;
        this.marca=_marca;
        this.modello=_modello;
        this.prezzo=_prezzo;
        this.anno=_anno;
    }

    public Auto(Auto a) {
        this.ID=a.ID;
        this.marca=a.marca;
        this.modello=a.modello;
        this.prezzo=a.prezzo;
        this.anno=a.anno;
    }

    public String getID() {
        return ID;
    }

    public String getMarca() {
        return marca;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }



    public abstract String mostraDettagli();




}
