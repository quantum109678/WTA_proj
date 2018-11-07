package com.not4win.electro;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.not4win.electro.api.Store;
import com.not4win.electro.model.Feedback;
import com.not4win.electro.model.User;
import com.not4win.electro.util.DBUtility;
import com.sun.net.httpserver.Authenticator.Success;
import com.sun.tools.javac.util.List;

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
	
	@RequestMapping("/signup")
	public String create(@RequestParam("name") String name, @RequestParam("password") String password,@RequestParam("email") String email) {
		User user = new User();
		user.setAadhar("12345678");
		user.setAddress("mangalore");
		user.setFName(name);
		user.setGender("male");
		user.setLName("nayak");
		user.setPno("93423423");
		user.setPassword(password);
		user.setUsername(email);
		
		boolean verified = DBUtility.addUser(user);
		
		if(verified) {
			return "login.jsp";
		}
		else {
			return "signup.jsp";
		}
	}
	@RequestMapping("/play")
	public ModelAndView displayProduct(@RequestParam("hi") String item) {
		item=item.replace('-', ' ');
		ArrayList<String> store=DBUtility.getData(item);
		item=item.replace(' ', '-');
		store.add(0,item);
		System.out.println(store);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product.jsp");
		mv.addObject("result", store);
		return mv;
	}
	
	@RequestMapping(value = " /buy/{user}/{website}/{item}", method=RequestMethod.GET)
	public String addtoCart(@PathVariable String user,@PathVariable String website,@PathVariable String item){
		boolean verification = DBUtility.addtoDBCart(user,website,item);
		if(verification) {
			return "redirect:http://localhost:2080/tusk/successfulCart.jsp";
		}
	//fetch order
		//return "redirect:http://localhost:2080/tusk/login.jsp";
		return null;
	}
	
	@RequestMapping(value = " /delete/{user}/{item}", method=RequestMethod.GET)
	public String deletefromCart(@PathVariable String user,@PathVariable String item){
		boolean verification = DBUtility.deletefromDBCart(user,item);
		if(verification) {
			return "redirect:http://localhost:2080/tusk/Cart.jsp";
		}
		return "redirect:http://localhost:2080/tusk/login.jsp";
	}
	
	@RequestMapping("/cart")
	public String gotocart() {
		return "redirect:http://localhost:2080/tusk/Cart.jsp";
	}
	
	@RequestMapping("/gotodb")
	public String gotoproducts() {
		return "redirect:http://localhost:2080/tusk/db.jsp";
	}
//	@RequestMapping("/Feedback")
//	public void signUp() {
//		Feedback fb = new Feedback();
//		user.setAadhar("12345678");
//		user.setAddress("mangalore");
//		user.setFName("ashwin");
//		user.setGender("male");
//		user.setLName("nayak");
//		user.setPno("93423423");		
//	}
}
