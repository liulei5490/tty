<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html >
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>松筠柏寒个人博客</title>


<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css"/>

<link href="logo.ico" rel="shortcut icon"/>
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="plugin/jquery.page.js"></script>
<script src="js/common.js"></script>
<script type="text/javascript" src="js/basic.js"></script>

<!--<script src="js/snowy.js"></script>-->

<style type="text/css">
.cont{
    border:1px solid #000;
    margin-top:50px;
    border-style: outset;
    }
.cont button{
      height: 30px;
      margin-top: 10px;
      margin-left: 325px;

}

.cont-group input{
      width: 100%;
      height: 30px;
}

.cont-group{
      margin-top: 10px;
}

table.altrowstable {
font-family: verdana,arial,sans-serif;
font-size:13px;
color:#333333;
border-width: 2px;
border-color: #a9c6c9;
border-collapse: collapse;
}

table.altrowstable th {
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #a9c6c9;
}

table.altrowstable td {
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #a9c6c9;
}
.oddrowcolor{
background-color:#d4e3e5;
}
.evenrowcolor{
background-color:#c3dde0;
}
    
    
</style>

<script type="text/javascript">
$(function() {
	$.post("userInfo/findAll", null, function(data) {
		console.log(data);
		if(data != null){
			$("#username").val(data.username);
			$("#userpass").val(data.username);
			$("#realname").val(data.realname);
			$("#birthday").val(data.birthday);
			$("#sex").val(data.sex);
			$("#contackway").val(data.contackway);
			$("#work").val(data.work);
			$("#email").val(data.email);
		}else{
			alert("您尚未登陆，请先登录!!!!");
			location.herf='login.html';
		}
	}, "json");
})
function update(){
    var username =$.trim($("#username").val());
    var userpass =$.trim($("#userpass").val());
	var realName =$.trim($("#realname").val());
	var birthday =$.trim($("#birthday").val());
	var sex =$.trim($("#sex").val());
	var contackway =$.trim($("#contackway").val());
	var work =$.trim($("#work").val());
	var email =$.trim($("#email").val());
	$.post("userInfo/update",{username:username,userpass:userpass,realname:realName,birthday:birthday,sex:sex,contackway:contackway,work:work,email:email},function(data){
		console.info(data);
		if(data > 0){
			alert("修改成功，请重新登录...");
			location.href = 'login.html';
		}else{
			alert("修改失败...");
		}
	},"json");
}

</script>
</head>


<body>
	<div class="w_header">
		<div class="container">
			<div class="w_header_top">
<!-- 				<a href="#" class="w_logo"></a>
 -->				<!--<span class="w_slogan">百度一下,你就知道</span>-->
				<span class="w_header_nav">
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
				  <li class="active">评论</li>
				  <span class="w_navbar_tip">你，生命中最重要的过客，之所以是过客，因为你未曾为我停留。</span>
				</ol>
				
				<div class="col-lg-9 col-md-9 w_main_left">
					
					
			<div class="cont" id="cont">
				
				<form action="" class="jqtransform" id="addGoodsForm">
					<table  class="altrowstable" id="alternatecolor" >
						<tr>
							<th>用户个人信息</th>
							
						</tr>
						<tr >
							<td class="td_right" style="background-color: #FF6633;">用户名:</td>
							<td>
							<input type="text" id="username" name="username" class="input-text lh30" size="40" placeholder="用户名"/>
							</td>
							
							<td class="td_right" style="background-color: #FF6633;">密码：</td>
							<td>
								 <input readonly type="text" id="userpass" name="userpass"   class="input-text lh30" size="40">
			
							</td>
						
							
						</tr>
						
						
						
						<tr>
							<td class="td_right" style="background-color:#66CC99;">QQ号：</td>
							<td>
								<input readonly type="text" id="realname" name="realname"   class="input-text lh30" size="40">
							</td>
							
							<td class="td_right" style="background-color: #51C1AC;">出生日期：</td>
							<td>
								<input type="text" id="birthday" name="birthday" class="input-text lh30" size="40" placeholder="生日"/>
							</td>
						</tr>
						
						
						<tr >
							<td class="td_right"  style="background-color: #51C15D;">性别：</td>
							<td>
                                <input type="text" id="sex" name="sex" class="input-text lh30" size="40" placeholder="性别"/>							
							</td>
							
							<td class="td_right" style="background-color: #C15190;">联系方式：</td>
							<td>
								<input type="text" id="contackway" name="contackway" class="input-text lh30" size="40" placeholder="联系方式"/>
							</td>
						</tr>
						
						<tr>
							<td class="td_right" style="background-color: #CC4545;">工作：</td>
							<td>
								<input type="text" id="work" name="work" class="input-text lh30" size="40" placeholder="工作"/>
								
							</td>
							
							<td class="td_right" style="background-color: #DF8D24;">邮箱：</td>
							<td>
								<input type="text" id="email" name="email" class="input-text lh30" size="40" placeholder="邮箱"/>
							</td>
						</tr>
						
						
		
						<tr>
							<td colspan="4" align="center">
								<button type="submit" class="btn btn-default" onclick="update()" >修改信息</button>
								
							</td>
						</tr>
					</table>
				</form>
			</div>
					
					
					
				
						
					<!-- 多说公共JS代码 end -->

					
					
				</div>
				<div class="col-lg-3 col-md-3 w_main_right">
					<img src="img/slider/geren.jpg" />
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
<script type="text/javascript">
function altRows(id){
	if(document.getElementsByTagName){  
	var table = document.getElementById(id);  
	var rows = table.getElementsByTagName("tr"); 
	 
	for(i = 0; i < rows.length; i++){          
	if(i % 2 == 0){
	rows[i].className = "evenrowcolor";
	}else{
	rows[i].className = "oddrowcolor";
	}      
	}
	}
	}

	window.οnlοad=function(){
	altRows('alternatecolor');
	}
</script>
</html>