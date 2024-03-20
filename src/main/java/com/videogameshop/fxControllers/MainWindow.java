package com.videogameshop.fxControllers;

import com.videogameshop.hibernate.HibernateShop;
import com.videogameshop.model.Accessory;
import com.videogameshop.model.Console;
import com.videogameshop.model.Product;
import com.videogameshop.model.VideoGame;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
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
    private EntityManagerFactory entityManagerFactory;
    private HibernateShop hibernateShop;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        entityManagerFactory = Persistence.createEntityManagerFactory("ProjectManagementSystem");
        productSizeChoice.getItems().addAll(sizes);
        productPegiChoice.getItems().addAll(pegis);
    }

    //Pass the entity manager object and user from a previous form
    public void createRecord() {
        HibernateShop hibernateShop = new HibernateShop(entityManagerFactory);

        // Console
        if (consoleRadio.isSelected()) {
            try {
                float price = Float.parseFloat(productPriceField.getText());

                Console console = new Console(
                        productTitleField.getText(),
                        productDescriptionField.getText(),
                        productColorField.getText(),
                        price,
                        productSizeChoice.getValue()
                );
                productAdminList.getItems().add(console);
                hibernateShop.create(console);

            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Price must be a valid number");
            }
        }
        // Accessory
        else if (accessoryRadio.isSelected()) {
            try {
                Accessory accessory = new Accessory(
                        productTitleField.getText(),
                        productDescriptionField.getText(),
                        Float.parseFloat(productPriceField.getText()),
                        Integer.parseInt(productQuantityField.getText()),
                        productColorField.getText()
                );
                productAdminList.getItems().add(accessory);
                hibernateShop.create(accessory);
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Price and quantity must be valid numbers");
            }
        }
        // Video Game
        else if (videoGameRadio.isSelected()) {
            try {
                VideoGame videoGame = new VideoGame(
                        productTitleField.getText(),
                        productDescriptionField.getText(),
                        Float.parseFloat(productPriceField.getText()),
                        productPegiChoice.getValue()
                );
                productAdminList.getItems().add(videoGame);
                hibernateShop.create(videoGame);
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Price must be a valid number");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Warning", "Please select a product type");
        }
    }

    public void disableFields() {
        if (consoleRadio.isSelected()) {
            productPegiChoice.setDisable(true);
            productQuantityField.setDisable(true);
            productSizeChoice.setDisable(true);
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
        try {
            Product product = productAdminList.getSelectionModel().getSelectedItem();

            if (product instanceof Console console) {
                console.setTitle(productTitleField.getText());
                console.setDescription(productDescriptionField.getText());
                System.out.println("\u001B[32mConsole updated successfully: " + product.getTitle());
            } else if (product instanceof Accessory accessory) {
                accessory.setTitle(productTitleField.getText());
                accessory.setDescription(productDescriptionField.getText());
                System.out.println("\u001B[32mAccessory updated successfully: " + product.getTitle());
            } else {
                VideoGame videoGame = (VideoGame) product;
                videoGame.setTitle(productTitleField.getText());
                videoGame.setDescription(productDescriptionField.getText());
                System.out.println("\u001B[32mVideo Game updated successfully: " + product.getTitle());
            }
        } catch (NullPointerException e) {
            showAlert(Alert.AlertType.INFORMATION, "Warning", "Please select a product to update");
        }
    }

    public void deleteRecord() {
        try {
            Product product = productAdminList.getSelectionModel().getSelectedItem();
            productAdminList.getItems().remove(product);
            product.removeMessage();
        } catch (NullPointerException e) {
            showAlert(Alert.AlertType.INFORMATION, "Warning", "Please select a product to delete");
        }
    }

    public void buyItems() {
        System.out.println("Buying items");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}