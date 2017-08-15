<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax 자유게시판</title>
<style>
a {
	cursor: pointer;
}

.view {
	cursor: pointer;
}
</style>
<script type="text/javascript">
	$(function() {
		//$("#totalCount").html("<b>테스트2</b>");
		loadPage(1);
	});

	function loadPage(page) {
		showLoading();
		$
				.ajax({
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
							htmlString += "<td class='view' text align = center data-rn='" + re.rn + "'><a>"
									+ re.rn + "</a></td>";
							htmlString += "<td text align = center>" + re.title + "</td>";
							htmlString += "<td text align = center>" + re.writer + "</td>";
							htmlString += "<td text align = center>" + re.cdate + "</td>";
							htmlString += "</tr>";
						}
						htmlString += "<tr><td class='write' colspan='5' align='right'><button class='btn btn-primary'>";
						htmlString += "글쓰기</button></td></tr>";
						$("#boardTable tbody").html(htmlString);
						$("#totalCount").html("전체 게시글 : " + result.totalCount + "개");
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
	function setEvent() {
		$("tr>td[class='view']").click(function() {
			var rn = this.getAttribute("data-rn");
			location.href = "/main/view.do?binum=" + rn;
		});
		$("a[class='movepage']").click(function() {
			var page = this.getAttribute("data-page");
			loadPage(page);
		});
		$("tr>td[class='write']").click(function() {
			location.href = "/main/write.do?";
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
		htmlString += "<div class='jb-center' style='text-align: center;'>" +
		"<ul class='pagination'>"
		htmlString += "<li><a class='movepage' data-page='"+firstPage+"'>"
				+ "처음</a></li>";
		htmlString += "<li><a class='movepage' data-page='"+prevPage+"'>"
				+ "이전</a></li>";

		for (var i = begin; i <= end; i++) {
			htmlString += "<li><a class='movepage' data-page='"+i+"'>" + i
					+ "</a></li>";
		}

		htmlString += "<li><a class='movepage' data-page='"+nextPage+"'>"
				+ "다음</a></li>";
		htmlString += "<li><a class='movepage' data-page='"+lastPage+"'>"
				+ "끝</a></li>";
		htmlString += "</ul>" + "</div>"	
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
				<td><a href="/main/main.do">main 화면 전환</a></td>
			</tr>
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
					</table>
				</td>
			</tr>
		</div>
	</table>
</body>
</html>
