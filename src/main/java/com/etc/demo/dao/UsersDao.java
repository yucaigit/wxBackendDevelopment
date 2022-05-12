package com.etc.demo.dao;

import com.etc.demo.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UsersDao {
    int deleteByPrimaryKey(Integer uId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users findUser(String nickName, int uState);

    @Select("select u_name from users where u_id = #{param1}")
    String findUserName(Integer buyid);

    @Select("select * from users")
    List<Users> getUser();

    @Select("select *from users where u_id = #{param1}")
    Users getUserByUserId(Integer userid);

    @Update("update users set u_state = 1 where u_id =#{param1}")
    Boolean updateUserState(Integer userid);

    @Select("select u_name from users where u_id = #{param1}")
    String getOneName(Integer uid);
}