package Terkep;

/**
 *  A lávákat megvalósítő osztály.
 */
public class Lava {
    private final int x;
    private final int y;
    private final int mivolt;
    private int miotalava;

    /**
     * Létre hoz egy lávát
     * @param x első koordináta
     * @param y második koordináta
     * @param miotalava hány lépés óta láva
     * @param mivolt mi volt az elött hogy láváva alakult.
     */
    public Lava(int x, int y, int mivolt,int miotalava) {
        this.x = x;
        this.y = y;
        this.mivolt = mivolt;
        this.miotalava = miotalava;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMivolt() {
        return mivolt;
    }

    public int getMiotalava() {
        return miotalava;
    }

    public void setMiotalava(int miotalava) {
        this.miotalava = miotalava;
    }

}
