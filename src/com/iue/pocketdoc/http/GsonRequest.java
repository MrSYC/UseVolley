package com.iue.pocketdoc.http;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;


public class GsonRequest<T> extends Request<T> {

	private Listener<T> glistener;

	private Gson gson;

	public GsonRequest(int method, String url, Listener<T> listener,
			ErrorListener errorlistener) {
		super(method, url, errorlistener);
		gson = new Gson();
		glistener = listener;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {

			String jsonString = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
			Map<String, Object> map = jsonToMap(jsonString);
			ReturnInfo returnInfo = (ReturnInfo) map.get("returnInfo");

			if (returnInfo.getReturnEnum() == ReturnEnum.Success) {
				return (Response<T>) Response.success(
						map.get("jsonWSResponse"),
						HttpHeaderParser.parseCacheHeaders(response));
			} else {
				return Response.error(new BusinessError(returnInfo));
			}

		} catch (UnsupportedEncodingException e) {

			return Response.error(new ParseError(e));
		}
	}

	@Override
	protected void deliverResponse(T response) {
		// TODO Auto-generated method stub
		glistener.onResponse(response);
	}

	/**
	 * 将json格式转换成map对象
	 * 
	 * @param jsonStr
	 * @return
	 */
	public Map<String, Object> jsonToMap(String jsonStr) {
		Map<String, Object> objMap = null;
		if (gson != null) {
			java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<Map<String, Object>>() {
			}.getType();
			objMap = gson.fromJson(jsonStr, type);
		}
		return objMap;
	}

}
