module org.example.dama {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.dama to javafx.fxml;
    exports org.example.dama;
}