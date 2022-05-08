package com.etc.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@ToString
@Table(name = "swiperlist")
public class SwiperListEntity {
    @Id
    @GeneratedValue
    private Integer s_Id;

    private String s_Name;
    private String s_Src;
    private String s_Sort;
    private String s_A;
    private String s_B;
}
