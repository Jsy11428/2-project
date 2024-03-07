package com.office.kiosk.franchisee.sales;

import lombok.Data;

@Data
public class FranchiseeSalesDto {

	private int fcsa_no;		
	private int fcsa_price;
	private String fcsa_reg_date;
	private String fcsa_mod_date;
	
	private int pm_mo;
    private String pm_type;
	
	private int fco_no;	
	private int fco_ori_no;
	private int fco_menu_cnt;
	private String fco_reg_date;
	private String fco_mod_date;
	
	private int fc_menu_no;
	private String fc_menu_name;
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
	
	private int fcs_no;
	private String fcs_name;
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
	
	private int cash_total_price;
	private int card_total_price;
	
}

