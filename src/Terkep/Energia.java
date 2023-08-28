package Terkep;

import Mukodes.Inventory;

/**
 * Az enegia kezelését megvalósító osztály.
 */
public class Energia {
    private double energia;

    /**
     * Létrehozza az energiát ami alapból 100.
     */
    public Energia() {
        this.energia = 100;
    }

    /**
     * Ha lép az ember kiszámolja hogy hány energiát kell veszítenie.
     */
    public void lepes(int[][] map, int x, int y, Inventory inventory, boolean szamar, int csapatmeret){

        int slot = inventory.slotokmennyisege()-(szamar ? 10 : 8);

        double alap = 1 * Math.pow(1.2, csapatmeret) * Math.pow(1.2, Math.max(0,slot));

        if (map[x][y] == 1 || map[x][y] == 9 || map[x][y] == 7 || map[x][y] == 8 || map[x][y] == 10) {
            removeen(alap);
        }
        if (map[x][y] == 4 && !inventory.vane("Bozótvágó")) {
            removeen(alap*2);
        } else if(map[x][y]==4) {
            inventory.csokkentes("Bozótvágó",1);
            map[x][y]=1;
            removeen(alap);
        }
    }

    /**
     * csökkenti az energiát a paraméterben kapott számmal.
     */
    public void removeen(double x){
        energia-=x;
        if(energia<0) {energia=0;}
    }

    public double getEnergia() {
        return energia;
    }

    /**
     * növeli az energiát a paraméterben kapott számmal.
     */
    public void adden(double x){
        if(this.energia+x<=100) {
        this.energia+=x;}
        else {energia=100;}
    }
}
