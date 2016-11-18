package edu.technopolis.homework;

/**
 * Created by mmb on 18.11.16.
 */
public class Trainer {
    private Pokemon pokemon;

    public void catchPokemon(Pokemon newPokemon){
        this.pokemon = newPokemon;
    }

    public Pokemon getPokemon(){
        return pokemon;
    }

    public void parry(int damage){
        int dealtDamage = pokemon.parry(damage);
        System.out.println(pokemon.getClass().getSimpleName() + " was hit: " + dealtDamage);
    }

    public void attack(Trainer rivalTrainer){
        if(!pokemon.hasBattleCried){
            pokemon.battleCry();
        }
        System.out.println(pokemon.getClass().getSimpleName() + " attacks");
        rivalTrainer.parry(pokemon.getDamage());
    }

    public void printPokemonState(){
        pokemon.printState();
    }

    public boolean isPokemonAlright(){
        return pokemon.healthPoints > 0;
    }
}
