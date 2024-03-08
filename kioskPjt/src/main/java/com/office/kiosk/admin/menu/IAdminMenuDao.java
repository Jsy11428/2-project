package com.office.kiosk.admin.menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAdminMenuDao {

	public List<AdminMenuCategoryDto> selectAllCategory();

	public int insertMenuCategory(AdminMenuCategoryDto adminMenuCategoryDto);

	public boolean isMenuCategory(String fcmc_name);
	
	public List<AdminMenuDto> selectAllMenus();
	
	public int insertMenu(AdminMenuDto adminMenuDto);
	
	public boolean isMenu(String fc_menu_name);

	public List<AdminMenuDto> selectMenusByCategory(String fcmc_no);

	public AdminMenuDto selectMenuInfo(String fc_menu_no);

	public int updateSelectMenu(AdminMenuDto adminMenuDto);

	public int deleteSelectMenu(String fc_menu_no);


}
