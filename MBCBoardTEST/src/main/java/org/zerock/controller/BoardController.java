package org.zerock.controller;

import org.zerock.controller.BoardController;
import org.zerock.service.BoardService;
import org.zerock.domain.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*") // http://192.168.111.104:80/board/* (모든경로)
@AllArgsConstructor
public class BoardController {

	private BoardService service ; // 필드

	@GetMapping("/list") // http://192.168.111.104:80/board/list
	public void list(Model model) {
		
		log.info("BoardController.list메서드 실행.....");
		
		model.addAttribute("list", service.getList());
	}
	
	
	@GetMapping("/register")
	public String register() {
		// jsp 페이지 전달용 
		return "/board/register";
	}
	
	
	
	@PostMapping("/register") 
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("BoardController.register메서드 실행.....");
		
		service.register(board); 
		
		rttr.addFlashAttribute("result",board.getBno()); 
		
		return "redirect:/board/list";   
	}
	
	
	@GetMapping({"/get","/modify" }) // http://192.168.111.104:80/board/get?bno=5
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		log.info("BoardController.get 메서드 실행.....");
		
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify") // http://192.168.111.104:80/board/modify
	public String modify(BoardVO board, RedirectAttributes rttr) {

		log.info("BoardController.get 메서드 실행.....");
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	
}
