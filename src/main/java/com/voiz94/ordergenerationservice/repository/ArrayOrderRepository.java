package com.voiz94.ordergenerationservice.repository;

import com.voiz94.ordergenerationservice.model.Order;
import com.voiz94.ordergenerationservice.repository.interfaces.IOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ArrayOrderRepository implements IOrderRepository {
    private final List<Order> ORDERS = new ArrayList<>();

    @Override
    public Order saveOrder(Order order) {
        ORDERS.add(order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return ORDERS;
    }

    @Override
    public Optional<Order> getOrderById(UUID id) {
        return Optional.ofNullable(ORDERS.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public void removeOrderById(UUID id) {
        ORDERS.removeIf(o -> o.getId().equals(id));
    }
}
