package com.office.kiosk.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.office.kiosk.franchisee.member.FranchiseeMemberDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminMemberService {
	
	final static public int ADMIN_ID_ALREADY_EXIST		= -2;
	final static public int ADMIN_DATABASE_TRUBLE			= -1;
	final static public int ADMIN_INSERT_FAIL				= 0;
	final static public int ADMIN_INSERT_SUCCESS			= 1;
	
	@Autowired
	IAdminMemberDao iAdminMemberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	public int createAdminAccountConfirm(AdminMemberDto adminMemberDto) {
		log.info("createAdminAccountConfirm()");
		
		boolean ismember = iAdminMemberDao.isMember(adminMemberDto.getAm_id());
		
		if (!ismember) {
			
			adminMemberDto.setAm_pw(passwordEncoder.encode(adminMemberDto.getAm_pw()));
			
			int result = iAdminMemberDao.insertAdmin(adminMemberDto);
			
			switch (result) {
			case ADMIN_DATABASE_TRUBLE:
				log.info("DATABASE COMMUNICATION TRUBLE");
				
				break;
				
			case ADMIN_INSERT_FAIL:
				log.info("INSERT FAIL AT DATABASE");
				
				break;
				
			case ADMIN_INSERT_SUCCESS:
				log.info("INSERT SUCCESS AT DATABASE");
				
				break;

			}
			
			return result;
			
		} else {
			
			return ADMIN_ID_ALREADY_EXIST;
			
		}
	}


	public AdminMemberDto adminLoginConfirm(AdminMemberDto adminMemberDto) {
		log.info("FranchiseeLoginConfirm");
		
		AdminMemberDto selectedAdminMemberDtoById = 
				iAdminMemberDao.selectAdminForLogin(adminMemberDto);
		
		if (passwordEncoder.matches(adminMemberDto.getAm_pw(), selectedAdminMemberDtoById.getAm_pw())) {
			return selectedAdminMemberDtoById;
		} else {
			return null;
		}
	}


	public AdminMemberDto adminModifyConfirm(AdminMemberDto adminMemberDto) {
		log.info("adminModifyConfirm");
		
		int result = iAdminMemberDao.updateAdminForModify(adminMemberDto);
		
		if (result > 0) {
			
			
			return iAdminMemberDao.selectLastesAdminInfo(adminMemberDto.getAm_no());
			
		}
		
		return null;
	}

}
