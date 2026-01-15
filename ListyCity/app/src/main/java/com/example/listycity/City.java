package com.example.listycity;

/**
 * This class represents a City
 */
public class City {
    // Attribs

    private String name;

    // Constructor

    /**
     * Default constructor for City class
     */
    public City() {
        this.name = "";
    }

    /**
     * Creates a City object
     *
     * @param name The name of the City
     */
    public City(String name) {
        this.name = name;
    }

    // Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Functions

    @Override
    public String toString() {
        return this.name;
    }
}
