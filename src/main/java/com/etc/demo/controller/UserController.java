package com.etc.demo.controller;

import com.etc.demo.entity.Adress;
import com.etc.demo.entity.QiugouEntity;
import com.etc.demo.entity.UserInfo;
import com.etc.demo.entity.Users;
import com.etc.demo.service.QiugouService;
import com.etc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;


@RestController
public class UserController {
    private static String rquestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}";
    private static final String appId = "wx00184b78fbcf0d17";
    private static final String appSecret = "9f50f97c25b396f46a5de1879f15aed9";

    private static Set<Users> users = new HashSet<>();

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;

    @Autowired
    QiugouService qiugouService;


    @RequestMapping("/wxLogin")
    public Users wxLogin(UserInfo userInfo) {
        System.out.println("用户"+userInfo.getNickName()+"登录");
//        返回一个用户对象
        Users user = userService.login(userInfo);
        users.add(user);
        return user;
    }

    @RequestMapping("/saveAdress")
    public Boolean saveAdress(Adress adress) {
        return userService.saveAdress(adress);
    }

    @RequestMapping("/qiugou")
    public Boolean qiuGou(QiugouEntity qiugouEntity) {
        return qiugouService.savaXuQiu(qiugouEntity);
    }

    @RequestMapping("/onLineUsers")
    public int getOnlines(){
        System.out.println("用户量"+users.size());
        return users.size();
    }

}

