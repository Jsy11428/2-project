package com.office.kiosk.franchisee.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/franchisee/menu")
public class FranchiseeMenuController {

	@Autowired
	FranchiseeMenuService franchiseeMenuService;

	
	// 프랜차이즈 메뉴 홈
	
	@GetMapping("/franchiseeMenuHome")	
	public String franchiseeMenuHome() {
		log.info("franchiseeMenuHome()");
		
		String nextPage = "/franchisee/menu/franchisee_menu_home";
		
		return nextPage;
		
	}
	
	// 프랜차이즈 메뉴 추가 신청 화면
	
	@GetMapping("/createMenuForm")	
	public String createMenuForm() {
		log.info("createMenuForm()");
		
		String nextPage = "/franchisee/menu/create_menu_account_form";
		
		return nextPage;
		
	}
	

	// 프랜차이즈 메뉴 추가 컨펌
	
	@PostMapping("/createMenuAccountConfirm")
	public String createMenuAccountConfirm(FranchiseeAddMenuDto franchiseeAddMenuDto, Model model) {
		log.info("createMenuAccountConfirm()");
		
		String nextPage = "/franchisee/menu/create_menu_account_ok";
		
		int result = -1;
		
		result = franchiseeMenuService.createMenuAccountConfirm(franchiseeAddMenuDto);
		
		if (result <= 0) {
			
			nextPage = "/franchisee/menu/create_menu_account_ng";
			
		}		
		
		return nextPage;
		
	}	
	
	
	// 프랜차이즈 메뉴 리스트(전체) 화면
	
	@GetMapping("/getAllMenus")
//	public Object getAllMenus(HttpSession session, Map<String, Object> menuMap) {
		public Object getAllMenus() {
		log.info("getAllMenus()");
		
		String nextPage = "/franchisee/menu/franchisee_menu_list";
		
		
//		FranchiseeMemberDto loginedFranchiseeMemberDto = 
//				(FranchiseeMemberDto) session.getAttribute("loginedFranchiseeMemberDto");
//		
//		menuMap.put("m_id", loginedFranchiseeMemberDto.getF_id());
//		Map<String, Object> resultMap = franchiseeMenuService.getAllMenus(menuMap);
//		
//		return resultMap;
		
		return nextPage;
		
	}
	

	
	// 프랜차이즈 메뉴 수정 화면
	
	@GetMapping("/modifySelectMenu")
	public String modifySelectMenu(Model model) {
		log.info("modifySelectMenu()");
		
		String nextPage = "/franchisee/menu/modify_menu_account_form";
		
		return nextPage;
		
	}
	
	
	// 프랜차이즈 메뉴 수정 컨펌
	
//	@PostMapping("/modifyMenuAccountConfirm")
//	public String modifyMenuAccountConfirm(FranchiseeMenuDto franchiseeMenuDto, Model model) {
//		log.info("createMenuAccountConfirm()");
//		
//		String nextPage = "/franchisee/menu/modify_menu_account_ok";
//		
//		int result = -1;
//		
//		result = franchiseeMenuService.createMenuAccountConfirm(franchiseeMenuDto);
//		
//		if (result <= 0) {
//			
//			nextPage = "/franchisee/menu/modify_menu_account_ng";
//			
//		}		
//		
//		return nextPage;
//		
//	}	
	
	
	// 프랜차이즈 메뉴 삭제 컨펌
	
	

	
}
