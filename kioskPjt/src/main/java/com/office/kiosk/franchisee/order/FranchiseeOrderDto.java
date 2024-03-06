package com.office.kiosk.franchisee.order;

import lombok.Data;

@Data
public class FranchiseeOrderDto {
	
	private int fco_no;			
	private int fco_ori_no;		
	private int fco_menu_cnt;
	private String fco_reg_date;
	private String fco_mod_date;
	
	private int fc_menu_no;
	private String fc_menu_name;
	private int fcmc_no;
	private String fc_menu_text;
	private int fc_menu_price;
	private String fc_menu_img_name;
	private int fc_menu_quantity;
	private String fc_menu_reg_date;
	private String fc_menu_mod_date;
	
	private int fcs_no;
	private String fcs_location;
	private String fcs_phone;
	private String fcs_reg_date;
	private String fcs_mod_date;
	
	private int fcm_no;
	private String fcm_id;
	private String fcm_pw;
	private String fcm_name;
	private String fcm_phone;
	private String fcm_mail;
	private int fcm_approval;
	private String fcm_reg_date;
	private String fcm_mod_date;
	
	
}
