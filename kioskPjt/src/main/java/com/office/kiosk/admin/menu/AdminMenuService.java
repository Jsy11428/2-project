package com.office.kiosk.admin.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.office.kiosk.franchisee.menu.FranchiseeMenuCategoryDto;
import com.office.kiosk.franchisee.menu.FranchiseeMenuDto;

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
	
	@Autowired
	RestTemplate restTemplate;
	
	public Map<String, Object> getCategory() {
		log.info("getCategory()");
		
		Map<String, Object> cateDtos = new HashMap<>();
		
		List<AdminMenuCategoryDto> categoryDtos = (List<AdminMenuCategoryDto>) iAdminMenuDao.selectAllCategory();
		
		cateDtos.put("categoryDtos", categoryDtos);
		
		return cateDtos;
	}



	public int createMenuCategoryAccountConfirm(AdminMenuCategoryDto adminMenuCategoryDto) {
		log.info("createMenuCategoryAccountConfirm()");

		
		boolean isMenuCategory = iAdminMenuDao.isMenuCategory(adminMenuCategoryDto.getFcmc_name());
		
		if (!isMenuCategory) {
			
			int result = iAdminMenuDao.insertMenuCategory(adminMenuCategoryDto);		
			
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
	
	
	public Map<String, Object> getMenus() {
		log.info("getMenus()");
		
		Map<String, Object> menuDtos = new HashMap<>();
		
		List<AdminMenuDto> menusDtos = (List<AdminMenuDto>) iAdminMenuDao.selectAllMenus();
		
		menuDtos.put("menusDtos", menusDtos);
		
		return menuDtos;
	}
		
	public int createMenuAccountConfirm(AdminMenuDto adminMenuDto) {
		log.info("createMenuAccountConfirm()");
		
		boolean isMenu = iAdminMenuDao.isMenu(adminMenuDto.getFc_menu_name());
		
		if (!isMenu) {
			
			int result = iAdminMenuDao.insertMenu(adminMenuDto);		
			
			switch (result) {
			case  ADMIN_MENU_DATABASE_TROUBLE:
				log.info("DATABASE COMMUNICATION TROUBLE");
				
				break;
				
			case  ADMIN_MENU_INSERT_FAIL:
				log.info("INSERT MENU FAIL");
				
				break;
				
			case  ADMIN_MENU_INSERT_SUCCESS:
				log.info("INSERT MENU SUCCESS");
				
				break;
				
			}	
			
			return result;
			
		} else {
			return ADMIN_MENU_ALREADT_EXIST;
		}
		
	}



	public ResponseEntity<String> uploadFile(MultipartFile file) {
		
		System.out.println("file: "+file);
				
		//RestTemplate
		
		//RestTemplate 객체생성
		//RestTemplate restTemplate = new RestTemplate();
		
		// Request Header 설정
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		// Request body 설정
		MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
		requestBody.add("file", file.getResource());		
		
		//Request Entity
		HttpEntity<MultiValueMap<String, Object>> responseEntity = new HttpEntity<>(requestBody, headers);
		
		//API 호출
		String severURL = "http://14.42.124.93:8091/upload_file";
		ResponseEntity<String> response = restTemplate.postForEntity(severURL, responseEntity, String.class);
				
		return response;
	}
	
}
