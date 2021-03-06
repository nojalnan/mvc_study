<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Main update</title>
	<script type="text/javascript" src="/resources/js/jquery/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/resources/js/main/modify.js"></script>
</head>
<body>
<form name="frm" action="/main/update.do" method="post">
<input type="hidden" name="binum" value="${item.binum}" />
<table class="table table-bordered table-hover">
<tbody>
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
	<td><input type="text" name="content" id="writer" value="${item.writer}" /></td>
</tr>
</tbody>
</table>
</form>
<ul class="nav nav-pills">
<li><a href="/main/main.do">목록</a></li>
<li><a href="/main/view.do?binum=${item.binum}">상세보기</a></li>
<li><a href="javascript:updateCheck();">업데이트</a></li>
</ul>
</body>
</html>
