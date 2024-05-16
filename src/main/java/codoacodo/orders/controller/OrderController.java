package codoacodo.orders.controller;

import java.util.List;
import codoacodo.orders.model.Order;
import codoacodo.orders.model.ProductDto;
import codoacodo.orders.service.OrdersService;
import codoacodo.orders.service.ProductClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/orders")

public class OrderController {
    @Autowired OrdersService ordersService;
    @Autowired private ProductClient productClient;

    @GetMapping("")
    private List<Order> getAllOrders(){
        return ordersService.getAllOrders();
    }
    @GetMapping("/products")
    public List<ProductDto> getAllProducts(){
        return productClient.getAllProducts();
       
    }
    
    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
       return ordersService.addOrder(order);
               
    }
    
    
    

}
