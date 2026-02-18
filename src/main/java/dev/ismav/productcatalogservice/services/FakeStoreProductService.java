package dev.ismav.productcatalogservice.services;

import dev.ismav.productcatalogservice.Clients.FakeStoreAPIClient;
import dev.ismav.productcatalogservice.dtos.FakeStoreProductDTO;
import dev.ismav.productcatalogservice.models.Product;
import org.jspecify.annotations.Nullable;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    FakeStoreAPIClient fakeStoreAPIClient;
      public FakeStoreProductService(FakeStoreAPIClient fakeStoreAPIClient){
        this.fakeStoreAPIClient=fakeStoreAPIClient;
    }


    @Override
    public Product getAproductByID(Long id) {

        /*FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class,
                id
        );*/
        ResponseEntity<FakeStoreProductDTO> response = fakeStoreAPIClient.requestForEntity(
                HttpMethod.GET,
                "https://fakestoreapi.com/products/{id}",
                null,   // GET has no body
                FakeStoreProductDTO.class,
                id
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
        ResponseEntity<FakeStoreProductDTO[]> response =  fakeStoreAPIClient.requestForEntity(
                HttpMethod.GET,
                "https://fakestoreapi.com/products",
                null,
                FakeStoreProductDTO[].class
        );

        List<Product> result = new ArrayList<>();
        if(response.hasBody() &&
                response.getStatusCode().equals((HttpStatusCode.valueOf(200)))){
                FakeStoreProductDTO[] fakeStoreProductDTOS = response.getBody();
                for(FakeStoreProductDTO fakeProduct: fakeStoreProductDTOS){
                        result.add(FakeStoreProductDTO.toProduct(fakeProduct));
                }
                return result;
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product, Long id) {

        FakeStoreProductDTO fakeStoreProductDTO =
                product.convertToFakeStoreProductDTO();

        ResponseEntity<FakeStoreProductDTO> response =
                fakeStoreAPIClient.requestForEntity(
                        HttpMethod.PUT,
                        "https://fakestoreapi.com/products/{id}",
                        fakeStoreProductDTO,
                        FakeStoreProductDTO.class,
                        id
                );

        if (response.hasBody() && response.getStatusCode().is2xxSuccessful()) {
            FakeStoreProductDTO body = response.getBody();
            return body.toProduct(body);
        }

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