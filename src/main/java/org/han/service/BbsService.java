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
	

	
	//게시물 등록하기
	public void create(BbsVO vo){
		mapper.create(vo);
		
	}
	
	//페이지당 List 보기 
	public List<BbsVO> listPage(int page){
		return mapper.listPage(page);
	}
	
	//페이징
	public PageMaker paging(int page){
		
			int cnt=mapper.countAll();
			PageMaker maker =new PageMaker(page, cnt);
		return maker;
	}

	
}
