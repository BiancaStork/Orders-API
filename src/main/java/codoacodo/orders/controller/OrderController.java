package codoacodo.orders.controller;

import java.util.List;
import java.util.Optional;

import codoacodo.orders.model.Order;
import codoacodo.orders.model.ProductDto;
import codoacodo.orders.service.OrdersService;
import codoacodo.orders.service.ProductClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/orders")

public class OrderController {
    @Autowired OrdersService ordersService;
    @Autowired ProductClient productClient;

    @GetMapping("")
    private List<Order> getAllOrders(){
        return ordersService.getAllOrders();
    }
    @GetMapping("/products")
    public List<ProductDto> getAllProducts(){
        return productClient.getAllProducts();
       
    }
    
    @GetMapping("/products/{id}")
    public Optional<ProductDto> productById(@PathVariable Long id) {
        System.out.println(id);
        return productClient.getProductById(id);
    }
    
    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order, @RequestParam Long id) {
        System.out.println("Id de producto pasado por parametro:" + id);
       return ordersService.addOrder(order, id);               
    }
    
    
    

}
