package com.office.kiosk.franchisee.sales;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.kiosk.paging.kioskPageDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FranchiseeSalesService {
	
	private int pageLimit = 3; // 한 페이지당 보여줄 sales 정보 갯수
	private int blockLimit = 3;
	
	@Autowired
	IFranchiseeSalesDao ifranchiseeSalesDao;

	// 우리가게의 전체 매출 START
	
	public Map<String, Object> pagingMyStoreAllSalesInfo(int page, String fcs_no) {
		log.info("pagingMyStoreAllSalesInfo()");
		
		 /*
		 1페이지에 보여지는 리스트 갯수 3개
		 1page => 0 (시작 인덱스)
		 2page => 4 (시작 인덱스)
		 3page => 8 (시작 인덱스)		 
		 */
		
		int pageingStart = (page - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pageingStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("fcs_no", Integer.parseInt(fcs_no));
		
		List<FranchiseeSalesDto> myStoreAllSalesInfo = ifranchiseeSalesDao.selectMyStoreAllSalesInfo(pagingParams);
		
		pagingList.put("myStoreAllSalesInfo", myStoreAllSalesInfo);
		
		return pagingList;
		
	}

	public kioskPageDto getMyStoreSalesInfoPageNum(int page, String fcs_no) {
		log.info("getMyStoreSalesInfoPageNum()");
		
		// 우리매장의 전체 sales 갯수 조회
		int salesInfoCnt = ifranchiseeSalesDao.selectMyStoreAllSalesInfoCnt(fcs_no);
		
		// 전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) salesInfoCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		// 마지막 페이지 값 계산
		int endPage = startPage + blockLimit - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto myStoreSalesInfoPageDto = new kioskPageDto();
		myStoreSalesInfoPageDto.setPage(page);
		myStoreSalesInfoPageDto.setMaxPage(maxPage);
		myStoreSalesInfoPageDto.setStartPage(startPage);
		myStoreSalesInfoPageDto.setEndPage(endPage);
		
		log.info("page :" + page);
		log.info("maxPage :" + maxPage);
		log.info("startPage :" + startPage);
		log.info("endPage :" + endPage);
		
		return myStoreSalesInfoPageDto;
	}

	// 우리가게의 전체 매출 END
	
	
	// 우리가게의 선택날짜(위쪽에서 날짜 하루 찍었을때) 매출 START
	
	
	public Map<String, Object> pagingMyStoreSalesInfoBySelectDate(Map<String, String> currentDate) {
		log.info("pagingMyStoreSalesInfoBySelectDate()");
		
		int pagingStart = (Integer.parseInt(currentDate.get("page")) - 1) * pageLimit;
		
		String year = currentDate.get("year");
        String month = currentDate.get("month");
        String date = currentDate.get("date");
        String fcs_no = currentDate.get("fcs_no");

        String selectDate = String.format("%04d-%02d-%02d",
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(date));
        
        Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Object> pagingParams = new HashMap<>();
		
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("selectDate", selectDate);
		pagingParams.put("fcs_no", fcs_no);
		
		List<FranchiseeSalesDto> myStoreSalesDtosBySelectDate = 
				ifranchiseeSalesDao.selectMyStoreSalesInfoBySelectDate(pagingParams);
		
		pagingList.put("myStoreSalesDtosBySelectDate", myStoreSalesDtosBySelectDate);
		
		return pagingList;
		
	}

	public kioskPageDto getMyStoreSalesInfoBySelectDatePageNum(Map<String, String> currentDate) {
		log.info("getMyStoreSalesInfoBySelectDatePageNum()");
		
		String year = currentDate.get("year");
        String month = currentDate.get("month");
        String date = currentDate.get("date");
        String fcs_no = currentDate.get("fcs_no");
        

        String selectDate = String.format("%04d-%02d-%02d",
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(date));
        
        Map<String, Object> pagingParams = new HashMap<>();
        
        pagingParams.put("selectDate", selectDate);
        pagingParams.put("fcs_no", fcs_no);
		
		//우리매장의 선택날짜별 sales 갯수 조회
		int franchiseeSalesListCnt = ifranchiseeSalesDao.selectMyStoreSalesInfoBySelectDateCnt(pagingParams);
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) franchiseeSalesListCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) Integer.parseInt(currentDate.get("page")) / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto myStoreSalesInfoBySelectDate = new kioskPageDto();
		myStoreSalesInfoBySelectDate.setPage(Integer.parseInt(currentDate.get("page")));
		myStoreSalesInfoBySelectDate.setMaxPage(maxPage);
		myStoreSalesInfoBySelectDate.setStartPage(startPage);
		myStoreSalesInfoBySelectDate.setEndPage(endPage);
		
		
		return myStoreSalesInfoBySelectDate;
	}

	public Map<String, Object> pagingMyStoreSalesInfoByInputPeriod(Map<String, String> period) {
		log.info("pagingMyStoreSalesInfoBySelectDate()");
		
		int pagingStart = (Integer.parseInt(period.get("page")) - 1) * pageLimit;
		
		String startDate = period.get("startDate");
        String endDate = period.get("endDate");
        String fcs_no = period.get("fcs_no");
        
        Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Object> pagingParams = new HashMap<>();
		
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("startDate", startDate);
		pagingParams.put("endDate", endDate);
		pagingParams.put("fcs_no", fcs_no);
		
		List<FranchiseeSalesDto> myStoreSalesDtosByInputPeriod = 
				ifranchiseeSalesDao.selectMyStoreSalesInfoByInputPeriod(pagingParams);
		
		pagingList.put("myStoreSalesDtosByInputPeriod", myStoreSalesDtosByInputPeriod);
		
		return pagingList;
		
	}

	public kioskPageDto getMyStoreSalesInfoByInputPeriodPageNum(Map<String, String> period) {
	log.info("getMyStoreSalesInfoByInputPeriodPageNum()");
		
		String startDate = period.get("startDate");
		String endDate = period.get("endDate");
		String fcs_no = period.get("fcs_no");
        
        Map<String, Object> pagingParams = new HashMap<>();
        
        pagingParams.put("startDate", startDate);
        pagingParams.put("endDate", endDate);
        pagingParams.put("fcs_no", fcs_no);
		
		//우리매장의 선택날짜별 sales 갯수 조회
		int franchiseeSalesListCnt = ifranchiseeSalesDao.selectMyStoreSalesInfoByInputPeriodCnt(pagingParams);
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) franchiseeSalesListCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) Integer.parseInt(period.get("page")) / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		kioskPageDto myStoreSalesInfoBySelectDate = new kioskPageDto();
		myStoreSalesInfoBySelectDate.setPage(Integer.parseInt(period.get("page")));
		myStoreSalesInfoBySelectDate.setMaxPage(maxPage);
		myStoreSalesInfoBySelectDate.setStartPage(startPage);
		myStoreSalesInfoBySelectDate.setEndPage(endPage);
		
		
		return myStoreSalesInfoBySelectDate;
	}
	
	
	// 우리가게의 선택날짜(위쪽에서 날짜 하루 찍었을때) 매출 END	


}
