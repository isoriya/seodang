package com.dog.seodang.contents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.seodang.contents.vo.ContentsHeaderVo;
import com.dog.seodang.contents.vo.ContentsVo;

@Service
public class ContentsService {

	@Autowired
	ContentsDao contentsDao;


	public int registContents(ContentsVo contentsVo) {
		return contentsDao.registContents(contentsVo);
	}


	public String getContents(int contetnsSeq) {
		return contentsDao.getContents(contetnsSeq);
	}


	public List<ContentsHeaderVo> getContentsList(int userSeq) {
		return contentsDao.getContentsList(userSeq);

	}
}
