package vue;

import javafx.scene.layout.VBox;

/**
 * cette class instancie la racine de l'interface permettant l'affichage des éléments contenus
 */
public class VBoxRoot extends VBox {
    //création d'une HBox pour le titre
    private static HBoxTitle cadreTitre;

    //création d'une HBox contenant les différentes interaction avec les scenarios
    private static HBoxScenario cadreScenario;

    /**
     * constructeur de la racine 'VBoxRoot' pour l'interface
     */
    public VBoxRoot(){
        //instanciation des deux HBox
        cadreTitre = new HBoxTitle();
        cadreScenario = new HBoxScenario();

        //ajout des HBox à la VBoxRoot
        this.getChildren().addAll(cadreTitre, cadreScenario);

    }
}
