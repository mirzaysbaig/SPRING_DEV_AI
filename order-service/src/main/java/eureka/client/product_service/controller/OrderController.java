package eureka.client.product_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    // Health check endpoint
    @GetMapping("/health")
    public String health() {
        return "Order Service is running";
    }

    // Order endpoint calling Product Service via Eureka
    @GetMapping("/order")
    public String order() {

        // Calling product-service using service name from Eureka
        String url = "http://product-service/api/product";
        String productResponse = restTemplate.getForObject(
                url,
                String.class
        );

        return "Order placed successfully. Product Service Response: " + productResponse;
    }
}