package com.office.kiosk.franchisee.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FranchiseeOrderService {
	
	@Autowired
	IFranchiseeOrderDao iFranchiseeOrderDao;

	
//	  public Map<String, Object> getAllOrders() {
//	  
//		  log.info("getAllOrders()");
//	  
//		  Map<String, Object> orderDtos = new HashMap<>();
//	  
//		  List<FranchiseeOrderDto> ordersDtos = iFranchiseeOrderDao.selectAllOrder();
//		  
//		  orderDtos.put("ordersDtos", ordersDtos);
//	 
//		  return orderDtos;
//	  
//	  	}
	

	public Map<String, Object> getOrdersNo(int loginNo) {
		log.info("getOrdersByFcsNo()");
		
		Map<String, Object> orderDtos = new HashMap<>();
		log.info("loginNo=====> " + loginNo);
		
	    List<FranchiseeOrderDto> ordersDtos = iFranchiseeOrderDao.getOrdersByNo(loginNo);
	    
	    
	    orderDtos.put("ordersDtos", ordersDtos);

	    return orderDtos;
	}
	 

}
