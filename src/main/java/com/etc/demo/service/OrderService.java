package com.etc.demo.service;


import com.etc.demo.entity.Order;
import com.etc.demo.entity.ReturnOrder;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface OrderService {
    List<Order> getAll(Integer uid);

    Boolean deleteById(Integer orderId);

    Boolean updateOrderState(Integer oId);


    Set<String> getGoodsName();

    Map<String, Integer> getOrderNum();

    List<ReturnOrder> getOrders();

    boolean changeOrderId(Integer oId);
}
