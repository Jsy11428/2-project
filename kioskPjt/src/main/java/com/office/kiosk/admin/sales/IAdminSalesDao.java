package com.office.kiosk.admin.sales;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;

@Mapper
public interface IAdminSalesDao {

	public List<FranchiseeSalesDto> selectAllSalesInfo();

	public List<FranchiseeSalesDto> selectAllSalesInfoForAjax();

}
