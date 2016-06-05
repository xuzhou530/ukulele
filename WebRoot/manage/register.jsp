<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
    <!-- iCheck -->
    <link href="<%=path %>/manage/plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />

	<link href="<%=path %>/manage/plugins/uniform/themes/default/css/uniform.default.css" rel="stylesheet" />
    <link href="<%=path %>/manage/css/uniform.default.fixes.css" rel="stylesheet" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="<%=path %>/manage/js/html5shiv.min.js"></script>
        <script src="<%=path %>/manage/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="register-page">
    <div class="register-box">
      <div class="register-logo">
        <a href="../../index2.html"><b>Ukulele</b>后台注册</a>
      </div>

      <div class="register-box-body">
        <p class="login-box-msg">小站管理员唯一</p>
        <form action="<%=path %>/HouTai/addUser.action"  id="register" method="post" enctype="multipart/form-data"  >

          <div class="form-group has-feedback">
            <input type="text" class="form-control" name="u.username" placeholder="用户名" pattern="^[a-z0-9_-]{3,16}$" required  />
            <span class="glyphicon glyphicon-user form-control-feedback"  ></span>
          </div>

		  <div class="form-group has-feedback">
			<div class="form-control">
				<span style="color:#999">上传头像<span><input name="file" id="file" type="file" class=" uniform"  />
			</div>
            <span class="glyphicon glyphicon-user form-control-feedback"  ></span>
          </div>

          <div class="form-group has-feedback" >
            <input type="password" name="u.password" class="form-control" placeholder="输入密码" required id="pw" />
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="form-group form-group has-feedback ">
              <input type="password" class="form-control" placeholder="确认密码" required id="pw2" />
              <span class="glyphicon glyphicon-log-in form-control-feedback has-error"></span>
              <span class="text-danger passwordDeff"  style="display: none" >两次密码输入不相同</span>
          </div>

          <div class="form-group has-feedback">
            <input type="text" name="u.nickname" class="form-control" placeholder="用户昵称" required />
            <span class="glyphicon glyphicon-user form-control-feedback" ></span>
          </div>


          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox"> 记住账号</a>
                </label>
              </div>
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
            </div>
          </div>
        </form>



        <a href="<%=path %>/HouTai/userLoginInput" class="text-center">已有账号</a>
      </div><!-- /.form-box -->
    </div><!-- /.register-box -->

    <!-- jQuery 2.1.4 -->
    <script src="<%=path %>/manage/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<%=path %>/manage/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="<%=path %>/manage/plugins/iCheck/icheck.min.js" type="text/javascript"></script>

    <!-- html5validate -->
    <script src="<%=path %>/manage/js/jquery-html5Validate.js" ></script>

	 <script src="<%=path %>/manage/plugins/uniform/jquery.uniform.min.js"></script>

    <script>
  
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });

        $("#register").html5Validate(function(){
          $(this).submit();
        },{
          validate:function(){
            if( $("#pw").val() !=$("#pw2").val() ){

              $("#pw").testRemind("两次密码输入不相同");

              return false;
            }
            
            if( $('#file')[0].files.length < 1) {
            	console.log($('#file')[0].files.length<1);
            	$('#file').closest(".form-control").testRemind("亲，请上传头像哦");
            	return false;
            }
            return true;
          }
        });

        $.testRemind.css = {
          color: "#fff",
          backgroundColor: "#f60"
        };

        $("#pw")[0].oninput=function(){
            validatePassword();
        };

        $("#pw2")[0].oninput=function(){
          validatePassword();
        };

        function validatePassword() {
          if(  $("#pw").val() != $("#pw2").val() && $("#pw2").val() !="" ){
            $("#pw2").addClass("has-error");
            $(".passwordDeff").show();
          }else{
            $("#pw2").removeClass("has-error");
            $(".passwordDeff").hide();
          }
        }
		
		$(".uniform").uniform();

      });
    </script>
  </body>
</html>
