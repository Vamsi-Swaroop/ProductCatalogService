package dev.ismav.productcatalogservice.Clients;

import dev.ismav.productcatalogservice.dtos.FakeStoreProductDTO;
import dev.ismav.productcatalogservice.models.Product;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreAPIClient {

    RestTemplate restTemplate = new RestTemplate();



    public FakeStoreAPIClient(RestTemplate restTemplate){
        this.restTemplate= restTemplate;
    }
    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request, Class<T> responseType, @Nullable Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url,httpMethod, requestCallback, responseExtractor, uriVariables);
    }

}
