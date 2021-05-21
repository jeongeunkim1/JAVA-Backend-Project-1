$(document).on('click',function(e){
	var k='#qty'+e.target.getAttribute('value');	
	var count=0;
	
	if(e.target.id=="minus-btn"){	
		count=cart_qty_ajax(0,e.target.getAttribute('value'));
		if(count==1){
			$(k).val(count);								
		}else{
			count=cart_qty_ajax(-1,e.target.getAttribute('value'));	
			$(k).val(count);			
		}
		
	}else if(e.target.id=="plus-btn"){
		
		var k='#qty'+e.target.getAttribute('value');
		$(k).val(cart_qty_ajax(1,e.target.getAttribute('value')));	
		
	}
	
	if(e.target.id=="cart_page_delete_btn"){
		$("#cart_del_no").val(e.target.getAttribute('name'));
		$("#delete_cart_form").submit();
	}
	
});

function cart_qty_ajax(qty,cart_no){
	var result="";
	$.ajax({
		url:'cart_add_item_json',
		method:'get',
		data : {'qty':qty,'cart_no':cart_no},
		dataType : "json",
		async: false,
		success : function(jsonArray) {
			result = jsonArray.cart_quantity;
		}		
	});
	return result;
}