package com.office.kiosk.franchisee.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FranchiseeMenuService {
	
	@Autowired
	IFranchiseeMenuDao dao;

	public int createMenuAccountConfirm(FranchiseeAddMenuDto franchiseeAddMenuDto) {
		log.info("createMenuAccountConfirm()");
		
		int result = -1;
		
		result = dao.insertFranchiseeMenu(franchiseeAddMenuDto);
		
		return result;
	}


	
}
