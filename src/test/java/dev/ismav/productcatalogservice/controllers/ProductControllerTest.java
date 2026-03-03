package dev.ismav.productcatalogservice.controllers;

import dev.ismav.productcatalogservice.dtos.ProductDTO;
import dev.ismav.productcatalogservice.models.Product;
import dev.ismav.productcatalogservice.services.IProductService;
import dev.ismav.productcatalogservice.services.StorageProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private StorageProductService productService;

    /*
    Happy Case for getproductByID
    Lets create a product and add a condition
    that when productService.getProductID is called with the id
    which we pass in the product controller method
    then it has to return this newly created product
    */

    @Test
   public void TestGetProductById_WithValidId_RunSuccessfully() {
       Product product = new Product();
       product.setId(1L);
       product.setName("Iphone17");
       product.setDescription("Best in class");
       product.setPrice(999.00);

       when(productService.getAproductByID(1L)).thenReturn(product);

       /*
       When we try to test getProductID, are we calling real service,
       Definitely NO. We have mocked the service layer.
        */

       /*
       Step-2 ACT:

        */
       ProductDTO productDTOEntity=productController.getProductByID(1L);

       /*
       Step-3 Assert
        */
        assertNotNull(productDTOEntity);
        //validated with only id, can be validated through name, description etc
        assertEquals(1L,productDTOEntity.getId());

        //verify() is used how many times the method is called while testing

   }
   /*
        SAD CASE SCENARIO FOR GET PRODUCT BY ID
         */
    @Test
    public void testGetProductByID_WithNegativeId_throwsIllegalArgumentException(){

        //Here in this case we really do not need anything i.,e. the first A.
        //Also we will not be reaching service since we are giving an negative Id,
        //hence we will not need the second A as well
        assertThrows(IllegalArgumentException.class,()-> {
            productController.getProductByID(-1L);
        });
    }
}