package org.zerock.service;

import java.util.List;

import org.zerock.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper ;
	
	
	
	
	
	public void register(BoardVO board) {
		
		log.info("BoardServiceImpl.register메서드 실행.....");
		
		mapper.insertSelectKey(board);
		log.info("정상등록 후 리스트 출력테스트......");
		mapper.getList();
		
	}


	@Override
	public boolean modify(BoardVO board) {

		log.info("BoardServiceImpl.modify메서드 실행.....");
		return mapper.update(board) == 1;
	}


	@Override
	public List<BoardVO> getList() {
		
		log.info("BoardServiceImpl.getList 메서드 실행.....");
		
		return mapper.getList();
	}


	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

}
