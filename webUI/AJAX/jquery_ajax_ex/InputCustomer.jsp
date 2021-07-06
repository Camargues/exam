<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 고객관리 프로그램 </title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" >
$(function(){
	$("#btnInsert").click(function(){
		var param = {name:$('#name').val(),
				age:$('#age').val(),
				tel:$('#tel').val(),
				addr:$('#addr').val()}
		
		$.ajax({
			type:'post',
			data: param,
			url : 'DataInput.jsp',
			dataType : 'text',
			success : function(result){
				if(result.trim() == '1'){alert('입력성공');}
			$('#name').val("");
				$('#age').val("");
				$('#tel').val("");
				$('#addr').val("");
			}
		});
	});
	
	$("#btnSelect").click(function(){
		$.ajax({
			type : 'get',
			url : 'DataSelect.jsp',
			dataType : 'text',
			success : parseData
		});
		function parseData(data){
			// $('선택자', 대상)
			// 해당 대상에서 선택자를 찾고자 할때 사용
			var person = $('person',data);
			/* alert(person.length); */
			$('#tbd').empty();
			person.each(function(){
				var name = $('name',this).text();
				var age = $('age',this).text();
				var tel = $('tel',this).text();
				var addr = $('addr',this).text();
				$('#tbd').append('<tr>');
				$('#tbd').append('<td>' + name + '</td>');
				$('#tbd').append('<td>' + age + '</td>');
				$('#tbd').append('<td>' + tel + '</td>');
				$('#tbd').append('<td>' + addr + '</td>');
				$('#tbd').append('</tr>');
			})			
		}
	});	
})
</script>

</head>


<!-- <body> -->
<body>

<h2> 고객정보 입력 </h2>

<form name="inForm" method="post">
<table border = 1>
	<tr>
		<td width="80" align="center">Name</td>
		<td width="50" align="center">Age</td>
		<td width="100" align="center">Tel</td>	
		<td width="250" align="center">Addr</td>
	</tr>
	<tr>
		<td align="center"><input type="text" size="8" name="name" id="name"></td>
		<td align="center"><input type="text" size="4" name="age" id="age"></td>
		<td align="center"><input type="text" size="12" name="tel" id="tel"></td>
		<td align="center"><input type="text" size="30" name="addr" id="addr"></td>
	</tr>
	<tr>
		<td colspan="4" align="center"> 
			<input type="button" id='btnInsert' value="입력">
		</td>
	</tr>
</table>

<br>
<hr>

<h2> 고객정보 목록보기  </h2>
<table border='0' width="510"> 
	<tr>
		<td align="right"><input type="button"  id='btnSelect' value="가져오기"></td>
	</tr>
</table>
<table border = 1 id="listTable">
	<tr>
		<td width="80" align="center">Name</td>
		<td width="50" align="center">Age</td>
		<td width="100" align="center">Tel</td>	
		<td width="250" align="center">Addr</td>
	</tr>
	<tbody id='tbd'></tbody>
</table>
<div id="myDiv"> </div>

</form>
</body>
</html>