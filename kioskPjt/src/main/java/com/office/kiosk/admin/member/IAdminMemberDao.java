package com.office.kiosk.admin.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAdminMemberDao {

	public boolean isMember(String am_id);

	public int insertAdmin(AdminMemberDto adminMemberDto);

	public AdminMemberDto selectAdminForLogin(AdminMemberDto adminMemberDto);

	public int updateAdminForModify(AdminMemberDto adminMemberDto);

	public AdminMemberDto selectLastesAdminInfo(int am_no);

}
