package kr.or.ksmart.springboot34_mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.springboot34_mybatis.domain.Goods;
import kr.or.ksmart.springboot34_mybatis.service.GoodsService;


@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	
	@GetMapping("/goodsDelete")
	public String gDelete(@RequestParam(value="gCode") String gCode, Goods g, Model model) {
		model.addAttribute("gCode", gCode);
		goodsService.gDelete(g);
		return "redirect:/goodsList";
		
	}
	
	
	@PostMapping("/goodsUpdate")
	public String gUpdate(Goods g) {
		System.out.println(g.toString());
		int result = goodsService.gUpdate(g);
		if(result > 0) {
			return "redirect:/goodsList";
		}
		return "redirect:/goodsUpdate";
	}
	
	
	@GetMapping("/goodsUpdate")
	public String gUpdate(@RequestParam(value="gCode") String gCode, Model model){
		System.out.println("binding test: " + gCode);
		System.out.println("binding test2: " + goodsService.selectForUpdate(gCode).toString());
		model.addAttribute("Goods", goodsService.selectForUpdate(gCode));
		return "gupdate/goodsUpdate";
		
	}
	
	@PostMapping("/goodsInsert")
	public String gInsert(Goods g) {
		System.out.println(g.toString());
		int result = goodsService.gInsert(g);
		System.out.println(result);
		if(result > 0 ) {
			return "redirect:/goodsList";
		}
		return "redirect:/goodsInsert";
	}
	
	@GetMapping("/goodsInsert")
	public String gInsert() {
		return "gInsert/goodsInsert";
	}
	
	
	@PostMapping("/goodsList")
	public String memberList(@RequestParam(value="sk") String sk,
			@RequestParam(value="sv", required=false) String sv, Model model) {
		System.out.println("binding test sk: " + sk);
		System.out.println("binding test sv: " + sv);
		List<Goods> list = goodsService.getSearchGoodsList(sk, sv);
		model.addAttribute("goodsList", list);
		return "glist/goodsList";
	}
	
	
	@GetMapping("/goodsList")
	public String getGoodsList1(Model model) {
		List<Goods> list = goodsService.getGoodslist();
		model.addAttribute("goodsList", list);
		System.out.println(goodsService.getGoodslist().toString());
		return "glist/goodsList";
	}
}
