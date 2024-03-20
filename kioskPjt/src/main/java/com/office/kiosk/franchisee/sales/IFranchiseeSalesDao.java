package com.office.kiosk.franchisee.sales;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IFranchiseeSalesDao {

	public List<FranchiseeSalesDto> selectMyStoreAllSalesInfo(Map<String, Integer> pagingParams);

	public int selectMyStoreAllSalesInfoCnt(String fcs_no);

	public List<FranchiseeSalesDto> selectMyStoreSalesInfoBySelectDate(Map<String, Object> pagingParams);

	public int selectMyStoreSalesInfoBySelectDateCnt(Map<String, Object> pagingParams);

	public List<FranchiseeSalesDto> selectMyStoreSalesInfoByInputPeriod(Map<String, Object> pagingParams);

	public int selectMyStoreSalesInfoByInputPeriodCnt(Map<String, Object> pagingParams);

	public FranchiseeSalesDto selectMyStoreTotalSales(String fcs_no);

	public FranchiseeSalesDto selectCurrentDateMyStoreTotalSales(Map<String, Object> pagingParams);

	public FranchiseeSalesDto selectPeriodDateMyStoreTotalSales(Map<String, Object> pagingParams);
	
}
