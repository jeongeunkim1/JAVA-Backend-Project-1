var email_check_state=0;

 function findAddress() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                    document.getElementById("inputStreetOrLot").value = addr;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                    document.getElementById("inputStreetOrLot").value = addr;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("inputStreetOrLot").value += extraAddr;
                    }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('inputZCode').value = data.zonecode;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("inputInfo").focus();
            }
        }).open({
        	autoClose: true
        });
}

$(function() {	
var email_check_state=0;

    	//아이디 정규식
    	var idJ = /^[a-z0-9]{4,12}$/;
    	// 비밀번호 정규식
    	var pwJ = /^[A-Za-z0-9]{4,12}$/; 
    	// 이름 정규식
    	var nameJ = /^[가-힣]{2,6}$/;
    	// 이메일 검사 정규식
    	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    	
    	//이름 체크
    	$('#inputName').keyup(function(e) {
    		if ($('#inputName').val()=='') {
    			$('#name_check').text('');
			}
    		if (nameJ.test($('#inputName').val())) {
				$('#name_check').text('');
			}else {
				$('#name_check').text("유효하지 않은 이름입니다.");
				$('#name_check').css('color', 'red');
			}
    	});
    	//아이디 체크
    	$('#inputId').keyup(function(e) {
    		var inputed_id=$('#inputId').val();
    		$.ajax({
    			url : "create_account_ajax_id",
    			method : "POST",
    			data: {
    				inputedId : inputed_id
    			},
    			async: false,
    			dataType: "json",
    			success: function(map) {
    				if (idJ.test($('#inputId').val())) {
   						if (map.count==1) {
   							$('#id_check').text('중복된 아이디입니다.');
   							$('#id_check').css('color', 'red');
   						}else if (map.count==0) {
    						$('#id_check').text('사용 가능한 아이디입니다.');
							$('#id_check').css('color', 'blue');
						}
    				}else {
    					$('#id_check').text("아이디는 알파벳과 영어로 시작하고 4~12자리 입니다.");
    					$('#id_check').css('color', 'red');
    				}		
				}
    		});
		});

    	//이메일 체크
    	$('#inputEmail').keyup(function(e) {
    		var inputed_email=$('#inputEmail').val();
    		$.ajax({
    			url : "create_account_ajax_email",
    			method : "POST",
    			data: {
    				inputedEmail : inputed_email
    			},
    			async: false,
    			dataType: "json",
    			success: function(map) {
    				if (mailJ.test($('#inputEmail').val())) {
   						if (map.count==1) {
   							$('#email_check').text('중복된 이메일입니다.');
   							$('#email_check').css('color', 'red');
   						}else if (map.count==0) {
    						$('#email_check').text('사용 가능한 이메일입니다.');
							$('#email_check').css('color', 'blue');
						}
    				}else {
    					$('#email_check').text("유효하지 않은 이메일입니다.");
    					$('#email_check').css('color', 'red');
    				}
				}
    		});
    	});
    	//비밀번호 체크
    	$('#inputPassword').keyup(function(e) {
    		if (pwJ.test($('#inputPassword').val())) {
				$('#pw_check').text('');
			}else {
				$('#pw_check').text("비밀번호는 4 ~ 12 자리입니다.");
				$('#pw_check').css('color', 'red');
			}
    	});
    	//비밀번호 확인 체크
    	$('#inputRePassword').keyup(function(e) {
    		if ($('#inputPassword').val()==$('#inputRePassword').val()) {
				$('#pw2_check').text("비밀번호가 일치합니다.");
				$('#pw2_check').css('color', 'blue');
			}
    		if ($('#inputPassword').val()!=$('#inputRePassword').val()) {
				$('#pw2_check').text("비밀번호가 일치하지않습니다.");
				$('#pw2_check').css('color', 'red');
			}
    	});
	
	  //이메일 인증
	  $('#send_check_email_btn').click(function(){
			var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			var clientEmail = $("#inputEmail").val();
				
			if(regExp.test(clientEmail)==true){
			
			$.ajax({
				url:"out_check_number",
				type:"POST",
				data:{'user_email':clientEmail},
				success : function(data){
					alert("입력하신 메일로 발송되었습니다.");
				},error:function(e){
					alert("전송 실패");
				}
			});
		   }else{
			 alert("이메일 형식이 아닙니다");
		   }
	  });
	  $("#check_email_btn").click(function(){
		   var clientEmail = $("#inputEmail").val();
		   var checkcode = $("#check_email_text").val();
		   $.ajax({
				url:"get_check_number",
				type:"POST",
				data:{'user_email':clientEmail,'check_code':checkcode},
				success : function(data){
					alert("인증 성공 :"+data);
					email_check_state=1;
					$("#create_account_submit_button").prop("disabled", false);
				},error:function(e){
					alert("인증 실패");
				}
			});
	  });
	  		 		
		 	 $("#create_account_submit_button").click(function(){
				console.log(email_check_state);
				if(email_check_state==1){	
			  		$("#create_account_form").submit();		
			  	}	
		 	 });		
});
    