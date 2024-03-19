package com.office.kiosk.admin.sales;

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

	public Map<String, Object> pagingSearchSalesInfo(SearchSalesDto searchSalesDto) {
		log.info("pagingSearchSalesInfo()");
		
		int pagingStart = (searchSalesDto.getPage() - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Object> pagingParams = new HashMap<>();
		
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("search_term", searchSalesDto.getSearch_term());
		pagingParams.put("search_value", searchSalesDto.getSearch_value());
		pagingParams.put("search_word", searchSalesDto.getSearch_word());
		
		List<FranchiseeSalesDto> searchSalesDtos = iAdminSalesDao.selectSearchSalesInfoForPaging(pagingParams);
		
		pagingList.put("searchSalesDtos", searchSalesDtos);
		
		return pagingList;
		
	}
	
	public kioskPageDto SearchSalesListPageNum(SearchSalesDto searchSalesDto) {
		log.info("SearchSalesListPageNum()");
		
		//전체 franchisee member 갯수 조회
		int searchSalesListCnt = iAdminSalesDao.selectSearchSalesListCnt(searchSalesDto);
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) searchSalesListCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) searchSalesDto.getPage() / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto searchSalesListPageDto = new kioskPageDto();
		searchSalesListPageDto.setPage(searchSalesDto.getPage());
		searchSalesListPageDto.setMaxPage(maxPage);
		searchSalesListPageDto.setStartPage(startPage);
		searchSalesListPageDto.setEndPage(endPage);
		
		return searchSalesListPageDto;
	}
	

	public Map<String, Object> pagingStoreAllSalesInfo(int page) {
		log.info("pagingStoreAllSalesInfo()");
		
		int pagingStart = (page - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		
		List<FranchiseeSalesDto> storeSalesDtos = 
				iAdminSalesDao.selectStoreTotalSalesForPaging(pagingParams);
		
		pagingList.put("storeSalesDtos", storeSalesDtos);
		
		return pagingList;
		
	}

	
	public kioskPageDto allStoreSalesListPageNum(int page) {
		log.info("allStoreSalesListPageNum()");
		
		//전체 franchisee member 갯수 조회
		int allStoreSalesListCnt = iAdminSalesDao.selectAllStoreSalesListCnt();
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) allStoreSalesListCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto allStoreSalesListPageDto = new kioskPageDto();
		allStoreSalesListPageDto.setPage(page);
		allStoreSalesListPageDto.setMaxPage(maxPage);
		allStoreSalesListPageDto.setStartPage(startPage);
		allStoreSalesListPageDto.setEndPage(endPage);
		
		return allStoreSalesListPageDto;
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
	
	public Map<String, Object> pagingSelectDateSalesInfo(Map<String, String> currentDate) {
		log.info("getSelectDateSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		String year = currentDate.get("year");
        String month = currentDate.get("month");
        String date = currentDate.get("date");

        String selectDate = String.format("%04d-%02d-%02d",
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(date));
        
		int pagingStart = (Integer.parseInt(currentDate.get("page")) - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Object> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("selectDate", selectDate);
		
		List<FranchiseeSalesDto> selectSalesDtosBySelectDate = 
				iAdminSalesDao.selectStoreSalesInfoBySelectDate(pagingParams);
		
		pagingList.put("selectSalesDtosBySelectDate", selectSalesDtosBySelectDate);
		
		return pagingList;
		
	}

	
	public kioskPageDto StoreSalesListPageNumBySelectDate(Map<String, String> currentDate) {
		log.info("StoreSalesListPageNumBySelectDate()");
		
		int page = Integer.parseInt(currentDate.get("page"));
		
		String year = currentDate.get("year");
        String month = currentDate.get("month");
        String date = currentDate.get("date");

        String selectDate = String.format("%04d-%02d-%02d",
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(date));
		
		//전체 franchisee member 갯수 조회
		int StoreSalesListCntBySelectDate = iAdminSalesDao.selectStoreSalesListCntBySelectDate(selectDate);
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) StoreSalesListCntBySelectDate / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto StoreSalesListPageDtoBySelectDate = new kioskPageDto();
		StoreSalesListPageDtoBySelectDate.setPage(page);
		StoreSalesListPageDtoBySelectDate.setMaxPage(maxPage);
		StoreSalesListPageDtoBySelectDate.setStartPage(startPage);
		StoreSalesListPageDtoBySelectDate.setEndPage(endPage);
		
		return StoreSalesListPageDtoBySelectDate;
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

	public Map<String, Object> getSalesDetailInfo(int fco_ori_no) {
		log.info("getSalesDetailInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> salesDetailInfo = 
				iAdminSalesDao.selectOrderInfoByOriNo(fco_ori_no);
		
		map.put("salesDetailInfo", salesDetailInfo);
		
		return map;
	}

	public kioskPageDto storeSalesListPageNumByInputPeriod(Map<String, String> period) {
		log.info("storeSalesListPageNumByInputPeriod()");
		
		int page = Integer.parseInt(period.get("page"));

		//전체 franchisee member 갯수 조회
		int StoreSalesListCntByInputPeriod = iAdminSalesDao.selectStoreSalesListCntByInputPeriod(period);
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) StoreSalesListCntByInputPeriod / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto StoreSalesListPageDtoByInputPeriod = new kioskPageDto();
		StoreSalesListPageDtoByInputPeriod.setPage(page);
		StoreSalesListPageDtoByInputPeriod.setMaxPage(maxPage);
		StoreSalesListPageDtoByInputPeriod.setStartPage(startPage);
		StoreSalesListPageDtoByInputPeriod.setEndPage(endPage);
		
		
		return StoreSalesListPageDtoByInputPeriod;
		
	}

	public Map<String, Object> pagingStoreSalesListByInputPeriod(Map<String, String> period) {
		log.info("pagingStoreSalesListByInputPeriod()");
		
		Map<String, Object> map = new HashMap<>();
		
		String startDate = period.get("startDate");
		String endDate = period.get("endDate");
        
		int pagingStart = (Integer.parseInt(period.get("page")) - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Object> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("startDate", startDate);
		pagingParams.put("endDate", endDate);
		
		
		List<FranchiseeSalesDto> sotreSalesDtosByInputPeriod = 
				iAdminSalesDao.selectStoreSalesInfoByInputPeriod(pagingParams);
		
		pagingList.put("sotreSalesDtosByInputPeriod", sotreSalesDtosByInputPeriod);
		
		return pagingList;
	}

	public kioskPageDto allFranchiseeSalesListPageNum(int page) {
		log.info("allFranchiseeSalesListPageNum()");
		
		//전체 franchisee member 갯수 조회
		int franchiseeSalesListCnt = iAdminSalesDao.selectFranchiseeSalesListCnt();
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) franchiseeSalesListCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto StoreSalesListPageDtoByInputPeriod = new kioskPageDto();
		StoreSalesListPageDtoByInputPeriod.setPage(page);
		StoreSalesListPageDtoByInputPeriod.setMaxPage(maxPage);
		StoreSalesListPageDtoByInputPeriod.setStartPage(startPage);
		StoreSalesListPageDtoByInputPeriod.setEndPage(endPage);
		
		
		return StoreSalesListPageDtoByInputPeriod;
		
	}

	public Map<String, Object> pagingFranchiseeAllSalesInfo(int page) {
		log.info("pagingFranchiseeAllSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		int pagingStart = (page - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Object> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		
		List<FranchiseeSalesDto> franchiseeSalesDtos = 
				iAdminSalesDao.selectFranchiseeSalesInfo(pagingParams);
		
		pagingList.put("franchiseeSalesDtos", franchiseeSalesDtos);
		
		return pagingList;
	}

	public kioskPageDto franchiseeSalesListPageNumBySelectDate(Map<String, String> currentDate) {
		log.info("franchiseeSalesListPageNumBySelectDate()");
		
		String year = currentDate.get("year");
        String month = currentDate.get("month");
        String date = currentDate.get("date");

        String selectDate = String.format("%04d-%02d-%02d",
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(date));
		
		//전체 franchisee member 갯수 조회
		int franchiseeSalesListCnt = iAdminSalesDao.selectFranchiseeSalesListCntBySelectDate(selectDate);
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) franchiseeSalesListCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) Integer.parseInt(currentDate.get("page")) / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto StoreSalesListPageDtoByInputPeriod = new kioskPageDto();
		StoreSalesListPageDtoByInputPeriod.setPage(Integer.parseInt(currentDate.get("page")));
		StoreSalesListPageDtoByInputPeriod.setMaxPage(maxPage);
		StoreSalesListPageDtoByInputPeriod.setStartPage(startPage);
		StoreSalesListPageDtoByInputPeriod.setEndPage(endPage);
		
		
		return StoreSalesListPageDtoByInputPeriod;
	}

	public Map<String, Object> pagingFranchiseeSalesInfoBySelectDate(Map<String, String> currentDate) {
		log.info("pagingFranchiseeSalesInfoBySelectDate()");
		
		Map<String, Object> map = new HashMap<>();
		
		int pagingStart = (Integer.parseInt(currentDate.get("page")) - 1) * pageLimit;
		
		String year = currentDate.get("year");
        String month = currentDate.get("month");
        String date = currentDate.get("date");

        String selectDate = String.format("%04d-%02d-%02d",
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(date));
        
        log.info("selectDate---" + selectDate);
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Object> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("selectDate", selectDate);
		
		List<FranchiseeSalesDto> franchiseeSalesDtosBySelectDate = 
				iAdminSalesDao.selectFranchiseeSalesInfoBySelectDate(pagingParams);
		
		log.info("franchiseeSalesDtosBySelectDate --- " + franchiseeSalesDtosBySelectDate);
		
		pagingList.put("franchiseeSalesDtosBySelectDate", franchiseeSalesDtosBySelectDate);
		
		return pagingList;
	}

	public kioskPageDto franchiseeSalesListPageNumByInputPeriod(Map<String, String> period) {
		log.info("franchiseeSalesListPageNumByInputPeriod()");
		
		int page = Integer.parseInt(period.get("page"));

		//전체 franchisee member 갯수 조회
		int franchiseeSalesListCntByInputPeriod = iAdminSalesDao.selectFranchiseeSalesListCntByInputPeriod(period);
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) franchiseeSalesListCntByInputPeriod / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto franchiseeSalesListPageDtoByInputPeriod = new kioskPageDto();
		franchiseeSalesListPageDtoByInputPeriod.setPage(page);
		franchiseeSalesListPageDtoByInputPeriod.setMaxPage(maxPage);
		franchiseeSalesListPageDtoByInputPeriod.setStartPage(startPage);
		franchiseeSalesListPageDtoByInputPeriod.setEndPage(endPage);
		
		
		return franchiseeSalesListPageDtoByInputPeriod;
	}

	public Map<String, Object> pagingFranchiseeTotalSalesByInputPeriod(Map<String, String> period) {
		log.info("pagingFranchiseeTotalSalesByInputPeriod()");
		
		Map<String, Object> map = new HashMap<>();
		
		String startDate = period.get("startDate");
		String endDate = period.get("endDate");
        
		int pagingStart = (Integer.parseInt(period.get("page")) - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Object> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("startDate", startDate);
		pagingParams.put("endDate", endDate);
		
		
		List<FranchiseeSalesDto> franchiseeSalesDtosByInputPeriod = 
				iAdminSalesDao.selectFranchiseeSalesInfoByInputPeriod(pagingParams);
		
		pagingList.put("franchiseeSalesDtosByInputPeriod", franchiseeSalesDtosByInputPeriod);
		
		return pagingList;
	}












}
