package com.etc.demo.dao;

import com.etc.demo.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
* @author yucai
* @description 针对表【admin】的数据库操作Mapper
* @createDate 2022-05-28 10:30:19
* @Entity com.etc.demo.entity.Admin
*/
@Mapper
@Repository
public interface AdminMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    @Select("select *from admin where admin_name = #{param1} and admin_password = #{param2}")
    Admin selectAdmin(String adminName, String adminPassword);

    @Update("update admin set admin_name = #{param2},admin_phone = #{param4},admin_password = #{param3} where admin_id = #{param1}")
    Boolean updateadmininfo(Integer aid, String name, String password, String phone);

    @Insert("insert into admin (admin_name,admin_phone,admin_password) values (#{param1},#{param2},{param3})")
    Boolean addAdmin(String adminName, String adminPhone, String adminPassword);

    @Select("select *from admin where admin_name=#{param1}")
    Admin selectId(String name);

    @Update("update admin set admin_name = #{param2} where admin_id=#{param1};")
    Boolean onlyUpdateName(Integer id, String name);

    @Update("update admin set admin_password = #{param2} where admin_id = #{param1}")
    Boolean onlyUpdatePwd(Integer id, String pwd);

    @Update("update admin set admin_name=#{param2},admin_password=#{param3} where admin_id = #{param1}")
    Boolean updateAdmin(Integer id, String name, String pwd);
}
