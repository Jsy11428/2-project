function franchiseeStoreLoginForm(){
	console.log('franchiseeStoreLoginForm()');
	
	let form = document.franchisee_store_login_form;
	
	if (form.fcm_id.value === '') {
		alert('PLEASE INPUT FRANCHISEE ID');
		form.fcm_id.focus();
		
	} else if (form.fcm_pw.value === '') {
		alert('PLEASE INPUT FRANCHISEE PW');
		form.fcm_pw.focus();
		
	} else {
		form.submit();
		
	}
	
}