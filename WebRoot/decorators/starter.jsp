<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 if (session.getAttribute("u")==null){
	 %>
	 <jsp:forward page="/manage/register.jsp"></jsp:forward>
	 <%
 }
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sitemesh-decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
  <head>
   <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title><sitemesh-decorator:title /></title>

   	<sitemesh-decorator:head />
  </head>
  <body class="skin-yellow layout-boxed">
    <div class="wrapper">
      <header class="main-header">

        <a href="index2.html" class="logo">
          <span class="logo-lg"><b>ukulele</b>小站后台</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- 切换左右窗口按钮 -->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">导航栏切换</span>
          </a>
          <!-- 右边导航栏 -->
          <div class="navbar-custom-menu">

            <ul class="nav navbar-nav">
              <!-- User Account Menu -->
              <li class="dropdown user user-menu">
                <!-- Menu Toggle Button -->
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <!-- The user image in the navbar-->
                  <img src='<s:property value="#session.u.picSrc" />' class="user-image" alt="User Image" />
                  <!-- hidden-xs hides the username on small devices so only the image appears. -->
                  <span class="hidden-xs"><s:property value="#session.u.nickname"/></span>
                </a>
                <ul class="dropdown-menu">
                  <!-- The user image in the menu -->
                  <li class="user-header">
                    <img src='<s:property value="#session.u.picSrc" />' class="img-circle" alt="User Image" />
                    <p class="user-intro">
                      <s:property value="#session.u.nickname"/>--小站创始人
                      <small><s:property value="#session.u.createdate"/></small>
                    </p>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="<%=path %>/HouTai/userInfo" class="btn btn-default btn-flat">修改个人信息</a>
                    </div>
                    <div class="pull-right">
                      <a href="<%=path %>/HouTai/logout" class="btn btn-default btn-flat">注销</a>
                    </div>
                  </li>
                </ul>
              </li>
             
              <li>
                <a href="#" data-toggle="control-sidebar"></a>
              </li>
            </ul>
          </div>
        </nav>
      </header>

      <!-- 左侧边栏 -->
      <aside class="main-sidebar">

        <section class="sidebar">

          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src='<s:property value="#session.u.picSrc" />' class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p><s:property value="#session.u.nickname"/></p>
              <a href="javascript:void(0)"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div><!-- /.user-panel -->

          <!-- Sidebar 菜单栏 -->
          <ul class="sidebar-menu">
            <li class="header">导航栏</li>

            <li class="active"><a href="<%=path %>/HouTai/userInfo"><i class="fa fa-link"></i> <span>个人信息</span></a></li>
            <li>
            	<a href="<%=path %>/HouTai/listCart"><i class="fa fa-link"></i>  论坛管理</a>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-cog"></i> <span>曲谱管理</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="<%=path %>/HouTai/add_music">上传曲谱</a></li>
                <li><a href="<%=path %>/HouTai/listMusic">曲谱操作</a></li>
              </ul>
            </li>
			<li class="treeview">
              <a href="#"><i class="fa fa-link"></i> <span>ululele视频</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="<%=path %>/HouTai/add_vedio">上传视频</a></li>
                <li><a href="<%=path %>/HouTai/listVedio">视频操作</a></li>
              </ul>
            </li>
          </ul><!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
      </aside>





      <sitemesh-decorator:body />


      <!-- Main Footer -->
      <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
          Anything you want
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2015 <a href="#">zjgsUnvercity</a>.</strong> By Kissyjoy.
      </footer>

    </div><!-- ./wrapper -->
  </body>
</html>
