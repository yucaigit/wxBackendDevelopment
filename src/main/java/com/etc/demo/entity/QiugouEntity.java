package com.etc.demo.entity;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class QiugouEntity {
    private Integer id;
    private String name;
    private String phone;
    private String needGoods;
    private Integer state;
    private Timestamp update;
}
