package com.etc.demo.entity;

import lombok.Data;

@Data
public class LoginInfoEntity {
    private String code;
    private String iv;
    private String encryptedData;

}
