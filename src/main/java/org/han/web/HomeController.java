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

	
	//���� ��� ������ �����ֱ�
	@RequestMapping(value = "/create")
	public String create() {

		/* service.create(vo); */
		return "hanBbs/create";

	}

	//����� �� DB�� �о� �ֱ� 
	@RequestMapping(value = "/insert")
	public String insert(@ModelAttribute BbsVO newPage) {
		service.create(newPage);
		return "redirect:listPage";
		//insert�� redirect�� ������ ����
	}
	
	
	//��ü �Խù� ����
	@RequestMapping(value="/listAll")
	public String viewAllList(){
		
		//��ü ����Ʈ ������?? Ȯ���� ���� 
		service.listAll();
		return "hanBbs/list";
	}

	
	@RequestMapping(value="/listPage")
	public String viewPageList(@RequestParam(value="page", defaultValue="1") int page, Model model){
		
		//addAttribute�� jsp�������� "list" ������ 
		model.addAttribute("list",service.listPage(page));
		
		
		return "hanBbs/list";
	}
	
	
	@RequestMapping(value="/listSearch")
	public String viewSearchList(){
		
		service.listSearch();
		
		return "hanBbs/list";
	}
	
}
