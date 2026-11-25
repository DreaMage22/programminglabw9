
package week9;


public class Warrior extends GameCharacter implements Attacker {
    private int armor;

    public Warrior(String name, int level, int maxHealth, int armor) {
        super(name, level, maxHealth);
        this.armor = armor;
    }

    @Override
    public int calculatePower() {
        return (getLevel() * 10) + (armor * 2);
    }

    @Override
    public String getCharacterInfo() {
        return "Warrior: " + getName() + " | Lvl: " + getLevel() + " | HP: " + getHealth() + "/" + getMaxHealth() + " | Armor: " + armor;
    }

    @Override
    public int takeDamage(int damage) {
        int reducedDamage = damage - (armor / 2);
        if (reducedDamage < 1) {
            reducedDamage = 1; 
        }
        return super.takeDamage(reducedDamage);
    }

    @Override
    public int attack(GameCharacter target) {
        if (!this.isAlive() || !target.isAlive()) return 0;
        int damageDealt = calculatePower() / 4;
        return target.takeDamage(damageDealt);
    }
}
