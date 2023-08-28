package Mukodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A csapatot és tagjait tartalmaző és ezzel kapcsolatos függvényeket tartalmazó osztály.
 */
public class Csapat {
    List<Emberek> emberek;
    private String legutobbikaja;
    Random random=new Random();

    /**
     * Lekéri hogy mi volt a legutobb fogyasztott táőlálék.
     */
    public String getLegutobbikaja() {
        return legutobbikaja;
    }

    /**
     * Ha Eszik a csapat ez beállítja hogy mi volt az.
     */
    public void setLegutobbikaja(String legutobbikaja) {
        this.legutobbikaja = legutobbikaja;
    }

    /**
     * Konstruktor ami hozzáadja alapértelmezetten a Felfedezőt.
     */
    public Csapat() {
        this.emberek = new ArrayList<>();
        addmember("Felfedező");
    }

    /**
     * Visszadaja hogy van e a paraméterben kapott ember a csapatban.
     */
    public boolean vanexy(String xy) {
        for(Emberek ember:emberek) {
            if(Objects.equals(ember.getNev(), xy)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Kitörli a paraméterben kapott mennyiségő embert, mindenkit a paraméterben kapott esellyel.
     */
    public String removemember(int esely,int mennyi){
        StringBuilder returns= new StringBuilder();
        for(int i=0;i< emberek.size();i++) {
            if(random.Boolean(esely) && !Objects.equals(emberek.get(i).getNev(), "Felfedező")) {
                returns.append(emberek.get(i).getNev()).append(" Lelépett ");
                emberek.remove(i);
                i--;
                if(mennyi==1) {break;}
            } else if(random.Boolean(esely) && Objects.equals(emberek.get(i).getNev(), "Felfedező") && emberek.size()==1){
                emberek.remove(i);
                i--;
                if(mennyi==1) {break;}
            }
        }
        return returns.toString()+"\n";
    }

    /**
     * Hozzáadja a paraméterben kapott embert a csapathoz.
     */
    public void addmember(String xy) {
        Emberek ember=new Emberek(xy);
        emberek.add(ember);
    }

    /**
     * 15% eséllyel függővé teszi az embereket.
     * @param anyag Melyik anyagra lesznek függők.
     */
    public void fuggo(String anyag) {

        if (random.Boolean(15)) {
            if(Objects.equals(anyag, "w")) {
                emberek.get(random.szam(0, emberek.size()-1)).setWhiskeyfuggo(true);}
            if(Objects.equals(anyag, "k")) {
                emberek.get(random.szam(0, emberek.size()-1)).setKabitofuggo(true);
            }
        }
    }

    /**
     *20% eséllyel valakit lesérít a cspatban.
     */
    public String leserul(){
        if (random.Boolean(20)) {
            int index= random.szam(0, emberek.size()-1);
            emberek.get(index).setLeserult(true);
            return "Lesérült " + emberek.get(index).getNev()+"\n";
        }
        return "";
    }

    /**
     * Ha valaki sérült akkor 5% eséllyel kitörli a csapatból.
     */
    public void serultelhagy(){
        for(int i=0;i< emberek.size();i++) {
            if(random.Boolean(5) && emberek.get(i).isLeserult()) {
                emberek.remove(i);
                i--;
            }
        }
    }

    /**
     * Aki sérült már nem lesz többé az.
     */
    public void meggyogyul(){
        for(Emberek ember:emberek){
            ember.setLeserult(false);
        }
    }

    /**
     * Ha eszik csokit a csapat eltünteti a függéséget.
     */
    public void fuggokivaltas() {
        for (Emberek ember : emberek) {
            ember.setWhiskeyfuggo(false);
            ember.setKabitofuggo(false);
            ember.setMiotakabszeres(0);
            ember.setMiotaiszakos(0);
        }
        }
    /**
     * Ha valaki függő azt kitörli 10% eséllyel ha több mint 30 kör óta az.
     */
        public String fuggokilep(){
        StringBuilder returns= new StringBuilder();
            for(int i=0;i< emberek.size();i++) {
                if(emberek.get(i).isKabitofuggo()){emberek.get(i).setMiotakabszeres(emberek.get(i).getMiotakabszeres()+1);}
                if(emberek.get(i).isWhiskeyfuggo()){emberek.get(i).setMiotaiszakos(emberek.get(i).getMiotaiszakos()+1);}
                if((emberek.get(i).getMiotaiszakos() > 30 || emberek.get(i).getMiotakabszeres() > 30) && random.Boolean(10)){
                    returns.append(emberek.get(i).getNev()).append(" Eltávozott");
                    emberek.remove(emberek.get(i));
                }
            }
            return returns.toString();
        }

    /**
     * Visszadja hogy hány meber van a csapatban a felfedezőn kívül.
     */
    public int meret() {
        return emberek.size()-1;
    }

    /**
     * a csapatot tartalmazó listát adja vissza.
     */
    public List<Emberek> getEmberek() {
        return emberek;
    }
}
