package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.bean.User;
import com.demo.service.LoginService;

@Controller
public class LoginController {
	
	/*@RequestMapping(value="/validate" ,method=RequestMethod.POST)
	public ModelAndView validateuser(@RequestParam("uname") String uname,@RequestParam("pass") String pass)
	{
		String msg=null;
		if((uname.equals("admin")) && (pass.equals("admin")))
		{
			msg="valid user";
		}
		else
		{
			msg="valid not user";
		}
		return new ModelAndView("displayMessage","msg",msg);
	}*/
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/validate" ,method=RequestMethod.POST)
	public ModelAndView validateuser(@RequestParam("uname") String uname,@RequestParam("pass") String pass)
	{
		String msg=null;
		User n=loginService.validate(uname,pass);
		if(n!=null)
		{
			msg="valid user";
		}
		else
		{
			msg="not valid";
		}
				return new ModelAndView("displayMessage","msg",msg);
		
	}
}


