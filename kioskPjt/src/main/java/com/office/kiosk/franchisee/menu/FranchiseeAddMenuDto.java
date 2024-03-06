package com.office.kiosk.franchisee.menu;

import lombok.Data;

@Data
public class FranchiseeAddMenuDto {

	private int fc_add_menu_no;
	private int fcmc_no;
	private String fc_add_menu_name;
	private String fc_add_menu_text;
	private int fc_add_menu_price;
	private String fc_add_menu_img_name;
	private int fc_add_menu_approval;
	private String fc_add_menu_reg_date;
	private String fc_add_menu_mod_date;
	
}
