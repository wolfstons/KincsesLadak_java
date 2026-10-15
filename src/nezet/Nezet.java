package nezet;

import modell.Jatek;

public abstract class Nezet {
    protected Jatek modell;

    public Nezet(Jatek modell) {
        this.modell = modell;
    }

    // a ládák és a feladat megjelenítése
    public abstract void megjelenit();

    // kérdés a felhasználónak
    public abstract void kerdez();

    // rossz bevitel esetén
    public abstract void hibaUzenet();

    // a játék vége
    public abstract void eredmeny(int tipp);

    // közös: kiír egy szöveget a konzolra
    public void megjelenit(String adat) {
        System.out.println(adat);
    }
}
