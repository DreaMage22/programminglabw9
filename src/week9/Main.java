
package week9;


public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testing Invalid Inputs ---");
        Warrior invalidWarrior = new Warrior("FailKnight", 150, -50, 10);
        
        Team myTeam = new Team();
        
        Warrior arthur = new Warrior("Arthur", 10, 200, 20);
        Mage merlin = new Mage("Merlin", 12, 120, 100);
        Healer lucy = new Healer("Lucy", 8, 100, 30);
        
        myTeam.addCharacter(arthur);
        myTeam.addCharacter(merlin);
        myTeam.addCharacter(lucy);
        
        
        myTeam.addCharacter(new Warrior("Arthur", 5, 100, 5));
        
        myTeam.displayTeam();

        
        Warrior golem = new Warrior("Golem", 25, 500, 40);
        System.out.println("\nEnemy Appears! -> " + golem.getCharacterInfo() + "\n");

        
        System.out.println("<<< ROUND 1 >>>");
        myTeam.attackAll(golem);
        
        if (golem.isAlive()) {
            System.out.println("\n" + golem.getName() + " attacks back!");
            int dmg = golem.attack(arthur);
            System.out.println(golem.getName() + " dealt " + dmg + " damage to " + arthur.getName());
        }
        
        myTeam.healTeam();
        myTeam.displayTeam();
        
       
        System.out.println("<<< ROUND 2 >>>");
        myTeam.attackAll(golem);
        
        if (golem.isAlive()) {
            System.out.println("\n" + golem.getName() + " attacks back!");
            int dmg = golem.attack(merlin);
            System.out.println(golem.getName() + " dealt " + dmg + " damage to " + merlin.getName());
        }
        
        myTeam.healTeam();
        myTeam.displayTeam();
        
        System.out.println("--- Searching & Removing ---");
        GameCharacter found = myTeam.findByName("Merlin");
        if (found != null) {
            System.out.println("Found character: " + found.getCharacterInfo());
        }
        
        myTeam.removeCharacter("Lucy");
        myTeam.displayTeam();
    }
}