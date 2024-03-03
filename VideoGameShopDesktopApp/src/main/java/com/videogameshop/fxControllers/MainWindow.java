package com.videogameshop.fxControllers;

import com.videogameshop.model.Accessory;
import com.videogameshop.model.Console;
import com.videogameshop.model.Product;
import com.videogameshop.model.VideoGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class MainWindow implements Initializable {

    private final String[] sizes = {"Small", "Medium", "Large"};
    private final String[] pegis = {"PEGI 3", "PEGI 7", "PEGI 12", "PEGI 16", "PEGI 18"};
    @FXML
    public Tab shopTab;
    @FXML
    public ListView<Product> shopProducts;
    @FXML
    public ListView<Product> productAdminList;
    @FXML
    public TextField productTitleField;
    @FXML
    public TextArea productDescriptionField;
    @FXML
    public TextField productColorField;
    @FXML
    public RadioButton consoleRadio;
    @FXML
    public RadioButton videoGameRadio;
    @FXML
    public RadioButton accessoryRadio;
    @FXML
    public TextField productPriceField;
    @FXML
    public TextField productQuantityField;
    @FXML
    private ChoiceBox<String> productSizeChoice;
    @FXML
    private ChoiceBox<String> productPegiChoice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productSizeChoice.getItems().addAll(sizes);
        productPegiChoice.getItems().addAll(pegis);
    }

    public void createRecord() {
        // Console
        if (consoleRadio.isSelected()) {
            Console console = new Console(
                    productTitleField.getText(),
                    productDescriptionField.getText(),
                    productColorField.getText(),
                    Float.parseFloat(productPriceField.getText()),
                    productSizeChoice.getValue()
            );
            productAdminList.getItems().add(console);
        }
        // Accessory
        else if (accessoryRadio.isSelected()) {
            Accessory accessory = new Accessory(
                    productTitleField.getText(),
                    productDescriptionField.getText(),
                    Float.parseFloat(productPriceField.getText()),
                    Integer.parseInt(productQuantityField.getText()),
                    productColorField.getText()
            );
            productAdminList.getItems().add(accessory);
        }
        // Video Game
        else {
            VideoGame videoGame = new VideoGame(
                    productTitleField.getText(),
                    productDescriptionField.getText(),
                    Float.parseFloat(productPriceField.getText()),
                    productPegiChoice.getValue()
            );
            productAdminList.getItems().add(videoGame);
        }
    }

    public void disableFields() {

        if (consoleRadio.isSelected()) {
            productPegiChoice.setDisable(true);
            productQuantityField.setDisable(true);
            productSizeChoice.setDisable(false);
            productColorField.setDisable(false);
        } else if (accessoryRadio.isSelected()) {
            productPegiChoice.setDisable(true);
            productQuantityField.setDisable(false);
            productSizeChoice.setDisable(true);
            productColorField.setDisable(true);
        } else {
            productPegiChoice.setDisable(false);
            productQuantityField.setDisable(true);
            productSizeChoice.setDisable(true);
            productColorField.setDisable(true);
        }
    }

    public void loadProductData() {
        Product product = productAdminList.getSelectionModel().getSelectedItem();

        if (product instanceof Console console) {
            productTitleField.setText(console.getTitle());
            productDescriptionField.setText(console.getDescription());

        } else if (product instanceof Accessory accessory) {
            productTitleField.setText(accessory.getTitle());
            productDescriptionField.setText(accessory.getDescription());
        } else {
            VideoGame videoGame = (VideoGame) product;
            productTitleField.setText(videoGame.getTitle());
            productDescriptionField.setText(videoGame.getDescription());
        }
    }

    public void updateRecord() {
        Product product = (Product) productAdminList.getSelectionModel().getSelectedItem();
        if (product instanceof Console console) {
            console.setTitle(productTitleField.getText());
            console.setDescription(productDescriptionField.getText());
        } else if (product instanceof Accessory accessory) {
            accessory.setTitle(productTitleField.getText());
            accessory.setDescription(productDescriptionField.getText());
        } else {
            VideoGame videoGame = (VideoGame) product;
            videoGame.setTitle(productTitleField.getText());
            videoGame.setDescription(productDescriptionField.getText());
        }
    }

    public void deleteRecord() {
        Product product = productAdminList.getSelectionModel().getSelectedItem();
        productAdminList.getItems().remove(product);
    }
    public void buyItems(ActionEvent actionEvent) {
        System.out.println("Buying items");
    }
}