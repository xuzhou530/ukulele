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
    <link href="<%=path %>/manage/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    <!--[if lt IE 9]>
        <script src="<%=path %>/manage/js/html5shiv.min.js"></script>
        <script src="<%=path %>/manage/js/respond.min.js"></script>
    <![endif]-->
    <style>
    	.table td>div{ width:auto; display:inline-block;max-width: 150px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;}
    	.musicPic{ display:inline-block; width:auto; max-width:80px; height: 30px; box-shodaw:0 0 4px #666; overflow: hidden;  }
    	.musicPic img{ width: 30px; height: auto; min-height: 30px; }
    </style>
  </head>
  <body class="layout-boxed">

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
            <li class="active">曲谱列表</li>
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">

          <div class="row">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">曲谱列表</h3>
              </div><!-- /.box-header -->
              <div class="box-body table-responsive no-padding">
                <table id="example1" class="table table-bordered table-striped table-hover">
                  <thead>
                    <tr>
                      <th>序号</th>
                      <th>曲谱标题</th>
                      <th>曲谱</th>
                      <th>曲谱教程key</th>
                      <th>教程标题</th>
                      <th>教程内容</th>
                      <th>操作</th>
                    </tr>
                  </thead>
                  <tbody>
                    <s:iterator value="musics" var="music" status="iIndex">
                    <tr>
                      <td><s:property value="#iIndex.index"/></td>
                      <td title="<s:property value="#music.obj.musicName" />"><div><s:property value="#music.obj.musicName" /></div></td>
                      <td title="曲谱图片"><div><div class="musicPic">
                      	<s:iterator value="#music.picsrc" var="pic">
                      		<img alt="曲谱图片" src='<s:property value="#pic" />'>	
                      	</s:iterator>
                      	</div></div></td>
                      <td title="<s:property value="#music.obj.vediokey" />"><div><s:property value="#music.obj.vediokey" /></div></td>
                      <td title="<s:property value="#music.obj.vedioTitle" />"><div><s:property value="#music.obj.vedioTitle" /></div></td>
                      <td title="<s:property value="#music.obj.vedioCount" />"><div><s:property value="#music.obj.vedioCount" /></div></td>
                      <td > <p style="width: 156px;"><a href="<%=path %>/HouTai/update_music?music.id=<s:property value="#music.obj.id"/>"><button class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i>修改</button></a>
                        <a href="<%=path %>/HouTai/deleteMusic?music.id=<s:property value="#music.obj.id"/>"><button class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i>删除</button></a></p></td>
                    </tr>
                    </s:iterator>
                    
                  </tbody>
                </table>
              </div><!-- /.box-body -->
            </div><!-- /.box -->

          </div>

        </section><!-- /.content -->
       </div>
       
    <!-- jQuery 2.1.4 -->
    <script src="<%=path %>/manage/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<%=path %>/manage/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="<%=path %>/manage/dist/js/app.min.js" type="text/javascript"></script>
    <!-- DATA TABES SCRIPT -->
    <script src="<%=path %>/manage/plugins/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="<%=path %>/manage/plugins/datatables/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <!-- SlimScroll -->
  <script >
    $("#example1").DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": false,
      "info": true,
      "autoWidth": true
    });

  </script>
  </body>
</html>
