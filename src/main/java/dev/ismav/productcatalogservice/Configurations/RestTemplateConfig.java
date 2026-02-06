package dev.ismav.productcatalogservice.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate createRestTemp(){
        return new RestTemplate();
    }
}
