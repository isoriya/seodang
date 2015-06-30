package com.dog.seodang.login.auth;

import httpexception.JsonException;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import com.dog.seodang.util.SedangResult;

public class MySavedRequestAwareAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {

//	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
//		SavedRequest savedRequest = requestCache.getRequest(request, response);
//
//		if (savedRequest == null) {
//			clearAuthenticationAttributes(request);
//			return;
//		}
//		String targetUrlParam = getTargetUrlParameter();
//		if (isAlwaysUseDefaultTargetUrl()
//				|| (targetUrlParam != null && StringUtils.hasText(request
//						.getParameter(targetUrlParam)))) {
//			requestCache.removeRequest(request, response);
//			clearAuthenticationAttributes(request);
//			return;
//		}
		response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getOutputStream().println(JsonException.makeJsonException(SedangResult.CODE.SUCCESS));
		clearAuthenticationAttributes(request);
	}

//	public void setRequestCache(RequestCache requestCache) {
//		this.requestCache = requestCache;
//	}
}
