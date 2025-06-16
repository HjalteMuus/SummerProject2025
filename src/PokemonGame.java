import Pokedex.Pokemon;

import static Pokedex.ExperienceCurve.*;
import static Pokedex.Type.*;

public class PokemonGame {
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon("Bulbasaur", GRASS, POISON, 1, 0, SLOW);
        Pokemon p = new Pokemon("Squirtle", WATER, 1, 0, MEDIUM);
        Pokemon p2 = new Pokemon("Charmander", FIRE, 1, 0, FAST);

        System.out.println(pokemon);
        System.out.println(p);
        System.out.println(p2);
    }
}
