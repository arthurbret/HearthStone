import Modele.*;
import Modele.Monstres.*;

public class Main {
    public static void main(String[] args) {
        // création des champions
        Champion champion1 = new Champion(1, "Champion1", 100, "Capacité spéciale 1");
        Champion champion2 = new Champion(2, "Champion2", 100, "Capacité spéciale 2");

        // création des monstres
        Monstre monstre1 = new Classique(1, "Monstre1", 50, 20);
        Monstre monstre2 = new Protecteur(2, "Monstre2", 60, 15);
        Monstre monstre3 = new Soigneur(3, "Monstre3", 40, 0);
        Monstre monstre4 = new Mascotte(4, "Monstre4", 30, 10);

        // création des cartes
        Carte carte1 = new Carte(1, "Pikachu", monstre1);
        Carte carte2 = new Carte(2, "Raichu", monstre2);
        Carte carte3 = new Carte(3, "Mewtwo", monstre3);
        Carte carte4 = new Carte(4, "Salamèche", monstre4);

        // affectation des cartes aux champions
        champion1.ajouterCarte(carte1);
        champion1.ajouterCarte(carte2);
        champion2.ajouterCarte(carte3);
        champion2.ajouterCarte(carte4);

        // création du jeu
        Jeu jeu = new Jeu(champion1, champion2);

        // commencement du jeu
        jeu.commencerPartie();
    }
}
