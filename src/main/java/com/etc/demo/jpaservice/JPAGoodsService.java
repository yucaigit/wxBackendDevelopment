package com.etc.demo.jpaservice;


import com.etc.demo.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAGoodsService extends JpaRepository<GoodsEntity, Integer> {

}
