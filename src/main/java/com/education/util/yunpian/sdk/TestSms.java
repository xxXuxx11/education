package com.education.util.yunpian.sdk;


import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.constant.YunpianConstant;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;

import java.util.Map;


public class TestSms implements YunpianConstant {
    YunpianClient clnt=new YunpianClient(TestYunpianClient.TESTKEY,
            TestYunpianClient.class.getResourceAsStream("/yunpian_online.properties")).init();

    public boolean single_sendTest(int num,String phone) {
        Map<String, String> param = clnt.newParam(2);
        param.put(MOBILE, phone);
        System.out.println(num);//
        param.put(TEXT, "【123】您的验证码是"+num);//
        // param.put(EXTEND, "001");
        // param.put(UID, "10001");
        // param.put(CALLBACK_URL, "http://yourreceiveurl_address");
        Result<SmsSingleSend> r = clnt.sms().single_send(param);
        String str=r+"";
        if(str.indexOf("成功")!=-1){
            clnt.close();
            return true;
        }
        System.out.println(r);
        clnt.close();
        return false;

    }
}
