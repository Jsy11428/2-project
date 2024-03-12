package com.office.kiosk.franchisee.order;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.kiosk.admin.menu.AdminMenuService;
import com.office.kiosk.franchisee.member.FranchiseeMemberDto;
import com.office.kiosk.paging.kioskPageDto;

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
	
	// 주문 리스트 뿌리기
	@GetMapping("/getOrdersByLogin")
	@ResponseBody
	public Object getOrdersByLogin(@RequestParam(value = "page", required = false, defaultValue = "1") int page, HttpSession session) {
	    log.info("getOrdersByLogin()");        	  
	    
	    FranchiseeMemberDto loginedFranchiseeMemberDto = 
	            (FranchiseeMemberDto) session.getAttribute("loginedFranchiseeMemberDto");
	         
	    if(loginedFranchiseeMemberDto != null) {
	    	
	    	int loginNo = loginedFranchiseeMemberDto.getFcm_no();
	    	
	    	Map<String, Object> pagingOrderDtos = franchiseeOrderService.pagingOrderList(page, loginNo);
	    	
	    	kioskPageDto orderListPageDto = franchiseeOrderService.getAllOrderListPageNum(page, loginNo);
	    	
	    	pagingOrderDtos.put("orderListPageDto", orderListPageDto);
	    	
	    	return pagingOrderDtos;
	    	
	    } else {
	    	
			return null;
		}
	}
	
	// 주문 삭제
	@GetMapping("/orderListDeleteConfirm")
	@ResponseBody
	public String orderListDeleteConfirm(@RequestParam("fco_no") int fco_no, HttpSession session) {
		
		log.info("orderListDeleteConfirm()");
		
			String nextPage = "/franchisee/order/get_order_list";
		    		   
			FranchiseeMemberDto loginedFranchiseeMemberDto = 
					(FranchiseeMemberDto) session.getAttribute("loginedFranchiseeMemberDto");
		    		   
		    int result = franchiseeOrderService.deleteOrderListConfirm(fco_no);
		    		    
		    if (result <= 0) {
		        nextPage = "/franchisee/order/orderList_delete_ng";
		    }
		    
		    return nextPage;		
		
	}
	
	//오더 넣는곳 이동
	@GetMapping("/createOrderList")
	public String createOrderList(HttpSession session) {
		log.info("createOrderList()");
		
			String nextPage ="/franchisee/order/create_order_form";
			
			return nextPage;
					
	}
	
	//카테고리 가져오기
	@PostMapping("/getCategory")
	@ResponseBody
	public Object getCategory() {
		log.info("getCategorycon()");

		Map<String, Object> cateDtos = franchiseeOrderService.getCategory();

		return cateDtos;

		
	}
	
	// 카테고리에 따른 메뉴 가져오기
	@GetMapping("/getMenusByCategory")
	@ResponseBody
	public Object getMenusByCategory() {
		log.info("getMenus()");

		Map<String, Object> franchiseeMenuDtos = franchiseeOrderService.getMenus();
		
		return franchiseeMenuDtos;

	}
	
	
	
}
