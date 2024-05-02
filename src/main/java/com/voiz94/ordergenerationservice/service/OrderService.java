package com.voiz94.ordergenerationservice.service;

import com.voiz94.ordergenerationservice.model.Order;
import com.voiz94.ordergenerationservice.repository.interfaces.IOrderRepository;
import com.voiz94.ordergenerationservice.service.interfaces.IOrderService;
import com.voiz94.ordergenerationservice.util.interfaces.IOrderCodeGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService {
    private final IOrderRepository repository;
    private final IOrderCodeGenerator codeGenerator;

    @Override
    public Order generateOrder(String name, String description) {
        return Order.builder().id(codeGenerator.generate()).name(name).description(description).build();
    }

    @Override
    public Order saveOrder(Order order) {
        return repository.saveOrder(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.getAllOrders();
    }

    @Override
    public Optional<Order> getOrderById(UUID id) {
        return repository.getOrderById(id);
    }

    @Override
    public void removeOrderById(UUID id) {
        repository.removeOrderById(id);
    }
}
