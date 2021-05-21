$(document).ready(function(){
	if($("#user_session").val()!=null){
		head_cart_ajax();		
	}
});

$(document).on('click',function(e){
	if(e.target.id=="cart_delete_btn"){
		delete_cart_ajax(e.target.getAttribute('name'));
	}
	
});

function searchProduct() {
		document.searchFRN.method='GET';
		document.searchFRN.action='product_search';
		document.searchFRN.submit();
	}

function head_cart_ajax(){
	var html="";
	var count=0;
	var total=0;
		$.ajax({
				url : "main_cart_ajax",
				async : false,
				method : "POST",
				dataType: "json",
				success: function(map) {
					var cartList=map.cartList;
					var productList=map.productList;
					var str=""; 
					$.each(cartList, function(i) {
						count++;
						total+=productList[i].product_price;
						str+=
								'<div class="tt-item" id="cart_item'+cartList[i].cart_no+'">'
									+'<a href="product_info?product_no='+productList[i].product_no+'&type='+productList[i].product_category+'">'
									+ 	'<div class="tt-item-img">'
									+ 		"<img src='images/productImage/"+productList[i].product_image+"' data-src='images/productImage/"+productList[i].product_image+"' alt=''>"
									+ 	'</div>'
									+	'<div class="tt-item-descriptions">'
									+ 		'<h2 class="tt-title">'+productList[i].product_name+'</h2>'
									+ 		'<ul class="tt-add-info">'
									+			'<li>'+productList[i].product_category+'</li>'
									+ 		'</ul>'
									+	'<div id="tt-quantity" class="tt-price">'+cartList[i].cart_quantity+' X</div> <div class="tt-price" id="cart_price'+cartList[i].cart_no+'">'+productList[i].product_price+'</div>'
									+   '<input type="hidden" id="cart_no"'+cartList[i].cart_no+' value="'+cartList[i].cart_no+'">'
									+	'</div>'
									+'</a>'
									+'<div class="tt-item-close">'
									+	'<a href="#" class="tt-btn-close" id="cart_delete_btn" name="'+cartList[i].cart_no+'"></a>'
									+'</div>'
								+'</div>';
					});
					
					//카트 아이템 시작
					html+="<button class='tt-dropdown-toggle'>"+
						  "<i class='icon-f-39'></i>"+
						  "<span class='tt-badge-cart' id='cartCount'>"+count+"</span>"+
					"</button>"+
					"<div class='tt-dropdown-menu'>"+
					"<div class='tt-mobile-add'>"+
					"<h6 class='tt-title'>SHOPPING CART</h6>"+
					"<button class='tt-close'>Close</button>"+
							"</div>"+
								"<div class='tt-dropdown-inner'>"+
									"<div class='tt-cart-layout'>"+
										"<div class='tt-cart-content'>"+
											"<div class='tt-cart-list'>";	
					
					//카트 메뉴들 
					html+=str;		
											
					//카트 아이템 끝
					html+="</div>";
						html+="<div class='tt-cart-total-row'>"+
									"<div class='tt-cart-total-title'>총 가격</div>"+
									"<div id='tt-cart-total-price' class='tt-cart-total-price'>"+total+"</div>"+
							   "</div>"+
							   "<div class='tt-cart-btn'>"+
							   		"<div class='tt-item'>"+
									   		"<a href='cart_page' class='btn-link-02 tt-hidden-mobile'>장바구니 이동</a>"+
											"<a href='cart_page' class='btn btn-border tt-hidden-desctope'>장바구니 이동</a>"+
							   		"</div>"+
							   "</div>"+
						"</div>"+
				    "</div>"+
				"</div>"+
			"</div>";
					
					$("#header_cart_menu").html(html);
				}
			});
}

function delete_cart_ajax(cart_no){
	$.ajax({
				url : "delete_cart_ajax",
				data : {'cart_no':cart_no},
				async : false,
				method : "POST",
				dataType: "text",
				success: function(result) {
					var cart_item="#cart_item"+cart_no;
					var cart_price="#cart_price"+cart_no;
					var total_price=$("#tt-cart-total-price").text();
					cart_price=$(cart_price).text();
					
					$("#tt-cart-total-price").text(total_price-cart_price);
					
					$("div").remove(cart_item);
					$("#cartCount").text(result);
				}
	});
}