package kr.or.ksmart.springboot34_mybatis.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import kr.or.ksmart.springboot34_mybatis.service.BoardService;


@Controller
public class boardController {
	
	private static final Logger logger = LoggerFactory.getLogger(boardController.class);

	@Autowired
	private BoardService boardService;

	@GetMapping("/boardList")
	public String getGoodsList1(@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage
			,Model model) {
		logger.info("currentPage :: {}", currentPage);
		Map<String, Object> map = boardService.getBoardlist(currentPage);
		model.addAttribute("boardList", map.get("boardList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("endPageNum", map.get("endPageNum"));
		//System.out.println(boardService.getBoardlist().toString());
		return "blist/boardList";
	}
}
