package com.dog.seodang.login.auth;

import httpexception.JsonException;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.dog.seodang.util.SedangResult;

public class MySavedRequestAwareAuthenticationFailHandler extends
		SimpleUrlAuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        String result = JsonException.makeJsonException(SedangResult.CODE.FAIL, exception.getLocalizedMessage());
        response.getOutputStream().println(result);
	}
}
