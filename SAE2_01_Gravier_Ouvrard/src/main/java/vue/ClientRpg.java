package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

/**
 * cette clss va afficher l'interface permettant à l'utilisateur de pouvoir voir les solutions des différents scenarios
 */
public class ClientRpg extends Application{

    //création de la racine qui va contenir tout le reste

    public void start(Stage stage){
        //instanciation de la scene
        VBoxRoot root = new VBoxRoot();
        Scene scene = new Scene(root);

        //initialisation de la 'stage' qui va contenir la scene
        stage.setScene(scene);
        stage.setTitle("Solutions RPG");
        stage.setWidth(1500);
        stage.setHeight(575);
        stage.centerOnScreen();
        stage.show();

        //liaison au fichier style css
        File css = new File("css"+File.separator+"style_rpg.css");
        scene.getStylesheets().add(css.toURI().toString());
    }

    //lancement du programme
    public static void main (String [] args){
        Application.launch();
    }
}
