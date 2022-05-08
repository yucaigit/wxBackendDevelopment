package com.etc.demo.service;


import com.etc.demo.entity.Goods;

import java.util.List;

public interface GoodsService {
    void sum1(Integer g_id);

    //    根据id 查询
    Goods selectByPrimaryKey(int g_id);

    void updateGA(Integer g_id);

    List<Goods> selectLikeQuery(String query);

    Goods findOne(Integer g_id);

    boolean saveGoods(String name, String attribute, String s, String price, String senTime, Integer id, String adress, String textarea, List<String> imgsList);

    List<Goods> getFreeGoods();

    List<Goods> selectLikeAdress(String adress);

    List<Goods> getAllG();

    int findUserId(Integer goodsid);
}
