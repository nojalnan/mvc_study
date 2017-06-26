<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
</head>
<body>
<script type="text/javascript">
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

function doDelete(userNum){
	xmlHttpObj = getHttpXmlObj(); 
   	var url = "./loginAction.user?";
   	var method = "get";
   	var params = "action=SIGNOUT&user_num=" + userNum;

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
<table width="400" border="1" cellpadding="0" cellspacing="0">
<tr>
	<td colspan="2">
		<jsp:include page="/module/top.jsp" flush="false" />
	</td>
</tr>
<tr>
	<td width="100" valign="top">
		<jsp:include page="/module/left.jsp" flush="false" />
	</td>
	<td width="300" valign="top">
		<!-- 내용 부분: 시작 -->
		불러온 내용 
		<!-- 버튼을 눌러 화면을 불러왔을 경우 원하는 영역에 리스트가 출력되게끔 설정해야함 -->
		<jsp:include page="/user/user_list.jsp" flush="false" />
		<br><br><br>
		<!-- 내용 부분: 끝 -->
	</td>
</tr>
<tr>
	<td colspan="2">
		<jsp:include page="/module/bottom.jsp" flush="false" />
	</td>
</tr>


</body>
</html>