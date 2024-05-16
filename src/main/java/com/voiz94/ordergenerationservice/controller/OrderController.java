package com.voiz94.ordergenerationservice.controller;

import com.voiz94.ordergenerationservice.model.Order;
import com.voiz94.ordergenerationservice.service.interfaces.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private IOrderService service;

    @GetMapping("/save_order")
    public Order saveOrder(String name, String description) {
        return service.saveOrder(service.generateOrder(name, description));
    }

    @PostMapping("/get_all_orders")
    public List<Order> getAllOrders(){
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable UUID id){
        return service.getOrderById(id);
    }

    @DeleteMapping("remove_order_by_id/{id}")
    public void removeOrderById(@PathVariable UUID id){
        service.removeOrderById(id);
    }
}
