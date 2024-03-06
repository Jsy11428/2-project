package com.office.kiosk.admin.menu;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.kiosk.franchisee.menu.FranchiseeMenuCategoryDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/admin/menu")
public class AdminMenuController {

	@Autowired
	AdminMenuService adminMenuService;
	
	
	@GetMapping("/createMenuForm")
	public String createMenuForm(Model model, FranchiseeMenuCategoryDto franchiseeMenuCategoryDto) {
		log.info("createMenuForm()");
		
		String nextPage = "/admin/menu/create_menu_account_form";
		
		model.addAttribute("franchiseeMenuCategoryDto", franchiseeMenuCategoryDto);
		
		return nextPage;
		
	}
	
	// /admin/menu/getCategory
	
	@PostMapping("/getCategory")
	@ResponseBody
	public Object getCategory()  {
		log.info("getCategory()");
		
		Map<String, Object> cateDtos = adminMenuService.getCategory();
				
		return cateDtos;
		
	}
	
	
	@PostMapping("/createMenuCategoryAccountConfirm")
	public String createMenuCategoryAccountConfirm(Model model, FranchiseeMenuCategoryDto franchiseeMenuCategoryDto) {
		log.info("createMenuCategoryAccountConfirm");
		
		String nextPage = "/admin/menu/create_menu_account_ok";
		
		int result = -1;
		
		result = adminMenuService.createMenuCategoryAccountConfirm(franchiseeMenuCategoryDto);
		
		if (result <= 0) {
			nextPage = "/admin/menu/create_menu_account_ng";
			
		}
		
		return nextPage;
		
	}
	
	
}
