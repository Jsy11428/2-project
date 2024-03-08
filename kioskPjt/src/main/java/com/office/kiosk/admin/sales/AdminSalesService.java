package com.office.kiosk.admin.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.kiosk.admin.member.IAdminMemberDao;
import com.office.kiosk.franchisee.dto.SearchSalesDto;
import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;
import com.office.kiosk.paging.kioskPageDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminSalesService {
	
	@Autowired
	IAdminSalesDao iAdminSalesDao;
	
	@Autowired
	IAdminMemberDao iAdminMemberDao;
	
	private int pageLimit = 5; 		// 한 페이지당 보여줄 admin정보 갯수
	private int blockLimit = 3; 	// 하단에 보여줄 페이지 번호 갯수

	public List<FranchiseeSalesDto> salesList() {
		log.info("salesList()");
			
		return iAdminSalesDao.selectAllSalesInfo();
	}

//	public Map<String, Object> getAllSalesInfo() {
//		log.info("getAllSalesInfo()");
//		
//		Map<String, Object> map = new HashMap<>();
//		
//		List<FranchiseeSalesDto> franchiseeSalesDtos = 
//				iAdminSalesDao.selectAllSalesInfoForAjax();
//		
//		map.put("franchiseeSalesDtos", franchiseeSalesDtos);
//		
//		return map;
//	}
	
	public Map<String, Object> pagingAllSalesInfo(int page) {
		log.info("pagingAllSalesInfo()");
		
		int pagingStart = (page - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		
		List<FranchiseeSalesDto> allFranchiseeSalesDtos = iAdminSalesDao.selectSalesListForPaging(pagingParams);
		
		pagingList.put("allFranchiseeSalesDtos", allFranchiseeSalesDtos);
		
		return pagingList;
	}
	
	public kioskPageDto allSalesListPageNum(int page) {
		log.info("allSalesListPageNum()");
		
		//전체 franchisee member 갯수 조회
		int allSalesListCnt = iAdminSalesDao.selectAllSalesListCnt();
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) allSalesListCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto allSalesListPageDto = new kioskPageDto();
		allSalesListPageDto.setPage(page);
		allSalesListPageDto.setMaxPage(maxPage);
		allSalesListPageDto.setStartPage(startPage);
		allSalesListPageDto.setEndPage(endPage);
		
		return allSalesListPageDto;
	}

	public Map<String, Object> getSearchSales(SearchSalesDto searchSalesDto) {
		log.info("getSearchSales()");
		
		Map<String, Object> map = new HashMap<>();
		
		String searchValue = searchSalesDto.getSearch_value();
		String searchTerm = searchSalesDto.getSearch_term();
		String searchWord = searchSalesDto.getSearch_word();
		
		List<FranchiseeSalesDto> searchSalesDtos = new ArrayList<>();
		
		searchSalesDtos = iAdminSalesDao.selectSalesInfo(searchSalesDto);
		
		map.put("searchSalesDtos", searchSalesDtos);
		
		return map;
	}

	public Map<String, Object> getStoreAllSalesInfo() {
		log.info("getStoreAllSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> storeSalesDtos = 
				iAdminSalesDao.selectStoreTotalSales();
		
		map.put("storeSalesDtos", storeSalesDtos);
		
		return map;
	}

	public Map<String, Object> getSelectDateSalesInfo(Map<String, String> currentDate) {
		log.info("getSelectDateSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		String year = currentDate.get("year");
        String month = currentDate.get("month");
        String date = currentDate.get("date");

        String selectDate = String.format("%04d-%02d-%02d",
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(date));
		
		List<FranchiseeSalesDto> selectSalesDtos = 
				iAdminSalesDao.selectDateTotalSales(selectDate);
		
		map.put("selectSalesDtos", selectSalesDtos);
		
		return map;
	}

	public Map<String, Object> getFranchiseeAllSalesInfo() {
		log.info("getFranchiseeAllSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> franchiseeSalesDtos = 
				iAdminSalesDao.selectFranchiseeTotalSales();
		
		map.put("franchiseeSalesDtos", franchiseeSalesDtos);
		
		return map;
	}

	public Map<String, Object> getSelectDateFranchiseeSalesInfo(Map<String, String> currentDate) {
		log.info("getSelectDateSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		String year = currentDate.get("year");
        String month = currentDate.get("month");
        String date = currentDate.get("date");

        String selectDate = String.format("%04d-%02d-%02d",
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(date));
		
		List<FranchiseeSalesDto> selectFranchiseeSalesDtos = 
				iAdminSalesDao.selectDateFranchiseeTotalSales(selectDate);
		
		map.put("selectFranchiseeSalesDtos", selectFranchiseeSalesDtos);
		
		return map;
	}

	public Map<String, Object> getFranchiseeTotalSalesByInputPeriod(Map<String, String> period) {
		log.info("getFranchiseeTotalSalesByInputPeriod()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> selectFranchiseeSalesDtosByInputFeriod =
				iAdminSalesDao.selectFranchiseeSalesDtosByInputFeriod(period);
		
		map.put("selectFranchiseeSalesDtosByInputFeriod", selectFranchiseeSalesDtosByInputFeriod);
		
		return map;
		
	}

	public Map<String, Object> getStoreTotalSalesByInputPeriod(Map<String, String> period) {
		log.info("getStoreTotalSalesByInputPeriod()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> selectStoreSalesDtosByInputFeriod =
				iAdminSalesDao.selectStoreSalesDtosByInputFeriod(period);
		
		map.put("selectStoreSalesDtosByInputFeriod", selectStoreSalesDtosByInputFeriod);
		
		return map;
	}

	public Map<String, Object> getSalesDetailInfo(int fco_ori_no) {
		log.info("getSalesDetailInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> salesDetailInfo = 
				iAdminSalesDao.selectOrderInfoByOriNo(fco_ori_no);
		
		map.put("salesDetailInfo", salesDetailInfo);
		
		return map;
	}



}
