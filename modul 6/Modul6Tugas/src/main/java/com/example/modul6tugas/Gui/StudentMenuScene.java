package com.example.modul6tugas.Gui;

import com.example.modul6tugas.Data.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentMenuScene {

    public static Scene getScene(Stage primaryStage, User user) {
        VBox studentMenu = new VBox(20);
        studentMenu.setAlignment(Pos.CENTER);
        studentMenu.setPadding(new Insets(20));

        // Menambahkan logo/ikon
        ImageView imageView = new ImageView(new Image("https://path-to-your-image/logo.png"));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Button displayInfoBtn = new Button("Display Information");
        setButtonStyle(displayInfoBtn, "#2196F3", "#1976D2");

        Button showBorrowedBooksBtn = new Button("Show Borrowed Books");
        setButtonStyle(showBorrowedBooksBtn, "#FFC107", "#FFA000");

        Button borrowBookBtn = new Button("Borrow Book");
        setButtonStyle(borrowBookBtn, "#4CAF50", "#388E3C");

        Button returnBookBtn = new Button("Return Book");
        setButtonStyle(returnBookBtn, "#FF5722", "#E64A19");

        Button logoutBtn = new Button("Logout");
        setButtonStyle(logoutBtn, "#607D8B", "#455A64");

        studentMenu.getChildren().addAll(imageView, displayInfoBtn, showBorrowedBooksBtn, borrowBookBtn, returnBookBtn, logoutBtn);

        Scene scene = new Scene(studentMenu, 500, 450);

        displayInfoBtn.setOnAction(e -> {
            user.displayInfo();
        });

        showBorrowedBooksBtn.setOnAction(e -> {
            user.showBorrowedBooks();
        });

        borrowBookBtn.setOnAction(e -> {
            primaryStage.setScene(BorrowBookScene.getScene(primaryStage, user));
        });

        returnBookBtn.setOnAction(e -> {
            primaryStage.setScene(ReturnBookScene.getScene(primaryStage, user));
        });

        logoutBtn.setOnAction(e -> {
            showAlert(Alert.AlertType.INFORMATION, "Logout", "You have been logged out successfully.");
            primaryStage.setScene(LibraryApp.getMainScene(primaryStage));
        });

        return scene;
    }

    private static void setButtonStyle(Button button, String bgColor, String hoverColor) {
        button.setStyle(
                "-fx-background-color: " + bgColor + "; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;");
        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: " + hoverColor + "; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));
        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: " + bgColor + "; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px;"));
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
