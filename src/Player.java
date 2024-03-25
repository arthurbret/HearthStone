import java.util.ArrayList;
import java.util.List;

public class Player implements Damageable{
    private String name;
    private int health;

    private List<Card> cards;

    private List<Card> board;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.cards = new ArrayList<>();
        this.board = new ArrayList<>();
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

    public List<Card> getBoard() {
        return board;
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

    public void summon(Card summonedMonster) {

        if (summonedMonster != null && summonedMonster.isMonster) {
            this.board.add(summonedMonster);
            System.out.println("Summoned Monster: " + summonedMonster.getName());
            LogWriter logWriter = new LogWriter();
            logWriter.writeLog("Summoned Monster: " + summonedMonster.getName());
        } else {
            System.out.println("You can't summon that !");
        }

    }

    public void printCrads(){
        if (this.getCards().isEmpty()) {
            System.out.print("[Hand is Empty]\n");
        }
        else {
            int index = 1;
            for (Card card : this.getCards()) {
                System.out.print("  " + index + ".[" + card.getName() + " DMG: " + card.getAttack());
                if(card.defense!=0){
                    System.out.print(" HP: " + card.getDefense() + "]\n");
                }
                else{
                    System.out.print("]\n");
                }
                index++;
            }
        }
    }

    public void printBoard(){
        if (this.getBoard().isEmpty()) {
            System.out.print("[Board is Empty]\n");
        }
        else {
            int index = 1;
            for (Card card : this.getBoard()) {
                System.out.print("  " + index + ".[" + card.getName() + " DMG: " + card.getAttack() + " HP: " + card.getDefense() + "]\n");
                index++;
            }
        }

    }

    public void hiddenDrawCard(Deck deck) {
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            this.cards.add(drawnCard);
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

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
        }
    }

    public void destroyIfNoHP(int index){
        if(this.board.get(index).defense==0){
            System.out.println(this.board.get(index).getName() + " Died !");
            this.board.remove(index);
        }
    }
}

