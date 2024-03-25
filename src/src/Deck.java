package src;

import src.Card;
import src.Spell;

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
        this.cards.add(new Spell("Fireball", 6, "Deal 6 damage to a target"));
        this.cards.add(new Spell("Frostbolt", 4, "Deal 3 damage to a target and freeze it"));
        this.cards.add(new Spell("Arcane Missiles", 2, "Deal 3 damage randomly split between all enemies"));
        this.cards.add(new Spell("Fireball", 6, "Deal 6 damage to a target"));
        this.cards.add(new Spell("Frostbolt", 4, "Deal 3 damage to a target and freeze it"));
        this.cards.add(new Spell("Arcane Missiles", 2, "Deal 3 damage randomly split between all enemies"));
        this.cards.add(new Spell("Fireball", 6, "Deal 6 damage to a target"));
        this.cards.add(new Spell("Frostbolt", 4, "Deal 3 damage to a target and freeze it"));
        this.cards.add(new Spell("Arcane Missiles", 2, "Deal 3 damage randomly split between all enemies"));
        this.cards.add(new Spell("Fireball", 6, "Deal 6 damage to a target"));
        this.cards.add(new Spell("Frostbolt", 4, "Deal 3 damage to a target and freeze it"));
        this.cards.add(new Spell("Arcane Missiles", 2, "Deal 3 damage randomly split between all enemies"));
        this.cards.add(new Spell("Fireball", 6, "Deal 6 damage to a target"));
        this.cards.add(new Spell("Frostbolt", 4, "Deal 3 damage to a target and freeze it"));
        this.cards.add(new Spell("Arcane Missiles", 2, "Deal 3 damage randomly split between all enemies"));
        this.cards.add(new Card("Wolfrider", 3, 2, "Charge", true));
        this.cards.add(new Card("Chillwind Yeti", 2, 4, "", true));
        this.cards.add(new Card("Ironfur Grizzly", 5, 6, "Taunt", true));
        this.cards.add(new Card("Wolfrider", 3, 2, "Charge", true));
        this.cards.add(new Card("Chillwind Yeti", 2, 4, "", true));
        this.cards.add(new Card("Ironfur Grizzly", 5, 6, "Taunt", true));
        this.cards.add(new Card("Wolfrider", 3, 2, "Charge", true));
        this.cards.add(new Card("Chillwind Yeti", 2, 4, "", true));
        this.cards.add(new Card("Ironfur Grizzly", 5, 6, "Taunt", true));
        this.cards.add(new Card("Wolfrider", 3, 2, "Charge", true));
        this.cards.add(new Card("Chillwind Yeti", 2, 4, "", true));
        this.cards.add(new Card("Ironfur Grizzly", 5, 6, "Taunt", true));
        // Add more cards as needed
    }
}
