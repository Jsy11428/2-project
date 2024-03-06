function createAdminAccountForm() {
	console.log("createAdminAccountForm()");
	
	let form = document.create_admin_account_form;
	
	if (form.am_id.value === '') {
		alert('INPUT FRANCHISEE ID');
		form.am_id.focus();
		
	} else if (form.am_pw.value === '') {
		alert('INPUT FRANCHISEE PW');
		form.am_pw.focus();
		
	} else if (form.am_pw_again.value === '') {
		alert('INPUT FRANCHISEE PW AGAIN');
		form.am_pw_again.focus();
		
	} else if (form.am_pw_again.value !== form.am_pw.value) {
		alert('PASSWORDS DO NOT MATCH');
		form.am_pw.focus();
		
	} else if (form.am_name.value === '') {
		alert('INPUT FRANCHISEE NAME');
		form.am_name.focus();
		
	} else if (form.am_phone.value === '') {
		alert('INPUT FRANCHISEE PHONE');
		form.am_phone.focus();
		
	} else if (form.am_mail.value === '') {
		alert('INPUT FRANCHISEE MAIL');
		form.am_mail.focus();
		
	} else {
		form.submit();
		
	}
	
}

function AdminLoginForm() {
	console.log("AdminLoginForm()");
	
	let form = document.admin_login_form;
	
	if (form.am_id.value === '') {
		alert('INPUT FRANCHISEE ID');
		form.am_id.focus();
		
	} else if (form.am_pw.value === '') {
		alert('INPUT FRANCHISEE PW');
		form.am_pw.focus();
		
	} else {
		form.submit();
		
	}
	
	
}

function adminLogoutConfirm() {
	console.log("adminLogoutConfirm()");
	
	let result = confirm("로그아웃하시겠습니까?");
	
	if (result) {
		
		location.href = "/admin/member/adminLogoutConfirm";
		
	}
	
}


function AdminModifyForm() {
	console.log("AdminModifyForm()");
	
		let form = document.admin_modify_form;
	
	if (form.am_name.value === '') {
		alert('INPUT FRANCHISEE NAME');
		form.am_name.focus();
		
	} else if (form.am_phone.value === '') {
		alert('INPUT FRANCHISEE PHONE');
		form.am_phone.focus();
		
	} else if (form.am_mail.value === '') {
		alert('INPUT FRANCHISEE MAIL');
		form.am_mail.focus();
		
	} else {
		form.submit();
		
	}
	
}


function franchiseeApproveBtn(fcm_no) {
	console.log("franchiseeApproveBtn()");
	
	let result = confirm("승인하시겠습니까?");
	
	if (result) {
		
		location.href = "/admin/member/franchiseeApprove?fcm_no=" + fcm_no;
		
	}
	
}

function adminApproveBtn(am_no) {
	console.log("adminApproveBtn()");
	
	let result = confirm("승인하시겠습니까?");
	
	if (result) {
		
		location.href = "/admin/member/adminApprove?am_no=" + am_no;
		
	}
	
}
