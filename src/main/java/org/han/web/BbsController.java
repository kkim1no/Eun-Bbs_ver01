package org.han.web;

import javax.inject.Inject;

import org.han.service.BbsService;
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
	BbsVO vo;

	@Inject
	BbsService service;
	
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
		public String viewPageList(@RequestParam(value="page", defaultValue="1") int page, Model model){
			
			//addAttribute deliver "list" 
			model.addAttribute("list",service.listPage(page));
			model.addAttribute("paging", service.paging(page));
					
			return "hanBbs/list";
		}
		
		

}
