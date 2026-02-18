package dev.ismav.productcatalogservice.models;

import dev.ismav.productcatalogservice.dtos.FakeStoreProductDTO;
import dev.ismav.productcatalogservice.dtos.ProductDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Product extends BaseModel{
        /*
        name
        description
        price
        imageUrl
        Category
         */

    private  String name;
    private Long id;
    private  String Description;
    private  Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    private String imageUrl;
    private Category category;

    public ProductDTO convert(){
        ProductDTO proDto = new ProductDTO();
        proDto.setName(this.getName());
        proDto.setPrice(this.getPrice());
        proDto.setDescription(this.getDescription());
        proDto.setId(this.getId());
        proDto.setCategory(this.getCategory());
        return proDto;
    }
    public FakeStoreProductDTO convertToFakeStoreProductDTO(){
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(this.getId());
        fakeStoreProductDTO.setTitle(this.getName());
        fakeStoreProductDTO.setPrice(this.getPrice());
        fakeStoreProductDTO.setDescription(this.getDescription());
        fakeStoreProductDTO.setImage(this.getImageUrl());
        if(this.getCategory()!=null){
            fakeStoreProductDTO.setCategory(this.getCategory().getName());
        }
        return  fakeStoreProductDTO;
    }
}

