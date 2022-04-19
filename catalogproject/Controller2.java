//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.catalogproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller2 implements Initializable {
    @FXML
    private TableView<Item> tableView;
    @FXML
    private TableColumn<Item, String> value;
    @FXML
    private Types types;
    @FXML
    private TextField attrValue;
    @FXML
    private TextField itemName;
    @FXML
    private TextField tagName;
    @FXML
    private TextArea itemDescription;
    @FXML
    private ListView<Types> listView;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button edit;
    @FXML
    private Button addValue;
    @FXML
    private Button deleteValue;
    @FXML
    private Button editValue;
    @FXML
    private Button save;
    @FXML
    private Accordion accordion;
    @FXML
    private TitledPane titledPane;
    @FXML
    Item item;
    @FXML
    Controller1 controller1;
    private TextField typeName;


    public void setController1(Controller1 controller1) {
        this.controller1 = controller1;
    }
    public void init(Controller1 controller1) {
        this.controller1 = controller1;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.value.setCellValueFactory(new PropertyValueFactory<Item,String>("attributeValues"));
        this.tableView.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {
                Item selectedItem = this.tableView.getSelectionModel().getSelectedItem();
                this.attrValue.setText(selectedItem.getAttributeValues());
            }
        });
    }
    public void addAttributeValue() {
        if(!this.attrValue.getText().isEmpty()) {
            String value = this.attrValue.getText();
            Item item = new Item(value);
            this.tableView.getItems().add(item);
            this.attrValue.clear();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter attribute value");
            alert.showAndWait();
        }
    }
    public void deleteAttributeValue() {
        Item item = this.tableView.getSelectionModel().getSelectedItem();
        this.tableView.getItems().remove(item);
    }
    public void editAttributeValue() {
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (attrValue.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter attribute value");
            alert.showAndWait();
        }
        else {
            selectedItem.setAttributeValues(attrValue.getText());
        }
        tableView.refresh();
    }
    public void addItem() {
        if(!this.itemName.getText().isEmpty() && !this.itemDescription.getText().isEmpty() && !this.tagName.getText().isEmpty()) {
            String name = this.itemName.getText();
            String description = this.itemDescription.getText();
            String tag = this.tagName.getText();
            Item item = new Item(name, description,tag);
            this.itemName.clear();
            this.itemDescription.clear();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter item name and description");
            alert.showAndWait();
        }
    }


    public void saveTypeName() {
        if(!this.typeName.getText().isEmpty()) {
            String name = this.typeName.getText();
            Item item = new Item(name);
            this.typeName.clear();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter item name");
            alert.showAndWait();
        }
    }
}
