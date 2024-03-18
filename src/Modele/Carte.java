package Modele;

public class Carte {
    private int id;
    private String nom;
    private Monstre monstre;

    public Carte(int id, String nom, Monstre monstre) {
        this.id = id;
        this.nom = nom;
        this.monstre = monstre;
    }

    public String getNom() {
        return nom;
    }

    public Monstre getMonstre() {
        return monstre;
    }
    // getters et setters
}