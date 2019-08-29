package kr.og.ksmart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
