/*상품의 정보를 담는 배열*/
var productArray=[];
/*페이징에 대한 정보를 담는 배열 */
var pageArray=[];
/*태그에 대한 정보를 담는 변수*/
var html = "";
/*현재 페이지에 대한 정보를 가지고 있는 변수 */
var currentPage=1;

/*Ajax로 출력한 동적 태그들을 사용하기 위한 함수 */
$(document).on('click', '#ul_pagelist', function(e){
	if(e.target.text!=null && e.target.text.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')){
		currentPage=e.target.text;
	}
	
	if(e.target.id=='first'){
		
			$('#proudcts_list').html(productArray[0]+pageArray[0]);
			currentPage=1;
			
	}else if(e.target.id=='last'){
		
			$('#proudcts_list').html(productArray[productArray.length-1]+pageArray[pageArray.length-1]);
			currentPage=productArray.length-1;	
			
	}else if(e.target.id=='prev'){
		
		currentPage--;
		if(currentPage==0){
			currentPage=1;
		}
		$('#proudcts_list').html(productArray[currentPage-1]+pageArray[(Math.ceil(currentPage/5)-1)]);
		
	}else if(e.target.id=='next'){
		
		currentPage++;
		console.log(currentPage);
		if(currentPage==productArray.length+1){
			currentPage=productArray.length;
		}
		$('#proudcts_list').html(productArray[currentPage-1]+pageArray[(Math.ceil(currentPage/5)-1)]);
		
	}else{
		
		$('#proudcts_list').html(productArray[currentPage-1]+pageArray[(Math.ceil(currentPage/5)-1)]);
		
	}
});

/*정렬 기능 */
function ajax_json(){
	$.ajax({
				url : 'product_list_json',
				method : 'GET',
				data : {'type':type,'state':state},
				dataType : "json",
				success : function(jsonArray) {
					/*페이지 초기화 */
					currentPage=1;
					/*요청에 따라 각각에 맞는 정렬 출력 
						0:가격이 낮은순
						1:가격이 높은순
						2:이름 오름차순
						3:이름 내림차순
					 */
					html = "";	
					productArray=[];									
					var count=0;
					switch(state){
						case 0:
							state=1;
							break;
						case 1:
							state=0;
							break;
						case 2:
							state=3;
							break;
						case 3:
							state=2;
							break;
					}
					
					$.each(jsonArray,function(i,product) {	
						/*1페이지당 9개의 상품을 담기 위해 if문을 걸어둠 */											
						if(count<9){	
						html += "<div class='col-6 col-md-4 tt-col-item'>"+
							"<div class='tt- thumbprod-center'>"+
							"<div class='tt-image-box'>"+
							"<a href='#' class='tt-btn-quickview' data-toggle='modal' data-target='#ModalquickView'	data-tooltip='Quick View' data-tposition='left'></a>"+
							"<a href='#' class='tt-btn-wishlist' data-tooltip='Add to Wishlist' data-tposition='left'></a>"+
							"<a href='#' class='tt-btn-compare' data-tooltip='Add to Compare' data-tposition='left'></a>"+
							"<a href=product_info?product_no="+product.product_no+"&type="+product.product_category+">"+
								"<span class='tt-img'><img src='images/productImage/"+product.product_image+"' height='250' width='200'></span>"+
							"</a>"+
						"</div>"+
						"<div class='tt-description' >"+
							"<div class='tt-row'>"+					 
								"<div class='tt-rating'>"+
									"<i class='icon-star'></i>"+
									"<i class='icon-star'></i>"+
									"<i class='icon-star'></i>"+
									"<i class='icon-star-half'></i>"+
									"<i class='icon-star-empty'></i>"+
								"</div>"+
							"</div>"+
							"<h2 style='font-size: 10px' class='tt-title'><a href='.html'>"+product.product_name+"</a></h2>"+
							"<div class='tt-price'>"+product.product_price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+
							"</div>"+
							"<div class='tt--inside-hover'>"+
					"<div class='tt-row-btn'>"+
					"<a href=@{product_info?product_no="+product.product_no+" class='tt-btn-addtocart thumbprod-button-bg' data-toggle='modal' data-target='#modalAddToCart'>ADD TO CART</a>"+
					"</div>"+
					"<div class='tt-row-btn'>"+
						"<a href='#' class='tt-btn-quickview' data-toggle='modal' data-target='#ModalquickView'></a>"+
						"<a href='#' class='tt-btn-wishlist'></a>"+
						"<a href='#' class='tt-btn-compare'></a>"+
					"</div>"+
				"</div>"+
						"</div>"+
							"</div>"+
					"</div>";
					count++;					
					}
					
					/*상품이 9개가 담기면 상품배열에 추가 및 카운터와 변수 초기화 */
					if(count==9){
						productArray.push(html);
						count=0;
						html="";
					}
					
					/*위 if문에 해당이 안되어 남은 데이터들을 담기 위한 조건문 */
					if(jsonArray.length==(i+1)){
						if(count!=0){
							productArray.push(html);
							html="";
						}
					}
					
				  });
				  	page_fuction();
					$('#proudcts_list').html(productArray[0]+pageArray[0]);
				}
			});	
}

function page_fuction(){
	var count=1;
		for(var i=1; i<=productArray.length; i++){
			
			if(count==1){
				/*배열의 크기에 맞게 페이지 수를 만듬 */
					html="<div class='container'>"+
					"<div class='row'>"+
					"<div class='col'>"+
					"<ul class='pagination justify-content-center' id='ul_pagelist'>"+
					"<li class='page-item'><a class='page-link' href='#' id='first'><<</a></li>"+
					"<li class='page-item'><a class='page-link' href='#' id='prev'><</a></li>";
				}
							
			html+="<li class='page-item'><a class='page-link' href='#'>"+i+"</a></li>";	
									
			if(count==5){
				html+="<li class='page-item'><a class='page-link' href='#' id='next'>></a></li>"+
				"<li class='page-item'><a class='page-link' href='#' id='last'>>></a></li>"+
				"</ul>"+
				"</div>"+
				"</div>"+
				"</div>";
				pageArray.push(html);
				html="";
				count=0;
			}

			if((i)==productArray.length){
					html+="<li class='page-item'><a class='page-link' href='#' id='next'>></a></li>"+
					"<li class='page-item'><a class='page-link' href='#' id='last'>>></a></li>"+
					"</ul>"+
					"</div>"+
					"</div>"+
					"</div>";
					pageArray.push(html);
					html="";
			}
			count++;
		}			
}

$("#price_order").click(function(){
	if(state!=0 && state!=1){
		state=0;
	}
	ajax_json();
});

$("#name_order").click(function(){
	if(state!=2 && state!=3){
		state=2;
	}
	ajax_json();
});