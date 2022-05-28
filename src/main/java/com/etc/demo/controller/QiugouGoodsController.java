package com.etc.demo.controller;

import com.etc.demo.dao.QiuGouMapper;
import com.etc.demo.entity.QiugouEntity;
import com.etc.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QiugouGoodsController {

    @Autowired
    QiuGouMapper qiuGouMapper;
    @Autowired
    GoodsService goodsService;
    @RequestMapping("/getQiugouGoods")
    public List<QiugouEntity> qiugou(){return qiuGouMapper.getAll();}

    @RequestMapping("/searchGoods")
    public Boolean searchqiugouGoods(@RequestParam Integer uid,
                                     @RequestParam String needName){
        return goodsService.qiugouGoods(uid,needName);
    }
}
