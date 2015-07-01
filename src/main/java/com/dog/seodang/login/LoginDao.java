package com.dog.seodang.login;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public class LoginDao extends SqlSessionDaoSupport{

	public String getUserPwd(String userId) {
		return (String)getSqlSession().selectOne("login.getUserPwd", userId);
	}
}
