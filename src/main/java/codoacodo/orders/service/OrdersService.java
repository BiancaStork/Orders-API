package codoacodo.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        System.out.println("Id Producto pasada por parametro en Servicio" + productId);
        ProductDto product = productClient.getProductById(productId).orElseThrow(() -> new RuntimeException("Product with id " + productId + " not found")); 
        order.setProduct(product);
        orders.add(order);
        return order;
    }

    public Order updateOrder(Order orderUpdate) {
        Long orderId = orderUpdate.getId();
        Order order = orders.stream()
        .filter(o -> o.getId().equals(orderId))
        .findFirst().orElseThrow(()-> new RuntimeException("Order with ID " + orderId + " not found"));
        order.setId(orderId);
        order.setProduct(orderUpdate.getProduct());       
        order.setCustomerEmail(orderUpdate.getCustomerEmail());
        order.setCustomerName(orderUpdate.getCustomerName());
        order.setCustomerPhone(orderUpdate.getCustomerPhone());
        return order;
      }

    public void deleteOrder(Long orderId)  {
        orders.removeIf(order -> order.getId().equals(orderId));
      }

    }




