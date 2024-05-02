package com.voiz94.ordergenerationservice.service.interfaces;

import com.voiz94.ordergenerationservice.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IOrderService {
    Order generateOrder(String name, String description);
    Order saveOrder(Order order);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(UUID id);
    void removeOrderById(UUID id);
}
