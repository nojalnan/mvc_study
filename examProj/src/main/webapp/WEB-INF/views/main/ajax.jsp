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
<style>
a{
	cursor:pointer;
}
.view{
	cursor:pointer;
}
</style>
<script type="text/javascript">
	$(function() {
		//$("#totalCount").html("<b>테스트2</b>");
		loadPage(1);
	});

	function loadPage(page) {
		showLoading();
		$.ajax({
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			type : "POST",
			url : "/main/data/boardList.do",
			data : "" + page,
			success : function(result) {
				var htmlString = "";
				for (var i = 0; i < result.boardList.length; i++) {
					var re = result.boardList[i];
					htmlString += "<tr>";
					htmlString += "<td class='view' data-rn='" + re.rn + "'><a>" 
					+ re.rn + "</a></td>";
					htmlString += "<td>" + re.title + "</td>";
					htmlString += "<td>" + re.writer + "</td>";
					htmlString += "<td>" + re.reg_date + "</td>";
					htmlString += "</tr>";
				}
				$("#boardTable tbody").html(htmlString);
				$("#totalCount").html("글 갯수 : " + result.totalCount);
				createPageing(result.totalCount, page);
				setEvent();
			},
			error : function(xhr) {
				alert("에러 : " + xhr.responseText);
			},
			complete : function() {
				hideLoading();
			}
		});
	}
	function setEvent(){
		$("tr>td[class='view']").click(function(){
			var rn = this.getAttribute("data-rn");
			location.href="/main/view.do?board_num=" + rn;
		});
		$("a[class='movepage']").click(function(){
			var page = this.getAttribute("data-page");
			loadPage(page);
		});
	}

	function createPageing(totalCount, page) {
		var firstPage = 1, begin, end;
		var lastPage = parseInt((totalCount - 1) / 10) + 1;
		var prevPage = parseInt((page - 1) / 10) * 10;
		if (prevPage < 1)
			prevPage = 1;
		var nextPage = (parseInt(((page - 1) / 10) + 1) * 10 + 1);
		if (nextPage > lastPage)
			nextPage = lastPage;

		begin = parseInt((page - 1) / 10) * 10 + 1;
		end = begin + 9;
		if (end > lastPage)
			end = lastPage;

		var htmlString = "";
		htmlString += "<a class='movepage' data-page='"+firstPage+"'>"
				+ "처음</a> ";
		htmlString += "<a class='movepage' data-page='"+prevPage+"'>"
				+ "이전</a> ";

		for (var i = begin; i <= end; i++) {
			htmlString += " <a class='movepage' data-page='"+i+"'>" + i
					+ "</a> ";
		}

		htmlString += "<a class='movepage' data-page='"+nextPage+"'>"
				+ "다음</a> ";
		htmlString += "<a class='movepage' data-page='"+lastPage+"'>"
				+ "끝</a> ";
		$("#pageList").html(htmlString);
	}

	function showLoading() {
		$("#loading").show();
	}

	function hideLoading() {
		$("#loading").hide();
	}
</script>
</head>
<body>
	<div id="loading"
		style="background: #000; position: absolute; left: 0; top: 0; width: 100%; height: 100%; opacity: 0.5; filter: alpha(opacity = 50); display: none;">
	</div>

	<table>
		<div class="container">
		<tr>
			<td>
				<div id="totalCount"></div>
				<table id="boardTable" data-height="460"
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
					</tbody>
				</table>
				<div id="pageList"></div>
			</td>
			<td id="boardView" style="display: none;">
				<table>
					<tr>
						<th>제목</th>
						<td></td>
					</tr>
					<tr>
						<th>내용</th>
						<td></td>
					</tr>
					</div>
				</table>

			</td>
		</tr>
	</table>
</body>
</html>
