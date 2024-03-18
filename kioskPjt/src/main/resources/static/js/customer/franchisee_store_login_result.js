<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

function dineInOrder(fco_packaging){
	console.log('dineInOrder()');
	
	location.href = "/franchisee/member/customerOrderView?fco_packaging=" + fco_packaging;
	
};

function takeOutOrder(fco_packaging){
	console.log('takeOutOrder()');
	
	location.href = "/franchisee/member/customerOrderView?fco_packaging=" + fco_packaging;
	
};


