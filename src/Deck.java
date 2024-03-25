import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public Card drawCard() {
        if (!this.cards.isEmpty()) {
            Card temp = this.cards.get(0);
            this.cards.remove(0);
            return temp;
        } else {
            return null;
        }
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void createDefaultDeck() {
        // Add predefined set of cards to the deck
        this.cards.add(new Card("Fireball", 6, 0, "Deal 6 damage to a target",false));
        this.cards.add(new Card("Frostbolt", 3, 0, "Deal 3 damage to a target and freeze it",false));
        this.cards.add(new Card("Arcane Missiles", 3, 0, "Deal 3 damage randomly split between all enemies",false));
        this.cards.add(new Card("Fireball", 6, 0, "Deal 6 damage to a target",false));
        this.cards.add(new Card("Frostbolt", 3, 0, "Deal 3 damage to a target and freeze it",false));
        this.cards.add(new Card("Arcane Missiles", 3, 0, "Deal 3 damage randomly split between all enemies",false));
        this.cards.add(new Card("Fireball", 6, 0, "Deal 6 damage to a target",false));
        this.cards.add(new Card("Frostbolt", 3, 0, "Deal 3 damage to a target and freeze it",false));
        this.cards.add(new Card("Arcane Missiles", 3, 0, "Deal 3 damage randomly split between all enemies",false));
        this.cards.add(new Card("Fireball", 6, 0, "Deal 6 damage to a target",false));
        this.cards.add(new Card("Frostbolt", 3, 0, "Deal 3 damage to a target and freeze it",false));
        this.cards.add(new Card("Arcane Missiles", 3, 0, "Deal 3 damage randomly split between all enemies",false));
        this.cards.add(new Card("Wolfrider", 3, 3, "Charge", true));
        this.cards.add(new Card("Chillwind Yeti", 4, 5, "", true));
        this.cards.add(new Card("Ironfur Grizzly", 3, 3, "Taunt", true));
        this.cards.add(new Card("Wolfrider", 3, 3, "Charge", true));
        this.cards.add(new Card("Chillwind Yeti", 4, 5, "", true));
        this.cards.add(new Card("Ironfur Grizzly", 3, 3, "Taunt", true));
        this.cards.add(new Card("Wolfrider", 3, 3, "Charge", true));
        this.cards.add(new Card("Chillwind Yeti", 4, 5, "", true));
        this.cards.add(new Card("Ironfur Grizzly", 3, 3, "Taunt", true));
        // Add more cards as needed
    }

    public void saveToFile(String filename) {
        // Implement logic to save the deck to a file with the given filename
    }

    public void loadFromFile(String filename) {
        // Implement logic to load the deck from a file with the given filename
    }
}
