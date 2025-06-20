package Pokedex;

public enum ExperienceCurve {
    SLOW(0,"Slow"),
    MEDIUM_FAST(0,"Medium Fast"),
    MEDIUM_SLOW(0, "Medium Slow"),
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
        if (lvl == 100){
            totalExpToNextLvl = 0;
            return;
        }
        if(e == SLOW){
            totalExpToNextLvl = (int)(Math.ceil(Math.pow(lvl+1,3)*1.25-Math.pow(lvl,3)*1.25));
        }else if(e == MEDIUM_FAST){
            totalExpToNextLvl = (int)(Math.ceil(Math.pow(lvl+1,3))-Math.pow(lvl,3));
        }else if(e == FAST){
            totalExpToNextLvl = (int)(Math.ceil(Math.pow(lvl+1,3)*0.8-Math.pow(lvl,3)*0.8));
        }else{
            if(lvl == 1){
                totalExpToNextLvl = 9;
                return;
            }
            totalExpToNextLvl = (int)(Math.ceil(1.2*Math.pow(lvl+1,3)-15*Math.pow(lvl+1,2)+100*(lvl+1)-140)-(1.2*Math.pow(lvl,3)-15*Math.pow(lvl,2)+100*(lvl)-140));
        }
    }
}
