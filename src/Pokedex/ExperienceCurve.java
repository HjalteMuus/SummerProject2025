package Pokedex;

public enum ExperienceCurve {
    SLOW(100,"Slow"),
    NORMAL(75,"Normal"),
    FAST(50,"Fast"),
    ;

    private final int expCurve;
    private final String name;

    ExperienceCurve(int expCurve, String name){
        this.expCurve = expCurve;
        this.name = name;
    }

    public int getExpCurve(){
        return expCurve;
    }

    public String getName(){
        return name;
    }
}
