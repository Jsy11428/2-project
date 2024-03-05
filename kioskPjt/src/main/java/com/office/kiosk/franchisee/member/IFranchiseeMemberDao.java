package com.office.kiosk.franchisee.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IFranchiseeMemberDao {

	public boolean isMember(String fcm_id);

	public int insertFranchisee(FranchiseeMemberDto memberDto);

	public FranchiseeMemberDto selectFranchiseeForLogin(FranchiseeMemberDto franchiseeMemberDto);

	public int updateFranchiseeForModify(FranchiseeMemberDto franchiseeMemberDto);

	public FranchiseeMemberDto selectLastesFranchiseeInfo(int fcm_no);
	
}
