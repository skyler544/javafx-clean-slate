module org.clean.frontend {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.clean.model;

    opens org.clean.slate to javafx.graphics, javafx.fxml;
    opens org.clean.slate.view to javafx.graphics, javafx.fxml;
    exports org.clean.slate;
}
