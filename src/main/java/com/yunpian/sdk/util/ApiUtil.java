/**
 * 
 */
package com.yunpian.sdk.util;

import com.yunpian.sdk.constant.YunpianConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * api参数／返回值处理工具
 * 
 * @author dzh
 * @date Nov 25, 2016 12:08:31 PM
 * @since 1.2.0
 */
public class ApiUtil {

    static final Logger LOG = LoggerFactory.getLogger(ApiUtil.class);

    static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final Date str2date(String date) {
        if (date == null || "".equals(date))
            return null;

        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            LOG.error(date + "-" + e.getMessage(), e.fillInStackTrace());
        }
        return null;
    }

    public static final String urlEncode(String text, String charset) {
        if (charset == null || "".equals(charset))
            charset = YunpianConstant.HTTP_CHARSET_DEFAULT;
        try {
            return URLEncoder.encode(text, charset);
        } catch (UnsupportedEncodingException e) {
            LOG.error(e.getMessage(), e.fillInStackTrace());
        }
        return text;
    }

    /**
     * @since 1.2.2
     * @param charset
     * @param seperator
     * @param text
     * @return encode(text[0],charset)+seperator+encode(text[1],charset)....seperator+encode(text[n],charset)
     */
    public static final String urlEncodeAndLink(String charset, String seperator, String... text) {
        if (text.length == 0)
            return "";
        if (charset == null || "".equals(charset))
            charset = YunpianConstant.HTTP_CHARSET_DEFAULT;
        if (seperator == null) {
            seperator = YunpianConstant.SEPERATOR_COMMA;
        }

        int len = 0;
        for (String t : text) {
            len += t.length();
        }

        StringBuilder buf = new StringBuilder(len + text.length - 1);
        try {
            buf.append(URLEncoder.encode(text[0], charset));
            for (int i = 1; i < text.length; i++) {
                buf.append(seperator);
                buf.append(URLEncoder.encode(text[i], charset));
            }
        } catch (UnsupportedEncodingException e) {
            LOG.error(e.getMessage(), e.fillInStackTrace());
        }
        return buf.toString();
    }

}
