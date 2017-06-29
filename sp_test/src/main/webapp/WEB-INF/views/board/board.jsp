<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function movePage(){
	location.href='http://localhost:8080/test/main';
}
</script>
<body>
<p>게시판 화면입니다.</p>

<input type="button" value="홈으로" onclick="movePage()"/>
</body>
</html>