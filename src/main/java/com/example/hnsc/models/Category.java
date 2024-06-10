package com.example.hnsc.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private String avatar;
    private String description;
    private HashMap<String, String> errors = new HashMap<>();

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void addError(String key, String value) {
        errors.put(key, value);
    }
}
