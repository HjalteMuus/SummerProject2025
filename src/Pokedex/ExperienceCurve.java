package Pokedex;

public enum ExperienceCurve {
    SLOW(8,"Slow"),
    NORMAL(5,"Normal"),
    FAST(3,"Fast"),
    ;

    private int totalExpToNextLvl;
    private final String name;

    ExperienceCurve(int totalExpToNextLvl, String name){
        this.totalExpToNextLvl = totalExpToNextLvl;
        this.name = name;
    }

    public int getTotalExpToNextLvl(){
        return totalExpToNextLvl;
    }

    public String getName(){
        return name;
    }

    public void setTotalExpToNextLvl(int lvl, ExperienceCurve e){
        if(e == SLOW){
            totalExpToNextLvl = (lvl * totalExpToNextLvl) + 25;
        }else if(e == NORMAL){
            totalExpToNextLvl = (lvl * totalExpToNextLvl) + 18;
        }else{
            totalExpToNextLvl = (lvl * totalExpToNextLvl) + 14;
        }
    }
}
