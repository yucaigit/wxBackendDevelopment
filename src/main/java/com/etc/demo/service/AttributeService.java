package com.etc.demo.service;

import com.etc.demo.entity.Attribute;

import java.util.List;

public interface AttributeService {
    int selectIdByAName(String name);

    List<Attribute> findAll();
}
