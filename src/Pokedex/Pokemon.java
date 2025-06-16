package Pokedex;

public class Pokemon {
    private String name;
    private final Type type1;
    private final Type type2;
    private int level;
    private final int MAX_LEVEL = 100;
    private int experience;
    private final ExperienceCurve experienceCurve;


    public Pokemon(String name, Type type1, Type type2, int level, int experience, ExperienceCurve experienceCurve){
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.level = level;
        this.experience = experience;
        this.experienceCurve = experienceCurve;
        experienceCurve.setTotalExpToNextLvl(level, experienceCurve);
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
        return type2;
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
        if(experienceUp < 1){
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

    @Override
    public String toString(){
        return String.format("""
                Name:       %s
                Types:      %s, %s
                Level:      %d
                Experience: %d
                Exp to lvl: %d
                """,
                name,
                type1.getTypeName(),
                type2.getTypeName(),
                level,
                experience,
                experienceCurve.getTotalExpToNextLvl()-experience
                );
    }
}
