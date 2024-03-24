public class Card {
    private String name;
    private int attack;
    private int defense;
    private String ability;

    public Card(String name, int attack, int defense, String ability) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.ability = ability;
    }

    public String getName() {
        return this.name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public String getAbility() {
        return ability;
    }

    // You can add more methods here as needed
}
