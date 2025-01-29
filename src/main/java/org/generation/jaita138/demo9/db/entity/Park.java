package org.generation.jaita138.demo9.db.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String name;
    @Column(length = 128)
    private String street;
    @Column(length = 64)
    private String city;

    private int capacity;

    @OneToMany(mappedBy = "park")
    private List<Car> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {

        return "Park [\n"
                + "  id=" + id + ",\n"
                + "  name=" + name + ",\n"
                + "  street=" + street + ",\n"
                + "  city=" + city + ",\n"
                + "  capacity=" + capacity + "\n"
                + "]";
    }
}
