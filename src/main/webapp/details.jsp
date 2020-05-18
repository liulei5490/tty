<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>详细博客</title>
</head>

<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link href="css/base.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/article_detail.css"/>
<link href="logo.ico" rel="shortcut icon"/>
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--<script type="text/javascript" src="plugin/jquery.page.js"></script>-->
<script src="js/common.js"></script>
<script type="text/javascript" src="js/respond.js"></script>
<script type="text/javascript" src="js/basic.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<!--<script src="js/snowy.js"></script>-->


<body>
	<div class="w_header">
		<div class="container">
			<div class="w_header_top">
<!-- 				<a href="#" class="w_logo"></a>
 -->				<span class="w_header_nav">
					<ul id="star">
						<!-- <li><a href="" class="active">首页</a></li>
						<li><a href="writen.jsp">Writing</a></li>
						<li><a href="collect.html">收藏</a></li>
						<li><a href="attention.html">关注</a></li>
						<li><a href="myself.html">个人</a></li>
						<li><a href="comment.html">论坛</a></li> -->
					</ul>
				</span>
				<div class="w_search">
					<div class="w_searchbox">
						<input type="text" placeholder="search" />
						<button>搜索</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="w_container">
		<div class="container">
			<div class="row w_main_row">
				
				<ol class="breadcrumb w_breadcrumb">
				  <li><a href="#">首页</a></li>
				  <li><a href="#">文章</a></li>
				  <li class="active">我的博客内容</li>
				  <span class="w_navbar_tip">多思者必心累，心重者必心苦</span>
				</ol>
				  
   
				<div class="col-lg-9 col-md-9 w_main_left">
					<div class="panel panel-default">
					<div class="newsview" id="newsview">
						<!-- <div class="panel-body">
							<h2 class="c_titile">我的个人博客之——阿里云空间选择</h2>
							<p class="box_c"><span class="d_time">发布时间：2017-02-05</span><span>编辑：<a href="mailto:wfyv@qq.com">wilco</a></span><span>阅读（88646）</span></p>
							<ul class="infos">
								
								
							</ul>
															
							
							
							 </div> 
							
							<div class="nextinfo">
								<p class="last">上一篇：<a href="#">免费收录网站搜索引擎登录口大全</a></p>
								<p class="next">下一篇：<a href="#">javascript显示年月日时间代码</a></p>
						    </div> -->
							
						</div>
					</div>
					
					 <!-- <div class="panel panel-default">
						<div class="panel-body">
				
							
							
							
							
						
							
						</div>
					</div>  -->
					
				
				
				
				
				
			<div id="comment" style="width:100%; margin: 0px auto; background-color: white; padding:105px 20px 20px 20px;">
			
			<div>
				<img src="images/login_user.jpg" alt="" style="width:40px; height:40px; border:1px solid black; border-radius:50%; float: left;"/>
				<div style="margin-left:50px;">
					<textarea id="iq" style="width:100%; height:90px; padding:10px 10px;" placeholder="想对作者说点什么。。。"></textarea>
					<div style="padding-left:85%; margin-top:10px;">
						<button onclick="toSubmit(${content.id })">发布</button>
						<button onclick="toCancel()">取消</button>
					</div>
				</div>
			</div>
			<hr/>
			<div>
				<h5>全部评论</h5>
				<div style="margin-top:20px;">
					<c:if test="${empty comments }">
						<p>该博客暂无评论。。。</p>
					</c:if>
					<c:if test="${not empty comments }">
						<c:forEach items="${comments }" var="comment" varStatus="status">
							<ul style="list-style:none;padding:16px 0px;border-bottom:1px dashed #e0e0e0;">
								<li>
									<div>
										<img src="images/login_user.jpg" alt="" style="width:40px; height:40px; border:1px solid black; border-radius:50%;"/>
										<span style="margin-left:20px;">${comment.uname }</span>
										<span style="padding-left:50px;color:#999;">${comment.date }</span>
										
										<c:choose>
											<c:when test="${comment.guid == user.id }">
												<i class="iconfont icon-dianzan-yes" style="cursor:pointer;float:right;margin:0px 7px;width:32px;" onclick="pick(2, ${content.id }, ${comment.id }, this, '${empty user }')">${comment.star }</i>
											</c:when>
											<c:otherwise>
												<i class="iconfont icon-dianzan-no" style="cursor:pointer;float:right;margin:0px 7px;width:32px;" onclick="pick(2, ${content.id }, ${comment.id }, this, '${empty user }')">${comment.star }</i>
											</c:otherwise>
										</c:choose>
										<c:if test="${comment.reply_count > 0 }">
											<a href="javascript:void(0)" style="float:right;margin:0px 7px" onclick="showReply(this, ${comment.reply_count })">查看回复(${comment.reply_count })</a>
										</c:if>
										<a href="#comment" style="float:right;margin:0px 7px" onclick="reply('${comment.uname }',${comment.uid },${comment.id })">回复</a>
										
									</div>
									<div style="margin-left:60px;margin-top:10px;">
										${comment.content }
									</div>
								</li>
								<c:if  test="${comment.reply_count > 0 }">
									<li style="display:none">
										<ul style="list-style:none;margin-left:40px;margin-top:10px;border-left:2px solid black;padding-left:10px;">
											<c:forEach items="${comment.replies }" var="reply" varStatus="status">
												<li>
													<div>
														<img src="images/login_user.jpg" alt="" style="width:40px; height:40px; border:1px solid black; border-radius:50%;"/>
														<span style="margin:0px 20px;">${reply.from_uname }</span>
														<span style="color:#999;">回复</span>
														<span style="margin-left:20px;">${reply.to_uname }</span>
														<span style="padding-left:50px;color:#999;">${reply.date }</span>
														
														<c:choose>
															<c:when test="${reply.guid == user.id }">
															<i class="iconfont icon-dianzan-yes" style="cursor:pointer;float:right;margin:0px 7px;width:32px;" onclick="pick(3, ${content.id }, ${reply.id }, this, '${empty user }')">${reply.star }</i>
															</c:when>
															<c:otherwise>
															<i class="iconfont icon-dianzan-no" style="cursor:pointer;float:right;margin:0px 7px;width:32px;" onclick="pick(3, ${content.id }, ${reply.id }, this, '${empty user }')">${reply.star }</i>
															</c:otherwise>
														</c:choose>
														<a href="#comment" style="float:right;margin:0px 7px;" onclick="reply('${reply.from_uname }', ${reply.from_uid }, ${reply.comment_id })">回复</a>
														
													</div>
													<div style="margin-left:60px;margin-top:10px;">
														${reply.content }
													</div>
												</li>
											</c:forEach>
										</ul>
									</li>
								</c:if>
							</ul>
						</c:forEach>
					</c:if>

				</div>
			</div>
			
					
					
					
				</div>
				</div>
				
				<div class="col-lg-3 col-md-3 w_main_right">
					
					<div class="panel panel-default">
					  <div class="panel-heading">
					    <h3 class="panel-title">最新发布</h3>
					  </div>
					  <div class="panel-body">
					    	<ul class="list-unstyled sidebar">				
								<li><a href="/post/04928311">排序算法之冒泡排序 － java实现</a></li>
								<li><a href="/post/32097759">快速搭建基于二进制日志文件的 mysql 复制</a></li>							
								<li><a href="/post/09196557">web 服务器负载均衡教程，快速搭建高可用服务器集群</a></li>							
								<li><a href="/post/20654391">使用 redis 和 spring-session 实现 tomcat、glassfish 等 web 服务器集群 session 共享</a></li>							
								<li><a href="/post/41501569">使用 Nginx 实现 tomcat、glassfish 等 web 服务器负载均衡</a></li>							
								<li><a href="/post/89658700">mysql 复制（replication）基础概念和应用场景简介</a></li>							
								<li><a href="/post/03088922">redis 单节点在 Linux 生产环境的安装和简单配置</a></li>							
								<li><a href="/post/05203355">使用 jQuery 的 val() 方法来获取以及设置表单元素值</a></li>							
								<li><a href="/post/03120718">使用 jQuery 的 removeProp() 方法来删除元素的特性（property）</a></li>							
								<li><a href="/post/37454977">使用 jQuery 的 prop() 方法来获取以及设置元素的特性（property）</a></li>							
						</ul>
					  </div>
					</div>
					
					<div class="panel panel-default">
					  <div class="panel-heading">
					    <h3 class="panel-title">友情链接</h3>
					  </div>
					  <div class="panel-body">
					    <div class="newContent">
					    	<ul class="list-unstyled sidebar shiplink">				
								<li><a href="https://www.baidu.com/" target="_blank">百度</a></li>
								<li><a href="https://www.oschina.net/" target="_blank">开源中国</a></li>							
								<li><a href="http://www.ulewo.com/" target="_blank">有乐网</a></li>							
								<li><a href="http://www.sina.com.cn/" target="_blank">新浪网</a></li>							
								<li><a href="http://www.qq.com/" target="_blank">腾讯网</a></li>							
							</ul>
					    </div>
					  </div>
					</div>
				</div>
			 
			
			
			
			
			
			
		</div>
	</div>
	<div class="w_foot">
		<!--<div class="w_foot_copyright">© 2015~2016 版权所有 | <a target="_blank" href="http://www.miitbeian.gov.cn/" rel="nofollow">京ICP备15010892号-1</a></div>-->
		<div class="w_foot_copyright">Copyright © 2017-2020, www.wfyvv.com. All Rights Reserved. </div>
	</div>
	<!--toTop-->
	<div id="shape">
		<div class="shapeColor">
			<div class="shapeFly">
			</div>
		</div>
	</div>
	<!--snow-->
	<!--<div class="snow-container"></div>-->
</body>
</html>