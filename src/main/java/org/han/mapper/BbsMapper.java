package org.han.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.han.vo.BbsVO;

public interface BbsMapper {
	
	//�Խù� ���
	@Insert("insert into tbl_bbs (bno, title, userid, cont, contfile)"+
			" values(seq_bbs.nextval, #{title}, #{userid}, #{cont}, #{contfile})")
	public void create(BbsVO vo);

	//��ü �Խù� ����
	@Select("select * from tbl_bbs")
	public List<BbsVO> listAll();
	
	//�������� �Խù� ����(1�������� 10����, 10������ �ڸ���)
	@Select("select bno," 
			+" (case when sysdate - regdate < 1 then '\"new\"' end)||title||(case when rcount = 0 then ' ' when rcount>0 then '['||rcount||']' end) title,"
			+"userid, regdate, vcount from"
			+" (select /*+index_desc(tbl_bbs pk_bbs)*/ rownum rn, bno, title, userid, regdate, vcount, rcount from tbl_bbs where bno>0 and rownum<=(ceil(#{page}/5)*50)+1)"
			+" where rn > (#{page}-1)*10 and rn<=(#{page}*10)")
	public List<BbsVO> listPage(int page);
	
	
	//�˻�
	@Select("����¡ ������ �ֱ�") 
	public List<BbsVO> listSearch();
	
}