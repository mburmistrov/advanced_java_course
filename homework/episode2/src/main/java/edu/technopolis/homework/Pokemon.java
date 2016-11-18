package edu.technopolis.homework;

/**
 * Created by mmb on 18.11.16.
 */
public abstract class Pokemon {
    protected int healthPoints;
    protected int armour; //reduces damage
    protected int damage; //how hard pokemon hits
    protected boolean hasBattleCried; //should use battle cry only once

    public abstract void battleCry(); //shout some cool stuff before battle
    public abstract void printState();

    public int parry(int enemyDamage) { //defend from attack
        int enemyDamageAfterReduce = (enemyDamage - (int)(armour * Math.random()));
        healthPoints -= enemyDamageAfterReduce;
        if(healthPoints < 0){
            healthPoints = 0;
        }
        return enemyDamageAfterReduce;
    }

    public int getDamage() {
        return damage;
    }


    protected String getName(){
        return this.getClass().getSimpleName();
    }
}
