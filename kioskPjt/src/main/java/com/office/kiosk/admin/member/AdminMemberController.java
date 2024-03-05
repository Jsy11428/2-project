package com.office.kiosk.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.kiosk.franchisee.member.FranchiseeMemberDto;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

	@Autowired
	AdminMemberService adminMemberService;
	
	@GetMapping("/adminMemberAccountForm")
	public String adminMemberAccountForm() {
		log.info("adminMemberAccountForm()");
		
		String nextPage = "/admin/member/create_admin_account_form";
	
		return nextPage;
		
	}
	
	@PostMapping("/createadminAccountConfirm")
	public String createadminAccountConfirm(AdminMemberDto adminMemberDto, Model model) {
		log.info("createadminAccountConfirm()");
		
		String nextPage = "/admin/member/create_admin_account_ok";
		
		int result = adminMemberService.createAdminAccountConfirm(adminMemberDto);
		
		if (result <= 0) 
			nextPage = "/admin/member/create_admin_account_ng";
		
		return nextPage;
		
	}
	
	@GetMapping("/adminLoginForm")
	public String adminLoginForm() {
		log.info("adminLoginForm()");
		
		String nextPage = "/admin/member/admin_login_form";
	
		return nextPage;
		
	}
	
	@PostMapping("/adminLoginConfirm")
	public String adminLoginConfirm(AdminMemberDto adminMemberDto, HttpSession session) {
		log.info("adminLoginConfirm()");
		
		String nextPage = "/admin/member/admin_login_ok";
		
		AdminMemberDto loginedAdminMemberDto = 
				adminMemberService.adminLoginConfirm(adminMemberDto);
		
		if (loginedAdminMemberDto != null) {
			session.setAttribute("loginedAdminMemberDto", loginedAdminMemberDto);
			session.setMaxInactiveInterval(60 * 30);
			
		} else {
			nextPage = "/admin/member/admin_login_ng";
			
		}
	
		return nextPage;
		
	}
	
	@GetMapping("/adminLogoutConfirm")
	public String adminLogoutConfirm(HttpSession session) {
		log.info("adminLogoutConfirm()");
		
		String nextPage = "/admin/admin_home";
		
		session.removeAttribute("loginedAdminMemberDto");
	
		return nextPage;
	}
	
	@GetMapping("/adminMemberModifyForm")
	public String adminMemberModifyForm(HttpSession session) {
		log.info("adminMemberModifyForm()");
		
		String nextPage = "/admin/member/admin_modify_form";
	
		return nextPage;
	
	}
	
	@PostMapping("/adminModifyConfirm")
	public String adminModifyConfirm(AdminMemberDto adminMemberDto, HttpSession session) {
		log.info("adminModifyConfirm()");
		
		String nextPage = "/admin/member/admin_modify_ok";
		
		AdminMemberDto modifiedDTo = 
				adminMemberService.adminModifyConfirm(adminMemberDto);
		
		if (modifiedDTo == null) {
			nextPage = "/admin/member/admin_modify_ng";
			
		} else {
			session.setAttribute("loginedAdminMemberDto", modifiedDTo);
			session.setMaxInactiveInterval(60 * 30);
			
		}
		
		return nextPage;
	}
	
	
	
}
