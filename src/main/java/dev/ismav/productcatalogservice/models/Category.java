package dev.ismav.productcatalogservice.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category extends BaseModel {

    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> listOfProducts;

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
}