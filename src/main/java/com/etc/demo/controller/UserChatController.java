package com.etc.demo.controller;

import com.etc.demo.dao.UsersDao;
import com.etc.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserChatController {
    @Autowired
    UsersDao usersDao;

    @RequestMapping("/chatcontroller/getuser")
    public Users getUserByUserId(@RequestParam Integer userid){return usersDao.getUserByUserId(userid);}
}
