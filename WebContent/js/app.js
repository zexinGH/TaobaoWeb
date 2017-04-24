$(function(){
	
	$('.editshow').hide();
	
	$("#bd_centent .btn").click(function(){
		window.location.href = "shanpingye.html";
	});
	
	$("#allCheckBox").click(function(){
		var isChecked = $(this).is(":checked");
		$("#shopcar input[class='mybox']").prop('checked', isChecked);
		calFee();
	});

	$('.mybox').click(function(){
		calFee();
	});
	
	$('.shopcar .btn').click(function(){
		$(this).parent().parent().remove();
		calFee();
	});
	
	$('#editShop').click(function(){
		var status =  $('#editShop').html();
		if (status == '编辑'){
			$('.commshow').hide();
			$('.editshow').show();
			$('#editShop').html('完成');
		}
		else{
			$('.editshow').hide();
			$('.commshow').show();
			$('#editShop').html('编辑');
		}
	});
	
	$('.sy_plus').click(function(){
		var $sy_num = $(this).prev();
		var num = $sy_num.attr('value');
		$sy_num.attr('value',++num);
		$(this).parent().parent().parent().parent().find('.pay .goodscount').html('x'+num);
//		$(this).parent().parent().parent().parent().css('border','1px solid red');
//		$(this).parent().parent().parent().parent().find('.pay .goodscount').css('border','1px solid green');
		calFee();
	});
	//数量减少事件
	$('.sy_minus').click(function(){
		var $sy_num = $(this).next();
		var num = $sy_num.attr('value');
		if (num > 1){
			$sy_num.attr('value',--num);
			$(this).parent().parent().parent().parent().find('.pay .goodscount').html('x'+num);
			calFee();
		}else{
			alert('受不了了，宝贝不能再减少里哦');
		}
	});
	//删除事件
	$('.delbtn').click(function(){
		$(this).parent().parent().remove();
		calFee();
	});
	
	function calFee(){
		var totalCost = 0;
		var arrChk= $("#shopcar input[class='mybox']");
		var arrPay = $(".shopcar .pay span");
		for (var k = 0; k < arrChk.length; ++k){
			if (arrChk[k].checked){
				var nums = parseInt(arrPay[2+k*3].innerHTML.replace(/[^0-9]/ig, "")); 
				totalCost += parseFloat(arrPay[1+k*3].innerHTML) * nums;
			}
		}
		$('.shopcar_bottom .total span').html(totalCost);
	};	
	
})



