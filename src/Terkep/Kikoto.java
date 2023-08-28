package Terkep;

/**
 * Olyan mint a falu de ez a kikötő boltját valósítja meg.
 */
public class Kikoto {
    private int kotel;
    private int faklya;
    private int bozotvago;
    private int hus;
    private int whiskey;
    private int csoki;
    private int golyo;

    /**
     * Létrehozza a kikötőt az árukkal
     */
    public Kikoto() {
        this.kotel = 50 + (int) (Math.random() * 49);
        this.faklya = 20 + (int) (Math.random() * 30);
        this.bozotvago = 50 + (int) (Math.random() * 49);
        this.hus = 40 + (int) (Math.random() * 40);
        this.whiskey = (int) (Math.random() * 50);
        this.csoki = 30 + (int) (Math.random() * 20);
        this.golyo = (int) (Math.random() * 30);
    }

    public int getKotel() {
        return kotel;
    }

    public void setKotel(int kotel) {
        this.kotel = kotel;
    }

    public int getFaklya() {
        return faklya;
    }

    public void setFaklya(int faklya) {
        this.faklya = faklya;
    }

    public int getBozotvago() {
        return bozotvago;
    }

    public void setBozotvago(int bozotvago) {
        this.bozotvago = bozotvago;
    }

    public int getHus() {
        return hus;
    }

    public void setHus(int hus) {
        this.hus = hus;
    }

    public int getWhiskey() {
        return whiskey;
    }

    public void setWhiskey(int whiskey) {
        this.whiskey = whiskey;
    }

    public int getCsoki() {
        return csoki;
    }

    public void setCsoki(int csoki) {
        this.csoki = csoki;
    }

    public int getGolyo() {
        return golyo;
    }

    public void setGolyo(int golyo) {
        this.golyo = golyo;
    }
}
