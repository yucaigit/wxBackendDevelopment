package com.etc.demo.dao;

import generator.domain.Attribute;
import org.apache.ibatis.annotations.Mapper;
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
}
