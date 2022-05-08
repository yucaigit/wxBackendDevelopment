package com.etc.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class ReturnOrder implements Serializable {
    private Integer orderId;

    private Integer userId;

    private Integer goodsId;

    private Integer shoppingId;

    private Integer orderState;

    private Timestamp orderSendtime;

    private Timestamp orderEndtime;

    private String orderDescribe;

    private Integer orderAmount;

    private Goods goods;
    private Users users;
    private static final long serialVersionUID = 1L;
}
