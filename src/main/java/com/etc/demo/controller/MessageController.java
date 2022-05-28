package com.etc.demo.controller;

import com.etc.demo.entity.Attribute;
import com.etc.demo.entity.Message;
import com.etc.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("/getMsgNum")
    public int getNumOfMesg(@RequestParam Integer uid){
        return messageService.getNumofMsg(uid);
    }
    @RequestMapping("/getMyAllMes")
    public List<Message> getAllMes(@RequestParam Integer uid){return messageService.getAllMse(uid);}

    @RequestMapping("/updateReplayMs")
    public Boolean updaReply(@RequestParam Integer id,
                             @RequestParam String reply){
        return messageService.updatem(id,reply);
    }
    @RequestMapping("/deletemsg")
    public Boolean deleteMsg(@RequestParam Integer id){return messageService.deleMsg(id);}

}
