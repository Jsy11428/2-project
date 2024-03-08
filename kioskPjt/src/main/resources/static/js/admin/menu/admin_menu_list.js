// 메뉴 등록 버튼 유효성 검사
  	
  	function modifyMenuAccountConfirm() {
    console.log('modifyMenuAccountConfirm()');
    
    let form = document.modify_menu_account_form;
    
    let result = confirm("정말 수정 하시겠습니까?");
        if (result) {
    
    if (form.fcmc_no.value === "") {
        alert('메뉴의 카테고리를 선택해주세요.');
        form.fcmc_no.focus();

    }
    
    // 메뉴 이름 검증
    else if (form.fc_menu_name.value === "") {	
        alert('메뉴의 이름을 입력해주세요.');
        form.fc_menu_name.focus();
        
    }
    
    // 메뉴 가격 검증
    else if (form.fc_menu_price.value === "") {
        alert('메뉴의 가격을 입력해주세요.');
        form.fc_menu_price.focus();
        
    }
    
    // 메뉴 설명 검증
    else if (form.fc_menu_text.value === "") {
		alert('메뉴의 설명을 입력해주세요.');
        form.fc_menu_text.focus();
		
	}
    
    
     else {
    	form.submit();
    	console.log('메뉴 수정이 완료되었습니다.');
    	
	}
	}
	
	}
	
	

	
	
	
	
    function deleteMenuConfirm() {
        // fc_menu_no 값을 가져옵니다.
        let fc_menu_no = document.getElementsByName("fc_menu_no")[0].value;
        
        // 가져온 fc_menu_no 값을 deleteMenuConfirm 함수의 매개변수로 전달합니다.
        let result = confirm("정말 삭제 하시겠습니까?");
        if (result) {
            location.href = `admin/menu/deleteMenuConfirm?fc_menu_no=${fc_menu_no}`;
        }
    }
    
    
    