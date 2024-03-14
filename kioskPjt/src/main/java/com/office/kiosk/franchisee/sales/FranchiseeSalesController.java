package com.office.kiosk.franchisee.sales;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.kiosk.paging.kioskPageDto;

import lombok.extern.log4j.Log4j2;



@Log4j2
@Controller
@RequestMapping("/franchisee/sales")
public class FranchiseeSalesController {

	@Autowired
	FranchiseeSalesService franchiseeSalesService;
	
	// 뷰변경
	
	@GetMapping("/getSalesInfo")
	public String getSalesInfo() {
		log.info("getSalesInfo()");
		
		String nextPage = "/franchisee/sales/franchisee_sales_list";
		
		return nextPage;
	}
	
	
	// 우리가게의 모든 매출 정보 가져오기
	
	@GetMapping("/getMyStoreAllSalesInfo")
	@ResponseBody
	public Object getMyStoreAllSalesInfo(@RequestParam("fcs_no") String fcs_no,@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		log.info("getMyStoreAllSalesInfo()");
		
		Map<String, Object> pagingMyStoreAllSalesDtos = 
				franchiseeSalesService.pagingMyStoreAllSalesInfo(page, fcs_no);
		
		kioskPageDto myStoreAllSalesPageDtos = franchiseeSalesService.getMyStoreSalesInfoPageNum(page, fcs_no);
		
		pagingMyStoreAllSalesDtos.put("myStoreAllSalesPageDtos", myStoreAllSalesPageDtos);
		log.info("pagingMyStoreAllSalesDtos------------------->" + pagingMyStoreAllSalesDtos);
		
		
		return pagingMyStoreAllSalesDtos;
		
	}
	
	
	
}
