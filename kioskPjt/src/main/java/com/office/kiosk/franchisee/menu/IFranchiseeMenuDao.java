package com.office.kiosk.franchisee.menu;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IFranchiseeMenuDao {

	public int createMenu();
	public FranchiseeMenuDto getAllMenu();
	public int deleteMenu();
	public int modifyMenu();
	public int insertFranchiseeMenu(FranchiseeAddMenuDto franchiseeAddMenuDto);
	
}
