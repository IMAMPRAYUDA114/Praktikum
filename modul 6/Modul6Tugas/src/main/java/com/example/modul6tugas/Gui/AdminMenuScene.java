package com.example.modul6tugas.Gui;

import com.example.modul6tugas.com.main.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminMenuScene {

    public static Scene getScene(Stage primaryStage) {
        VBox adminMenu = new VBox(20);
        adminMenu.setAlignment(Pos.CENTER);
        adminMenu.setPadding(new Insets(20));

        // Menambahkan logo/ikon
        ImageView imageView = new ImageView(new Image("https://cdn-icons-png.flaticon.com/512/1156/1156356.png"));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // Button "Add Student" dengan efek hover
        Button addStudentBtn = new Button("Add Student");
        addStudentBtn.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;");
        addStudentBtn.setOnMouseEntered(e -> addStudentBtn.setStyle(
                "-fx-background-color: #48D1CC; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));
        addStudentBtn.setOnMouseExited(e -> addStudentBtn.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));

        // Button "Add Book" dengan efek hover
        Button addBookButton = new Button("Add Book");
        addBookButton.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;");
        addBookButton.setOnMouseEntered(e -> addBookButton.setStyle(
                "-fx-background-color: #48D1CC; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));
        addBookButton.setOnMouseExited(e -> addBookButton.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));

        // Button "Display Registered Students" dengan efek hover
        Button displayStudentsBtn = new Button("Display Registered Students");
        displayStudentsBtn.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;");
        displayStudentsBtn.setOnMouseEntered(e -> displayStudentsBtn.setStyle(
                "-fx-background-color: #48D1CC; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));
        displayStudentsBtn.setOnMouseExited(e -> displayStudentsBtn.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));

        // Button "Display Available Books" dengan efek hover
        Button displayBooksBtn = new Button("Display Available Books");
        displayBooksBtn.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;");
        displayBooksBtn.setOnMouseEntered(e -> displayBooksBtn.setStyle(
                "-fx-background-color: #48D1CC; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));
        displayBooksBtn.setOnMouseExited(e -> displayBooksBtn.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));

        // Button "Logout" dengan efek hover
        Button logoutBtn = new Button("Logout");
        logoutBtn.setStyle(
                "-fx-background-color: #DC143C; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;");
        logoutBtn.setOnMouseEntered(e -> logoutBtn.setStyle(
                "-fx-background-color: #455A64; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));
        logoutBtn.setOnMouseExited(e -> logoutBtn.setStyle(
                "-fx-background-color: #DC143C; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));

        adminMenu.getChildren().addAll(imageView, addStudentBtn, addBookButton, displayStudentsBtn, displayBooksBtn, logoutBtn);

        Scene scene = new Scene(adminMenu, 300, 600);

        addStudentBtn.setOnAction(e -> {
            primaryStage.setScene(AddStudentScene.getScene(primaryStage));
            showAlert(Alert.AlertType.INFORMATION, "Information", "You are now adding a student.");
        });
        addBookButton.setOnAction(e -> primaryStage.setScene(AddBookScene.getScene(primaryStage, Main.admin)));
        displayStudentsBtn.setOnAction(e -> {
            Main.admin.displayRegisteredStudents();
        });
        displayBooksBtn.setOnAction(e -> {
            Main.admin.displayBooks();
        });
        logoutBtn.setOnAction(e -> {
            primaryStage.setScene(LibraryApp.getMainScene(primaryStage));
            showAlert(Alert.AlertType.INFORMATION, "Information", "Logout successful.");
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
