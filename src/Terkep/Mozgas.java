package Terkep;

/**
 * A mozgást megvalósító osztály.
 */
public class Mozgas {
    private final int max;
    private int positionx;
    private int positiony;

    public int getPositionx() {
        return positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    /**
     * Létrehoz egy mozgást az adott térképre.
     * @param amap adott terkep
     * @param meret térkép mérete.
     */
    public Mozgas(Map amap, int meret) {
        this.max = meret-1;
        int[][] map = amap.getMap();
        for (int a = 0; a < meret; ++a) {
            for (int b = 0; b < meret; ++b) {
                if(map[a][b]==2) {
                    positionx=a;
                    positiony=b;
                }
                }
            }
    }

    /**
     * Lefelé lépés
     */
    public void lelep(int[][] felhomap,boolean felderito) {
        if(positionx==max) {
            return;
        }
        if(positionx==max-1) {
            felhomap[positionx][positiony]=1;
            positionx++;
            felhomap[positionx][positiony]=9;
            return;
        }
        felhomap[positionx][positiony]=1;
        positionx++;
        felhomap[positionx][positiony]=9;
        felhomap[positionx+1][positiony]=1;
        if(positiony<max){felhomap[positionx+1][positiony+1]=1;}
        if(positiony>0){felhomap[positionx+1][positiony-1]=1;}
        if(felderito && positionx<max-1) {
            felhomap[positionx+2][positiony]=1;
            if(positiony<max-1){felhomap[positionx+2][positiony+2]=1;}
            if(positiony<max){felhomap[positionx+2][positiony+1]=1;}
            if(positiony>1){felhomap[positionx+2][positiony-2]=1;}
            if(positiony>0){felhomap[positionx+2][positiony-1]=1;}
        }
    }

    /**
     *felfelé lépés
     */
    public void fellep(int[][] felhomap,boolean felderito) {
        if(positionx==0) {
            return;
        }
        if(positionx==1) {
            felhomap[positionx][positiony]=1;
            positionx--;
            felhomap[positionx][positiony]=9;
            return;
        }
        felhomap[positionx][positiony]=1;
        positionx--;
        felhomap[positionx][positiony]=9;
        felhomap[positionx-1][positiony]=1;
        if(positiony<max){felhomap[positionx-1][positiony+1]=1;}
        if(positiony>0){felhomap[positionx-1][positiony-1]=1;}
        if(felderito && positionx>1) {
            felhomap[positionx-2][positiony]=1;
            if(positiony<max-1){felhomap[positionx-2][positiony+2]=1;}
            if(positiony<max){felhomap[positionx-2][positiony+1]=1;}
            if(positiony>1){felhomap[positionx-2][positiony-2]=1;}
            if(positiony>0){felhomap[positionx-2][positiony-1]=1;}
        }
    }

    /**
     * jobbra lépés
     */
public void jobbralep(int[][] felhomap,boolean felderito) {
        if(positiony==max) {
            return;
        }
        if(positiony==max-1) {
            felhomap[positionx][positiony]=1;
            positiony++;
            felhomap[positionx][positiony]=9;
            return;
        }
        felhomap[positionx][positiony]=1;
        positiony++;
        felhomap[positionx][positiony]=9;
        felhomap[positionx][positiony+1]=1;
        if(positionx<max){felhomap[positionx+1][positiony+1]=1;}
        if(positionx>0){felhomap[positionx-1][positiony+1]=1;}
    if(felderito && positiony<max-1) {
        felhomap[positionx][positiony+2]=1;
        if(positionx<max-1){felhomap[positionx+2][positiony+2]=1;}
        if(positionx<max){felhomap[positionx+1][positiony+2]=1;}
        if(positionx>1){felhomap[positionx-2][positiony+2]=1;}
        if(positionx>0){felhomap[positionx-1][positiony+2]=1;}
    }
}

    /**
     * balra lépés
     */
public void balralep(int[][] felhomap,boolean felderito) {
    felhomap[positionx][positiony]=1;
    positiony--;
    felhomap[positionx][positiony]=9;
    felhomap[positionx][positiony-1]=1;
    if(positionx<max){felhomap[positionx+1][positiony-1]=1;}
    if(positionx>0){felhomap[positionx-1][positiony-1]=1;}
    if(felderito && positiony>1) {
        felhomap[positionx][positiony-2]=1;
        if(positionx<max-1){felhomap[positionx+2][positiony-2]=1;}
        if(positionx<max){felhomap[positionx+1][positiony-2]=1;}
        if(positionx>1){felhomap[positionx-2][positiony-2]=1;}
        if(positionx>0){felhomap[positionx-1][positiony-2]=1;}
    }
}

}