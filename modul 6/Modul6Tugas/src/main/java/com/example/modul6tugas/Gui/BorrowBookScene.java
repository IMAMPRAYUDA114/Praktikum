package com.example.modul6tugas.Gui;

import com.example.modul6tugas.Book.Book;
import com.example.modul6tugas.Data.Student;
import com.example.modul6tugas.Data.User;
import com.example.modul6tugas.com.main.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorrowBookScene {

    public static Scene getScene(Stage primaryStage, User user) {
        VBox borrowBookLayout = new VBox(20);
        borrowBookLayout.setPadding(new Insets(20));
        borrowBookLayout.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Enter the title of the book you want to borrow:");
        TextField titleTextField = new TextField();
        Button borrowButton = new Button("Borrow");
        Button backButton = new Button("Back");

        borrowBookLayout.getChildren().addAll(titleLabel, titleTextField, borrowButton, backButton);

        Scene scene = new Scene(borrowBookLayout, 500, 350);

        // style
        borrowButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        backButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-weight: bold;");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        titleTextField.setStyle("-fx-font-size: 14px;");
        borrowBookLayout.setStyle("-fx-background-color: #f0f0f0;");

        borrowButton.setOnAction(e -> {
            String bookTitle = titleTextField.getText();
            if (bookTitle.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please enter the title of the book.");
                return;
            }

            Book bookToBorrow = null;
            for (Book book : Main.bookList) {
                if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                    bookToBorrow = book;
                    break;
                }
            }

            if (bookToBorrow == null || bookToBorrow.getStock() <= 0) {
                showAlert(Alert.AlertType.ERROR, "Error", "Book not available or out of stock.");
            } else {
                if (user instanceof Student) {
                    Student student = (Student) user;
                    student.borrowBook(bookToBorrow);
                    bookToBorrow.setStock(bookToBorrow.getStock() - 1);
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Book borrowed successfully.");
                    primaryStage.setScene(StudentMenuScene.getScene(primaryStage,user));
                }
            }
        });

        backButton.setOnAction(e -> primaryStage.setScene(StudentMenuScene.getScene(primaryStage, user)));

        return scene;
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
