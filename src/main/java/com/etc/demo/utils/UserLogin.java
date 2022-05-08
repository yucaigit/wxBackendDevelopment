package com.etc.demo.utils;/*
package com.etc.wxplat.utils;

import com.alibaba.fastjson.JSONObject;
import com.etc.wxplat.entity.LoginInfoEntity;
import com.etc.wxplat.entity.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class UserLogin {
    public UserInfo userLogin(LoginInfoEntity loginInfo){
        String code = loginInfo.getCode();
        String iv = loginInfo.getIv();
        String encryptedData = loginInfo.getEncryptedData();
        Map<String,String> params =new HashMap<>();
        params.put("appid",appId);
        params.put("secret",appSecret);
        params.put("js_code",code);
        params.put("grant_type","authorization_code");
        ResponseEntity<String> forEntity = restTemplate.getForEntity(rquestUrl, String.class, params);
        String body = forEntity.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        MapType mapType = TypeFactory.defaultInstance().constructMapType(HashMap.class,String.class,String.class);
        Map<String,String> result = null;
        try {
            result = objectMapper.readValue(body, mapType);
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }
        String openid = result.get("openid");
        String sessionKey = result.get("session_key");
        JSONObject decrypt = null;
        try {
            decrypt= AesCbcUtil.decrypt(encryptedData, sessionKey, iv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(decrypt);
        UserInfo userInfo = new UserInfo();
        userInfo.setCity("aaaa");
        return userInfo;
    }

}
*/
