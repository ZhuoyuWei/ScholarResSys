<%@ page language="java" import="java.util.*,java.text.*,com.po.ScholarTweet" pageEncoding="ISO-8859-1"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>HOME PAGE</title>
    
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

    <div id="user_info">
   		<%String userName=session.getAttribute("userName").toString();%>   
    	<%=userName%>'s HOME &nbsp&nbsp&nbsp&nbsp&nbsp<a href=<%=basePath+"SinaInfo"%>>Synchronize SinaWeibo info</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    	 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href=<%=basePath+"AddFriend"%>>Add Friends</a>
    </div>
    <div id="tweet_publish">
    	<s:form action="PublishTweet">
    		<s:textarea name="s_publishTweetContext" label="New Tweet" labelposition="top" 
    			cols="50" rows="5" value="Enter your tweet here!"/>
    		<s:submit  value="publish"/>
    	</s:form>
    </div>
    <div id="add_item">
    	<a href=<%=basePath+"AddPaper"%>>Add a new Item</a>
    </div>
    <div id="friends_new">
    	<table>
    		<%List<ScholarTweet> tweetList=(List<ScholarTweet>)request.getAttribute("friendTweets");
    			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		  	if(tweetList==null||tweetList.size()==0){%>
    		  		<tr><td>There isn't anything new, you can make more fiends or publish your own!</td></tr>
    		<%  }
    			else
    		  	{
     		  		for(int i=0;i<tweetList.size();i++)
    		  		{%>
    		  			<tr>
    		  				<td>
    		  					<div><%=tweetList.get(i).getCreateby().getUserName()%>:</div>
    		  				</td>
    		  				<td>
    		  					<div><%=tweetList.get(i).getContent()%></div>
    		  				</td>   
    		  				<td>
    		  					<div>
    		  						<%
    		  							if(tweetList.get(i).getItem()!=null)
    		  							{
    		  								String url="ItemInfo?itemId="+tweetList.get(i).getItem().getItemId();
    		  							%>
    		  								<a href=<%=basePath+url%>>view item</a>
    		  							<%}
    		  						%>
    		  					</div>
    		  				</td>	
     		  				<td>
    		  					<div><%=sdf.format(tweetList.get(i).getCreateTime().getTime())%></div>
    		  				</td>   		  				  				
    		  			</tr>
    		  		<%}   		  
    		  	}
    		%>
    		
    	</table>
    </div>
    
  </body>
</html>
