package com.etc.demo.service.impl;

import com.etc.demo.dao.MessageMapper;
import com.etc.demo.entity.Message;
import com.etc.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public int getNumofMsg(Integer uid) {
        List<Message> msgList =  messageMapper.getMegNum(uid);
        return msgList.size();
    }

    @Override
    public List<Message> getAllMse(Integer uid) {
        return messageMapper.getAllMs(uid);
    }

    @Override
    public Boolean updatem(Integer id, String reply) {
        return messageMapper.updatem(id,reply);
    }

    @Override
    public Boolean deleMsg(Integer id) {
        return messageMapper.deletMsg(id);
    }
}
