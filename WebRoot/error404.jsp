<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
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
    <link href="<%=path %>/manage/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />

<!-- Font Awesome Icons -->
    <link href="<%=path %>/manage/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
   
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="<%=path %>/manage/js/html5shiv.min.js"></script>
        <script src="<%=path %>/manage/js/respond.min.js"></script>
    <![endif]-->

  </head>
  
  <body>
            <!-- Main content -->
        <section class="content col-md-12" >

          <div class="error-page">
            <h2 class="headline text-red">404!</h2>
            <div class="error-content" style="margin-top:100px; padding: 20px">
              <h3><i class="fa fa-warning text-red"></i> Oops! Something went wrong.</h3>
              <p >
				        你访问的页面不存在 请返回上以及重试    
              </p>
            </div>
          </div><!-- /.error-page -->

        </section><!-- /.content -->
        
            <!-- jQuery 2.1.4 -->
    <script src="<%=path %>/manage/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<%=path %>/manage/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="<%=path %>/manage/dist/js/app.min.js" type="text/javascript"></script>
  </body>
</html>
