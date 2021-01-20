package com.SpringBootThymeleaf.SpringBootThymeleaf.form;

import com.SpringBootThymeleaf.SpringBootThymeleaf.model.Character;
import com.SpringBootThymeleaf.SpringBootThymeleaf.model.Type;

public class CharacterForm {
    private int id;
    private String name;
    private Type type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
