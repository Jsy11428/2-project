package com.office.kiosk.franchisee.menu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.office.kiosk.admin.menu.AdminMenuDto;

@Mapper
public interface IFranchiseeMenuDao {

	public int createMenu();
	
	public FranchiseeMenuDto getAllMenu();
	
	public int deleteMenu();
	
	public int modifyMenu();
	
	
	public int insertFranchiseeMenu(FranchiseeAddMenuDto franchiseeAddMenuDto);
	
	public List<FranchiseeMenuDto> selectAllCategory();

	public List<FranchiseeMenuDto> selectFranchiseeMenuPagingList(Map<String, Integer> pagingParams);

	public int selcetAllFranchiseeMenuListCnt();

	public List<FranchiseeMenuDto> selectFranchiseeMenuPagingListByCate(Map<String, Integer> pagingParams);

	public int selcetAllFranchiseeMenuListCntByCate(String fcmc_no);

	public FranchiseeMenuDto selectMenuInfo(String fc_menu_no);
	
}
