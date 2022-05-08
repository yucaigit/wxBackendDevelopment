package com.etc.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class Message implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String message;

    /**
     *
     */
    private Integer goodsid;

    /**
     *
     */
    private Integer sellid;

    /**
     *
     */
    private Integer buyid;

    /**
     *
     */
    private Timestamp selltime;

    /**
     *
     */
    private Timestamp buytime;

    /**
     *
     */
    private String buyname;
}
