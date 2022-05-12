package com.etc.demo.webSocket;

import com.alibaba.fastjson.JSONObject;
import com.etc.demo.hmwebsocket.MessageUtils;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ServerEndpoint("/websocketapi2/{name}")
public class WebSocketServerEndpoint2 {
    public static Map<String,WebSocketServerEndpoint2> onLineUser = new ConcurrentHashMap<>();
    public static String username;
//    发送消息
    private Session session;
    @OnOpen
    public void open(@PathParam("name") String name, Session session) throws IOException {

        log.info("{}上线了", name);
        onLineUser.put(name,this);
        username = name;
        MessageBody systemMessage = new MessageBody();
        systemMessage.setContent(name+"成功建立连接");
        systemMessage.setFromName(name);
        session.getBasicRemote().sendText(JSONObject.toJSONString(systemMessage));
    }

    @OnMessage
    public void onMessage(Session session,String message) {
        System.out.println("接受到消息"+message);
        log.info("监听到消息：{}", message);
        MessageBody messageBody = JSONObject.parseObject(message, MessageBody.class);
        String toName = messageBody.getToName();
        String msgDate = messageBody.getContent();
        //发送消息
        String sendMsg = MessageUtils.getMessage(false, username, msgDate);
        try {
            onLineUser.get(toName).session.getBasicRemote().sendText(sendMsg);
        } catch (IOException e) {
            log.info("消息发送出错");
            e.printStackTrace();
        }
    }


}
