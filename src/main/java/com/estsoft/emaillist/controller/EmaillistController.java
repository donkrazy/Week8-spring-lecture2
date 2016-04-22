package com.estsoft.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.estsoft.emaillist.dao.EmailListDao;
import com.estsoft.emaillist.vo.EmailListVo;

@Controller
public class EmaillistController {
	@Autowired
	private EmailListDao dao;
	
	@RequestMapping( value="/insert", method=RequestMethod.POST  )
	public String insert( 
		@RequestParam( value="fn", required=true, defaultValue="" ) String firstName, 
		@RequestParam( value="ln", required=true, defaultValue="" ) String lastName, 
		@RequestParam( value="email", required=true, defaultValue="" ) String email ) {
		
		EmailListVo vo = new EmailListVo();
		vo.setEmail(email);
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		
		dao.insert( vo );
		return "redirect:/index";
	}
	
	@RequestMapping( "/form" )
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping( "/index" )
	public String index( Model model ) {
		List<EmailListVo> list = dao.getList();
		model.addAttribute( "list", list );
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping( "/index2" )
	public ModelAndView index2() {
		List<EmailListVo> list = dao.getList();

		ModelAndView mav = new ModelAndView();
		mav.addObject( "list", list );
		mav.setViewName( "/WEB-INF/views/index.jsp" );
		return mav;
	}
	
}
