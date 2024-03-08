package com.office.kiosk.franchisee.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IFranchiseeOrderDao {

//	public List<FranchiseeOrderDto> selectAllOrder();

	public List<FranchiseeOrderDto> getOrdersByNo(int loginNo);

}
