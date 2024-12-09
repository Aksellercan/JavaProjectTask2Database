package org.example;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operatingsystem")
public class OperatingSystem {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "operatingSystem",cascade = CascadeType.ALL)
    private List<Smartphone> smartphones = new ArrayList<>();

    // Constructors
    public OperatingSystem() {}

    public OperatingSystem(String name) {
        this.name = name;
    }

    //Getters and Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Smartphone> getSmartphones() {
        return smartphones;
    }
    public void setSmartphones(List<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }

    @Override
    public String toString() {
//        return "OperatingSystem{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
        return name;
    }
}