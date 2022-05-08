package com.etc.demo.controller;

import com.etc.demo.dao.MessageMapper;
import com.etc.demo.entity.Goods;
import com.etc.demo.entity.GoodsEntity;
import com.etc.demo.entity.Message;
import com.etc.demo.service.GoodsService;
import com.etc.demo.service.QiugouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsListController {

    @Autowired
    QiugouService qiugouService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    MessageMapper messageMapper;

    @RequestMapping("/notification")
    public String requestNotification() {
        return qiugouService.getNotic();
    }

    @RequestMapping("/mianfei")
    public List<Goods> getList() {
        return goodsService.getFreeGoods();
    }

    @RequestMapping("/toncheng")
    public List<Goods> getToncheng(@RequestParam String adress) {
        return goodsService.selectLikeAdress(adress);
    }

    @RequestMapping("/getMessage")
    public List<Message> getMesageList(@RequestParam Integer goodsid){return messageMapper.getMessage(goodsid);}
}
