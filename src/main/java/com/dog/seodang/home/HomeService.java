package com.dog.seodang.home;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

	@Autowired
	HomeDao homeDao;
	
	public String test() throws SQLException {
		return homeDao.test();
	}
}
