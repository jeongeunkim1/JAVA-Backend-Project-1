$("#card_no").keydown(function(e){
	var card_text="";
	
	if(e.keyCode!=8){
		switch($("#card_no").val().length){
			case 4:
				card_text=$("#card_no").val();
				card_text+='-';
				$("#card_no").val(card_text);
				break;
			case 9:
				card_text=$("#card_no").val();
				card_text+='-';
				$("#card_no").val(card_text);
				break;
			case 14:
				card_text=$("#card_no").val();
				card_text+='-';
				$("#card_no").val(card_text);
				break;		
		}
	}

});

$("#card_insert_btn").click(function(){
	var regex=/^[0-9]*$/;
	
	if($("#card_no").val()==''){
		alert("카드 번호를 입력해주세요.");
	}
	
	if($("#card_no").val()!=''){
		for(var i=0; i<$("#card_no").length; i++){
			if($("#card_no").val()[i]!='-'){
				if(!regex.test($("#card_no").val()[i])){
					alert("카드번호는 숫자만 입력가능합니다.");
				}
			}
		}
	}
	
	if(!regex.test($("#card_cvc").val()) || $("#card_cvc").val()==''){
		alert("CVC를 입력해주세요.");
	}
	
	if(!regex.test($("#card_month").val()) || $("#card_month").val()==''){
		alert("유효기간 월을 제대로 입력하시오.");
	}
	
	if(!regex.test($("#card_year").val()) || $("#card_year").val()==''){
		alert("유효기간 년도를 제대로 입력하시오.");
	}
	
	if(!regex.test($("#card_password").val()) || $("#card_password").val()==''){
		alert("카드 비밀번호 앞2자리를 입력해주세요.");
	}
	
	if(!regex.test($("#card_password2").val()) || $("#card_password2").val()==''){
		alert("2차 비밀번호를 입력해주세요.");
	}
	
	
	else{
		$("#card_insert").submit();
	}
	
});