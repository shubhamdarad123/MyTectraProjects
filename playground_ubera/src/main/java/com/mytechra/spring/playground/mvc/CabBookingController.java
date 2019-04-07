package com.mytechra.spring.playground.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mytechra.spring.playground.core.CabLogistics;
import com.mytechra.spring.playground.core.cabpool.CabPool;
import com.mytechra.spring.playground.model.Cab;

@Controller
public class CabBookingController {
	
	@Autowired
	private CabLogistics cabs;
	
	@Autowired
	private CabPool cabPool;
	
	@RequestMapping(path= "register.do" ,method = RequestMethod.POST)
	public ModelAndView registerCab(@ModelAttribute @Validated Cab cab ,BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("cabs");
		}
		
		return new ModelAndView("redirect:registerDisplay.do?status=SUCEESS");
	}
	
	@RequestMapping(path= "registerDisplay.do" ,method = RequestMethod.GET)
	public ModelAndView registerDisplay() throws Exception {
		ModelAndView modelAndView = new ModelAndView("cabs", "cabs", cabPool.listCabs());
		modelAndView.addObject("cab", new Cab());
		return modelAndView;
	}
	
}