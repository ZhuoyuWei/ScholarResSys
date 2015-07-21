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
    
    <title>My JSP 'AddPaper.jsp' starting page</title>
    
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
    Add a new paper! <br>
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
    	<s:form action="AddPaperSub">
			<s:hidden name="s_itemType" value="paper"/>
    		<s:textfield name="s_itemName" key="Paper title"/>
    		<s:textfield name="s_major" key="Major"/>
    		<s:textfield name="s_authorString" key="Authors"></s:textfield>
    		<s:textfield name="s_paperType" key="Paper Type"/>
    		<s:textfield name="s_journal" key="Journal"/>
    		<s:textfield name="s_conference" key="Conference"/>
    		<s:textfield name="s_pubYear" key="Year"/>
    		<s:textarea name="s_abstractContent" label="Abstract" labelposition="left" 
    			cols="50" rows="5"/>
    		<s:textfield name="s_tagString" key="Keywords"/>
    		<s:textfield name="s_linkUrl" key="Url"/> 
    		<!--<s:checkbox name="isPublish" label=""
    			value="true" fieldValue="false" labelposition="left"/>-->
    		<s:checkbox name="checkMe" fieldValue="true" value="true" 
    			label="Publish a new tweet with this item at the same time" labelposition="left"/>	
    		<s:textarea name="s_publishTweetContext" label="New Tweet" labelposition="left" 
    			cols="50" rows="5" value="Enter your tweet here!"/>  
    		<s:submit  value="Add"/>
    	</s:form>
    </div>
  </body>
</html>
