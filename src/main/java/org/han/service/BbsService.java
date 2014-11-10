package org.han.service;

import java.util.List;

import javax.inject.Inject;
import javax.print.attribute.standard.PageRanges;

import org.han.mapper.BbsMapper;
import org.han.util.PageMaker;
import org.han.vo.BbsVO;
import org.springframework.stereotype.Service;

@Service
public class BbsService {
	
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
	
	//paginge
//	public PageMaker paging(int page){
//		
//		int cnt= vo.getCnt();
//		PageMaker maker =new PageMaker(page, cnt);
//			
//		return maker;
//	}

}
