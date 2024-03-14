package com.office.kiosk.franchisee.member;

import lombok.Data;

@Data
public class FranchiseeMemberDto {

	private int fcm_no;
	private String fcm_id;
	private String fcm_pw;
	private String fcm_name;
	private String fcm_phone;
	private String fcm_mail;
	private int fcm_approval;
	private String fcm_reg_date;
	private String fcm_mod_date;
	
	private int fcs_no;

}
