module com.example.modul6tugas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens com.example.modul6tugas to javafx.fxml;
    opens com.example.modul6tugas.Gui to javafx.graphics; // Add this line
    exports com.example.modul6tugas;
    exports com.example.modul6tugas.Gui;
    exports com.example.modul6tugas.Data;
    exports com.example.modul6tugas.exception;
}