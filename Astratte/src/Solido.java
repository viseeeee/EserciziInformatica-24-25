public abstract class Solido extends GestoreSolidi{
    protected String nome;

    public Solido(String nome){
        this.nome = nome;
    }

    /* con i metodi astratti occorre
    * definire la firma */
    public abstract double calcolaVolume();
    public abstract double calcolaSuperficie();

    @Override
    public String toString(){
        return String.format("%s\tVolume: %.2fcm3\tSuperficie: %.2fcm2", this.nome, calcolaVolume(), calcolaSuperficie());
    }
}
