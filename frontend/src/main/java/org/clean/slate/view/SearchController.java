package org.clean.slate.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SearchController {

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private VBox dataContainer;
    @FXML
    private TableView tableView;

    @FXML
    private void initialize() {
        searchButton.setText("Search");
        // searchButton.setOnAction(event -> loadData());

        // blue button, white text
        searchButton.setStyle("-fx-background-color: #457ecd; -fx-text-fill: #ffffff");

        initTable();
    }

    private void initTable() {
        tableView = new TableView<>();
        TableColumn id = new TableColumn("ID");
        TableColumn name = new TableColumn("NAME");
        TableColumn employed = new TableColumn("EMPLOYED");
        tableView.getColumns().addAll(id, name, employed);
        dataContainer.getChildren().add(tableView);
    }

}
