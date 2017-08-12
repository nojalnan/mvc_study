<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<title>자유게시판</title>
	<script type="text/javascript" src="/resources/js/jquery/jquery-3.2.1.min.js"></script>
</head>
<body>
	<table>
		<div class="container">
			글갯수 : ${totalCount}
			<table id="table" data-height="460"
				class="table table-bordered table-hover">
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th class="text-center">제목</th>
						<th class="text-center">작성자</th>
						<th class="text-center">작성일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="item" varStatus="status">
						<tr align="center">
							<td><a href="/main/view.do?board_num=${item.board_num}">
									${item.rn} </a></td>
							<td>${item.title}</td>
							<td>${item.writer}</td>
							<td>${item.reg_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a href="/main/main.do?page=${firstPage}">처음</a>
		<a href="/main/main.do?page=${prevPage}">이전</a>
		<c:forEach begin="${begin}" end="${end}" var="item" varStatus="status">
			<span
				<c:if test="${param.page == item}">style='font-size:20px;'</c:if>>
				<a href="/main/main.do?page=${item}">${item}</a>
			</span>
		</c:forEach>
		<a href="/main/main.do?page=${nextPage}">다음</a>
		<a href="/main/main.do?page=${lastPage}">끝</a>
</body>
</html>
