<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %> 
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head lang="en">
    <title >尤克里里小站曲谱</title>
    <link rel="stylesheet" href="<%=path %>/show/css/app.css" />
     <link  href="<%=path %>/show/css/bootstrap-modal.css" rel="stylesheet"/>
    <link href="<%=path %>/show/css/bootstrap-modal-bs3patch.css" rel="stylesheet"/>
</head>
<body>
    <!-- .container-->
    <div class="container relative clearfix ">
        <article class="carts box">
            <header class="box-header clearfix">
                <ul class="fl">
                    <li class="fl"><a href="<%=path %>/cart/pagerCart?pager.offset=0">全部</a></li>
                    <li class="fl"><a href="<%=path %>/cart/pagerCart?pager.offset=0&orderby=createdate">最新</a></li>
                    <li class="fl"><a href="<%=path %>/cart/pagerCart?pager.offset=0&orderby=scanfCount">热帖</a></li>
                    <li class="fl"><a href="<%=path %>/cart/pagerCart?pager.offset=0&orderby=top">精华</a></li>
                    <li class="fl"><a href="<%=path %>/cart/pagerCart?pager.offset=0">更多<span class="icon10"></span></a></li>
                </ul>
                <ul class="fr">
                    <li class="fl"><a href="javascript:void(0)">回复/查看</a></li>
                    <li class="fl"><a href="javascript:void(0)">最后发表</a></li>
                </ul>
            </header>
            <!-- article 开始-->
            <article class="box-body carts">
            	<s:iterator value="#pager.objs" var="cart">
            		<section class="clearfix">
	                    <div class="carTitle fl">
	                        <a href='<%=path %>/cart/show?cart.id=<s:property value="#cart.id" />'>
	                       <s:if test="#cart.type == 0" >
	                       	【入门教程】
	                       </s:if>
	                       	<s:if test="#cart.type == 1" >
	                       	【交流讨论】
	                       </s:if>
	                       <s:if test="#cart.type == 2" >
	                       	【资料库】
	                       </s:if>
	                       <s:if test="#cart.type == 3" >
	                       	【自扒普】
	                       </s:if>
	                       <s:if test="#cart.type == 4" >
	                       	【转载】
	                       </s:if>
	                         <s:property value="#cart.title" /> &nbsp; 
		                        <s:if test="#cart.top == 1">
		                        	<span class="icon9"></span>
		                        </s:if>
		                        
		                        <s:if test="#cart.scanfCount >= 100">
		                        	<span class="icon8"></span>
		                        </s:if>
		                        
		                        <s:if test="#cart.createdate.getTimes()">
		                        	<span class="icon7"></span>
		                        </s:if>
	                         </a>
	                    </div>
	                    <ul class="cartAbout fr">
	                        <li>
	                            <s:property value="#cart.comments.size()" /><br />
	                            <span ><s:property value="#cart.scanfCount" /></span>
	                        </li>
	                        <li>
	                          <s:property value="#cart.username" /><br/>
	                            <span><s:property value="#cart.createdate" /></span>
	                        </li>
	                    </ul>
	                </section>
            	</s:iterator>
                <div class="pager">
                	<ul class="pagenavigation">
                	<pg:pager  
                		maxPageItems="${pager.pagerSize }" 
                		items="${pager.pageCount }" 
                		export="curPage=pageNumber" 
                		maxIndexPages="5" 
                		url="cart/pagerCart">
                		<pg:param name="orderby"/>
                		<pg:prev ifnull="false" >
				   			<li>
						      <a href="${pageUrl }" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
					  	</pg:prev>  
						 <pg:pages>
				   			<c:if test="${curPage eq pageNumber }">
				   			 <li class="active"><a href="${pageUrl }">${pageNumber } <span class="sr-only"></span></a></li>
							</c:if>
							<c:if test="${curPage ne pageNumber }">
								 <li class=""><a href="${pageUrl }">${pageNumber } <span class="sr-only"></span></a></li>
							</c:if>
				   		</pg:pages>
				   		
				   		<pg:next ifnull="false">
			   				 <li>
						      <a href="${pageUrl }" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
				   		</pg:next>
				   		<pg:last >
				   			<li>
				   				<a href="${pageUrl }">
				   					尾页 [${pageNumber }]
				   				</a>
				   			</li>
				   		</pg:last>
						
                	</pg:pager>
                    </ul>
                </div>
            </article>
        </article>
        <!--  /.article 结束 -->
        <div>

            <p class="btn publish_cart_title"> 发帖</p>

            <form action="<%=path %>/cart/add" method="post" class="publish_cart"  id="addCart" >
                <div class="form_group">
                    <input type="text" name="cart.title"  required="required" maxlength="80" />&nbsp; 可输入80个字符
                </div>
                <div >
                    <span id="testresult"></span>
                    <textarea name="cart.content" required="required" id="cart_content"></textarea>
                </div>
                <button class="btn form_group" type="button" data-toggle="modal" data-target="#myModal" >发表帖子</button>
                <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">临时昵称</h4>
                    </div>
                    <div class="modal-body">
                        	昵称：<input type="text"  class="form-control"  placeholder="昵称" name="cart.username"  required="required" /><br/>
                        	类别：<select name="cart.type" class="form-control" >
                        		<option value="0">入门教程</option>
                        		<option value="1">交流讨论</option>
                        		<option value="2">资料库</option>
                        		<option value="3">自扒普</option>
                        	</select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn">发送</button>
                    </div>
                </div>
            </form>

        </div>
    </div><!-- /.conatiner -->

    <script src="<%=path %>/show/js/jquery.min.js"></script>
    
    <script src="<%=path %>/show/js/boostrap-modal.js"></script>
    <!-- Ckeditor 文本编辑器编辑 -->
    <script type="text/javascript" src="<%=path %>/show/ckeditor/ckeditor.js"></script>
    
    <!-- 验证 -->
    <script type="text/javascript" src="<%=path %>/show/js/jquery-html5Validate.js"></script>
    <script>
        var $section = $(".vedios section.vedio");
        $($.map($section,function(oI){
            if(($(oI).index()+1)%3==1){
                return oI;
            };
        })).css('margin-left','0px');
        $(".icon9").closest("a").css({
        	"color":"#601986",
        	"text-shadow":"0 0px .3px #601986"
        	});
        $(".icon8").closest("a").css({
        	"color":"#E60012",
        	"text-shadow":"0 0px .3px #601986"
        	});
        var oVedioCount = CKEDITOR.replace("cart.content");
        
        
        $("#addCart").html5Validate(function(){
            $(this).submit();
          });

          $.testRemind.css = {
            color: "#fff",
            backgroundColor: "#f60",
            "z-index":"200000"
          };
        
    </script>



</body>
</html>