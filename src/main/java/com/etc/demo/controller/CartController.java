package com.etc.demo.controller;

import com.etc.demo.dao.OrderDao;
import com.etc.demo.entity.CartsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    private static int uid=0;
    @Autowired
    OrderDao orderDao;


    @RequestMapping("getUserid")
    public int getUid(@RequestParam Integer id){
        uid=id;
        return id;}

    @RequestMapping("/cartPay")
    public boolean cartPay(@RequestBody List<CartsEntity> list){
        for (CartsEntity cartsEntity : list){
            int goodsid = cartsEntity.getGoodsId();
            orderDao.addOrder(uid,goodsid);
        }
        return true;}

}
