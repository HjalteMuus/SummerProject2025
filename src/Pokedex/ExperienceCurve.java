package Pokedex;

public enum ExperienceCurve {
    SLOW(0,"Slow"),
    MEDIUM(0,"Medium"),
    FAST(0,"Fast"),
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
            totalExpToNextLvl = (int)(Math.ceil(Math.pow(lvl+1,3)*1.25-Math.pow(lvl,3)*1.25));
        }else if(e == MEDIUM){
            totalExpToNextLvl = (int)(Math.ceil(Math.pow(lvl+1,3))-Math.pow(lvl,3));
        }else{
            totalExpToNextLvl = (int)(Math.ceil(Math.pow(lvl+1,3)*0.8-Math.pow(lvl,3)*0.8));
        }
        if (lvl == 100) totalExpToNextLvl = 0;
    }
}
