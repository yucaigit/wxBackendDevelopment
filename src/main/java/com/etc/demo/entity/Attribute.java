package com.etc.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * attribute
 *
 * @author
 */
@Data
public class Attribute implements Serializable {
    private Integer aId;
    private String aName;

    private String aGrade;

    private Integer aCount;

    private String aA;

    private String aB;

//   修改时间
    private Timestamp aC;

    private List<Goods> goodsList;

    private static final long serialVersionUID = 1L;
}