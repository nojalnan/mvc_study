<%@ page contentType = "text/html; charset=utf-8" %>
 좌측 메뉴
<table border="1" align="center" cellspacing="0" cellpadding="0">
	<tr>
		<td> 유저리스트 : </td>
	</tr>
	<tr>
		<td><input type='button' value='불러오기' onclick='doGetUserList()'/></td>
	</tr>
	<tr>
		<td> 자유게시판 : </td>
	</tr>
	<tr>
		<td><input type='button' value='불러오기' onclick='doGetBoardList()'/></td>
	</tr>
</table>
<div id="resultDiv"></div>
