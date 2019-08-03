package com.yunpian.sdk.service;

import com.google.gson.reflect.TypeToken;
import com.yunpian.sdk.constant.Config;
import com.yunpian.sdk.constant.YunpianConstant;
import com.yunpian.sdk.model.ResultDO;
import com.yunpian.sdk.model.Template;
import com.yunpian.sdk.util.HttpUtil;
import com.yunpian.sdk.util.JsonUtil;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bingone on 16/1/19.
 */

/**
 * 模板短信操作类
 */
@Deprecated
@SuppressWarnings("serial")
public class TplOperator extends AbstractOperator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String apikey;

	public TplOperator(String apikey) {
		this.apikey = apikey;
	}

	public ResultDO<List<Template>> getDefault() {
		return getDefault("");
	}

	public ResultDO<List<Template>> getDefault(final String tplId) {
		return send(Config.URI_GET_DEFAULT_TPL_SMS, new HashMap<String, String>() {
			{
				put(YunpianConstant.TPL_ID, tplId);
			}
		}, new TypeToken<List<Template>>() {
		}.getType());
	}

	public ResultDO<Template> add(final String Tplcontent) {
		return send(Config.URI_ADD_TPL_SMS, new HashMap<String, String>() {
			{
				put(YunpianConstant.TPL_CONTENT, Tplcontent);
			}
		});
	}

	public ResultDO<List<Template>> get(final String tplId) {
		return send(Config.URI_GET_TPL_SMS, new HashMap<String, String>() {
			{
				put(YunpianConstant.TPL_ID, tplId);
			}
		}, new TypeToken<List<Template>>() {
		}.getType());
	}

	public ResultDO<List<Template>> get() {
		return get("");
	}

	public ResultDO<Template> update(final String tplId, final String Tplcontent) {
		return send(Config.URI_UPD_TPL_SMS, new HashMap<String, String>() {
			{
				put(YunpianConstant.TPL_ID, tplId);
				put(YunpianConstant.TPL_CONTENT, Tplcontent);
			}
		});
	}

	public ResultDO<Template> del(final String tplId) {
		return send(Config.URI_DEL_TPL_SMS, new HashMap<String, String>() {
			{
				put(YunpianConstant.TPL_ID, tplId);
			}
		});
	}

	public <T> ResultDO<T> send(String url, Map<String, String> parms) {
		return send(url, parms, new TypeToken<Template>() {
		}.getType());
	}

	public <T> ResultDO<T> send(String url, Map<String, String> parms, Type t) {
		ResultDO<T> resultDO = new ResultDO<T>();
		parms.put(YunpianConstant.APIKEY, apikey);
		try {
			String ret = HttpUtil.post(url, parms);
			resultDO.setData(JsonUtil.<T>fromJson(ret, t));
			resultDO.setSuccess(true);
		} catch (Throwable e) {
			resultDO.setE(e);
		}
		return resultDO;
	}
}
