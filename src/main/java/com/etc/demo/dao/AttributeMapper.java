package com.etc.demo.dao;

import generator.domain.Attribute;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yucai
 * @description 针对表【attribute】的数据库操作Mapper
 * @createDate 2022-04-15 22:34:56
 * @Entity generator.domain.Attribute
 */
@Mapper
@Repository
public interface AttributeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    Attribute selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Attribute record);

    int updateByPrimaryKey(Attribute record);

    int selectIdByName(String name);

    List<com.etc.demo.entity.Attribute> findAll();

    @Select("SELECT a_name from attribute")
    List<String> getAllName();

    @Select("select a_id from attribute where a_name = #{param1}")
    int getAllId(String aName);

    @Select("select *from ATTRIBUTE ")
    List<com.etc.demo.entity.Attribute> getAllSort();



    @Select("select *from ATTRIBUTE where a_id = #{param1}")
    com.etc.demo.entity.Attribute getSortDetail(Integer aid);

    @Select("select *from ATTRIBUTE where a_name = #{param1}")
    Boolean isExitSo(String name);

    @Insert("insert into attribute (a_name,a_count) values (#{param1},1)")
    Boolean addSort(String name);

    @Delete("delete from attribute where a_id = #{param1}")
    Boolean deleteSort(Integer aid);

    @Update("update attribute set a_name = #{param2} where a_id = #{param1}")
    Boolean updateSortName(Integer aid, String name);


//    查询分类商品的数量SELECT COUNT(*) from attribute a,goods b WHERE a.a_id = b.g_attributes and a.a_id = 102

}
