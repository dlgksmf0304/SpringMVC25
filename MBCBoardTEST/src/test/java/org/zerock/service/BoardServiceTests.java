package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;
import org.zerock.service.BoardServiceTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	

	@Test
	public void testExist() {
		
		log.info("==================");
		log.info(service); // 인터페이스를 호출해보자.
		assertNotNull(service); // 빈객체가 아님을 테스트 한다.
		log.info("=================="); 
		
	}
	
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("서비스에서 만든 제목");
		board.setContent("서비스에서 만든 내용");
		board.setWriter("서비스님");
		
		service.register(board);
		
		log.info("======================");
		log.info("생성된 게시물의 번호 : " + board.getBno());
		log.info("======================");
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(2L); 
		
		if(board == null) {
			log.info("찾는 게시물이 없습니다. ");
			return;
		}
		
		board.setTitle("서비스에서 수정된 제목");
		log.info("수정된 결과 출력 : " + service.modify(board));
		
	}
	
}
