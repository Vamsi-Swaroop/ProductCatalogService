package dev.ismav.productcatalogservice.dtos;

import dev.ismav.productcatalogservice.models.Category;
import dev.ismav.productcatalogservice.models.Product;

public class ProductDTO {

    private Long id;
    private String description;
    private String name;
    private String imageUrl;
    private Category category;
    private Double price;

    // --- MANUAL GETTERS AND SETTERS ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Your existing implementation
    public Product convertToProduct() {
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        product.setPrice(this.getPrice());
        product.setImageUrl(this.getImageUrl());

        // Corrected the 'if' condition to check this.category
        if (this.getCategory() != null) {
            Category category1 = new Category();
            category1.setName(this.getCategory().getName());
            category1.setId(this.getCategory().getId());
            category1.setDescription(this.getCategory().getDescription());
            product.setCategory(category1);
        }
        return product;
    }
}
