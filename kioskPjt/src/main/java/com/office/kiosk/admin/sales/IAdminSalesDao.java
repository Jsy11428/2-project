package com.office.kiosk.admin.sales;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.office.kiosk.franchisee.dto.SearchSalesDto;
import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;

@Mapper
public interface IAdminSalesDao {

	public List<FranchiseeSalesDto> selectAllSalesInfo();

	public List<FranchiseeSalesDto> selectAllSalesInfoForAjax();

	public List<FranchiseeSalesDto> selectSalesInfoByFcsNameForOneDay(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcsNameForOneWeek(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcsNameForOneMonth(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcsNameForSixMonth(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcsNameForOneYear(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcsName(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcmNameForOneDay(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcmNameForOneWeek(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcmNameForOneMonth(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcmNameForSixMonth(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcmNameForOneYear(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByFcmName(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByPmTypeForOneDay(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByPmTypeForOneWeek(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByPmTypeForOneMonth(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByPmTypeForSixMonth(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByPmTypeForOneYear(String searchWord);

	public List<FranchiseeSalesDto> selectSalesInfoByPmType(String searchWord);

	
	
//	public List<FranchiseeSalesDto> selectSalesInfoByFcsName(SearchSalesDto searchSalesDto);
//
//	public List<FranchiseeSalesDto> selectSalesInfoByFcmName(SearchSalesDto searchSalesDto);
//
//	public List<FranchiseeSalesDto> selectSalesInfoByPmType(SearchSalesDto searchSalesDto);

}
