package com.etc.demo.controller;

import com.etc.demo.entity.Order;
import com.etc.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/getOrders")
    public List<Order> getOrder(@RequestParam Integer uid) {
        List<Order> list = orderService.getAll(uid);
        return list;
    }

    @RequestMapping("/removeOrderById")
    public boolean removeOrderById(@RequestParam Integer oId) {


        return orderService.changeOrderId(oId);
    }

    @RequestMapping("/confirmResive")
    public boolean confirmResive(@RequestParam Integer oId) {
        return orderService.updateOrderState(oId);
    }
}
