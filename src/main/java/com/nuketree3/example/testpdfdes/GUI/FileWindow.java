package com.nuketree3.example.testpdfdes.GUI;

import com.nuketree3.example.testpdfdes.service.Service;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class FileWindow {

    private int numberOfPage = -1;
    private int pagesCount;
    private String fileName;
    private static int width;
    private static int height;
    private final ImageView imageView;
    private final HelloApplication application;

    private static Service service;

    public FileWindow(int width, int height, HelloApplication application) {
        FileWindow.width = width;
        FileWindow.height = height;
        this.application = application;
        service = new Service();
        imageView = new ImageView();
    }

    public void setPagesCount(String filename) throws IOException {
        pagesCount = service.getPDF(filename).getNumberOfPages();
    }

    public Scene getScene(String fileName) throws IOException {
        if(this.fileName != null && !this.fileName.equals(fileName)) {
            numberOfPage = -1;
        }
        this.fileName = fileName;
        setPagesCount(fileName);
        return new Scene(getAllThings(), width, height);
    }

    public Group getLastPageButton() {
        Group group = new Group();
        Button button = new Button();
        button.setText("Last Page");
        button.setOnAction(event -> {
            if(numberOfPage > 0) {
                numberOfPage--;
                try {
                    getFilePage();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        group.getChildren().add(button);
        group.setLayoutX(50);
        return group;
    }

    public Group getNextPageButton() {
        Group group = new Group();
        Button button = new Button();
        button.setText("Next Page");
        button.setOnAction(event -> {
            if(numberOfPage < pagesCount-1){
                numberOfPage++;
                try {
                    getFilePage();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        group.getChildren().add(button);
        group.setLayoutX(width-50);
        return group;
    }

    public Group getBackToMainWindowButton() {
        Group backToMainWindowButton = new Group();
        Button button = new Button("Back to Main Window");
        button.setOnAction(event -> application.showMainWindow());
        backToMainWindowButton.getChildren().add(button);
        backToMainWindowButton.setLayoutX((double) width / 2);
        return backToMainWindowButton;
    }

    public void getFilePage() throws IOException {
        imageView.setImage(service.getImage(service.getPDF(fileName), numberOfPage));
    }

    public StackPane getAllThings() throws IOException {
        Group group = new Group();
        group.getChildren().addAll(getLastPageButton(), getNextPageButton(), getBackToMainWindowButton());
        group.setTranslateY(height/2.1);
        if(numberOfPage<0){
            imageView.setImage(service.getImage(service.getPDF(fileName), 0));
            numberOfPage = 0;
        }
        return new StackPane(imageView, group);
    }
}
