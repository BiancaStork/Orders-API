package codoacodo.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import codoacodo.orders.model.Order;
import codoacodo.orders.model.ProductDto;


@Service

public class OrdersService {
    @Autowired
    ProductClient productClient;

    private final List<Order> orders = new ArrayList<>();
    public List<Order> getAllOrders(){
        return orders;
    }

    

    public Order addOrder (Order order, @RequestParam Long productId){
        //obtengo el producto con el id pasado por parametro
        System.out.println("Id Producto pasada por parametro" + productId);
        ProductDto product = productClient.getProductById(productId).orElseThrow(() -> new RuntimeException("Product with id " + productId + " not found")); 
        order.setProduct(product);
        orders.add(order);
        return order;
    }

}
