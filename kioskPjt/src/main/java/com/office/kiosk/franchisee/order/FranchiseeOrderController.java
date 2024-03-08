package com.office.kiosk.franchisee.order;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.kiosk.franchisee.member.FranchiseeMemberDto;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/franchisee/order")
public class FranchiseeOrderController {

	@Autowired
	FranchiseeOrderService franchiseeOrderService;
	
	@GetMapping("/getTableOrderList")
	public String getTableOrderList() {
		log.info("getTableOrderList()");
		
		String nextPage ="/franchisee/order/get_order_list";
				
		return nextPage;
	}
	
	// 오더 리스트 다 보여주기
//	@PostMapping("/getOrders")
//	@ResponseBody
//	public Object getOrders() {
//		log.info("getOrders()");		
//	
//		Map<String, Object> orderDtos = franchiseeOrderService.getAllOrders();
//		
//		return orderDtos;
//	}
	
	// 로그인 한 지점의 오더 리스트 보여주기
//	@PostMapping("/getOrders")
//	@ResponseBody
//	public Object getOrders(HttpSession session) {
//		log.info("getOrders()");		
//		
//	FranchiseeMemberDto loginedFranchiseeMemberDto = 
//			(FranchiseeMemberDto) session.getAttribute("loginedFranchiseeMemberDto");
//		
//    int loginNo = loginedFranchiseeMemberDto.getFcm_no();
//    
//    Map<String, Object> orderDtos = franchiseeOrderService.getOrdersNo(loginNo);
//	
//		return orderDtos;
//	}
	
	@PostMapping("/getOrdersByLogin")
	@ResponseBody
	public Object getOrdersByLogin(HttpSession session) {
	    log.info("getOrdersByLogin()");        
	        
	    FranchiseeMemberDto loginedFranchiseeMemberDto = 
	            (FranchiseeMemberDto) session.getAttribute("loginedFranchiseeMemberDto");
	    
	    int loginNo = loginedFranchiseeMemberDto.getFcm_no();
	    
	    Map<String, Object> orderDtos = franchiseeOrderService.getOrdersNo(loginNo);
	    
	    return orderDtos;
	}
	
	
	
	
}
