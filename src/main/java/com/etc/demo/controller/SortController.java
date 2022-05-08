package com.etc.demo.controller;

import com.etc.demo.entity.Attribute;
import com.etc.demo.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SortController {

    @Autowired
    AttributeService attributeService;

    @RequestMapping("/getsortList")
    public List<Attribute> getSortList() {
        return attributeService.findAll();
    }
}
