package org.han.web;

import java.util.List;

import javax.inject.Inject;

import org.han.service.BbsService;
import org.han.utill.PageMaker;
import org.han.vo.BbsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hanBbs/*")
public class BbsController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	

	@Inject
	BbsService service;
	
	@Inject
	BbsVO vo;
	
	//view create page
		@RequestMapping(value = "/create")
		public String create() {
			return "hanBbs/create";

		}

		//insert sumit data 
		@RequestMapping(value = "/insert")
		public String insert(@ModelAttribute BbsVO newPage) {
			service.create(newPage);
			return "redirect:listPage";
			//insert후 redirect로 페이지 갱신
		}
		
		

		@RequestMapping(value="/listPage")
		public String viewPageList(@ModelAttribute PageMaker maker, Model model){
			
			List<BbsVO> list= service.listPage(maker.getPage());
			
			//addAttribute deliver "list" to view page
			model.addAttribute("list",list);
			
			PageMaker maker1 =new PageMaker(maker.getPage(), list.get(0).getCnt());
			maker1.setKeyword(maker.getKeyword());
			
			model.addAttribute("paging", maker1);
			
			return "hanBbs/list";
		}
	
}
