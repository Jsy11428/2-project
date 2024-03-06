  	// 메뉴 카테고리 등록 버튼 유효성 검사
  	
  	function createMenuCategoryAccountForm() {
		  console.log('createMenuCategoryAccountForm');
		  
		  let form = document.create_menu_category_account_form;
		  
		  if (form.fcmc_name.value === "") {
			  alert('카테고리의 이름을 입력해주세요');
			  form.fcmc_name.focus();
		  } else {
			  form.submit();
		  }
		  
	  }
  	
  	
  	// 메뉴 등록 버튼 유효성 검사
  	
  	function createMenuAccountForm() {
    console.log('createMenuAccountForm()');
    
    let form = document.create_menu_account_form;
 /*   let fm_fcmc_no = form.fcmc_no;
    
    
    let isChecked_fcmc_no = false;
    
    // 대분류 라디오 버튼 검증
    for (let i = 0; i < fm_fcmc_no.length; i++) {
        if (fm_fcmc_no[i].checked) {
            isChecked_fcmc_no = true;
            break;
        }
    }
    
    // 대분류 검증
    if (!isChecked_fcmc_no) {
        alert('대분류를 선택해주세요.');
        fm_fcmc_no[0].focus();
        return false;
    }*/
    
    // 메뉴 이름 검증
    if (form.fc_menu_name.value === "") {
        alert('메뉴의 이름을 입력해주세요.');
        form.fc_menu_name.focus();
        return false;
    }
    
    // 메뉴 설명 검증
    if (form.fc_menu_text.value === "") {
		alert('메뉴의 설명을 입력해주세요.');
        form.fc_menu_text.focus();
        return false;
		
	}
    
    // 메뉴 가격 검증
    if (form.fc_menu_price.value === "") {
        alert('메뉴의 가격을 입력해주세요.');
        form.fc_menu_price.focus();
        return false;
    }
    
    // 메뉴 이미지 검증
    if (form.fc_menu_img_name.value === "") {
        alert('메뉴의 사진을 선택해주세요.');
        form.fc_menu_img_name.focus();
        return false;
    }
    
    form.submit();
}
   
        