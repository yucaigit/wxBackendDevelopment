package com.etc.demo.entity;

import lombok.Data;

@Data
public class UserInfo {

    private Integer id;

    private String nickName;

    private String gender;

    private String language;

    private String city;

    private String province;

    private String country;

    private String avatarUrl;
}
