package com.javacourse.courseprojectfx.fxControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainWindow {
    public ListView shopProducts;
    public Tab shopTab;


    public void buyItems() {
        Pane pane = new Pane();
        Button button = new Button("Test button");
        pane.getChildren().add(button);
        System.out.println("Yo");

        AnchorPane anchorPane = (AnchorPane) shopTab.getContent();
        anchorPane.getChildren().add(pane);

    }
}
