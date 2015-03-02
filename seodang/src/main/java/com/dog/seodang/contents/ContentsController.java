package com.dog.seodang.contents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dog.seodang.contents.vo.ContentsVo;
import com.dog.seodang.util.SedangResult;

@Controller
@RequestMapping("/contents")
public class ContentsController {
	private static final Logger logger = LoggerFactory
			.getLogger(ContentsController.class);
	
	@Autowired
	ContentsService contentsService;
	
	@RequestMapping(value = "/registContents", method = RequestMethod.POST)
	public ModelAndView registContents(@RequestParam int userSeq, String contents ) {
		
		logger.info("[registContents] userSeq=" + userSeq +  " ,contents=" + contents);
		ModelAndView modelAndView = new ModelAndView();
		try {
			ContentsVo contentsVo = new ContentsVo();
			contentsVo.setUserSeq(userSeq);
			contentsVo.setContents(contents);
			contentsService.registContents(contentsVo);
			
			int contentsSeq = contentsVo.getContentsSeq();
			
			modelAndView.setViewName("jsonView");
			modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SUCCESS);
			modelAndView.addObject("contentsSeq", contentsSeq);
		} catch (Exception e) {
			logger.error("[registContents] userSeq=" + userSeq +  " ,contents=" + contents + ""
					+ " ,Exception=" + e.getMessage());
			modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SERVER_ERROR);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/getContents", method = RequestMethod.GET)
	public ModelAndView getContents(@RequestParam int contetnsSeq) {
		
		logger.info("[getContents] contetnsSeq=" + contetnsSeq);
		ModelAndView modelAndView = new ModelAndView();
		try {
			String contents = contentsService.getContents(contetnsSeq);
			
			modelAndView.setViewName("jsonView");
			
			
			if(contents == null) {
				modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.NO_EXSIST);
			} else {
				modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SUCCESS);
				modelAndView.addObject("contentsSeq", contents);
			}
		} catch (Exception e) {
			logger.error("[getContents] contetnsSeq=" + contetnsSeq + " ,Exception=" + e.getMessage());
			modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SERVER_ERROR);
		}
		return modelAndView;
	}
}
