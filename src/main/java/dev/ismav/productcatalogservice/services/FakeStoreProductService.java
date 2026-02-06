package dev.ismav.productcatalogservice.services;

import dev.ismav.productcatalogservice.dtos.FakeStoreProductDTO;
import dev.ismav.productcatalogservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    // Initialize the RestTemplate directly
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Product getAproductByID(Long id) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class,
                id
        );

        // Ensure you are calling the static method correctly as discussed before
        return FakeStoreProductDTO.toProduct(fakeStoreProductDTO);
    }

    @Override
    public Product createAProduct(Product input){
        return null;
    }

    @Override
    public List<Product> getAllProducts(){
        return null;
    }
}
