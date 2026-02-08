package dev.ismav.productcatalogservice.services;

import dev.ismav.productcatalogservice.dtos.FakeStoreProductDTO;
import dev.ismav.productcatalogservice.models.Product;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    // Initialize the RestTemplate directly
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Product getAproductByID(Long id) {

        /*FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class,
                id
        );*/
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class,id
        );

        if(response.hasBody() && response.getStatusCode().equals(HttpStatusCode.valueOf(200)))
        {
            return response.getBody().toProduct(response.getBody());
        }
        return null;
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


/*

getForEntity func:

public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = this.acceptHeaderRequestCallback(responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = this.responseEntityExtractor(responseType);
        return (ResponseEntity)nonNull((ResponseEntity)this.execute(url, HttpMethod.GET, requestCallback, responseExtractor, uriVariables));
    }
 */