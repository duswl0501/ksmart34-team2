package kr.or.ksmart.springboot34_mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ksmart.springboot34_mybatis.domain.Member;
import kr.or.ksmart.springboot34_mybatis.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("logout메서드");
		session.invalidate();
		return "login/login";
	}
	
	
	//로그인 화면
	@GetMapping("/login")
	public String login(@RequestParam(value="result", required=false) String result
			, Model model) {
		model.addAttribute("result", result);
		return "login/login";
	}
	
	//로그인 처리 로직
	@PostMapping("/login")
	public String login(@RequestParam(value="mId", required=false) String mId ,
						@RequestParam(value="mPw", required=false) String mPw,
						RedirectAttributes redirectA
						,HttpSession session) {
		System.out.println("binding test mId: " + mId);
		System.out.println("binding test mPw: " + mPw);
		Member m = memberService.selectForUpdate(mId);
		
		
		//로그인 성공
		if (m!=null && mPw != null && !mPw.equals("") && mPw.equals(m.getmPw())) {
			session.setAttribute("SID", m.getmId());
			session.setAttribute("SNAME", m.getmName());
			session.setAttribute("SLEVEL", m.getmLevel());
			return "redirect:/";
			
			
		//로그인 실패
		} else {
			redirectA.addAttribute("result", "등록된 회원이 아닙니다.");
			return "redirect:/login";
		}		
	}
	
	
	//회원조건검색
	@PostMapping("/memberList")
	public String memberList(@RequestParam(value = "sk") String sk,
			@RequestParam(value = "sv", required = false) String sv, Model model) {
		System.out.println("binding test sk: " + sk);
		System.out.println("binding test sv: " + sv);
		List<Member> list = memberService.getSearchMemberList(sk, sv);
		model.addAttribute("memberList", list);
		return "mlist/memberList";
	}
	
	//회원삭제
	@PostMapping("/memberDelete")
	public String mDelete(@RequestParam(value = "mId") String mId,
			@RequestParam(value = "mPw", required = false) String mPw, RedirectAttributes redirectA) {
		Member m = memberService.selectForUpdate(mId);
		if (mPw != null && !mPw.equals("") && mPw.equals(m.getmPw())) {
			memberService.mDelete(m);
			return "redirect:/memberList";
		} else {
			redirectA.addAttribute("mId", mId);
			return "redirect:/memberDelete";
		}
	}

	//회원삭제화면
	@GetMapping("/memberDelete")
	public String mDelete(@RequestParam(value = "mId") String mId, Model model) {
		model.addAttribute("mId", mId);
		return "mdelete/memberDelete";
	}

	//회원정보수정
	@PostMapping("/memberUpdate")
	public String mUpdate(Member m) {
		System.out.println(m.toString());
		int result = memberService.mUpdate(m);
		if (result > 0) {
			return "redirect:/memberList";
		}
		return "redirect:/memberUpdate";
	}

	//회원 한명 정보 조회
	@GetMapping("/memberUpdate")
	public String mUpdate(@RequestParam(value = "mId") String mId, Model model) {
		System.out.println("binding test: " + mId);
		System.out.println("bindcint test2: " + memberService.selectForUpdate(mId).toString());
		model.addAttribute("Member", memberService.selectForUpdate(mId));
		return "mupdate/memberUpdate";
	}

	//회원가입
	@PostMapping("/memberInsert")
	public String mInsert(Member m) {
		System.out.println(m.toString());
		int result = memberService.mInsert(m);
		System.out.println(result);
		if (result > 0) {
			return "redirect:/memberList";
		}
		return "redirect:/memberInsert";
		/*
		 * @PostMapping("/memberInsert") public String
		 * mInsert(@RequestParam(value="mId", required = false) String mId) {
		 * System.out.println("binding test=" + mId); return "redirect:/memberInsert"; }
		 */
	}

	//회원가입 화면
	@GetMapping("/memberInsert")
	public String mInsert() {
		return "minsert/memberInsert";
	}

	//회원리스트
	@GetMapping("/memberList")
	public String getMemberList1(Model model) {
		List<Member> list = memberService.getMemberlist();
		model.addAttribute("memberList", list);
		System.out.println(memberService.getMemberlist().toString());
		return "mlist/memberList";
	}

	
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("title", "ksmart34");
		mav.setViewName("index");
		return mav;
	}
}
