<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
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
 
function doSend(){
	var inputNum1 = parseInt(document.getElementById("inputNum1").value);
	var inputNum2 = parseInt(document.getElementById("inputNum2").value);
	var operator = document.getElementById("operator").value;
    // 정수입력1과 정수입력2가 숫자인지 아닌지 체크합니다.
    if(isNaN(inputNum1)){ 
    	alert("정수입력1에 숫자를 입력해주세요.");
    	document.getElementById("inputNum1").focus();
     	return false;
   	}else if(isNaN(inputNum2)){
     	alert("정수입력2에 숫자를 입력해주세요.");
     	document.getElementById("inputNum2").focus();
     	return false;
   	}
   	//Ajax를 사용할 수 있는 Xml통신객체를 반듭니다. 
   	xmlHttpObj = getHttpXmlObj();
   	//메쏘드는 GET방식으로 합니다.
   	var method = "POST";
   	//통신할 jsp명입니다.
   	var url = "./output.do1";
   	//jsp에서 받을 값들을 GET방식으로 써줍니다.
   	var params = "inputNum1=" + encodeURIComponent(inputNum1) + "&inputNum2=" + encodeURIComponent(inputNum2) + "&operator=" + encodeURIComponent(operator);
   	
   	var sync = true;
   	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultNum").value=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	//xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.open(method, url, sync);
   	xmlHttpObj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   	xmlHttpObj.setRequestHeader("Content-length", params.length);
   	xmlHttpObj.setRequestHeader("Connection", "close");

   	//실제로 값을 보냅니다.
   	xmlHttpObj.send(params);
}

 </script>
<body>
 <form method="post" action="./output.jsp">
   <TABLE BORDER="1" CELLSPACING="0" CELLPADDING="0" ALIGN="CENTER" WIDTH="500">
      <TR ALIGN="CENTER">
       <TD COLSPAN="4">==사칙연산 계산기==</TD>
      </TR>
      <TR ALIGN="CENTER">
       <TD>정수입력1</TD>
       <TD>연산자선택</TD>
       <TD>정수입력2</TD>
       <TD>결과값</TD>
      </TR>
      <TR ALIGN="CENTER">
       <TD><INPUT TYPE="TEXT" NAME="inputNum1" id="inputNum1"></TD>
       <TD>
        <select name="operator" id="operator">
           <option selected value="+">+</option>
           <option value="-">-</option>
           <option value="*">*</option>
           <option value="/">/</option>
          </select>
       </TD>
       <TD><INPUT TYPE="TEXT" NAME="inputNum2" id="inputNum2"></TD>
       <TD><INPUT TYPE="TEXT" NAME="resultNum" id="resultNum"></TD>
      </TR>
      
      <TR ALIGN="CENTER" style=" height : 37px;">
       <TD COLSPAN="4"><input type="button" value="계산" onclick="doSend();"></TD>
      </TR>
     </TABLE>
 </form>
</body>
</html>