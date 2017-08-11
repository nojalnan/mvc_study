<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
</head>
<body>
<table>

글갯수 : ${totalCount}
<c:forEach items="${list}" var="item" varStatus="status">
<tr>
	<td>
		 <a href="/board/view.do?seq=${item.board_num}">
			${item.rn}
		</a>
	</td>
	<td>${item.title}</td>
	<td><c:if test="${item.board_num == '1'}">new</c:if></td>
</tr>
</c:forEach>
</table>
<a href="/board/board.do?page=${firstPage}">처음</a>
<a href="/board/board.do?page=${prevPage}">이전</a>
<c:forEach begin="${begin}" end="${end}" var="item" varStatus="status">
	<span <c:if test="${param.page == item}">style='font-size:20px;'</c:if>>
		<a href="/board/board.do?page=${item}">${item}</a>
	</span>
</c:forEach>
<a href="/board/board.do?page=${nextPage}">다음</a>
<a href="/board/board.do?page=${lastPage}">끝</a>
</body>
</html>
