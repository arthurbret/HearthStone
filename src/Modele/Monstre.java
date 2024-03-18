package Modele;

public class Monstre {
    private int id;
    private String nom;
    private int pointsDeVie;
    private int forceAttaque;

    public Monstre(int id, String nom, int pointsDeVie, int forceAttaque) {
        this.id = id;
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.forceAttaque = forceAttaque;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public String getNom() {
        return nom;
    }

    public int getForceAttaque() {
        return forceAttaque;
    }

    // getters et setters
}