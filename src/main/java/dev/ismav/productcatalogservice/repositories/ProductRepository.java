package dev.ismav.productcatalogservice.repositories;

import dev.ismav.productcatalogservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{


}
