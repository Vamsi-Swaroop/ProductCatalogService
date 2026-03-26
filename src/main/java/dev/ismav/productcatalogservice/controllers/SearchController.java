package dev.ismav.productcatalogservice.controllers;

import dev.ismav.productcatalogservice.dtos.ProductDTO;
import dev.ismav.productcatalogservice.dtos.SearchRequestDTO;
import dev.ismav.productcatalogservice.dtos.SortParams;
import dev.ismav.productcatalogservice.models.Product;
import dev.ismav.productcatalogservice.services.ISearchService;
import dev.ismav.productcatalogservice.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ISearchService searchService;

    @PostMapping
    public Page<ProductDTO> search(@RequestBody SearchRequestDTO searchRequestDTO) {
        Page<Product> products = searchService.searchProducts(searchRequestDTO.getQuery(),
                searchRequestDTO.getPageNo(),
                searchRequestDTO.getPageNo(),
                searchRequestDTO.getSortParams());

        Page<ProductDTO> productDTOS = products.map(product -> product.convert());
        return productDTOS;
    }

}

