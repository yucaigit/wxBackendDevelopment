package com.etc.demo.hmwebsocket;

import lombok.Data;
//浏览器发送服务端数据
@Data
public class Message {
    private String toName;
    private String message;
}
