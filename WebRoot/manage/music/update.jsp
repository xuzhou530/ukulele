<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
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
    <link href="<%=path %>/manage/plugins/uniform/themes/default/css/uniform.default.css" rel="stylesheet" />
    <link href="<%=path %>/manage/css/uniform.default.fixes.css" rel="stylesheet" />
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
            曲谱列表
            <small>管理操作-曲谱信息</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="<%=path %>/HouTai/listMusic"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li class="active">更新曲谱</li>
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">
          <div class="box box-primary">
            <div class="box-header">
                <div class="box-title">更新曲谱</div>
                <div class="box-tools pull-right">
                  <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                  <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                </div>
            </div>
            <div class="box-body">
              <div class="row">
                  <div class="col-sm-12">
                    <form class="form-horizontal col-sm-10 col-sm-offset-1" action="<%=path %>/HouTai/updateMusic" id="addMusic"  method="post"  enctype="multipart/form-data" >
                      <input type="hidden" name="music.id" value="${music.id }"/> 
                      <!-- 标题 -->
                      <div class="form-group">
                        <label class="col-sm-2 control-label"><i class="ion-ios-medical text-danger"></i>曲谱标题：</label>
                        <div class="col-sm-6"  >
                          <input type="text"  class="form-control" name="music.musicName" value="<s:property value="#music.musicName" />" placeholder="标题部分" required  />
                        </div>
                      </div>

                      <!-- 曲谱 -->
                      <div class="form-group">
                        <label class="col-sm-2 control-label"><i class="ion-ios-medical text-danger"></i>曲谱：</label>
                        <div class="col-sm-6" id="musicSrcWrapper">
                          <div>
                              <input type="file"  name="file"  class="form-control uniform_on"  id="musicSrc" />
                          </div>
                        </div>
                      </div>

                      <!-- 附加曲谱教程 -->
                      <div class="box box-default">
                        <div class="box-header">
                          <div class="box-title">曲谱教程</div>
                          <div class="box-tools pull-right">
                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                          <!-- 教程key -->
                          <div class="form-group">
                            <label class="col-sm-2 control-label">教程key：</label>
                            <div class="col-sm-6"  >
                              <input type="text"  name="music.vediokey" value="<s:property value="#music.vediokey" />" class="form-control" placeholder="key" />
                            </div>
                          </div>

                          <!-- 教程标题 -->
                          <div class="form-group">
                            <label class="col-sm-2 control-label">教程标题：</label>
                            <div class="col-sm-6"  >
                              <input type="text" name="music.vedioTitle" value="<s:property value="#music.vedioTitle" />"  class="form-control" placeholder="教程标题" />
                            </div>
                          </div>

                          <!-- 教程内容 -->
                          <div class="form-group">
                            <label class="col-sm-2 control-label">教程内容：</label>
                            <div class="col-sm-10" style="height: 180px;" >
                              <textarea class="form-control" name="music.vedioCount"  rows="4"  cols="4" ><s:property value="#music.vedioCount" /></textarea>
                            </div>
                          </div>
                        </div>


                      </div>
                      <div class="form-group">
                        <div class="col-sm-6 col-sm-offset-2"> <button type="submit" class="btn btn-warning"><i class="ion-log-in"></i>提交</button>
                            <button type="reset" class="btn btn-primary"><i class="ion-ios-refresh-outline"></i>重置</button> </div>
                      </div>
                    </form>
                  </div>
                  
              </div>

            </div>
          </div>
	</section><!--/.content   -->
	</div><!-- /.content-wrapper -->

    <!-- jQuery 2.1.4 -->
    <script src="<%=path %>/manage/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<%=path %>/manage/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="<%=path %>/manage/dist/js/app.min.js" type="text/javascript"></script>

    <!-- file文件按钮修饰 -->
    <script src="<%=path %>/manage/plugins/uniform/jquery.uniform.min.js"></script>

    <!-- Ckeditor 文本编辑器编辑 -->
    <script src="<%=path %>/manage/ckeditor/ckeditor.js"></script>

    <!-- html5validate -->
    <script src="<%=path %>/manage/js/jquery-html5Validate.js" ></script>

    <script>
        $(".uniform_on").uniform();
       var oVedioCount = CKEDITOR.replace("music.vedioCount");

        var aFile = [];
        $("#musicSrc").on("change",function(){

           var aFile1 = Array.apply({},this.files);
            aFile = $.map(aFile1,function( n ){
               if( n.type.match(/^(image\/)/) ){
                   return n;
               }
                return null;
            });
        });

        $("#addMusic").html5Validate(function(){
            $(this).submit();
        },{
            validate:function(){
                if( aFile.length<=0 )
                {
                    $("#musicSrc").parent().testRemind("亲，上传曲谱一定要上传图片哦");
                    return false;
                }
                return true;
            }
        });

        $.testRemind.css = {
            color: "#fff",
            backgroundColor: "#f60"
        };
    </script>
  </body>
</html>
