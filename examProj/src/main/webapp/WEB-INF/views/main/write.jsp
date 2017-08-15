<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>글쓰기</title>
	<script type="text/javascript" src="/resources/js/jquery/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/resources/js/main/insert.js"></script>
</head>
<body>
<form name="frm" action="/main/insert.do" method="post">
<table>
<tr>
	<th>제목</th>
	<td><input type="text" name="title" id="title" value="${item.title}" /></td>
</tr>
<tr>
	<th>내용</th>
	<td><input type="text" name="content" id="content" value="${item.content}" /></td>
</tr>
<tr>
	<th>작성자</th>
	<td><input type="text" name="writer" id="writer" value="${item.writer}" /></td>
</tr>
<tr>
	<td><a href="javascript:insertCheck();">작성완료</a></td>
</tr>
</table>
</form>

<a href="/main/main.do">목록</a>

</body>
</html>
