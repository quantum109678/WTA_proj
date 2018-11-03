package com.not4win.electro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.not4win.electro.model.User;
import com.not4win.electro.util.DBUtility;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String home() {
		return "login.jsp";
	}
	
	@RequestMapping("/trylogin")
	public ModelAndView login(@RequestParam("username") String name, @RequestParam("password") String password) {
		boolean bool = DBUtility.verifyLogin(name, password);
		
		if (bool) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("success.jsp");
			mv.addObject("result", name);
			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("failure.jsp");
			mv.addObject("result", name);
			return mv;
		}
	}
	
	@RequestMapping("/login")
	public String gotoLogin() {
		return "login.jsp";
	}
	
	@RequestMapping("/signup")
	public String gotoSignup() {
		return "signup.jsp";
	}
	
	@RequestMapping("/createaccount")
	public void create() {
		User user = new User();
		user.setAadhar("12345678");
		user.setAddress("mangalore");
		user.setFName("ashwin");
		user.setGender("male");
		user.setLName("nayak");
		user.setPno("93423423");		
	}
}
