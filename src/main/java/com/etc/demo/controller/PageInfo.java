package com.etc.demo.controller;

import lombok.Data;

@Data
public class PageInfo {
    private String kw;
    private Integer cid;
    private Integer pageNum;
    private Integer pageSize;

}
