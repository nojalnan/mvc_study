<%@ include file="/WEB-INF/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지입니다.</title>
</head>
<script>
function doLogin(){
	var data = {};
	data["userid"] = $("input[name=userid]").val();
	data["userpwd"] = $("input[name=userpwd]").val();
	//alert(JSON.stringify(data));
	//return;
	$.ajax({
		type :"POST"
	,	url : "/test/user/login"
	,	dataType :"json"
	,	beforeSend : function(xhr) {
		xhr.setRequestHeader("Accept", "application/json");
		xhr.setRequestheader("Content-Type", "application/json");
	}
	,	data : JSON.stringify(data)
	,	success : returnLogin
	/* 	
 
 	,	success :function(json) {
			var url = json.url;
			var data = json.data;
			var msg = json.msg;
	} 
	*/
	,
	error : function(shr, status, e){
		alert(e);
	 $('#result').html(e);
	},
	done : function(e) {
		alert("DONE");
	}
	});
}

function returnLogin(result){
	alert(result);
}

</script>
<body>
<div id="result"></div>
<table>
	<tr>
		<td>아이디1</td>
		<td><input type="text" name="userid"></td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td><input type="password" name="userpwd"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="button" value="로그인" onclick="doLogin()"></td>
	</tr>	
</table>
</body>
</html>