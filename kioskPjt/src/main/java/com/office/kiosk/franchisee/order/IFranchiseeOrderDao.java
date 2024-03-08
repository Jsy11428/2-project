package com.office.kiosk.franchisee.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IFranchiseeOrderDao {

//	public List<FranchiseeOrderDto> getOrdersByNo(int loginNo);

	public List<FranchiseeOrderDto> selectOrderPagingList(Map<String, Integer> pagingParams);

	public int selectAllOrderListCnt();

}
