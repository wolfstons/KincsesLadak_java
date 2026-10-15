package controller;

import java.util.Scanner;
import modell.Jatek;
import nezet.Nezet;

public class Jatekkontroller {
    private Jatek modell;
    private Nezet nezet;

    public Jatekkontroller(Jatek modell, Nezet nezet) {
        this.modell = modell;
        this.nezet = nezet;
    }

    public void jatek() {
        Scanner sc = new Scanner(System.in);

        nezet.megjelenit();

        int tipp = -1;
        while (tipp == -1) {
            nezet.kerdez();
            tipp = ladaSzam(sc.nextLine());
            if (tipp == -1) {
                nezet.hibaUzenet();
            }
        }

        nezet.eredmeny(tipp);
    }

    // a beírt szövegből ládaszám: 0, 1, 2 (vagy -1, ha rossz a bevitel)
    private int ladaSzam(String szoveg) {
        szoveg = szoveg.trim().toLowerCase();
        if (szoveg.equals("ezust")) {
            szoveg = "ezüst";
        }
        for (int i = 0; i < modell.getLadak().size(); i++) {
            String nev = modell.getLadak().get(i).getNev();
            if (szoveg.equals(nev) || szoveg.equals(String.valueOf(i + 1))) {
                return i;
            }
        }
        return -1;
    }
}
