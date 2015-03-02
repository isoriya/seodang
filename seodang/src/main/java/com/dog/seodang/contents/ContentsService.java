package com.dog.seodang.contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
