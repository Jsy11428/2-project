package com.office.kiosk.admin.sales;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.kiosk.franchisee.dto.SearchSalesDto;

import lombok.extern.log4j.Log4j2;



@Log4j2
@Controller
@RequestMapping("/admin/sales")
public class AdminSalesController {

	@Autowired
	AdminSalesService adminSalesService;
	
//	/*
//	 * 	sales list 불러오기
//	 */
//	@GetMapping("/salesList")
//	public String salesList(Model model) {
//		log.info("salesList()");
//		
//		String nextPage = "/admin/sales/admin_sales_list";
//		
//		List<FranchiseeSalesDto> franchiseeSalesDtos = adminSalesService.salesList();
//		
//		model.addAttribute("franchiseeSalesDtos", franchiseeSalesDtos);
//		
//		return nextPage;
//		
//	}
	
	/*
	 * 	sales list 불러오기
	 */
	@GetMapping("/salesList")
	public String salesList(Model model) {
		log.info("salesList()");
		
		String nextPage = "/admin/sales/admin_sales_list2";
		
		return nextPage;
		
	}
	
	/*
	 * 	get all sales info
	 */
	@PostMapping("/getAllSalesInfo")
	@ResponseBody
	public Object getAllSalesInfo() {
		log.info("getAllSalesInfo()");
		
		Map<String, Object> resultMap = adminSalesService.getAllSalesInfo();
		
		return resultMap;
	}
	
	/*
	 * 	get search sales list
	 */
	@PostMapping("/getSearchSales")
	@ResponseBody
	public Object getSearchSales(SearchSalesDto searchSalesDto) {
		log.info("getSearchSales()");
		
		Map<String, Object> resultMap = 
				adminSalesService.getSearchSales(searchSalesDto);
		
		return resultMap;
	}
	
	
	
}
