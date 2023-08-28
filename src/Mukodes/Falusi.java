package Mukodes;

public class Falusi extends Emberek {
            private final String leiras;

    /**
     * A faluból felvehető csapattársat megvalósító osztály
     */
    public Falusi(String nev, String leiras) {
        super(nev);
        this.leiras = leiras;
    }

    public String getLeiras() {
        return leiras;
    }

}
