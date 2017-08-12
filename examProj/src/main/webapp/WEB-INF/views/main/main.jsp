<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<title>자유게시판</title>
</head>
<body style="width:800px; height:480px">
	<table>
		<div class="container">
			<tr>
				<td><a href="/main/ajax.do">ajax 화면 전환</a></td>
			</tr>
			<tr>	
				<td>글갯수 : ${totalCount}</td>
			</tr>
			<table id="table" data-height="460"
				class="table table-bordered table-hover table-condensed">
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
							<td class="view" width=50 style="word-break:break-all"><a href="/main/view.do?binum=${item.binum}">
									${item.rn} </a></td>
							<td>${item.title}</td>
							<td width=200 style="word-break:break-all">${item.writer}</td>
							<td width=200 style="word-break:break-all">${item.cdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="jb-center" style="text-align: center;">
		<ul class="pagination">
		<li><a href="/main/main.do?page=${firstPage}">처음</a></li>
		<li><a href="/main/main.do?page=${prevPage}">이전</a></li>
		<li><c:forEach begin="${begin}" end="${end}" var="item" varStatus="status">
			<span
				<c:if test="${param.page == item}">style='font-size:20px;'</c:if>>
				<a href="/main/main.do?page=${item}">${item}</a>
			</span>
		</c:forEach></li>
		<li><a href="/main/main.do?page=${nextPage}">다음</a></li>
		<li><a href="/main/main.do?page=${lastPage}">끝</a></li>
		</ul>
		</div>
</body>
</html>
