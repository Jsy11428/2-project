package com.office.kiosk.franchisee.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.office.kiosk.admin.menu.AdminMenuDto;

@Mapper
public interface IFranchiseeOrderDao {

//	public List<FranchiseeOrderDto> getOrdersByNo(int loginNo);

	public List<FranchiseeOrderDto> selectOrderPagingList(@Param("pagingParams") Map<String, Integer> pagingParams, @Param("loginNo") int loginNo);

	public int selectAllOrderListCnt(@Param("loginNo") int loginNo);

	public int deleteSelectOrder(int fco_no);

	public List<FranchiseeOrderDto> selectAllCategory();

	public List<FranchiseeOrderDto> selectAllMenu(int fcmc_no);

	public List<FranchiseeOrderDto> selectAllPrice(int fc_menu_no);

	public List<FranchiseeOrderDto> insertAllOrder(Map<String, Object> map);

}
