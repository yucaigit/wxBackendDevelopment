package com.etc.demo.webSocket;
import javax.websocket.Session;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 定义会话存储
 *
 * @author yucai
 * @version 1.0.0
 * @date 2021/6/22 9:50
 */
public class SocketStorage {

    private SocketStorage(){}

    /**
     * 根据name存储的Socket会话Map
     * key:name, value:session
     */
    public static ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();    /**
     * 根据Socket会话ID存储的name的Map
     * key:sessionId, value:name
     */
    public static ConcurrentHashMap<String, String> nameMap = new ConcurrentHashMap<>();
}
