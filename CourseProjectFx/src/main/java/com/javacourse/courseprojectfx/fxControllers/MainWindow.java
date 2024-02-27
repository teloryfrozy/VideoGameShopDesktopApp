package com.javacourse.courseprojectfx.fxControllers;

import com.javacourse.courseprojectfx.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

//Jei norite prieiti prie laukų iki jie bus sugeneruoti, reikia, kad kontrolerio klasė implementuotų Initializable interfeisą
//Tuomet reikės implementuoti initialize() metodą, jo viduje matysite kaip užpildau combo box
public class MainWindow implements Initializable {
    //Aš dažniausiai susidedu @FXML prie visų klasės kintamųjų, kurie yra susieti su formos elementų id, lengviau būna dirbti
    @FXML
    //ListView be nieko yra taip vadinamasis raw usage of list view. Geriausia yra nurodyti kokio tipo duomenis mes saugosim tame sąraše
    //Šiuo atveju tai būtų Product
    public ListView<Product> shopProducts;
    @FXML
    public Tab shopTab;
    @FXML
    public ListView<Product> productAdminList;
    @FXML
    public TextField productTitleField;
    @FXML
    public TextArea productDescriptionField;
    @FXML
    public TextField productQuantityField;
    @FXML
    public TextField productWeightField;
    @FXML
    public DatePicker productDatePickField;
    @FXML
    public DatePicker productPlantDateField;
    @FXML
    public DatePicker productValidTillField;
    @FXML
    public TextField productColourField;
    @FXML
    public TextField productTypeField;
    @FXML
    public TextField productFarmField;
    @FXML
    public DatePicker productSeedPickDate;
    @FXML
    //Čia mano ComboBox saugos Enum SeedType reikšmes
    public ComboBox<SeedType> seedTypeField;
    @FXML
    public TextField productManufacturerField;
    @FXML
    public RadioButton productPlantRadio;
    @FXML
    public RadioButton productSeedRadio;
    @FXML
    public RadioButton productToolRadio;

    public void buyItems() {
    }

    //Metodas, kuris kviečiamas paspaudus mygtuką Add
    public void createRecord() {
        //Tikrinam ar pasirinktas augalas, jei taip, kuriam Plant objektą, susirinkdami info iš laukų, kurie reikalingi Plant
        if (productPlantRadio.isSelected()) {
            Plant plant = new Plant(productTitleField.getText(),
                    productDescriptionField.getText(),
                    Integer.parseInt(productQuantityField.getText()),
                    Float.parseFloat(productWeightField.getText()),
                    productPlantDateField.getValue(),
                    productColourField.getText(),
                    productTypeField.getText());
            //Kai turėsime duomenų bazę, šiame žyngsnyje tą objekto info išsaugosime db ir tik tada atvaizduosime
            productAdminList.getItems().add(plant); //Kol kas tiesiog atvaizduoju sukurtą objektą ListView elemente
        } else if (productSeedRadio.isSelected()) {
            //Čia jei pasirinktas produktas sėklos, susirenku info iš tų laukų, kurie reikalingi Seed objekto kūrimui
            Seed seed = new Seed(productTitleField.getText(),
                    productDescriptionField.getText(),
                    Integer.parseInt(productQuantityField.getText()),
                    Float.parseFloat(productWeightField.getText()),
                    productFarmField.getText(),
                    productSeedPickDate.getValue(),
                    seedTypeField.getValue());
            productAdminList.getItems().add(seed);
        } else {
            //O čia kas liko - Tool
            Tool tool = new Tool(productTitleField.getText(),
                    productDescriptionField.getText(),
                    Integer.parseInt(productQuantityField.getText()),
                    Float.parseFloat(productWeightField.getText()),
                    productManufacturerField.getText());
            productAdminList.getItems().add(tool);
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

    //Kviečiamas delete mygtuko paspaudimo metu, ištrinam iš sąrašo
    public void deleteRecord() {
        Product product = productAdminList.getSelectionModel().getSelectedItem();
        productAdminList.getItems().remove(product);
    }

    //Čia metodas, kuris iškviečiamas paspaudus ant bet kurio radio button
    public void disableFields() {
        //vienus laukus enable'inu, o kitus disable'inu. Yra dar metodas setVisible(), jei norit iš viso neatvaizduoti elemento
        if (productPlantRadio.isSelected()) {
            productFarmField.setDisable(true);
            productSeedPickDate.setDisable(true);
            seedTypeField.setDisable(true);
            productManufacturerField.setDisable(true);
            productDatePickField.setDisable(false);
            productPlantDateField.setDisable(false);
            productValidTillField.setDisable(false);
            productColourField.setDisable(false);
            productTypeField.setDisable(false);
        } else if (productSeedRadio.isSelected()) {
            productFarmField.setDisable(false);
            productSeedPickDate.setDisable(false);
            seedTypeField.setDisable(false);
            productManufacturerField.setDisable(true);
            productDatePickField.setDisable(true);
            productPlantDateField.setDisable(true);
            productValidTillField.setDisable(true);
            productColourField.setDisable(true);
            productTypeField.setDisable(true);
        } else {
            productManufacturerField.setDisable(false);
            productFarmField.setDisable(true);
            productSeedPickDate.setDisable(true);
            seedTypeField.setDisable(true);
            productDatePickField.setDisable(true);
            productPlantDateField.setDisable(true);
            productValidTillField.setDisable(true);
            productColourField.setDisable(true);
            productTypeField.setDisable(true);
        }
    }

    //Šis metodas iškviečiamas paspaudus ant ListView elemento, kuriame atvaizduojame visus produktus
    //Jis uzpildo laukus su objekto info i laukus ir leidzia mums ja patogiai koreguoti
    public void loadProductData() {
        //ListView elementas turi getSelectionModel().getSelectedItem(), jei norim nustatyti kurį įrašą pasirinko
        Product product = productAdminList.getSelectionModel().getSelectedItem();

        //Kadangi ListView<Product> saugo Product t.y. ten kur parent klase, galime saugoti vaikines klases objektus
        //Bet tokiu atveju negalim pasiekti atributu ir metodu vaikinese klasese
        //Tai galim patikrinti su instanceof koks ten vaikas ir padaryti type casting
        if (product instanceof Plant) {
            Plant plant = (Plant) product;
            productTitleField.setText(plant.getTitle());
            productDescriptionField.setText(plant.getDescription());
            productQuantityField.setText(String.valueOf(plant.getQty()));
            productWeightField.setText(String.valueOf(plant.getWeight()));

        } else if (product instanceof Seed) {
            Seed seed = (Seed) product;
            productTitleField.setText(seed.getTitle());
            productDescriptionField.setText(seed.getDescription());
            productQuantityField.setText(String.valueOf(seed.getQty()));
            productWeightField.setText(String.valueOf(seed.getWeight()));
            productFarmField.setText(seed.getFarm());
            productSeedPickDate.setValue(seed.getCollectDate());
            seedTypeField.setValue(seed.getSeedType());
        } else {
            Tool tool = (Tool) product;
            productTitleField.setText(tool.getTitle());
            productDescriptionField.setText(tool.getDescription());
            productQuantityField.setText(String.valueOf(tool.getQty()));
            productWeightField.setText(String.valueOf(tool.getWeight()));
            productManufacturerField.setText(tool.getManufacturer());
        }
    }

    //Kai klasė implements Initializable, implementuojam šį metodą. Jis suteikia galimybę mums prieiti prie laukų iki jie bus sugeneruoti
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seedTypeField.getItems().addAll(SeedType.values());
    }
}
