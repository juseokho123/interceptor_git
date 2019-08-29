package kr.og.ksmart;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping(value="/")
	public String main() {
		
		return "/index.html";
	}
	@GetMapping(value="/login")
	public String login() {
		
		return "/login.html";
	}
	@GetMapping(value="/notPermission")
	public String notPermission() {
		
		return "/notPermission.html";
	}
	@GetMapping(value="/main")
	public String main2() {
		
		return "/main.html";
	}
	
	@PostMapping(value="/loginProcess")
	public String loginProcess(@RequestParam(value="id")String id,@RequestParam(value="pw")String pw,HttpSession session) {
			
		
		//db조회했다는 가정
		if("12345".equals(pw)) {
			session.setAttribute("memberId", id);
			return "redirect:/main";
			
		}else {
			return "redirect:/login";
		}
		
	}
	
	@GetMapping(value="/logoutProcess")
	public String logoutProcess(HttpSession session) {
		session.invalidate();
		
		return "redirect:/login";
	}
}
