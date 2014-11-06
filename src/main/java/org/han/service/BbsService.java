package org.han.service;

import java.util.List;

import javax.inject.Inject;

import org.han.mapper.BbsMapper;
import org.han.vo.BbsVO;
import org.springframework.stereotype.Service;

@Service
public class BbsService {
	
	@Inject
	BbsMapper mapper;
	
	//�Խù� ����ϱ�
	public void create(BbsVO vo){
		mapper.create(vo);
		
	}
	
	//��ü �Խù� ����
	public List<BbsVO> listAll(){
		return mapper.listAll();
	}

	//�������� List ���� 
	public List<BbsVO> listPage(int page){
		return mapper.listPage(page);
		
	}
	
	//�˻�
	public List<BbsVO> listSearch(){
		return mapper.listSearch();
		
	}
	
	
}
