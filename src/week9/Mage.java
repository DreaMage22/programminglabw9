
package week9;


public class Mage extends GameCharacter implements Attacker, Supporter {
    private int mana;

    public Mage(String name, int level, int maxHealth, int mana) {
        super(name, level, maxHealth);
        this.mana = mana;
    }

    @Override
    public int calculatePower() {
        return (getLevel() * 8) + mana;
    }

    @Override
    public String getCharacterInfo() {
        return "Mage: " + getName() + " | Lvl: " + getLevel() + " | HP: " + getHealth() + "/" + getMaxHealth() + " | Mana: " + mana;
    }

    @Override
    public int attack(GameCharacter target) {
        if (!this.isAlive() || !target.isAlive()) return 0;
        
        if (mana < 20) {
            System.out.println(getName() + " does not have enough mana to attack!");
            return 0;
        }
        
        int power = calculatePower(); 
        this.mana -= 20;
        int damageDealt = power / 3;
        return target.takeDamage(damageDealt);
    }

    @Override
    public int heal(GameCharacter target) {
        if (!this.isAlive() || !target.isAlive()) return 0;
        
        if (mana < 15) {
            System.out.println(getName() + " does not have enough mana to heal!");
            return 0;
        }
        
        this.mana -= 15;
        int healAmount = getLevel() * 2;
        return target.restoreHealth(healAmount);
    }
}
