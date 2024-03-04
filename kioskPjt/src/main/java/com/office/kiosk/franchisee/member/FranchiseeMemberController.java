package com.office.kiosk.franchisee.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/franchisee/member")
public class FranchiseeMemberController {

	@Autowired
	FranchiseeMemberService franchiseeMemberService;
	
	/*
	 * 	회원가입
	 */
	@GetMapping("/createFranchiseeAccountForm")
	public String createFranchiseeAccountForm() {
		log.info("createFranchiseeAccountForm()");
		
		String nextPage = "/franchisee/member/create_franchisee_account_form";
	
		return nextPage;
		
	}
	
	/*
	 * 	회원가입 확인
	 */
	@PostMapping("/createFranchiseeAccountConfirm")
	public String createFranchiseeAccountConfirm(FranchiseeMemberDto memberDto, Model model) {
		log.info("createFranchiseeAccountConfirm()");
		
		String nextPage = "/franchisee/member/create_franchisee_account_ok";
		
		int result = franchiseeMemberService.createFranchiseeAccountConfirm(memberDto);
		
		if (result <= 0) 
			nextPage = "/franchisee/member/create_franchisee_account_ng";
		
		return nextPage;
		
	}
	
	/*
	 * 	로그인 폼
	 */
	@GetMapping("/franchiseeLoginForm")
	public String franchiseeLoginForm() {
		log.info("FranchiseeLoginForm()");
		
		String nextPage = "/franchisee/member/franchisee_login_form";
	
		return nextPage;
		
	}
	
//	/*
//	 * 	로그인 확인
//	 */
//	@PostMapping("/FranchiseeLoginConfirm")
//	public String franchiseeLoginConfirm(FranchiseeMemberDto franchiseeMemberDto, HttpSession session) {
//		log.info("FranchiseeLoginConfirm()");
//		
//		String nextPage = "/franchisee/member/franchisee_login_ok";
//		
//		FranchiseeMemberDto loginedFranchiseeMemberDto = 
//				franchiseeMemberService.FranchiseeLoginConfirm(franchiseeMemberDto);
//		
//		if (loginedFranchiseeMemberDto != null) {
//			session.setAttribute("loginedFranchiseeMemberDto", loginedFranchiseeMemberDto);
//			session.setMaxInactiveInterval(60 * 30);
//			
//		} else {
//			nextPage = "/franchisee/member/franchisee_login_ng";
//			
//		}
//	
//		return nextPage;
//		
//	}
	
	/*
	 * 	로그인 성공
	 */
	@GetMapping("/franchiseeLoginSuccess")
	public String franchiseeLoginSuccess() {
		log.info("franchiseeLoginSuccess()");
		
		String nextPage = "/franchisee/member/franchisee_login_ok";
	
		return nextPage;
	
	}
	
	/*
	 * 	로그인 실패
	 */
	@GetMapping("/franchiseeLoginFail")
	public String franchiseeLoginFail() {
		log.info("franchiseeLoginFail()");
		
		String nextPage = "/franchisee/member/franchisee_login_ng";
	
		return nextPage;
	
	}
	
//	/*
//	 * 	로그아웃 확인
//	 */
//	@GetMapping("/franchiseeLogoutConfirm")
//	public String franchiseeLogoutConfirm(HttpSession session) {
//		log.info("FranchiseeLogoutConfirm()");
//		
//		String nextPage = "/franchisee/franchisee_home";
//		
//		session.removeAttribute("loginedFranchiseeMemberDto");
//	
//		return nextPage;
//	}
//	
	
	/*
	 * 	정보수정 폼
	 */
	@GetMapping("/franchiseeModifyForm")
	public String franchiseeModifyForm(HttpSession session) {
		log.info("FranchiseeModifyForm()");
		
		String nextPage = "/franchisee/member/franchisee_modify_form";
	
		return nextPage;
	
	}
	
	/*
	 * 	정보수정 확인
	 */
	@PostMapping("/franchiseeModifyConfirm")
	public String franchiseeModifyConfirm(FranchiseeMemberDto franchiseeMemberDto, HttpSession session) {
		log.info("franchiseeModifyConfirm()");
		
		String nextPage = "/franchisee/member/franchisee_modify_ok";
		
		FranchiseeMemberDto modifieDto = 
				franchiseeMemberService.franchiseeModifyConfirm(franchiseeMemberDto);
		
		if (modifieDto == null) {
			nextPage = "/franchisee/member/franchisee_modify_ng";
			
		} else {
			session.setAttribute("loginedFranchiseeMemberDto", modifieDto);
			session.setMaxInactiveInterval(60 * 30);
			
		}
		
		return nextPage;
	}
	
}
