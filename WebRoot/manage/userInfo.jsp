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
    <title>尤克里里-小站后台</title>

    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link href="<%=path %>/manage/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="<%=path %>/manage/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=path %>/manage/css/ionicons.min.css" rel="stylesheet" type="text/css" /> 
    <link href="<%=path %>/manage/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/manage/css/style.css" rel="stylesheet" type="text/css" />
    <!--[if lt IE 9]>
        <script src="<%=path %>/manage/js/html5shiv.min.js"></script>
        <script src="<%=path %>/manage/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="skin-yellow layout-boxed">
        <!-- 侧边栏结束 -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            管理员信息
            <small>管理操作-个人信息</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="<%=path %>/HouTai/userInfo"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li class="active"></li>
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">
          <div class="box box-primary">
            <div class="box-header">
                <div class="box-title">个人信息</div>
                <div class="box-tools pull-right">
                  <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                  <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                </div>
            </div>
            <div class="box-body">
              <div class="row">
                  <div class="col-sm-12">
                    <form class="form-horizontal col-sm-10 col-sm-offset-1" action="<%=path %>/HouTai/updateUser" method="post" enctype="multipart/form-data">
                        <!-- 用户头像 -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="position: relative;top: 20px;">管理员头像：</label>
                            <div class="col-sm-6"   >
                               <div class="userpic">
                                   <label for="picSrc"> <img  src='<s:property value="#session.u.picSrc" />'  /> </label>
                                   <div></div>
                               </div>
                            </div>
                        </div>
                      <!-- 标题 -->
                      <div class="form-group">
                        <label class="col-sm-2 control-label">登陆名：</label>
                        <div class="col-sm-6"  >
                          <input type="text" name="u.username"  class="form-control" value='<s:property value="#session.u.username"/>' placeholder="个人信息" />
                        </div>
                      </div>

                      <!-- 用户密码 -->
                      <div class="form-group">
                        <label class="col-sm-2 control-label">用户密码：</label>
                        <div class="col-sm-6" >
                          <div>
                              <input type="password"  name="u.password" class="form-control " value='<s:property value="#session.u.password"/>' placeholder="用户密码" />
                          </div>
                        </div>
                      </div>

                      <!-- 用户昵称 -->
                      <div class="form-group">
                        <label class="col-sm-2 control-label">用户昵称：</label>
                        <div class="col-sm-6" >
                          <div>
                            <input type="text"  name="u.nickname" class="form-control" value='<s:property value="#session.u.nickname"/>' placeholder="用户昵称" />
                          </div>
                        </div>
                      </div>
                      <input type="file"  name="file" style="display: none" id="picSrc" multiple="multiple" />

                      <div class="form-group">
                        <div class="col-sm-6 col-sm-offset-2"> <button type="submit" class="btn btn-warning"><i class="ion-log-in"></i>提交</button>
                            <button type="reset" class="btn btn-primary"><i class="ion-ios-refresh-outline"></i>重置</button> </div>
                      </div>
                    </form>
                  </div>
                  <div class="col-md-6">

                  </div>
              </div>

            </div>
          </div>

        </section><!-- /.content -->
</div><!-- /.content-wraper -->

    <!-- jQuery 2.1.4 -->
    <script src="<%=path %>/manage/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<%=path %>/manage/js/bootstrap.min.js" type="text/javascript"></script>
   <script src="<%=path %>/manage/dist/js/app.min.js" type="text/javascript"></script>


    <!--  文件上传预览  -->
    <script>
        var $file = $("#picSrc");
        var aFile = [];
        var oTar =  $('[for="picSrc"] img');
        $file.on("change",function(){
            aFile = Array.apply({},this.files);
            if( typeof FileReader == "undefined" ) return;
            var fr = new FileReader();
            oTar.next("div").show();
            $(aFile).each(function(){
                if(this.type.match(/^(image\/)/)){
                    fr.onload = function( e ){
                       oTar.attr("src", e.target.result);
                        oTar.next("div").hide();
                    };

                    fr.readAsDataURL(this);
                };

            });
        });
    </script>
  </body>
</html>
