import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Concessionario {
    private List<Auto> autoList = new ArrayList<>();

    // CREATE
    public void aggiungiAuto(Auto auto) {
        autoList.add(auto);
    }

    // READ
    public void mostraTutte() {
        for (Auto auto : autoList) {
            auto.mostraDettagli();
            System.out.println("--------------------");
        }
    }

    // UPDATE
    public void aggiornaPrezzo(int id, double nuovoPrezzo) {
        for (Auto auto : autoList) {
            if (auto.getId() == id) {
                auto.prezzo = nuovoPrezzo;
                break;
            }
        }
    }

    // DELETE
    public void rimuoviAuto(int id) {
        Iterator<Auto> it = autoList.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                break;
            }
        }
    }

    // RICERCA per marca
    public void ricercaPerMarca(String marca) {
        for (Auto auto : autoList) {
            if (auto.getMarca().equalsIgnoreCase(marca)) {
                auto.mostraDettagli();
                System.out.println("--------------------");
            }
        }
    }

    // Visualizza auto immatricolate da un certo anno in poi
    public void visualizzaDaAnno(int anno) {
        for (Auto auto : autoList) {
            if (auto.getAnnoImmatricolazione() >= anno) {
                auto.mostraDettagli();
                System.out.println("--------------------");
            }
        }
    }
}
