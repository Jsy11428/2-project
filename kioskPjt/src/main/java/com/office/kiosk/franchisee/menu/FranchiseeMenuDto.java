package com.office.kiosk.franchisee.menu;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FranchiseeMenuDto {

	private int fc_menu_no;
	private String fc_menu_name;
	private int fcmc_no;
	private String fc_menu_text;
	private int fc_menu_price;
	private String fc_menu_img_name;
	private int fc_menu_quantity;
	private String fc_menu_reg_date;
	private String fc_menu_mod_date;
	
}
