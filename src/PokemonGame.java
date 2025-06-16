import Pokedex.Pokemon;

import static Pokedex.ExperienceCurve.*;
import static Pokedex.Type.*;

public class PokemonGame {
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon("Bulbasaur", GRASS, POISON, 5, 0, SLOW);

        System.out.println(pokemon);

        pokemon.setExperience(64);

        System.out.println(pokemon);
    }
}
