package vue;

import javafx.scene.layout.HBox;

/**
 * cette class permet d'intégrer :
 *     - une table view offrant le choix du scenario à consulter
 *     - un gridpane présentant les informations des solutions du scenario sélectionné
 */
public class HBoxScenario extends HBox {
    //table view pour le choix du scenario
    private static TableChoixScenario choixScenario;

    //gridpane des ifnormations de solutions
    private static GridPaneScenario solutionsPane ;


    public HBoxScenario(){

        //instanciacion des contenant
        choixScenario = new TableChoixScenario();
        solutionsPane = new GridPaneScenario();

        //ajout des contenant
        this.getChildren().addAll(choixScenario, solutionsPane);
        this.setId("BoxScenario");
    }
}
