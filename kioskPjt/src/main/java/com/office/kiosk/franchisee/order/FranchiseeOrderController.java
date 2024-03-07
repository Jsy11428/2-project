package com.office.kiosk.franchisee.order;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("/getOrders")
	@ResponseBody
	public Object getOrders() {
		log.info("getOrders()");		
		
	Map<String, Object> orderDtos = franchiseeOrderService.getAllOrders();
		
		return orderDtos;
	}
	
	
}
