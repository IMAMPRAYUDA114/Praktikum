package com.example.modul6tugas.Gui;

import com.example.modul6tugas.Data.User;
import com.example.modul6tugas.com.main.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentLoginScene {

    public static Scene getScene(Stage primaryStage) {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        // Menambahkan logo/ikon
        ImageView imageView = new ImageView(new Image("https://cdn-icons-png.flaticon.com/512/8004/8004092.png"));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // Title
        Label titleLabel = new Label("Login Student");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-text-fill: #333;");

        // NIM
        Label nimLabel = new Label("Enter your NIM (15 characters):");
        TextField nimField = new TextField();
        nimField.setStyle(
                "-fx-padding: 10; " +
                        "-fx-border-color: #ccc; " +
                        "-fx-border-radius: 5px;");

        // Login button dengan efek hover
        Button loginBtn = new Button("Login");
        loginBtn.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;");
        loginBtn.setOnMouseEntered(e -> loginBtn.setStyle(
                "-fx-background-color: #48D1CC; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));
        loginBtn.setOnMouseExited(e -> loginBtn.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));

        // Back button dengan efek hover
        Button backButton = new Button("Back");
        backButton.setStyle(
                "-fx-background-color: #DC143C; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;");
        backButton.setOnMouseEntered(e -> backButton.setStyle(
                "-fx-background-color: #455A64; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));
        backButton.setOnMouseExited(e -> backButton.setStyle(
                "-fx-background-color: #DC143C; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));

        layout.getChildren().addAll(imageView, titleLabel, nimLabel, nimField, loginBtn, backButton);

        Scene scene = new Scene(layout, 300, 600);

        loginBtn.setOnAction(e -> {
            String nim = nimField.getText();
            if (nim.length() != 15) {
                showAlert(Alert.AlertType.ERROR, "Error", "NIM must be exactly 15 characters long.");
            } else if (Main.checkNim(nim)) {
                User user = Main.getUser(nim);
                if (user != null) {
                    showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + user.getName() + "! You are now logged in as a student.");
                    primaryStage.setScene(StudentMenuScene.getScene(primaryStage, user));
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "User not found");
                }
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid NIM");
            }
        });

        backButton.setOnAction(e -> {
            primaryStage.setScene(LibraryApp.getMainScene(primaryStage));
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
