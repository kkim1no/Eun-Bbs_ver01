package han.org.web;

import javax.inject.Inject;

import org.han.mapper.BbsMapper;
import org.han.service.BbsService;
import org.han.utill.PageMaker;
import org.han.vo.BbsVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/**/*-context.xml" })
public class BbsTest {

	Logger logger = LoggerFactory.getLogger(BbsTest.class);

	@Inject
	BbsMapper mapper;
	@Inject
	BbsVO vo;
	
	@Inject 
	BbsService service;
	
	
	@Test
	public void createTest() {
		
		vo.setCont("content");
		vo.setContfile("kim's.img");
		vo.setTitle("title");
		vo.setUserid("han01");

		mapper.create(vo);
	}
	
	@Test
	public void listPageTest() {
		logger.info(mapper.listPage(1).toString());
	}
	
	@Test
	public void paging(){
		PageMaker maker=service.paging(50);
		System.out.println(maker);
		
	}
	
}
