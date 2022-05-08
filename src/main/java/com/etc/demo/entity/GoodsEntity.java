package com.etc.demo.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@ToString
@Accessors(chain = true)
@Table(name = "goods")
public class GoodsEntity implements Comparable<GoodsEntity> {
    @Id
    private Integer g_id;
    private String g_name;
    private String g_attributes;
    private String g_img1;
    private String g_img2;
    private BigDecimal g_price;
    private String g_date_up;
    private String g_date_down;
    private Integer g_uid;
    private String g_adress;
    private Integer g_ifree;
    private String g_change;
    private String g_state;
    //  热搜等级
    private Integer g_a;

    private String g_b;
    private String g_c;
    private String g_describe;

    //    重写compareTo 比较
    @Override
    public int compareTo(GoodsEntity o) {
        if (this.g_a < o.g_a) {
            return 1;
        } else {
            return -1;
        }
    }
}
