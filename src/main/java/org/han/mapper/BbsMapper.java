package org.han.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.han.util.PageMaker;
import org.han.vo.BbsVO;

public interface BbsMapper {
	
	//Create new data
	@Insert("insert into tbl_bbs (bno, title, userid, cont, contfile)"+
			" values(seq_bbs.nextval, #{title}, #{userid}, #{cont}, #{contfile})")
	public void create(BbsVO vo);
	
	// if you want change view page count, modify this "(ceil(#{page}/5)*50)+1)"
	public List<BbsVO> listPage(PageMaker maker);
	
	//count All data
//	@Select("select count(bno) cnt from tbl_bbs")
//	public int countAll();
//	
	
}
