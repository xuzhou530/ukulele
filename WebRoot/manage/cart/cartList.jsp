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
	<link href="<%=path %>/manage/css/style.css" rel="stylesheet" type="text/css" />
    <link href="<%=path %>/manage/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    <!--[if lt IE 9]>
        <script src="<%=path %>/manage/js/html5shiv.min.js"></script>
        <script src="<%=path %>/manage/js/respond.min.js"></script>
    <![endif]-->
    <style>
    	.table td>div{ width:auto; display:inline-block;max-width: 150px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;}
    	
    	.musicPic{max-width: 80px; display:inline-block; height: 30px; box-shodaw:0 0 4px #666; overflow: hidden;  }
    	.musicPic img{ width: 30px; height: auto; min-height: 30px; }
    </style>
  </head>
  <body class="layout-boxed">
   
<!-- 侧边栏结束 -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper ">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            论坛列表
            <small>管理操作-论坛列表</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="<%=path %>/HouTai/listCart"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li class="active">论坛管理</li>
          </ol>
        </section>


        <!-- Main content -->
        <section class="content">

          <div class="row">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">论坛列表</h3>
              </div><!-- /.box-header -->
              <div class="box-body table-responsive no-padding">
                <table id="example1" class="table table-bordered table-striped table-hover">
                  <thead>
                    <tr>
                      <th>序号</th>
                      <th>所属类型</th>
                      <th>标题</th>
                      <th>内容</th>
                      <th>是否加精</th>
                      <th>发出日期</th>
                      <th>被举报次数</th>
                      <th>预览次数</th>
                      <th>操作</th>
                    </tr>
                  </thead>
                  <tbody>
                    <s:iterator value="carts" var="cart" status="iIndex">
                    <tr>
                      <td><s:property value="#iIndex.index" /></td>
                      <td>
                      	 <s:if test="#cart.type == 0" >
	                       	入门教程
	                       </s:if>
	                       	<s:if test="#cart.type == 1" >
	                       	交流讨论
	                       </s:if>
	                       <s:if test="#cart.type == 2" >
	                       	资料库
	                       </s:if>
	                       <s:if test="#cart.type == 3" >
	                       	自扒普
	                       </s:if>
	                       <s:if test="#cart.type == 4"  >
	                       	转载
	                       </s:if>
                      </td>
                      <td title="<s:property value="#cart.title" />"><div><s:property value="#cart.title" /></div></td>
                      <td title="<s:property value="#cart.content" escapeHtml="true"  />"><div><s:property value="#cart.content" escapeHtml="false"  /></div></td>
                      <td title="<s:property value="#cart.top" />"><div>
                      	<s:if test="#cart.top==1">加精</s:if>
                      	<s:if test="#cart.top==0">未加精</s:if>
                      	</div></td>
                      <td title="<s:property value="#cart.createdate" />"><div><s:property value="#cart.createdate" /></div></td>
                      <td title="<s:property value="#cart.danger" />"><div><s:property value="#cart.danger" /></div></td>
                      <td title="<s:property value="#cart.scanfCount" />"><div><s:property value="#cart.scanfCount" /></div></td>
                      <td >
                       <p  style="width:200px; text-align: center;">
                       	<s:if test="#cart.top!=1">
                       		<a href="<%=path %>/HouTai/update_cart?cart.id=<s:property value="#cart.id"/>&cart.top=1"><button class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i>加精</button></a>
                       	</s:if>
                       <s:if test="#cart.top==1">
                       		<a href="<%=path %>/HouTai/update_cart?cart.id=<s:property value="#cart.id"/>&cart.top=0"><button class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i>取消加精</button></a>
                       	</s:if>
                        <a href="<%=path %>/HouTai/deleteCart?cart.id=<s:property value="#cart.id"/>"><button class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i>删除</button></a></p></td>
                    </tr>
                    </s:iterator>
                  </tbody>
                 
                </table>
              </div><!-- /.box-body -->
            </div><!-- /.box -->

          </div>

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

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
    $(".table td>div img").css({"width":"30px",
    	"height":"30px"}
    );

  </script>
  </body>
</html>
