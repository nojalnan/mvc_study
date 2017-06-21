<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판입력</title>
</head>
<body>
<script>
 
var xmlHttpObj;
 
function getHttpXmlObj(){
    //해당브라우져가 익스플로러 7.0 이상이거나 파이어폭스, 크롭 등일경우
	if(window.XMLHttpRequest){
  		return new XMLHttpRequest();
 	}else if(window.ActiveXObject){
  		//해당 브라우져가 익스플로러 6.0 이하일경우
  		return new ActiveXObject("Microsoft.XMLHTTP");
 	}
	//해당 브라우져가 듣보잡일경우.. 어떤 브라우져 인진 나도 모름.
	alert("해당 브라우져가  Ajax를 지원하지 않습니다.");
}
 
function doBoardWrite(){
	xmlHttpObj = getHttpXmlObj(); 
	var boardtitle = document.getElementById("title").value;
	var boardcontent = document.getElementById("content").value;
	var boardwriter = document.getElementById("writer").value;
	var boardcdate = document.getElementById("cdate").value;
	var boardmodifier = document.getElementById("modifier").value;
	var boardmdate = document.getElementById("mdate").value;
 
   	var url = "./loginAction.board?";
   	var method = "get";
   	var params = "action=BOARDWRITE&title=" + encodeURIComponent(boardtitle) + "&content=" + encodeURIComponent(boardcontent) + "&writer=" + encodeURIComponent(boardwriter) + "&cdate=" + encodeURIComponent(boardcdate) + "&modifier=" + encodeURIComponent(boardmodifier) + "&mdate=" + encodeURIComponent(boardmdate);
 
   	var sync = true;
   	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
</script>
<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2"> 게시글 작성 </td> 
	</tr>
	<tr>
		<td> 제목 </td>
		<td><input type="text" name="title" id="title"/></td>
	</tr>
	<tr>
		<td> 내용 </td>
		<td><input type="text" name="content" id="content"/></td>
	</tr>
	<tr>
		<td> 글쓴이 </td>
		<td><input type="text" name="writer" id="writer"/></td>
	</tr>
	<tr>
		<td> 작성시간 </td>
		<td><input type="text" name="cdate" id="cdate"/></td>
	</tr>
	<tr>
		<td> 작성자 </td>
		<td><input type="text" name="modifier" id="modifier"/></td>
	</tr>
	<tr>
		<td> 수정시간 </td>
		<td><input type="text" name="mdate" id="mdate"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="button" value="게시판입력" onclick="doBoardWrite();"/></td>
	</tr>
</table>
<div id="resultDiv"></div>
</body>
</html>