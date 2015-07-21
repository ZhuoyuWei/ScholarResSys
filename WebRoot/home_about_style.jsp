<%@ page language="java"  import="java.util.*,java.text.*,com.po.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html xmlns:wb=“http://open.weibo.com/wb”>
<!--[if lte IE 8]>              <html class="ie8 no-js" lang="en">     <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html class="not-ie no-js" lang="en">  <!--<![endif]-->

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<title>ScholarRecSys | Home</title>
	
	<meta name="description" content="">
	<meta name="author" content="">

	<link rel="icon" type="image/png" href="images/favicon.ico">
	
	<link rel="stylesheet" href="css/style.css" media="screen" />
	
	<!-- HTML5 Shiv + detect touch events -->
	<script src="js/modernizr.custom.js"></script>
	<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript" charset="utf-8"></script>
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
			
			<div id="content">
				
				<h1 class="content-title">Home Page</h1>
				
				<form id="tweet_publish" action="PublishTweet" class="contacts-form" >

					<fieldset>	
						
						<label class="message textarea-block"><textarea name="s_publishTweetContext" placeholder="Enter your tweet here!"></textarea></label>
						
						<br class="clear">
						
					</fieldset>
					<input type="checkbox" name="post_to_weibo" fieldValue="true" value="true"
					style="width:13px;height:13px;line-height:13px;margin-right:2px; vertical-align:-2px;
					*vertical-align:middle;_vertical-align:3px;"/>&nbsp&nbsp&nbsp&nbsp Post in SinaWeibo at the same time
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<button type="submit" class="button-style-2 medium">Post it !</button>
					
				<div class="hidden" id="contact_form_responce"><blockquote></blockquote></div></form>
				
				<hr /> 
				
				<!-- *************** - Tabs Container - *************** -->	
				
				<div class="content-tabs">
					<ul class="tabs-nav clearfix">

						<li><a href="#tab1">My Information</a></li>
						<li><a href="#tab2">My Motto</a></li>
						<li><a href="#tab3">My Keywords</a></li>

					</ul><!--/ .content-tabs-nav -->

					<div class="tabs-container">
					<%
						ScholarUser su=(ScholarUser)request.getAttribute("User");					
					 %>
						<div class="tab-content" id="tab1">
						<p>
							I'm from <%=su.getCity() %>, <%=su.getProvince() %>,  <%=su.getCountry()%> 
						</p>
						<p>
							My major is <%=su.getMajor() %>
						</p>
						<p>
							You can contact me via phone number(<%=su.getPhoneNum() %>), or email(<%=su.getEmailAddress() %>)
						</p>


						</div><!--/ #tab1-->

						<div class="tab-content" id="tab2">
							<blockquote class="quote-text">
							<%=su.getMotto() %>
						</blockquote>
						</div><!--/ #tab2-->

						<div class="tab-content" id="tab3">
							<p>
								<%
									for(int i=0;i<su.getKeywordList().size();i++)
									{
										if(i>=10)
											break;
									%>
										<%=su.getKeywordList().get(i)+", " %>
									<%}
								%>
							</p>
							
						</div><!--/ #tab3-->

					</div><!--/ .tabs-container -->
				</div><!--/ .content-tabs-->
				
				<!-- ************** - end Tabs Container - ************** -->
				
				<h1>News Feed</h1>
				
				<!-- *************** - Our Team - *************** -->	
				
				<ul class="accordion clearfix" id="accordion">
				
				<%List<ScholarTweet> tweetList=(List<ScholarTweet>)request.getAttribute("friendTweets");
    			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			System.out.println((tweetList!=null)+"\t"+tweetList.size()+"fuck");
     		  	for(int i=0;i<tweetList.size();i++)
    		  		{%>
    		  			<li>
						<section>
							<h4 class="slide-name"><%=tweetList.get(i).getCreateby().getUserName()%></h4>
							<div class="slide-thumb"><img alt="Thumbnail" src="images/temp/team_img_<%=Math.abs(ScholarTweet.rand.nextInt())%10+""%>.jpg" /></div><!--/ .slide-thumb-->
							<div class="slide-content">
								<p>
									<%=tweetList.get(i).getContent()%>
								</p>
								<ul class="social-links clearfix">
									<li data-tooltip="Facebook" class="facebook"><a href="#">Facebook</a></li>
									<li data-tooltip="Twitter" class="twitter"><a href="#">Twitter</a></li>
									<li data-tooltip="Flickr" class="flickr"><a href="#">Flickr</a></li>
									<li data-tooltip="LinkedIn" class="linked"><a href="#">LinkedIn</a></li>
									<li data-tooltip="Skype" class="skype"><a href="#">Skype</a></li>
									<li data-tooltip="Mail" class="mail"><a href="#">Mail</a></li>
									
								</ul><!--/ .social-links-->		
							</div><!--/ .slide-content-->		
						</section>
					</li>
    		  	<%}%>
				</ul><!--/ accordion--> 
				
				<!-- *************** - end Our Team - *************** -->	
				
			</div><!--/ #content-->
			
			
			<!-- ********** - Sidebar - ************ -->
			
			<aside id="sidebar">
				
				<div class="widget">
					
					<h1 class="widget-title">Pages List</h1>

					<ul class="feature-menu">
						<li><a href="pages-about.html">About Us</a></li>
						<li><a href="pages-full-width.html">Full Width Page</a></li>
						<li><a href="pages-with-right-sidebar.html">Page Width Right Sidebar</a></li>
						<li><a href="pages-with-left-sidebar.html">Page Width Left Sidebar</a></li>
						<li><a href="pages-archives.html">Archives</a></li>
						<li><a href="pages-404.html">404 Page</a></li>
					</ul><!--/ .feature-menu-->	
					
				</div><!--/ .widget-->
				
				
				<div class="widget">
					
					<!-- *************** - Tabs Container - *************** -->
					
					<div class="aside-tabs">
						
						<ul class="tabs-nav clearfix">

							<li class="popular" data-tooltip="Popular"><a href="#tab4">Popular Posts</a></li>
							<li class="recent" data-tooltip="Recent"><a href="#tab5">Recent Posts</a></li>
							<li class="tags" data-tooltip="Tags"><a href="#tab6">Tags</a></li>
							<li class="latest" data-tooltip="Twitter"><a href="#tab7">Latest Tweets</a></li>

						</ul><!--/ .tabs-nav -->

						<div class="tabs-container">

							<div class="tab-content" id="tab4">
								<ul class="small-thumb">
									<li>
										<a href="#"><img class="alignleft" src="images/temp/pic_thumb_1.jpg" alt="" /></a>
										<div class="entry">
											<h6><a href="#">Donec in velit vel ipsum auctor.</a></h6>
											<div class="entry-meta">
												<a class="post-date" href="#"><span>03/29/2012</span></a>
											</div><!--/ .entry-meta-->	
										</div><!--/ .entry-->
										<div class="clear"></div>
									</li>
									<li>
										<a href="#"><img class="alignleft" src="images/temp/pic_thumb_2.jpg" alt="" /></a>
										<div class="entry">
											<h6><a href="#">Donec in velit vel ipsum auctor.</a></h6>
											<div class="entry-meta">
												<a class="post-date" href="#"><span>03/29/2012</span></a>
											</div><!--/ .entry-meta-->	
										</div><!--/ .entry-->
										<div class="clear"></div>
									</li>
									<li>
										<a href="#"><img class="alignleft" src="images/temp/pic_thumb_3.jpg" alt="" /></a>
										<div class="entry">
											<h6><a href="#">Donec in velit vel ipsum auctor.</a></h6>
											<div class="entry-meta">
												<a class="post-date" href="#"><span>03/29/2012</span></a>
											</div><!--/ .entry-meta-->	
										</div><!--/ .entry-->
										<div class="clear"></div>
									</li>
								</ul>
							</div><!--/ #tab4-->

							<div class="tab-content" id="tab5">
								<ul class="small-thumb">
									<li>
										<a href="#"><img class="alignleft" src="images/temp/pic_thumb_2.jpg" alt="" /></a>
										<div class="entry">
											<h6><a href="#">Donec in velit vel ipsum auctor.</a></h6>
											<div class="entry-meta">
												<a class="post-date" href="#"><span>03/29/2012</span></a>
											</div><!--/ .entry-meta-->	
										</div><!--/ .entry-->
										<div class="clear"></div>
									</li>
									<li>
										<a href="#"><img class="alignleft" src="images/temp/pic_thumb_1.jpg" alt="" /></a>
										<div class="entry">
											<h6><a href="#">Donec in velit vel ipsum auctor.</a></h6>
											<div class="entry-meta">
												<a class="post-date" href="#"><span>03/29/2012</span></a>
											</div><!--/ .entry-meta-->	
										</div><!--/ .entry-->
										<div class="clear"></div>
									</li>
									<li>
										<a href="#"><img class="alignleft" src="images/temp/pic_thumb_3.jpg" alt="" /></a>
										<div class="entry">
											<h6><a href="#">Donec in velit vel ipsum auctor.</a></h6>
											<div class="entry-meta">
												<a class="post-date" href="#"><span>03/29/2012</span></a>
											</div><!--/ .entry-meta-->	
										</div><!--/ .entry-->
										<div class="clear"></div>
									</li>
								</ul>
							</div><!--/ #tab5-->

							<div class="tab-content" id="tab6">
								<ul class="tag-list">
									<li><a href="#">Art</a>&nbsp;<span>(3)</span></li>
									<li><a href="#">Fashion</a>&nbsp;<span>(7)</span></li>
									<li><a href="#">Landscape</a>&nbsp;<span>(4)</span></li>
									<li><a href="#">Nature</a>&nbsp;<span>(1)</span></li>
									<li><a href="#">Photography</a>&nbsp;<span>(9)</span></li>
									<li><a href="#">Travelling</a>&nbsp;<span>(12)</span></li>
								</ul>
							</div><!--/ #tab6-->

							<div class="tab-content" id="tab7">
								
								<div class="tweet"></div>
								
							</div><!--/ #tab7-->

						</div><!--/ .tabs-container -->	
					</div><!--/ .aside-tabs-->
		
					<!-- ************** - end Tabs Container - ************** -->	
					
				</div><!--/ .widget-->
				
				<div class="widget">
					
					<h1 class="content-title">Latest Projects</h1>
					
					<ul class="latest">
						<li>
							<a href="#">
								<img alt="" src="images/temp/220px_1.jpg">
								<h3 class="title">Suspendisse sollicitudin</h3>
								<span class="desc">Aenean nec eros. Vestibulum ante ipsum primis in faucibus orci...</span>
							</a>		
						</li>
						<li>
							<a href="#">
								<img alt="" src="images/temp/220px_2.jpg">
								<h3 class="title">Aliquam dapibus tincidunt</h3>
								<span class="desc">Aenean nec eros. Vestibulum ante ipsum primis in faucibus orci...</span>
							</a>		
						</li>
						<li>
							<a href="#">
								<img alt="" src="images/temp/220px_3.jpg">
								<h3 class="title">Donec sagittis euismod</h3>
								<span class="desc">Aenean nec eros. Vestibulum ante ipsum primis in faucibus orci...</span>
							</a>		
						</li>
					</ul>
					<div class="latest-controls">
						<a href="#" id="prev"></a>
						<a href="#" id="next"></a>
					</div>

				</div><!--/ .widget-->

				
			</aside><!--/ #sidebar-->
			
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
<script src="js/jquery.cycle.all.min.js"></script>
<script src="js/jquery.elegantAccordion.js"></script>
<script src="js/custom.js"></script>
<script src="themeChanger/js/colorpicker.js"></script>
<script src="themeChanger/js/themeChanger.js"></script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

