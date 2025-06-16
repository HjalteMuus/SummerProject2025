import Pokedex.Pokemon;

import static Pokedex.ExperienceCurve.*;
import static Pokedex.Type.*;

public class PokemonGame {
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon("Bulbasaur", GRASS, POISON, 5, 0, SLOW);
        Pokemon p = new Pokemon("Squirtle", WATER, 5, 0, MEDIUM);

        System.out.println(pokemon);
        System.out.println(p);
    }
}
