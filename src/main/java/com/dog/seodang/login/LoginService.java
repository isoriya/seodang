package com.dog.seodang.login;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service("loginService")
public class LoginService implements UserDetailsService{

	private LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao){
		this.loginDao = loginDao;
	}
	
	private static final Logger logger = LoggerFactory
			.getLogger(LoginService.class);

	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException{
		
		logger.debug("LoginService[loadUserByUsername] userId = " + userId);		 
		
		String userPwd = loginDao.getUserPwd(userId);
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		UserDetails userDetails = new User(userId, userPwd, roles);
		return userDetails;
		
		
	}
}
