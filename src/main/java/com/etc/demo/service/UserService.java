package com.etc.demo.service;


import com.etc.demo.entity.Adress;
import com.etc.demo.entity.UserInfo;
import com.etc.demo.entity.Users;

public interface UserService {

    Users login(UserInfo userInfo);

    Boolean saveAdress(Adress adress);
}
