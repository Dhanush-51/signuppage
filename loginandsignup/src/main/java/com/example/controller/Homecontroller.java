package com.example.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Details;
import com.example.repository.Homerepo;
import com.example.service.Homeservice;

@Controller
public class Homecontroller {
	
	@Autowired
	Homerepo rep;

	
	private final Homeservice ser;

	@Autowired
	public Homecontroller(Homeservice ser) {
	    this.ser = ser;
	}
	
	//main home page
	@RequestMapping("/home")
	public ModelAndView home(Details details)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	//from home to login page
	@RequestMapping("/login")
	public ModelAndView login(Details details)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("loginpage");
		return mv;
	}
	//from home to sign up page
	@RequestMapping("/signup")
	public ModelAndView signup(Details details)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("signuppage");
		return mv;
	}
	
	@RequestMapping("/adddetails")
	public String adddetails(Details details)
	{
		rep.save(details);
		return "redirect:home";
	}
	@RequestMapping("/checkdetails")
	public String checkdetails(Details details, @RequestParam String username , @RequestParam String password)
	{
		Details det=ser.getdet(username,password);
		System.out.print(det);
		if(Objects.nonNull(det)) {
			return "redirect:home";
		}
		else {
			return "redirect:signup";
		}
		
		
	}
	
	

}
