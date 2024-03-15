package com.office.kiosk.franchisee.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;

import jakarta.servlet.http.HttpSession;

@Mapper
public interface IFranchiseeOrderDao {

//	public List<FranchiseeOrderDto> getOrdersByNo(int loginNo);

	public List<FranchiseeOrderDto> selectOrderPagingList(@Param("pagingParams") Map<String, Integer> pagingParams, @Param("loginNo") int loginNo);

	public int selectAllOrderListCnt(@Param("loginNo") int loginNo);

	public int deleteSelectOrder(int fco_no);

	public List<FranchiseeOrderDto> selectAllCategory();

	public List<FranchiseeOrderDto> selectAllMenu(int fcmc_no);

	public List<FranchiseeOrderDto> selectAllPrice(int fc_menu_no);

	public int insertAllOrder(FranchiseeOrderDto franchiseeOrderDto);

	public FranchiseeOrderDto getOriNo();

	public FranchiseeSalesDto selectOrderTotalPriceByOriNo(int fco_ori_no);

	public int insertSalesByOrder(FranchiseeSalesDto salesDto);


}
