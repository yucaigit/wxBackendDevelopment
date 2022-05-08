package com.etc.demo.service.impl;

import com.etc.demo.dao.OrderDao;
import com.etc.demo.entity.Order;
import com.etc.demo.entity.ReturnOrder;
import com.etc.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;



    @Override
    public List<Order> getAll(Integer uid) {
        List<Order> list = orderDao.findAll(uid);
        return list;
    }

    @Override
    public Boolean deleteById(Integer orderId) {
        int i = orderDao.deleteById(orderId);
        if (i >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateOrderState(Integer oId) {
        return orderDao.updateOrderState(oId);
    }

    @Override
    public Set<String> getGoodsName() {
        return orderDao.getGoodsName();
    }

    @Override
    public Map<String, Integer> getOrderNum() {
        Map<String,Integer> map = new HashMap<>();
        List<String> list =orderDao.getGoodsNameAndValue();
        int value =1;
        for (String str : list){
            boolean b = map.containsKey(str);
            if (b){
                Integer integer = map.get(str);

                map.put(str,++integer);
            }else {
                map.put(str,value);
            }
        }
        return map;
    }

    @Override
    public List<ReturnOrder> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    public boolean changeOrderId(Integer oId) {
        return orderDao.changeOrderState(oId);
    }

}
