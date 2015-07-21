<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>Register!</div>
    <div>
    <%Object oInfo=request.getAttribute("registerInfo");
    if(oInfo!=null)
    {%>
    <%=oInfo.toString()%>
    <%}%>
    </div>
    <div>
    	<s:form action="register">
    		<s:textfield name="s_userName" key="Username"/>
    		<s:password name="s_password" key="Password"/>
    		<s:password name="s_confirm" key="Confirm password"/>
    		<s:textfield name="s_job" key="Job"/>
    		<s:textfield name="s_company" key="Company"/>
    		<s:textfield name="s_school" key="School"/>
    		<s:textfield name="s_degree" key="Degree"/>
    		<!--<s:combobox name="degree" label="degree" theme="css_xhtml" labelposition="left"
    			list="{'Junior college','Undergraduate','Master','PhD'}"/>-->
    		<s:textfield name="s_major" key="Major"/>
    		<s:textfield name="s_country" key="Country"/>
    		<s:textfield name="s_province" key="Province"/>
    		<s:textfield name="s_city" key="City"/>
    		<s:textfield name="s_address" key="Address"/>
    		<s:textfield name="s_zip" key="Zip"/>
    		<s:textfield name="s_emailAddress" key="Email"/>
    		<s:textfield name="s_phoneNum" key="Phone"/>
    		<s:hidden name="registerInfo"/>	
    		<s:submit key="register"/>
    	</s:form>
    </div>
  </body>
</html>
