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
	
	<title>Lucent | Portfolio 2 Columns</title>
	
	<meta name="description" content="">
	<meta name="author" content="">
	
	<link rel="icon" type="image/png" href="images/favicon.ico">
	
	<link rel="stylesheet" href="css/style.css" media="screen" />
	
	<link rel="stylesheet" type="text/css" href="fancybox/jquery.fancybox.css" media="screen" />
	
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
		
		
		<div class="content-wrapper clearfix">
			
			<header class="page-header clearfix">
				
				<h1>2 Columns Portfolio</h1>
				
				<ul id="portfolio-filter">

					<li>Show:</li>
					<li><a data-categories="*">All</a></li>
					<li><a data-categories="photography">Photography</a></li>
					<li><a data-categories="travelling">Travelling</a></li>
					<li><a data-categories="motion">Motion</a></li>
					<li><a data-categories="illustration">Illustration</a></li>
					<li><a data-categories="web">Web</a></li>

				</ul><!-- end #portfolio-items-filter -->
				
			</header><!--/ .page-header-->
			
			<section id="portfolio-items" class="gl-col-2">
				
				<article class="one-half" data-categories="photography">

					<a href="images/fullscreen/big-img-1.jpg" class="single-image picture-icon" rel="group_portfolio">
						<img src="images/portfolio/thumb-2nd-1.jpg" alt="">
					</a>

					<a href="#" class="project-meta">
						<h3 class="title-item">Panorama View of Budapest, Hungary</h3>
						<span class="categories">Photography</span>
					</a>
			
				</article><!--/ .one-half -->
				
				<article class="one-half" data-categories="travelling">

					<a href="images/fullscreen/big-img-2.jpg" class="single-image picture-icon" rel="group_portfolio">
						<img src="images/portfolio/thumb-2nd-2.jpg" alt="">
					</a>

					<a href="#" class="project-meta">
						<h3 class="title-item">Somewhere In Paradise</h3>
						<span class="categories">Travelling</span>
					</a>
			
				</article><!--/ .one-half -->
				
				<article class="one-half" data-categories="motion">

					<a href="../../www.youtube.com/v/AEtrjFWnvvw@version=3&feature=player_detailpage" class="video video-icon" rel="group_portfolio">
						<img src="images/portfolio/thumb-2nd-3.jpg" alt="">
					</a>

					<a href="#" class="project-meta">
						<h3 class="title-item">Benedictine Monastery on St George's Island, Montenegro</h3>
						<span class="categories">Motion</span>
					</a>
			
				</article><!--/ .one-half -->
				
				<article class="one-half" data-categories="web">

					<a href="images/fullscreen/big-img-4.jpg" class="single-image picture-icon" rel="group_portfolio">
						<img src="images/portfolio/thumb-2nd-4.jpg" alt="">
					</a>

					<a href="#" class="project-meta">
						<h3 class="title-item">The Reichstag Building, Germany</h3>
						<span class="categories">Web</span>
					</a>
			
				</article><!--/ .one-half -->
				
				<article class="one-half" data-categories="illustration">

					<a href="images/fullscreen/big-img-5.jpg" class="single-image picture-icon" rel="group_portfolio">
						<img src="images/portfolio/thumb-2nd-5.jpg" alt="">
					</a>

					<a href="#" class="project-meta">
						<h3 class="title-item">Through The Woods by Minnhagen</h3>
						<span class="categories">Illustration</span>
					</a>
			
				</article><!--/ .one-half -->
				
				<article class="one-half" data-categories="photography">

					<a href="images/fullscreen/big-img-6.jpg" class="single-image picture-icon" rel="group_portfolio">
						<img src="images/portfolio/thumb-2nd-6.jpg" alt="">
					</a>

					<a href="#" class="project-meta">
						<h3 class="title-item">The Grand Hungarian Parliament Building</h3>
						<span class="categories">Photography</span>
					</a>
			
				</article><!--/ .one-half -->
				
				<article class="one-half" data-categories="travelling">

					<a href="images/fullscreen/big-img-7.jpg" class="single-image picture-icon" rel="group_portfolio">
						<img src="images/portfolio/thumb-2nd-7.jpg" alt="">
					</a>

					<a href="#" class="project-meta">
						<h3 class="title-item">The Basilica of the Sacred Heart of Paris</h3>
						<span class="categories">Travelling</span>
					</a>
			
				</article><!--/ .one-half -->
				
				<article class="one-half" data-categories="motion">
					
					<a href="../../www.youtube.com/v/72UPv2NaX3g@version=3&feature=player_detailpage" class="video video-icon" rel="group_portfolio">
						<img src="images/portfolio/thumb-2nd-8.jpg" alt="">
					</a>
					<a href="#" class="project-meta">
						<h3 class="title-item">Traditional Holland Village</h3>
						<span class="categories">Motion</span>
					</a>
			
				</article><!--/ .one-half -->
				
				<article class="one-half" data-categories="illustration">

					<a href="images/fullscreen/big-img-9.jpg" class="single-image picture-icon" rel="group_portfolio">
						<img src="images/portfolio/thumb-2nd-9.jpg" alt="">
					</a>

					<a href="#" class="project-meta">
						<h3 class="title-item">Hut by Minnhagen</h3>
						<span class="categories">Illustration</span>
					</a>
			
				</article><!--/ .one-half -->
				
				<article class="one-half" data-categories="web">

					<a href="images/fullscreen/big-img-10.jpg" class="single-image picture-icon" rel="group_portfolio">
						<img src="images/portfolio/thumb-2nd-10.jpg" alt="">
					</a>

					<a href="#" class="project-meta">
						<h3 class="title-item">The Liberty Bridge Across The River Danube, Hungary</h3>
						<span class="categories">Web Design</span>
					</a>
			
				</article><!--/ .one-half -->
				
			</section><!--/ #portfolio-items-->
						
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
	
	<!-- ************ - end Footer - ************ -->


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
<script src="js/jquery.isotope.min.js"></script>
<script src="js/custom.js"></script>
<script src="themeChanger/js/colorpicker.js"></script>
<script src="themeChanger/js/themeChanger.js"></script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
