package Terkep;


import Mukodes.Random;

import java.util.ArrayList;
import java.util.List;



public class Map {
    Random random=new Random();
    private int mapmeret;
    private int[][] map;
    private int viszony=3;
    private final List<Falu> faluk=new ArrayList<>();

    public Falu getfalu(int x,int y){
        for(Falu ez:faluk) {
            if(x==ez.getPositionx() && y==ez.getPositiony()) {
                return ez;
            }
        }

        return null;
    }

    public int getViszony() {
        return viszony;
    }

    public void setViszony(int viszony) { this.viszony = viszony; }

    public void viszonycsokken(int x){ this.viszony-=x; }

    public int getMapmeret() {
        return mapmeret;
    }

    public void setMapmeret(int mapmeret) {
        this.mapmeret = mapmeret;
    }

    public int[][] getMap() { return this.map; }

    public void setMap(int[][] map) {
        this.map = map;
    }

    //0=víz
    //1=szárazföld
    //2=hajo
    //3=tó
    //4 jungle
    //5 hegyek
    //6 barlang
    //7 oltar
    //8 piramis
    //9 nedves
    //10 falu
    public Map(int mapmeret) {
        this.mapmeret = mapmeret;
        this.map = new int[mapmeret][mapmeret];
        viz();
        hajo();
        tavak();
        tavaknagy();
        jungle();
        junglenagy();
        hegy();
        hegynagy();
        barlang();
        oltar();
        falu();
        nedvesites();
        piramis();
    }
        //bal oldalra víz feltöltés + a többi helyre föld
        private void viz() {
            for (int i = 0; i < mapmeret; ++i) {
                for (int j = 0; j < mapmeret; ++j) {
                    if (j < mapmeret * 0.15) {
                        map[i][j] = 0;
                        continue;
                    }
                    double szelreviz = Math.abs(mapmeret / 2.0 - i) / mapmeret * 100;
                    if (j < mapmeret * 0.20 && random.Boolean(50 + szelreviz) && map[i][j - 1] == 0) {
                        map[i][j] = 0;
                        continue;
                    } else {
                        map[i][j] = 1;
                    }
                    if (j < mapmeret * 0.3 && random.Boolean(25 + szelreviz) && map[i][j - 1] == 0) {
                        map[i][j] = 0;
                        continue;
                    } else {
                        map[i][j] = 1;
                    }
                    if (j < mapmeret * 0.4 && random.Boolean(25 + szelreviz) && map[i][j - 1] == 0) {
                        map[i][j] = 0;
                        continue;
                    } else {
                        map[i][j] = 1;
                    }
                    if (j > mapmeret * 0.4) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        //hajo lerakása
        private void hajo() {
            int hajo = 1;
            while (hajo > 0) {
                for (int a = 0; a < mapmeret; ++a) {
                    for (int b = 0; b < mapmeret; ++b) {
                        if (map[b][a] == 0 && random.Boolean(1)) {
                            if (map[b][a + 1] == 1 && hajo > 0) {
                                map[b][a] = 2;
                                --hajo;
                                break;
                            }
                        }
                    }
                }
            }
        }
        //tavak lerakása
        private void tavak() {
        for (int a = 0; a < mapmeret; ++a) {
            for (int b = 0; b < mapmeret; ++b) {
                if (map[a][b] == 1) {
                    if (map[a][b - 2] != 0 && map[a][b - 1] != 0 && map[a][b - 2] != 2 && map[a][b - 1] != 2 && random.Boolean(2)) {
                        map[a][b] = 3;
                    }
                }
            }
        }
    }
        //tavak nagyítása
        private void tavaknagy() {
        for (int a = 0; a < mapmeret; a++) {
            for (int b = 0; b < mapmeret; b++) {
                if (map[a][b] == 3) {
                    if (map[a][b - 2] != 0 && map[a][b - 1] == 1 && random.Boolean(10)) {
                        map[a][b - 1] = 3;
                    }
                    if (b != mapmeret - 1 && random.Boolean(10)) {
                        map[a][b + 1] = 3;
                    }
                    if (a != 0 && random.Boolean(10)) {
                        if (map[a - 1][b] == 1 && map[a - 1][b - 2] != 0 && map[a - 1][b - 1] != 0) {
                            map[a - 1][b] = 3;
                        }
                    }
                    if (a != mapmeret - 1 && random.Boolean(10)) {
                        if (map[a + 1][b] == 1 && map[a + 1][b - 2] != 0 && map[a + 1][b - 1] != 0) {
                            map[a + 1][b] = 3;
                        }
                    }
                }
            }
        }
    }
        //jungle lerakása
        private void jungle() {
        for (int a = 0; a < mapmeret; ++a) {
            for (int b = 0; b < mapmeret; ++b) {
                if (map[a][b] == 1) {
                    if (map[a][b - 2] != 0 && map[a][b - 2] != 0 && random.Boolean(2 + mapmeret / 6.0)) {
                        map[a][b] = 4;
                    }
                }
            }
        }
    }
        //jungle nagyítása
        private void junglenagy() {
            for (int a = 0; a < mapmeret; a++) {
                for (int b = 0; b < mapmeret; b++) {
                    if (map[a][b] == 4) {
                        if (map[a][b - 1] == 1 && random.Boolean(20 + mapmeret - 10)) {
                            map[a][b - 1] = 4;
                        }
                        if (b != mapmeret - 1 && random.Boolean(20 + mapmeret - 10)) {
                            map[a][b + 1] = 4;
                        }
                        if (a != 0 && random.Boolean(20 + mapmeret - 10)) {
                            if (map[a - 1][b] == 1) {
                                map[a - 1][b] = 4;
                            }
                        }
                        if (a != mapmeret - 1 && random.Boolean(20 + mapmeret - 10)) {
                            if (map[a + 1][b] == 1) {
                                map[a + 1][b] = 4;
                            }
                        }
                    }
                }
            }
        }
        //hegyek lerakása
        private void hegy() {
            int hegy = 2;
            while (hegy > 0) {
                for (int a = 0; a < mapmeret; ++a) {
                    for (int b = 0; b < mapmeret; ++b) {
                        if (map[a][b] == 1 && random.Boolean(3)) {
                            if (map[a][b - 2] != 0 && map[a][b - 1] != 0 && map[a][b - 2] != 2 && map[a][b - 1] != 2 && map[a][b - 3] != 0 && map[a][b - 3] != 2) {
                                map[a][b] = 5;
                                --hegy;
                            }
                        }
                    }
                }
            }
        }
        //hegyek nagyítása
        private void hegynagy() {
            for (int a = 0; a < mapmeret; a++) {
                for (int b = 0; b < mapmeret; b++) {
                    if (map[a][b] == 5) {
                        if (map[a][b - 2] != 0 && map[a][b - 1] == 1 && random.Boolean(14 + mapmeret)) {
                            map[a][b - 1] = 5;
                        }
                        if (b != mapmeret - 1 && random.Boolean(14 + mapmeret)) {
                            map[a][b + 1] = 5;
                        }
                        if (a != 0 && random.Boolean(14 + mapmeret)) {
                            if (map[a - 1][b - 2] != 0 && map[a - 1][b - 1] != 0 && map[a - 1][b] == 1) {
                                map[a - 1][b] = 5;
                            }
                        }
                        if (a != mapmeret - 1 && random.Boolean(14 + mapmeret)) {
                            if (map[a + 1][b - 2] != 0 && map[a + 1][b - 1] != 0 && map[a + 1][b] == 1) {
                                map[a + 1][b] = 5;
                            }
                        }
                    }
                }
            }
        }
        //min 2 barlang
        private void barlang() {
            int barlang = 2;
            while (barlang > 0) {
                for (int a = 0; a < mapmeret; ++a) {
                    for (int b = 0; b < mapmeret; ++b) {
                        if (map[b][a] == 5 && random.Boolean(10)) {
                            map[b][a] = 6;
                            --barlang;
                        }
                    }
                }
            }
        }
        //min 1 oltár
        private void oltar() {
            int oltar = 1;
            while (oltar > 0) {
                for (int a = 0; a < mapmeret; ++a) {
                    for (int b = 0; b < mapmeret; ++b) {
                        if (map[b][a] == 1 && random.Boolean(1.5)) {
                            map[b][a] = 7;
                            --oltar;
                        }
                    }
                }
            }
        }
        //min 1 falu
        private void falu() {
            int falu = 1;
            while (falu > 0) {
                for (int a = 0; a < mapmeret; ++a) {
                    for (int b = 0; b < mapmeret; ++b) {
                        if (map[b][a] == 1 && random.Boolean(1.5)) {
                            map[b][a] = 10;
                            --falu;
                            Falu falu1 = new Falu(b, a);
                            faluk.add(falu1);
                        }
                    }
                }
            }
        }
        //1 piramis
        private void piramis() {
            int piramis = 1;
            while (piramis > 0) {
                for (int a = (int) (mapmeret * 0.7); a < mapmeret; ++a) {
                    for (int b = 0; b < mapmeret; ++b) {
                        if (map[b][a] == 1 && random.Boolean(0.5) && piramis != 0) {
                            map[b][a] = 8;
                            --piramis;
                            break;
                        }
                    }
                }
            }
        }
        //tavak nedvesitenek
        private void nedvesites2(int a,int b){
            if(map[a][b]==1){
                map[a][b]=9; }
            if(map[a][b]==7){
                map[a][b]=79; }
            if(map[a][b]==8){
                map[a][b]=89; }
        }

        private void nedvesites() {
        for (int a = 0; a < mapmeret; ++a) {
            for (int b = 0; b < mapmeret; ++b) {
                if(map[a][b]==3) {

                    nedvesites2(a,b-1);
                    if(b!=mapmeret-1) {
                        nedvesites2(a, b + 1);
                        if(a!=0) {
                            nedvesites2(a - 1, b + 1);
                        }
                        if(a!=mapmeret-1){
                            nedvesites2(a+1,b+1);
                                         }
                                       }

                    if(a!=0) {
                        nedvesites2(a - 1, b);
                        if(b!=mapmeret-1) {
                            nedvesites2(a - 1, b - 1);
                        }
                    }
                    if(a!=mapmeret-1) {
                        nedvesites2(a+1,b-1);
                        nedvesites2(a+1,b);
                    }
                }
            }
        }
    }
}
