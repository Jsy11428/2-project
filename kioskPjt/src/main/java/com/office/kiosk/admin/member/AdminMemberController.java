package com.office.kiosk.admin.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.kiosk.franchisee.FranchiseeStoreDto;
import com.office.kiosk.franchisee.member.FranchiseeMemberDto;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;


@Log4j2
@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

	@Autowired
	AdminMemberService adminMemberService;
	
	/*
	 * 	admin 회원가입
	 */
	@GetMapping("/adminMemberAccountForm")
	public String adminMemberAccountForm() {
		log.info("adminMemberAccountForm()");
		
		String nextPage = "/admin/member/create_admin_account_form";
	
		return nextPage;
		
	}
	
	/*
	 * 	admin 회원가입 확인
	 */
	@PostMapping("/createadminAccountConfirm")
	public String createadminAccountConfirm(AdminMemberDto adminMemberDto, Model model) {
		log.info("createadminAccountConfirm()");
		
		String nextPage = "/admin/member/create_admin_account_ok";
		
		int result = adminMemberService.createAdminAccountConfirm(adminMemberDto);
		
		if (result <= 0) 
			nextPage = "/admin/member/create_admin_account_ng";
		
		return nextPage;
		
	}
	
	/*
	 * 	admin 로그인
	 */
	@GetMapping("/adminLoginForm")
	public String adminLoginForm() {
		log.info("adminLoginForm()");
		
		String nextPage = "/admin/member/admin_login_form";
	
		return nextPage;
		
	}
	
	/*
	 *  admin 로그인 확인
	 */
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
	
	/*
	 * 	admin 로그아웃 확인
	 */
	@GetMapping("/adminLogoutConfirm")
	public String adminLogoutConfirm(HttpSession session) {
		log.info("adminLogoutConfirm()");
		
		String nextPage = "/admin/admin_home";
		
		session.removeAttribute("loginedAdminMemberDto");
	
		return nextPage;
	}
	
	/*
	 *  amdin 정보수정
	 */
	@GetMapping("/adminMemberModifyForm")
	public String adminMemberModifyForm(HttpSession session) {
		log.info("adminMemberModifyForm()");
		
		String nextPage = "/admin/member/admin_modify_form";
	
		return nextPage;
	
	}
	
	/*
	 * 	admin 정보수정 확인
	 */
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
	
	/*
	 *  franchisee list 불러오기
	 */
	@GetMapping("/franchiseeList")
	public String franchiseeList(Model model) {
		log.info("franchiseeList()");
		
		String nextPage = "/admin/member/franchisee_list";
		
		List<FranchiseeMemberDto> franchiseeMemberDtos = adminMemberService.franchiseeList();
		
		model.addAttribute("franchiseeMemberDtos", franchiseeMemberDtos);
		
		return nextPage;
		
	}
	
	/*
	 * 	franchisee 승인하기
	 */
	@GetMapping("/franchiseeApprove")
	public String franchiseeApprove(@RequestParam("fcm_no") int fcm_no) {
		log.info("franchiseeApprove()");
		
		String nextPage = "redirect:/admin/member/franchiseeList";
		
		adminMemberService.franchiseeApprove(fcm_no);
		
		return nextPage;
		
	}
	
	/*
	 *  admin list 불러오기
	 */
	@GetMapping("/adminList")
	public String adminList(Model model, HttpSession session) {
		log.info("adminList()");
		
		String nextPage = "/admin/member/admin_list";
		
		AdminMemberDto loginedAdminMemberDto = 
				(AdminMemberDto) session.getAttribute("loginedAdminMemberDto");
		
		if (loginedAdminMemberDto.getAm_id().equals("super admin")) {
			
			List<AdminMemberDto> adminMemberDtos = adminMemberService.adminList();
			
			model.addAttribute("adminMemberDtos", adminMemberDtos);
		} else {
			nextPage = "/admin/member/admin_list_fail";
			
		}
		
		return nextPage;
		
	}
	
	/*
	 * 	admin 승인하기
	 */
	@GetMapping("/adminApprove")
	public String adminApprove(@RequestParam("am_no") int am_no) {
		log.info("adminApprove()");
		
		String nextPage = "redirect:/admin/member/adminList";
		
		adminMemberService.adminApprove(am_no);
		
		return nextPage;
		
	}
	
	/*
	 * 	store list 불러오기
	 */
	@GetMapping("/storeList")
	public String storeList(Model model) {
		log.info("storeList()");
		
		String nextPage = "/admin/member/franchisee_store_list";
		
		List<FranchiseeStoreDto> franchiseeSotreDtos = adminMemberService.storeList();
		
		model.addAttribute("franchiseeSotreDtos", franchiseeSotreDtos);
		
		return nextPage;
		
	}
	
	
	
}
