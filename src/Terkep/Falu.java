package Terkep;

import Mukodes.Falusi;
import Mukodes.Random;


public class Falu {
    Random random = new Random();
    private final int positionx;
    private final int positiony;
    private int kotel;
    private int faklya;
    private int gyumolcs;
    private int hus;
    private int kabitoszer;
    private Falusi csapattars;

    /**
     * A falukat megvalósító osztály.
     * @param positionx első koordináta
     * @param positiony második koordináta
     */
    public Falu(int positionx, int positiony) {
        this.positionx = positionx;
        this.positiony = positiony;
        this.kotel = 3 + (int) (Math.random() * 2);
        this.faklya = 1 + (int) (Math.random() * 5);
        this.gyumolcs = 5 + (int) (Math.random() * 5);
        this.hus = 5 + (int) (Math.random() * 5);
        this.kabitoszer = (int) (Math.random() * 3);
        if (random.Boolean(20)) {
            switch (random.szam(1, 3)) {
                case 1 : {csapattars = new Falusi("Felderítő", "+1 Látókör. Ára: 150 Arany");
                break;}
                case 2 : {csapattars = new Falusi("Sámán", "Kábítószer +20% energia. Ára: 150 Arany");
                break;}
                case 3 : {csapattars = new Falusi("Bölcs", "+3 Alapviszony új térképen. Ára: 150 Arany");
                break;}
            }
        } else {
            csapattars = new Falusi("Nincs", "Nincs");
        }
    }

    /**
     *  a faluból vehető csapattársat kitörli.
     */
    public void deleteCsapattars() {
        this.csapattars = new Falusi("Nincs", "Nincs");
    }

    public Falusi getCsapattars() {
        return csapattars;
    }

    public void setKotel(int kotel) {
        this.kotel = kotel;
    }

    public void setFaklya(int faklya) {
        this.faklya = faklya;
    }

    public void setGyumolcs(int gyumolcs) {
        this.gyumolcs = gyumolcs;
    }

    public void setHus(int hus) {
        this.hus = hus;
    }

    public void setKabitoszer(int kabitoszer) {
        this.kabitoszer = kabitoszer;
    }

    public int getPositionx() {
        return positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    public int getKotel() {
        return kotel;
    }

    public int getFaklya() {
        return faklya;
    }

    public int getGyumolcs() {
        return gyumolcs;
    }

    public int getHus() {
        return hus;
    }

    public int getKabitoszer() {
        return kabitoszer;
    }

}
