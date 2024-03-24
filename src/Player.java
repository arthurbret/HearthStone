import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;

    private List<Card> cards;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card getCard(int index) {
        if (index >= 0 && index < this.cards.size()) {
            return this.cards.get(index);
        } else {
            return null;
        }
    }


    public void drawCard(Deck deck) {
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            cards.add(drawnCard);
            System.out.println("Drew card: " + drawnCard.getName());
        } else {
            System.out.println("Deck is empty!");
        }
    }

    public void hiddenDrawCard(Deck deck) {
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            cards.add(drawnCard);
        } else {
            System.out.println("Deck is empty!");
        }
    }

    public Card playCard(int index) {
        if (index >= 0 && index < this.cards.size()) {
            Card card = this.cards.get(index);
            this.cards.remove(index);
            return card;
        } else {
            return null;
        }
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
        }
    }
}

