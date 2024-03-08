package com.office.kiosk.admin.sales;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.kiosk.franchisee.dto.SearchSalesDto;
import com.office.kiosk.paging.kioskPageDto;

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
	 * 	전체 매출 리스트
	 */
	@GetMapping("/salesList")
	public String salesList() {
		log.info("salesList()");
		
		String nextPage = "/admin/sales/admin_sales_list";
		
		return nextPage;
		
	}
	
//	/*
//	 * 	get all sales info
//	 */
//	@PostMapping("/getAllSalesInfo")
//	@ResponseBody
//	public Object getAllSalesInfo() {
//		log.info("getAllSalesInfo()");
//		
//		Map<String, Object> resultMap = adminSalesService.getAllSalesInfo();
//		
//		return resultMap;
//	}
	
	/*
	 * 	get all sales info
	 */
	@PostMapping("/getAllSalesInfo")
	@ResponseBody
	public Object getAllSalesInfo(@RequestParam("page") int page) {
		log.info("getAllSalesInfo()");
		log.info("page" + page);
		
		Map<String, Object> resultMap = adminSalesService.pagingAllSalesInfo(page);
		
		kioskPageDto allSalesListPageDto = adminSalesService.allSalesListPageNum(page);
		
		resultMap.put("allSalesListPageDto", allSalesListPageDto);
		
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
	
	/*
	 * 	선택 fco_ori_no detail info modal
	 */
	@PostMapping("/getSalesDetailInfo")
	@ResponseBody
	public Object getSalesDetailInfo(@RequestParam("fco_ori_no") int fco_ori_no) {
		log.info("getSalesDetailInfo()");
		
		Map<String, Object> resultMap = 
				adminSalesService.getSalesDetailInfo(fco_ori_no);
		
		return resultMap;
	}
	
	
	
	
	/*
	 * 	가맹점별 매출리스트 뷰
	 */
	@GetMapping("/storeSalesList")
	public String storeSalesList() {
		log.info("storeSalesList()");
		
		String nextPage = "/admin/sales/admin_store_sales_list";
		
		return nextPage;
		
	}
	
	/*
	 * 	전체 가맹점 매출 불러오기
	 */
	@PostMapping("/getStoreAllSalesInfo")
	@ResponseBody
	public Object getStoreAllSalesInfo() {
		log.info("getStoreAllSalesInfo()");
		
		Map<String, Object> resultMap = 
				adminSalesService.getStoreAllSalesInfo();
		
		return resultMap;
	}
	
	/*
	 * 	선택 날짜 가맹첨 매출 리스트 불러오기
	 */
	@PostMapping("/getSelectDateSalesInfo")
	@ResponseBody
	public Object getSelectDateSalesInfo(@RequestBody Map<String, String> currentDate) {
		log.info("getSelectDateSalesInfo()");
		
		Map<String, Object> resultMap = 
				adminSalesService.getSelectDateSalesInfo(currentDate);
		
		return resultMap;
	}
	
	/*
	 * 	선택 기간 가맹점별 매출 리스트 불러오기
	 */
	@PostMapping("/getStoreTotalSalesByInputPeriod")
	@ResponseBody
	public Object getStoreTotalSalesByInputPeriod(@RequestBody Map<String, String> period) {
		log.info("getStoreTotalSalesByInputPeriod()");
		
		Map<String, Object> resultMap = 
				adminSalesService.getStoreTotalSalesByInputPeriod(period);
		
		return resultMap;
		
	}
	
	/*
	 * 	가맹회원별 매출 리스트 뷰
	 */
	@GetMapping("/franchiseeSalesList")
	public String franchiseeSalesList() {
		log.info("franchiseeSalesList()");
		
		String nextPage = "/admin/sales/admin_franchisee_sales_list";
		
		return nextPage;
		
	}
	
	/*
	 * 	전체 회원별 매출 불러오기
	 */
	@PostMapping("/getFranchiseeAllSalesInfo")
	@ResponseBody
	public Object getFranchiseeAllSalesInfo() {
		log.info("getFranchiseeAllSalesInfo()");
		
		Map<String, Object> resultMap = 
				adminSalesService.getFranchiseeAllSalesInfo();
		
		return resultMap;
	}
	
	/*
	 * 	선택 날짜 회원별 매출 리스트 불러오기
	 */
	@PostMapping("/getSelectDateFranchiseeSalesInfo")
	@ResponseBody
	public Object getSelectDateFranchiseeSalesInfo(@RequestBody Map<String, String> currentDate) {
		log.info("getSelectDateFranchiseeSalesInfo()");
		
		Map<String, Object> resultMap = 
				adminSalesService.getSelectDateFranchiseeSalesInfo(currentDate);
		
		return resultMap;
	}
	
	/*
	 * 	선택 기간 회원별 매출 리스트 불러오기
	 */
	@PostMapping("/getFranchiseeTotalSalesByInputPeriod")
	@ResponseBody
	public Object getFranchiseeTotalSalesByInputPeriod(@RequestBody Map<String, String> period) {
		log.info("getFranchiseeTotalSalesByInputPeriod()");
		
		Map<String, Object> resultMap = 
				adminSalesService.getFranchiseeTotalSalesByInputPeriod(period);
		
		return resultMap;
		
	}
	
	
	
}
