$(document).ready(function() {
	
	init();
		
});

function init(){
	
	$('#section_wrap .login_form input[name="fcs_name"]').click(function(){
		console.log('오픈지점 click')
		
		let fcm_id = $('#section_wrap .login_form input[name="fcm_id"]').val();
		
		ajax_selectStoreByFcmId(fcm_id);

		$('#section_wrap .store_list').show();
		
	})


}

function franchiseeStoreLogin() {
	console.log('franchiseeStoreLogin()');

	let form = document.franchisee_store_login_form;

	if(form.fcm_id.value === '') {
		alert("PLEASE INPUT FRANCHISEE ID");
		form.fcm_id.focus();

	} else if(form.fcm_pw.value === '') {
		alert("PLEASE INPUT FRANCHISEE ID");
		form.fcm_pw.focus();

	} else if(form.fcs_no.value === '') {
		alert('오픈지점을 선택하세요.')
				
	} else {
		form.submit();

	}

}

function ajax_selectStoreByFcmId(fcm_id){

	$.ajax({
		url: '/customer/order/getStoreList',
		method: 'post',
		data: { 'fcm_id' : fcm_id },
		dataType: 'json',
		success: function(data){
			console.log('ajax success!')
			
			let list = data.storeListByFcmId;
			let appendTag = '';
			
			if(list.length === 0) {

				appendTag = '<tr>';
					appendTag += '<td colspan="4">ID를 확인하세요.</td>'
				appendTag += '</tr>'

				$('#section_wrap .store_list table tbody').append(appendTag);

			} else {

				for (let i = 0; i < list.length; i++) {
					
					appendTag = '<tr>';
	
						appendTag += '<td>' + list[i].fcs_name + '</td>';
						appendTag += '<td>' + list[i].fcs_location + '</td>';
						appendTag += '<td>' + list[i].fcs_phone + '</td>';
						appendTag += '<td><input type="button" fcs_name="'+list[i].fcs_name+'" fcs_no="'+list[i].fcs_no+'" value="선택"></td>';
	
					appendTag += '</tr>'
					
					$('#section_wrap .store_list table tbody').append(appendTag);
	
				}

			}

		},
		error: function(data){
			console.log('ajax error!')

		},
		complete: function(){

			$('#section_wrap .store_list table tbody input[value="선택"]').click(function(){
				console.log('fcs_no btn 선택');

				let fcs_no = $(this).attr("fcs_no");
				
				let fcs_name = $(this).attr("fcs_name");
				
				$('#section_wrap .login_form input[name="fcs_no"]').val(fcs_no);
				
				$('#section_wrap .login_form span.fcs_name').text(fcs_name);

				$('#section_wrap .store_list table tbody').empty();

				$('#section_wrap .store_list').hide();

			})

			$('#section_wrap .store_list table thead input[value="close"]').click(function(){
				console.log('close btn click!');

				$('#section_wrap .store_list table tbody').empty();

				$('#section_wrap .store_list').hide();

			})

		}
	})

}

