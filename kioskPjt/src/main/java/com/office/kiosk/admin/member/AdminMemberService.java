package com.office.kiosk.admin.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.office.kiosk.franchisee.FranchiseeStoreDto;
import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;
import com.office.kiosk.paging.kioskPageDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminMemberService {
	
	final static public int ADMIN_ID_ALREADY_EXIST		= -2;
	final static public int ADMIN_DATABASE_TRUBLE			= -1;
	final static public int ADMIN_INSERT_FAIL				= 0;
	final static public int ADMIN_INSERT_SUCCESS			= 1;
	
	private int pageLimit = 5; // 한 페이지당 보여줄 admin정보 갯수
	private int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수
	
	@Autowired
	IAdminMemberDao iAdminMemberDao;
	
	@Autowired
	AdminMemberDao adminMemberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	public int createAdminAccountConfirm(AdminMemberDto adminMemberDto) {
		log.info("createAdminAccountConfirm()");
		
		boolean ismember = iAdminMemberDao.isMember(adminMemberDto.getAm_id());
		
		if (!ismember) {
			
			adminMemberDto.setAm_pw(passwordEncoder.encode(adminMemberDto.getAm_pw()));
			
			int result = iAdminMemberDao.insertAdmin(adminMemberDto);
			
			switch (result) {
			case ADMIN_DATABASE_TRUBLE:
				log.info("DATABASE COMMUNICATION TRUBLE");
				
				break;
				
			case ADMIN_INSERT_FAIL:
				log.info("INSERT FAIL AT DATABASE");
				
				break;
				
			case ADMIN_INSERT_SUCCESS:
				log.info("INSERT SUCCESS AT DATABASE");
				
				break;

			}
			
			return result;
			
		} else {
			
			return ADMIN_ID_ALREADY_EXIST;
			
		}
	}


	public AdminMemberDto adminLoginConfirm(AdminMemberDto adminMemberDto) {
		log.info("adminLoginConfirm()");
		
		AdminMemberDto selectedAdminMemberDtoById = 
				iAdminMemberDao.selectAdminForLogin(adminMemberDto);
		
		if (selectedAdminMemberDtoById != null) {
			if (passwordEncoder.matches(adminMemberDto.getAm_pw(), selectedAdminMemberDtoById.getAm_pw())) {
				return selectedAdminMemberDtoById;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}


	public AdminMemberDto adminModifyConfirm(AdminMemberDto adminMemberDto) {
		log.info("adminModifyConfirm");
		
		int result = iAdminMemberDao.updateAdminForModify(adminMemberDto);
		
		if (result > 0) {
			
			
			return iAdminMemberDao.selectLastesAdminInfo(adminMemberDto.getAm_no());
			
		}
		
		return null;
	}


//	public List<FranchiseeMemberDto> franchiseeList() {
//		log.info("franchiseeList()");
//		
//		List<FranchiseeMemberDto> franchiseeMemberDtos = iAdminMemberDao.selectAllFranchiseeInfo();
//		
//		return franchiseeMemberDtos;
//		
////		return adminMemberDao.selectAllFranchiseeInfo();
//		
//	}
	
	public Map<String, Object> pagingFranchiseeList(int page) {
		log.info("franchiseeList()");
				
		///////////////////////////
		/*		 
		 1페이지에 보여지는 리스트 갯수 5개
		 1page => 0 (시작 인덱스)
		 2page => 5 (시작 인덱스)
		 3page => 10 (시작 인덱스)		 
		 */
		int pageingStart = (page - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pageingStart);
		pagingParams.put("limit", pageLimit);
		
		List<AdminMemberDto> franchiseeMemberDtos = iAdminMemberDao.selectFranchiseePagingList(pagingParams);
		pagingList.put("franchiseeMemberDtos", franchiseeMemberDtos);
		
		return pagingList;				
	}
	public kioskPageDto getAllFranchiseeListPageNum(int page) {
		log.info("getAllFranchiseeListPageNum()");	
		
		//전체 franchisee member 갯수 조회
		int franchiseeListCnt = iAdminMemberDao.selcetAllFranchiseeListCnt();
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) franchiseeListCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		kioskPageDto franchiseeMemberListPageDto = new kioskPageDto();
		franchiseeMemberListPageDto.setPage(page);
		franchiseeMemberListPageDto.setMaxPage(maxPage);
		franchiseeMemberListPageDto.setStartPage(startPage);
		franchiseeMemberListPageDto.setEndPage(endPage);
		
		return franchiseeMemberListPageDto;
	}

	public void franchiseeApprove(int fcm_no) {
		log.info("franchiseeList()");
		
		iAdminMemberDao.updateFranchiseeApproval(fcm_no);
		
	}


//	public List<AdminMemberDto> adminList() {
//		log.info("adminList()");
//		
//		List<AdminMemberDto> adminMemberDtos = iAdminMemberDao.selectAllAdminInfo();
//		
//		return adminMemberDtos;
//	}
	
//	public Map<String, Object> adminList() {
//		log.info("adminList()");
//		
//		Map<String, Object> map = new HashMap<>();
//		
//		List<AdminMemberDto> adminMemberDtos = iAdminMemberDao.selectAllAdminInfo();
//		
//		map.put("adminMemberDtos",adminMemberDtos);
//		
//		return map;
//	}


	public void adminApprove(int am_no) {
		log.info("franchiseeList()");
		
		iAdminMemberDao.updateAdminApproval(am_no);
		
	}
	
	
	public Map<String, Object> franchiseeInfoList() {
		log.info("franchiseeInfoList()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeStoreDto> allFranchiseeInfoDtos = iAdminMemberDao.selectAllFranchiseeStoreInfo();
		
		map.put("allFranchiseeInfoDtos", allFranchiseeInfoDtos);
		
		return map;
	}
	
	/*
	 * store list paging 처리
	 */
	public Map<String, Object> storeList(int page) {
		log.info("storeList()");
		
		int pageingStart = (page - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pageingStart);
		pagingParams.put("limit", pageLimit);
		
		List<FranchiseeStoreDto> franchiseeStoreDtos = iAdminMemberDao.selectAllFranchiseeStorePagingList(pagingParams);
		
		pagingList.put("franchiseeStoreDtos", franchiseeStoreDtos);
		
		return pagingList;
	}
	
	public kioskPageDto getAllStoreListPageNum(int page) {
		log.info("getAllStoreListPageNum()");	
		
		//전체 admin 갯수 조회
		int adminListCnt = iAdminMemberDao.selcetAllStoreListCnt();
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) adminListCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		kioskPageDto storeListPageDto = new kioskPageDto();
		storeListPageDto.setPage(page);
		storeListPageDto.setMaxPage(maxPage);
		storeListPageDto.setStartPage(startPage);
		storeListPageDto.setEndPage(endPage);
		
		return storeListPageDto;
	}

	
	/*
	 * admin list paging 처리
	 */
	public Map<String, Object> pagingAdminList(int page) {
		log.info("pagingAdminList()");		
				
		/*		 
		 1페이지에 보여지는 리스트 갯수 5개
		 1page => 0 (시작 인덱스)
		 2page => 5 (시작 인덱스)
		 3page => 10 (시작 인덱스)		 
		 */
		int pageingStart = (page - 1) * pageLimit;
		
		Map<String, Object> pagingList = new HashMap<>();
		
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pageingStart);
		pagingParams.put("limit", pageLimit);		
		
		List<AdminMemberDto> adminMemberDtos = iAdminMemberDao.selectAdminMemberPagingList(pagingParams);
				
		pagingList.put("adminMemberDtos", adminMemberDtos);
		
		return pagingList;
	}

	/*
	 * get all admin member list page number
	 */
	public kioskPageDto getAllAdminListPageNum(int page) {
		log.info("getAllAdminListPageNum()");	
		
		//전체 admin 갯수 조회
		int adminListCnt = iAdminMemberDao.selcetAllAdminListCnt();
		
		//전체 페이지 갯수 계산
		int maxPage = (int) (Math.ceil((double) adminListCnt / pageLimit));
		
		//시작 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (1,4,7,10,~~~~))
		int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1 ) * blockLimit + 1;
		
		//마지막 페이지 값 계산 (페이지 번호를 3개씩 보여줄 경우 = (3,6,9,12,~~~~~))
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		kioskPageDto adminMemberListPageDto = new kioskPageDto();
		adminMemberListPageDto.setPage(page);
		adminMemberListPageDto.setMaxPage(maxPage);
		adminMemberListPageDto.setStartPage(startPage);
		adminMemberListPageDto.setEndPage(endPage);
		
		return adminMemberListPageDto;
	}


	public Map<String, Object> getFranchiseeStoreListBySelect(int fcm_no) {
		log.info("getFranchiseeStoreListBySelect()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeStoreDto> franchiseeStoreDtos = iAdminMemberDao.selectFranchiseeStoreInfoBySelect(fcm_no);
		
		map.put("franchiseeStoreDtos", franchiseeStoreDtos);
		
		return map;
	}


	public Map<String, Object> createFranchiseeStoreConfirm(FranchiseeSalesDto franchiseeSalesDto) {
		log.info("createFranchiseeStoreConfirm()");
		
		Map<String, Object> map = new HashMap<>();
		
		int result = iAdminMemberDao.insertFranchiseeStore(franchiseeSalesDto);
		
		if (result > 0) {
			List<FranchiseeStoreDto> franchiseeStoreDto = 
					iAdminMemberDao.selectFranchiseeStoreByFcmNo(franchiseeSalesDto.getFcm_no());
			
			map.put("franchiseeStoreDto", franchiseeStoreDto);
			return map;
			
		} else {
			return map;
			
		}
		
		
	}


	public void franchiseeStoreDelete(int fcs_no) {
		log.info("franchiseeStoreDelete()");
		
		iAdminMemberDao.updateFranchiseeStoreByFcsNoForDelete(fcs_no);
		
		
	}


}
