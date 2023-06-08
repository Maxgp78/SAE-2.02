package vue;

import javafx.geometry.Insets;
import javafx.scene.LightBase;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * cette classe affiche le grid pane des informations des solutions du scneario selcetionné par l'utilisateur
 */
public class GridPaneScenario extends GridPane {

    private static GridPane scenarioPane;

    public GridPaneScenario(){

        //initialisation du gridpane
        scenarioPane = new GridPane();
        setPadding(new Insets(40));
        setHgap(150);
        setVgap(7);
        setGridLinesVisible(false);

        //ajout de différents label
        Label labelTitreSolution = new Label("Solutions : ");
        this.add(labelTitreSolution, 0, 0, 1, 1);


        Label labelNbSolutions = new Label("Nombre de solutions :");
        this.add(labelNbSolutions, 0, 2, 1, 1);


        Label labelPriorite = new Label("Priorite :");
        this.add(labelPriorite, 3, 2, 1, 1);


        Label labelNum = new Label("Numéro");
        this.add(labelNum, 0, 4, 1, 1);


        Label labelSolution = new Label("Solutions");
        this.add(labelSolution, 1, 4, 3, 1);


        Label labelType = new Label("Type");
        this.add(labelType, 4,4, 1, 1);

        //ajout de separator dans le gridPane
        Separator line1 = new Separator();
        Separator line2 = new Separator();
        Separator line3 = new Separator();


        this.add(line1, 0,1, 5,1);
        this.add(line2, 0,3, 5,1);
        this.add(line3, 0,5, 5,1);



        //enfin on ajoute le tout à l'objet créé
        this.getChildren().add(scenarioPane);
    }
}
