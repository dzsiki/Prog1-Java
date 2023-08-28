package Mukodes;

/**
 * Random Számot/booleant megvalósító osztály.
 */
public class Random {
    /**
     * Vissza ad a paraméterben kapott eséllyel true-t. amugy falset.
     */
    public boolean Boolean(double probability) {
        double randomValue = Math.random() * 100;  //0.0 to 99.9
        return randomValue <= probability;
    }
    /**
     * A parméterben kapott számok közötti számot ad vissza.
     */
    public int szam(int min,int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
