package dev.ismav.productcatalogservice.services;

import dev.ismav.productcatalogservice.models.Product;

import java.util.List;


public interface IProductService {

    Product getAproductByID(Long id);
    List<Product> getAllProducts();
    Product createAProduct(Product input);
    Product updateProduct (Product product, Long productId);
}
