package com.etc.demo.service.impl;

import com.etc.demo.dao.AttributeMapper;
import com.etc.demo.dao.GoodsDao;
import com.etc.demo.entity.Attribute;
import com.etc.demo.entity.Goods;
import com.etc.demo.service.AttributeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {


    @Autowired
    AttributeMapper attributeMapper;
    @Autowired
    GoodsDao goodsDao;

    @Override
    public int selectIdByAName(String name) {
        System.out.println("Service Impl ============" + name);
        int aId = attributeMapper.selectIdByName(name);
        return aId;
    }

    @Override
    public List<Attribute> findAll() {
        List<Attribute> attributesList = attributeMapper.findAll();
        for (Attribute a :
                attributesList) {
            System.out.println(a);

        }
        return attributesList;
    }
}
