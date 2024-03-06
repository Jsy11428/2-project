package com.office.kiosk.admin.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/admin/sales")
public class AdminSalesController {

	@Autowired
	AdminSalesService adminSalesService;
	
	/*
	 * 	sales list 불러오기
	 */
	@GetMapping("/salesList")
	public String salesList(Model model) {
		log.info("salesList()");
		
		String nextPage = "/admin/sales/admin_sales_list";
		
		List<FranchiseeSalesDto> franchiseeSalesDtos = adminSalesService.salesList();
		
		model.addAttribute("franchiseeSalesDtos", franchiseeSalesDtos);
		
		return nextPage;
	}
	
	
}
