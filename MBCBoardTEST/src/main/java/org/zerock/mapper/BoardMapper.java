package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	// @Select("select * from board_TEST where bno > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO bard);
	
	public void insertSelectKey(BoardVO board);
	
	public int update(BoardVO board);

}
