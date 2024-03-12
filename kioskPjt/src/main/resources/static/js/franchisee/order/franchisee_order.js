function orderListDeleteConfirm(fco_no) {
    let result = confirm("정말 삭제하시겠습니까?");
    if (result) {
        // 삭제할 주문 번호를 파라미터로 전달하여 요청            
        location.href = "/franchisee/order/orderListDeleteConfirm?fco_no=" + fco_no;        
    } 
}

// HTML 버튼 클릭 시 페이지 이동하는 함수
function checkLoginAndRedirect() {
    // 세션에서 로그인 여부 확인
    let isLogined = sessionStorage.getItem('loginedFranchiseeMemberDto');

    // 로그인 여부에 따라 리디렉션 처리
    if (isLogined === 'false') {

        alert('login please');
    }
}

function createOrderAccountForm() {
		console.log('createOrderAccountForm()');
	
}
