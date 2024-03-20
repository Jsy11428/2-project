package com.office.kiosk.admin.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.office.kiosk.franchisee.FranchiseeStoreDto;
import com.office.kiosk.franchisee.member.FranchiseeMemberDto;
import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;

@Mapper
public interface IAdminMemberDao {

	public boolean isMember(String am_id);

	public int insertAdmin(AdminMemberDto adminMemberDto);

	public AdminMemberDto selectAdminForLogin(AdminMemberDto adminMemberDto);

	public int updateAdminForModify(AdminMemberDto adminMemberDto);

	public AdminMemberDto selectLastesAdminInfo(int am_no);

	public List<FranchiseeMemberDto> selectAllFranchiseeInfo();//안 씀

	public void updateFranchiseeApproval(int fcm_no);

	public List<AdminMemberDto> selectAllAdminInfo();//안 씀

	public void updateAdminApproval(int am_no);

	public List<FranchiseeStoreDto> selectAllFranchiseeStoreInfo();

	public List<AdminMemberDto> selectAdminMemberPagingList(Map<String, Integer> pagingParams);

	public int selcetAllAdminListCnt();

	public List<AdminMemberDto> selectFranchiseePagingList(Map<String, Integer> pagingParams);

	public int selcetAllFranchiseeListCnt();

	public List<FranchiseeStoreDto> selectAllFranchiseeStorePagingList(Map<String, Integer> pagingParams);

	public int selcetAllStoreListCnt();

	public List<FranchiseeStoreDto> selectFranchiseeStoreInfoBySelect(String fcm_id);

	public int insertFranchiseeStore(FranchiseeSalesDto franchiseeSalesDto);

	public List<FranchiseeStoreDto> selectFranchiseeStoreByFcmNo(int fcm_no);

	public void updateFranchiseeStoreByFcsNoForDelete(int fcs_no);


}
