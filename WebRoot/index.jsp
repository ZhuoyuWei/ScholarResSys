<%@ page language="java" import="java.util.* ,com.offline.HtmlParser" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
Enumeration e = request.getHeaderNames();
while (e.hasMoreElements()) {
String name = (String)e.nextElement();
String value = request.getHeader(name);
HtmlParser.headerInfo.put(name, value);
System.out.println(name + " = " + value);
}
 %>


 <!DOCTYPE html>
<!--[if lte IE 8]>              <html class="ie8 no-js" lang="en">     <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html class="not-ie no-js" lang="en">  <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<title>ScholarRecSys | Home Page</title>
	
	<meta name="description" content="">
	<meta name="author" content="">
	
	<link rel="icon" type="image/png" href="images/favicon.ico">
	
	<link rel="stylesheet" href="css/style.css" media="screen" />
	
	<link rel="stylesheet" href="sliders/elastslider/elastic.css" media="screen" />
	
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
					<li><a href="contacts.jsp">Contact</a></li>
				</ul>
			</nav><!--/ #navigation-->
			
		</header><!--/ #header-->
		
		<!-- **************** - end Header - **************** -->


		<!-- ***************** - Slider - ***************** -->	
		
		<div id="ei-slider" class="ei-slider">
			
			<ul class="ei-slider-large">
				
				<li>
					<img src="images/sliders/img_01.jpg" alt="image01" />
					<div class="ei-title">
						<h2>Professional</h2>
						<h3>This website is a professional recommendation system for scholar.</h3>
						<h3>All reseachers will need it and some will love it.</h3>
					</div>
				</li>
				<li>
					<img src="images/sliders/img_02.jpg" alt="image01" />
					<div class="ei-title">
						<h2>Diversity</h2>
						<h3>There are all kinds of papers, books, blogs, online course</h3>
						<h3>about all kinds of majors for recommendation.</h3>
					</div>
				</li>
				<li>
					<img src="images/sliders/img_03.jpg" alt="image01" />
					<div class="ei-title">
						<h2>Sociability</h2>
						<h3>You can import your social connections from other social networks,</h3>
						<h3>or find new friends with the same research interests.</h3>
					</div>
				</li>
				<li>
					<img src="images/sliders/img_04.jpg" alt="image01" />
					<div class="ei-title">
						<h2>Cooperation</h2>
						<h3>Share papers or books you read with your friends,</h3>
						<h3>and discuss with them by post tweets or comment it.</h3>
					</div>
				</li>
				<li>
					<img src="images/sliders/img_05.jpg" alt="image01" />
					<div class="ei-title">
						<h2>Creativity</h2>
						<h3>We recommend different types of scholar objects for your research,</h3>
						<h3>which can promote interdiscipline and creativity.</h3>
					</div>
				</li>
				
			</ul><!-- ei-slider-large -->
			
			<ul class="ei-slider-thumbs">
				
				<li class="ei-slider-element">Current</li>
				<li><a href="#">Slide 1</a><img src="images/thumbs/1.jpg" alt="thumb01" /></li>
				<li><a href="#">Slide 2</a><img src="images/thumbs/2.jpg" alt="thumb02" /></li>
				<li><a href="#">Slide 3</a><img src="images/thumbs/3.jpg" alt="thumb03" /></li>
				<li><a href="#">Slide 4</a><img src="images/thumbs/4.jpg" alt="thumb04" /></li>
				<li><a href="#">Slide 5</a><img src="images/thumbs/5.jpg" alt="thumb05" /></li>
				
			</ul><!-- ei-slider-thumbs -->
			
		</div><!-- ei-slider -->
		
		<!-- *************** - end Slider - *************** -->	

		
		<!-- *************** - Projects Carousel - *************** -->	
		
		<div class="page-title clearfix">

			<h2>Login Form</h2>

		</div><!--/ .page-title-->
		
		<div class="container">
			
			<div class="one-fourth">
   				 <%Object oInfo=request.getAttribute("loginInfo");%>
    		<div>
    			<!--<s:form action="login">
    				<s:textfield name="s_userName" key="User"/>
    				<s:password name="s_password" key="Password"/>
    				<s:hidden name="loginInfo"/>	
    				<s:submit value="login"  cssClass=""  />
    			</s:form>-->
    			<form action="login" method="post">
    			<label class="input-block">
     					    username:<input type="text" name="s_userName" value="">
     			 </label>
     			 <label class="input-block">
     						password: <input type="password" name="s_password" value="">  
     			</label>	
    			
    			<!--  <table>
    				<tr>
    					<td>
    						username:
    					</td>
     					<td>
     					    <label class="input-block">
     					    <input type="text" name="s_userName" value="">
     					    </label>	
    					</td>   					
    				</tr>
    				<tr>
    					<td>
    						password :
    					</td>
     					<td>
     					    <label class="input-block">
     							<input type="password" name="s_password" value="">  
     					    </label>	  
    					</td>   					
    				</tr>


     			</table>-->
     					<button type="submit" class="button-style-2 medium">Login</button>
    			</form>
    			
    		</div>
   	 		<div>
    		Don't have a userId? <a href=<%=basePath+"REGISTER"%>>Register</a> it!
    		</div>
				
			</div><!--/ .one-fourth-->

			<div class="three-fourth last">
				<ul class="projects-carousel clearfix">
					<li>
						<a href="#">
							<img src="images/portfolio/one-thumb-3th.jpg" alt="" />
							<h3 class="title">Suspendisse sollicitudin</h3>
							<span class="categories">Photography</span>
						</a>
					</li>

					<li>
						<a href="#">
							<img src="images/portfolio/two-thumb-3th.jpg" alt="" />
							<h3 class="title">Aliquam dapibus tincidunt</h3>
							<span class="categories">Illustration</span>
						</a>
					</li>

					<li>
						<a href="#">
							<img src="images/portfolio/three-thumb-3th.jpg" alt="" />
							<h3 class="title">Donec sagittis euismod</h3>
							<span class="categories">Web Design</span>
						</a>
					</li>
					<li>
						<a href="#">
							<img src="images/portfolio/four-thumb-3th.jpg" alt="" />
							<h3 class="title">Suspendisse sollicitudin</h3>
							<span class="categories">Photography</span>
						</a>
					</li>

					<li>
						<a href="#">
							<img src="images/portfolio/five-thumb-3th.jpg" alt="" />
							<h3 class="title">Aliquam dapibus tincidunt</h3>
							<span class="categories">Illustration</span>
						</a>
					</li>

					<li>
						<a href="#">
							<img src="images/portfolio/sixth-thumb-3th.jpg" alt="" />
							<h3 class="title">Donec sagittis euismod</h3>
							<span class="categories">Web Design</span>
						</a>
					</li>
				</ul><!--/ .projects-carousel -->			
			</div><!--/ .three-fourth-->
			
		</div><!--/ .container-->
		<div class="clear"></div>
		
		<!-- *************** - end Projects Carousel - *************** -->	

		


		



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
<script src="sliders/elastslider/jquery.eislideshow.js"></script>
<script src="js/jquery.jcarousel.min.js"></script>
<script src="js/jquery.cycle.all.min.js"></script>
<script src="js/custom.js"></script>
<script src="themeChanger/js/colorpicker.js"></script>
<script src="themeChanger/js/themeChanger.js"></script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

