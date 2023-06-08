package vue;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * cette classe permet de présenter le choix du scenario à consulter elle contient une VBox contenant une Table View
 */
public class TableChoixScenario extends VBox{
    //création de la tableview
    TableView <String> tableDesSolutions;

    //création de l'unique colonne de la table view
    TableColumn colonneScenario;

    public TableChoixScenario(){

        //instantiacion de la tableview et de la colonne
        tableDesSolutions = new TableView<>();
        colonneScenario = new TableColumn<String, String>("Scenario");
        colonneScenario.setCellValueFactory(new PropertyValueFactory<>("String"));

        //on ajuste la taille de la colonne
        colonneScenario.setMinWidth(300);

        //on ajoute la colonne à la tableview puis on réduite la taille minimum pour qu'elle en puisse pas etre ridiculement petite
        tableDesSolutions.getColumns().add(colonneScenario);
        tableDesSolutions.setMinWidth(100);

        //on ajoute le tout dans la VBox contenant la TableView
        this.getChildren().add(tableDesSolutions);
    }


}
