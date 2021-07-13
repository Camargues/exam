<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<script  type="text/javascript"  src="libs/jquery-1.9.1.min.js"> </script>
	<script>
	    $(function(){
	    	var param = { cate : 'kkk', name : 'ooo'};
	    	// json 구조 객체형식 변수
	    	$.ajax({
	    		type : 'get',
	    	url : '04_server.jsp',
	    	data : param,	// 서버로 보내는 data
	    	dataType : 'text', // 서버로부터 받는 dataType
	    	// 추후에 
	    	success : function(result){
	    		
	    		var obj = {};
	    		obj = eval(result);
	    		$('#cate').val(obj.first);
	    		$('#name').val(obj.second);
	    	}
	    	});	    	
	 	    	
	    })
	</script>
</head>

<body>
서버로부터 넘겨받은 데이터<br/>
첫번째 데이터 : <input type="text" name="" id="cate"/><br/>
두번째 데이터 : <input type="text" name="" id="name"/><br/>
</body>
</html>


