<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script type="text/javascript"
	src="/resources/js/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/resources/js/main/view.js"></script>
</head>
<body>
	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<tbody>
				<tr>
					<th>번호</th>
					<td>${item.board_num}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${item.title}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${item.content}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${item.writer}</td>
				</tr>
				<tr>
					<th>작성시간</th>
					<td>${item.reg_date}</td>
				</tr>
			</tbody>
		</table>
		<a href="/main/modify.do?board_num=${item.board_num}">수정</a> 
		<a href="javascript:deleteCheck();">삭제</a>
		<a href="/main/main.do">목록</a>
	</div>

	<input type="hidden" id="board_num" value="${item.board_num}" />
</body>
</html>
