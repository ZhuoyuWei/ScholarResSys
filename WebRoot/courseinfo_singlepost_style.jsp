<%@ page language="java" import="java.util.*, com.po.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!--[if lte IE 8]>              <html class="ie8 no-js" lang="en">     <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html class="not-ie no-js" lang="en">  <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<title>ScholarRecSys | Online Course Info</title>
	
	<meta name="description" content="">
	<meta name="author" content="">

	<link rel="icon" type="image/png" href="images/favicon.ico">
	
	<link rel="stylesheet" href="css/style.css" media="screen" />
	
	<link rel="stylesheet" href="fancybox/jquery.fancybox.css" media="screen" />
	
	<!-- HTML5 Shiv + detect touch events -->
	<script src="js/modernizr.custom.js"></script>
</head>
<body class="liquid light">

<div id="wrapper">

	<!-- ***************** - Header Top - ***************** -->	
	
	<div id="header-top" class="clearfix">
		
		<section class="container clearfix">
			
			<div class="one-half">
				
				<ul class="contact-info clearfix">
					<li class="phone">+86 13795127261</li>
					<li class="email"><a href="mailto:cloudssdut@gmail.com">cloudssdut@gmail.com</a></li>
				</ul><!--/ .contact-info-->	
				
			</div><!--/ .one-half-->
			
			<div  class="one-half last">
				<ul data-description="Stay in touch via social networks:" class="social-links clearfix">
					<li data-tooltip="LinkedIn" class="linked"><a href="#">LinkedIn</a></li>
					<li data-tooltip="Flickr" class="flickr"><a href="#">Flickr</a></li>
					<li data-tooltip="Twitter" class="twitter"><a href="#">Twitter</a></li>
					<li data-tooltip="Facebook" class="facebook"><a href="#">Facebook</a></li>
					<li data-tooltip="Rss" class="rss"><a href="#">Rss</a></li>
				</ul><!--/ .social-links-->	
			</div><!--/ .one-fourth.last-->
			
		</section><!--/ .container-->
		
		<a href="#" id="more"></a>
		
	</div><!--/ #header-top-->
	
	<!-- ***************** - END Header Top - ***************** -->


	<!-- ***************** - Container - ***************** -->
	
	<section class="container">

		
		<!-- ***************** - Header - ***************** -->
		
		<header id="header" class="clearfix">
			
			<div id="logo">
				<h1><a href="<%=basePath+"home"%>">ScholarRecSys</a></h1>
				<div class="slogan"><span></span></div><!--/ .slogan-->
			</div><!--/ #logo-->
			
			<nav id="navigation" class="navigation">
				<ul>
					<li><a href="<%=basePath+"home"%>">Home</a>
					</li>
					<li><a href="features-typography.html">Friends</a> <!-- 这里直接跳转到我的好友吧 -->
						<ul>
							<li><a href=<%=basePath+"MyFriends"%>>Friends</a></li>		<!--显示所有用户，分页  -->	
							<li><a href=<%=basePath+"AllPeople"%>>Peoples</a></li>		<!--显示所有用户，分页  -->											
							<li><a href=<%=basePath+"AddFriend"%>>Add Friend</a></li>  <!-- 应该去掉，变成People也中的一个简单的搜索 -->
							<li><a href=<%=basePath+"SinaInfo"%>>Synchronize</a></li>
						</ul>
					</li>
					<li class="current"><a href="pages-about.html">Items</a>
						<ul>
							<li><a href=<%=basePath+"MyItems"%>>My Items</a></li>
							<li><a href=<%=basePath+"ItemList"%>>Item List</a></li>
							<li>
								<a href="">Add Item</a>
								<span class="rightarrowclass"></span>
								<ul>
									<li><a href=<%=basePath+"AddPaper"%>>Add Paper</a></li>
									<li><a href=<%=basePath+"AddBook"%>>Add Book</a></li>
									<li><a href=<%=basePath+"AddBlog"%>>Add Blog</a></li>
									<li><a href=<%=basePath+"AddOnlineCourse"%>>Add Online Course</a></li>									
								</ul>
							</li>
														
						</ul>
					</li>
					<li><a href="<%=basePath+"Analyze"%>">Analyze</a>
					</li>
					<li><a href="<%=basePath+"Recommend"%>">Recommend</a>
					</li>
					<li><a href="contacts.html">Contact</a></li>
				</ul>
			</nav><!--/ #navigation-->
			
		</header><!--/ #header-->
		
		<!-- **************** - END Header - **************** -->
		
		<div class="content-wrapper sbr clearfix">
			
			
			<div class="page-header clearfix">
				
				<h1 class="alignleft">Online course Information Page</h1>
				
				<div class="search-container">
					<form id="search" action="/">
						<input placeholder="Search" type="text" />
						<button type="submit"></button>
					</form><!--/ #search-->
				</div><!--/ .search-container-->
				
			</div><!--/ .page-header-->
			
			
			<section id="content">
				
				<article class="post-item clearfix">
				<%OnelineCourse item=(OnelineCourse)request.getAttribute("item"); %>
					<%int imageIndex=Math.abs(ScholarTweet.rand.nextInt())%12+1;
						//ScholarUser su=(ScholarUser)request.getAttribute("User");				
					 %>
					 
					<a class="single-image picture-icon" href="<%=item.getImageUrl()%>">
						<img class="entry-image" src="<%=item.getImageUrl()%>" alt="" />
					</a>
					
						

					
					
    					<h2>
							<span class="post-type picture"></span>
							<%=item.getItemName() %>
						</h2>
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
    					<td><%=item.getShort_des() %></td>
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
    			<a href="<%=basePath+"AcceptItem?itemId="+item.getItemId()%>">Accept it!</a>
					</article><!--/ .post-item-->
				
				<section id="comments">

					<h3>Comments</h3>

					<ol class="comments-list">
					<%
    					List commentList=(List)request.getAttribute("CommentList");
    					if(commentList!=null)
    					{%>

    					<%
    						for(int i=0;i<commentList.size();i++)
    						{
    							Comment com=(Comment)commentList.get(i);
    					%>
    				
    						<li class="comment">

							<article>
								<img src="images/gravatar.png" alt="Image" class="avatar">
								<div class="comment-meta">
									<h4 class="author"><a href="#"><%=com.getCreateby().getUserName() %></a></h4>
									<div class="date"><%=com.getCreateTime().toString() %></div>
									<!--  <div class="reply"><a class="button-style-1 small" href="#">Reply</a></div>-->
								</div><!--/ .comment-meta -->
								<div class="comment-body">
									<p>
										<%=com.getContent() %>
									</p>
								</div><!--/ .comment-body -->
							</article>
							</li><!--/ .children-->				
    				<%}
    				%>
    			<%}
    			%>
					</ol><!--/ .comments-list-->
				</section><!--/ #comments-->		
				
				<section id="respond">

					<h3 class="content-title">Leave a Comment</h3>
					
					<p>Post a comment or a judgement for this paper.</p>

					<form class="comments-form" action="Comment">
					
						<fieldset class="textarea-block">
							<textarea name="s_comment" placeholder="Comment here!"></textarea>
						</fieldset>

						<button class="button-style-2 medium" type="submit">Comment</button>

						<div class="clear"></div>

					</form><!--/ .comments-form-->
				</section><!--/ #respond-->
				
				
				

			
			
			<!-- ********** - Sidebar - ************ -->
			
			
			
			<!-- ********** - END Sidebar - ************ -->
			
			
		</div><!--/ .content-wrapper-->


		<!-- ************* - Main Footer - *************** -->
		
		<footer id="footer" class="clearfix">
			
			<div class="one-half">
				
				<nav id="footer-nav" class="clearfix">
					<ul>
						<li><a href="index.html">Home</a></li>
						<li><a href="features-shortcodes-elements.html">Features</a></li>
						<li><a href="pages-about.html">Pages</a></li>
						<li><a href="portfolio-3columns.html">Portfolio</a></li>
						<li><a href="blog.html">Blog</a></li>
						<li><a href="contacts.html">Contact</a></li>				
					</ul>
				</nav><!--/ #footer-nav-->
				
				<div class="copyright">&copy; 2012 Lucent. All rights reserved.</div><!--/ .copyright-->
				
			</div><!--/ .one-half-->
			
			<div class="one-half last">
				
				<ul data-description="Stay in touch via social networks:" class="social-links">
					<li data-tooltip="LinkedIn" class="linked"><a href="#">LinkedIn</a></li>
					<li data-tooltip="Flickr" class="flickr"><a href="#">Flickr</a></li>
					<li data-tooltip="Twitter" class="twitter"><a href="#">Twitter</a></li>
					<li data-tooltip="Facebook" class="facebook"><a href="#">Facebook</a></li>
					<li data-tooltip="Rss" class="rss"><a href="#">Rss</a></li>
				</ul><!--/ .social-links-->	
				
			</div><!--/ .one-half.last-->
			
		</footer>
		
		<!-- ************ - END Footer - ************ -->	

		
	</section><!--/ .container-->
	
	<!-- *************** - END Container - *************** -->

	
	<!-- ************ - Footer Bottom - ************ -->
	
	<footer id="footer-bottom">
		
		<a href="#" id="footer-more"></a>
		
		<section class="container panel clearfix">
			
			<div class="one-half">
				<div class="widget-text">
					<h1>About Us</h1>
					<p>
						Quisque diam lorem, interdum vitae,dapibus ac, scelerisque vitae, pede. Donec eget tellus non erat lacinia fermentum. 
						Donec in velit vel ipsum auctor pulvinar. Vestibulum iaculis lacinia est. Proin dictum elementum velit. 
						Fusce euismod consequat ante. 
					</p>
					<p>
						Lorem ipsum dolor sit amet, consectetuer adipis. Mauris accumsan nulla vel diam. Sed in lacus ut enim adipiscing aliquet. Nulla venenatis. 
					</p>
				</div><!--/ .widget-text-->
			</div><!--/ .one-half-->
			
			<div class="one-fourth">
				<div class="widget-flickr">
					<h1>From Flickr</h1>
					<ul id="flickr-badge" class="clearfix"></ul>
				</div><!--/ .widget-flickr-->
			</div><!--/ .one-fourth-->
			
			<div class="one-fourth last">
				<div id="signup">
					<h1>Join to Our Newsletter</h1>
					<form method="post" action="/" id="signup_form">
						<fieldset>
							<label for="s-email">Ut pharetra augue nec augue. Nam elit agna, endrerit sit amet.</label>
							<input type="text" placeholder="Enter your email address" name="s-email" id="s-email"/>
							<input type="submit" name="signup_submit" id="signup_submit" value="Submit" />
						</fieldset>
					</form><!--/ #signup_form-->
				</div><!--/ #signup -->
			</div><!--/ .one-fourth.last-->
			
		</section><!--/ .container-->
	</footer><!--/ #footer-bottom-->
	
	<!-- ************ - END Footer - ************ -->
	

</div><!--/ #wrapper-->

<script type="text/javascript" src="../../ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script>!window.jQuery && document.write('<script src="js/jquery-1.7.1.min.js"><\/script>')</script>
<!--[if lt IE 9]>
	<script src="js/selectivizr-and-extra-selectors.min.js"></script>
	<script src="../../ie7-js.googlecode.com/svn/version/2.1(beta4)/IE8.js"></script>
<![endif]-->
<script src="js/respond.min.js"></script>
<script src="js/jquery.easing-1.3.min.js"></script>
<script src="fancybox/jquery.fancybox.pack.js"></script>
<script src="js/jquery.cycle.all.min.js"></script>
<script src="js/jquery.touchSwipe-1.2.5.min.js"></script>
<script src="js/custom.js"></script>
<script src="themeChanger/js/colorpicker.js"></script>
<script src="themeChanger/js/themeChanger.js"></script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

