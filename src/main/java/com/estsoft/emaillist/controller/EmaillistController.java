package com.estsoft.emaillist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estsoft.emaillist.dao.EmailListDao;

@Controller
public class EmaillistController {
	@Autowired
	private EmailListDao dao;
	
	@RequestMapping( "/index" )
	@ResponseBody
	public String index() {
		System.out.println( dao );
		return "emaillist";
	}
}
