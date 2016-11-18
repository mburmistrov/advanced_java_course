package edu.technopolis.homework;

/**
 * Created by mmb on 18.11.16.
 */
public class Squirtl extends Pokemon {
    Squirtl(){
        healthPoints = 400;
        damage = 25;
        armour = 10;
    }
    private static int rageThreshold = 100;
    private boolean isInRage = false; //squirtl becomes enraged when on low health

    public void battleCry(){
        System.out.println(this.getName() + " says: This fight will be your last!");
        hasBattleCried = true;
    }

    public void printState(){
        System.out.println(this.getName() + " HP: " + healthPoints + ", damage: " + damage + ", armour: " + armour + ", is in rage: " + isInRage);
    }

    @Override
    public int parry(int enemyDamage) {
        int damageAfterReduce = super.parry(enemyDamage);
        if(!isInRage && (healthPoints < rageThreshold)){
            enrage();
        }
        return damageAfterReduce;
    }

    private void enrage(){
        System.out.println(this.getClass().getSimpleName() + " is in rage!");
        damage *= 2;
        armour *= 2;
        isInRage = true;
    }
}
