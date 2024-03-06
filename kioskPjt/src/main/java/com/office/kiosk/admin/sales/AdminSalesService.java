package com.office.kiosk.admin.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminSalesService {
	
	@Autowired
	IAdminSalesDao iAdminSalesDao;

	public List<FranchiseeSalesDto> salesList() {
		log.info("salesList()");
			
		return iAdminSalesDao.selectAllSalesInfo();
	}

}
