package pers.song.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pers.song.demo.entity.Tuser;
import pers.song.demo.service.TestService;

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
}
