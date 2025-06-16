package Pokedex;

public class Pokemon {
    private String name;
    private final Type type1;
    private Type type2;
    private int level;
    private final int MAX_LEVEL = 100;
    private int experience;
    private ExperienceCurve experienceCurve;

    public Pokemon(String name, Type type1, Type type2, int level, int experience, ExperienceCurve experienceCurve){
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.level = level;
        this.experience = experience;
        this.experienceCurve = experienceCurve;
        experienceCurve.setTotalExpToNextLvl(level, experienceCurve);
    }

    public Pokemon(String name, Type type1, int level, int experience, ExperienceCurve experienceCurve){
        this.name = name;
        this.type1 = type1;
        this.level = level;
        this.experience = experience;
        this.experienceCurve = experienceCurve;
        experienceCurve.setTotalExpToNextLvl(level, experienceCurve);
    }
    
    //Pokemon as seen in the pokedex
    public Pokemon(String name, Type type1, Type type2){
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public Type getType1(){
        return type1;
    }

    public Type getType2(){
        if(type2 != null){
            return type2;
        }
        return Type.NONE;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int levelUp){
        level = levelUp;
    }

    public int getExperience(){
        return experience;
    }

    public void setExperience(int experienceUp){
        if(experienceUp < 1 || level == MAX_LEVEL){
            return;
        }
        experience += experienceUp;

        while(true){
            if(experience < experienceCurve.getTotalExpToNextLvl() || level == MAX_LEVEL) break;
            levelUp();
        }
    }

    public ExperienceCurve getExperienceCurve(){
        return experienceCurve;
    }

    private void levelUp(){
        if(experience >= experienceCurve.getTotalExpToNextLvl()){
            experience = experience - experienceCurve.getTotalExpToNextLvl();
            setLevel((level+1));
        }
        experienceCurve.setTotalExpToNextLvl(level, experienceCurve);
        if(level == MAX_LEVEL) experience = 0;
    }

    public static Pokemon fromStringToParty(String csvFileLine){
        String[] attributes = csvFileLine.split(";");
        String name = attributes[0];
        Type primaryType = Type.valueOf(attributes[1]);
        Type secondaryType = !attributes[2].isEmpty() ? Type.valueOf(attributes[2]) : Type.NONE;
        int level = Integer.parseInt(attributes[3]);
        int experience = Integer.parseInt(attributes[4]);
        ExperienceCurve ec = ExperienceCurve.valueOf(attributes[5]);

        return new Pokemon(name, primaryType, secondaryType, level, experience, ec);
    }
    
    public static Pokemon fromStringToPokedex(String csvFileLine){
        String[] attributes = csvFileLine.split(";");
        String name = attributes[0];
        Type primaryType = Type.valueOf(attributes[1]);
        Type secondaryType = !attributes[2].isEmpty() ? Type.valueOf(attributes[2]) : Type.NONE;

        return new Pokemon(name, primaryType, secondaryType);
    }

    public String[] toStringArrayToPokedex(){
        String[] attributes = new String[3];
        attributes[0] = name;
        attributes[1] = getType1().getTypeName();
        attributes[2] = !(getType2().getTypeName().isEmpty()) ? getType2().getTypeName() : "";

        return attributes;
    }

    @Override
    public String toString(){
        if(getType2().getTypeName().isEmpty()){
            return String.format("""
                Name:       %s
                Types:      %s
                Level:      %d
                Experience: %d
                Exp to lvl: %d
                """,
                name,
                getType1().getTypeName(),
                level,
                experience,
                experienceCurve.getTotalExpToNextLvl()-experience);
        }

        return String.format("""
                Name:       %s
                Types:      %s
                Level:      %d
                Experience: %d
                Exp to lvl: %d
                """,
                name,
                String.format("%s %s", getType1().getTypeName(), getType2().getTypeName()),
                level,
                experience,
                experienceCurve.getTotalExpToNextLvl()-experience);
    }
}
