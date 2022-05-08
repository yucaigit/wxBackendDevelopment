package com.etc.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * users
 *
 * @author
 */
@Data
@Accessors(chain = true)
public class Users implements Serializable {
    private Integer uId;

    private String uName;

    private String uPhone;

    private Integer adressId;

    private Integer cartId;

    //    储存头像信息
    private String uA;

    private Integer orderId;

    private Integer shoppingId;

    private Integer payinfoId;

    //用户状态 0 为正常  1为封掉状态 2为删除 3永久删除
    private Integer uState;

    // 0 为平民 1为管理员
    private Integer grade;

    private static final long serialVersionUID = 1L;
}