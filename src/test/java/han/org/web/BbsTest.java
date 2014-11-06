package han.org.web;

import javax.inject.Inject;




import org.han.mapper.BbsMapper;
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
	
	
	@Test
	public void createTest() {
		
		vo.setCont("������ �Խ��� �׽�Ʈ�Դϴ�");
		vo.setContfile("kim's.img");
		vo.setTitle("������ �׽�Ʈ");
		vo.setUserid("han01");
		
		mapper.create(vo);
		
	}

	
	@Test
	public void listPageTest() {
		
		logger.info(mapper.listPage(1).toString());
		
		
	}
}
