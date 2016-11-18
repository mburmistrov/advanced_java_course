package edu.technopolis.homework;

/**
 * Created by mmb on 18.11.16.
 */
public class Pikachu extends Pokemon {
    Pikachu(){
        healthPoints = 350;
        damage = 23;
        armour = 20;
    }
    private static int criticalChance = 50; //pikachu has a chance to deal double damage

    public void battleCry(){
        System.out.println(this.getName() + " says: Pika Pika!");
        hasBattleCried = true;
    }

    public void printState(){
        System.out.println(this.getName() + " HP: " + healthPoints + ", damage: " + damage + ", armour: " + armour);
    }

    @Override
    public int getDamage() {
        int damage = super.getDamage(); //base damage
        if (((int)(Math.random() * 100) - criticalChance) > 0) {
            System.out.println(this.getClass().getSimpleName() + " performed a critical hit!");
            damage *= 2;
        }
        return damage;
    }
}
