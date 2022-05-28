package com.etc.demo.dao;

import com.etc.demo.entity.QiugouEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface QiuGouMapper {

    @Select("select *from qiugou")
    List<QiugouEntity> getNotic();

    @Insert("insert into qiugou (name,phone,needgoods,price) values (#{param1},#{param2},#{param3},#{param4})")
    Boolean savaXuqiu(String name, String phone, String needGoods, BigDecimal price);

    @Select("select *from qiugou")
    List<QiugouEntity> getAll();
}
