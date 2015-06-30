package com.dog.seodang.home;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	HomeService homeService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test() {
		logger.info("Welcome test");
		List<String> list = new ArrayList<String>();
		list.add("사이트 관리");
		list.add("관리자 관리");
		list.add("공통 코드 관리");
		list.add("접속 이력");

		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "cat");
		map.put("2", "dog");
		map.put("3", "tiger");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		modelAndView.addObject("menuList", list);
		modelAndView.addObject("animal", map);
		String str;
		try {
			str = homeService.test();
			logger.info("결과 a=" + str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modelAndView;

	}
}
