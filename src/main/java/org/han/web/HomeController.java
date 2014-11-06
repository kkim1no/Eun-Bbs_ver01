package org.han.web;

import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.han.service.BbsService;
import org.han.vo.BbsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/hanBbs/*")
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Inject
	BbsVO vo;

	@Inject
	BbsService service;

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

		return "hanBbs/home";
	}

	
	//새글 등록 페이지 보여주기
	@RequestMapping(value = "/create")
	public String create() {

		/* service.create(vo); */
		return "hanBbs/create";

	}

	//제출된 글 DB에 밀어 넣기 
	@RequestMapping(value = "/insert")
	public String insert(@ModelAttribute BbsVO newPage) {
		service.create(newPage);
		return "redirect:listPage";
		//insert후 redirect로 페이지 갱신
	}
	
	
	//전체 게시물 보기
	@RequestMapping(value="/listAll")
	public String viewAllList(){
		
		//전체 리스트 나오나?? 확인해 보기 
		service.listAll();
		return "hanBbs/list";
	}

	
	@RequestMapping(value="/listPage")
	public String viewPageList(@RequestParam(value="page", defaultValue="1") int page, Model model){
		
		//addAttribute로 jsp페이지에 "list" 던지기 
		model.addAttribute("list",service.listPage(page));
		
		
		return "hanBbs/list";
	}
	
	
	@RequestMapping(value="/listSearch")
	public String viewSearchList(){
		
		service.listSearch();
		
		return "hanBbs/list";
	}
	
}
