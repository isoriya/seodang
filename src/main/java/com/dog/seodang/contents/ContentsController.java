package com.dog.seodang.contents;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dog.seodang.contents.vo.ContentsHeaderVo;
import com.dog.seodang.contents.vo.ContentsVo;
import com.dog.seodang.util.SedangResult;
import com.dog.seodang.util.SeoDangUtils;

@Controller
@RequestMapping("/contents")
public class ContentsController {
	private static final Logger logger = LoggerFactory
			.getLogger(ContentsController.class);
	
	@Autowired
	ContentsService contentsService;
	
	@RequestMapping(value = "/registContents", method = RequestMethod.POST)
	public ModelAndView registContents(@RequestParam(required=true) int userSeq,
			@RequestParam(required=true) String title,
			@RequestParam(required=true) String contents) {
		
		logger.info("[registContents] userSeq=" + userSeq +  " ,title=" + title +  " ,contents=" + contents);
		ModelAndView modelAndView = new ModelAndView();
		try {
			ContentsVo contentsVo = new ContentsVo();
			contentsVo.setUserSeq(userSeq);
			contentsVo.setTitle(title);
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
	public ModelAndView getContents(@RequestParam(required=true) int contetnsSeq) {
		
		logger.info("[getContents] contetnsSeq=" + contetnsSeq);
		ModelAndView modelAndView = new ModelAndView();
		try {
			ContentsVo contentsVo = contentsService.getContents(contetnsSeq);
			
			modelAndView.setViewName("jsonView");
			
			
			if(contentsVo == null) {
				modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.NO_EXSIST);
			} else {
				modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SUCCESS);
				modelAndView.addObject("contents", contentsVo);
			}
		} catch (Exception e) {
			logger.error("[getContents] contetnsSeq=" + contetnsSeq + " ,Exception=" + e.getMessage());
			modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SERVER_ERROR);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/getContentsList", method = RequestMethod.GET)
	public ModelAndView getContentsList(@RequestParam(required=true) int userSeq) {
		
		logger.info("[getContentsList] userSeq=" + userSeq);
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<ContentsHeaderVo> contentsHeaderVos= contentsService.getContentsList(userSeq);
			
			modelAndView.setViewName("jsonView");
			
			
			if(SeoDangUtils.isListEmpty(contentsHeaderVos)) {
				modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.NO_EXSIST);
			} else {
				modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SUCCESS);
				modelAndView.addObject("contentsList", contentsHeaderVos);
			}
		} catch (Exception e) {
			logger.error("[getContentsList] userSeq=" + userSeq + " ,Exception=" + e.getMessage());
			modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SERVER_ERROR);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/modifyContents", method = RequestMethod.POST)
	public ModelAndView modifyContents(@RequestParam(required=true) int contentsSeq,
			@RequestParam(required=true) String title,
			@RequestParam(required=true) String contents) {
		
		logger.info("[modifyContents] contentsSeq=" + contentsSeq, " contents=" + contents);
		ModelAndView modelAndView = new ModelAndView();
		try {
			ContentsVo contentsVo = new ContentsVo();
			contentsVo.setContentsSeq(contentsSeq);
			contentsVo.setTitle(title);
			contentsVo.setContents(contents);
			boolean result = contentsService.modifyContents(contentsVo);
			
			modelAndView.setViewName("jsonView");
			
			
			if(!result) {
				modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.NO_EXSIST);
			} else {
				modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SUCCESS);
				modelAndView.addObject("contentsSeq", contentsSeq);
			}
		} catch (Exception e) {
			logger.error("[modifyContents] contetnsSeq=" + contentsSeq + " ,Exception=" + e.getMessage());
			modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SERVER_ERROR);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteContents", method = RequestMethod.POST)
	public ModelAndView deleteContents(@RequestParam(required=true) int contentsSeq) {
		
		logger.info("[deleteContents] contentsSeq=" + contentsSeq);
		ModelAndView modelAndView = new ModelAndView();
		try { 
			
			boolean result = contentsService.deleteContents(contentsSeq);
			modelAndView.setViewName("jsonView");
			
			if(!result) {
				modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.NO_EXSIST);
			} else {
				modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SUCCESS);
			}
		} catch (Exception e) {
			logger.error("[deleteContents] contetnsSeq=" + contentsSeq + " ,Exception=" + e.getMessage());
			modelAndView.addObject(SedangResult.RESULT, SedangResult.CODE.SERVER_ERROR);
		}
		return modelAndView;
	}
}
