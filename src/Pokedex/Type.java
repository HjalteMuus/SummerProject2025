package Pokedex;

public enum Type {
    WATER("Water"),
    FIRE("Fire"),
    GRASS("Grass"),
    ELECTRIC("Electric"),
    GROUND("Ground"),
    ROCK("Rock"),
    DRAGON("Dragon"),
    ICE("Ice"),
    PSYCHIC("Psychic"),
    DARK("Dark"),
    BUG("Bug"),
    POISON("Poison"),
    FIGHTING("Fighting"),
    FLYING("Flying"),
    NORMAL("Normal"),
    FAIRY("Fairy"),
    GHOST("Ghost"),
    STEEL("Steel"),
    NONE(""),
    ;

    private final String typeName;

    Type(String typeName){
        this.typeName = typeName;
    }

    public String getTypeName(){
        return typeName;
    }
}
