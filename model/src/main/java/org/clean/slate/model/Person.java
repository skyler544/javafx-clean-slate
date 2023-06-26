package org.clean.slate.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
	private SimpleBooleanProperty isEmployed;

	public Person(int id, String name, boolean isEmployed) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.isEmployed = new SimpleBooleanProperty(isEmployed);
    }

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
    public Boolean getIsEmployed() {
		return isEmployed.get();
	}

    public void setIsEmployed(Boolean isEmployed) {
		this.isEmployed.set(isEmployed);
	}
}
