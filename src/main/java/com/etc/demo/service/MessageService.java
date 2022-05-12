package com.etc.demo.service;

import com.etc.demo.entity.Message;

import java.util.List;

public interface MessageService {
    int getNumofMsg(Integer uid);

    List<Message> getAllMse(Integer uid);


    Boolean updatem(Integer id, String reply);

    Boolean deleMsg(Integer id);
}
