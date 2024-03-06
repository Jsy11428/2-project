package com.office.kiosk.franchisee;

import lombok.Data;

@Data
public class FranchiseeStoreDto {

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
	
}
