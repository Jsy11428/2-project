function createFranchiseeAccountForm() {
	console.log("createFranchiseeAccountForm()");
	
	let form = document.create_franchisee_account_form;
	
	if (form.fcm_id.value === '') {
		alert('INPUT FRANCHISEE ID');
		form.fcm_id.focus();
		
	} else if (form.fcm_pw.value === '') {
		alert('INPUT FRANCHISEE PW');
		form.fcm_pw.focus();
		
	} else if (form.fcm_pw_again.value === '') {
		alert('INPUT FRANCHISEE PW AGAIN');
		form.fcm_pw_again.focus();
		
	} else if (form.fcm_pw_again.value !== form.fcm_pw.value) {
		alert('PASSWORDS DO NOT MATCH');
		form.fcm_pw.focus();
		
	} else if (form.fcm_name.value === '') {
		alert('INPUT FRANCHISEE NAME');
		form.fcm_name.focus();
		
	} else if (form.fcm_phone.value === '') {
		alert('INPUT FRANCHISEE PHONE');
		form.fcm_phone.focus();
		
	} else if (form.fcm_mail.value === '') {
		alert('INPUT FRANCHISEE MAIL');
		form.fcm_mail.focus();
		
	} else {
		form.submit();
		
	}
	
}

function franchiseeLoginForm() {
	console.log("franchiseeLoginForm()");
	
	let form = document.franchisee_login_form;
	
	if (form.fcm_id.value === '') {
		alert('INPUT FRANCHISEE ID');
		form.fcm_id.focus();
		
	} else if (form.fcm_pw.value === '') {
		alert('INPUT FRANCHISEE PW');
		form.fcm_pw.focus();
		
	} else {
		form.submit();
		
	}
	
	
}

function franchiseeLogoutConfirm() {
	console.log("franchiseeLogoutConfirm()");
	
	let result = confirm("로그아웃하시겠습니까?");
	
	if (result) {
		
		location.href = "/franchisee/member/franchiseeLogoutConfirm";
		
	}
	
}


function franchiseeModifyForm() {
	console.log("FranchiseeModifyForm()");
	
		let form = document.franchisee_modify_form;
	
	if (form.fcm_name.value === '') {
		alert('INPUT FRANCHISEE NAME');
		form.fcm_name.focus();
		
	} else if (form.fcm_phone.value === '') {
		alert('INPUT FRANCHISEE PHONE');
		form.fcm_phone.focus();
		
	} else if (form.fcm_mail.value === '') {
		alert('INPUT FRANCHISEE MAIL');
		form.fcm_mail.focus();
		
	} else {
		form.submit();
		
	}
	
}

function franchiseeFindPasswordForm() {
	console.log('franchiseeFindPasswordForm()');
	
		let form = document.franchisee_find_password_form;
	
	if (form.fcm_id.value === '') {
		alert('INPUT FRANCHISEE ID');
		form.fcm_id.focus();
		
	} else if (form.fcm_name.value === '') {
		alert('INPUT FRANCHISEE NAME');
		form.fcm_name.focus();
		
	} else if (form.fcm_phone.value === '') {
		alert('INPUT FRANCHISEE PHONE');
		form.fcm_phone.focus();
		
	} else if (form.fcm_mail.value === '') {
		alert('INPUT FRANCHISEE MAIL');
		form.fcm_mail.focus();
		
	} else {
		form.submit();
		
	}
	
}

function franchiseeFindPasswordConFirm() {
	console.log('franchiseeFindPasswordConFirm()');
	
	let form = document.franchisee_find_password_confirm_form;
	
	if (form.fcm_pw.value === '') {
		alert('INPUT FRANCHISEE PW');
		form.fcm_pw.focus();
		
	} else if (form.fcm_pw_again.value === '') {
		alert('INPUT FRANCHISEE PW AGAIN');
		form.fcm_pw_again.focus();
		
	} else if (form.fcm_pw_again.value !== form.fcm_pw.value) {
		alert('PASSWORDS DO NOT MATCH');
		form.fcm_pw.focus();
		
	} else {
		form.submit();
		
	}
	 
}
