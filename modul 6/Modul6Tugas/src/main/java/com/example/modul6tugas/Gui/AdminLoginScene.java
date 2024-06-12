package com.example.modul6tugas.Gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminLoginScene {

    public static Scene getScene(Stage primaryStage) {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        // Menambahkan logo/ikon
        ImageView imageView = new ImageView(new Image("https://cdn-icons-png.flaticon.com/512/1838/1838308.png"));
        imageView.setFitWidth(100);

        // Title
        Label titleLabel = new Label("Login Admin");
        imageView.setFitHeight(100);
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-text-fill: #333;");

        // Username
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setStyle(
                "-fx-padding: 10; " +
                        "-fx-border-color: #ccc; " +
                        "-fx-border-radius: 5px;");

        // Password
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle(
                "-fx-padding: 10; " +
                        "-fx-border-color: #ccc; " +
                        "-fx-border-radius: 5px;");

        // Login button dengan efek hover
        Button loginButton = new Button("Login");
        loginButton.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;");
        loginButton.setOnMouseEntered(e -> loginButton.setStyle(
                "-fx-background-color: #48D1CC; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));
        loginButton.setOnMouseExited(e -> loginButton.setStyle(
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

        // Add components to the layout
        layout.getChildren().addAll(imageView, titleLabel, usernameLabel, usernameField, passwordLabel, passwordField, loginButton, backButton);

        Scene scene = new Scene(layout, 300, 600);

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            boolean loginSuccessful = validateAdminLogin(username, password);

            if (loginSuccessful) {
                // If login successful, pindah ke admin menu
                showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, Admin! You are now logged in as an admin.");
                primaryStage.setScene(AdminMenuScene.getScene(primaryStage));
            } else {
                // If login failed, pesan error
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password. Please try again.");
            }
        });

        backButton.setOnAction(e -> {
            primaryStage.setScene(LibraryApp.getMainScene(primaryStage));
        });

        return scene;
    }

    private static boolean validateAdminLogin(String username, String password) {
        String adminUsername = "admin";
        String adminPassword = "admin";

        return username.equals(adminUsername) && password.equals(adminPassword);
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
