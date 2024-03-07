package com.office.kiosk.franchisee.order;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.kiosk.admin.menu.AdminMenuDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FranchiseeOrderService {
	
	@Autowired
	IFranchiseeOrderDao iFranchiseeOrderDao;

	  public Map<String, Object> getAllOrders() { 
		  
	  log.info("getAllOrders()");
	  
	  Map<String, Object> orderDtos = new HashMap<>();
	  
	  List<FranchiseeOrderDto> ordersDtos = iFranchiseeOrderDao.selectAllOrder();
	  
	  log.info("ordersDtos-------" + ordersDtos);
	  
	  orderDtos.put("ordersDtos", ordersDtos);
	  
	  return orderDtos;
	 
	  }
	 

}
