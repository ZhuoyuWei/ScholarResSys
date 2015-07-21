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
    
    <title>My JSP 'AddBlog.jsp' starting page</title>
    
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
    Add a new blog! <br>
    <div id="select_item_type">
    	<table>
    		<tr>
    			<td><a href=<%=basePath+"AddPaper"%>>Paper</a></td>
    			<td><a href=<%=basePath+"AddBook"%>>Book</a></td>
     			<td><a href=<%=basePath+"AddBlog"%>>Blog</a></td>
    			<td><a href=<%=basePath+"AddOnlineCourse"%>>OnlineCourse</a></td>   			    			
    		</tr>
    	</table>
    </div>
    <div id="add_item_form">
    	<s:form action="AddBlogSub">
			<s:hidden name="s_itemType" value="blog"/>
    		<s:textfield name="s_itemName" key="Blog title"/>
    		<s:textfield name="s_major" key="Major"/>
    		<s:textfield name="s_authorString" key="Author"></s:textfield>
    		<s:textarea name="s_abstractContent" label="Discription" labelposition="left" 
    			cols="50" rows="5"/>
    		<s:textfield name="s_tagString" key="Keywords"/>
    		<s:textfield name="s_blogName" key="Blog"/>
    		<s:textfield name="s_linkUrl" key="URL"/>
    		<s:checkbox name="checkMe" fieldValue="true" value="true" 
    			label="Publish a new tweet with this item at the same time" labelposition="left"/>	
    		<s:textarea name="s_publishTweetContext" label="New Tweet" labelposition="left" 
    			cols="50" rows="5" value="Enter your tweet here!"/>  
    		<s:submit  value="Add"/>
    	</s:form>
    </div>
  </body>
</html>
