package com.office.kiosk.admin.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.kiosk.franchisee.menu.FranchiseeMenuCategoryDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminMenuService {

	// 메뉴 카테고리 추가 메서드용 상수
	final static public int ADMIN_MENU_CATEGORY_ALREADT_EXIST = -2;
	final static public int ADMIN_MENU_CATEGORY_DATABASE_TROUBLE = -1;
	final static public int ADMIN_MENU_CATEGORY_INSERT_FAIL = 0;
	final static public int ADMIN_MENU_CATEGORY_INSERT_SUCCESS = 1;
	
	
	// 메뉴 추가 메서드용 상수
	final static public int ADMIN_MENU_ALREADT_EXIST = -2;
	final static public int ADMIN_MENU_DATABASE_TROUBLE = -1;
	final static public int ADMIN_MENU_INSERT_FAIL = 0;
	final static public int ADMIN_MENU_INSERT_SUCCESS = 1;
	
	
	@Autowired
	IAdminMenuDao iAdminMenuDao;

	public Map<String, Object> getCategory() {
		log.info("getCategory");
		
		Map<String, Object> cateDtos = new HashMap<>();
		
		List<FranchiseeMenuCategoryDto> categoryDtos = (List<FranchiseeMenuCategoryDto>) iAdminMenuDao.selectAllCategory();
		
		cateDtos.put("categoryDtos", categoryDtos);
		
		return cateDtos;
	}


	public int createMenuCategoryAccountConfirm(FranchiseeMenuCategoryDto franchiseeMenuCategoryDto) {
		log.info("createMenuCategoryAccountConfirm");
		
		boolean isMenuCategory = iAdminMenuDao.isMenuCategory(franchiseeMenuCategoryDto.getFcmc_name());
		
		if (!isMenuCategory) {
			
			int result = iAdminMenuDao.insertMenuCategory(franchiseeMenuCategoryDto);		
			
			switch (result) {
			case  ADMIN_MENU_CATEGORY_DATABASE_TROUBLE:
				log.info("DATABASE COMMUNICATION TROUBLE");
				
				break;
				
			case  ADMIN_MENU_CATEGORY_INSERT_FAIL:
				log.info("INSERT MENU CATEGORY FAIL");
				
				break;
				
			case  ADMIN_MENU_CATEGORY_INSERT_SUCCESS:
				log.info("INSERT MENU CATEGORY SUCCESS");
				
				break;
				
			}
			
			return result;
			
			
		} else {
			
			return ADMIN_MENU_CATEGORY_ALREADT_EXIST;
		}
		
		
		
	}


	
}
