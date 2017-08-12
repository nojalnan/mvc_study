<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	<script type="text/javascript" src="/resources/js/jquery/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			//$("#totalCount").html("<b>테스트2</b>");
			loadPage(1);
		});
		
		function loadPage(page) {
			showLoading();
			$.ajax({
				contentType:"application/json; charset=utf-8",
	        	type:"POST",
	        	url:"/main/data/boardList.do",      
	        	data:""+page,      
	        	success:function(result){
	        		var htmlString = "";
	        		for( var i=0;i<result.boardList.length;i++ ) {
	        			htmlString += "<tr>";
	        			htmlString += "<td>" + result.boardList[i].board_num + "</td>";
	        			htmlString += "<td>" + result.boardList[i].title + "</td>";
	        			htmlString += "</tr>";
	        		}
	        		$("#boardTable tbody").html(htmlString);
	        		$("#totalCount").html( "글 갯수 : " + result.totalCount );
	        		
	        		createPageing( result.totalCount, page );
	        	},
	        	complete:function() {
	        		hideLoading();
	        	}
			});
		}
		
		function createPageing(totalCount, page) {
			var firstPage = 1, begin, end;
			var lastPage = parseInt((totalCount-1)/10)+1;
			var prevPage = parseInt((page-1)/10)*10;
			if( prevPage < 1 ) prevPage = 1;
			var nextPage = (parseInt(((page-1)/10)+1)*10+1);
			if( nextPage > lastPage ) nextPage = lastPage;
			
			begin = parseInt((page-1)/10)*10+1;
			end = begin+9;
			if( end > lastPage ) end = lastPage;

    		var htmlString = "";
    		htmlString += "<a href='javascript:loadPage("+firstPage+")'>"+"처음</a> ";
    		htmlString += "<a href='javascript:loadPage("+prevPage+")'>"+"이전</a> ";
    		
    		for( var i=begin;i<=end;i++ ) {
    			htmlString += " <a href='javascript:loadPage("+i+")'>"+i+"</a> ";
    		}
    		
    		htmlString += "<a href='javascript:loadPage("+nextPage+")'>"+"다음</a> ";
    		htmlString += "<a href='javascript:loadPage("+lastPage+")'>"+"끝</a> ";
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
<div id="loading" style="background:#000;position:absolute;left:0;top:0;width:100%;height:100%;opacity: 0.5;filter: alpha(opacity=50);display:none;">
</div>
<table>
<tr>
	<td>
	<div id="totalCount"></div>
	<table id="boardTable">
	<thead>
	<tr>
		<th>번호</th>
		<th>내용</th>
	</tr>
	</thead>
	<tbody>
	</tbody>
	</table>
	<div id="pageList"></div>
	</td>
	<td id="boardView" style="display:none;">
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
</table>
</body>
</html>
