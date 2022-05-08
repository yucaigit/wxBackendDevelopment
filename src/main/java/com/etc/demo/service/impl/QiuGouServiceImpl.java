package com.etc.demo.service.impl;

import com.etc.demo.dao.QiuGouMapper;
import com.etc.demo.entity.QiugouEntity;
import com.etc.demo.service.QiugouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class QiuGouServiceImpl implements QiugouService {

    private static int a = 0;
    private static QiugouEntity[] qiugouEntities;
    private static int size;
    @Autowired
    QiuGouMapper qiuGouMapper;

    @Override
    public String getNotic() {
        List<QiugouEntity> userList = null;
        if (a == 0) {
            userList = qiuGouMapper.getNotic();
            a = 1;
            size = userList.size();
            qiugouEntities = userList.toArray(new QiugouEntity[size]);
        } else {
            int i = new Random().nextInt(size);
            String str = "用户:" + qiugouEntities[i].getPhone() + " 求购了" + qiugouEntities[i].getNeedGoods() + "请联系他吧！";
            return str;
        }
        return null;


//        userList.stream().forEach(user->{
//            String strs = "用户:"+user.getPhone()+"\t需要"+user.getNeedGoods();
//        });

    }

    @Override
    public Boolean savaXuQiu(QiugouEntity qiugouEntity) {
        return qiuGouMapper.savaXuqiu(qiugouEntity.getName(), qiugouEntity.getPhone(), qiugouEntity.getNeedGoods());
    }
}
