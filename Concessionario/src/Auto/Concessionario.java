package Auto;

import java.util.ArrayList;

public class Concessionario {
    ArrayList<Auto> auto = new ArrayList<Auto>();

    public void setAuto(Auto _auto) {
        auto.add(_auto);
    }

    public void confrontoID(String id) throws Exception{
        for (Auto a : auto) {
            if (a.getID().equals(id))
                throw new Exception("L'id che hai messo è già stato inserito");
        }
    }

    public int returnIndexID(String id) throws Exception{
        int i = 0;
        for (Auto a : auto) {
            i++;
            if (a.getID().equals(id)){
                return i;
            }
        }
        throw new Exception("ID non trovato");
    }

    public void IDControl(String id) throws Exception{
        for (Auto a : auto) {
            if (a.getID().equals(id)){
                return;
            }
        }
        throw new Exception("ID non trovato");
    }


    public ArrayList<Auto> ricerca(String marca) throws Exception{
        ArrayList<Auto> ricerca =new ArrayList<Auto>();
        int i=0;
        for (Auto a : auto) {
            if (a.getMarca().equals(marca)){
                i++;
                 ricerca.add(a);
            }
        }
        if (i==0)
            throw new Exception("ID non trovato");
        return ricerca;
    }

    public void remove(int numero)throws Exception{
        auto.remove(numero-1);
    }
    public ArrayList<Auto> getAuto() {
        return auto;
    }
}
