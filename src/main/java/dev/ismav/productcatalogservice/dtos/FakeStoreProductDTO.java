package dev.ismav.productcatalogservice.dtos;

import dev.ismav.productcatalogservice.models.Category;
import dev.ismav.productcatalogservice.models.Product;

public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private Double price;       // Changed to Double to match FakeStore JSON
    private String category;
    private String description;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
// Getters and Setters ... (Keep yours, but update price to Double)

    /**
     * Corrected toProduct Method
     * 1. Made it STATIC so you can call it without an instance.
     * 2. It takes a DTO and returns a Product.
     */
    public static Product toProduct(FakeStoreProductDTO dto) {
        if (dto == null) return null;

        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice()); // No more parseDouble needed if type is Double
        product.setImageUrl(dto.getImage());

        Category cat = new Category();
        cat.setName(dto.getCategory());
        product.setCategory(cat);

        return product;
    }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
