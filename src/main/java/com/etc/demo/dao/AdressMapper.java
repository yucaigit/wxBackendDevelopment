package com.etc.demo.dao;

import com.etc.demo.entity.Adress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdressMapper {
    int insert(Adress adress);

    @Select("select * from adress where uid = #{uid}")
    List<Adress> getAdress(Integer uid);
}
