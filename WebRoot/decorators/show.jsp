<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="sitemesh-decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta content="" name=""/>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
    <meta content="专注分享尤克里里谱、尤克里里教程、ukulele谱、尤克里里调音、尤克里里和弦的乌克丽丽夏威夷吉他小站。" name="description" />
    <meta content="ukulele，乌克丽丽，尤克里里，尤克里里谱，尤克里里教程，ukulele谱，ukulele教程，尤克里里调音，尤克里里和弦，乌克丽丽教程，尤克里里入门" name="keywords" />
    <meta content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" name="viewport" />
   <sitemesh-decorator:head />
   <title><sitemesh-decorator:title /></title>
   <link type="image/x-icon" href="<%=path %>/show/img/logo-01-img2ico.net.ico" rel="shortcut icon">
    <!--[if lt IE 9]>
       <script src="<%=path %>/show/js/html5shiv.min.js" ></script>
       <script src="<%=path %>/show/js/respond.min.js" ></script>
    <![endif] -->
    <style type="text/css">
    	.ie8 .share-wrapper .icn a,.ie7 .share-wrapper .icn a,.ie6 .share-wrapper .icn a{
    	-ms-behavior: url(<%=path %>/show/css/backgroundsize.min.htc);
		behavior: url(<%=path %>/show/css/backgroundsize.min.htc);
    	}
    </style>
  </head>
  
  
<!--[if IE 9]><body class="ie9"><![endif]-->
<!--[if IE 8]><body class="ie8"><![endif]-->
<!--[if IE 7]><body class="ie7"><![endif]-->
<!--[if IE 6]><body class="ie6"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><body><!--<![endif]-->


   <!-- header begin-->
    <header id="header">
        <div class="container clearfix">
            <p>网站公告:<label>珠海尤克里里于8月15号上线啦！ 欢迎访问哦0.0</label></p>
            <%-- <ul class="third_login clearfix">
                <li>
                    <a href="#"><img src="<%=path %>/show/img/QQ.png" alt="QQ登陆"/></a>
                </li>
                <li>
                    <a href="#"><img src="<%=path %>/show/img/weixin.png" alt="微信登陆"/></a>
                </li>
                <li>
                    <a href="#"><img src="<%=path %>/show/img/weibo.png" alt="微博登陆"/></a>
                </li>
            </ul>

            <ul class="login clearfix">
                <li>
                    <a href="#">注册</a>
                </li>
                <li>
                    |
                </li>
                <li>
                    <a href="#">登陆</a>
                </li>
            </ul> --%>

        </div>
    </header>
<!-- header end -->

<!-- nav-->
    <nav id="iNavbar" class="container">
        <div class="Ibrand">
            <a href="<%=path %>/index"><img src="<%=path %>/show/img/logo-01.png"></a>
        </div>
        <div class="nav_search">
            <form class="search" action="" method="post" style="visibility: hidden;">
                <div class="iInput-addon">
                    <input type="text" value="" placeholder="在此输入关键字"/>
                    <span class="iInputAddon"></span>
                </div>
            </form>
            <nav class="clear iNav">
                <ul>
                    <li>
                        <a href="<%=path %>/index">首页</a>
                    </li>
                    <li>
                        <a href="<%=path %>/music/showMusicList?pager.offset=0">尤克里里曲谱</a>
                    </li>
                    <li>
                        <a href="<%=path %>/vedio/showVedioList?pager.offset=0">尤克里里视频</a>
                    </li>
                    <li>
                        <a href="<%=path %>/music/ukuleleAbout">常用和弦</a>
                    </li>
                    <li>
                        <a href="<%=path %>/cart/pagerCart?pager.offset=0">尤克里里论坛</a>
                    </li>
                </ul>
            </nav>
        </div>
    </nav>
<!-- /.nav -->
	
	<sitemesh-decorator:body />
	
	
<!--  #footer -->
<footer id="footer">
    <div class="ftCon">
        Copyright&copy;2014-2015 ukulele小教室浙江省杭州市浙江工商大学<br />
        联系我们&nbsp;|&nbsp;QQ:1347827212<br/>
        小站所有曲谱均出自网络
    </div>
</footer>
<!--  /#footer -->

	<script src="<%=path %>/show/js/share.js"></script>
  </body>
</html>
