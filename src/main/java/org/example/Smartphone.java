package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "smartphones")
public class Smartphone {
    //encapsulation using getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ram")
    private int ram;

    @Column(name = "processorspeed")
    private double processorspeed;

    @Column(name = "batterysize")
    private int batterysize;

    @Column(name = "screensize")
    private double screensize;

    @Column(name = "storage")
    private int storage;

    @ManyToOne
    @JoinColumn(name = "os_id")
    private OperatingSystem operatingSystem;

    public Smartphone() {}
    // Constructor
    public Smartphone(String name, int ram, double processorspeed, int batterysize, double screensize, int storage, OperatingSystem operatingSystem) {
        this.name = name;
        this.ram = ram;
        this.processorspeed = processorspeed;
        this.batterysize = batterysize;
        this.screensize = screensize;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
    }

    // Getters and Setters
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
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public double getProcessorspeed() {
        return processorspeed;
    }
    public void setProcessorspeed(double processorspeed) {
        this.processorspeed = processorspeed;
    }
    public int getBatterysize() {
        return batterysize;
    }
    public void setBatterysize(int batterysize) {
        this.batterysize = batterysize;
    }
    public double getScreensize() {
        return screensize;
    }
    public void setScreensize(double screensize) {
        this.screensize = screensize;
    }
    public int getStorage() {
        return storage;
    }
    public void setStorage(int storage) {
        this.storage = storage;
    }
    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }
    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    //toString
    @Override
    public String toString() {
        return name + ": " + ram + "GB RAM, " + batterysize + "mAh battery, " + screensize + " inch screen, " + storage + "GB storage, " + operatingSystem + " operating system";
    }
}
