package org.generation.jaita138.demo9.db.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String brand;
    @Column(length = 64)
    private String model;

    private int year;
    private int price;

    private int displacement; // cilindrata

    @ManyToOne
    private Park park;

    @ManyToMany
    private List<Owner> owners;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public List<Owner> getOwners() {

        return this.owners;
    }

    public void setOwners(List<Owner> owners) {

        this.owners = owners;
    }

    public void addOwner(Owner owner) {

        if (this.owners == null)
            this.owners = new ArrayList<>();

        this.owners.add(owner);
    }

    @Override
    public String toString() {

        return "Car [\n"
                + "  id=" + id + ",\n"
                + "  brand=" + brand + ",\n"
                + "  model=" + model + ",\n"
                + "  year=" + year + ",\n"
                + "  price=" + price + ",\n"
                + "  displacement=" + displacement + "\n"
                + "  park=" + park + "\n"
                + "]";
    }
}
