package Modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Champion {
    private int id;
    private String nom;
    private int pointsDeVie;
    private String capaciteSpecial;
    private List<Carte> cartes;

    public Champion(int id, String nom, int pointsDeVie, String capaciteSpecial) {
        this.id = id;
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.capaciteSpecial = capaciteSpecial;
        this.cartes = new ArrayList<>();
    }

    public void ajouterCarte(Carte carte) {
        this.cartes.add(carte);
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public String getCapaciteSpecial() {
        return capaciteSpecial;
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public Collection<Object> getCartesJouees() {
        return null;
    }

    // autres méthodes
}
