package pers.song.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;
import pers.song.demo.entity.Tuser;
import pers.song.demo.service.TestService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
	
	@Autowired
	private TestService testServicet;
	
	@RequestMapping(value = "/hello",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String testIndex(){
		
		Tuser user = testServicet.findTuser(1L);
		return user.toString();
	}

	@GetMapping(value = "/test")
	public ModelAndView test(HttpServletRequest req) {
		// UserEntity userEntity = getCurrentUser(req);
		Tuser user = new Tuser();
		user.setName("123");
		user.setId(2L);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("/user/test.html");
		return mv;
	}

	@RequestMapping("/hello2")
	public String hello(Model model) {
		model.addAttribute("name", "thymeleaf");
		return "/user/test.html";
	}
}
