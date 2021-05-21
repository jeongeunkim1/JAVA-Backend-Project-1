function searchProduct() {
		document.searchFRN.method='GET';
		document.searchFRN.action='product_search';
		document.searchFRN.submit();
}

$("#search").keydown(function(e){
	if(e.keyCode == 13){
		 searchProduct();
		 e.preventDefault();
	}
});
 