package Mukodes;

/**
 * A csapat tagjait megvalósítő osztály.
 */
public class Emberek {
   private final String nev;
   private int miotakabszeres=0;
   private boolean kabitofuggo=false;
   private int miotaiszakos=0;
   private boolean whiskeyfuggo=false;
   private boolean leserult=false;

    /**
     * Látrehoz egy embert a paraméterben kapott névvel.
     */
    public Emberek(String nev) {
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    public boolean isKabitofuggo() {
        return kabitofuggo;
    }

    public void setKabitofuggo(boolean kabitofuggo) {
        this.kabitofuggo = kabitofuggo;
    }

    public boolean isWhiskeyfuggo() {
        return whiskeyfuggo;
    }

    public void setWhiskeyfuggo(boolean whiskeyfuggo) {
        this.whiskeyfuggo = whiskeyfuggo;
    }

    public boolean isLeserult() { return leserult; }

    public void setLeserult(boolean leserult) { this.leserult = leserult; }

    public int getMiotakabszeres() { return miotakabszeres; }

    public void setMiotakabszeres(int miotakabszeres) { this.miotakabszeres = miotakabszeres; }

    public int getMiotaiszakos() { return miotaiszakos; }

    public void setMiotaiszakos(int mioraiszakos) { this.miotaiszakos = mioraiszakos; }

    /**
     * Visszadja hogy van-e valamilyen függősége az embernek.
     */
    public boolean fuggoe(){ return (kabitofuggo || whiskeyfuggo); }
}
