package ca.leomoraes.fulllabstore.model;

public class Product {
    private String name;
    private String brand;

    public Product(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}