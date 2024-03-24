/*package Modele;

import java.util.Scanner;

public class Jeu {
    private Champion champion1;
    private Champion champion2;
    private Scanner scanner;

    public Jeu(Champion champion1, Champion champion2) {
        this.champion1 = champion1;
        this.champion2 = champion2;
        this.scanner = new Scanner(System.in);
    }

    public void commencerPartie() {
        System.out.println("Bienvenue dans le jeu !");
        while (!estPartieTerminee()) {
            jouerTour(champion1);
            jouerTour(champion2);
        }
        System.out.println("La partie est terminée !");
    }

    private boolean estPartieTerminee() {
        return champion1.getPointsDeVie() <= 0 || champion2.getPointsDeVie() <= 0;
    }

    private void jouerTour(Champion champion) {
        System.out.println("C'est le tour de " + champion.getNom());
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1. Jouer une carte");
        System.out.println("2. Utiliser la capacité spéciale");
        System.out.println("3. Attaquer");
        System.out.print("Entrez le numéro de l'action : ");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                jouerCarte(champion);
                break;
            case 2:
                utiliserCapaciteSpecial(champion);
                break;
            case 3:
                attaquer(champion);
                break;
            default:
                System.out.println("Action invalide.");
        }
    }

    private void jouerCarte(Champion champion) {
        System.out.println("Voici vos cartes :");
        for (int i = 0; i < champion.getCartes().size(); i++) {
            Carte carte = champion.getCartes().get(i);
            System.out.println((i + 1) + ". " + carte.getNom() + " (" + carte.getMonstre().getPointsDeVie() + " PV, " + carte.getMonstre().getForceAttaque() + " ATK)");
        }
        System.out.print("Entrez le numéro de la carte que vous voulez jouer : ");
        int numCarte = scanner.nextInt() - 1;
        if (numCarte >= 0 && numCarte < champion.getCartes().size()) {
            Carte carte = champion.getCartes().get(numCarte);
            // code pour jouer la carte
            System.out.println("Vous avez joué la carte " + carte.getNom());
            // code pour invoquer le monstre de la carte sur le plateau
            System.out.println("Le monstre " + carte.getMonstre().getNom() + " a été invoqué sur le plateau !");
            // code pour retirer la carte de la main du champion
            champion.getCartes().remove(numCarte);
        } else {
            System.out.println("Numéro de carte invalide.");
        }
    }

    private void utiliserCapaciteSpecial(Champion champion) {
        System.out.println("Capacité spéciale de " + champion.getNom() + " : " + champion.getCapaciteSpecial());
        System.out.print("Voulez-vous utiliser la capacité spéciale de " + champion.getNom() + " ? (o/n) ");
        String reponse = scanner.next();
        if (reponse.equalsIgnoreCase("o")) {
            // code pour utiliser la capacité spéciale du champion
            System.out.println("La capacité spéciale de " + champion.getNom() + " a été utilisée !");
        } else {
            System.out.println("La capacité spéciale de " + champion.getNom() + " n'a pas été utilisée.");
        }
    }

    private void attaquer(Champion champion) {
        System.out.println("Voici les monstres sur le plateau :");
        for (int i = 0; i < Plateau.getMonstres().size(); i++) {
            Monstre monstre = Plateau.getMonstres().get(i);
            System.out.println((i + 1) + ". " + monstre.getNom() + " (" + monstre.getPointsDeVie() + " PV, " + monstre.getForceAttaque() + " ATK)");
        }
        System.out.print("Entrez le numéro du monstre que vous voulez attaquer : ");
        int numMonstre = scanner.nextInt() - 1;
        if (numMonstre >= 0 && numMonstre < Plateau.getMonstres().size()) {
            Monstre monstreAttaque = Plateau.getMonstres().get(numMonstre);
            System.out.println("Quel monstre ou champion voulez-vous utiliser pour attaquer ?");
            for (int i = 0; i < champion.getCartesJouees().size(); i++) {
                Carte carte = champion.getCartesJouees().get(i);
                System.out.println((i + 1) + ". " + carte.getMonstre().getNom() + " (" + carte.getMonstre().getPointsDeVie() + " PV, " + carte.getMonstre().getForceAttaque() + " ATK)");
            }
            System.out.println((champion.getCartesJouees().size() + 1) + ". " + champion.getNom() + " (" + champion.getPointsDeVie() + " PV)");
            System.out.print("Entrez le numéro du monstre ou du champion que vous voulez utiliser : ");
            int numAttaquant = scanner.nextInt() - 1;
            Monstre monstreAttaquant;
            if (numAttaquant >= 0 && numAttaquant < champion.getCartesJouees().size()) {
                Carte carte = champion.getCartesJouees().get(numAttaquant);
                monstreAttaquant = carte.getMonstre();
            } else if (numAttaquant == champion.getCartesJouees().size()) {
                monstreAttaquant = champion;
            } else {
                System.out.println("Numéro d'attaquant invalide.");
                return;
            }
            // code pour attaquer le monstre ou le champion cible
            System.out.println(monstreAttaquant.getNom() + " attaque " + monstreAttaque.getNom() + " !");
            monstreAttaque.subirDegats(monstreAttaquant.getForceAttaque());
            if (monstreAttaque.getPointsDeVie() <= 0) {
                System.out.println(monstreAttaque.getNom() + " a été détruit !");
                Plateau.retirerMonstre(monstreAttaque);
            } else {
                System.out.println(monstreAttaque.getNom() + " a " + monstreAttaque.getPointsDeVie() + " points de vie restants.");
            }
        } else {
            System.out.println("Numéro de monstre invalide.");
        }
    }

}*/
