package nezet;

import modell.Jatek;
import modell.Lada;

public class KonzolNezet extends Nezet {

    public KonzolNezet(Jatek modell) {
        super(modell);
    }

    @Override
    public void megjelenit() {
        megjelenit("=== KINCSES LÁDÁK ===");
        megjelenit("Az egyik ládában kincs van. Csak az egyik felirat igaz!");
        megjelenit("");
        int sorszam = 1;
        for (Lada lada : modell.getLadak()) {
            megjelenit(sorszam + ". " + lada.getNev() + " láda: \"" + lada.getAllitas() + "\"");
            sorszam++;
        }
        megjelenit("");
    }

    @Override
    public void kerdez() {
        System.out.print("Hol van a kincs? (arany / ezüst / bronz): ");
    }

    @Override
    public void hibaUzenet() {
        megjelenit("Ilyen láda nincs, próbáld újra!");
    }

    @Override
    public void eredmeny(int tipp) {
        megjelenit("");
        if (modell.joTipp(tipp)) {
            megjelenit("Gratulálok, megtaláltad a kincset!");
        } else {
            String hely = modell.getLadak().get(modell.getKincsHelye()).getNev();
            megjelenit("Sajnos nem ott van. A kincs az " + hely + " ládában volt.");
        }

        megjelenit("");
        megjelenit("A feliratok:");
        for (int i = 0; i < modell.getLadak().size(); i++) {
            Lada lada = modell.getLadak().get(i);
            String igaz = modell.allitasIgaz(i) ? "igaz" : "hamis";
            megjelenit(lada.getNev() + ": " + igaz);
        }
    }
}
