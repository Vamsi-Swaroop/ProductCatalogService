package dev.ismav.productcatalogservice.controllers;

import dev.ismav.productcatalogservice.services.IProductService;
import dev.ismav.productcatalogservice.services.StorageProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//We use WebMVC test so that it loads only MVC layer making test faster, isolated and focuses on
//request response handling and hence we can skip @SoringBootTest

//@SpringBootTest
@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {
        @Autowired
        private MockMvc mockMVC;

        @MockBean(name="storageProductService")
        private IProductService productService;
        /*
        getAllProducts
        /products
         */
    @Test
    public void testGetAllProducts_RunSuccessfully() throws Exception {
        mockMVC.perform(get("/products")).andExpect(status().isOk());
    }
}
