package modell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jatek {
    public static final int ARANY = 0;
    public static final int EZUST = 1;
    public static final int BRONZ = 2;

    private ArrayList<Lada> ladak;
    private int kincsHelye;

    public Jatek() {
        ladak = new ArrayList<>();
        ladak.add(new Lada("arany", "Nálam van a kincs."));
        ladak.add(new Lada("ezüst", "Nincs nálam a kincs."));
        ladak.add(new Lada("bronz", "Az arany láda hazudik."));

        kincsHelye = kincsKeres();
    }

    public List<Lada> getLadak() {
        return Collections.unmodifiableList(ladak);
    }

    public int getKincsHelye() {
        return kincsHelye;
    }

    public boolean joTipp(int tipp) {
        return tipp == kincsHelye;
    }

    // igaz-e a láda állítása, ha a kincs a megadott helyen van
    private boolean allitasIgaz(int lada, int kincs) {
        if (lada == ARANY) {
            return kincs == ARANY;          // "Nálam van a kincs."
        }
        if (lada == EZUST) {
            return kincs != EZUST;          // "Nincs nálam a kincs."
        }
        return !allitasIgaz(ARANY, kincs);  // "Az arany láda hazudik."
    }

    // igaz-e a láda állítása a valódi kincshelyzet mellett
    public boolean allitasIgaz(int lada) {
        return allitasIgaz(lada, kincsHelye);
    }

    // azt a helyet keressük, ahol pontosan egy állítás igaz
    private int kincsKeres() {
        for (int hely = 0; hely < 3; hely++) {
            int igaz = 0;
            for (int lada = 0; lada < 3; lada++) {
                if (allitasIgaz(lada, hely)) {
                    igaz++;
                }
            }
            if (igaz == 1) {
                return hely;
            }
        }
        return -1;
    }
}
