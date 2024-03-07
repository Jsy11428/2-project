package com.office.kiosk.admin.sales;

import java.util.ArrayList;
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
		
		String searchValue = searchSalesDto.getSearch_value();
		String searchTerm = searchSalesDto.getSearch_term();
		String searchWord = searchSalesDto.getSearch_word();
		
		List<FranchiseeSalesDto> searchSalesDtos = new ArrayList<>();
		
		switch (searchValue) {
		case "fcs_name":
			
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsName(searchSalesDto);
			
			switch (searchTerm) {
			case "1d":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsNameForOneDay(searchWord);
				
				break;
			
			case "1w":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsNameForOneWeek(searchWord);
				
				break;
				
			case "1m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsNameForOneMonth(searchWord);
				
				break;
			
			case "6m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsNameForSixMonth(searchWord);
				
				break;
				
			case "1y":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsNameForOneYear(searchWord);
				
				break;
			
			case "all":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsName(searchWord);
				
				break;
				
			}
			
			break;
			
		case "fcm_name":
			
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmName(searchSalesDto);
			
			switch (searchTerm) {
			case "1d":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmNameForOneDay(searchWord);
				
				break;
			
			case "1w":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmNameForOneWeek(searchWord);
				
				break;
				
			case "1m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmNameForOneMonth(searchWord);
				
				break;
			
			case "6m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmNameForSixMonth(searchWord);
				
				break;
				
			case "1y":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmNameForOneYear(searchWord);
				
				break;
			
			case "all":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmName(searchWord);
				
				break;
				
			}
			
			break;
			
		case "pm_type":
			
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmType(searchSalesDto);
			
			switch (searchTerm) {
			case "1d":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmTypeForOneDay(searchWord);
				
				break;
			
			case "1w":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmTypeForOneWeek(searchWord);
				
				break;
				
			case "1m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmTypeForOneMonth(searchWord);
				
				break;
			
			case "6m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmTypeForSixMonth(searchWord);
				
				break;
				
			case "1y":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmTypeForOneYear(searchWord);
				
				break;
			
			case "all":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmType(searchWord);
				
				break;
				
			}
			
			break;
		}
		
//		if (searchValue == "fcs_name") {
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsName(searchSalesDto);
//		} else if (searchValue == "fcm_name") {
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmName(searchSalesDto);
//		} else if (searchValue == "pm_type") {
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmType(searchSalesDto);
//		}
		
		
		map.put("searchSalesDtos", searchSalesDtos);
		
		return map;
	}

}
