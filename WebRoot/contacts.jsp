<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

	<title>ScholarRecSys | Contacts</title>
	
	<meta name="description" content="">
	<meta name="author" content="">

	<link rel="icon" type="image/png" href="images/favicon.ico">
	
	<link rel="stylesheet" href="css/style.css" media="screen" />
	
	<!-- HTML5 Shiv + detect touch events -->
	<script src="js/modernizr.custom.js"></script>
</head>
<body class="liquid light">

	<!--[if lte IE 8]>
	<div class="error ie_message">
		<div class="container clearfix">
			<div class="two-third">
				<a target="_blank" href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
					You are using an outdated browser. For a faster, safer browsing experience! 
				</a>	
			</div>
			<div class="one-third last">
				<a target="_blank"  href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode" class="button-style-2 small">upgrade for free today</a>
			</div>
		</div>
	</div>
	<![endif]-->

<div id="wrapper">

	<!-- ***************** - Container - ***************** -->

	<section class="container">

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
					<li><a href="">Analyze</a>
					</li>
					<li><a href="">Recommend</a>
					</li>
					<li><a href="contacts.html">Contact</a></li>
				</ul>
			</nav><!--/ #navigation-->
			
		</header><!--/ #header-->
		
		<!-- **************** - END Header - **************** -->


		<div class="content-wrapper clearfix">

			<div id="map"></div>

			<div class="one-fourth">

				<h2 class="content-title noborder">Contact Info</h2>

				<div class="contact-block">
					<p>
						<span>Institute of Automation <br />Chinese Academy of Sciences</span>
						
						95 Zhongguancun East Road, <br />
						 100190, BEIJING, CHINA
					</p>

					<ul class="contact-list">
						<li class="contact-phone">+86 13795127261</li>
						<li class="contact-mail">
							<a href="mailto:mail@companyname.com">cloudssdut@gmail.com</a>
						</li>
						<li class="contact-skype">Zhuoyu Wei</li>
					</ul><!--/ .contact-list-->

				</div><!--/ .contact-block-->

			</div><!--/ .one-fourth-->

			<div class="three-fourth last">

				<h2 class="content-title">Drop Me a Line</h2>

				<p></p>

				<form action="" class="contacts-form" id="contactform">

					<fieldset>

						<label class="input-block"><input type="text" name="name" value="" placeholder="Name (required)"></label>
						
						<label class="input-block"><input type="text" name="email" value="" placeholder="Email (required)"></label>
						
						<label class="input-block"><input type="text" name="website" value="" placeholder="Website"></label>	
						
						<label class="message textarea-block"><textarea name="comments" placeholder="Message (required)"></textarea></label>
						
						<br class="clear">
						
					</fieldset>
					
					<button type="submit" class="button-style-2 medium">Send Message</button>
					
				</form>


			</div><!--/ .three-fourth .last-->


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

		<!-- ************ - end Footer - ************ -->	


	</section><!--/ .container-->

	<!-- *************** - end Container - *************** -->


	<!-- ************ - Footer Bottom - ************ -->

	<footer id="footer-bottom">

		<a href="#" id="footer-more"></a>

		<section class="container panel clearfix">

			<div class="one-half">
				<div class="widget-text">
					<h1>About Us</h1>
					<p>
						
					</p>
					<p>
						 
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

	<!-- ************ - end Footer - ************ -->


</div><!--/ #wrapper-->

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script>!window.jQuery && document.write('<script src="js/jquery-1.7.1.min.js"><\/script>')</script>
<!--[if lt IE 9]>
	<script src="js/selectivizr-and-extra-selectors.min.js"></script>
	<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE8.js"></script>
<![endif]-->
<script src="js/respond.min.js"></script>
<script src="js/jquery.easing-1.3.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script src="js/jquery.gmap.min.js"></script>
<script src="js/custom.js"></script>
<script src="themeChanger/js/colorpicker.js"></script>
<script src="themeChanger/js/themeChanger.js"></script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

