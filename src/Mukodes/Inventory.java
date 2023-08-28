package Mukodes;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Az inventoryt megvalósító osztály.
 */
public class Inventory {
    private final List<String> itemek= new ArrayList<>();
    private final List<Integer> mennyiseg= new ArrayList<>();
    private final List<Integer> slot = new ArrayList<>();

    public Inventory() {}

    /**
     * visszadja hogy van-e a paraméterben kapott tárgyból az inventoryban.
     */
    public boolean vane(String nev) {
        return itemek.contains(nev);
    }

    /**
     * Csökkenti a tárgy mennyiségét
     * @param mennyit mennyiel csökkentse a mennyiséget
     * @param nev mit csökkentsen.
     */
    public void csokkentes(String nev,int mennyit) {
        int index = itemek.indexOf(nev);
        if(index>-1) {
            int x = mennyiseg.get(index);
            if (x - mennyit < 1) {
                mennyiseg.remove(index);
                slot.remove(index);
                itemek.remove(nev);
            } else {
                mennyiseg.set(index, x - mennyit);
                slot.set(index, (int) Math.ceil(mennyiseg.get(index) / 7.0));
                if(Objects.equals(nev, "Kincs")) {
                    slot.set(itemek.indexOf(nev),mennyiseg.get(itemek.indexOf(nev)));
                }
            }
        }
    }

    /**
     *Növeli a tárgy mennyiségét
     * @param nev mit növeljen.
     * @param mennyit mennyivel növelje.
     */
    public void noveles(String nev,int mennyit) {
        int index = itemek.indexOf(nev);
        if(index==-1) {
            itemek.add(nev);
            mennyiseg.add(itemek.indexOf(nev),mennyit);
            slot.add(itemek.indexOf(nev), (int) Math.ceil(mennyit/7.0));
            if(Objects.equals(nev, "Kincs")) {
                slot.set(itemek.indexOf(nev),mennyiseg.get(itemek.indexOf(nev)));
            }
        } else {
            mennyiseg.set(index, mennyiseg.get(index) + mennyit);
            slot.set(index, (int) Math.ceil(mennyiseg.get(index)/7.0));
            if(Objects.equals(nev, "Kincs")) {
                slot.set(index,mennyiseg.get(index));
            }
        }
    }

    /**
     * Visszadja hogy mennyi slotot foglal az egész inventory.
     */
    public int slotokmennyisege() {
        int x = 0;
        for(int temp:slot) {
            x+=temp;
        }
        return x;
    }

    public List<String> getItemek() {
        return itemek;
    }

    public List<Integer> getMennyiseg() {
        return mennyiseg;
    }

    public List<Integer> getSlot() {
        return slot;
    }

}
