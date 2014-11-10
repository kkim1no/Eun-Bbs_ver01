package org.han.web;

import java.util.List;

import javax.inject.Inject;

import org.han.service.BbsService;
import org.han.util.PageMaker;
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
			return "redirect:list";
			//insert후 redirect로 페이지 갱신
		}
		
		

		@RequestMapping(value="/list")
		public void viewPageList(PageMaker maker, Model model){
			
			//addAttribute deliver "list" to view page
			try {
				model.addAttribute("list",service.listPage(maker));
			} catch (Exception e) {
				model.addAttribute("erroeMessage","해당 검색 결과가 없습니다.");	
				maker.setKeyword("");
			}
			model.addAttribute("maker",maker);
		
		}
	
}
