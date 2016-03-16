package com.iue.pocketdoc.http;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;

public class VolleyErrorHelper {

	private static boolean isNetworkProblem(Object error) {
		return (error instanceof NetworkError)
				|| (error instanceof NoConnectionError);
	}

	private static boolean isServerProblem(Object error) {
		return (error instanceof ServerError)
				|| (error instanceof AuthFailureError)
				|| (error instanceof ParseError);
	}

	public static ReturnInfo handleServerError(Object error) {
		ReturnInfo returnInfo = new ReturnInfo();
		if (error instanceof BusinessError) {

		}
		if (isNetworkProblem(error)) {

		}
		if (isServerProblem(error)) {

		}
		if (error instanceof TimeoutError) {

		}
		return returnInfo;
	}

}
