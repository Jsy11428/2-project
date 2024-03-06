package com.office.kiosk.admin.sales;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.kiosk.franchisee.dto.SearchSalesDto;
import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminSalesService {
	
	@Autowired
	IAdminSalesDao iAdminSalesDao;

	public List<FranchiseeSalesDto> salesList() {
		log.info("salesList()");
			
		return iAdminSalesDao.selectAllSalesInfo();
	}

	public Map<String, Object> getAllSalesInfo() {
		log.info("getAllSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> franchiseeSalesDtos = 
				iAdminSalesDao.selectAllSalesInfoForAjax();
		
		map.put("franchiseeSalesDtos", franchiseeSalesDtos);
		
		return map;
	}

	public Map<String, Object> getSearchSales(SearchSalesDto searchSalesDto) {
		log.info("getSearchSales()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> searchSalesDtos = 
				iAdminSalesDao.selectAllSalesInfoForAjax();
		
		map.put("searchSalesDtos", searchSalesDtos);
		
		return map;
	}

}
