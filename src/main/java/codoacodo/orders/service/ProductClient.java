package codoacodo.orders.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import codoacodo.orders.model.ProductDto;


@FeignClient(name = "product-api")
public interface ProductClient {
    @GetMapping("/products")
    List<ProductDto> getAllProducts();

}
