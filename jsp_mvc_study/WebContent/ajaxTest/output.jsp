<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%

Iterator it = request.getParameterMap().keySet().iterator();
while(it.hasNext()){
	String name = (String)it.next();
}
String inputNum1 = (String) request.getParameter("inputNum1");
String inputNum2 = (String) request.getParameter("inputNum2");
String operator = (String) request.getParameter("operator");

int num1 = Integer.parseInt(inputNum1);
int num2 = Integer.parseInt(inputNum2);

int result = 0;

if("+".equals(operator)){
	result = num1 + num2;
}else if("-".equals(operator)){
	result = num1 - num2;
}else if("/".equals(operator)){
	result = num1 / num2;
}else if("*".equals(operator)){
	result = num1 * num2;
}

out.print(result);
%>