package com.office.kiosk.admin.sales;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.office.kiosk.franchisee.dto.SearchSalesDto;
import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;

@Mapper
public interface IAdminSalesDao {

	public List<FranchiseeSalesDto> selectAllSalesInfo();

	public List<FranchiseeSalesDto> selectAllSalesInfoForAjax();
	
	public List<FranchiseeSalesDto> selectSalesInfo(SearchSalesDto searchSalesDto);

	public List<FranchiseeSalesDto> selectStoreTotalSales();

	public List<FranchiseeSalesDto> selectDateTotalSales(String selectDate);

	public List<FranchiseeSalesDto> selectFranchiseeTotalSales();

	public List<FranchiseeSalesDto> selectDateFranchiseeTotalSales(String selectDate);

	public List<FranchiseeSalesDto> selectFranchiseeSalesDtosByInputFeriod(Map<String, String> period);

	public List<FranchiseeSalesDto> selectStoreSalesDtosByInputFeriod(Map<String, String> period);

	public List<FranchiseeSalesDto> selectOrderInfoByOriNo(int fco_ori_no);

	public int selectAllSalesListCnt();

	public List<FranchiseeSalesDto> selectSalesListForPaging(Map<String, Integer> pagingParams);

	public int selectSearchSalesListCnt(SearchSalesDto searchSalesDto);



}
