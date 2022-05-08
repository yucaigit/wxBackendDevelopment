package com.etc.demo.dao;


import com.etc.demo.entity.Imgs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yucai
 * @description 针对表【imgs】的数据库操作Mapper
 * @createDate 2022-04-16 16:04:56
 * @Entity generator.domain.Imgs
 */
@Mapper
@Repository
public interface ImgsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Imgs record);

    int insertSelective(Imgs record);

    Imgs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Imgs record);

    int updateByPrimaryKey(Imgs record);

    void saveImges(String str, int gId);
}
