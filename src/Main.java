

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to BAGARRESTONE\n\n Game Presented by Arthur Bret and Franck Ramaherison\n\n\n");
        try (FileWriter fw = new FileWriter("log.txt")) {
            fw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create players and deck
        Player player1 = new Player("Player 1", 30);
        Player player2 = new Player("Player 2", 30);
        Deck deckp1 = new Deck();
        deckp1.createDefaultDeck();
        Deck deckp2 = new Deck();
        deckp2.createDefaultDeck();

        String input;
        int idAttacker;
        int idDefender;

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
            System.out.println("\n\n\nPlayer 1's turn:");
            player1.drawCard(deckp1);
            System.out.println("Health: " + player1.getHealth());
            System.out.print("Your Hand: \n");//+ player1.getCards());
            player1.printCrads();
            System.out.print("Your Board: \n");
            player1.printBoard();
            System.out.print("Enemy's Board: \n");
            player2.printBoard();
            for (int i = 0; i < 2; i++) {
                System.out.println("Remaining Actions: " + (2 - i) + "\nChoose an action (or type 'done' to pass your action):\n 1. Play a card\n 2. Attack a monster\n 3. Attack Enemy player");
                input = scanner.nextLine();
                if (!input.equalsIgnoreCase("done")) {
                    if (Integer.parseInt(input) == 1) {
                        System.out.print("Your Hand: \n");//+ player1.getCards());
                        player1.printCrads();
                        System.out.println("Choose a card to play (or type 'done' to pass your action):");
                        input = scanner.nextLine();
                        if (!input.equalsIgnoreCase("done")) {
                            int cardIndex = Integer.parseInt(input) - 1;
                            Card chosenCard = player1.playCard(cardIndex);
                            if (!chosenCard.isMonster) {
                                System.out.println("Choose a target:\n 1.Player\n 2.Monster");
                                input = scanner.nextLine();
                                if (Integer.parseInt(input) == 1) {
                                    player2.takeDamage(chosenCard.getAttack());
                                    System.out.println("Player 2 takes " + chosenCard.getAttack() + " damage!");
                                    LogWriter logWriter = new LogWriter();
                                    logWriter.writeLog("Player 2 takes " + chosenCard.getAttack() + " damage!");

                                }
                                if (Integer.parseInt(input) == 2) {
                                    System.out.print("Enemy's Board: \n");
                                    player2.printBoard();
                                    System.out.println("Choose a monster to target:");
                                    input = scanner.nextLine();
                                    idDefender = Integer.parseInt(input) - 1;
                                    Card defender = player2.getBoard().get(idDefender);
                                    defender.takeDamage(chosenCard.getAttack());
                                    player2.destroyIfNoHP(idDefender);
                                }
                            }
                            if (chosenCard.isMonster) {
                                player1.summon(chosenCard);
                                System.out.print("Your Board: \n");
                                player1.printBoard();
                                System.out.print("Enemy's Board: \n");
                                player2.printBoard();
                            }
                        }
                        input = "0";
                    }
                    if (Integer.parseInt(input) == 2) {
                        if (player2.getBoard().isEmpty()) {
                            System.out.println("You can't attack an empty board !");
                            i--;
                        } else if (player1.getBoard().isEmpty()) {
                            System.out.println("You can't attack with an empty board !");
                            i--;
                        }

                         else {
                            System.out.print("Your Board: \n");
                            player1.printBoard();
                            System.out.println("Choose a monster to attack with:");
                            input = scanner.nextLine();
                            idAttacker = Integer.parseInt(input) - 1;
                            Card attacker = player1.getBoard().get(idAttacker);
                            System.out.print("Enemy's Board: \n");
                            player2.printBoard();
                            System.out.println("Choose a monster to attack:");
                            input = scanner.nextLine();
                            idDefender = Integer.parseInt(input) - 1;
                            Card defender = player2.getBoard().get(idDefender);

                            defender.takeDamage(attacker.getAttack());
                            attacker.takeDamage(defender.getAttack());
                            player1.destroyIfNoHP(idAttacker);
                            player2.destroyIfNoHP(idDefender);

                            System.out.print("Your Board: \n");
                            player1.printBoard();
                            System.out.print("Enemy's Board: \n");
                            player2.printBoard();
                        }
                         input = "0";
                    }
                }

                if (Integer.parseInt(input) == 3) {
                    if (player1.getBoard().isEmpty()) {
                        System.out.println("You can't attack with an empty board !");
                        i--;
                    } else {
                        System.out.print("Your Board: \n");
                        player1.printBoard();
                        System.out.println("Choose a monster to attack with:");
                        input = scanner.nextLine();
                        idAttacker = Integer.parseInt(input) - 1;
                        Card attacker = player1.getBoard().get(idAttacker);
                        player2.takeDamage(attacker.getAttack());
                        System.out.println("Player 2 takes " + attacker.getAttack() + " damage!");
                        LogWriter logWriter = new LogWriter();
                        logWriter.writeLog("Player 2 takes " + attacker.getAttack() + " damage!");
                    }
                }
            }


            // Player 2's turn
            System.out.println("\n\n\nPlayer 2's turn:");
            player2.drawCard(deckp2);
            System.out.println("Health: " + player2.getHealth());
            System.out.print("Your Hand: \n");//+ player2.getCards());
            player2.printCrads();
            System.out.print("Your Board: \n");
            player2.printBoard();
            System.out.print("Enemy's Board: \n");
            player1.printBoard();


            for (int i = 0; i < 2; i++) {
                System.out.println("Remaining Actions: " + (2 - i) + "\nChoose an action (or type 'done' to pass your action):\n 1. Play a card\n 2. Attack a monster\n 3. Attack Enemy player");
                input = scanner.nextLine();
                if (!input.equalsIgnoreCase("done")) {
                    if (Integer.parseInt(input) == 1) {
                        System.out.print("Your Hand: \n");//+ player1.getCards());
                        player2.printCrads();
                        System.out.println("Choose a card to play (or type 'done' to pass your action):");
                        input = scanner.nextLine();
                        if (!input.equalsIgnoreCase("done")) {
                            int cardIndex = Integer.parseInt(input) - 1;
                            Card chosenCard = player2.playCard(cardIndex);
                            if (!chosenCard.isMonster) {
                                System.out.println("Choose a target:\n 1.Player\n 2.Monster");
                                input = scanner.nextLine();
                                if (Integer.parseInt(input) == 1) {
                                    player1.takeDamage(chosenCard.getAttack());
                                    System.out.println("Player 1 takes " + chosenCard.getAttack() + " damage!");
                                    LogWriter logWriter = new LogWriter();
                                    logWriter.writeLog("Player 1 takes " + chosenCard.getAttack() + " damage!");
                                }
                                if (Integer.parseInt(input) == 2) {
                                    System.out.print("Enemy's Board: \n");
                                    player1.printBoard();
                                    System.out.println("Choose a monster to target:");
                                    input = scanner.nextLine();
                                    idDefender = Integer.parseInt(input) - 1;
                                    Card defender = player1.getBoard().get(idDefender);
                                    defender.takeDamage(chosenCard.getAttack());
                                    player1.destroyIfNoHP(idDefender);
                                }
                            }
                            if (chosenCard.isMonster) {
                                player2.summon(chosenCard);
                                System.out.print("Your Board: \n");
                                player2.printBoard();
                                System.out.print("Enemy's Board: \n");
                                player1.printBoard();
                            }
                        }
                        input = "0";
                    }
                    if (Integer.parseInt(input) == 2) {
                        if (player1.getBoard().isEmpty()) {
                            System.out.println("You can't attack an empty board !");
                            i--;
                        } else if (player1.getBoard().isEmpty()) {
                            System.out.println("You can't attack with an empty board !");
                            i--;
                        } else {
                            System.out.print("Your Board: \n");
                            player2.printBoard();
                            System.out.println("Choose a monster to attack with:");
                            input = scanner.nextLine();
                            idAttacker = Integer.parseInt(input) - 1;
                            Card attacker = player2.getBoard().get(idAttacker);
                            System.out.print("Enemy's Board: \n");
                            player1.printBoard();
                            System.out.println("Choose a monster to attack:");
                            input = scanner.nextLine();
                            idDefender = Integer.parseInt(input) - 1;
                            Card defender = player1.getBoard().get(idDefender);

                            defender.takeDamage(attacker.getAttack());
                            attacker.takeDamage(defender.getAttack());
                            player2.destroyIfNoHP(idAttacker);
                            player1.destroyIfNoHP(idDefender);

                            System.out.print("Your Board: \n");
                            player2.printBoard();
                            System.out.print("Enemy's Board: \n");
                            player1.printBoard();
                        }
                        input = "0";
                    }
                    if (Integer.parseInt(input) == 3) {
                        if (player1.getBoard().isEmpty()) {
                            System.out.println("You can't attack with an empty board !");
                            i--;
                        } else {
                            System.out.print("Your Board: \n");
                            player2.printBoard();
                            System.out.println("Choose a monster to attack with:");
                            input = scanner.nextLine();
                            idAttacker = Integer.parseInt(input) - 1;
                            Card attacker = player2.getBoard().get(idAttacker);
                            player1.takeDamage(attacker.getAttack());
                            System.out.println("Player 1 takes " + attacker.getAttack() + " damage!");
                            LogWriter logWriter = new LogWriter();
                            logWriter.writeLog("Player 1 takes " + attacker.getAttack() + " damage!");
                        }
                    }
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
}
