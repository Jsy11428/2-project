function dineInOrder(fco_packaging){
	console.log('dineInOrder()');
	
	location.href = "/customer/order/customerOrderView?fco_packaging=" + fco_packaging;
	
};

function takeOutOrder(fco_packaging){
	console.log('takeOutOrder()');
	
	location.href = "/customer/order/customerOrderView?fco_packaging=" + fco_packaging;
	
};

$(document).ready(function(){
	$('ul.img_slide li').eq(3).animate({'opacity':'0'},3000,function loop(){
		$('ul.img_slide li').eq(2).animate({'opacity':'0'},3000,function(){
			$('ul.img_slide li').eq(1).animate({'opacity':'0'},3000,function(){
				$('ul.img_slide li').css('opacity','1');
				$('ul.img_slide li').eq(3).animate({'opacity':'0'},3000,loop);
			});
		});
	});
});


