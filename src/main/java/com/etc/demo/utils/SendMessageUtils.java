package com.etc.demo.utils;
import com.zhenzi.sms.ZhenziSmsClient;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SendMessageUtils {

   private String apiUrl="https://sms_developer.zhenzikj.com";
   private  String appId = "111457";
   private String appSecret = "bd0523e0-aa67-4409-8e33-9cd77975bc16";
   public JSONObject sendMessage(String phoneNumber){
       try{
           JSONObject json = null;
           ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
           String code = String.valueOf(new Random().nextInt(899999) + 100000);
           Map<String, Object> params = new HashMap<String, Object>();
           params.put("number", phoneNumber);
           params.put("templateId", "9072");
           //这个参数就是短信模板上那两个参数
           String[] templateParams = new String[2];
           templateParams[0] = code;
           templateParams[1] = "2分钟";
           params.put("templateParams", templateParams);
           String result = client.send(params);

            json = new JSONObject(result);
            json.put("phoneNumber",phoneNumber);
            json.put("code",code);
            json.put("createTime",System.currentTimeMillis());
           // 将认证码存入SESSION
            return json;
       }catch(Exception e){
           e.printStackTrace();
           return null;
       }
   }
}
