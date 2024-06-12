package com.example.modul6tugas.Gui;

import com.example.modul6tugas.Data.User;
import com.example.modul6tugas.Data.Student;
import com.example.modul6tugas.Book.Book;
import com.example.modul6tugas.com.main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ReturnBookScene {

    public static Scene getScene(Stage primaryStage, User user) {
        VBox returnBookLayout = new VBox(10);
        returnBookLayout.setAlignment(javafx.geometry.Pos.CENTER);
        returnBookLayout.setPadding(new Insets(20));

        Label titleLabel = new Label("Select book to return:");
        ChoiceBox<String> bookChoiceBox = new ChoiceBox<>();
        ObservableList<String> borrowedBooks = FXCollections.observableArrayList();

        if (user instanceof Student) {
            Student student = (Student) user;
            List<Book> userBorrowedBooks = student.getBorrowedBooks();
            for (Book borrowedBook : userBorrowedBooks) {
                borrowedBooks.add(borrowedBook.getTitle());
            }
            bookChoiceBox.setItems(borrowedBooks);

            Button returnButton = new Button("Return");
            returnButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20;");

            Button backButton = new Button("Back");
            backButton.setStyle("-fx-background-color: #607D8B; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20;");

            returnBookLayout.getChildren().addAll(titleLabel, bookChoiceBox, returnButton, backButton);

            Scene scene = new Scene(returnBookLayout, 500, 350);

            returnButton.setOnAction(e -> {
                String selectedBookTitle = bookChoiceBox.getValue();
                if (selectedBookTitle != null) {
                    Book borrowedBook = student.findBorrowedBookByTitle(selectedBookTitle);
                    if (borrowedBook != null) {
                        student.returnBook(borrowedBook);
                        Main.bookList.add(borrowedBook);
                        borrowedBooks.remove(selectedBookTitle);
                        showAlert(Alert.AlertType.INFORMATION, "Success", "Book returned successfully.");
                        primaryStage.setScene(StudentMenuScene.getScene(primaryStage,user));
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Error", "Book not found in user's borrowed books.");
                    }
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Please select a book to return.");
                }
            });

            backButton.setOnAction(e -> primaryStage.setScene(StudentMenuScene.getScene(primaryStage, user)));

            return scene;
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "User is not a student.");
            return null;
        }
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
