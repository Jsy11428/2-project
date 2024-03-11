package com.office.kiosk.franchisee.dto;

import lombok.Data;

@Data
public class SearchSalesDto {

	private String search_term; 
	private String search_value; 
	private String search_word;
	private int page;
	
}
