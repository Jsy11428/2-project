package com.office.kiosk.admin.member;

import lombok.Data;

@Data
public class AdminMemberDto {

	private int am_no;
	private String am_name;
	private String am_id;
	private String am_pw;
	private String am_phone;
	private String am_mail;
	private int am_approval;
	private String am_reg_date;
	private String am_mod_date;


	
}
