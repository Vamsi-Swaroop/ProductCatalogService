package dev.ismav.productcatalogservice.services;

import dev.ismav.productcatalogservice.models.Product;
import dev.ismav.productcatalogservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("storageProductService")
public class StorageProductService implements IProductService{
    private ProductRepository productRepository;

    public StorageProductService(ProductRepository productRepository){
        this.productRepository= productRepository;
    }

    @Override
    public Product getAproductByID(Long id){

        //The product this is present by id might present or not
        Optional<Product> productOptional= productRepository.findById(id);
        return productOptional.orElse(null);
    }
    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @Override
    public Product createAProduct(Product input){
        Optional<Product> productOptional = productRepository.findById(input.getId());
        if(productOptional.isEmpty()){
            return createAProduct(input);
        }
        return null; //instead we can throw an exception
    }
    @Override
    public Product updateProduct (Product product, Long productId){
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            return null;
        }
        product.setId(productId);
        product.setCreatedAt(productOptional.get().getCreatedAt());
        return productRepository.save(product);
    }


}
