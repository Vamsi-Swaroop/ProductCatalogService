package dev.ismav.productcatalogservice.controllers;

import dev.ismav.productcatalogservice.dtos.ProductDTO;
import dev.ismav.productcatalogservice.models.Product;
import dev.ismav.productcatalogservice.services.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products") // Global prefix for all methods in this class
public class ProductController {

    // Final ensures the service is not modified after injection
    private final IProductService productService;

    // CONSTRUCTOR INJECTION: This is the best practice for Service injection
    // It prevents NullPointerExceptions and ensures the bean is ready.
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    // POST a product
    // Added @RequestBody so Spring can parse incoming JSON into the DTO
    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productdto) {
        // Implementation: return productService.createProduct(productdto);
        return new ProductDTO();
    }

    // GET product by id
    // Path becomes /products/{id}
    @GetMapping("/{id}")
    public ProductDTO getProductByID(@PathVariable Long id) {
        // Instead of creating new product,  we need to get use of real product from service
        Product product = productService.getAproductByID(id);

        if (product == null) {
            return null;
        }

        // 2️⃣ Convert using Product's method
        return product.convert();
    }

    // GET all products
    // Return type changed to List<ProductDTO>
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        // Implementation: return productService.getAllProducts();
        return null;
    }
}
