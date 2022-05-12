package com.etc.demo.hmwebsocket;

import lombok.Data;

@Data
//服务端发送客户端
public class ResultMessage {
    private boolean isSystem;
    private String fromName;
    private Object message;
}
