package codoacodo.orders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import codoacodo.orders.model.ProductDto;


@FeignClient(name = "product-api")
public interface ProductClient {
    @GetMapping("/products")
    List<ProductDto> getAllProducts();

    @GetMapping("/products/{id}")
    Optional<ProductDto> getProductById(@PathVariable("id") Long productId);

}
