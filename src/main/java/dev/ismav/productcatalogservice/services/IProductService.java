package dev.ismav.productcatalogservice.services;

import dev.ismav.productcatalogservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {

    Product getAproductByID(Long id);
    List<Product> getAllProducts();
    Product createAProduct(Product input);

}
