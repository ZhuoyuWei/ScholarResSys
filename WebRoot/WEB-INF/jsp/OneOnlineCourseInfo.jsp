<%@ page language="java" import="java.util.*, com.po.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'OneOnlineCourseInfo.jsp' starting page</title>
    
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
    <div id="online_info">
    <%OnelineCourse item =(OnelineCourse)request.getAttribute("item"); %>
    	<table>
    		<%if(item==null)
    			{%>
    				<tr>This online course is not exist or has been deleted.</tr>
    			<%}
    			else
    			{%>
    				<tr>
    					<td>Course Id:</td>
    					<td><%=item.getItemId() %></td>
    				</tr>
    				<tr>
    					<td>Course name:</td>
    					<td><%=item.getItemName() %></td>
    				</tr>
    				<tr>
    					<td>Major:</td>
    					<td><%=item.getMajor() %></td>
    				</tr>


    				<tr>
    					<td>Description:</td>
    					<td><%=item.getContent() %></td>
    				</tr>			
    				<tr>
    					<td>Keywords:</td>
    					<%
    						StringBuffer sb=new StringBuffer();
    						for(int i=0;i<item.getTags().size();i++)
    						{
    							sb.append(item.getTags().get(i)+" ");
    						}
    					%>
    					<td><%=sb.toString() %></td>
    				</tr>
    				
    				<tr>
    					<td>URL:</td>
    					<td><a href=<%=item.getLinkUrl() %>><%=item.getLinkUrl() %></a></td>
    				</tr>
    				
    				<tr><td>&nbsp</td></tr>
    			<%}
    		 %>
    	</table>
    </div>
    <div id="comment_box">
    	<s:form action="Comment">
    	    <s:textarea name="s_comment" 
    			cols="50" rows="5" />  
    		<s:submit  value="Comment"/>
    	</s:form>
    </div>
    <div id="comment_list">
    <%
    	List commentList=(List)request.getAttribute("CommentList");
    	if(commentList!=null)
    	{%>
    	<table>
    		<%
    			for(int i=0;i<commentList.size();i++)
    			{
    				Comment com=(Comment)commentList.get(i);
    			%>
    				<tr>
    					<td><%=com.getCreateby().getUserName() %></td>
    					<td><%=com.getContent() %></td>
    					<td><%=com.getCreateTime().toString() %></td>
    				</tr>
    			<%}
    		%>
    	</table>
    	<%}
    %>
    </div>
  </body>
</html>
