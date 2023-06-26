package org.clean.slate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader =
            new FXMLLoader(Main.class.getResource("/org/clean/slate/view/SearchController.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page);

        primaryStage.setTitle("JavaFX Yo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
