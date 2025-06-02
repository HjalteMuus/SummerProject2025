import Pokedex.ExperienceCurve;
import Pokedex.Pokemon;

import static Pokedex.ExperienceCurve.*;
import static Pokedex.Type.*;

public class PokemonGame {
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon("Bulbasaur", GRASS, POISON, 5, 0, SLOW);

        System.out.println(
            "Pokemon name: " + pokemon.getName() +
            " and it's types are: " + pokemon.getType1().getTypeName() + " and " + pokemon.getType2().getTypeName() +
            "\nIt's level " + pokemon.getLevel() + " and has " + pokemon.getExperience() + " experience");

        pokemon.setExperience(1);

        System.out.println(pokemon.getExperience() + " " + pokemon.getLevel());
    }
}
