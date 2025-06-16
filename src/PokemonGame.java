import Pokedex.Pokemon;

import static Pokedex.ExperienceCurve.*;
import static Pokedex.Type.*;

public class PokemonGame {
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon("Bulbasaur", GRASS, POISON, 1, 0, SLOW);

        System.out.println(pokemon);

        pokemon.setExperience(1210000);

        System.out.println(pokemon);
    }
}
