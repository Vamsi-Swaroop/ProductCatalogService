package dev.ismav.productcatalogservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
        /*
        name
        description
        price
        imageUrl
        Category
         */

    private  String name;
    private  String desc;
    private  long price;
    private String imageUrl;
    private Category category;
}

