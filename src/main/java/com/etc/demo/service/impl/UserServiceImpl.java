package com.etc.demo.service.impl;

import com.etc.demo.dao.AdressMapper;
import com.etc.demo.dao.UsersDao;
import com.etc.demo.entity.Adress;
import com.etc.demo.entity.UserInfo;
import com.etc.demo.entity.Users;
import com.etc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersDao usersDao;
    @Autowired
    AdressMapper adressMapper;

    /*
     * @Author yucai
     * @Dream: Code like poem
     * @date 2022/4/9 15:44
     * 1 判断用户状态 存在是否被封号
     * 2 如果没被封号 登录   管理员可以对用户进行封号处理
     */
    @Override
    public Users login(UserInfo userInfo) {
        String nickName = userInfo.getNickName();
        String avatarUrl = userInfo.getAvatarUrl();
        int uState = 0;
        Users user = usersDao.findUser(nickName, uState);
        if (user != null && user.getUState() == 0) {
            return user;
        }
        if (user != null && user.getUState() != 0) {
            return null;
        }
        Users users = new Users().setUName(nickName).setUA(avatarUrl).setUState(0);
        usersDao.insert(users);
        return users;
    }

    @Override
    public Boolean saveAdress(Adress adress) {
        int i = adressMapper.insert(adress);
        if (i >= 0) return true;
        return false;
    }
}
