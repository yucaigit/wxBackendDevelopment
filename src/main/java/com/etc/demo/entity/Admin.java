package com.etc.demo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName admin
 */
@Data
public class Admin implements Serializable {
    /**
     * 
     */
    private Integer adminId;

    /**
     * 
     */
    private String adminName;

    /**
     * 
     */
    private String adminPhone;

    /**
     * 
     */
    private String adminPassword;

    /**
     * 
     */
    private String adminB;

    private static final long serialVersionUID = 1L;
}