package com.etc.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * order
 *
 * @author
 */
@Data
public class Order implements Serializable {
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

    private static final long serialVersionUID = 1L;
}