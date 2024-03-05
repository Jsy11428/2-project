package com.office.kiosk.franchisee.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FranchiseeMemberDetailService implements UserDetailsService {

	@Autowired
	IFranchiseeMemberDao iFranchiseeMemberDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername()");
			
		FranchiseeMemberDto franchiseeMemberDto = new FranchiseeMemberDto();
		franchiseeMemberDto.setFcm_id(username);
		
		FranchiseeMemberDto selectedFranchiseeMemberDto =
				iFranchiseeMemberDao.selectFranchiseeForLogin(franchiseeMemberDto);
		
		return User.builder()
				.username(selectedFranchiseeMemberDto.getFcm_id())
				.password(selectedFranchiseeMemberDto.getFcm_pw())
				.roles("FRANCHISEE")
				.build();
		
	}
	
}
