package com.etc.demo.webSocket;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.EOFException;
import java.io.IOException;
import java.util.Date;

@Slf4j
@ServerEndpoint("/websocketapi/{name}")
public class WebSocketServerEndpoint {
/*成功建立连接*/

    @OnOpen
    public void open(@PathParam("name") String name,Session session) throws IOException {
        if (SocketStorage.sessionMap.putIfAbsent(name, session) != null){
            log.error("用户名：{} 已存在", name);
            throw new RuntimeException("用户名已存在，请更换用户名。");
        }
        SocketStorage.nameMap.put(session.getId(),name);
        log.info("{}上线了", name);
        MessageBody systemMessage = new MessageBody();
        systemMessage.setContent(name+"成功建立连接");
        systemMessage.setFromName(name);
        session.getBasicRemote().sendText(JSONObject.toJSONString(systemMessage));
    }
    @OnMessage
    public void handleMessage(Session session,String message) throws IOException {
        System.out.println("接受到消息"+message);
        log.info("监听到消息：{}", message);
        MessageBody messageBody = JSONObject.parseObject(message, MessageBody.class);
        System.out.println(messageBody);

        log.info(messageBody.getToName()+"收消息人的信息");
        if (messageBody == null){
            log.warn("监听到的消息为空或格式不正确，message:{}", message);
            return;
        }
        String fromUser = SocketStorage.nameMap.get(session.getId());
        //设置发消息的人
        messageBody.setFromName(fromUser);
        messageBody.setSendTime(new Date());
        //将消息转发给收消息的人
        Session toSession = SocketStorage.sessionMap.get(messageBody.getToName());

        if (toSession != null){
            toSession.getBasicRemote().sendText(JSONObject.toJSONString(messageBody));
        }else{
            log.info("{}不在线，发送失败", messageBody.getToName());
            MessageBody systemMessage = new MessageBody();
            systemMessage.setContent(messageBody.getToName() + "不在线，发送失败");
            systemMessage.setFromName("system");
            session.getBasicRemote().sendText(JSONObject.toJSONString(systemMessage));
        }
      //  session.getBasicRemote().sendText(msg);
    }


    @OnClose
    public void onClose(Session session){
        String name = SocketStorage.nameMap.remove(session.getId());
        SocketStorage.sessionMap.remove(name);
        log.info("{}下线了", name);
    }
    @OnError
    public void onError(Session session, Throwable error){
        if (error instanceof EOFException && error.getMessage() == null){
            String name = SocketStorage.nameMap.get(session.getId());
            SocketStorage.nameMap.remove(session.getId());
            SocketStorage.sessionMap.remove(name);
            log.info("{}长时间没有活动，连接已断开", name);
        }
    }
}
