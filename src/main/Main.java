package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Kötprog Programozás 1. 5. feladata.
 * @author Simon Dániel
 * @version 1.0
 */
public class Main extends Application {



    /**
     * Elindítja a GUI-t.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("gui.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("The Peculiar Expedition");
        primaryStage.setScene(new Scene(root, 1600, 900));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:kepek\\2.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
