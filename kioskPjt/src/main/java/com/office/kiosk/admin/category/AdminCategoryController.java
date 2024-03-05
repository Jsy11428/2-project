package com.office.kiosk.admin.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class AdminCategoryController {

	@Autowired
	AdminCategoryService adminCategoryService;
	
	@GetMapping("lskfjsga")
	public String sdagalsg(){
		log.info("");
		
		return null;
	}
}
