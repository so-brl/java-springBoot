package com.IntroductionSpringBoot.IntroductionSpringBoot.model;

import javax.persistence.*;


//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Avatar {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    //@OneToOne(orphanRemoval=true)
    private String name;
    //@OneToOne(orphanRemoval=true)
    private String type;



    public Avatar() {

    }

    /**
     *
     * @param id
     * @param name
     * @param type
     */
    public Avatar(int id, String name, String type) {
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
        return "Avatar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
