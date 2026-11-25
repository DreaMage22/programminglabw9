
package week9;

public abstract class GameCharacter {
    private String name;
    private int level;
    private int health;
    private int maxHealth;

    public GameCharacter(String name, int level, int maxHealth) {
        this.name = name;
        
        if (level < 1 || level > 100) {
            System.out.println("Warning: Invalid level for " + name + ". Setting to 1.");
            this.level = 1;
        } else {
            this.level = level;
        }

        if (maxHealth <= 0) {
            System.out.println("Warning: Invalid maxHealth for " + name + ". Setting to 100.");
            this.maxHealth = 100;
        } else {
            this.maxHealth = maxHealth;
        }

        this.health = this.maxHealth;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public int takeDamage(int damage) {
        if (damage < 0) damage = 0;
        int actualDamage = Math.min(this.health, damage);
        this.health -= actualDamage;
        return actualDamage;
    }

    public int restoreHealth(int amount) {
        if (!isAlive()) {
            return 0; 
        }
        if (amount < 0) amount = 0;
        
        int missingHealth = this.maxHealth - this.health;
        int actualRestore = Math.min(missingHealth, amount);
        this.health += actualRestore;
        return actualRestore;
    }

    public abstract String getCharacterInfo();
    public abstract int calculatePower();

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
}
