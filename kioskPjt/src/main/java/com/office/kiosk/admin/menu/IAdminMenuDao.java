package com.office.kiosk.admin.menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.office.kiosk.franchisee.menu.FranchiseeMenuCategoryDto;
import com.office.kiosk.franchisee.menu.FranchiseeMenuDto;

@Mapper
public interface IAdminMenuDao {

	public List<AdminMenuCategoryDto> selectAllCategory();

	public int insertMenuCategory(AdminMenuCategoryDto adminMenuCategoryDto);

	public boolean isMenuCategory(String fcmc_name);
	
	public List<AdminMenuDto> selectAllMenus();
	
}
