package com.office.kiosk.franchisee.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.office.kiosk.franchisee.FranchiseeStoreDto;

@Mapper
public interface IFranchiseeMemberDao {

	public boolean isMember(String fcm_id);

	public int insertFranchisee(FranchiseeMemberDto memberDto);

	public FranchiseeMemberDto selectFranchiseeForLogin(FranchiseeMemberDto franchiseeMemberDto);

	public int updateFranchiseeForModify(FranchiseeMemberDto franchiseeMemberDto);

	public FranchiseeMemberDto selectLastesFranchiseeInfo(int fcm_no);

	public FranchiseeMemberDto selectFranchiseeInfoByFcmId(String fcm_id);

	public List<FranchiseeStoreDto> selectFranchiseeStoreList(FranchiseeMemberDto dto);

}
