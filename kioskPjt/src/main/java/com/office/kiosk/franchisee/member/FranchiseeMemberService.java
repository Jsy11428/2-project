package com.office.kiosk.franchisee.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FranchiseeMemberService {
	
	final static public int ID_ALREADY_EXIST		= -2;
	final static public int DATABASE_TRUBLE			= -1;
	final static public int INSERT_FAIL				= 0;
	final static public int INSERT_SUCCESS			= 1;

	@Autowired
	IFranchiseeMemberDao iFranchiseeMemberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public int createFranchiseeAccountConfirm(FranchiseeMemberDto franchiseememberDto) {
		log.info("createFranchiseeAccountConfirm()");
		
		boolean ismember = iFranchiseeMemberDao.isMember(franchiseememberDto.getFcm_id());
		
		if (!ismember) {
			
			franchiseememberDto.setFcm_pw(passwordEncoder.encode(franchiseememberDto.getFcm_pw()));
			
			int result = iFranchiseeMemberDao.insertFranchisee(franchiseememberDto);
			
			switch (result) {
			case DATABASE_TRUBLE:
				log.info("DATABASE COMMUNICATION TRUBLE");
				
				break;
				
			case INSERT_FAIL:
				log.info("INSERT FAIL AT DATABASE");
				
				break;
				
			case INSERT_SUCCESS:
				log.info("INSERT SUCCESS AT DATABASE");
				
				break;

			}
			
			return result;
			
		} else {
			
			return ID_ALREADY_EXIST;
			
		}
	
	}
	

	public FranchiseeMemberDto FranchiseeLoginConfirm(FranchiseeMemberDto franchiseeMemberDto) {
		log.info("FranchiseeLoginConfirm");
		
		FranchiseeMemberDto selectedFranchiseeMemberDtoById = 
				iFranchiseeMemberDao.selectFranchiseeForLogin(franchiseeMemberDto);
		
		if (passwordEncoder.matches(franchiseeMemberDto.getFcm_pw(), selectedFranchiseeMemberDtoById.getFcm_pw())) {
			return selectedFranchiseeMemberDtoById;
		} else {
			return null;
		}
		
	}

	public FranchiseeMemberDto franchiseeModifyConfirm(FranchiseeMemberDto franchiseeMemberDto) {
		log.info("FranchiseeLoginConfirm");
		
		int result = iFranchiseeMemberDao.updateFranchiseeForModify(franchiseeMemberDto);
		
		if (result > 0) {
			
			
			return iFranchiseeMemberDao.selectLastesFranchiseeInfo(franchiseeMemberDto.getFcm_no());
			
		}
		
		return null;
		
	}
	
	
}
