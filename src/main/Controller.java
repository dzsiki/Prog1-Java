package main;

//<editor-fold defaultstate="collapsed" desc="Importok">
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

import Mukodes.Emberek;
import Mukodes.Random;
import Terkep.*;
import Terkep.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Mukodes.Csapat;
import Mukodes.Inventory;
//</editor-fold>

/**
 * A controller ami a GUI-t kezeli ezáltal szinte az egész program innen fut és van kezelve.
 */
public class Controller implements Initializable {



    Energia energia;
    int hirnev;
    int arany;
    Map amap;
    int[][] felhomap;
    Mozgas mozgas;
    Inventory inventory;
    Inventory hajoinv;
    Csapat csapat;
    int meret;
    String playername="Player";
    Random random= new Random();
    List<Lava> lavak;
    List<Gejzir> gejzirek;
    Kikoto kikoto;
    int kuldetes;

    //<editor-fold defaultstate="collapsed" desc="Képek">
    Image viz0 = new Image("file:kepek\\0.png");
    Image fold0 = new Image("file:kepek\\1.png");
    Image hajo0 = new Image("file:kepek\\2.png");
    Image jungle0 = new Image("file:kepek\\4.png");
    Image hegy0 = new Image("file:kepek\\5.png");
    Image vulkan0 = new Image("file:kepek\\51.png");
    Image barlang0 = new Image("file:kepek\\6.png");
    Image oltar0 = new Image("file:kepek\\7.png");
    Image oltar1 = new Image("file:kepek\\79.png");
    Image piramis0 = new Image("file:kepek\\8.png");
    Image piramis1 = new Image("file:kepek\\89.png");
    Image vizes0 = new Image("file:kepek\\9.png");
    Image falu0 = new Image("file:kepek\\10.png");
    Image lava0 = new Image("file:kepek\\11.png");
    Image gejzir0 = new Image("file:kepek\\12.png");
    Image felho0 = new Image("file:kepek\\felho.png");
    Image fohos0 = new Image("file:kepek\\fohos.png");
    Image semmi0 = new Image("file:kepek\\semmi.png");
    Image kereskedo = new Image("file:kepek\\kereskedo.png");
    Image katona = new Image("file:kepek\\katona.png");
    Image szamar = new Image("file:kepek\\szamar.png");
    Image felderito = new Image("file:kepek\\felderito.png");
    Image saman = new Image("file:kepek\\saman.png");
    Image bolcs = new Image("file:kepek\\bolcs.png");
    Image kincs0= new Image("file:kepek\\kincs.png");
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="FXML importok">
    @FXML
    Label kikotopenz;
    @FXML
    Label ranglistalabel;
    @FXML
    Button folytatas;
    @FXML
    Button jatekvege;
    @FXML
    Pane ranglista;
    @FXML
    Label elso;
    @FXML
    Label masodik;
    @FXML
    Label harmadik;
    @FXML
    Label negyedik;
    @FXML
    ImageView kincskep;
    @FXML
    Pane kincspane;
    @FXML
    Pane koztespane;
    @FXML
    Label kincsdarab;
    @FXML
    Button kincselad;
    @FXML
    Button kincsajandek;
    @FXML
    Pane kikotobolt;
    @FXML
    Button kikotokotel;
    @FXML
    Button kikotofaklya;
    @FXML
    Button kikotobozot;
    @FXML
    Button kikotohus;
    @FXML
    Button kikotogolyo;
    @FXML
    Button kikotocsoki;
    @FXML
    Button kikotowhiskey;
    @FXML
    Label kkmennyi;
    @FXML
    Label kfmennyi;
    @FXML
    Label kbmennyi;
    @FXML
    Label khmennyi;
    @FXML
    Label kumennyi;
    @FXML
    Label kcsmennyi;
    @FXML
    Label kwmennyi;
    @FXML
    Label kkar;
    @FXML
    Label kfar;
    @FXML
    Label kbar;
    @FXML
    Label khar;
    @FXML
    Label kuar;
    @FXML
    Label kcsar;
    @FXML
    Label kwar;
    @FXML
    public Button felveszgomb;
    @FXML
    public Button lepakolgomb;
    @FXML
    public Label hajoinventorydarab;
    @FXML
    public Pane hajoinventorypane;
    @FXML
    public ChoiceBox<String> hajochoice;
    @FXML
    public Pane hajopane;
    @FXML
    public Label visszajelzeslabel;
    @FXML
    public Label lose;
    @FXML
    public Label csapatlabel;
    @FXML
    public ImageView falutarskep;
    @FXML
    public Label falutarsleiras;
    @FXML
    public Button falutarsbuy;
    @FXML
    public ImageView tarskep;
    @FXML
    public Label tarsleiras;
    @FXML
    public Label tarsnev;
    @FXML
    public Pane tarspane;
    @FXML
    public Label aranylabel;
    @FXML
    public Label aranylabel1;
    @FXML
    public Label energylabel;
    @FXML
    public Button eatgyum;
    @FXML
    public Button eathus;
    @FXML
    public Button eatcsoki;
    @FXML
    public Button eatkabito;
    @FXML
    public Button eatwhiskey;
    @FXML
    public Label inventorylabel;
    @FXML
    public Slider mapmeret;
    @FXML
    public AnchorPane mappane;
    @FXML
    private GridPane grid;
    @FXML
    public GridPane felho;
    @FXML
    public Button mapbeolvas;
    @FXML
    public AnchorPane fomenu;
    @FXML
    public TextField playernameinput;
    @FXML
    public Pane mapsettings;
    @FXML
    public Pane ingamepane;
    @FXML
    public Button startgame;
    @FXML
    public Pane falupane;
    @FXML
    public Label kotelmennyiseg;
    @FXML
    public Label faklyamennyiseg;
    @FXML
    public Label gyumolcsmennyiseg;
    @FXML
    public Label husmennyiseg;
    @FXML
    public Label kabitomennyiseg;
    @FXML
    public Button kotelvasarlas;
    @FXML
    public Button faklyavasarlas;
    @FXML
    public Button gyumolcsvasarlas;
    @FXML
    public Button husvasarlas;
    @FXML
    public Button kabitovasarlas;
    @FXML
    public Label kotelar;
    @FXML
    public Label faklyaar;
    @FXML
    public Label gyumolcsar;
    @FXML
    public Label husar;
    @FXML
    public Label kabitoar;
    //</editor-fold>

    /**
     * A főmenü gomja. Visszaállít mindent alapértelmezettre és átvált a térkép generálós részre.
     */
    @FXML
    private void gotomapgen() {
        fomenu.setVisible(false);
        mappane.setVisible(true);
        arany=250;
        hirnev=0;
        kuldetes=0;
        energia = new Energia();
        csapat=new Csapat();
        inventory = new Inventory();
        hajoinv = new Inventory();
        lavak=new ArrayList<>();
        gejzirek=new ArrayList<>();
        kikoto=new Kikoto();
        mapgen();
        ingamepane.setVisible(false);
        mapsettings.setVisible(true);
        playernameinput.setDisable(false);
        hajopane.setVisible(false);
        lose.setVisible(false);
        kikotokotel.setDisable(false);
        kikotocsoki.setDisable(false);
        kikotogolyo.setDisable(false);
        kikotohus.setDisable(false);
        kikotobozot.setDisable(false);
        kikotofaklya.setDisable(false);
        kikotowhiskey.setDisable(false);
        falupane.setVisible(false);
    }

