package com.iue.pocketdoc.http;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;


public class VolleyHttpRequest {

	public static <T> void volleyGsonRequest(String url,
			final Map<String, String> map, VolleyHandler<T> volleyRequest) {
		GsonRequest<T> gsonRequest = new GsonRequest<T>(Method.POST, url,
				volleyRequest.reqLis, volleyRequest.reqErr) {

			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				// TODO Auto-generated method stub
				Map<String, String> headers = new HashMap<String, String>();
				headers.put("os", "android");
				headers.put("version", "1.0.0.0");
				headers.put("token", "123456789");
				return headers;
			}

			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				return map;
			}

//			 @Override
//			 public String getBodyContentType() {
//			 // TODO Auto-generated method stub
//			 return "application/json";
//			 }

		};
		gsonRequest.setTag("gsonrequest");
		// gsonRequest.set
		//IUEApplication.getQueue().add(gsonRequest);
	}

}
