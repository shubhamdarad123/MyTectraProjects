package com.mytechra.spring.playground.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mytechra.spring.playground.core.CabLogistics;

@Controller
public class UberMVCController {
	
	@Autowired
	private CabLogistics cabs;
	
	@GetMapping("/home")
	public ModelAndView home() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@GetMapping("/listRides.do")
	public ModelAndView listRide(@RequestParam("location") String location) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		modelAndView.addObject("rides", cabs.getRides(location));
		return modelAndView;
	}

}