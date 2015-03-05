package com.dog.seodang.contents;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dog.seodang.contents.vo.ContentsHeaderVo;
import com.dog.seodang.contents.vo.ContentsVo;

@Repository
public class ContentsDao {
	@Autowired	
    private SqlSession session;
 
	public int registContents(ContentsVo contentsVo) throws SQLException{
		return session.insert("contents.registContents", contentsVo);
	}

	public ContentsVo getContents(int contetnsSeq) throws SQLException{
		return session.selectOne("contents.getContents", contetnsSeq);
	}

	public List<ContentsHeaderVo> getContentsList(int userSeq) throws SQLException{
		return session.selectList("contents.getContentsList", userSeq);
		
	}

	public int modifyContents(ContentsVo contentsVo) throws SQLException{
		return session.update("contents.modifyContents", contentsVo);
	}

	public int deleteContents(int contentsSeq) throws SQLException{
		return session.update("contents.deleteContents", contentsSeq);
	}
}
