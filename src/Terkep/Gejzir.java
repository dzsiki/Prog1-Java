package Terkep;

/**
 * A gejzír helyét és hogy mióta van ott tartalmazó osztály
 */
public class Gejzir {
    int x;
    int y;
    int miota;

    /**
     * Létrehoz egy gejzírt a paraméterben kapott koordinátákon aminek megadható hogy mennyi ideje van már ott.
     */
    public Gejzir(int x, int y, int miota) {
        this.x = x;
        this.y = y;
        this.miota = miota;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMiota() {
        return miota;
    }

    public void setMiota(int miota) {
        this.miota = miota;
    }
}
