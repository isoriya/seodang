package com.dog.seodang.contents;

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
 
	public int registContents(ContentsVo contentsVo) {
		return session.insert("contents.registContents", contentsVo);
	}

	public String getContents(int contetnsSeq) {
		return session.selectOne("contents.getContents", contetnsSeq);
	}

	public List<ContentsHeaderVo> getContentsList(int userSeq) {
		return session.selectList("contents.getContentsList", userSeq);
		
	}
}
