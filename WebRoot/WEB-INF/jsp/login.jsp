<%@page import="org.apache.commons.logging.Log"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//System.out.println(basePath);
//Thread.sleep(10000);
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ScholarRecSys Start Page</title>
    
	<meta http-equiv="pragma" content="no-cacB411427043he">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>ScholarResSys</div>
    <div>
    <%Object oInfo=request.getAttribute("loginInfo");
    String t=request.getHeader("User-Agent");
    System.out.println("Fuck:\t"+t);
    if(oInfo!=null)
    {%>
    <%=oInfo.toString()%>
    <%}%>
    </div>
    <div>
    	<s:form action="login">
    		<s:textfield name="s_userName" key="User"/>
    		<s:password name="s_password" key="Password"/>
    		<s:hidden name="loginInfo"/>	
    		<s:submit value="login"/>
    	</s:form>
    </div>
    <div>
    Don't have a userId? <a href=<%=basePath+"REGISTER"%>>Register</a> it!
    </div>
   


  </body>
</html>
