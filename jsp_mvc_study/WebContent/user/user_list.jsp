<%@ page contentType = "text/html; charset=utf-8" %>
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
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
</script>