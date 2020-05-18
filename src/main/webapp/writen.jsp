<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"  isELIgnored="false" %>
<!DOCTYPE html >
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>松筠-柏寒</title>
</head>

<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/about.css"/>
<link href="css/base.css" rel="stylesheet">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/main.css">
<link href="logo.ico" rel="shortcut icon"/>
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="plugin/jquery.page.js"></script>
<script type="text/javascript" src="js/showpic.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/allInfo.js"></script>
<script type="text/javascript" src="js/comm.js"></script>
<script src="js/piccontent.min.js" type="text/javascript"></script>
<script src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="js/basic.js"></script>


<script src="js/common.js"></script>
<script type="text/javascript">
var tno;
$(function(){
	$.getJSON("type/findAll", null, function(data){
		var str = "";
		$.each(data, function(index, item) {
			str += "<option value='" + item.type + "'>" + item.typename+ "</option>";
		});
		
		$("#typeinfo").append($(str));
	});
	
	tno=$("#my_id").val();
	
});
</script>
<style type="text/css">
table.gridtable {
font-family: verdana,arial,sans-serif;
font-size:11px;
color:#333333;
border-width: 1px;
border-color: #666666;
border-collapse: collapse;
}
table.gridtable th {
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #666666;
background-color: #dedede;
}
table.gridtable td {
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #666666;
background-color: #ffffff;
}
</style>

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
				  <li class="active">关于我</li>
				  <span class="w_navbar_tip">人生当苦无妨，良人当归即好</span>
				</ol>
				
				<article>
	<div class="box_center">
				<form action="" class="jqtransform" id="addGoodsForm">
					<table class="gridtable">
						<tr>
							<td class="td_right">博客类型：</td>
							<td>
								<select class="select" name="type" id="typeinfo">
									
								</select>
							</td>
							
							<td class="td_right">作者：</td>
							<td>
								 <input readonly type="text" id="userid" name="userid" value="${loginUser.username}"  class="input-text lh30" size="20">
								 <input type="hidden" id="my_id" value="${loginUser.userid}">
							</td>
						
							
						</tr>
						<tr>
							<!-- <td class="td_right">原创：</td>
							<td>
								<select id="original">
									<option value="" selected>是</option>
									<option value="">否</option>
								</select>
							</td> -->
							
							<td class="td_right">标签：</td>
							<td>
								<input type="text" id="label" name="label" class="input-text lh30" size="40" placeholder="标签"/>
							</td>
						</tr>
						<tr>
							
							<td class="td_right">博客插图图片：</td>
							<td>
								<input type="file" id="pics" name="pic" class="input-text lh30" size="40" multiple="multiple" onchange="setImagePreviews(this,'showPics')">
							</td>
							<td class="td_right">日期：</td>
							<td>
								<input type="date" id="editordate" name="editordate" class="input-text lh30" size="40"  placeholder="编辑日期"/>
							</td>
							
						</tr>
						
						
						<tr>
							<td>&nbsp;</td>
							<td colspan="5" align="center">
								<div id="showPics">
								</div>
							</td>
						</tr>
						<tr>
							<td class="td_right">博客标题：</td>
							<td colspan="5">
								 <textarea name="title" id="title" rows="3" cols="100"></textarea>
							</td>
						</tr>
						<tr>
							<td class="td_right">博客正文：</td>
							<td colspan="5">
								 <textarea name="editor1" id="editor1" rows="10" cols="80"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<input type="button" name="button" class="btn btn82 btn_save2" onclick="addBlogInfo()" value="发表">
								
							</td>
						</tr>
					</table>
				</form>
			</div>
  
  <div class="blank"></div>
</article>
				<!--<div class="col-lg-3 col-md-3 w_main_right">
					<div class="about_c">
					    <p>昵称：<span>wilco</span> | 即步非烟</p>
					    <p>姓名：王风宇 </p>
					    <p>生日：1991-03-07</p>
					    <p>邮箱：wfyv@qq.com</p>
					    <p>籍贯：安徽省—六安市</p>
					    <p>现居：合肥市—蜀山区</p>
					    <p>职业：JavaWeb开发</p>
					</div>
				</div>-->
			
			
			</div>
		</div>
	</div>
	<div class="w_foot">
		<!--<div class="w_foot_copyright">© 2015~2016 版权所有 | <a target="_blank" href="http://www.miitbeian.gov.cn/" rel="nofollow">京ICP备15010892号-1</a></div>-->
		<div class="w_foot_copyright">Copyright © 2017-2020, www.wfyvv.com. All Rights Reserved. </div>
	</div>
	<!--toTop-->
	<!-- <div id="shape">
		<div class="shapeColor">
			<div class="shapeFly">
			</div>
		</div>
	</div> -->
	<a href="#" class="cd-top">Top</a>
	
	<!--snow-->
	<!--<div class="snow-container"></div>-->
	<script type="text/javascript">
	CKEDITOR.replace( 'editor1' );
	function addBlogInfo() {
		var type = $.trim($("#typeinfo").val());
		var title = $.trim($("#title").val());
		var original = $.trim($("#original option:selected").text());
		var label = $.trim($("#label").val());
		var editordate = $.trim($("#editordate").val());
		var userid = $.trim($("#my_id").val());
		var content = $.trim(CKEDITOR.instances.editor1.getData());
		$.ajaxFileUpload({
			url:'blog/addblog',
			secureuri: false,
			fileElementId:"pics",
			dataType:"json",
			data:{userid:userid,editordate:editordate,title:title,label:label,content:content,original:original,type:type},
			success:function(data, status) {
				data = parseInt($.trim(data));
				if (data == 1) {
					$("#addGoodsForm")[0].reset();
					$("#showPics").html("");
					CKEDITOR.instances.editor1.setData("");
					alert("博客发表成功...");
				} else {
					alert("博客发表失败...");
				}
			},
			error:function(data, status, e) {
				alert("博客发表失败，请稍后重试...\n" + e);
			}
		});
		
	}
	</script>
	<a href="#" class="cd-top">Top</a>
</body>
</html>
