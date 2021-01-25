package com.SpringBootThymeleaf.SpringBootThymeleaf.model;

import java.util.Random;

public class Character {
    private int id;
    private String name;
    private String type;



    public Character() {

    }


    public Character(int id) {
        this.id = id;
        this.name = getName();
        this.type = getType();
    }

    public Character(String name, String type) {
        Random rand = new Random();
        this.id = rand.nextInt(1000 - 100 + 1) + 100;;
        this.name = name;
        this.type = type;
    }

    /**
     *
     * @param id
     * @param name
     * @param type
     */
    public Character(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
