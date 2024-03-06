package com.office.kiosk.admin.menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.office.kiosk.franchisee.menu.FranchiseeMenuCategoryDto;
import com.office.kiosk.franchisee.menu.FranchiseeMenuDto;

@Mapper
public interface IAdminMenuDao {

	public List<FranchiseeMenuCategoryDto> selectAllCategory();

	public int insertMenuCategory(FranchiseeMenuCategoryDto franchiseeMenuCategoryDto);

	public boolean isMenuCategory(String fcmc_name);
	
	public int insertMenu(FranchiseeMenuDto franchiseeMenuDto);
	
	public boolean isMenu(String fc_menu_name);
}

