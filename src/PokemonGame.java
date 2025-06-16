import Pokedex.Pokemon;

import static Pokedex.ExperienceCurve.*;
import static Pokedex.Type.*;

public class PokemonGame {
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon("Bulbasaur", GRASS, POISON, 20, 0, SLOW);
        Pokemon p = new Pokemon("Squirtle", WATER, 20, 0, MEDIUM_SLOW);
        Pokemon p2 = new Pokemon("Charmander", FIRE, 20, 0, FAST);
        Pokemon p3 = new Pokemon("Weedle", BUG, POISON, 20, 0, MEDIUM_FAST);

        System.out.println(pokemon);
        System.out.println(p);
        System.out.println(p2);
        System.out.println(p3);
    }
}
