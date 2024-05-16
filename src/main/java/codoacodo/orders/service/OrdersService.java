package codoacodo.orders.service;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import codoacodo.orders.model.Order;


@Service

public class OrdersService {
    private final List<Order> orders = new ArrayList<>();

    public List<Order> getAllOrders(){
        return orders;
    }
    public Order addOrder (Order addedOrder){
        orders.add(addedOrder);
        return addedOrder;
    }

}
