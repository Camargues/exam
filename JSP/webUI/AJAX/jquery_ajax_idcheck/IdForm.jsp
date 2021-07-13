<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 아이디 중복 검사 </title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	// $("#id_check").click(function(){
		// #id_check 버튼 눌렀을때 실행
	$('.userinput').keyup(function(){
		// .userinput에 키를 누를때마다 id 중복 체크
		$.ajax({
			type : 'get',	// get 방식
			data : {id : $('.userinput').val()},	// id란 이름에 .userinput에 입력한 value값 넘기기
			url : 'IdCheck.jsp',
			dataType : 'text',
			success : function(data){
				if(data.trim() == 'YES'){
				// 공백을 제거하는 trim() 함수
				// 통신으로 데이터를 주고 받을때 공백을 반드시 제거해야함
				$('#idmessage').show();
				$('#idmessage').text('이미 사용중인 아이디입니다')
				}else{
					$('#idmessage').show();
					$('#idmessage').text('사용 가능한 아이디입니다')
				}
			}
		})
	})
})
		
</script>

</head>
<body>

<input name="id" type="text" class="userinput" size="15" />
<button type="button" id="id_check">중복체크</button><br/><br/>
<div id="idmessage" style="display:none;"></div>

</body>
</html>