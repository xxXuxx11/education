/**
 * 
 */
package com.education.util.yunpian.sdk.api;

import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.User;
import org.junit.Test;

import java.util.Map;

/**
 * 账户API
 * 
 * https://www.yunpian.com/api2.0/api-user.html
 * 
 * @author dzh
 * @date Dec 3, 2016 12:09:10 AM
 * @since 1.2.0
 */
public class TestUserApi extends TestYunpianClient {

	@Test
	public void getTest() {
		Result<User> r = clnt.user().get();
		System.out.println(r);

		// r = ((UserApi) clnt.user().version(VERSION_V1)).get();
		// System.out.println(r);
	}

	@Test
	public void setTest() {
		Map<String, String> param = clnt.newParam(3);
		param.put(EMERGENCY_CONTACT, "dzh");
		param.put(EMERGENCY_MOBILE, "11111111111");
		param.put(ALARM_BALANCE, "10");
		Result<User> r = clnt.user().set(param);
		System.out.println(r);

		// r = ((UserApi) clnt.user().version(VERSION_V1)).set(param);
		// System.out.println(r);
	}

}
