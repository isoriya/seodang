package com.dog.seodang.home;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {
	@Autowired
    private SqlSession query;
 
    public String test() throws SQLException {
        return query.selectOne("query.test");
        
    }
}
