package com.iue.pocketdoc.http;

import com.android.volley.VolleyError;



public class BusinessError extends VolleyError {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4394102250384368242L;
	private ReturnInfo returnInfo;

	public BusinessError(ReturnInfo returnInfo) {
		this.returnInfo = returnInfo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return returnInfo.getReturnMsg();
	}

	public ReturnInfo getReturnInfo() {
		return returnInfo;
	}

	public void setReturnInfo(ReturnInfo returnInfo) {
		this.returnInfo = returnInfo;
	}

}
