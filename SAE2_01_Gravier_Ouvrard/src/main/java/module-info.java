module com.example.sae2_01_gravier_ouvrard {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sae2_01_gravier_ouvrard to javafx.fxml;
    exports com.example.sae2_01_gravier_ouvrard;
}