package com.dog.seodang.contents;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.seodang.contents.vo.ContentsHeaderVo;
import com.dog.seodang.contents.vo.ContentsVo;
import com.dog.seodang.util.SeoDangUtils;

@Service
public class ContentsService {

	@Autowired
	ContentsDao contentsDao;


	public int registContents(ContentsVo contentsVo) throws SQLException{
		return contentsDao.registContents(contentsVo);
	}


	public ContentsVo getContents(int contetnsSeq) throws SQLException{
		return contentsDao.getContents(contetnsSeq);
	}


	public List<ContentsHeaderVo> getContentsList(int userSeq) throws SQLException{
		return contentsDao.getContentsList(userSeq);

	}


	public boolean modifyContents(ContentsVo contents) throws SQLException{
		return SeoDangUtils.isMoreThanZero(contentsDao.modifyContents(contents));
	}


	public boolean deleteContents(int contentsSeq) throws SQLException{
		return SeoDangUtils.isMoreThanZero(contentsDao.deleteContents(contentsSeq));
	}
}
