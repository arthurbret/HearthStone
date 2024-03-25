package tests;
import org.junit.Test;
import src.Card;
import src.Deck;
import src.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestsU {

    @Test
    public void defaultDeck() {
        Deck deck = new Deck();
        deck.createDefaultDeck();
        assertFalse(deck.isEmpty());
    }

    @Test
    public void summonTest() {
        Player player1 = new Player("Player 1", 30);
        Card monster = new Card("Ironfur Grizzly", 5, 6, "Taunt", true);
        player1.summon(monster);
        assertFalse(player1.getBoard().isEmpty());
    }

    @Test
    public void attackTest() {
        Player player1 = new Player("Player 1", 30);
        Player player2 = new Player("Player 2", 30);
        Card monster = new Card("Ironfur Grizzly", 5, 6, "Taunt", true);
        Card monster2 = new Card("Chillwind Yeti", 2, 4, "", true);

        player1.summon(monster);
        player2.summon(monster2);

        player2.getBoard().get(0).takeDamage(player2.getBoard().get(0).getAttack());
        assertEquals(0, monster2.getDefense());
        player2.destroyIfNoHP(0);
        assertTrue(player2.getBoard().isEmpty());
    }

    @Test
    public void koTest() {
        Player player1 = new Player("Player 1", 30);
        Player player2 = new Player("Player 2", 30);

        boolean player1win = false;
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            //player1 turn
            for (int i = 0; i < 2; i++) {
                player2.takeDamage(15);
                if (player1.getHealth() == 0 || player2.getHealth() == 0) {
                    break;
                }
            }
            //player2 turn
            for (int i = 0; i < 2; i++) {
                player2.takeDamage(10);
                if (player1.getHealth() == 0 || player2.getHealth() == 0) {
                    break;
                }
            }
        }

        if (player1.getHealth() > 0) {
            System.out.println("Player 1 wins!");
            player1win = true;
        } else if (player2.getHealth() > 0) {
            System.out.println("Player 2 wins!");
        }

        assertTrue(player1win);
    }

    @Test
    public void drawTest() {
        Player player1 = new Player("Player 1", 30);
        Deck deck = new Deck();
        deck.createDefaultDeck();

        player1.drawCard(deck);
        assertFalse(player1.getCards().isEmpty());
    }

}
