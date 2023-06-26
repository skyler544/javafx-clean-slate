package org.clean.slate.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Data;

@Data
public class Person {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleBooleanProperty isEmployed;
}
