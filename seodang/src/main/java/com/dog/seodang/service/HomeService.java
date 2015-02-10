package com.dog.seodang.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.seodang.dao.HomeDao;

@Service
public class HomeService {

	@Autowired
	HomeDao homeDao;
	
	public String test() throws SQLException {
		return homeDao.test();
	}
}
