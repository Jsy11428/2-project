function orderListCompleteConfirm(fco_ori_no) {
    let result = confirm("정말 완료하시겠습니까?");
    if (result) {
        // 주문 완료
        location.href = "/franchisee/order/orderListCompleteConfirm?fco_ori_no=" + fco_ori_no;        
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

