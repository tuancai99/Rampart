module com.example.m1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m1 to javafx.fxml;
    exports com.example.m1;
}