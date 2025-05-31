package com.nuketree3.example.testpdfdes.GUI;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 1000;
    private Stage primaryStage;
    private FileWindow fileWindow;
    private MainWindow mainWindow;

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        mainWindow = new MainWindow(SCENE_WIDTH, SCENE_HEIGHT, this);
        fileWindow = new FileWindow(SCENE_WIDTH, SCENE_HEIGHT, this);

        showMainWindow();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void showMainWindow() {
        primaryStage.setScene(mainWindow.getScene());
    }

    public void showFileWindow(String fileName) throws IOException {
        primaryStage.setScene(fileWindow.getScene(fileName));
    }
}