package com.etc.demo.dao;


import com.etc.demo.entity.Order;
import com.etc.demo.entity.ReturnOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@Mapper

public interface OrderDao {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

//    @Select("select *from orders left join goods on user_id = #{uid}")
    List<Order> findAll(int uid);

    int deleteById(Integer orderId);

    Boolean updateOrderState(Integer oId);

    boolean addOrder(Integer uid, Integer goodsid);

    @Select("select a.g_name from goods a,orders b where b.goods_id=a.g_id")
    Set<String> getGoodsName();

    @Select("select a.g_name from goods a,orders b where b.goods_id=a.g_id")
    List<String> getGoodsNameAndValue();

    List<ReturnOrder> getOrders();

    @Update("UPDATE orders SET order_state = 5 where order_id = #{param1}")
    boolean changeOrderState(Integer oId);

    @Select("select *from orders where order_id = #{param1}")
    Order getOneOrder(Integer orderid);

    @Select("select * from orders where user_id = #{param1}")
    List<Order> getOrdersByUserid(Integer userid);

//    得到全部金额
    List<Order> getAllOrder();

    List<Order> succOrder(Integer uid);

    @Select("SELECT SUM(order_amount) from orders")
    int getOrderCunt();

    @Delete("delete from orders where order_id = #{param1}")
    Boolean deleteOrder(Integer oid);
}