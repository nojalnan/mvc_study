<%@ page contentType = "text/html; charset=utf-8" %>
<script>
function doLogout(){
	xmlHttpObj = getHttpXmlObj(); 
   	var url = "./loginAction.user?";
   	var method = "get";
   	var params = "action=LOGOUT";

   	var sync = true;
   	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
       		//로그아웃시 로그인 페이지로 이동
       		location.href="/user/login.jsp";
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
</script>

상단 메뉴:
	<tr>
		<td colspan="2" align="right"><input type="button" value="Logout" onclick="doLogout();"/></td>
	</tr>