
package week9;


import java.util.ArrayList;

public class Team {
    private ArrayList<GameCharacter> members;

    public Team() {
        this.members = new ArrayList<>();
    }

    public void addCharacter(GameCharacter character) {
        for (GameCharacter member : members) {
            if (member.getName().equals(character.getName())) {
                System.out.println("Character with the name " + character.getName() + " is already in the team!");
                return;
            }
        }
        members.add(character);
        System.out.println(character.getName() + " added to the team.");
    }

    public void removeCharacter(String name) {
        GameCharacter toRemove = findByName(name);
        if (toRemove != null) {
            members.remove(toRemove);
            System.out.println(name + " has been removed from the team.");
        } else {
            System.out.println("Character " + name + " not found in the team.");
        }
    }

    public GameCharacter findByName(String name) {
        for (GameCharacter member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public void attackAll(GameCharacter target) {
        System.out.println("--- Team attacks " + target.getName() + " ---");
        for (GameCharacter member : members) {
            if (member.isAlive() && member instanceof Attacker) {
                int damage = ((Attacker) member).attack(target);
                System.out.println(member.getName() + " dealt " + damage + " damage to " + target.getName());
            }
        }
    }

    public void healTeam() {
        System.out.println("--- Team is healing ---");
        GameCharacter lowestHealthMember = null;
        double lowestRatio = Double.MAX_VALUE;

     
        for (GameCharacter member : members) {
            if (member.isAlive()) {
                double ratio = (double) member.getHealth() / member.getMaxHealth();
                if (ratio < lowestRatio) {
                    lowestRatio = ratio;
                    lowestHealthMember = member;
                }
            }
        }

        if (lowestHealthMember != null) {
            for (GameCharacter member : members) {
                if (member.isAlive() && member instanceof Supporter) {
                    int healed = ((Supporter) member).heal(lowestHealthMember);
                    System.out.println(member.getName() + " healed " + lowestHealthMember.getName() + " for " + healed + " HP.");
                }
            }
        }
    }

    public int getTotalPower() {
        int total = 0;
        for (GameCharacter member : members) {
            if (member.isAlive()) {
                total += member.calculatePower();
            }
        }
        return total;
    }

    public void displayTeam() {
        System.out.println("\n=== Team Status ===");
        for (GameCharacter member : members) {
            System.out.println(member.getCharacterInfo());
        }
        System.out.println("Total Team Power: " + getTotalPower());
        System.out.println("===================\n");
    }
}
