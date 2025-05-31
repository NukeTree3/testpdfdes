package com.nuketree3.example.testpdfdes.GUI;

import com.nuketree3.example.testpdfdes.service.Service;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.List;

public class MainWindow {

    private static int width;
    private static int height;
    private HelloApplication application;

    private static Service service;

    public MainWindow(int width, int height, HelloApplication application) {
        service = new Service();
        MainWindow.width = width;
        MainWindow.height = height;
        this.application = application;
    }

    public FlowPane addButtons() {
        Group root = new Group();
        List<String> files = service.getFiles();
        for (int i = 0; i < files.size(); i++) {
            Button button = getButton(files, i, application);
            button.setPrefWidth(width);
            root.getChildren().add(button);
        }
        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setPrefViewportHeight(MainWindow.height);
        FlowPane fp =  new FlowPane(Orientation.VERTICAL, 10, 50, scrollPane);
        fp.setAlignment(Pos.CENTER);
        return fp;
    }

    private static Button getButton(List<String> files, int i, HelloApplication application) {
        Button button = new Button();
        button.setMaxWidth(width);
        button.setLayoutX((double) width / 4);
        button.setText(files.get(i));
        button.setTranslateY(i * 50);
        int finalI = i;
        button.setOnAction(event -> {
            try {
                application.showFileWindow(files.get(finalI));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return button;
    }

    public Scene getScene() {
        return new Scene(addButtons(), width, height);
    }
}
