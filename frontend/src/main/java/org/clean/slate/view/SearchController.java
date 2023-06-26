package org.clean.slate.view;

import org.clean.slate.model.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class SearchController {

    @FXML
    private TextField searchField;
    @FXML
    private Label searchLabel;
    @FXML
    private Button searchButton;
    @FXML
    private VBox dataContainer;
    @FXML
    private TableView tableView;

    ObservableList<Person> masterData = FXCollections.observableArrayList();
    ObservableList<Person> results = FXCollections.observableList(masterData);

    @FXML
    private void initialize() {
        searchButton.setText("Search");
        // searchButton.setOnAction(event -> loadData());

        // blue button, white text
        searchButton.setStyle("-fx-background-color: #457ecd; -fx-text-fill: #ffffff");

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                searchLabel.setText(newValue);
            });

        initTable();
    }

    private void initTable() {
        tableView = new TableView<>(FXCollections.observableList(masterData));

        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory("id"));

        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn employed = new TableColumn("EMPLOYED");
        employed.setCellValueFactory(new PropertyValueFactory("isEmployed"));

        tableView.getColumns().addAll(id, name, employed);
        dataContainer.getChildren().add(tableView);
    }

}
