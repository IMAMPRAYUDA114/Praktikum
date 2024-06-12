package com.example.modul6tugas.Gui;
import com.example.modul6tugas.Data.Admin;
import com.example.modul6tugas.Data.User;
import com.example.modul6tugas.com.main.Main;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddStudentScene {

    public static Scene getScene(Stage primaryStage) {
        VBox addStudent = new VBox(10);
        addStudent.setAlignment(javafx.geometry.Pos.CENTER);
        addStudent.setPadding(new javafx.geometry.Insets(20));

        Label nameLabel = new Label("Enter student name:");
        TextField nameField = new TextField();

        Label nimLabel = new Label("Enter student NIM (15 characters):");
        TextField nimField = new TextField();

        Label facultyLabel = new Label("Enter student faculty:");
        TextField facultyField = new TextField();

        Label programLabel = new Label("Enter student program:");
        TextField programField = new TextField();

        Button addBtn = new Button("Add Student");
        addBtn.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20;");

        Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20;");

        addStudent.getChildren().addAll(nameLabel, nameField, nimLabel, nimField, facultyLabel, facultyField,
                programLabel, programField, addBtn, backBtn);

        Scene scene = new Scene(addStudent, 500, 350);

        addBtn.setOnAction(e -> {
            String name = nameField.getText();
            String nim = nimField.getText();
            String faculty = facultyField.getText();
            String program = programField.getText();
            if (nim.length() != 15) {
                showAlert(Alert.AlertType.ERROR, "Error", "NIM must be exactly 15 characters long.");
                return;
            }
            if (Main.admin.addStudent(name, nim, faculty, program)) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student added successfully!");
                primaryStage.setScene(AdminMenuScene.getScene(primaryStage));
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to add student.");
            }
        });

        backBtn.setOnAction(e -> {
            primaryStage.setScene(AdminMenuScene.getScene(primaryStage));
        });

        return scene;
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
