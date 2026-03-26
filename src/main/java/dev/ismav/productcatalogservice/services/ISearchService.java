package dev.ismav.productcatalogservice.services;

import dev.ismav.productcatalogservice.dtos.SortParams;
import dev.ismav.productcatalogservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {
    Page<Product> searchProducts(String query, Integer pageNo, Integer pageSize, List<SortParams> sortParams);
}
