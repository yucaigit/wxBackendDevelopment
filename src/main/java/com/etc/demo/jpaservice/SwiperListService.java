package com.etc.demo.jpaservice;


import com.etc.demo.entity.SwiperListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwiperListService extends JpaRepository<SwiperListEntity, Long> {

}
