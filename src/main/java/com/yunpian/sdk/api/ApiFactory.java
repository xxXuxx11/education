/**
 *
 */
package com.yunpian.sdk.api;

import com.yunpian.sdk.YunpianClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dzh
 * @date Nov 23, 2016 1:29:44 PM
 * @since 1.2.0
 */
public class ApiFactory {

    static Logger LOG = LoggerFactory.getLogger(ApiFactory.class);

    private YunpianClient clnt;

    public ApiFactory(YunpianClient clnt) {
        this.clnt = clnt;
    }

    @SuppressWarnings("unchecked")
    public <T extends YunpianApi> T api(String name) {
        T t = null;
        switch (name) {
        case CallApi.NAME:
            t = (T) new CallApi();
            break;
        case FlowApi.NAME:
            t = (T) new FlowApi();
            break;
        case SignApi.NAME:
            t = (T) new SignApi();
            break;
        case SmsApi.NAME:
            t = (T) new SmsApi();
            break;
        case TplApi.NAME:
            t = (T) new TplApi();
            break;
        case UserApi.NAME:
            t = (T) new UserApi();
            break;
        case VoiceApi.NAME:
            t = (T) new VoiceApi();
            break;
        case ShortUrlApi.NAME:
            t = (T) new ShortUrlApi();
            break;
        case VideoSmsApi.NAME:
            t = (T) new VideoSmsApi();
            break;
        }
        if (t != null) t.init(clnt);
        return t;
    }

}
