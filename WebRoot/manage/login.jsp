<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="s" uri="/struts-tags" %>
<s:if test="#user == null">
	 <jsp:forward page="/manage/register.jsp"></jsp:forward>
</s:if>
<!DOCTYPE html>
<html>
  <head>
   <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>ukulele小站后台</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.4 -->
    <link href="<%=path %>/manage/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="<%=path %>/manage/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="<%=path %>/manage/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="<%=path %>/manage/js/html5shiv.min.js"></script>
        <script src="<%=path %>/manage/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="lockscreen">
    <!-- Automatic element centering -->
    <div class="lockscreen-wrapper">
      <div class="lockscreen-logo">
        <a href="#"><b>Ukulele</b>后台登录</a>
      </div>
      <!-- User name -->
      <div class="lockscreen-name"><s:property value="#user.nickname" /></div>

      <!-- START LOCK SCREEN ITEM -->
      <div class="lockscreen-item">
        <!-- lockscreen image -->
        <div class="lockscreen-image">
          <img src='<s:property value="#user.picSrc" />' alt="用户头像" />
        </div>
        <!-- /.lockscreen-image -->

        <!-- lockscreen credentials (contains the form) -->
        <form class="lockscreen-credentials" action="<%=path %>/HouTai/login" method="post">
          <div class="input-group">
            <input type="password" class="form-control" placeholder="password" name="u.password" />
            <input type="hidden" name="u.username" value='<s:property value="#user.username"/>' />
            <div class="input-group-btn">
              <button class="btn"><i class="fa fa-arrow-right text-muted"></i></button>
            </div>
          </div>
        </form><!-- /.lockscreen credentials -->
      </div><!-- /.lockscreen-item -->
      <div class="help-block text-center">
        请输入密码进入后台管理界面<br/>
        <span style="color: red"><s:property value="#error" /></span>
      </div>
      <div class="lockscreen-footer text-center">
        Copyright &copy; 2015-8-6 <b><a href="#" class="text-black">KissyJoy</a></b><br/>
      </div>
    </div><!-- /.center -->

    <!-- jQuery 2.1.4 -->
    <script src="<%=path %>/manage/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<%=path %>/manage/js/bootstrap.min.js" type="text/javascript"></script>
  </body>
</html>
