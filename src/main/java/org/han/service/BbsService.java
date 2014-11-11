package org.han.service;

import java.util.List;

import javax.inject.Inject;
import javax.print.attribute.standard.PageRanges;

import org.han.mapper.BbsMapper;
import org.han.util.PageMaker;
import org.han.vo.BbsVO;
import org.han.web.BbsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BbsService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BbsService.class);
	
	@Inject
	BbsMapper mapper;
	
	@Inject
	BbsVO vo;
	
	//insert data
	public void create(BbsVO vo){
		mapper.create(vo);
		
	}
	
	//view List
	public List<BbsVO> listPage(PageMaker maker) throws Exception{
		
		List<BbsVO> list= mapper.listPage(maker);
		
			maker.doExecute(list.get(0).getCnt());
		
		return list;
		
		
	}

	public BbsVO read(BbsVO bbs) {
		
		return mapper.read(bbs.getBno());
		
	}

	public void delete(int bno) {

		mapper.delete(bno);
	}


	public void update(BbsVO vo) {

		mapper.update(vo);
		logger.info(vo.toString());
	}
	
	//paginge
//	public PageMaker paging(int page){
//		
//		int cnt= vo.getCnt();
//		PageMaker maker =new PageMaker(page, cnt);
//			
//		return maker;
//	}

}
