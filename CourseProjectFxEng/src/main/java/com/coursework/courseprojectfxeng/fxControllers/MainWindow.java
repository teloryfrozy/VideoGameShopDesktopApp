package com.coursework.courseprojectfxeng.fxControllers;

import com.coursework.courseprojectfxeng.model.Plant;
import com.coursework.courseprojectfxeng.model.Product;
import com.coursework.courseprojectfxeng.model.SeedType;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainWindow {
    public ListView shopProducts;
    public Tab shopTab;
    public ListView<Product> productAdminList;
    public TextField productTitleField;
    public TextArea productDescriptionField;
    public TextField productQuantityField;
    public TextField productWeightField;
    public DatePicker productDatePickField;
    public DatePicker productPlantDateField;
    public DatePicker productValidTillField;
    public TextField productColourField;
    public TextField productTypeField;
    public TextField productFarmField;
    public DatePicker productSeedPickDate;
    public ComboBox<SeedType> seedTypeField;
    public TextField productManufacturerField;
    public RadioButton productPlantRadio;
    public RadioButton productSeedRadio;
    public RadioButton productToolRadio;


    public void buyItems() {
        Pane pane = new Pane();
        Button button = new Button("Test button");
        pane.getChildren().add(button);
        System.out.println("Yo");

        AnchorPane anchorPane = (AnchorPane) shopTab.getContent();
        anchorPane.getChildren().add(pane);

    }

    public void createRecord() {
        if (productPlantRadio.isSelected()) {
            Plant plant = new Plant(productTitleField.getText(),
                    productDescriptionField.getText(),
                    Integer.parseInt(productQuantityField.getText()),
                    Float.parseFloat(productWeightField.getText()),
                    productPlantDateField.getValue(),
                    productColourField.getText(),
                    productTypeField.getText());
            //insert to database
            productAdminList.getItems().add(plant);
        }
    }

    public void updateRecord() {
        Product product = productAdminList.getSelectionModel().getSelectedItem();
        if (product instanceof Plant) {
            Plant plant = (Plant) product;
            product.setTitle(productTitleField.getText());
            //productDescriptionField.setText(plant.getDescription());
            plant.setDescription(productDescriptionField.getText());
        }
    }

    public void deleteRecord() {
        Product product = productAdminList.getSelectionModel().getSelectedItem();
        productAdminList.getItems().remove(product);
    }

    public void disableFields() {
        if (productPlantRadio.isSelected()) {
            productFarmField.setDisable(true);
            productSeedPickDate.setDisable(true);
            seedTypeField.setDisable(true);
        } else if (productSeedRadio.isSelected()) {
            productFarmField.setDisable(false);
            productSeedPickDate.setDisable(false);
            seedTypeField.setDisable(false);
        } else {

        }
    }

    public void loadProductData() {
        Product product = productAdminList.getSelectionModel().getSelectedItem();

        if (product instanceof Plant) {
            Plant plant = (Plant) product;
            productTitleField.setText(plant.getTitle());
            productDescriptionField.setText(plant.getDescription());
        }
    }
}
