package com.iue.pocketdoc.http;

import com.iue.pocketdoc.http.ReturnEnum;

public class ReturnInfo {
	private ReturnEnum returnEnum;
	private String returnCode;
	private String returnMsg;
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public ReturnEnum getReturnEnum() {
		return returnEnum;
	}
	public void setReturnEnum(ReturnEnum returnEnum) {
		this.returnEnum = returnEnum;
	}
}
