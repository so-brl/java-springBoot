package com.IntroductionSpringBoot.IntroductionSpringBoot.model;

import java.util.Random;

public class Character {
    private int id;
    private String name;
    private Type type;



    public Character() {

    }
    public Character(String name, Type type) {
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
    public Character(int id, String name, Type type) {
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
    public Type getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(Type type) {
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
