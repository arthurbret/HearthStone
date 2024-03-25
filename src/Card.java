public class Card {
    protected String name;
    protected int attack;
    protected int defense;
    protected String ability;
    protected boolean isMonster;

    public Card(String name, int attack, int defense, String ability, boolean isMonster) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.ability = ability;
        this.isMonster = isMonster;
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

    public void takeDamage(int damage){
        this.defense -= damage;
        if (this.defense <= 0) {
            this.defense = 0;
        }
    }

    // You can add more methods here as needed
}
