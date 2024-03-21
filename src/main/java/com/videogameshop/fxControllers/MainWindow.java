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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        entityManagerFactory = Persistence.createEntityManagerFactory("ProjectManagementSystem");
        productSizeChoice.getItems().addAll(sizes);
        productPegiChoice.getItems().addAll(pegis);

        // Add existing products in list
//        HibernateShop hibernateShop = new HibernateShop(entityManagerFactory);
//        shopProducts.getItems().addAll(hibernateShop.getAllRecords());
    }

    public void createRecord() {
        HibernateShop hibernateShop = new HibernateShop(entityManagerFactory);

        String title = productTitleField.getText().trim();
        String description = productDescriptionField.getText().trim();
        String color = productColorField.getText().trim();
        String size = productSizeChoice.getValue();
        String priceText = productPriceField.getText().trim();
        String pegi = productPegiChoice.getValue();
        float price = 0.0f;

        try {
            price = Float.parseFloat(priceText);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Price must be a valid number");
        }

        if (title.isEmpty()) {
            System.out.println("Error: Title is empty");
            showAlert(Alert.AlertType.ERROR, "Error", "Title is mandatory");
            return;
        }

        if (consoleRadio.isSelected()) {

            if (color.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Color is mandatory");
                return;
            } else if (size == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Size is mandatory");
                return;
            } else if (priceText.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Price is mandatory");
                return;
            }
            try {
                Console console = new Console(title, description, price, size, color);
                productAdminList.getItems().add(console);
                hibernateShop.create(console);
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
            }
        } else if (accessoryRadio.isSelected()) {

            if (color.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Color is mandatory");
                return;
            } else if (priceText.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Price is mandatory");
                return;
            }
            try {
                int quantity = Integer.parseInt(productQuantityField.getText());
                Accessory accessory = new Accessory(title, description, price, quantity, color);
                productAdminList.getItems().add(accessory);
                hibernateShop.create(accessory);
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Quantity must be a valid number");
            }
        } else if (videoGameRadio.isSelected()) {

            if (priceText.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Price is mandatory");
                return;
            } else if (pegi == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "PEGI is mandatory");
                return;
            }
            try {
                VideoGame videoGame = new VideoGame(title, description, price, pegi);
                productAdminList.getItems().add(videoGame);
                hibernateShop.create(videoGame);
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Warning", "Please select a product type");
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
            productColorField.setDisable(false);
            productSizeChoice.setDisable(true);
        } else {
            productPegiChoice.setDisable(false);
            productQuantityField.setDisable(true);
            productSizeChoice.setDisable(true);
            productColorField.setDisable(true);
        }
    }

    public void loadProductData() {
        // TODO: Load product data from the database and call this method when the application starts
        HibernateShop hibernateShop = new HibernateShop(entityManagerFactory);

        Product product = productAdminList.getSelectionModel().getSelectedItem();

        if (product instanceof Console) {
            Console console = hibernateShop.getEntityById(Console.class, product.getId());

            System.out.println("Console: " + console.getTitle());
            System.out.println("Description: " + console.getDescription());
            System.out.println("Color: " + console.getColor());
            System.out.println("Size: " + console.getSize());
            System.out.println("Price: " + console.getPrice());

            productTitleField.setText(console.getTitle());
            productDescriptionField.setText(console.getDescription());
            productColorField.setText(console.getColor());
            productSizeChoice.setValue(console.getSize());
            productPriceField.setText(String.valueOf(console.getPrice()));

            consoleRadio.setSelected(true);
            productPegiChoice.setDisable(true);
            productQuantityField.setDisable(true);
            productSizeChoice.setDisable(false);
            productColorField.setDisable(false);

        } else if (product instanceof Accessory) {
            Accessory accessory = hibernateShop.getEntityById(Accessory.class, product.getId());
            productTitleField.setText(accessory.getTitle());
            productDescriptionField.setText(accessory.getDescription());
            productColorField.setText(accessory.getColor());
            productPriceField.setText(String.valueOf(accessory.getPrice()));

            System.out.println("Accessory: " + accessory.getTitle());
            System.out.println("Description: " + accessory.getDescription());
            System.out.println("Color: " + accessory.getColor());
            System.out.println("Quantity: " + accessory.getQuantity());
            System.out.println("Price: " + accessory.getPrice());

            accessoryRadio.setSelected(true);
            productPegiChoice.setDisable(true);
            productQuantityField.setDisable(false);
            productSizeChoice.setDisable(true);
            productColorField.setDisable(true);

        } else {
            VideoGame videoGame = hibernateShop.getEntityById(VideoGame.class, product.getId());
            productTitleField.setText(videoGame.getTitle());
            productDescriptionField.setText(videoGame.getDescription());
            productPegiChoice.setValue(videoGame.getPegi());
            productPriceField.setText(String.valueOf(videoGame.getPrice()));

            System.out.println("Video Game: " + videoGame.getTitle());
            System.out.println("Description: " + videoGame.getDescription());
            System.out.println("PEGI: " + videoGame.getPegi());
            System.out.println("Price: " + videoGame.getPrice());

            videoGameRadio.setSelected(true);
            productPegiChoice.setDisable(false);
            productQuantityField.setDisable(true);
            productSizeChoice.setDisable(true);
            productColorField.setDisable(true);
        }
    }

    public void updateRecord() {
        HibernateShop hibernateShop = new HibernateShop(entityManagerFactory);

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
            hibernateShop.update(productAdminList.getSelectionModel().getSelectedItem());

        } catch (NullPointerException e) {
            showAlert(Alert.AlertType.INFORMATION, "Warning", "Please select a product to update");
        }
    }

    public void deleteRecord() {
        HibernateShop hibernateShop = new HibernateShop(entityManagerFactory);

        try {
            Product product = productAdminList.getSelectionModel().getSelectedItem();
            productAdminList.getItems().remove(product);
            product.removeMessage();
            hibernateShop.delete(product.getClass(), product.getId());
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