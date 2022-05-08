package com.etc.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * goods
 *
 * @author
 */
@Data
public class Goods implements Serializable {
    private Integer gId;
    private String gName;

    private Integer gAttributes;

    private String gImg1;

    private String gPrice;

    private String gDateUp;

    private String gDateDown;

    private Integer gUid;

    private String gAdress;

    private Integer gIfree;

    private String gChange;

    private String gState;

    private Integer gA;

//    商品状态 0为未上架 1为上架
    private Integer gB;

    private String gC;

    private String gImg2;

    private String gDescribe;

    private List<Imgs> imgs;

    private static final long serialVersionUID = 1L;
}