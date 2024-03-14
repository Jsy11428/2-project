package com.office.kiosk.franchisee.sales;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IFranchiseeSalesDao {

	public List<FranchiseeSalesDto> selectMyStoreAllSalesInfo(Map<String, Integer> pagingParams);

	public int selectMyStoreAllSalesInfoCnt(String fcs_no);
	
}
