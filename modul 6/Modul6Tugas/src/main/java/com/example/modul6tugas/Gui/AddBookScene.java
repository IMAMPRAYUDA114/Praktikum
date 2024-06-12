package com.example.modul6tugas.Gui;

import com.example.modul6tugas.Data.Admin;
import com.example.modul6tugas.Book.Book;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddBookScene {

    public static Scene getScene(Stage primaryStage, Admin admin) {
        VBox addBookLayout = new VBox(10);
        addBookLayout.setAlignment(javafx.geometry.Pos.CENTER);
        addBookLayout.setPadding(new javafx.geometry.Insets(20));

        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();

        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();

        Label categoryLabel = new Label("Category:");
        TextField categoryField = new TextField();

        Label stockLabel = new Label("Stock:");
        TextField stockField = new TextField();

        Label durationLabel = new Label("Duration:");
        TextField durationField = new TextField();

        Button addButton = new Button("Add Book");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20;");

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20;");

        addBookLayout.getChildren().addAll(titleLabel, titleField, authorLabel, authorField, categoryLabel, categoryField, stockLabel, stockField, durationLabel, durationField, addButton, backButton);

        Scene scene = new Scene(addBookLayout, 600, 400);

        addButton.setOnAction(e -> {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String category = categoryField.getText().trim();
            String stockText = stockField.getText().trim();
            String durationText = durationField.getText().trim();

            if (title.isEmpty() || author.isEmpty() || category.isEmpty() || stockText.isEmpty() || durationText.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please fill all fields correctly.");
                return;
            }

            int stock;
            int duration;
            try {
                stock = Integer.parseInt(stockText);
                duration = Integer.parseInt(durationText);
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please enter valid numbers for stock and duration.");
                return;
            }

            // Buat objek Book baru
            Book newBook = new Book(null, title, author, category, stock, duration);

            // Tambahkan buku ke daftar admin
            admin.addBook(newBook);

            // Pesan BUku berhasil ditambahkan
            showAlert(Alert.AlertType.INFORMATION, "Success", "Book added successfully: " + newBook.getTitle());

            // Kembali ke tampilan menu admin
            primaryStage.setScene(AdminMenuScene.getScene(primaryStage));
        });

        backButton.setOnAction(e -> primaryStage.setScene(AdminMenuScene.getScene(primaryStage)));

        return scene;
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