    /**
     * A generálás után ezzel indítod el a játékot.
     */
    @FXML
    private void startgame() {
        playername = playernameinput.getText();
        mapsettings.setVisible(false);
        ingamepane.setVisible(true);
        guifrissit();
        ingamepane.setDisable(true);
        randomtars();
        tarspane.setVisible(true);
        falupane.setVisible(false);
        visszajelzeslabel.setText("");
        playernameinput.setDisable(true);
    }

    //<editor-fold defaultstate="collapsed" desc="Társ a küldetés elején">
    private void randomtars(){
        switch (random.szam(1, 3)) {
            case 1 : {
                tarskep.setImage(kereskedo);
                tarsnev.setText("Kereskedő");
                tarsleiras.setText("Minden kicsit olcsóbb. Ára: 150 Arany");
                break;
            }
            case 2 : {
                tarskep.setImage(katona);
                tarsnev.setText("Katona");
                tarsleiras.setText("Whiskey +20% energiát tölt vissza. Ára: 150 Arany");
                break;
            }
            case 3 : {
                tarskep.setImage(szamar);
                tarsnev.setText("Szamár");
                tarsleiras.setText("+2 Inventory slot. Ára: 150 Arany");
                break;
            }
        }
    }

    @FXML
    private void tarselutasit(){
        ingamepane.setDisable(false);
        tarspane.setVisible(false);
    }
    @FXML
    private void tarsfelvetel(){

        if(arany<150) {
            tarsleiras.setText("Nincs elég pénzed!"); return;}
        if(csapat.meret()>3) {
            tarsleiras.setText("Nem lehet több csapattársad!"); return;}
        if(csapat.vanexy(tarsnev.getText())) {
            tarsleiras.setText("Van már ilyen a csapatodban!"); return;}

            csapat.addmember(tarsnev.getText());
            arany-=150;

            ingamepane.setDisable(false);
            tarspane.setVisible(false);
            guifrissit();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Térkép generáláshoz">
    /**
     * Legenerál egy teljesen új térképet a felhővel együtt.
     */
    @FXML
    private void mapgen() {
        startgame.setVisible(true);
        int meret= (int) mapmeret.getValue();
        amap = new Map(meret);
        if(csapat.vanexy("Bölcs")){
            amap.setViszony(6); }
        amap.setMapmeret(meret);
        mozgas = new Mozgas(amap,meret);

        this.meret=meret;
        mapkirajzolas();
        felhomapgen();
        felho();
    }

    /**
     * Eltünteti a felhőt/ködöt hogy le lehesse ellenőrizni a térképgenerálást bejárás nélkül.
     */
    @FXML
    private void kodeltuntetes() {
        Label label = new Label("");
        felho.getChildren().setAll(label);
        for(int i=0;i<meret;++i) {
            for(int j=0;j<meret;++j) {
                felhomap[i][j]=1;
            }
        }
    }

    /**
     * A feltöltött fájl-ból generál egy térképet.
     */
    public void mapbolvasas() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Nyisd meg a térképet tartalmazó txt fájlt");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Txt fájlok", "*.txt")
        );
        File openedmap = fileChooser.showOpenDialog(stage);
        if(openedmap != null) {
            try {
                Scanner scanner = new Scanner(openedmap);
                int mapmeret = scanner.nextInt();
                if(mapmeret<10 || mapmeret>20) {
                    mapbeolvas.setText("Térképméret nem megfelelő!");
                    return;
                }
                int[][] scanneltmap = new int[mapmeret][mapmeret];
                for (int i=0;i<mapmeret;i++) {
                    for(int j=0;j<mapmeret;j++) {
                        scanneltmap[i][j] = scanner.nextInt();
                    }
                }
                amap = new Map(mapmeret);
                amap.setMap(scanneltmap);
                this.meret=mapmeret;
                amap.setMapmeret(meret);
                mozgas = new Mozgas(amap,meret);
                mapkirajzolas();
                felhomapgen();
                felho();
                startgame.setVisible(true);
            } catch (FileNotFoundException e) {
                mapbeolvas.setText("Mapbeolvasas sikertelen!");
            }
        } else {mapbeolvas.setText("Mapbeolvasas sikertelen!");}


    }

    //<editor-fold defaultstate="collapsed" desc="mapkirajzolas">

    /**
     * A térképből legenerálja a GUI-n látható térképet.
     * (Gui... pls ne vonj le ezért pontot mert hosszu :( )
     */
    private void mapkirajzolas() {


        int[][] map = amap.getMap();

        Label label = new Label("");
        grid.getChildren().setAll(label);

        for (int x = 0; x < meret; x++){
            for (int y = 0; y < meret; y++){
                switch (map[x][y]) {
                    case 0 :
                    case 3 : {
                        ImageView viz = new ImageView();
                        viz.setImage(viz0);
                        viz.setFitHeight(780.0/meret);
                        viz.setFitWidth(780.0/meret);
                        grid.add(viz, y, x);
                        break;
                    }
                    case 1 : {
                        ImageView fold = new ImageView();
                        fold.setImage(fold0);
                        fold.setFitHeight(780.0/meret);
                        fold.setFitWidth(780.0/meret);
                        grid.add(fold, y, x);
                        break;
                    }
                    case 2 : {
                        ImageView hajo = new ImageView();
                        hajo.setImage(hajo0);
                        hajo.setFitHeight(780.0/meret);
                        hajo.setFitWidth(780.0/meret);
                        grid.add(hajo, y, x);
                        break;
                    }
                    case 4 : {
                        ImageView jungle = new ImageView();
                        jungle.setImage(jungle0);
                        jungle.setFitHeight(780.0/meret);
                        jungle.setFitWidth(780.0/meret);
                        grid.add(jungle, y, x);
                        break;
                    }
                    case 5 : {
                        ImageView hegy = new ImageView();
                        hegy.setImage(hegy0);
                        hegy.setFitHeight(780.0/meret);
                        hegy.setFitWidth(780.0/meret);
                        grid.add(hegy, y, x);
                        break;
                    }
                    case 51 : {
                        ImageView vulkan = new ImageView();
                        vulkan.setImage(vulkan0);
                        vulkan.setFitHeight(780.0/meret);
                        vulkan.setFitWidth(780.0/meret);
                        grid.add(vulkan, y, x);
                        break;
                    }
                    case 6 : {
                        ImageView barlang = new ImageView();
                        barlang.setImage(barlang0);
                        barlang.setFitHeight(780.0/meret);
                        barlang.setFitWidth(780.0/meret);
                        grid.add(barlang, y, x);
                        break;
                    }
                    case 7 : {
                        ImageView oltar = new ImageView();
                        oltar.setImage(oltar0);
                        oltar.setFitHeight(780.0/meret);
                        oltar.setFitWidth(780.0/meret);
                        grid.add(oltar, y, x);
                        break;
                    }
                    case 79 : {
                        ImageView oltarv = new ImageView();
                        oltarv.setImage(oltar1);
                        oltarv.setFitHeight(780.0/meret);
                        oltarv.setFitWidth(780.0/meret);
                        grid.add(oltarv, y, x);
                        break;
                    }
                    case 8 : {
                        ImageView piramis = new ImageView();
                        piramis.setImage(piramis0);
                        piramis.setFitHeight(780.0/meret);
                        piramis.setFitWidth(780.0/meret);
                        grid.add(piramis, y, x);
                        break;
                    }
                    case 89 : {
                        ImageView piramisv = new ImageView();
                        piramisv.setImage(piramis1);
                        piramisv.setFitHeight(780.0/meret);
                        piramisv.setFitWidth(780.0/meret);
                        grid.add(piramisv, y, x);
                        break;
                    }
                    case 9 : {
                        ImageView vizes = new ImageView();
                        vizes.setImage(vizes0);
                        vizes.setFitHeight(780.0/meret);
                        vizes.setFitWidth(780.0/meret);
                        grid.add(vizes, y, x);
                        break;
                    }
                    case 10 : {
                        ImageView falu = new ImageView();
                        falu.setImage(falu0);
                        falu.setFitHeight(780.0/meret);
                        falu.setFitWidth(780.0/meret);
                        grid.add(falu, y, x);
                        break;
                    }
                    case 11 : {
                        ImageView lava = new ImageView();
                        lava.setImage(lava0);
                        lava.setFitHeight(780.0/meret);
                        lava.setFitWidth(780.0/meret);
                        grid.add(lava, y, x);
                        break;
                    }
                    case 12 : {
                        ImageView gejzir = new ImageView();
                        gejzir.setImage(gejzir0);
                        gejzir.setFitHeight(780.0/meret);
                        gejzir.setFitWidth(780.0/meret);
                        grid.add(gejzir, y, x);
                        break;
                    }
                }
            }
        }
    }
    //</editor-fold>

    /**
     * A hajó/felfedező körül eltünteti a felhőket.
     * @param a az első koordináta amin van a hajó/felfedező
     * @param b a második koordináta amin van a hajó/felfedező
     */
    void felhomapfrissit(int a,int b){
        felhomap[a][b]=9;
        felhomap[a][b-1]=1;
        if(b!=meret-1) {
            felhomap[a][b + 1] = 1;
            if(a!=0){
                felhomap[a - 1][b + 1] = 1;
            }
            if(a!=meret-1){
                felhomap[a + 1][b + 1] = 1;
            }
        }
        if(a!=0) {
            felhomap[a-1][b]=1;
            felhomap[a-1][b-1]=1;
        }
        if(a!=meret-1) {
            felhomap[a+1][b]=1;
            felhomap[a+1][b-1]=1;
        }
        if(csapat.vanexy("Felderítő") && b>1) {
            felhomap[a][b-2]=1;
            if(a<meret-2){felhomap[a+2][b-2]=1;}
            if(a<meret-1){felhomap[a+1][b-2]=1;}
            if(a>1){felhomap[a-2][b-2]=1;}
            if(a>0){felhomap[a-1][b-2]=1;}
        }
        if(csapat.vanexy("Felderítő") && b<meret-2) {
            felhomap[a][b+2]=1;
            if(a<meret-2){felhomap[a+2][b+2]=1;}
            if(a<meret-1){felhomap[a+1][b+2]=1;}
            if(a>1){felhomap[a-2][b+2]=1;}
            if(a>0){felhomap[a-1][b+2]=1;}
        }
        if(csapat.vanexy("Felderítő") && a>1) {
            felhomap[a-2][b]=1;
            if(b<meret-1){felhomap[a-2][b+1]=1;}
            felhomap[a-2][b-1]=1;
        }
        if(csapat.vanexy("Felderítő") && a<meret-2) {
            felhomap[a+2][b]=1;
            if(b<meret-1){felhomap[a+2][b+1]=1;}
            felhomap[a+2][b-1]=1;
        }
    }

    /**
     * Megkeresi hogy hol van a hajó a játék elején és meghívja a felhofrissit()-et a koordinátáival.
     * Minden mást felhővé alakít.
     */
    public void felhomapgen() {
    felhomap= new int[meret][meret];
    int[][] map= amap.getMap();
    for (int a = 0; a < meret; ++a) {
        for (int b = 0; b < meret; ++b) {
            if(felhomap[a][b]!=1){felhomap[a][b]=2;}
            if(map[a][b]==2) {
                felhomapfrissit(a,b);
            }
        }
    }
}
    /**
     * A GUI-n látható felhőket jeleníti meg.
     */
    public void felho() {
    Label label = new Label("");
    felho.getChildren().setAll(label);

    for (int x = 0; x < meret; x++) {
        for (int y = 0; y < meret; y++) {
            if(felhomap[x][y]==1) {
                ImageView semmi = new ImageView();
                semmi.setImage(semmi0);
                semmi.setFitHeight(780.0 / meret);
                semmi.setFitWidth(780.0 / meret);
                this.felho.add(semmi, y, x);
            }
            if(felhomap[x][y]==2) {
                ImageView felho = new ImageView();
                felho.setImage(felho0);
                felho.setFitHeight(780.0 / meret);
                felho.setFitWidth(780.0 / meret);
                this.felho.add(felho, y, x);
            }
            if(felhomap[x][y]==9) {
                ImageView fohos = new ImageView();
                fohos.setImage(fohos0);
                fohos.setFitHeight(780.0 / meret);
                fohos.setFitWidth(780.0 / meret);
                this.felho.add(fohos, y, x);
            }
        }
    }
}
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Mozgás">

    /**
     * Érzékeli ha megnyomsz egy gombot és ennek megfelelően meghívja abba az irányba a mozgásokat.
     */
    @FXML
    public void gomblenyomas(KeyEvent event) {
        if (event.getCode().equals(KeyCode.W)) {
            fellep();
        } else if (event.getCode().equals(KeyCode.S)) {
            lelep();
        }else if (event.getCode().equals(KeyCode.D)) {
            jobbralep();
        }else if (event.getCode().equals(KeyCode.A)) {
            balralep();
        }
    }

    /**
     * Ha 0 energián vagy ez sorsol arra hogy elhagyja-e valaki a csapatot.
     */
    private void energiaelfogy() {
        visszajelzeslabel.setText(csapat.removemember(8,0));
        if(!csapat.vanexy("Felfedező")) {
            lose.setVisible(true);
            fomenu.setVisible(true);
            mappane.setVisible(false);
        }
    }

    /**
     * A felfelé (W) lépést valósítja meg.
     */
    @FXML
    public void fellep(){
        int[][] map= amap.getMap();
        int x = mozgas.getPositionx()-1;
        int y = mozgas.getPositiony();
        if(x>-1) {
                if (map[x][y] != 0 && map[x][y] != 5 && map[x][y] != 3 && map[x][y] != 6) {
                    mozgas.fellep(felhomap, csapat.vanexy("Felderítő"));
                    lepes(x, y);
                }else if (map[x][y] == 6) {barlang(map,x,y);}
        }
    }
    /**
     * A lefelé (S) lépést valósítja meg.
     */
    @FXML
    public void lelep(){
        int x = mozgas.getPositionx()+1;
        int y = mozgas.getPositiony();
        int[][] map= amap.getMap();
        if(x<amap.getMapmeret()) {
            if (map[x][y] != 0 && map[x][y] != 5 && map[x][y] != 3 && map[x][y] != 6) {
                mozgas.lelep(felhomap, csapat.vanexy("Felderítő"));
                lepes(x, y);
            }else if (map[x][y] == 6) {barlang(map,x,y);}
        }
    }

    /**
     * A jobbra (D) lépést valósítja meg.
     */
    @FXML
    public void jobbralep(){
        int x = mozgas.getPositionx();
        int y = mozgas.getPositiony()+1;
        int[][] map= amap.getMap();
        if(y<amap.getMapmeret()) {
            if (map[x][y] != 0 && map[x][y] != 5 && map[x][y] != 3 && map[x][y] != 6) {
                mozgas.jobbralep(felhomap, csapat.vanexy("Felderítő"));
                lepes(x, y);
            }else if (map[x][y] == 6) {barlang(map,x,y);}
        }
    }

    /**
     * A balra (A) lépést valósítja meg.
     */
    @FXML
    public void balralep(){
        int x = mozgas.getPositionx();
        int y = mozgas.getPositiony()-1;
        int[][] map= amap.getMap();
        if(y>-1) {
            if (map[x][y] != 0 && map[x][y] != 5 && map[x][y] != 3 && map[x][y] != 6) {
                mozgas.balralep(felhomap, csapat.vanexy("Felderítő"));
                lepes(x, y);
            }else if (map[x][y] == 6) {barlang(map,x,y);}
        }
    }

    /**
     * Általános lépés ami minden lépésnél ugyan az.
     * A irányba lépések hívják meg.
     */
    void lepes(int x,int y){
        lavaoregszik();
        lavaterjed();
        gejzirterjed();
        visszajelzeslabel.setText("");
        int[][] map= amap.getMap();
            felho();
            energia.lepes(map,x,y, inventory,csapat.vanexy("Szamár"),csapat.meret());
            if(energia.getEnergia()==0) energiaelfogy();
            if(map[x][y] == 7 || map[x][y]==79) {
                amap.viszonycsokken(2);
                inventory.noveles("Kincs",1);
                visszajelzeslabel.setText("Kaptál egy kincset!");
                if(map[x][y]==7) {
                    map[x][y] = 1;
                } else {map[x][y]=9;}
                atok();
                amap.setMap(map);
            }
            if(map[x][y] == 8 || map[x][y]==89) {
                hirnev+=1000;
                if(map[x][y]==8) map[x][y]=1;
                else map[x][y]=9;
                amap.setMap(map);
            }
            if(map[x][y] == 10) falumegjelenites(amap.getfalu(x,y));
            if(map[x][y] == 2) hajoralep();
            if(map[x][y] == 11) {
                energia.removeen(50);
                if(energia.getEnergia()==0) energiaelfogy();
            }
            csapat.serultelhagy();
            if(csapat.meret()!=0)visszajelzeslabel.setText(csapat.fuggokilep());
            if(!csapat.vanexy("Felfedező")) {
                lose.setVisible(true);
                fomenu.setVisible(true);
                mappane.setVisible(false);
        }

        mapkirajzolas();
        guifrissit();
    }

    /**
     * Ez kezeli le, hogy ha barlangra lépsz mi történjen.
     */
    void barlang(int[][] map,int x, int y) {
        visszajelzeslabel.setText("Kaptál egy kincset!");
        if(!inventory.vane("Fáklya") && random.Boolean(65)){
            katasztrofa();
        }
        if(inventory.vane("Fáklya")){
            inventory.csokkentes("Fáklya",1);
            visszajelzeslabel.setText("Elhasználtál egy fáklyát!");
        }
        inventory.noveles("Kincs",1);
        energia.lepes(map,x,y, inventory,csapat.vanexy("Szamár"),csapat.meret());
        map[x][y]=5;
        amap.setMap(map);
        mapkirajzolas();
        guifrissit();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Falu">
    private Falu jelenlegifalu;
    /**
     * A falu GUI-t jeleníti meg.
     */
    public void falumegjelenites(Falu falu){
        jelenlegifalu=falu;
        kabitovasarlas.setDisable(false);
        kotelvasarlas.setDisable(false);
        faklyavasarlas.setDisable(false);
        gyumolcsvasarlas.setDisable(false);
        husvasarlas.setDisable(false);
        grid.setDisable(true);
        felho.setDisable(true);
        ingamepane.setDisable(true);
        falupane.setVisible(true);
        kotelmennyiseg.setText(String.valueOf(falu.getKotel()));
        faklyamennyiseg.setText(String.valueOf(falu.getFaklya()));
        gyumolcsmennyiseg.setText(String.valueOf(falu.getGyumolcs()));
        husmennyiseg.setText(String.valueOf(falu.getHus()));
        kabitomennyiseg.setText(String.valueOf(falu.getKabitoszer()));
        if(falu.getKabitoszer()==0) {
            kabitovasarlas.setDisable(true);
        }
        if(falu.getKotel()==0) {
            kotelvasarlas.setDisable(true);
        }
        if(falu.getFaklya()==0) {
            faklyavasarlas.setDisable(true);
        }
        if(falu.getGyumolcs()==0) {
            gyumolcsvasarlas.setDisable(true);
        }
        if(falu.getHus()==0) {
            husvasarlas.setDisable(true);
        }
        kotelar.setText(csapat.vanexy("Kereskedő") ? "10" : "15");
        faklyaar.setText(csapat.vanexy("Kereskedő") ? "25" : "30");
        gyumolcsar.setText(csapat.vanexy("Kereskedő") ? "10" : "15");
        husar.setText(csapat.vanexy("Kereskedő") ? "20" : "25");
        kabitoar.setText(csapat.vanexy("Kereskedő") ? "15" : "20");
        if(!(Objects.equals(falu.getCsapattars().getNev(), "Nincs")) && amap.getViszony()>1) {
            falutarsbuy.setVisible(true);
            falutarsleiras.setVisible(true);
            falutarskep.setVisible(true);
            falutarsleiras.setText(falu.getCsapattars().getLeiras());
            switch (falu.getCsapattars().getNev()) {
                case "Felderítő" : {falutarskep.setImage(felderito);
                break;}
                case "Sámán" : {falutarskep.setImage(saman);
                break;}
                case "Bölcs" : {falutarskep.setImage(bolcs);
                break;}
            }
        } else {
            falutarsbuy.setVisible(false);
            falutarsleiras.setVisible(false);
            falutarskep.setVisible(false);
        }
    }
    /**
     * Ha meg akarod venni a csapattársat ez kezeli le.
     */
    @FXML
    public void falutarsbuy(){
        if(csapat.vanexy(jelenlegifalu.getCsapattars().getNev())) {
            falutarsleiras.setText("Van már ilyen a csapatodban!"); return;}
        if(csapat.meret()>3) {
            falutarsleiras.setText("Nem lehet több csapattársad!"); return;}
        if(arany<150) {
            falutarsleiras.setText("Nincs elég pénzed!"); return;}

        csapat.addmember(jelenlegifalu.getCsapattars().getNev());
        arany-=150;

        if(Objects.equals(jelenlegifalu.getCsapattars().getNev(), "Felderítő")) {
            felhomapfrissit(mozgas.getPositionx(), mozgas.getPositiony());
            felho();
        }

        jelenlegifalu.deleteCsapattars();
        guifrissit();
        falumegjelenites(jelenlegifalu);
    }
    /**
     * Ha ki akarsz lépni a faluból ez tünteti el a GUI-ról.
     */
    @FXML
    public void kilepesafalubol(){
        grid.setDisable(false);
        felho.setDisable(false);
        ingamepane.setDisable(false);
        falupane.setVisible(false);
        guifrissit();
    }
    /**
     * Kötél vásárlás gomb lekezelője.
     */
    @FXML
    public void kotelvasarlas() {
        int ar=Integer.parseInt(kotelar.getText());
        if(ar>arany) {
            System.out.println("nincs elég pénzed");
        } else {
            arany-=ar;
            inventory.noveles("Kötél",1);
            jelenlegifalu.setKotel(jelenlegifalu.getKotel()-1);
            falumegjelenites(jelenlegifalu);
        }
    }
    /**
     * fáklya vásárlás gomb lekezelője.
     */
    @FXML
    public void faklyavasarlas() {
        int ar=Integer.parseInt(faklyaar.getText());
        if(ar>arany) {
            System.out.println("nincs elég pénzed");
        } else {
            arany-=ar;
            inventory.noveles("Fáklya",1);
            jelenlegifalu.setFaklya(jelenlegifalu.getFaklya()-1);
            falumegjelenites(jelenlegifalu);
        }
    }
    /**
     * gyümölcs vásárlás gomb lekezelője.
     */
    @FXML
    public void gyumolcsvasarlas() {
        int ar=Integer.parseInt(gyumolcsar.getText());
        if(ar>arany) {
            System.out.println("Nincs elég pénzed");
        } else {
            arany-=ar;
            inventory.noveles("Gyümölcs",1);
            jelenlegifalu.setGyumolcs(jelenlegifalu.getGyumolcs()-1);
            falumegjelenites(jelenlegifalu);
        }
    }
    /**
     * hús vásárlás gomb lekezelője.
     */
    @FXML
    public void husvasarlas() {
        int ar=Integer.parseInt(husar.getText());
        if(ar>arany) {
            System.out.println("nincs elég pénzed");
        } else {
            arany-=ar;
            inventory.noveles("Hús",1);
            jelenlegifalu.setHus(jelenlegifalu.getHus()-1);
            falumegjelenites(jelenlegifalu);
        }
    }
    /**
     * Kábítószer vásárlás gomb lekezelője.
     */
    @FXML
    public void kabitovasarlas() {
        int ar=Integer.parseInt(kabitoar.getText());
        if(ar>arany) {
            System.out.println("nincs elég pénzed");
        } else {
            arany-=ar;
            inventory.noveles("Kábítószer",1);
            jelenlegifalu.setKabitoszer(jelenlegifalu.getKabitoszer()-1);
            falumegjelenites(jelenlegifalu);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Kikötő">
    /**
     * Két küldetés közötti boltot, kikőtőt jeleníti meg a GUI-n.
     */
    public void kikotomegjelenites() {
        kkmennyi.setText(String.valueOf(kikoto.getKotel()));
        kfmennyi.setText(String.valueOf(kikoto.getFaklya()));
        kbmennyi.setText(String.valueOf(kikoto.getBozotvago()));
        khmennyi.setText(String.valueOf(kikoto.getHus()));
        kumennyi.setText(String.valueOf(kikoto.getGolyo()));
        kcsmennyi.setText(String.valueOf(kikoto.getCsoki()));
        kwmennyi.setText(String.valueOf(kikoto.getWhiskey()));
        if (kikoto.getWhiskey() == 0) kikotowhiskey.setDisable(true);
        if (kikoto.getFaklya() == 0) kikotofaklya.setDisable(true);
        if (kikoto.getBozotvago() == 0) kikotobozot.setDisable(true);
        if (kikoto.getHus() == 0) kikotohus.setDisable(true);
        if (kikoto.getGolyo() == 0) kikotogolyo.setDisable(true);
        if (kikoto.getCsoki() == 0) kikotocsoki.setDisable(true);
        if (kikoto.getKotel() == 0) kikotokotel.setDisable(true);
        kkar.setText(csapat.vanexy("Kereskedő") ? "10" : "15");
        kfar.setText(csapat.vanexy("Kereskedő") ? "25" : "30");
        kbar.setText(csapat.vanexy("Kereskedő") ? "5" : "10");
        khar.setText(csapat.vanexy("Kereskedő") ? "20" : "25");
        kuar.setText(csapat.vanexy("Kereskedő") ? "15" : "20");
        kcsar.setText(csapat.vanexy("Kereskedő") ? "20" : "25");
        kwar.setText(csapat.vanexy("Kereskedő") ? "15" : "20");
        kikotopenz.setText("Pénzed: " + arany +" Arany");
    }

    /**
     * A kikötőben való kötél vásárlás gomb kezelője.
     */
    @FXML
    void kikotokotel(){
        int ar=Integer.parseInt(kkar.getText());
        if(ar<=arany){
            arany-=ar;
            inventory.noveles("Kötél",1);
            kikoto.setKotel(kikoto.getKotel()-1);
            kikotomegjelenites();
        }
    }
    /**
     * A kikötőben való faklya vásárlás gomb kezelője.
     */
    @FXML
    void kikotofaklya(){
        int ar=Integer.parseInt(kfar.getText());
        if(ar<=arany){
            arany-=ar;
            inventory.noveles("Fáklya",1);
            kikoto.setFaklya(kikoto.getFaklya()-1);
            kikotomegjelenites();
        }
    }
    /**
     * A kikötőben való Bozótvágó vásárlás gomb kezelője.
     */
    @FXML
    void kikotobozot(){
        int ar=Integer.parseInt(kbar.getText());
        if(ar<=arany){
            arany-=ar;
            inventory.noveles("Bozótvágó",1);
            kikoto.setBozotvago(kikoto.getBozotvago()-1);
            kikotomegjelenites();
        }
    }
    /**
     * A kikötőben való hús vásárlás gomb kezelője.
     */
    @FXML
    void kikotohus(){
        int ar=Integer.parseInt(khar.getText());
        if(ar<=arany){
            arany-=ar;
            inventory.noveles("Hús",1);
            kikoto.setHus(kikoto.getHus()-1);
            kikotomegjelenites();
        }
    }
    /**
     * A kikötőben való üveggolyó vásárlás gomb kezelője.
     */
    @FXML
    void kikotogolyo(){
        int ar=Integer.parseInt(kuar.getText());
        if(ar<=arany){
            arany-=ar;
            inventory.noveles("Üveggolyó",1);
            kikoto.setGolyo(kikoto.getGolyo()-1);
            kikotomegjelenites();
        }
    }
    /**
     * A kikötőben való Whiskey vásárlás gomb kezelője.
     */
    @FXML
    void kikotowhiskey(){
        int ar=Integer.parseInt(kwar.getText());
        if(ar<=arany){
            arany-=ar;
            inventory.noveles("Whiskey",1);
            kikoto.setWhiskey(kikoto.getWhiskey()-1);
            kikotomegjelenites();
        }
    }
    /**
     * A kikötőben való csokoládé vásárlás gomb kezelője.
     */
    @FXML
    void kikotocsoki() {
        int ar = Integer.parseInt(kcsar.getText());
        if (ar <= arany) {
            arany -= ar;
            inventory.noveles("Csokoládé", 1);
            kikoto.setCsoki(kikoto.getCsoki() - 1);
            kikotomegjelenites();
        }
    }
    /**
     * Kikötő elhagyásáért felelős gomb.
     */
        @FXML
    void leavekikoto(){
        kikotobolt.setVisible(false);
        if(kuldetes==5){
            folytatas.setVisible(false);
            jatekvege.setVisible(true);
            ranglistalabel.setText("Végső Ranglista");
        }else {
            folytatas.setVisible(true);
            jatekvege.setVisible(false);
            ranglistalabel.setText("Jelenlegi Ranglista");
        }
        ranglistacalc();
        ranglista.setVisible(true);
    }

    //</editor-fold>

    /**
     * Az egész GUI-t lefrissíti ami változó adatokat tartalmaz.
     */
    public void guifrissit(){
    List<String> itemek = inventory.getItemek();
    List<Integer> mennyiseg = inventory.getMennyiseg();
    List<Integer> slot = inventory.getSlot();
    int extraslot = inventory.slotokmennyisege()-(csapat.vanexy("Szamár") ? 10 : 8);
    StringBuilder szoveg= new StringBuilder("Inventory:(" + (csapat.vanexy("Szamár") ? "10" : "8")+" Slot)\n" + Math.round(Math.pow(1.2, Math.max(0, extraslot))*100.0)/100.0 + "-szoros az energiaköltség.\n\n");
    int sorok=0;
    for(int i=0;i<itemek.size();i++){
        if(sorok>25) {
            szoveg.append("...");
            break;
        }
        int x=slot.get(i);
        if(x==1) {
            szoveg.append(itemek.get(i)).append(" : ").append(mennyiseg.get(i)).append("db\n");
        } else {
            while (x > 1) {
                if(!itemek.get(i).equals("Kincs")){
                szoveg.append(itemek.get(i)).append(" : ").append(7).append("db\n");
                } else {
                    szoveg.append(itemek.get(i)).append(" : ").append(1).append("db\n");
                }
                x--;
                sorok++;
            }
            if(!itemek.get(i).equals("Kincs")) {
                szoveg.append(itemek.get(i)).append(" : ").append(mennyiseg.get(i) - ((slot.get(i) - 1) * 7)).append("db\n");
            } else {
                szoveg.append(itemek.get(i)).append(" : ").append(mennyiseg.get(i) - ((slot.get(i) - 1))).append("db\n");
            }
        }
        sorok++;
    }
    inventorylabel.setText(szoveg.toString());
    szoveg.delete(0,szoveg.length());
    szoveg.append("A Csapat:\nEnergia költség: ").append(Math.round(Math.pow(1.2, Math.max(0, csapat.meret())) * 100.0) / 100.0).append("-szoros\n\n");
    for(Emberek ember : csapat.getEmberek()) {
        szoveg.append(ember.getNev()).append(ember.fuggoe() ? " Függő":"").append(ember.isLeserult() ? " Sérült":"").append("\n");
    }
    csapatlabel.setText(szoveg.toString());
    eatcsoki.setDisable(tudeenni("Csokoládé"));
    eatgyum.setDisable(tudeenni("Gyümölcs"));
    eathus.setDisable(tudeenni("Hús"));
    eatkabito.setDisable(tudeenni("Kábítószer"));
    eatkabito.setText("Kábítószer" + (csapat.vanexy("Sámán") ? "(+24)" : "(+20)"));
    eatwhiskey.setDisable(tudeenni("Whiskey"));
    eatwhiskey.setText("Whiskey" + (csapat.vanexy("Katona") ? "(+24)" : "(+20)"));
    energylabel.setText("Energia: " + (Math.round(energia.getEnergia()*100.0)/100.0) + " Viszony: " + amap.getViszony());
    aranylabel.setText(arany + " Aranyad van");
    aranylabel1.setText(arany + " Aranyad van");
}

    //<editor-fold defaultstate="collapsed" desc="Táplálkozás">
    /**
     * Az nézi meg, hogy van-e az adott kajádból.
     * @param kaja az adott kaja.
     */
private boolean tudeenni(String kaja) {
        return !inventory.vane(kaja);
}

    /**
     * Gyümölcs elfogyasztásáért felelős gombot kezeli.
     */
@FXML
public void eatgyum(){
        inventory.csokkentes("Gyümölcs",1);
        energia.adden(15);
        csapat.setLegutobbikaja("Gyümölcs");
        guifrissit();}
    /**
     * Hús elfogyasztásáért felelős gombot kezeli.
     */
@FXML
public void eathus(){
        inventory.csokkentes("Hús",1);
        energia.adden(25);
        csapat.setLegutobbikaja("Hús");
        guifrissit();}
    /**
     * Csoki elfogyasztásáért felelős gombot kezeli.
     */
@FXML
public void eatcsoki(){
        inventory.csokkentes("Csokoládé",1);
        energia.adden(20);
        csapat.setLegutobbikaja("Csokoládé");
        csapat.fuggokivaltas();
        guifrissit();}
    /**
     * Kábítószer elfogyasztásáért felelős gombot kezeli.
     */
@FXML
public void eatkabito(){
        inventory.csokkentes("Kábítószer",1);
        energia.adden((csapat.vanexy("Sámán") ? 20*1.2 : 20));
        if(Objects.equals(csapat.getLegutobbikaja(), "Kábítószer")) {
            csapat.fuggo("k"); }
        csapat.setLegutobbikaja("Kábítószer");
        guifrissit();}
    /**
     * Whiskey elfogyasztásáért felelős gombot kezeli.
     */
@FXML
public void eatwhiskey(){
        inventory.csokkentes("Whiskey",1);
        energia.adden((csapat.vanexy("Katona") ? 20*1.2 : 20));
        if(Objects.equals(csapat.getLegutobbikaja(), "Whiskey")) {
            csapat.fuggo("w"); }
        csapat.setLegutobbikaja("Whiskey");
        guifrissit();}
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Katasztrofa es Atok">
    /**
     * Ha katasztrófa történik ez intézi el hogy mi történjen.
     */
    void katasztrofa(){
        String visszajel="";
        visszajel += csapat.leserul();
        visszajel += csapat.removemember(10,1);
        if(!csapat.vanexy("Felfedező")) {
            lose.setVisible(true);
            fomenu.setVisible(true);
            mappane.setVisible(false);
        }
        if(random.Boolean(70)){
            energia.removeen(45);
            visszajel+="Vesztettél 45 energiát!";
        }
        visszajelzeslabel.setText(visszajel);
    }
    /**
     * Ha átok következik be ez intézi el hogy mi történjen.
     */
    void atok() {
        int[][] map= amap.getMap();
        if(random.Boolean(35)){
            System.out.println("Vulkán");
            int legkozelebbix=0;
            int legkozelebbiy=0;
            int mintav=100;
            for(int x=0;x<meret;x++){
                for(int y=0;y<meret;y++) {
                    if(map[x][y]==5 && mintav>Math.abs(x-mozgas.getPositionx()) + Math.abs(y-mozgas.getPositiony())) {
                        mintav=Math.abs(x-mozgas.getPositionx()) + Math.abs(y-mozgas.getPositiony());
                        legkozelebbix=x;
                        legkozelebbiy=y;
                    }
                }
            }
            if(legkozelebbix!=0 && legkozelebbiy!=0) {
                map[legkozelebbix][legkozelebbiy] = 51;
                amap.setMap(map);
                lavalerak(legkozelebbix, legkozelebbiy);
                guifrissit();
            }
        } else {
            System.out.println("gejzir");
            gejzir();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Lava">
    /**
     * Ha átok miatt vulkán lesz, ez rakja le oda a lávát
     * @param a a vulkán első koordinátája
     * @param b a vulkán második koordinátája
     */
    private void lavalerak(int a, int b){
        lavaterjed2(a,b-1);
        if(b!=meret-1) {
            lavaterjed2(a, b + 1);
            if (a != 0) {
                lavaterjed2(a - 1, b + 1);
            }
                if (a != meret - 1) {
                    lavaterjed2(a + 1, b + 1);
                }
            }

        if(a!=0) {
            lavaterjed2(a - 1, b);
            lavaterjed2(a - 1, b - 1);
        }
        if(a!=meret-1) {
            lavaterjed2(a+1,b-1);
            lavaterjed2(a+1,b);
        }
    }

    /**
     * A tényleges lávának a lerakását/ terjedésést intéző függvény.
     * @param a ahova terjed első koordinátája
     * @param b ahova terjed második koordinátája
     */
    private void lavaterjed2(int a,int b){
        int[][] map=amap.getMap();
        boolean vanvulkan=false;

        for(int x=Math.max(a-3,0);x<Math.min(meret,a+4);x++){
            for(int y=Math.max(b-3,0);y<Math.min(meret,b+4);y++) {
                if (map[x][y] == 51) {
                    vanvulkan = true;
                    break;
                }
            }}
        if(map[a][b]!=0 && map[a][b]!=3 && map[a][b]!=2 && map[a][b]!=5 && map[a][b]!=6 && vanvulkan && map[a][b]!=51 && map[a][b]!=11){
            Lava lava=new Lava(a,b,map[a][b],0);
            lavak.add(lava);
            map[a][b]=11;
            amap.setMap(map);
        }
    }
    /**
     * Minden körben terjed a láva 4 irányba, ezt intézi.
     */
    private void lavaterjed() {
        for (int a = 0; a < meret; ++a) {
            for (int b = 0; b < meret; ++b) {

                if (getlava(a, b)!=null) {
                    if (Objects.requireNonNull(getlava(a, b)).getMiotalava() == 1) {
                        lavaterjed2(a, b - 1);
                        if (b != meret - 1) {
                            lavaterjed2(a, b + 1);
                        }

                        if (a != 0) {
                            lavaterjed2(a - 1, b);
                        }
                        if (a != meret - 1) {
                            lavaterjed2(a + 1, b);
                        }
                    }
                }
            }
        }
    }
    /**
     * Számolja hogy mióta van kint egy bizonyos láva pont és meghíja a  meghallava-t
     */
    private void lavaoregszik(){
        for (Lava lava : lavak) {
                lava.setMiotalava(lava.getMiotalava()+1);
        }
        meghallava();
    }

    /**
     * Minden lávát ami több mint 4 lépés óta lenne ott eltünteti.
     */
    private void meghallava(){
        int[][] map=amap.getMap();
        for (int i=0;i<lavak.size();i++) {
            Lava lava= lavak.get(i);
            if(lava.getMiotalava()>4){
                if(lava.getMivolt()!=4) {
                    map[lava.getX()][lava.getY()] = lava.getMivolt();
                } else {
                    map[lava.getX()][lava.getY()] = 1;
                }
                amap.setMap(map);
                lavak.remove(lava);
                i--;
            }
        }
        if(lavak.size()==0){
            for(int i=0;i<meret;i++){
                for(int j=0;j<meret;j++){
                    if(map[i][j]==51){
                        map[i][j]=5;
                    }
                }
            }
            amap.setMap(map);
        }
    }
    /**
     * Lekérem a lávát ami az adott koordinátán van.
     * @param x adott első koordináta
     * @param y adott második koordináta
     */
    private Lava getlava(int x, int y) {
        for (Lava lava : lavak) {
            if (lava.getX() == x && lava.getY() == y) {
                return lava;
            }
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Gejzir">
    /**
     * A gejzír működéséért felelős.
     */
    void gejzir() {
        int[][] map= amap.getMap();

        whilet:
        while(true) {
            for (int x = Math.max(mozgas.getPositionx() - 1, 0); x < Math.min(meret, mozgas.getPositionx() + 2); x++) {
                for (int y = Math.max(mozgas.getPositiony() - 1, 0); y < Math.min(meret, mozgas.getPositiony() + 2); y++) {
                    if (random.Boolean(10) && (map[x][y]==1 || map[x][y]==9)) {
                        map[x][y] = 12;
                        gejzirek.add(new Gejzir(x,y,1));
                        break whilet;
                    }
                }
            }
        }
        gejzirterjed();
    }

    /**
     * A körökben terjed a gejzír minden irányba.
     */
    private void gejzirterjed(){
        int[][] map=amap.getMap();
        for(Gejzir gejzir:gejzirek) {
            for (int x = Math.max(gejzir.getX() - gejzir.getMiota(), 0); x < Math.min(meret, gejzir.getX() + gejzir.getMiota()+1); x++) {
                for (int y = Math.max(gejzir.getY() - gejzir.getMiota(), 0); y < Math.min(meret, gejzir.getY() + gejzir.getMiota()+1); y++) {
                    switch (map[x][y]) {
                        case 1 : {map[x][y] = 9;
                        break;}
                        case 7 : {map[x][y] = 79;
                        break;}
                        case 8 : {map[x][y] = 89;
                        break;}
                    }
                }
            }
            gejzir.setMiota(gejzir.getMiota()+1);
        }
        for(int i=0;i<gejzirek.size();i++){
            if(gejzirek.get(i).getMiota()>3){
                map[gejzirek.get(i).getX()][gejzirek.get(i).getY()]=9;
                amap.setMap(map);
                gejzirek.remove(gejzirek.get(i));
                i--;
            }
        }
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Hajó">
    /**
     * Lekezeli ha valaki rálép a hajó mezőre.
     */
    void hajoralep(){
        hajopane.setVisible(true);
        ingamepane.setDisable(true);
    }
    /**
     * Ha pihensz a hajóban feltölti az energiád.
     */
    @FXML
    void pihen() {
        energia.adden(100);
        guifrissit();
    }

    /**
     * Átállítja a GUI és a előkészíti azt, ha vége egy köüldetésnek.
     */
    @FXML
    void kuldetesvege(){
        kuldetes++;
        csapat.meggyogyul();
        hajopane.setVisible(false);
        energia = new Energia();
        lavak=new ArrayList<>();
        gejzirek=new ArrayList<>();
        mapgen();
        ingamepane.setVisible(false);
        mapsettings.setVisible(true);
        playernameinput.setDisable(true);
        mappane.setVisible(false);
        koztespane.setVisible(true);
        int index;
        int kincshajo=0;
        index=inventory.getItemek().indexOf("Kincs");
        if(index>-1){
        kincs = inventory.getMennyiseg().get(index);
        inventory.csokkentes("Kincs",kincs);}
        index=hajoinv.getItemek().indexOf("Kincs");
        if(index>-1){
        kincshajo = hajoinv.getMennyiseg().get(index);
        hajoinv.csokkentes("Kincs",kincshajo);}
        kincs+=kincshajo;
        kincskep.setImage(kincs0);
        kincsp();
    }

    /**
     * A hajóra való lepakolás gombot kezeli le.
     */
    @FXML
    void lepakol() {
        hajoinventorypane.setVisible(true);
        lepakolgomb.setVisible(true);
        felveszgomb.setVisible(false);
        ObservableList<String> itemek = FXCollections.observableArrayList(inventory.getItemek());
        hajochoice.setItems(itemek);
        hajoinventorydarab.setText("");
    }

    /**
     * A hajó inventorijának a megnyitását kezeli le.
     */
    @FXML
    void hajoinventorymegnyit(){
        hajoinventorypane.setVisible(true);
        lepakolgomb.setVisible(false);
        felveszgomb.setVisible(true);
        ObservableList<String> itemek = FXCollections.observableArrayList(hajoinv.getItemek());
        hajochoice.setItems(itemek);
        hajoinventorydarab.setText("");
    }
    /**
     * Ha kiválasztottál valamit, ez írja ki hogy mennyi van belőle.
     */
    @FXML
    void choiceclick(){
        if(hajochoice.getValue()!=null){
            if(lepakolgomb.isVisible()) {
                hajoinventorydarab.setText(inventory.getMennyiseg().get(inventory.getItemek().indexOf(hajochoice.getValue())) + " Darab");
            } else {
                hajoinventorydarab.setText(hajoinv.getMennyiseg().get(hajoinv.getItemek().indexOf(hajochoice.getValue())) + " Darab");
            }
        }
    }

    /**
     * A lepakolást végző gomb.
     */
    @FXML
    void lepakolgomb(){
        if(hajochoice.getValue()!=null) {
            hajoinv.noveles(hajochoice.getValue(), 1);
            inventory.csokkentes(hajochoice.getValue(), 1);
            if (Objects.equals(hajoinventorydarab.getText(), "1 Darab")) {
                lepakol();
            } else {
                choiceclick();
            }
            guifrissit();
        }
    }
    /**
     * Hajó inventorijából való kipakolást végzi.
     */
    @FXML
    void felveszgomb(){
        if(hajochoice.getValue()!=null) {
            hajoinv.csokkentes(hajochoice.getValue(), 1);
            inventory.noveles(hajochoice.getValue(), 1);
            if (!hajoinv.vane(hajochoice.getValue())) {
                hajoinventorymegnyit();
            } else {
                choiceclick();
            }
            guifrissit();
        }
    }
    /**
     * Hajóinventory/lepakolásból való kilépést intézi.
     */
    @FXML
    void inventoryvissza() {
        hajoinventorypane.setVisible(false);
    }
    /**
     * Ha a hajóból ki akarsz lépni és folytatni a játékot ez intézi.
     */
    @FXML
    void hajopanekilep(){
        hajopane.setVisible(false);
        ingamepane.setDisable(false);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Kincs">
    int kincs=0;

    /**
     * A kincsek eladásánál/ajándékozásánál írja ki hogy mennyi van még.
     * Ha már nincs átlép a kikötőbe.
     */
    void kincsp() {
        if(kincs>0) {
            kincsdarab.setText(kincs + " Darab");
        } else {
            kincspane.setVisible(false);
            kikotobolt.setVisible(true);
            kikotomegjelenites();
        }
    }

    /**
     * Kincs eladása gombot kezeli.
     */
    @FXML
    void kincselad(){
        arany+=100;
        kincs--;
        kincsp();
    }
    /**
     * A kincs elajndékozása gombot kezeli.
     */
    @FXML
    void kincsajandek(){
        hirnev+=100;
        kincs--;
        kincsp();
    }
    //</editor-fold>

    /**
     * Kiszámolja, hogy hol fogsz állni a ranglistában.
     */
    void ranglistacalc(){
        String[] nevek= new String[4];
        int[] pontok= new int[4];

        nevek[0]=playername + "(te)";
        nevek[1]="Józsibácsiaszomszédból";
        nevek[2]="Kinderkommandó";
        nevek[3]="PerselusPiton";
        pontok[0]=hirnev;
        pontok[1]=kuldetes*500;
        pontok[2]=kuldetes*1000;
        pontok[3]=kuldetes*1200;

        int temp;
        String temp2;
        for(int i = 0; i<4; i++ ){
            for(int j = i+1; j<4; j++){

                if(pontok[i]<pontok[j]){
                    temp = pontok[i];
                    pontok[i] = pontok[j];
                    pontok[j] = temp;
                    temp2 = nevek[i];
                    nevek[i] = nevek[j];
                    nevek[j] = temp2;
                }
            }
        }
        elso.setText("1. "+ nevek[0] + ": "+ pontok[0]);
        masodik.setText("2. "+ nevek[1] + ": "+ pontok[1]);
        harmadik.setText("3. "+ nevek[2] + ": "+ pontok[2]);
        negyedik.setText("4. "+ nevek[3] + ": "+ pontok[3]);
    }

    /**
     * A ranglista után a következő küldetésre visz.
     */
    @FXML
    void folytatas(){
        ranglista.setVisible(false);
        kincspane.setVisible(true);
        koztespane.setVisible(false);
        mappane.setVisible(true);
    }
    /**
     * A ragnlista után ha ez volt az utolsó küldetés a főmenübe dob.
     */
    @FXML
    void jatekvege(){
        ranglista.setVisible(false);
        kincspane.setVisible(true);
        koztespane.setVisible(false);
        fomenu.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}