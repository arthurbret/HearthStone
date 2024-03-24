import Modele.*;
import Modele.Monstres.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create players and deck
        Player player1 = new Player("Player 1", 30);
        Player player2 = new Player("Player 2", 30);
        Deck deckp1 = new Deck();
        deckp1.createDefaultDeck();
        Deck deckp2 = new Deck();
        deckp2.createDefaultDeck();

        // Shuffle the deck and deal cards to each player
        deckp1.shuffle();
        deckp2.shuffle();
        for (int i = 0; i < 5; i++) {
            player1.hiddenDrawCard(deckp1);
            player2.hiddenDrawCard(deckp2);
        }

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Continue playing turns until one player's health reaches zero
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            // Player 1's turn
            System.out.println("Player 1's turn:");
            player1.drawCard(deckp1);
            System.out.println("Health: " + player1.getHealth());
            System.out.print("Cards: ");//+ player1.getCards());
            for (Card card : player1.getCards()) {
                System.out.print(card.getName() + ", ");
            }
            System.out.print("\n");
            System.out.println("Choose a card to play (or type 'done' to end your turn):");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                int cardIndex = Integer.parseInt(input) - 1;
                Card chosenCard = player1.playCard(cardIndex);
                if (chosenCard != null) {
                    player2.takeDamage(chosenCard.getAttack());
                    System.out.println("Player 2 takes " + chosenCard.getAttack() + " damage!");
                }
            }

            // Player 2's turn
            System.out.println("Player 2's turn:");
            player2.drawCard(deckp2);
            System.out.println("Health: " + player2.getHealth());
            System.out.print("Cards: ");//+ player2.getCards());
            for (Card card : player2.getCards()) {
                System.out.print(card.getName() + ", ");
            }
            System.out.print("\n");
            System.out.println("Choose a card to play (or type 'done' to end your turn):");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                int cardIndex = Integer.parseInt(input) - 1;
                Card chosenCard = player2.playCard(cardIndex);
                if (chosenCard != null) {
                    player1.takeDamage(chosenCard.getAttack());
                    System.out.println("Player 1 takes " + chosenCard.getAttack() + " damage!");
                }
            }
        }

        // Determine the winner and print a message
        if (player1.getHealth() > 0) {
            System.out.println("Player 1 wins!");
        } else if (player2.getHealth() > 0) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    /*public static void main(String[] args) {
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
    }*/
}
