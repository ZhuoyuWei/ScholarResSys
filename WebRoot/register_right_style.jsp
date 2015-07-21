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
	
	<title>ScholarRecSys | Register</title>

	<meta name="description" content="">
	<meta name="author" content="">	
	
	<link rel="icon" type="image/png" href="images/favicon.ico">
	
	<link rel="stylesheet" href="css/style.css" media="screen" />
	
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
				<h1><a href="index.html">ScholarRecSys</a></h1>
				<div class="slogan"><span>A Professional Scholar Recommendation System.</span></div><!--/ .slogan-->
			</div><!--/ #logo-->
			
			<nav id="navigation" class="navigation">
				<ul>
					<li><a href="contacts.html">Contact</a></li>
				</ul>
			</nav><!--/ #navigation-->
			
		</header><!--/ #header-->
		
		<!-- **************** - end Header - **************** -->
		
		
		<div class="content-wrapper sbr clearfix">
			
		<div id="content">
				
		<h1 class="content-title">Register An Account</h1>
		<form action="register">
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<label class="input-block" ><input type="text" name="s_userName" placeholder="Username" style="width:200px;"></label>*<br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp			
			<label class="input-block"><input type="password" name="s_password" placeholder="Password" style="width:200px;"></label>*<br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp			
			<label class="input-block"><input type="password" name="s_confirm" placeholder="Confirm password" style="width:200px;">*</label><br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp			
			<label class="input-block"><input type="text" name="s_job" placeholder="Job" style="width:200px;"></label><br><br>	
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp				
			<label class="input-block"><input type="text" name="s_company" placeholder="Company" style="width:200px;"></label><br><br>	
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp			
			<label class="input-block"><input type="text" name="s_school" placeholder="School" style="width:200px;"></label><br><br>	
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp					
			<label class="input-block"><input type="text" name="s_degree" placeholder="Degree" style="width:200px;"></label><br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp				
			<label class="input-block"><input type="text" name="s_major" placeholder="Major" style="width:200px;"></label>*<br><br>	
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp			
			<label class="input-block"><input type="text" name="s_country" placeholder="Country" style="width:200px;"></label><br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp				
			<label class="input-block"><input type="text" name="s_province" placeholder="Province" style="width:200px;"></label><br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp						
			<label class="input-block"><input type="text" name="s_city" placeholder="City" style="width:200px;"></label><br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp					
			<label class="input-block"><input type="text" name="s_address" placeholder="Address" style="width:200px;"></label><br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp			
			<label class="input-block"><input type="text" name="s_zip" placeholder="Zip" style="width:200px;"></label><br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp			
			<label class="input-block"><input type="text" name="s_emailAddress" placeholder="Email" style="width:200px;"></label>*<br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp			
			<label class="input-block"><input type="text" name="s_phoneNum" placeholder="Phone" style="width:200px;"></label>*<br><br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<label class="message textarea-block"><textarea name="s_motto" placeholder="Motto" style="width:400px; height:100px;"></textarea></label><br><br>	
			<input type="hidden" name="registerInfo"/>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<button type="submit" class="button-style-2 medium">Register</button>
    	</form>
			
				
		</div><!--/ #content-->
			
			
			<!-- ********** - Sidebar - ************ -->
			
			<aside id="sidebar">
				
				<div class="widget">
					
					<h1 class="widget-title">Tools Bar</h1>

					<ul class="feature-menu">
						<li><a href="">About Us</a></li>
						<li><a href="">Full Width Page</a></li>
						<li><a href="">Page Width Right Sidebar</a></li>
						<li><a href="">Page Width Left Sidebar</a></li>
						<li><a href="">Archives</a></li>
						<li><a href="">404 Page</a></li>
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
<script src="js/custom.js"></script>
<script src="themeChanger/js/colorpicker.js"></script>
<script src="themeChanger/js/themeChanger.js"></script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

