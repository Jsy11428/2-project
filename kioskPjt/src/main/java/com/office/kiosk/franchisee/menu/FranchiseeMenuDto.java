package com.office.kiosk.franchisee.menu;

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
	
	
	private int fcmc_p_no;		
	private String fcmc_name;
	private String fcmc_reg_date;
	private String fcmc_mod_date;
	
}
