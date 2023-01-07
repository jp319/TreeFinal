module group_6.treefinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens group_6.treefinal to javafx.fxml;
    exports group_6.treefinal;
}