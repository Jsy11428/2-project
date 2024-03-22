function orderListCompleteConfirm(fco_ori_no) {
    let result = confirm("정말 완료하시겠습니까?");
    if (result) {
        // 주문 완료
        location.href = "/franchisee/order/orderListCompleteConfirm?fco_ori_no=" + fco_ori_no;        
    } 
}

