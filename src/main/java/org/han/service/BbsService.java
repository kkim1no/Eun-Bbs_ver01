package org.han.service;

import java.util.List;

import javax.inject.Inject;

import org.han.mapper.BbsMapper;
import org.han.utill.PageMaker;
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
	public List<BbsVO> listPage(int page){
		return mapper.listPage(page);
		
		
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
