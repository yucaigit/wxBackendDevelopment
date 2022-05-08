package com.etc.demo.dao;

import com.etc.demo.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {

    @Select("select *from message where goodsid=#{param1}")
    List<Message> getMessage(Integer goodsid);

    @Insert("insert into message (message,goodsid,sellid,buyid,buyname) values (#{param1},#{param2},#{param3},#{param4},#{param5})")
    boolean addMesage(String msg, Integer goodsid, int sellid, Integer buyid, String buyName);

    @Select("select *from message where sellid = #{param1}")
    List<Message> getMyMessage(Integer id);
}
