package Modele;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private static List<Monstre> monstres;

    public Plateau() {
        monstres = new ArrayList<>();
    }

    public void invoquerMonstre(Monstre monstre) {
        monstres.add(monstre);
    }

    public void retirerMonstre(Monstre monstre) {
        monstres.remove(monstre);
    }

    public static List<Monstre> getMonstres() {
        return monstres;
    }
}
