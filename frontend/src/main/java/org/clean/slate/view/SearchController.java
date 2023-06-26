package org.clean.slate.view;

import org.clean.slate.model.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.stream.Collectors;

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
    private TableView<Person> tableView;

    private ObservableList<Person> masterData = FXCollections.observableArrayList();
    private ObservableList<Person> results = FXCollections.observableList(masterData);

    public SearchController () {
        masterData.add(new Person(1, "Alice", true));
        masterData.add(new Person(2, "Bob", false));
    }

    @FXML
    private void initialize() {
        searchButton.setText("Search");
        searchButton.setOnAction(event -> loadData());

        // blue button, white text
        searchButton.setStyle("-fx-background-color: #457ecd; -fx-text-fill: #ffffff");

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                searchLabel.setText(newValue);
            });

        searchField.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    loadData();
                }
            });

        initTable();
    }

    private void loadData() {
        String searchText = searchField.getText();
        Task<ObservableList<Person>> task = new Task<>() {
                @Override
                protected ObservableList<Person> call() throws Exception {
                    updateMessage("Loading data");
                    return FXCollections
                    .observableArrayList(masterData
                                         .stream()
                                         .filter(value -> value.getName()
                                                 .toLowerCase()
                                                 .contains(searchText))
                                         .collect(Collectors.toList()));
                }

            };

        task.setOnSucceeded(event -> {
                results = task.getValue();
                tableView.setItems(FXCollections.observableList(results));
            });

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    private void initTable() {
        tableView = new TableView<>(FXCollections.observableList(masterData));

        TableColumn<Person, Integer> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Person, String> name = new TableColumn<>("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Person, Boolean> employed = new TableColumn<>("EMPLOYED");
        employed.setCellValueFactory(new PropertyValueFactory<>("isEmployed"));

        // why is this necessary?
        // https://stackoverflow.com/q/53258264
        // https://stackoverflow.com/a/1445334
        tableView.getColumns().addAll(List.of(id, name, employed));
        dataContainer.getChildren().add(tableView);
    }

}
