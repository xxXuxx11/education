/**
 * 
 */
package com.yunpian.sdk.api;

import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.constant.YunpianConstant;
import org.junit.After;
import org.junit.Before;

/**
 * @author dzh
 * @date Nov 18, 2016 7:58:27 PM
 * @since 1.2.0
 */
public class TestYunpianClient implements YunpianConstant {

	static final String TESTKEY = "44fb6b3154f44d6ddea35de4110ffefc";

	YunpianClient clnt;

	@Before
	public void init() {
		clnt = new YunpianClient(TestYunpianClient.TESTKEY,
				TestYunpianClient.class.getResourceAsStream("/yunpian_online.properties")).init();
	}

	@After
	public void close() {
		clnt.close();
	}

}