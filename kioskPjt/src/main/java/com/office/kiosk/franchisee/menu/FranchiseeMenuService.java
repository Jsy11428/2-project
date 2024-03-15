package com.office.kiosk.franchisee.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.kiosk.admin.menu.AdminMenuCategoryDto;
import com.office.kiosk.admin.menu.AdminMenuDto;
import com.office.kiosk.paging.kioskPageDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FranchiseeMenuService {
	
	private int pageLimit = 12; // 한 페이지당 보여줄 menu정보 갯수
	private int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수
	
	@Autowired
	IFranchiseeMenuDao iFranchiseeMenuDao;

	public int createMenuAccountConfirm(FranchiseeAddMenuDto franchiseeAddMenuDto) {
		log.info("createMenuAccountConfirm()");
		
		int result = -1;
		
		result = iFranchiseeMenuDao.insertFranchiseeMenu(franchiseeAddMenuDto);
		
		return result;
	}

	public Map<String, Object> getCategory() {
		
		log.info("getCategory()");

		Map<String, Object> cateDtos = new HashMap<>();

		List<FranchiseeMenuDto> categoryDtos = (List<FranchiseeMenuDto>) iFranchiseeMenuDao.selectAllCategory();

		cateDtos.put("categoryDtos", categoryDtos);

		return cateDtos;
	}

	
	public Map<String, Object> pagingFranchiseeMenuList(int page) {
		log.info("pagingAdminMenuList");
				
		int pageingStart = (page - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pageingStart);
		pagingParams.put("limit", pageLimit);
		
		List<FranchiseeMenuDto> franchiseeMenuDtos = iFranchiseeMenuDao.selectFranchiseeMenuPagingList(pagingParams);
		
		pagingList.put("franchiseeMenuDtos", franchiseeMenuDtos);
		
		return pagingList;
	}



	// 모든 페이지 number 불러오기
	
	public kioskPageDto getAllFranchiseeMenuListPageNum(int page) {
		log.info("getAllAdminMenuListPageNum");
		
		// 전체 menu 갯수 조회
		int menuListcnt = iFranchiseeMenuDao.selcetAllFranchiseeMenuListCnt();
		
		// 전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) menuListcnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		// 마지막 페이지 값 계산
		int endPage = startPage + blockLimit - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		kioskPageDto franchiseeMenuListPageDto = new kioskPageDto();
		franchiseeMenuListPageDto.setPage(page);
		franchiseeMenuListPageDto.setMaxPage(maxPage);
		franchiseeMenuListPageDto.setStartPage(startPage);
		franchiseeMenuListPageDto.setEndPage(endPage);
		
		log.info("page :" + page);
		log.info("maxPage :" + maxPage);
		log.info("startPage :" + startPage);
		log.info("endPage :" + endPage);
		
		return franchiseeMenuListPageDto;
	}

	public Map<String, Object> pagingFranchiseeMenuListByCate(int page, String fcmc_no) {
		log.info("pagingAdminMenuList");
			
		int pageingStart = (page - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pageingStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("fcmc_no", Integer.parseInt(fcmc_no));
		
		List<FranchiseeMenuDto> franchiseeMenuDtos = iFranchiseeMenuDao.selectFranchiseeMenuPagingListByCate(pagingParams);
		
		pagingList.put("franchiseeMenuDtos", franchiseeMenuDtos);
		
		return pagingList;
	}

	public kioskPageDto getAllFranchiseeMenuListPageNumByCate(int page, String fcmc_no) {
		log.info("getAllAdminMenuListPageNumByCate");
		
		// 전체 menu 갯수 조회
		int menuListcnt = iFranchiseeMenuDao.selcetAllFranchiseeMenuListCntByCate(fcmc_no);
		
		// 전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) menuListcnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		// 마지막 페이지 값 계산
		int endPage = startPage + blockLimit - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		kioskPageDto franchiseeMenuListPageDto = new kioskPageDto();
		franchiseeMenuListPageDto.setPage(page);
		franchiseeMenuListPageDto.setMaxPage(maxPage);
		franchiseeMenuListPageDto.setStartPage(startPage);
		franchiseeMenuListPageDto.setEndPage(endPage);
		
		log.info("franchiseeMenuListPageDto ====>" + franchiseeMenuListPageDto);
		
		log.info("page :" + page);
		log.info("maxPage :" + maxPage);
		log.info("startPage :" + startPage);
		log.info("endPage :" + endPage);
		
		return franchiseeMenuListPageDto;
	}

	public FranchiseeMenuDto getSelectMenuInfo(String fc_menu_no) {
		
		log.info("getSelectMenuInfo()");

		FranchiseeMenuDto dto = iFranchiseeMenuDao.selectMenuInfo(fc_menu_no);

		return dto;
	}

}
