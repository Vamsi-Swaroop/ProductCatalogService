package dev.ismav.productcatalogservice.controllers;

import dev.ismav.productcatalogservice.dtos.ProductRequestDTO;
import dev.ismav.productcatalogservice.dtos.ProductResponseDTO;
import dev.ismav.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController  //This class will be ready to receive requests
public class ProductController {


    //post a product(into database)
    @PostMapping("/products")
    ProductResponseDTO createProduct(ProductRequestDTO productdto){
        ProductResponseDTO product = new ProductResponseDTO();
        return  product;
    }

    //GET product by id
    @PostMapping("/products/{id}")
    ProductResponseDTO getProductByID(@PathVariable Long id){
        return new ProductResponseDTO();
    }

    //get all products
    @GetMapping("/products")
    String getAllProducts(){
        //return new ArrayList<ProductResponseDTO>();
        return "Hey Vams!!";
    }
}
