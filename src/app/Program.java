package app;

import controller.Jatekkontroller;
import modell.Jatek;
import nezet.KonzolNezet;
import nezet.Nezet;

public class Program {

    public static void main(String[] args) {
        Jatek modell = new Jatek();
        Nezet nezet = new KonzolNezet(modell);
        Jatekkontroller kontroller = new Jatekkontroller(modell, nezet);

        kontroller.jatek();
    }

}
