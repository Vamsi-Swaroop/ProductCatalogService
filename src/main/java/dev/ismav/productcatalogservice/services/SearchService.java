package dev.ismav.productcatalogservice.services;

import dev.ismav.productcatalogservice.dtos.SortParams;
import dev.ismav.productcatalogservice.models.Product;
import dev.ismav.productcatalogservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements ISearchService{

    @Autowired
    private ProductRepository productRepo;
    
    @Override
    public Page<Product> searchProducts(String query, Integer pageNo, Integer pageSize, List<SortParams>sortParams) {

        Sort sort = null;

        if(!sortParams.isEmpty()){
            if(sortParams.get(0).getOrder().equals("ASC")){
                sort = sort.by(sortParams.get(0).getParamName()).ascending();
            }else{
                sort = sort.by(sortParams.get(0).getParamName()).descending();
            }

            for(int i = 1 ; i < sortParams.size() ; i++){
                if(sortParams.get(i).getOrder().equals("ASC")) {
                    sort = sort.and(sort.by(sortParams.get(i).getParamName()).ascending());
                }else{
                    sort = sort.and(sort.by(sortParams.get(i).getParamName()).descending());
                }
            }
        }

        return productRepo.findByName(query, PageRequest.of(pageNo,pageSize,sort));

    }
}
