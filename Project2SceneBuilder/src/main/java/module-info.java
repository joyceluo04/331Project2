module com.example.project2scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;
    requires java.sql;

    opens com.example.project2scenebuilder to javafx.fxml;
    exports com.example.project2scenebuilder;
}