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

	


}
