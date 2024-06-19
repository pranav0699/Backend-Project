package com.app.services;

import java.util.List;

import com.app.entities.Order;

public interface OrderService {
	
	List<Order> getAllOrders();
    Order getOrderById(Long id);
    List<Order> getOrdersByUserId(Long userId);
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Long id);
    Order placeOrder(Order order);
    Order updateOrder(Long id, Order order);

}
