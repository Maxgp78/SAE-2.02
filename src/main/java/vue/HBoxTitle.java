package vue;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.TextAlignment;

public class HBoxTitle extends HBox {
    private Label title;

    private Button quitter;

    public HBoxTitle(){
        title = new Label("Solutions RPG");
        title.setId("titre");

        quitter = new Button("Quitter");

        this.setId("boxTitle");
        this.getChildren().addAll(quitter, title);
        this.setMargin(title, new Insets(0, 0, 10, 520));
        this.setMargin(quitter, new Insets(5, 0, 0, 5));



    }
}
