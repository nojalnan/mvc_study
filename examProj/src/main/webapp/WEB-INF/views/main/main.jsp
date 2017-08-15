<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<title>자유게시판</title>
<body style="width: 800px; height: 480px">
	<table>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/main/ajax.do">ajax 화면 전환</a></li>
						<li><p class="navbar-text">전체 게시글 : ${totalCount}개</p></li>
					</ul>
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
									<td><a href="/main/view.do?binum=${item.binum}">
											${item.rn} </a></td>
									<td>${item.title}</td>
									<td>${item.writer}</td>
									<td>${item.cdate}</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="5" align="right">
								<button class="btn btn-primary" onclick="location.href='/main/write.do'">글쓰기</button></td>		
							</tr>
						</tbody>
					</table>
				</div>
		</nav>
		</table>
		<div class="jb-center" style="text-align: center;">
			<ul class="pagination">
				<li><a href="/main/main.do?page=${firstPage}">처음</a></li>
				<li><a href="/main/main.do?page=${prevPage}">이전</a></li>
				<li><c:forEach begin="${begin}" end="${end}" var="item"
						varStatus="status">
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
