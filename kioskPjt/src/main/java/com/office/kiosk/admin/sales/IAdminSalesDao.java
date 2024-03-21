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
	
	public List<FranchiseeSalesDto> selectDateTotalSales(String selectDate);

	public List<FranchiseeSalesDto> selectFranchiseeTotalSales();

	public List<FranchiseeSalesDto> selectDateFranchiseeTotalSales(String selectDate);

	public List<FranchiseeSalesDto> selectFranchiseeSalesDtosByInputFeriod(Map<String, String> period);

	public List<FranchiseeSalesDto> selectStoreSalesDtosByInputFeriod(Map<String, String> period);

	public List<FranchiseeSalesDto> selectOrderInfoByOriNo(int fco_ori_no);

	public int selectAllSalesListCnt();

	public List<FranchiseeSalesDto> selectSalesListForPaging(Map<String, Integer> pagingParams);

	public int selectSearchSalesListCnt(SearchSalesDto searchSalesDto);

	public List<FranchiseeSalesDto> selectSearchSalesInfoForPaging(Map<String, Object> pagingParams);

	public int selectAllStoreSalesListCnt();

	public List<FranchiseeSalesDto> selectStoreTotalSalesForPaging(Map<String, Integer> pagingParams);

	public int selectStoreSalesListCntBySelectDate(String selectDate);

	public List<FranchiseeSalesDto> selectStoreSalesInfoBySelectDate(Map<String, Object> pagingParams);

	public int selectStoreSalesListCntByInputPeriod(Map<String, String> period);

	public List<FranchiseeSalesDto> selectStoreSalesInfoByInputPeriod(Map<String, Object> pagingParams);

	public int selectFranchiseeSalesListCnt();

	public List<FranchiseeSalesDto> selectFranchiseeSalesInfo(Map<String, Object> pagingParams);

	public int selectFranchiseeSalesListCntBySelectDate(String selectDate);

	public List<FranchiseeSalesDto> selectFranchiseeSalesInfoBySelectDate(Map<String, Object> pagingParams);

	public int selectFranchiseeSalesListCntByInputPeriod(Map<String, String> period);

	public List<FranchiseeSalesDto> selectFranchiseeSalesInfoByInputPeriod(Map<String, Object> pagingParams);

	public FranchiseeSalesDto selectAllMemberTotalSales();

	public FranchiseeSalesDto selectSearchTotalSales(Map<String, Object> pagingParams);

	public List<FranchiseeSalesDto> selectStoreMonthlySales(int fcs_no);

}
