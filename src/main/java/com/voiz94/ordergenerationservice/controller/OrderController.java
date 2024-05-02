package com.voiz94.ordergenerationservice.controller;

import com.voiz94.ordergenerationservice.model.Order;
import com.voiz94.ordergenerationservice.service.interfaces.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private IOrderService service;

    @GetMapping("/add_order_form")
    public ModelAndView showProductFormForAdd(Model model) {
        model.addAttribute("order", service.generateOrder( null, null));
        model.addAttribute("form_title", "Добавление заказа");
        return new ModelAndView("order_form");
    }

    @PostMapping("/save_order")
    public ModelAndView saveOrder(@ModelAttribute("order") Order order, Model model){
        service.saveOrder(order);
        return new ModelAndView("redirect:/api/v1/orders");
    }

    @GetMapping("/get_all_orders")
    public ModelAndView getAllOrders(Model model){
        model.addAttribute("orders", service.getAllOrders());
        return new ModelAndView("orders");
    }

    @GetMapping("/{id}")
    public ModelAndView getOrderById(@PathVariable UUID id, Model model){
        model.addAttribute("order", service.getOrderById(id));
        return new ModelAndView("order_form");
    }

    @DeleteMapping("remove_order_by_id/{id}")
    public ModelAndView removeOrderById(@PathVariable UUID id, Model model){
        service.removeOrderById(id);
        return new ModelAndView("redirect:/api/v1/orders");
    }
}
