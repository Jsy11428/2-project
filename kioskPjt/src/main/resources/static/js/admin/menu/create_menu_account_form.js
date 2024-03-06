  	// 메뉴 카테고리 등록 버튼 유효성 검사
  	
  	function createMenuCategoryAccountForm() {
		  console.log('createMenuCategoryAccountForm()');
		  
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
<<<<<<< HEAD
 /*   let fm_fcmc_no = form.fcmc_no;
=======
>>>>>>> 6b5729418fad31567ae156035ba2cdd82a75d081
    
    if (form.fcmc_no.value === "") {
        alert('메뉴 카테고리 선택해주세요.');
        form.fcmc_no.focus();
        return false;
<<<<<<< HEAD
    }*/
    
=======
    }
>>>>>>> 6b5729418fad31567ae156035ba2cdd82a75d081
    // 메뉴 이름 검증
    else if (form.fc_menu_name.value === "") {	
        alert('메뉴의 이름을 입력해주세요.');
        form.fc_menu_name.focus();
        return false;
    }
    
    // 메뉴 가격 검증
    else if (form.fc_menu_price.value === "") {
        alert('메뉴의 가격을 입력해주세요.');
        form.fc_menu_price.focus();
        return false;
    }
    
    // 메뉴 설명 검증
    else if (form.fc_menu_text.value === "") {
		alert('메뉴의 설명을 입력해주세요.');
        form.fc_menu_text.focus();
        return false;
		
	}
    
    // 메뉴 이미지 검증
	else if (form.file.value === "") {
        alert('메뉴의 사진을 선택해주세요.');
        form.file.focus();
        return false;
    } else {
		
    	form.submit();
	}
     
}
   
        