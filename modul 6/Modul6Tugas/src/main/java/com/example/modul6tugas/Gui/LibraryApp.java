package com.example.modul6tugas.Gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LibraryApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Perpustakaan UMM");
        primaryStage.setScene(getMainScene(primaryStage));
        primaryStage.show();
    }

    public static Scene getMainScene(Stage primaryStage) {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));


        ImageView imageView = new ImageView(new Image("https://cdn-icons-png.flaticon.com/512/2038/2038140.png"));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);


        Label titleLabel = new Label("BUKU KITA");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman'; -fx-text-fill: #333;");


        Button adminLoginButton = new Button("Admin Login");
        adminLoginButton.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px; " +
                        "-fx-min-width: 100px; " +
                        "-fx-min-height: 50px;");
        adminLoginButton.setOnMouseEntered(e -> adminLoginButton.setStyle(
                "-fx-background-color: #48D1CC; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px; " +
                        "-fx-min-width: 100px; " +
                        "-fx-min-height: 50px;"));
        adminLoginButton.setOnMouseExited(e -> adminLoginButton.setStyle(
                "-fx-background-color: #4169E1; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px; " +
                        "-fx-min-width: 100px; " +
                        "-fx-min-height: 50px;"));


        Button studentLoginButton = new Button("Student Login");
        studentLoginButton.setStyle(
                "-fx-background-color: #48D1CC; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px; " +
                        "-fx-min-width: 100px; " +
                        "-fx-min-height: 50px;");
        studentLoginButton.setOnMouseEntered(e -> studentLoginButton.setStyle(
                "-fx-background-color: #48D1CC; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px; " +
                        "-fx-min-width: 100px; " +
                        "-fx-min-height: 50px;"));
        studentLoginButton.setOnMouseExited(e -> studentLoginButton.setStyle(
                "-fx-background-color: #48D1CC; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20px; " +
                        "-fx-min-width: 100px; " +
                        "-fx-min-height: 50px;"));

        layout.getChildren().addAll(imageView, titleLabel, adminLoginButton, studentLoginButton);

        Scene scene = new Scene(layout, 300, 600, Color.WHITE);

        adminLoginButton.setOnAction(e -> primaryStage.setScene(AdminLoginScene.getScene(primaryStage)));
        studentLoginButton.setOnAction(e -> primaryStage.setScene(StudentLoginScene.getScene(primaryStage)));

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
