package com.office.kiosk.admin.menu;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/admin/menu")
public class AdminMenuController {

	@Autowired
	AdminMenuService adminMenuService;

	// 메뉴 등록 화면 페이지 이동(뷰 변경)

	 @GetMapping("/createMenuForm")
	   public String createMenuForm(Model model, AdminMenuCategoryDto adminMenuCategoryDto) {
	      log.info("createMenuForm()");
	      
	      String nextPage = "/admin/menu/create_menu_account_form";
	      
	      model.addAttribute("adminMenuCategoryDto", adminMenuCategoryDto);
	      
	      return nextPage;
	      
	   }
	 
	  @PostMapping("/createMenuAccountConfirm")
	   public String createMenuAccountConfirm(AdminMenuDto adminMenuDto,
	         @RequestParam("file") MultipartFile file) {
	      log.info("createMenuAccountConfirm()");
	      
	      String nextPage = "redirect:/admin/menu/menuList";
	      
	      log.info(file);      
	      
	      ResponseEntity<String> saveFileName = adminMenuService.uploadFile(file);
	      
	         
	      if(saveFileName != null) {
	         adminMenuDto.setFc_menu_img_name(saveFileName.getBody()); 
	      
	      int result =
	      adminMenuService.createMenuAccountConfirm(adminMenuDto);
	       
	      if(result <= 0) nextPage = "/admin/menu/create_menu_account_ng";
	       
	      } else { nextPage = "/admin/menu/create_menu_account_ng"; 
	      	
	      }
	       
	      return nextPage;
	   }
   

	// 메뉴 등록


	// 모든 카테고리 가져오기

	@PostMapping("/getCategory")
	@ResponseBody
	public Object getCategory() {
		log.info("getCategory()");

		Map<String, Object> cateDtos = adminMenuService.getCategory();

		return cateDtos;

	}

	// 메뉴 카테고리 등록 확인 컨펌

	@PostMapping("/createMenuCategoryAccountConfirm")
	public String createMenuCategoryAccountConfirm(Model model, AdminMenuCategoryDto adminMenuCategoryDto) {
		log.info("createMenuCategoryAccountConfirm");

		String nextPage = "redirect:/admin/menu/createMenuForm";

		int result = -1;

		result = adminMenuService.createMenuCategoryAccountConfirm(adminMenuCategoryDto);

		if (result <= 0) {
			nextPage = "/admin/menu/create_menu_account_ng";

		}

		return nextPage;

	}

	// 메뉴리스트 화면 페이지 이동(뷰 변경)

	@GetMapping("/menuList")
	public String menuList() {
		log.info("menuList()");

		String nextPage = "/admin/menu/admin_menu_list";

		return nextPage;

	}

	// 메뉴리스트 화면 기존 메뉴 리스트 불러오기 메서드

	@PostMapping("/getMenus")
	@ResponseBody
	public Object getMenus() {
		log.info("getMenus()");

		Map<String, Object> menuDtos = adminMenuService.getMenus();

		return menuDtos;

	}
	
	// 카테고리에 따른 메뉴 불러오기

	@PostMapping("/getMenusByCategory")
	@ResponseBody
	public Object getMenusByCategory(Model model, @RequestParam("fcmc_no") String fcmc_no) {
		log.info("getMenusByCategory()");

		Map<String, Object> menuDtos = adminMenuService.getMenusByCategory(fcmc_no);

		return menuDtos;

	}
	
	

	// 모달창으로 선택한 메뉴의 정보 가져오기
	
	@PostMapping("/getSelectMenuInfo")
	@ResponseBody
	public AdminMenuDto getSelectMenuInfo(Model model ,@RequestParam("fc_menu_no") String fc_menu_no) {
		log.info("getSelectMenuInfo()"); 
		log.info(fc_menu_no);
		log.info(adminMenuService.getSelectMenuInfo(fc_menu_no));
		
		AdminMenuDto dto = adminMenuService.getSelectMenuInfo(fc_menu_no);
	
		
	    return dto;
	}
	
	// 모달창에서 기존에 선택된 메뉴 카테고리 불러오기
	
	
	
	
	

}
