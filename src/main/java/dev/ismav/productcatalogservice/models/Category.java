package dev.ismav.productcatalogservice.models;

import java.util.List;

// Removed @Getter and @Setter to avoid "symbol not found" issues
public class Category extends BaseModel {
    private String name;
    private String description;
    private List<Product> listOfProducts;

    // Manual Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    // If BaseModel DOES NOT have getId/setId, you should add them here:

    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

}
