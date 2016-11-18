package edu.technopolis.homework;

/**
 * Created by mmb on 18.11.16.
 */
public class Battle {
    public static void main(String[] args) {
        Trainer lordVader = new Trainer();
        Trainer yoda = new Trainer();

        lordVader.catchPokemon(new Pikachu());
        yoda.catchPokemon(new Squirtl());

        System.out.println("The fight begins!");

        while (lordVader.isPokemonAlright() && yoda.isPokemonAlright()){
            lordVader.attack(yoda); //lord vader starts first cause dark side rules
            lordVader.printPokemonState();
            yoda.printPokemonState();
            yoda.attack(lordVader);
            yoda.printPokemonState();
            lordVader.printPokemonState();
        }

        if(!lordVader.isPokemonAlright() && !yoda.isPokemonAlright() ){
            System.out.printf("Its a tie!");
        }else if(lordVader.isPokemonAlright()){
            System.out.println(lordVader.getPokemon().getName() + " won!");
        }else{
            System.out.println(yoda.getPokemon().getName() + " won!");
        }
    }
}
