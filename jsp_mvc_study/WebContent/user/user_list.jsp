<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">

function doGetUserList(){
	xmlHttpObj = getHttpXmlObj(); 
   	var url = "./loginAction.user?";
   	var method = "get";
   	var params = "action=USERLIST";

   	var sync = true;
   	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open���� ���� ����� jsp��� ����� �����մϴ�. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
</script>

</body>
</html>